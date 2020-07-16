package com.yao.common.util;

import java.util.Date;

/**
 * @author : 妖妖
 * @date : 20:09 2020/7/16
 */
public class RangeDateUtil {
    private Date startDate;
    private Date endDate;

    public RangeDateUtil(String date) {
        if (date != null && (!"".equals(date))){
            date = date.replaceAll("-","").replaceAll(" ","");
            startDate = DateUtil.str2Date(date.substring(0,8)+"000000",DateUtil.yyyymmddhhmmss);
            endDate = DateUtil.str2Date(date.substring(8)+"235959",DateUtil.yyyymmddhhmmss);
        }
    }

    public Date getStartDate() {
        if (startDate == null || "".equals(startDate))
            return null;
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        if (endDate == null || "".equals(endDate))
            return null;
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
