package com.yao.bean.vo;

public class ResultObj {
    private Object data;
    private String message;
    private boolean state;

    public Object getData() {
        return data;
    }

    public ResultObj setData(Object data) {
        this.data = data;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ResultObj setMessage(String message) {
        this.message = message;
        return this;
    }

    public boolean isState() {
        return state;
    }

    public ResultObj setState(boolean state) {
        this.state = state;
        return this;
    }
}
