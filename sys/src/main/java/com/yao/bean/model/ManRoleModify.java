package com.yao.bean.model;

/**
 * @author : 妖妖
 * @date : 19:22 2020/7/24
 */
public class ManRoleModify {
    private String roleId;
    private String name;
    private boolean state;

    public String getName() {
        return name;
    }

    public ManRoleModify setName(String name) {
        this.name = name;
        return this;
    }

    public String getRoleId() {
        return roleId;
    }

    public ManRoleModify setRoleId(String roleId) {
        this.roleId = roleId;
        return this;
    }

    public boolean isState() {
        return state;
    }

    public ManRoleModify setState(boolean state) {
        this.state = state;
        return this;
    }
}
