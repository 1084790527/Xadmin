package com.yao.sys.service;

import com.alibaba.fastjson.JSON;
import com.yao.bean.LoginInfo;
import com.yao.bean.db.PrivilegesPojo;
import com.yao.bean.db.RolePrivilegesPojo;
import com.yao.bean.db.SysRolePojo;
import com.yao.common.Consts;
import com.yao.sys.dao.PrivilegesDao;
import com.yao.sys.dao.RolePrivilegesDao;
import com.yao.sys.dao.SysRoleDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author : 妖妖
 * @date : 20:05 2020/7/13
 */
@Service
@Transactional
@Slf4j
public class AuthorityService {

    @Autowired
    private HttpSession session;
    @Autowired
    private SysRoleDao sysRoleDao;
    @Autowired
    private RolePrivilegesDao rolePrivilegesDao;
    @Autowired
    private PrivilegesDao privilegesDao;

    public void SettingRole() {
        for (PrivilegesPojo pojo : obtainPriAuthoritys()){
            session.setAttribute(pojo.getPermission(),pojo.getUrl());
            session.setAttribute(pojo.getPermission()+"_name",pojo.getName());
        }
    }

    public List<PrivilegesPojo> treePriAuthoritys(){
        List<PrivilegesPojo> tree = privilegesDao.treePrivileges(new PrivilegesPojo().setInId(getPrIds()).setState("1").setMenuLevel(0L));
        return tree;
    }

    public List<PrivilegesPojo> obtainPriAuthoritys(){
        List<PrivilegesPojo> pojos = privilegesDao.getRecordListByWhere(new PrivilegesPojo().setInId(getPrIds()).setState("1"));
//        log.info("pojos : "+JSON.toJSONString(pojos));
        return pojos;
    }
    public List<PrivilegesPojo> obtainPriAuthoritys(String roleId){
        List<PrivilegesPojo> pojos = privilegesDao.getRecordListByWhere(new PrivilegesPojo().setInId(getPrIds(roleId)).setState("1"));
        return pojos;
    }

    private String getRoleIds(){
        LoginInfo info = (LoginInfo) session.getAttribute(Consts.LOGIN_INFO);
        List<SysRolePojo> sysRoles = sysRoleDao.getRecordListByWhere(new SysRolePojo().setUserId(info.getId()).setState("1"));
        String rolsIds = "";
        for (int i = 0 ; i < sysRoles.size() ; i++){
            if (i == 0){
                rolsIds = sysRoles.get(i).getRoleId();
            }else {
                rolsIds = rolsIds + "," + sysRoles.get(i).getRoleId();
            }
        }
        return rolsIds;
    }

    private String getPrIds(String roleIds){
        RolePrivilegesPojo pojo = new RolePrivilegesPojo().setState("1");
        if (roleIds == null)
            pojo.setInRoleId(getRoleIds());
        else
            pojo.setRoleId(roleIds);
        List<RolePrivilegesPojo> privileges = rolePrivilegesDao.getRecordListByWhere(pojo);
        String prIds = "";
        for (int i = 0 ; i < privileges.size() ; i++){
            if (i == 0){
                prIds = privileges.get(i).getPrivilegeId();
            }else {
                prIds = prIds + "," + privileges.get(i).getPrivilegeId();
            }
        }
        return prIds;
    }

    private String getPrIds(){
        return getPrIds(null);
    }
}
