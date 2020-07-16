package com.yao.bean.model;

/**
 * @author : 妖妖
 * @date : 15:59 2020/7/16
 */
public class AgencyRegModel {
    private String id;
    private String name;
    private String mobileNo;
    private String realName;
    private String sex;
    private String nikename;
    private String password;
    private String[] priIds;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNikename() {
        return nikename;
    }

    public void setNikename(String nikename) {
        this.nikename = nikename;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String[] getPriIds() {
        return priIds;
    }

    public void setPriIds(String[] priIds) {
        this.priIds = priIds;
    }
}
