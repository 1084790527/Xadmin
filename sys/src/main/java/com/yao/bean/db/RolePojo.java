package com.yao.bean.db;


import java.io.Serializable;
import java.util.Date;

public class RolePojo implements Serializable {

  private String id;
  private String agencyId;
  private String name;
  private String desc;
  private String state;
  private String inState;
  private String lastModOperId;
  private Date lastModOperDate;
  private String creOperId;
  private Date creDate;

  public String getInState() {
    return inState;
  }

  public RolePojo setInState(String inState) {
    this.inState = inState;
    return this;
  }

  public String getAgencyId() {
    return agencyId;
  }

  public RolePojo setAgencyId(String agencyId) {
    this.agencyId = agencyId;
    return this;
  }

  public String getId() {
    return id;
  }

  public RolePojo setId(String id) {
    this.id = id;
    return this;
  }


  public String getName() {
    return name;
  }

  public RolePojo setName(String name) {
    this.name = name;
    return this;
  }


  public String getDesc() {
    return desc;
  }

  public RolePojo setDesc(String desc) {
    this.desc = desc;
    return this;
  }


  public String getState() {
    return state;
  }

  public RolePojo setState(String state) {
    this.state = state;
    return this;
  }


  public String getLastModOperId() {
    return lastModOperId;
  }

  public RolePojo setLastModOperId(String lastModOperId) {
    this.lastModOperId = lastModOperId;
    return this;
  }


  public Date getLastModOperDate() {
    return lastModOperDate;
  }

  public RolePojo setLastModOperDate(Date lastModOperDate) {
    this.lastModOperDate = lastModOperDate;
    return this;
  }


  public String getCreOperId() {
    return creOperId;
  }

  public RolePojo setCreOperId(String creOperId) {
    this.creOperId = creOperId;
    return this;
  }


  public Date getCreDate() {
    return creDate;
  }

  public RolePojo setCreDate(Date creDate) {
    this.creDate = creDate;
    return this;
  }

}
