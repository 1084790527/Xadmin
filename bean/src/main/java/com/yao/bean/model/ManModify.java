package com.yao.bean.model;

import java.util.List;

/**
 * @author : 妖妖
 * @date : 19:21 2020/7/24
 */
public class ManModify {
    private String id;
    private String nickname;
    private String mobileNo;
    private String realName;
    private String profilePic;
    private String sex;
    private String password;
    private String birthday;
    private List<ManRoleModify> roleIds;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public List<ManRoleModify> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<ManRoleModify> roleIds) {
        this.roleIds = roleIds;
    }
}
