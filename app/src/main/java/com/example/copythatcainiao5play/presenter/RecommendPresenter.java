package com.example.copythatcainiao5play.presenter;

import com.example.copythatcainiao5play.bean.BaseBean;
import com.example.copythatcainiao5play.common.rx.RxHttpResponseCompat;
import com.example.copythatcainiao5play.data.RecommendModel;
import com.example.copythatcainiao5play.presenter.contract.RecommendContract;
import com.example.copythatcainiao5play.bean.DataBean;
import com.example.copythatcainiao5play.bean.ListAppBean;
import com.example.copythatcainiao5play.bean.PageBean;
import com.example.copythatcainiao5play.bean.TypeBean;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class RecommendPresenter extends BasePresenter<RecommendModel, RecommendContract.View> {

    private List<ListAppBean> listAppBeans = new ArrayList<>();

    @Inject
    public RecommendPresenter(RecommendModel model, RecommendContract.View view) {
        super(model, view);
    }

    public void requestDatas() {
        mView.showLoading();
        mModel.getApps(new Callback<PageBean<TypeBean>>() {
            @Override
            public void onResponse(Call<PageBean<TypeBean>> call, Response<PageBean<TypeBean>> response) {

                if (response!=null){
                    PageBean<TypeBean> body = response.body();
                    assert body != null;
                    List<TypeBean> dabs = body.getDatas();
                    for (TypeBean<ListAppBean> beans: dabs){
                        if (beans.getType().equals("listApp")) {
                            DataBean<ListAppBean> data = beans.getData();

                            String s = new Gson().toJson(data);

                            DataBean<ListAppBean> dataBean = new Gson().fromJson(s, new TypeToken<DataBean<ListAppBean>>(){}.getType());

                            List<ListAppBean> typeListBean =dataBean.getListApp();

                            assert typeListBean != null;
                            listAppBeans.addAll(typeListBean);
                        }
                    }
                    mView.showResult(listAppBeans);
                }else {
                    mView.showNoData();
                }
                mView.dismissLoading();
            }

            @Override
            public void onFailure(Call<PageBean<TypeBean>> call, Throwable t) {

                mView.dismissLoading();
                mView.showError(t.getMessage());
            }
        });

//        mModel.getApps()
//                .subscribeOn(Schedulers.io())
//
//                .observeOn(AndroidSchedulers.mainThread())
//
//                .subscribe(new Subscriber<PageBean<TypeBean>>() {
//
//                    @Override
//                    public void onStart() {
//                        mView.showLoading();
//                    }
//
//                    @Override
//                    public void onCompleted() {
//                        mView.dismissLoading();
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        mView.dismissLoading();
//                    }
//
//                    @Override
//                    public void onNext(PageBean<TypeBean> typeBeanPageBean) {
//                        if (typeBeanPageBean != null) {
////                            PageBean<TypeBean> body = typeBeanPageBean.getDatas();
////                            assert body != null;
//                            List<TypeBean> dabs = typeBeanPageBean.getDatas();
//                            for (TypeBean<ListAppBean> beans : dabs) {
//                                if (beans.getType().equals("listApp")) {
//                                    DataBean<ListAppBean> data = beans.getData();
//
//                                    String s = new Gson().toJson(data);
//
//                                    DataBean<ListAppBean> dataBean = new Gson().fromJson(s, new TypeToken<DataBean<ListAppBean>>() {
//                                    }.getType());
//
//                                    List<ListAppBean> typeListBean = dataBean.getListApp();
//
//                                    assert typeListBean != null;
//                                    listAppBeans.addAll(typeListBean);
//                                }
//                            }
//                            mView.showResult(listAppBeans);
//                        } else {
//                            mView.showNoData();
//                        }
//                    }
//                });
    }
}