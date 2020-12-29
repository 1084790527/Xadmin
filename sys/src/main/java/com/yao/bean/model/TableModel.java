package com.yao.bean.model;

/**
 * @author : 妖妖
 * @date : 10:47 2020/7/14
 */
public class TableModel {
    private int code;
    private String msg;
    private Long count;
    private Object data;

    public TableModel() {
        this.code = 0;
        this.msg = "";
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
