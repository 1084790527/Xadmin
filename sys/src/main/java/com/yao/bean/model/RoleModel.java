package com.yao.bean.model;


public class RoleModel {

  private String id;
  private String[] ids;
  private String agencyId;
  private String name;
  private String desc;
  private String state;
  private String inState;
  private String lastModOperId;
  private String lastModOperName;
  private String lastModOperDate;
  private String creOperId;
  private String creOperName;
  private String creDate;

  public String[] getIds() {
    return ids;
  }

  public void setIds(String[] ids) {
    this.ids = ids;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getAgencyId() {
    return agencyId;
  }

  public void setAgencyId(String agencyId) {
    this.agencyId = agencyId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getInState() {
    return inState;
  }

  public void setInState(String inState) {
    this.inState = inState;
  }

  public String getLastModOperId() {
    return lastModOperId;
  }

  public void setLastModOperId(String lastModOperId) {
    this.lastModOperId = lastModOperId;
  }

  public String getLastModOperName() {
    return lastModOperName;
  }

  public void setLastModOperName(String lastModOperName) {
    this.lastModOperName = lastModOperName;
  }

  public String getLastModOperDate() {
    return lastModOperDate;
  }

  public void setLastModOperDate(String lastModOperDate) {
    this.lastModOperDate = lastModOperDate;
  }

  public String getCreOperId() {
    return creOperId;
  }

  public void setCreOperId(String creOperId) {
    this.creOperId = creOperId;
  }

  public String getCreOperName() {
    return creOperName;
  }

  public void setCreOperName(String creOperName) {
    this.creOperName = creOperName;
  }

  public String getCreDate() {
    return creDate;
  }

  public void setCreDate(String creDate) {
    this.creDate = creDate;
  }
}
