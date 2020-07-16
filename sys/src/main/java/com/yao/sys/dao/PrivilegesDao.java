package com.yao.sys.dao;

import com.yao.bean.db.PrivilegesPojo;

import java.util.List;

/**
 * @author : 妖妖
 * @date : 17:29 2020/7/9
 */
public interface PrivilegesDao {
    public int insertRecord(PrivilegesPojo record);

    public PrivilegesPojo getRecordByKey(PrivilegesPojo record);

    public PrivilegesPojo getRecordByWhere(PrivilegesPojo record);

    public List<PrivilegesPojo> getRecordListByWhere(PrivilegesPojo record);

    public int updateRecordByKey(PrivilegesPojo record);

    List<PrivilegesPojo> treePrivileges(PrivilegesPojo record);
}
