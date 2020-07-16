package com.yao.sys.service;

import com.yao.bean.bean.LoginBean;
import com.yao.bean.db.AgencyPojo;
import com.yao.bean.db.SysPojo;
import com.yao.common.util.DateUtil;
import com.yao.common.util.JwtUtil;
import com.yao.common.util.MD5Util;
import com.yao.bean.LoginInfo;
import com.yao.sys.dao.AgencyDao;
import com.yao.sys.dao.SysDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.TreeMap;

/**
 * @author : 妖妖
 * @date : 17:40 2020/7/13
 */
@Service
@Transactional
@Slf4j
public class LoginService {

    @Autowired
    private SysDao sysDao;
    @Autowired
    private AgencyDao agencyDao;
    @Autowired
    private JwtUtil jwtUtil;

    public LoginInfo login(LoginBean loginBean) throws Exception {
        LoginInfo info = new LoginInfo();

        SysPojo sysPojo = sysDao.getRecordByWhere(new SysPojo().setMobileNo(loginBean.getMobileNo()));
        if (sysPojo == null){
            throw new Exception("用户不存在！");
        }
        String password = MD5Util.getMD5Str(loginBean.getPassword());
        if (!password.equals(sysPojo.getPassword())){
            throw new Exception("密码错误！");
        }
        if (!"1".equals(sysPojo.getState())){
            throw new Exception("账号异常请联系管理员");
        }
        AgencyPojo agency = agencyDao.getRecordByKey(new AgencyPojo().setId(sysPojo.getAgencyId()));
        if (!"1".equals(agency.getState())){
            throw new Exception("服务商异常请联系管理员");
        }
        //更新登入记录
        sysDao.updateRecordByKey(new SysPojo().setId(sysPojo.getId()).setLastDate(new Date()).setLastLoginIp(loginBean.getIp()));
        info.setId(sysPojo.getId());
        info.setNickname(sysPojo.getNickname());
        info.setMobileNo(sysPojo.getMobileNo());
        info.setAgencyId(sysPojo.getAgencyId());
        info.setLoginDate(new Date());
        info.setDefaults(sysPojo.getDefaults());
        info.setIp(loginBean.getIp());
        TreeMap dataMap = new TreeMap();
        dataMap.put("id",info.getId());
        dataMap.put("ip",loginBean.getIp());
        dataMap.put("date", DateUtil.getyyyyMMddHHmmss());
        String token = jwtUtil.createJWT(info.getId(), "",dataMap);
        info.setToken(token);
        return info;
    }
}
