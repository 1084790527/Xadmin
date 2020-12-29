package com.yao.sys.controller;

import com.alibaba.fastjson.JSON;
import com.yao.bean.model.ManagerModel;
import com.yao.bean.model.ManagerTab;
import com.yao.bean.model.SysModel;
import com.yao.bean.model.TableModel;
import com.yao.bean.vo.ResultObj;
import com.yao.common.Consts;
import com.yao.sys.service.ManagerService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 管理员管理
 * @author : 妖妖
 * @date : 10:01 2020/7/17
 */
@RequestMapping(value = "/manager")
@RestController
//@Slf4j
public class ManagerContrller {

    private static Log log = LogFactory.getLog(ManagerContrller.class);
    @Autowired
    private ManagerService managerService;

    @PostMapping(value = "index")
    public TableModel index(ManagerTab managerTab){
        TableModel model = managerService.obtainSys(managerTab);
        return model;
    }

    @PostMapping(value = "add")
    public ResultObj add(ManagerModel managerModel){
        ResultObj resultObj = new ResultObj();
        try {
            managerService.addManager(managerModel);
            resultObj.setState(true);
            resultObj.setMsg("添加成功");
        }catch (Exception e){
            log.error("添加管理员错误",e);
            resultObj.setState(false);
            resultObj.setMsg(e.getMessage());
        }
        return resultObj;
    }
    @PostMapping(value = "modify")
    public ResultObj modify(ManagerModel managerModel){
        ResultObj resultObj = new ResultObj();
        try {
            managerService.modifyManager(managerModel);
            resultObj.setState(true);
            resultObj.setMsg("修改成功");
        }catch (Exception e){
            log.error("修改管理员错误",e);
            resultObj.setState(false);
            resultObj.setMsg(e.getMessage());
        }
        return resultObj;
    }
    @PostMapping(value = "password")
    public ResultObj password(SysModel sys){
        log.info("sys : "+JSON.toJSONString(sys));
        ResultObj resultObj = new ResultObj();
        try {
            managerService.resetPassword(sys);
            resultObj.setState(true);
            resultObj.setMsg("密码修改成功");
        }catch (Exception e){
            log.error("密码修改成功错误",e);
            resultObj.setState(false);
            resultObj.setMsg(e.getMessage());
        }
        return resultObj;
    }
    @PostMapping(value = "disable")
    public ResultObj disable(SysModel sys){
        ResultObj resultObj = new ResultObj();
        try {
            managerService.upStateManager(sys, Consts.AGENCY_STATE_DISABLE);
            resultObj.setState(true);
            resultObj.setMsg("停用成功");
        }catch (Exception e){
            log.error("停用管理员错误",e);
            resultObj.setState(false);
            resultObj.setMsg(e.getMessage());
        }
        return resultObj;
    }
    @PostMapping(value = "enable")
    public ResultObj enable(SysModel sys){
        ResultObj resultObj = new ResultObj();
        try {
            managerService.upStateManager(sys, Consts.AGENCY_STATE_ENABLE);
            resultObj.setState(true);
            resultObj.setMsg("启用成功");
        }catch (Exception e){
            log.error("启用管理员错误",e);
            resultObj.setState(false);
            resultObj.setMsg(e.getMessage());
        }
        return resultObj;
    }
    @PostMapping(value = "delete")
    public ResultObj delete(SysModel sys){
        ResultObj resultObj = new ResultObj();
        try {
            managerService.upStateManager(sys, Consts.AGENCY_STATE_DELETE);
            resultObj.setState(true);
            resultObj.setMsg("删除成功");
        }catch (Exception e){
            log.error("删除管理员错误",e);
            resultObj.setState(false);
            resultObj.setMsg(e.getMessage());
        }
        return resultObj;
    }

}
