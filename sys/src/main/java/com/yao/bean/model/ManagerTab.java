package com.yao.bean.model;

/**
 * @author : 妖妖
 * @date : 10:03 2020/7/17
 */
public class ManagerTab {
    private int page;
    private int limit;
    private String regDate;
    private String nickname;
    private String mobileNo;
    private String realName;
    private String sex;
    private String state;

    public String getNickname() {
        if (nickname == null || "".equals(nickname))
            return null;
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getMobileNo() {
        if (mobileNo == null || "".equals(mobileNo))
            return null;
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getRealName() {
        if (realName == null || "".equals(realName))
            return null;
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getSex() {
        if (sex == null || "".equals(sex))
            return null;
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getState() {
        if (state == null || "".equals(state))
            return null;
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getRegDate() {
        if (regDate == null || regDate.equals(""))
            return null;
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }
}
