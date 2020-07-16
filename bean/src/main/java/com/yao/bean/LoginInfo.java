package com.yao.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * @author : 妖妖
 * @date : 17:40 2020/7/13
 */
public class LoginInfo implements Serializable {
    private String id;
    private String nickname;
    private String mobileNo;
    private String ip;
    private String agencyId;
    private String defaults;
    private Date loginDate;
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getId() {
        return id;
    }

    public LoginInfo setId(String id) {
        this.id = id;
        return this;
    }

    public String getNickname() {
        return nickname;
    }

    public LoginInfo setNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public LoginInfo setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
        return this;
    }

    public String getIp() {
        return ip;
    }

    public LoginInfo setIp(String ip) {
        this.ip = ip;
        return this;
    }

    public String getAgencyId() {
        return agencyId;
    }

    public LoginInfo setAgencyId(String agencyId) {
        this.agencyId = agencyId;
        return this;
    }

    public String getDefaults() {
        return defaults;
    }

    public LoginInfo setDefaults(String defaults) {
        this.defaults = defaults;
        return this;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public LoginInfo setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
        return this;
    }
}
