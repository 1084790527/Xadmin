package com.yao.sys.controller;

import com.alibaba.fastjson.JSON;
import com.yao.bean.model.SysModel;
import com.yao.bean.vo.ResultObj;
import com.yao.sys.service.InfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : 妖妖
 * @date : 14:30 2020/7/31
 */
@RequestMapping(value = "/info")
@RestController
@Slf4j
public class InfoController {

    @Autowired
    private InfoService infoService;

    @PostMapping(value = "index")
    public ResultObj index(SysModel sysModel){
        ResultObj resultObj = new ResultObj();
        try {
            infoService.upInfo(sysModel);
            resultObj.setState(true);
        }catch (Exception e){
            log.debug(e.getMessage(),e);
            resultObj.setState(false).setMessage(e.getMessage());
        }
        return resultObj;
    }

    @PostMapping(value = "resetpwd")
    public ResultObj resetpwd(@RequestParam(value = "oldPwd")String oldPwd,@RequestParam(value = "newPwd")String newPwd){
        ResultObj resultObj = new ResultObj();
        try {
            infoService.resetpwd(oldPwd,newPwd);
            resultObj.setState(true);
        }catch (Exception e){
            log.debug(e.getMessage(),e);
            resultObj.setState(false).setMessage(e.getMessage());
        }
        return resultObj;
    }
}
