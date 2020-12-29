package com.yao.bean.vo;

import com.yao.bean.model.TableModel;

public class ResultObj extends TableModel{
    private boolean state;

    public boolean isState() {
        return state;
    }

    public ResultObj setState(boolean state) {
        this.state = state;
        return this;
    }
}
