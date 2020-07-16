package com.yao.bean.model;


public class AgencyModel {

  private String id;
  private String name;
  private String mobileNo;
  private String regDate;
  private String updateDate;
  private String creOperId;
  private String creOperName;
  private String lastModOperId;
  private String lastModOperName;
  private String lastModOperDate;
  private String state;
  private String cityId;

  public String getCreOperName() {
    return creOperName;
  }

  public void setCreOperName(String creOperName) {
    this.creOperName = creOperName;
  }

  public String getLastModOperName() {
    return lastModOperName;
  }

  public void setLastModOperName(String lastModOperName) {
    this.lastModOperName = lastModOperName;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getMobileNo() {
    return mobileNo;
  }

  public void setMobileNo(String mobileNo) {
    this.mobileNo = mobileNo;
  }

  public String getRegDate() {
    return regDate;
  }

  public void setRegDate(String regDate) {
    this.regDate = regDate;
  }

  public String getUpdateDate() {
    return updateDate;
  }

  public void setUpdateDate(String updateDate) {
    this.updateDate = updateDate;
  }

  public String getCreOperId() {
    return creOperId;
  }

  public void setCreOperId(String creOperId) {
    this.creOperId = creOperId;
  }

  public String getLastModOperId() {
    return lastModOperId;
  }

  public void setLastModOperId(String lastModOperId) {
    this.lastModOperId = lastModOperId;
  }

  public String getLastModOperDate() {
    return lastModOperDate;
  }

  public void setLastModOperDate(String lastModOperDate) {
    this.lastModOperDate = lastModOperDate;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getCityId() {
    return cityId;
  }

  public void setCityId(String cityId) {
    this.cityId = cityId;
  }
}
