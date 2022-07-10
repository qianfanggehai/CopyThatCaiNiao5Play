package com.example.copythatcainiao5play.bean;

import java.util.List;

public class DataBean<T> {

    private List<T> listApp;

    public List<T> getListApp() {
        return listApp;
    }

    public void setListApp(List<T> listApp) {
        this.listApp = listApp;
    }
}
