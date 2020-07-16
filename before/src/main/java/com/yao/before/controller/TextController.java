package com.yao.before.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author : 妖妖
 * @date : 16:38 2020/7/4
 */
@RequestMapping(value = "/")
@Controller
public class TextController {

    @GetMapping(value = "/index")
    @ResponseBody
    public String index(){
        return "前端测试页面";
    }
}
