package com.yao.bean.db;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class PrivilegesPojo implements Serializable {

  private String id;
  private String inId;
  private String name;
  private String desc;
  private String parentId;
  private Long menuLevel;
  private Long permissionType;
  private String permission;
  private String url;
  private String methodType;
  private String state;
  private String lastModOperId;
  private Date lastModOperDate;
  private String creOperId;
  private Date creDate;
  private List<PrivilegesPojo> privileges;

  public List<PrivilegesPojo> getPrivileges() {
    return privileges;
  }

  public PrivilegesPojo setPrivileges(List<PrivilegesPojo> privileges) {
    this.privileges = privileges;
    return this;
  }

  public String getInId() {
    return inId;
  }

  public PrivilegesPojo setInId(String inId) {
    this.inId = inId;
    return this;
  }

  public String getId() {
    return id;
  }

  public PrivilegesPojo setId(String id) {
    this.id = id;
    return this;
  }


  public String getName() {
    return name;
  }

  public PrivilegesPojo setName(String name) {
    this.name = name;
    return this;
  }


  public String getDesc() {
    return desc;
  }

  public PrivilegesPojo setDesc(String desc) {
    this.desc = desc;
    return this;
  }


  public String getParentId() {
    return parentId;
  }

  public PrivilegesPojo setParentId(String parentId) {
    this.parentId = parentId;
    return this;
  }


  public Long getMenuLevel() {
    return menuLevel;
  }

  public PrivilegesPojo setMenuLevel(Long menuLevel) {
    this.menuLevel = menuLevel;
    return this;
  }


  public Long getPermissionType() {
    return permissionType;
  }

  public PrivilegesPojo setPermissionType(Long permissionType) {
    this.permissionType = permissionType;
    return this;
  }


  public String getPermission() {
    return permission;
  }

  public PrivilegesPojo setPermission(String permission) {
    this.permission = permission;
    return this;
  }


  public String getUrl() {
    return url;
  }

  public PrivilegesPojo setUrl(String url) {
    this.url = url;
    return this;
  }


  public String getMethodType() {
    return methodType;
  }

  public PrivilegesPojo setMethodType(String methodType) {
    this.methodType = methodType;
    return this;
  }


  public String getState() {
    return state;
  }

  public PrivilegesPojo setState(String state) {
    this.state = state;
    return this;
  }


  public String getLastModOperId() {
    return lastModOperId;
  }

  public PrivilegesPojo setLastModOperId(String lastModOperId) {
    this.lastModOperId = lastModOperId;
    return this;
  }


  public Date getLastModOperDate() {
    return lastModOperDate;
  }

  public PrivilegesPojo setLastModOperDate(Date lastModOperDate) {
    this.lastModOperDate = lastModOperDate;
    return this;
  }


  public String getCreOperId() {
    return creOperId;
  }

  public PrivilegesPojo setCreOperId(String creOperId) {
    this.creOperId = creOperId;
    return this;
  }


  public Date getCreDate() {
    return creDate;
  }

  public PrivilegesPojo setCreDate(Date creDate) {
    this.creDate = creDate;
    return this;
  }

}
