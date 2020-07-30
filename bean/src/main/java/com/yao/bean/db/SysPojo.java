package com.yao.bean.db;

import java.io.Serializable;
import java.util.Date;

/**
 * @author : 妖妖
 * @date : 16:34 2020/7/9
 */

public class SysPojo implements Serializable{
    private String id;
    private String nickname;
    private String mobileNo;
    private String realName;
    private String profilePic;
    private String sex;
    private String password;
    private Date birthday;
    private Date regDate;
    private Date startRegDate;
    private Date endRegDate;
    private Date updateDate;
    private Date lastDate;
    private String lastModOperId;
    private Date lastModOperDate;
    private String lastAuditOperId;
    private Date lastAuditOperDate;
    private String lastLoginIp;
    private String state;
    private String inState;
    private String agencyId;
    private String defaults;

    public Date getStartRegDate() {
        return startRegDate;
    }

    public SysPojo setStartRegDate(Date startRegDate) {
        this.startRegDate = startRegDate;
        return this;
    }

    public Date getEndRegDate() {
        return endRegDate;
    }

    public SysPojo setEndRegDate(Date endRegDate) {
        this.endRegDate = endRegDate;
        return this;
    }

    public String getId() {
        return id;
    }

    public SysPojo setId(String id) {
        this.id = id;
        return this;
    }

    public String getNickname() {
        return nickname;
    }

    public SysPojo setNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public SysPojo setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
        return this;
    }

    public String getRealName() {
        return realName;
    }

    public SysPojo setRealName(String realName) {
        this.realName = realName;
        return this;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public SysPojo setProfilePic(String profilePic) {
        this.profilePic = profilePic;
        return this;
    }

    public String getSex() {
        return sex;
    }

    public SysPojo setSex(String sex) {
        this.sex = sex;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public SysPojo setPassword(String password) {
        this.password = password;
        return this;
    }

    public Date getBirthday() {
        return birthday;
    }

    public SysPojo setBirthday(Date birthday) {
        this.birthday = birthday;
        return this;
    }

    public Date getRegDate() {
        return regDate;
    }

    public SysPojo setRegDate(Date regDate) {
        this.regDate = regDate;
        return this;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public SysPojo setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
        return this;
    }

    public Date getLastDate() {
        return lastDate;
    }

    public SysPojo setLastDate(Date lastDate) {
        this.lastDate = lastDate;
        return this;
    }

    public String getLastModOperId() {
        return lastModOperId;
    }

    public SysPojo setLastModOperId(String lastModOperId) {
        this.lastModOperId = lastModOperId;
        return this;
    }

    public Date getLastModOperDate() {
        return lastModOperDate;
    }

    public SysPojo setLastModOperDate(Date lastModOperDate) {
        this.lastModOperDate = lastModOperDate;
        return this;
    }

    public String getLastAuditOperId() {
        return lastAuditOperId;
    }

    public SysPojo setLastAuditOperId(String lastAuditOperId) {
        this.lastAuditOperId = lastAuditOperId;
        return this;
    }

    public Date getLastAuditOperDate() {
        return lastAuditOperDate;
    }

    public SysPojo setLastAuditOperDate(Date lastAuditOperDate) {
        this.lastAuditOperDate = lastAuditOperDate;
        return this;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public SysPojo setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
        return this;
    }

    public String getState() {
        return state;
    }

    public SysPojo setState(String state) {
        this.state = state;
        return this;
    }

    public String getInState() {
        return inState;
    }

    public SysPojo setInState(String inState) {
        this.inState = inState;
        return this;
    }

    public String getAgencyId() {
        return agencyId;
    }

    public SysPojo setAgencyId(String agencyId) {
        this.agencyId = agencyId;
        return this;
    }

    public String getDefaults() {
        return defaults;
    }

    public SysPojo setDefaults(String defaults) {
        this.defaults = defaults;
        return this;
    }
}
