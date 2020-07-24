package com.yao.sys.dao;

import com.yao.bean.db.SysRolePojo;

import java.util.List;

/**
 * @author : 妖妖
 * @date : 17:28 2020/7/9
 */
public interface SysRoleDao {
    public int insertRecord(SysRolePojo record);

    public SysRolePojo getRecordByKey(SysRolePojo record);

    public SysRolePojo getRecordByWhere(SysRolePojo record);

    public List<SysRolePojo> getRecordListByWhere(SysRolePojo record);

    public int updateRecordByKey(SysRolePojo record);

    public int deleteRecordByKey(SysRolePojo record);
}
