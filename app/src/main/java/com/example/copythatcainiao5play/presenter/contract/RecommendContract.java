package com.example.copythatcainiao5play.presenter.contract;

import com.example.copythatcainiao5play.presenter.BasePresenter;
import com.example.copythatcainiao5play.ui.BaseView;
import com.example.copythatcainiao5play.bean.ListAppBean;

import java.util.List;

public interface RecommendContract {
    interface View extends BaseView{


        void showResult(List<ListAppBean> data);
        void showNoData();
        void showError(String message);
    }

}
