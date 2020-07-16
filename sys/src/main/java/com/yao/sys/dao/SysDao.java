package com.yao.sys.dao;

import com.yao.bean.db.SysPojo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author : 妖妖
 * @date : 16:59 2020/7/9
 */
public interface SysDao {
    public int insertRecord(SysPojo record);

    public SysPojo getRecordByKey(SysPojo record);

    public SysPojo getRecordByWhere(SysPojo record);

    public List<SysPojo> getRecordListByWhere(SysPojo record);

    public int updateRecordByKey(SysPojo record);
}
