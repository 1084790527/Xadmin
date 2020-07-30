package com.yao.bean.db;


import java.io.Serializable;
import java.util.Date;

public class RolePrivilegesPojo implements Serializable {

  private String privilegeId;
  private String roleId;
  private String inRoleId;
  private String state;
  private String lastModOperId;
  private Date lastModOperDate;
  private String creOperId;
  private Date creDate;

  public String getInRoleId() {
    return inRoleId;
  }

  public RolePrivilegesPojo setInRoleId(String inRoleId) {
    this.inRoleId = inRoleId;
    return this;
  }

  public String getPrivilegeId() {
    return privilegeId;
  }

  public RolePrivilegesPojo setPrivilegeId(String privilegeId) {
    this.privilegeId = privilegeId;
    return this;
  }


  public String getRoleId() {
    return roleId;
  }

  public RolePrivilegesPojo setRoleId(String roleId) {
    this.roleId = roleId;
    return this;
  }


  public String getState() {
    return state;
  }

  public RolePrivilegesPojo setState(String state) {
    this.state = state;
    return this;
  }


  public String getLastModOperId() {
    return lastModOperId;
  }

  public RolePrivilegesPojo setLastModOperId(String lastModOperId) {
    this.lastModOperId = lastModOperId;
    return this;
  }


  public Date getLastModOperDate() {
    return lastModOperDate;
  }

  public RolePrivilegesPojo setLastModOperDate(Date lastModOperDate) {
    this.lastModOperDate = lastModOperDate;
    return this;
  }


  public String getCreOperId() {
    return creOperId;
  }

  public RolePrivilegesPojo setCreOperId(String creOperId) {
    this.creOperId = creOperId;
    return this;
  }


  public Date getCreDate() {
    return creDate;
  }

  public RolePrivilegesPojo setCreDate(Date creDate) {
    this.creDate = creDate;
    return this;
  }

}
