package com.yao.sys.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yao.bean.db.SysPojo;
import com.yao.sys.dao.SysDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author : 妖妖
 * @date : 17:15 2020/7/9
 */
@Service
@Transactional
@Slf4j
public class TestService {

    @Autowired
    private SysDao sysDao;

    public List<SysPojo> sysPojos(){


        //分页查询从1开始
        PageHelper.orderBy(" id desc ");
        PageHelper.startPage(2,5 ,true );
        List<SysPojo> sysPojos = sysDao.getRecordListByWhere(new SysPojo());
        PageInfo page = new PageInfo(sysPojos);

//        log.info("StartRow : "+page.getStartRow());
//        log.info("EndRow   : "+page.getEndRow());
        log.info("PageNum  : "+page.getPageNum()); //当前页  第1页开始
        log.info("Pages    : "+page.getPages()); //总页数
        log.info("Total    : "+page.getTotal()); //总记录数
        log.info("PageSize : "+page.getPageSize()); //  每页的数量
        log.info("First    : "+page.isIsFirstPage());
        log.info("Last     : "+page.isIsLastPage());

        return sysPojos;
    }

}
