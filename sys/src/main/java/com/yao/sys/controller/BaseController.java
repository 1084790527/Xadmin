package com.yao.sys.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yao.bean.LoginInfo;
import com.yao.bean.db.PrivilegesPojo;
import com.yao.bean.db.RolePojo;
import com.yao.bean.model.RoleModel;
import com.yao.bean.model.SystemModel;
import com.yao.common.Consts;
import com.yao.common.util.IdWorker;
import com.yao.sys.service.AuthorityService;
import com.yao.sys.service.RoleService;
import com.yao.sys.service.SystemService;
import com.yao.sys.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sun.rmi.runtime.Log;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author : 妖妖
 * @date : 21:05 2020/7/8
 */
@RequestMapping
@Controller
@Slf4j
public class BaseController {

    @Autowired
    private TestService testService;
    @Autowired
    private SystemService system;
    @Autowired
    private IdWorker idWorker;
    @Autowired
    private AuthorityService authorityService;
    @Autowired
    private RoleService roleService;

    @RequestMapping
    public String index_a(){
//        System.out.println("idWorker --- >>> "+idWorker.nextId());
        return "redirect:/index";
    }
    @RequestMapping(value = "index")
    public String index(Model model){
        authorityService.SettingRole();
        List<PrivilegesPojo> menus = authorityService.treePriAuthoritys();
//        log.info("menus : "+JSON.toJSONString(menus));
        //添加该用户的菜单
        model.addAttribute("menus",menus);
        return "index";
    }

    @RequestMapping(value = "/{path}")
    public String path(@PathVariable(name = "path")String path){
//        log.info("path : "+path);
//        log.info(JSON.toJSONString(testService.sysPojos()));
        return path;
    }

    @GetMapping(value = "/merchant/add")
    public String merchantAdd(Model model){

        List<RoleModel> roles = roleService.getEnableRoles();
        model.addAttribute("roles",roles);
        return "/merchant/add";
    }

    @GetMapping(value = "/role/modify")
    public String roleModify(Model model, @RequestParam(name = "id")String id){
//        List<PrivilegesPojo> pojoData = authorityService.obtainPriAuthoritys(id);
        List<String> prIds = new ArrayList<>();
        for (PrivilegesPojo pojoData : authorityService.obtainPriAuthoritys(id)){
            prIds.add(pojoData.getId());
        }

        List<PrivilegesPojo> privileges = authorityService.treePriAuthoritys();
//        log.info("menus : "+JSON.toJSONString(privileges));
        JSONArray menus = new JSONArray();
        for (PrivilegesPojo one: privileges){
            JSONObject oneData = new JSONObject();
            oneData.put("title", one.getName());
            oneData.put("id", one.getId());
            oneData.put("field","ids");
            if (one.getPrivileges() != null && one.getPrivileges().size() != 0){
                if (prIds.contains(one.getId()))
                    oneData.put("spread",true);
                JSONArray twoDataArrery=new JSONArray();
                for(PrivilegesPojo two : one.getPrivileges()){
                    JSONObject twoData = new JSONObject();
                    twoData.put("title", two.getName());
                    twoData.put("id", two.getId());
                    twoData.put("field","ids");
                    if (two.getPrivileges() != null && two.getPrivileges().size()!= 0){
                        if (prIds.contains(two.getId()))
                            twoData.put("spread",true);
                        JSONArray threeDataArray = new JSONArray();
                        for (PrivilegesPojo three : two.getPrivileges()){
                            JSONObject threeData = new JSONObject();
                            threeData.put("title", three.getName());
                            threeData.put("id", three.getId());
                            threeData.put("field","ids");
                            if (prIds.contains(three.getId()))
                                threeData.put("checked",true);
                            threeDataArray.add(threeData);
                        }
                        twoData.put("children", threeDataArray);
                    }else {
                        if (prIds.contains(two.getId()))
                            twoData.put("checked",true );
                    }
                    twoDataArrery.add(twoData);
                }
                oneData.put("children", twoDataArrery);
            }else {
                if (prIds.contains(one.getId()))
                    oneData.put("checked",true );
            }
            menus.add(oneData);
        }
        log.info("prIds : "+JSON.toJSONString(prIds));
        log.info("menus : "+menus.toString());
        model.addAttribute("menus",menus.toString());
        RolePojo role = roleService.obtainRole(id);
        model.addAttribute("role",role);
        return "/role/modify";
    }

    @GetMapping(value = "/role/add")
    public String roleAdd(Model model){
        List<PrivilegesPojo> privileges = authorityService.treePriAuthoritys();
//        log.info("menus : "+JSON.toJSONString(privileges));
        JSONArray menus = new JSONArray();
        for (PrivilegesPojo one: privileges){
            JSONObject oneData = new JSONObject();
            oneData.put("title", one.getName());
            oneData.put("id", one.getId());
            oneData.put("field","ids");
            if (one.getPrivileges() != null){
                JSONArray twoDataArrery=new JSONArray();
                for(PrivilegesPojo two : one.getPrivileges()){
                    JSONObject twoData = new JSONObject();
                    twoData.put("title", two.getName());
                    twoData.put("id", two.getId());
                    twoData.put("field","ids");
                    if (two.getPrivileges() != null){
                        JSONArray threeDataArray = new JSONArray();
                        for (PrivilegesPojo three : two.getPrivileges()){
                            JSONObject threeData = new JSONObject();
                            threeData.put("title", three.getName());
                            threeData.put("id", three.getId());
                            threeData.put("field","ids");
                            threeDataArray.add(threeData);
                        }
                        twoData.put("children", threeDataArray);
                    }
                    twoDataArrery.add(twoData);
                }
                oneData.put("children", twoDataArrery);
            }
            menus.add(oneData);
        }
        model.addAttribute("menus",menus.toString());
        return "role/add";
    }

    @RequestMapping(value = "/{one}/{two}")
    public String pathTwo(@PathVariable(name = "one")String one,@PathVariable(name = "two")String two){
        return one+"/"+two;
    }

    @RequestMapping(value = "welcome")
    public String welcome(Model model){
        model.addAttribute("system",system.system());
        return "welcome";
    }
}
