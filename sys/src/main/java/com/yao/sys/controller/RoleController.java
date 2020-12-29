package com.yao.sys.controller;

import com.alibaba.fastjson.JSON;
import com.yao.bean.model.RoleModel;
import com.yao.bean.model.RoleTab;
import com.yao.bean.model.TableModel;
import com.yao.bean.vo.ResultObj;
import com.yao.common.Consts;
import com.yao.sys.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : 妖妖
 * @date : 14:24 2020/7/14
 */
@RestController
@RequestMapping(value = "/role")
//@Slf4j
public class RoleController {
    private static Log log = LogFactory.getLog(RoleController.class);

    @Autowired
    private RoleService roleService;

    @PostMapping(value = "index")
    public TableModel index(RoleTab roleTab){
        TableModel tableModel = roleService.obtainRole(roleTab);
        return tableModel;
    }
    @PostMapping(value = "add")
    public ResultObj add(RoleModel role){
        ResultObj resultObj = new ResultObj();
        try {
            roleService.addRole(role);
            resultObj.setState(true);
        }catch (Exception e){
            log.error("角色添加异常",e);
            resultObj.setState(false);
            resultObj.setMsg(e.getMessage());
        }
        return resultObj;
    }
    @PostMapping(value = "modify")
    public ResultObj modify(RoleModel role){
        ResultObj resultObj = new ResultObj();
        try {
            roleService.modifyRole(role);
            resultObj.setState(true);
        }catch (Exception e){
            log.error("角色修改异常",e);
            resultObj.setState(false);
            resultObj.setMsg(e.getMessage());
        }
        return resultObj;
    }
    @PostMapping(value = "disable")
    public ResultObj disable(RoleModel roleModel){
        ResultObj resultObj = new ResultObj();
        try {
            roleService.upStateRole(roleModel, Consts.ROLE_STATE_DISABLE);
            resultObj.setState(true);
        }catch (Exception e){
            log.error("角色停用异常",e);
            resultObj.setState(false);
            resultObj.setMsg(e.getMessage());
        }
        return resultObj;
    }
    @PostMapping(value = "enable")
    public ResultObj enable(RoleModel roleModel){
        ResultObj resultObj = new ResultObj();
        try {
            roleService.upStateRole(roleModel, Consts.ROLE_STATE_ENABLE);
            resultObj.setState(true);
        }catch (Exception e){
            log.error("角色启用异常",e);
            resultObj.setState(false);
            resultObj.setMsg(e.getMessage());
        }
        return resultObj;
    }
    @PostMapping(value = "delete")
    public ResultObj delete(RoleModel roleModel){
        ResultObj resultObj = new ResultObj();
        try {
            roleService.upStateRole(roleModel, Consts.ROLE_STATE_DELETE);
            resultObj.setState(true);
        }catch (Exception e){
            log.error("角色删除异常",e);
            resultObj.setState(false);
            resultObj.setMsg(e.getMessage());
        }
        return resultObj;
    }
}
