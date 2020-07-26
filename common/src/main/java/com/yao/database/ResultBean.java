package com.yao.database;

/**
 * @author : 妖妖
 * @date : 10:44 2020/7/26
 */
public class ResultBean {
    private String name;
    private String type;
    private String comment;

    public String getName() {
        return name;
    }

    public ResultBean setName(String name) {
        this.name = name;
        return this;
    }

    public String getType() {
        return type;
    }

    public ResultBean setType(String type) {
        this.type = type;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public ResultBean setComment(String comment) {
        this.comment = comment;
        return this;
    }
}
