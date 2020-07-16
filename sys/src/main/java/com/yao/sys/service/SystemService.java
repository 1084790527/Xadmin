package com.yao.sys.service;

import com.alibaba.fastjson.JSON;
import com.mysql.cj.jdbc.DatabaseMetaData;
import com.mysql.cj.util.StringUtils;
import com.yao.bean.model.SystemModel;
import org.apache.catalina.util.ServerInfo;
import org.junit.Test;
import org.springframework.stereotype.Service;

import java.io.File;
import java.math.BigDecimal;
import java.util.Properties;

/**
 * @author : 妖妖
 * @date : 12:16 2020/7/12
 */
@Service
public class SystemService {

    public SystemModel system(){
        SystemModel system = new SystemModel();
        Properties properties = System.getProperties();
        system.setVersion("1.0.0");
        system.setServerAddress("111.111.111.111");
        system.setOperatingSystem(properties.getProperty("os.name"));
        system.setEnvironment("java + tomcat");
        system.setJavaVersion(properties.getProperty("java.version"));
        system.setTomcatVersion(ServerInfo.getServerInfo());
        system.setMysqlVersion("8.0.0");
        File[] disks = File.listRoots();
        Long freeSpace = 0L;
        for(File file : disks){
            freeSpace = freeSpace + file.getFreeSpace();
        }
        system.setHardDisk(new BigDecimal(freeSpace).divide(new BigDecimal(1024*1024*1024)).setScale(4,BigDecimal.ROUND_HALF_UP).toString()+"G");
//        System.out.println("system ---- >>> "+JSON.toJSONString(system));
        return system;
    }

}
