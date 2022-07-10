package com.example.copythatcainiao5play.ui.fragment;

import android.app.Application;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.copythatcainiao5play.AppApplication;
import com.example.copythatcainiao5play.R;
import com.example.copythatcainiao5play.di.component.AppComponent;
import com.example.copythatcainiao5play.di.component.DaggerAppComponent;
import com.example.copythatcainiao5play.di.component.DaggerRecommendComponent;
import com.example.copythatcainiao5play.di.module.RecommendModule;
import com.example.copythatcainiao5play.presenter.RecommendPresenter;
import com.example.copythatcainiao5play.presenter.contract.RecommendContract;
import com.example.copythatcainiao5play.ui.adapter.RecommedAppAdapter;
import com.example.copythatcainiao5play.bean.ListAppBean;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecommendFragment extends BaseFragment<RecommendPresenter> implements RecommendContract.View {
    String TAG="RecommendFragment";

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    List<ListAppBean> listAppBeans;

    private RecommedAppAdapter mRecommendAppAdapter;

    @Inject
    ProgressDialog mProgressDialog;

    @Override
    public int setLayout() {
        return R.layout.fragment_recommend;
    }

    @Override
    public void setUpActivityComponent(AppComponent appComponent) {
        DaggerRecommendComponent.builder().appComponent(appComponent)
                .recommendModule(new RecommendModule(this))
                .build().inject(this);
    }

    @Override
    public void init() {
        mPresenter.requestDatas();
    }

    private void initRecyclerView(List<ListAppBean> dates){

        //布局管理器
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        //分割线
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.HORIZONTAL));

        //动画
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        mRecommendAppAdapter=new RecommedAppAdapter(getActivity(),dates);


//        recyclerView.scrollToPosition(6);

//        我也没试过能不能成功~
//        MoveToPosition(layoutManager,6);

        recyclerView.setAdapter(mRecommendAppAdapter);

    }
    /**
     * RecyclerView 移动到当前位置，
     *
     * @param manager 设置RecyclerView对应的manager
     * @param n 要跳转的位置
     */
    public static void MoveToPosition(LinearLayoutManager manager, int n) {
        manager.scrollToPositionWithOffset(n, 0);
        manager.setStackFromEnd(true);
    }

    @Override
    public void showResult(List<ListAppBean> data) {
        initRecyclerView(data);
    }

    @Override
    public void showNoData() {
        Toast.makeText(getActivity(),"暂时无数据,请吃完饭再来",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showError(String message) {
        Toast.makeText(getActivity(),"服务器开小差了:"+message,Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showLoading() {
        mProgressDialog.show();
    }

    @Override
    public void dismissLoading() {
        if (mProgressDialog.isShowing()){
            mProgressDialog.dismiss();
        }
    }
}
