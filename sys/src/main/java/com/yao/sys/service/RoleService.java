package com.yao.sys.service;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yao.bean.LoginInfo;
import com.yao.bean.db.RolePojo;
import com.yao.bean.db.RolePrivilegesPojo;
import com.yao.bean.db.SysPojo;
import com.yao.bean.model.RoleModel;
import com.yao.bean.model.RoleTab;
import com.yao.bean.model.TableModel;
import com.yao.common.Consts;
import com.yao.common.util.DateUtil;
import com.yao.common.util.IdWorker;
import com.yao.sys.dao.RoleDao;
import com.yao.sys.dao.RolePrivilegesDao;
import com.yao.sys.dao.SysDao;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author : 妖妖
 * @date : 14:25 2020/7/14
 */
@Service
@Transactional
//@Slf4j
public class RoleService {
    private static Log log = LogFactory.getLog(RoleService.class);

    @Autowired
    private HttpSession httpSession;
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private RolePrivilegesDao rolePrivilegesDao;
    @Autowired
    private SysDao sysDao;
    @Autowired
    private IdWorker idWorker;

    public RolePojo obtainRole(String roleId){
        return roleDao.getRecordByKey(new RolePojo().setId(roleId));
    }

    public TableModel obtainRole(RoleTab roleTab) {
        TableModel data = new TableModel();
        LoginInfo info = (LoginInfo) httpSession.getAttribute(Consts.LOGIN_INFO);
        if (roleTab.getName() == null || roleTab.getName().equals(""))
            roleTab.setName(null);
        String inState = "";
        if (roleTab.getState() == null || roleTab.getState().equals(""))
            inState="1,0";
        else
            inState = roleTab.getState();
        PageHelper.orderBy(" id desc ");
        Page<RolePojo> page = PageHelper.startPage(roleTab.getPage(), roleTab.getLimit(), true);
        roleDao.getRecordListByWhere(new RolePojo().setAgencyId(info.getAgencyId()).setInState(inState).setName(roleTab.getName()));
        data.setCount(page.getTotal());
        List<RoleModel> roleModels = new ArrayList<>();
        for (RolePojo pojo : page.getResult()){
            SysPojo creOpen = sysDao.getRecordByKey(new SysPojo().setId(pojo.getCreOperId()));
            SysPojo lastOpen = sysDao.getRecordByKey(new SysPojo().setId(pojo.getLastModOperId()));
            RoleModel role = new RoleModel();
            role.setId(pojo.getId());
            role.setName(pojo.getName());
            role.setDesc(pojo.getDesc());
            role.setState(pojo.getState());
            role.setLastModOperId(pojo.getLastModOperId());
            role.setLastModOperName(lastOpen == null ? "":lastOpen.getNickname());
            role.setLastModOperDate(DateUtil.getyyyy_MM_ddHHmmss(pojo.getLastModOperDate()));
            role.setCreOperId(pojo.getCreOperId());
            role.setCreOperName(creOpen == null ? "":creOpen.getNickname());
            role.setCreDate(DateUtil.getyyyy_MM_ddHHmmss(pojo.getCreDate()));
            roleModels.add(role);
        }
        data.setData(roleModels);
        return data;
    }

    public void addRole(RoleModel role) throws Exception {
        if (role.getIds() == null || role.getIds().length == 0){
            throw new Exception("角色拥有的权限不能空");
        }
        LoginInfo info = (LoginInfo) httpSession.getAttribute(Consts.LOGIN_INFO);
        String creId = info.getId();
        Date creDate = new Date();
        //1 role 创建对应角色
        String roleId = idWorker.nextId();
        RolePojo pojo = new RolePojo();
        pojo.setId(roleId);
        pojo.setState("1");
        pojo.setName(role.getName());
        pojo.setDesc(role.getDesc());
        pojo.setCreDate(creDate);
        pojo.setCreOperId(creId);
        pojo.setAgencyId(info.getAgencyId());
        roleDao.insertRecord(pojo);
        //2 赋予权限
        for (String priId : role.getIds()){
            RolePrivilegesPojo privilegesPojo = new RolePrivilegesPojo();
            privilegesPojo.setRoleId(roleId);
            privilegesPojo.setPrivilegeId(priId);
            privilegesPojo.setState("1");
            privilegesPojo.setCreDate(creDate);
            privilegesPojo.setCreOperId(creId);
            rolePrivilegesDao.insertRecord(privilegesPojo);
        }
    }

    public void modifyRole(RoleModel role) throws Exception {
        if (role.getIds() == null || role.getIds().length == 0){
            throw new Exception("角色拥有的权限不能空");
        }
        RolePojo roleData = roleDao.getRecordByKey(new RolePojo().setId(role.getId()));
        LoginInfo info = (LoginInfo) httpSession.getAttribute(Consts.LOGIN_INFO);
        String lastId = info.getId();
        Date lastDate = new Date();
        //1 role 创建对应角色
        RolePojo pojo = new RolePojo();
        pojo.setId(role.getId());
        pojo.setState(roleData.getState());
        pojo.setName(role.getName());
        pojo.setDesc(role.getDesc());
        pojo.setLastModOperId(lastId);
        pojo.setLastModOperDate(lastDate);
        pojo.setAgencyId(info.getAgencyId());
        roleDao.updateRecordByKey(pojo);
        //删除所有权限
        rolePrivilegesDao.deleteRecordByKey(new RolePrivilegesPojo().setRoleId(role.getId()));
        //2 赋予权限
        for (String priId : role.getIds()){
            RolePrivilegesPojo privilegesPojo = new RolePrivilegesPojo();
            privilegesPojo.setRoleId(role.getId());
            privilegesPojo.setPrivilegeId(priId);
            privilegesPojo.setState(roleData.getState());
            privilegesPojo.setLastModOperDate(lastDate);
            privilegesPojo.setLastModOperId(lastId);
            rolePrivilegesDao.insertRecord(privilegesPojo);
        }
    }

    public void upStateRole(RoleModel roleModel, String state) throws Exception {
        if (roleModel == null || roleModel.getId() == null || roleModel.getId().equals(""))
            throw new Exception("数据类型错误");
        LoginInfo info = (LoginInfo) httpSession.getAttribute(Consts.LOGIN_INFO);
        RolePojo roleData = roleDao.getRecordByKey(new RolePojo().setId(roleModel.getId()));
        if (!roleData.getAgencyId().equals(roleData.getAgencyId()))
            throw new Exception("操作异常");
        String lastId = info.getId();
        Date lastDate = new Date();
        int row = roleDao.updateRecordByKey(new RolePojo().setId(roleModel.getId()).setState(state).setLastModOperId(lastId).setLastModOperDate(lastDate));
        if (row != 1)
            throw new Exception("更新异常："+row+"行");
        if (state.equals(Consts.ROLE_STATE_DISABLE)||state.equals(Consts.ROLE_STATE_ENABLE)){
            rolePrivilegesDao.updateRecordByKey(new RolePrivilegesPojo().setRoleId(roleData.getId()).setState(state).setLastModOperDate(lastDate).setLastModOperId(lastId));
        }else if (state.equals(Consts.ROLE_STATE_DELETE)){
            rolePrivilegesDao.deleteRecordByKey(new RolePrivilegesPojo().setRoleId(roleData.getId()));
        }else {
            throw new Exception("状态更新异常");
        }
    }

    public List<RoleModel> getEnableRoles() {
        List<RoleModel> roles = new ArrayList<>();
        LoginInfo info = (LoginInfo) httpSession.getAttribute(Consts.LOGIN_INFO);
        List<RolePojo> roleDatas = roleDao.getRecordListByWhere(new RolePojo().setAgencyId(info.getAgencyId()).setState("1"));
        for (RolePojo d : roleDatas){
            RoleModel r = new RoleModel();
            r.setId(d.getId());
            r.setName(d.getName());
            r.setDesc(d.getDesc());
            roles.add(r);
        }
        return roles;
    }
}
