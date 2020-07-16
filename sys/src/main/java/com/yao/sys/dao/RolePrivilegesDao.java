package com.yao.sys.dao;

import com.yao.bean.db.RolePrivilegesPojo;

import java.util.List;

/**
 * @author : 妖妖
 * @date : 17:29 2020/7/9
 */
public interface RolePrivilegesDao {
    public int insertRecord(RolePrivilegesPojo record);

    public RolePrivilegesPojo getRecordByKey(RolePrivilegesPojo record);

    public RolePrivilegesPojo getRecordByWhere(RolePrivilegesPojo record);

    public List<RolePrivilegesPojo> getRecordListByWhere(RolePrivilegesPojo record);

    public int updateRecordByKey(RolePrivilegesPojo record);

    public int deleteRecordByKey(RolePrivilegesPojo record);
}
