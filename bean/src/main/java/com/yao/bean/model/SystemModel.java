package com.yao.bean.model;

/**
 * @author : 妖妖
 * @date : 12:10 2020/7/12
 */
public class SystemModel {
    //平台版本
    private String version;
    //服务器公网ip
    private String serverAddress;
    //运行系统
    private String operatingSystem;
    //运行环境
    private String environment;
    //java版本
    private String javaVersion;
    //tomcat版本
    private String tomcatVersion;
    //mysql版本
    private String mysqlVersion;
    //硬盘剩余可用大小
    private String hardDisk;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getServerAddress() {
        return serverAddress;
    }

    public void setServerAddress(String serverAddress) {
        this.serverAddress = serverAddress;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getJavaVersion() {
        return javaVersion;
    }

    public void setJavaVersion(String javaVersion) {
        this.javaVersion = javaVersion;
    }

    public String getTomcatVersion() {
        return tomcatVersion;
    }

    public void setTomcatVersion(String tomcatVersion) {
        this.tomcatVersion = tomcatVersion;
    }

    public String getMysqlVersion() {
        return mysqlVersion;
    }

    public void setMysqlVersion(String mysqlVersion) {
        this.mysqlVersion = mysqlVersion;
    }

    public String getHardDisk() {
        return hardDisk;
    }

    public void setHardDisk(String hardDisk) {
        this.hardDisk = hardDisk;
    }
}
