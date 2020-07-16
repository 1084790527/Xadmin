package com.yao.sys.dao;

import com.yao.bean.db.AgencyPojo;

import java.util.List;

/**
 * @author : 妖妖
 * @date : 17:29 2020/7/9
 */
public interface AgencyDao {
    public int insertRecord(AgencyPojo record);

    public AgencyPojo getRecordByKey(AgencyPojo record);

    public AgencyPojo getRecordByWhere(AgencyPojo record);

    public List<AgencyPojo> getRecordListByWhere(AgencyPojo record);

    public int updateRecordByKey(AgencyPojo record);
}
