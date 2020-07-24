package com.yao.sys.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yao.bean.LoginInfo;
import com.yao.bean.db.RolePojo;
import com.yao.bean.db.SysPojo;
import com.yao.bean.db.SysRolePojo;
import com.yao.bean.model.*;
import com.yao.common.Consts;
import com.yao.common.util.DateUtil;
import com.yao.common.util.IdWorker;
import com.yao.common.util.RangeDateUtil;
import com.yao.sys.dao.RoleDao;
import com.yao.sys.dao.SysDao;
import com.yao.sys.dao.SysRoleDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author : 妖妖
 * @date : 10:05 2020/7/17
 */
@Service
@Transactional
@Slf4j
public class ManagerService {

    @Autowired
    private SysDao sysDao;
    @Autowired
    private HttpSession httpSession;
    @Autowired
    private IdWorker idWorker;
    @Autowired
    private SysRoleDao sysRoleDao;
    @Autowired
    private RoleDao roleDao;

    public TableModel obtainSys(ManagerTab managerTab) {
        TableModel table = new TableModel();

        LoginInfo info = (LoginInfo) httpSession.getAttribute(Consts.LOGIN_INFO);
        SysPojo search = new SysPojo();
        if (managerTab.getState()==null){
            search.setInState("1,0");
        }else {
            search.setState(managerTab.getState());
        }
        RangeDateUtil util = new RangeDateUtil(managerTab.getRegDate());
        search.setStartRegDate(util.getStartDate());
        search.setEndRegDate(util.getEndDate());
        PageHelper.orderBy(" id desc ");
        Page<SysPojo> page = PageHelper.startPage(managerTab.getPage(),managerTab.getLimit() ,true);
        sysDao.getRecordListByWhere(search.setDefaults("0").setSex(managerTab.getSex()).setNickname(managerTab.getNickname())
                .setMobileNo(managerTab.getMobileNo()).setRealName(managerTab.getRealName()).setAgencyId(info.getAgencyId()));
        table.setCount(page.getTotal());
        List<SysModel> s = new ArrayList<>();
        for (SysPojo p : page.getResult()){
            SysPojo last = sysDao.getRecordByKey(new SysPojo().setId(p.getLastModOperId()));
            SysModel sysModel = new SysModel();

            sysModel.setId(p.getId());
            sysModel.setNickname(p.getNickname());
            sysModel.setMobileNo(p.getMobileNo());
            sysModel.setRealName(p.getRealName());
            sysModel.setSex(p.getSex());
            sysModel.setBirthday(DateUtil.getyyyy_MM_dd(p.getBirthday()));
            sysModel.setRegDate(DateUtil.getyyyy_MM_ddHHmmss(p.getRegDate()));
            sysModel.setUpdateDate(DateUtil.getyyyy_MM_ddHHmmss(p.getUpdateDate()));
            sysModel.setLastDate(DateUtil.getyyyy_MM_ddHHmmss(p.getLastDate()));
            sysModel.setLastModOperId(p.getLastModOperId());
            if (last != null) sysModel.setLastModOperName(last.getNickname());
            sysModel.setLastModOperDate(DateUtil.getyyyy_MM_ddHHmmss(p.getLastModOperDate()));
            sysModel.setState(p.getState());

            s.add(sysModel);
        }
        table.setData(s);
        return table;
    }

    public void addManager(ManagerModel manager) throws Exception {
        LoginInfo info = (LoginInfo) httpSession.getAttribute(Consts.LOGIN_INFO);
        Date regDate = new Date();
        String sysId = idWorker.nextId();
        SysPojo sys = new SysPojo();
        sys.setId(sysId);
        sys.setNickname(manager.getNickname());
        sys.setMobileNo(manager.getMobileNo());
        sys.setRealName(manager.getRealName());
        sys.setSex(manager.getSex());
        sys.setPassword(DigestUtils.md5DigestAsHex(manager.getPassword().getBytes()));
        sys.setBirthday(DateUtil.str2Date(manager.getBirthday(), DateUtil.date_sdf));
        sys.setRegDate(regDate);
        sys.setState("1");
        sys.setAgencyId(info.getAgencyId());
        sys.setDefaults("0");
        sysDao.insertRecord(sys);
        if (manager.getPriIds() == null || manager.getPriIds().length == 0)
            throw new Exception("必须分配角色");
        for (String roleId:manager.getPriIds()){
            SysRolePojo role = new SysRolePojo();
            role.setRoleId(roleId);
            role.setUserId(sysId);
            role.setState("1");
            role.setCreOperId(info.getId());
            role.setCreDate(regDate);
            sysRoleDao.insertRecord(role);
        }
    }
    public void modifyManager(ManagerModel manager) throws Exception {
        LoginInfo info = (LoginInfo) httpSession.getAttribute(Consts.LOGIN_INFO);
        String lastId = info.getId();
        Date lastData = new Date();
        SysPojo sysData = sysDao.getRecordByKey(new SysPojo().setId(manager.getId()));
        if (sysData == null || (!sysData.getAgencyId().equals(info.getAgencyId()))){
            throw new Exception("数据异常");
        }
        SysPojo sys = new SysPojo();
        sys.setId(manager.getId());
        sys.setNickname(manager.getNickname());
        sys.setMobileNo(manager.getMobileNo());
        sys.setRealName(manager.getRealName());
        sys.setSex(manager.getSex());
        sys.setBirthday(DateUtil.str2Date(manager.getBirthday(), DateUtil.date_sdf));
        sysDao.updateRecordByKey(sys);
        if (manager.getPriIds() == null || manager.getPriIds().length == 0)
            throw new Exception("必须分配角色");
        //删除所有这个人的权限
        sysRoleDao.deleteRecordByKey(new SysRolePojo().setUserId(manager.getId()));
        for (String roleId:manager.getPriIds()){
            SysRolePojo role = new SysRolePojo();
            role.setRoleId(roleId);
            role.setUserId(manager.getId());
            role.setState("1");
            role.setLastModOperDate(lastData);
            role.setLastModOperId(lastId);
            sysRoleDao.insertRecord(role);
        }
    }

    public void resetPassword(SysModel sys) throws Exception {
        LoginInfo info = (LoginInfo) httpSession.getAttribute(Consts.LOGIN_INFO);
        SysPojo sysData = sysDao.getRecordByWhere(new SysPojo().setId(sys.getId()).setAgencyId(info.getAgencyId()).setDefaults("0"));
        if (sysData == null)
            throw new Exception("操作异常");
        sysDao.updateRecordByKey(new SysPojo().setId(sys.getId()).setPassword(DigestUtils.md5DigestAsHex("qaz123".getBytes())).setLastModOperId(info.getId()).setLastModOperDate(new Date()));
    }

    public void upStateManager(SysModel sys, String state) throws Exception {
        LoginInfo info = (LoginInfo) httpSession.getAttribute(Consts.LOGIN_INFO);
        SysPojo sysData = sysDao.getRecordByKey(new SysPojo().setId(sys.getId()));
        String lastId = info.getId();
        Date lastDate = new Date();
        if (sysData == null)
            throw new Exception("操作异常");
        if (!info.getAgencyId().equals(sysData.getAgencyId()))
            throw new Exception("操作异常");
        sysDao.updateRecordByKey(new SysPojo().setId(sys.getId()).setState(state).setLastModOperDate(lastDate).setLastModOperId(lastId));
        if (state.equals(Consts.MANAGER_STATE_DELETE))
            sysRoleDao.deleteRecordByKey(new SysRolePojo().setUserId(sys.getId()));
        else
            sysRoleDao.updateRecordByKey(new SysRolePojo().setUserId(sys.getId()).setState(state).setLastModOperDate(lastDate).setLastModOperId(lastId));
    }

    public ManModify getModify(String id) {
        LoginInfo info = (LoginInfo) httpSession.getAttribute(Consts.LOGIN_INFO);
        ManModify modify = new ManModify();
        SysPojo sysData = sysDao.getRecordByKey(new SysPojo().setId(id));
        modify.setId(sysData.getId());
        modify.setNickname(sysData.getNickname());
        modify.setMobileNo(sysData.getMobileNo());
        modify.setRealName(sysData.getRealName());
        modify.setProfilePic(sysData.getProfilePic());
        modify.setSex(sysData.getSex());
        modify.setBirthday(DateUtil.getyyyy_MM_dd(sysData.getBirthday()));
        List<ManRoleModify> modifies = new ArrayList<>();
        List<SysRolePojo> have = sysRoleDao.getRecordListByWhere(new SysRolePojo().setUserId(sysData.getId()));
        List<RolePojo> all = roleDao.getRecordListByWhere(new RolePojo().setState("1").setAgencyId(info.getAgencyId()));
        for (RolePojo a : all){
            boolean b = false;
            for (SysRolePojo h : have){
                if (a.getId().equals(h.getRoleId()))
                    b = true;
            }
            if (b){
                modifies.add(new ManRoleModify().setRoleId(a.getId()).setState(true).setName(a.getName()));
            }else {
                modifies.add(new ManRoleModify().setRoleId(a.getId()).setState(false).setName(a.getName()));
            }
        }
        modify.setRoleIds(modifies);
        return modify;
    }


}
