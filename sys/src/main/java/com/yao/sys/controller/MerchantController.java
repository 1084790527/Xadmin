package com.yao.sys.controller;

import com.alibaba.fastjson.JSON;
import com.yao.bean.model.AgencyModel;
import com.yao.bean.model.AgencyRegModel;
import com.yao.bean.model.SysTab;
import com.yao.bean.model.TableModel;
import com.yao.bean.vo.ResultObj;
import com.yao.common.Consts;
import com.yao.sys.service.MerchantService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : 妖妖
 * @date : 9:51 2020/7/14
 */
@RestController
@RequestMapping(value = "/merchant")
//@Slf4j
public class MerchantController {

    private static Log log = LogFactory.getLog(MerchantController.class);
    @Autowired
    private MerchantService merchantService;

    @PostMapping(value = "index")
    public TableModel index(SysTab sysTab){
        TableModel data = merchantService.obtainAgency(sysTab);
//        log.info(JSON.toJSONString(data));
        return data;
    }
    @PostMapping(value = "password")
    public ResultObj password(AgencyRegModel agencyRegModel){
        ResultObj resultObj = new ResultObj();
        try {
            merchantService.resetPassword(agencyRegModel);
            resultObj.setState(true);
            resultObj.setMsg("密码修改成功");
        }catch (Exception e){
            log.error("添加商户错误",e);
            resultObj.setState(false);
            resultObj.setMsg(e.getMessage());
        }
        return resultObj;
    }

    @PostMapping(value = "add")
    public ResultObj add(AgencyRegModel agencyRegModel){
//        log.info("agencyRegModel : "+JSON.toJSONString(agencyRegModel));
        ResultObj resultObj = new ResultObj();
        try {
            merchantService.addMerchant(agencyRegModel);
            resultObj.setState(true);
        }catch (Exception e){
            log.error("添加商户错误",e);
            resultObj.setState(false);
            resultObj.setMsg(e.getMessage());
        }
        return resultObj;
    }
    @PostMapping(value = "disable")
    public ResultObj disable(AgencyModel agencyModel){
        ResultObj resultObj = new ResultObj();
        try {
            merchantService.upStateAgency(agencyModel, Consts.AGENCY_STATE_DISABLE);
            resultObj.setState(true);
        }catch (Exception e){
            log.error("停用商户错误",e);
            resultObj.setState(false);
            resultObj.setMsg(e.getMessage());
        }
        return resultObj;
    }
    @PostMapping(value = "enable")
    public ResultObj enable(AgencyModel agencyModel){
        ResultObj resultObj = new ResultObj();
        try {
            merchantService.upStateAgency(agencyModel, Consts.AGENCY_STATE_ENABLE);
            resultObj.setState(true);
        }catch (Exception e){
            log.error("启用商户错误",e);
            resultObj.setState(false);
            resultObj.setMsg(e.getMessage());
        }
        return resultObj;
    }
    @PostMapping(value = "delete")
    public ResultObj delete(AgencyModel agencyModel){
        ResultObj resultObj = new ResultObj();
        try {
            merchantService.upStateAgency(agencyModel, Consts.AGENCY_STATE_DELETE);
            resultObj.setState(true);
        }catch (Exception e){
            log.error("删除商户错误",e);
            resultObj.setState(false);
            resultObj.setMsg(e.getMessage());
        }
        return resultObj;
    }

}
