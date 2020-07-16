package com.yao.sys.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yao.bean.LoginInfo;
import com.yao.bean.db.AgencyPojo;
import com.yao.bean.db.SysPojo;
import com.yao.bean.db.SysRolePojo;
import com.yao.bean.model.AgencyModel;
import com.yao.bean.model.AgencyRegModel;
import com.yao.bean.model.SysTab;
import com.yao.bean.model.TableModel;
import com.yao.common.Consts;
import com.yao.common.util.DateUtil;
import com.yao.common.util.IdWorker;
import com.yao.common.util.RangeDateUtil;
import com.yao.sys.dao.AgencyDao;
import com.yao.sys.dao.SysDao;
import com.yao.sys.dao.SysRoleDao;
import org.junit.Test;
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
 * @date : 10:52 2020/7/14
 */
@Service
@Transactional
public class MerchantService {
    @Autowired
    private SysDao sysDao;
    @Autowired
    private AgencyDao agencyDao;
    @Autowired
    private IdWorker idWorker;
    @Autowired
    private HttpSession httpSession;
    @Autowired
    private SysRoleDao sysRoleDao;

    public TableModel obtainAgency(SysTab sysTab) {
        TableModel data = new TableModel();
        AgencyPojo search = new AgencyPojo().setId(sysTab.getId()).setMobileNo(sysTab.getMobileNo()).setName(sysTab.getName());
        if (sysTab.getState() == null)
            search.setInState("1,0");
        else
            search.setState(sysTab.getState());
        RangeDateUtil util = new RangeDateUtil(sysTab.getRegDate());
        search.setRegStartDate(util.getStartDate());
        search.setRegEndDate(util.getEndDate());
        PageHelper.orderBy(" id desc ");
        Page<AgencyPojo> page = PageHelper.startPage(sysTab.getPage(),sysTab.getLimit() ,true);
        agencyDao.getRecordListByWhere(search);
        data.setCount(page.getTotal());
        List<AgencyModel> agencys = new ArrayList<>();
        for (AgencyPojo pojo : page.getResult()){
            SysPojo creOper = sysDao.getRecordByKey(new SysPojo().setId(pojo.getCreOperId()));
            SysPojo lastOper = sysDao.getRecordByKey(new SysPojo().setId(pojo.getLastModOperId()));
            AgencyModel agency = new AgencyModel();
            agency.setId(pojo.getId());
            agency.setName(pojo.getName());
            agency.setMobileNo(pojo.getMobileNo());
            agency.setRegDate(DateUtil.getyyyy_MM_ddHHmmss(pojo.getRegDate()));
            agency.setUpdateDate(DateUtil.getyyyy_MM_ddHHmmss(pojo.getUpdateDate()));
            agency.setCreOperId(pojo.getCreOperId());
            agency.setCreOperName(creOper == null ? "":creOper.getNickname());
            agency.setLastModOperId(pojo.getLastModOperId());
            agency.setLastModOperName(lastOper == null ? "" : lastOper.getNickname());
            agency.setLastModOperDate(DateUtil.getyyyy_MM_ddHHmmss(pojo.getLastModOperDate()));
            agency.setState(pojo.getState());
            agency.setCityId(pojo.getCityId());
            agencys.add(agency);
        }
        data.setData(agencys);
        return data;
    }

    public void addMerchant(AgencyRegModel agencyReg) throws Exception {
        if (agencyReg.getPriIds() == null || agencyReg.getPriIds().length == 0)
            throw new Exception("属于角色不能空");
        //验证手机号是否已注册
        if (sysDao.getRecordByWhere(new SysPojo().setMobileNo(agencyReg.getMobileNo())) != null || agencyDao.getRecordByWhere(new AgencyPojo().setMobileNo(agencyReg.getMobileNo())) != null)
            throw new Exception("手机号已存在");
        LoginInfo info = (LoginInfo) httpSession.getAttribute(Consts.LOGIN_INFO);
        String creId = info.getId();
        Date creDate = new Date();
        String agencyId = idWorker.nextId();
        String sysId = idWorker.nextId();

        AgencyPojo agency = new AgencyPojo();
        agency.setId(agencyId);
        agency.setName(agencyReg.getName());
        agency.setMobileNo(agencyReg.getMobileNo());
        agency.setRegDate(creDate);
        agency.setCreOperId(creId);
        agency.setState("1");
        if (agencyDao.insertRecord(agency) != 1)
            throw new Exception("新建异常");
        SysPojo sys = new SysPojo();
        sys.setId(sysId);
        sys.setNickname(agencyReg.getNikename());
        sys.setMobileNo(agencyReg.getMobileNo());
        sys.setRealName(agencyReg.getRealName());
        sys.setSex(agencyReg.getSex());
        sys.setPassword(DigestUtils.md5DigestAsHex(agencyReg.getPassword().getBytes()));
        sys.setRegDate(creDate);
        sys.setState("1");
        sys.setDefaults("1");
        sys.setAgencyId(agencyId);
        if (sysDao.insertRecord(sys) != 1)
            throw new Exception("新建异常");

        for (String roleId : agencyReg.getPriIds()){
            SysRolePojo rolePojo = new SysRolePojo();
            rolePojo.setUserId(sysId);
            rolePojo.setRoleId(roleId);
            rolePojo.setState("1");
            rolePojo.setCreDate(creDate);
            rolePojo.setCreOperId(creId);
            sysRoleDao.insertRecord(rolePojo);
        }
    }

    public void upStateAgency(AgencyModel agencyModel, String state) throws Exception {
        AgencyPojo agencyData = agencyDao.getRecordByKey(new AgencyPojo().setId(agencyModel.getId()));
        if (agencyData == null)
            throw new Exception("操作异常");
        LoginInfo info = (LoginInfo) httpSession.getAttribute(Consts.LOGIN_INFO);
        String lastId = info.getId();
        Date lastDate = new Date();
        //1 这个商户改状态 不改该商户下面的管理员（避免bug）
        agencyDao.updateRecordByKey(new AgencyPojo().setId(agencyData.getId()).setState(state).setLastModOperId(lastId).setLastModOperDate(lastDate));

    }

    public void resetPassword(AgencyRegModel agencyRegModel) throws Exception {
        SysPojo sysData = sysDao.getRecordByWhere(new SysPojo().setAgencyId(agencyRegModel.getId()).setDefaults("1"));
        if (sysData == null)
            throw new Exception("异常操作");
        LoginInfo info = (LoginInfo) httpSession.getAttribute(Consts.LOGIN_INFO);
        sysDao.updateRecordByKey(new SysPojo().setId(sysData.getId()).setPassword(DigestUtils.md5DigestAsHex("qaz123".getBytes())).setLastModOperDate(new Date()).setLastModOperId(info.getId()));
    }
}
