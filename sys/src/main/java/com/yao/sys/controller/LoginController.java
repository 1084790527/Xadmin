package com.yao.sys.controller;

import com.yao.bean.bean.LoginBean;
import com.yao.bean.vo.ResultObj;
import com.yao.common.Consts;
import com.yao.common.util.IpAddress;
import com.yao.bean.LoginInfo;
import com.yao.sys.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author : 妖妖
 * @date : 16:33 2020/7/13
 */
@RestController
@RequestMapping(value = "/login")
//@Slf4j
public class LoginController {

    private static Log log = LogFactory.getLog(LoginController.class);
    @Autowired
    private LoginService loginService;

    @PostMapping
    public ResultObj login(HttpServletRequest request,HttpSession session, LoginBean loginBean){
        ResultObj resultObj = new ResultObj();
        try {
            loginBean.setIp(IpAddress.getIpAddress(request));
            LoginInfo loginInfo = loginService.login(loginBean);
            session.setAttribute(Consts.LOGIN_INFO,loginInfo);
            resultObj.setState(true);
        }catch (Exception e){
            log.error("登入异常",e);
            resultObj.setState(false);
            resultObj.setMsg(e.getMessage());
        }
        return resultObj;
    }
}
