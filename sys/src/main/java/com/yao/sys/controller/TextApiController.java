package com.yao.sys.controller;

import com.yao.bean.vo.MailVo;
import com.yao.sys.service.MailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author : 妖妖
 * @date : 15:23 2020/8/7
 */
@RestController
@RequestMapping(value = "/text/api")
@Slf4j
public class TextApiController {

//    @Autowired
//    private MailService_1 mailService1;
    @Autowired
    private MailService mailService;

    @GetMapping(value = "/t1")
    public String t1(){
        log.info("发邮件t1");
        MailVo mailVo = new MailVo();
        mailVo.setTo("1084790527@qq.com");
        mailVo.setSubject("邮件标题");
        mailVo.setText("邮件内容1111111111111111111111111111111111111111111111");
        MailVo mail = mailService.sendMail(mailVo);
        return mail.getError();
    }
}
