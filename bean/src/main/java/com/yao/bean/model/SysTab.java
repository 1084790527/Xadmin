package com.yao.bean.model;

/**
 * @author : 妖妖
 * @date : 10:48 2020/7/14
 */
public class SysTab {
    private int page;
    private int limit;
    private String regDate;
    private String id;
    private String name;
    private String mobileNo;
    private String state;

    public String getRegDate() {
        if (regDate == null || "".equals(regDate))
            return null;
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        if (name == null || "".equals(name))
            return null;
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNo() {
        if (mobileNo == null || "".equals(mobileNo))
            return null;
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
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
}
