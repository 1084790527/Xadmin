package com.yao.sys.controller;

import com.yao.bean.vo.MailVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author : 妖妖
 * @date : 15:23 2020/8/7
 */
@RestController
@RequestMapping(value = "/text/api")
//@Slf4j
public class TextApiController {
    private static Log log = LogFactory.getLog(TextApiController.class);

//    @Autowired
//    private MailService mailService;
//
//    @GetMapping(value = "/t1")
//    public String t1(){
//        MailVo mailVo = new MailVo();
//        mailVo.setTo("1084790527@qq.com");
//        mailVo.setSubject("邮件标题");
//        mailVo.setText("邮件内容1111111111111111111111111111111111111111111111");
//        MailVo mail = mailService.sendMail(mailVo);
//        return mail.getError();
//    }

    @Test
    public void tttt(){
        LinkedHashSet<String> hashSet = new LinkedHashSet<>();
        hashSet.add("45453");
        hashSet.add("tttt");
        hashSet.add("adgsrvrv");
        hashSet.add("cxzxvdxzv");
        System.out.println(hashSet.toString());
        hashSet.add("asfasf");
        System.out.println(hashSet.toString());
        hashSet.add("cxzxvdxzv");
        System.out.println(hashSet.toString());
//        System.out.println(hashSet.contains("cxzxvdxzv"));
//        System.out.println(hashSet.contains("safffff"));

        hashSet.remove("45453");
        System.out.println(hashSet.toString());
    }

    @PostMapping(value = "/t2")
    public String t2(HttpServletRequest request,MultipartFile file){
        System.out.println(request.getParameter("aaa"));
        System.out.println(file.getOriginalFilename());
        return "asdasdasdasd";
    }

}
