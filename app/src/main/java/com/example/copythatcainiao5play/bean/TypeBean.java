package com.example.copythatcainiao5play.bean;

public class TypeBean<T> {
    private String type;
    private DataBean<T> data;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public DataBean<T> getData() {
        return data;
    }

    public void setData(DataBean<T> data) {
        this.data = data;
    }
}
