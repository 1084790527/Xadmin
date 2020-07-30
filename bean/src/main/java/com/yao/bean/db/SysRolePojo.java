package com.yao.bean.db;

import java.io.Serializable;
import java.util.Date;

public class SysRolePojo implements Serializable {

  private String userId;
  private String roleId;
  private String state;
  private String lastModOperId;
  private Date lastModOperDate;
  private String creOperId;
  private Date creDate;


  public String getUserId() {
    return userId;
  }

  public SysRolePojo setUserId(String userId) {
    this.userId = userId;
    return this;
  }


  public String getRoleId() {
    return roleId;
  }

  public SysRolePojo setRoleId(String roleId) {
    this.roleId = roleId;
    return this;
  }


  public String getState() {
    return state;
  }

  public SysRolePojo setState(String state) {
    this.state = state;
    return this;
  }


  public String getLastModOperId() {
    return lastModOperId;
  }

  public SysRolePojo setLastModOperId(String lastModOperId) {
    this.lastModOperId = lastModOperId;
    return this;
  }


  public Date getLastModOperDate() {
    return lastModOperDate;
  }

  public SysRolePojo setLastModOperDate(Date lastModOperDate) {
    this.lastModOperDate = lastModOperDate;
    return this;
  }


  public String getCreOperId() {
    return creOperId;
  }

  public SysRolePojo setCreOperId(String creOperId) {
    this.creOperId = creOperId;
    return this;
  }


  public Date getCreDate() {
    return creDate;
  }

  public SysRolePojo setCreDate(Date creDate) {
    this.creDate = creDate;
    return this;
  }

}
