package com.yao.bean.db;


import java.io.Serializable;
import java.util.Date;

public class AgencyPojo implements Serializable {

  private String id;
  private String name;
  private String mobileNo;
  private Date regDate;
  private Date regStartDate;
  private Date regEndDate;
  private Date updateDate;
  private String creOperId;
  private String lastModOperId;
  private Date lastModOperDate;
  private String state;
  private String inState;
  private String cityId;

  public Date getRegStartDate() {
    return regStartDate;
  }

  public AgencyPojo setRegStartDate(Date regStartDate) {
    this.regStartDate = regStartDate;
    return this;
  }

  public Date getRegEndDate() {
    return regEndDate;
  }

  public AgencyPojo setRegEndDate(Date regEndDate) {
    this.regEndDate = regEndDate;
    return this;
  }

  public String getInState() {
    return inState;
  }

  public AgencyPojo setInState(String inState) {
    this.inState = inState;
    return this;
  }

  public String getId() {
    if (id == null || "".equals(id))
      return null;
    return id;
  }

  public AgencyPojo setId(String id) {
    this.id = id;
    return this;
  }


  public String getName() {
    return name;
  }

  public AgencyPojo setName(String name) {
    this.name = name;
    return this;
  }


  public String getMobileNo() {
    return mobileNo;
  }

  public AgencyPojo setMobileNo(String mobileNo) {
    this.mobileNo = mobileNo;
    return this;
  }


  public Date getRegDate() {
    return regDate;
  }

  public AgencyPojo setRegDate(Date regDate) {
    this.regDate = regDate;
    return this;
  }


  public Date getUpdateDate() {
    return updateDate;
  }

  public AgencyPojo setUpdateDate(Date updateDate) {
    this.updateDate = updateDate;
    return this;
  }


  public String getCreOperId() {
    return creOperId;
  }

  public AgencyPojo setCreOperId(String creOperId) {
    this.creOperId = creOperId;
    return this;
  }


  public String getLastModOperId() {
    return lastModOperId;
  }

  public AgencyPojo setLastModOperId(String lastModOperId) {
    this.lastModOperId = lastModOperId;
    return this;
  }


  public Date getLastModOperDate() {
    return lastModOperDate;
  }

  public AgencyPojo setLastModOperDate(Date lastModOperDate) {
    this.lastModOperDate = lastModOperDate;
    return this;
  }


  public String getState() {
    return state;
  }

  public AgencyPojo setState(String state) {
    this.state = state;
    return this;
  }


  public String getCityId() {
    return cityId;
  }

  public AgencyPojo setCityId(String cityId) {
    this.cityId = cityId;
    return this;
  }

}
