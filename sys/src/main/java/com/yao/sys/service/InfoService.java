package com.yao.sys.service;

import com.yao.bean.LoginInfo;
import com.yao.bean.db.SysPojo;
import com.yao.bean.model.SysModel;
import com.yao.common.Consts;
import com.yao.common.util.DateUtil;
import com.yao.sys.dao.SysDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @author : 妖妖
 * @date : 19:53 2020/8/1
 */
@Service
@Transactional
@Slf4j
public class InfoService {

    @Autowired
    private SysDao sysDao;
    @Autowired
    private HttpSession httpSession;

    public SysModel getiInfo(){
        LoginInfo info = (LoginInfo) httpSession.getAttribute(Consts.LOGIN_INFO);
        SysPojo pojo = sysDao.getRecordByKey(new SysPojo().setId(info.getId()));
        SysModel sysModel = new SysModel();
        sysModel.setMobileNo(pojo.getMobileNo());
        sysModel.setNickname(pojo.getNickname());
        sysModel.setRealName(pojo.getRealName());
        sysModel.setBirthday(DateUtil.getyyyy_MM_dd(pojo.getBirthday()));
        sysModel.setSex(pojo.getSex());
        return sysModel;
    }

    public void upInfo(SysModel model) {
        LoginInfo info = (LoginInfo) httpSession.getAttribute(Consts.LOGIN_INFO);
        SysPojo sys = new SysPojo();
        sys.setId(info.getId());
        sys.setBirthday(DateUtil.str2Date(model.getBirthday(), DateUtil.date_sdf));
        sys.setNickname(model.getNickname());
        sys.setRealName(model.getRealName());
        sys.setSex(model.getSex());
        sys.setUpdateDate(new Date());
        sysDao.updateRecordByKey(sys);
    }

    public void resetpwd(String oldPwd, String newPwd) throws Exception {
        LoginInfo info = (LoginInfo) httpSession.getAttribute(Consts.LOGIN_INFO);
        SysPojo pojo = sysDao.getRecordByKey(new SysPojo().setId(info.getId()));
        if (!DigestUtils.md5DigestAsHex(oldPwd.getBytes()).equals(pojo.getPassword())){
            throw new Exception("旧密码错误！");
        }
        sysDao.updateRecordByKey(new SysPojo().setId(info.getId()).setPassword(DigestUtils.md5DigestAsHex(newPwd.getBytes())).setUpdateDate(new Date()));
    }
}
