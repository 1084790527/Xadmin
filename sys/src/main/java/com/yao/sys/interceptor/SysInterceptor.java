package com.yao.sys.interceptor;

import com.alibaba.fastjson.JSON;
import com.yao.bean.LoginInfo;
import com.yao.bean.db.PrivilegesPojo;
import com.yao.common.Consts;
import com.yao.common.util.JwtUtil;
import com.yao.sys.service.AuthorityService;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : 妖妖
 * @date : 15:05 2020/7/9
 */
@Component
//@Slf4j
public class SysInterceptor implements HandlerInterceptor {

    private static Log log = LogFactory.getLog(SysInterceptor.class);
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthorityService authorityService;
    @Value("${interceptor.noVerify}")
    private List<String> noVerify;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info(request.getServletPath()+"   "+request.getMethod());
        HttpSession session = request.getSession();
        String path = request.getServletPath();
        try {
            Object o = session.getAttribute(Consts.LOGIN_INFO);
            if (o == null){
                response.sendRedirect(request.getScheme()+"://"+request.getServerName()+request.getContextPath()+"/login");
                return false;
            }
            LoginInfo info = (LoginInfo) o;
            Claims claims = jwtUtil.parseJWT(info.getToken());
            if (claims == null || !claims.getId().equals(info.getId())){
                response.sendRedirect(request.getScheme()+"://"+request.getServerName()+"/"+request.getContextPath()+"/login");
                return false;
            }
            if (noVerify.contains(path)){
                return true;
            }
            //验证是否有这个权限
            Boolean authority = false;
            List<PrivilegesPojo> privilegesPojos = authorityService.obtainPriAuthoritys();
            for (PrivilegesPojo pojo : privilegesPojos){
                if (path.equals(pojo.getUrl()))
                    authority = true;
            }
            if (authority)
                return true;
            response.sendRedirect(request.getScheme()+"://"+request.getServerName()+request.getContextPath()+"/error/404");
            return false;
        }catch (Exception e){
            log.error("拦截器异常："+e);
            response.sendRedirect(request.getScheme()+"://"+request.getServerName()+"/"+request.getContextPath()+"/login");
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        log.info("postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        log.info("afterCompletion");
    }
}
