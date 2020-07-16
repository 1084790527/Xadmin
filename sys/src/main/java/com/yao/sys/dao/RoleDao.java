package com.yao.sys.dao;

import com.yao.bean.db.RolePojo;

import java.util.List;

/**
 * @author : 妖妖
 * @date : 17:29 2020/7/9
 */
public interface RoleDao {
    public int insertRecord(RolePojo record);

    public RolePojo getRecordByKey(RolePojo record);

    public RolePojo getRecordByWhere(RolePojo record);

    public List<RolePojo> getRecordListByWhere(RolePojo record);

    public int updateRecordByKey(RolePojo record);
}
