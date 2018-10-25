package com.fei.mylibsdemo.tabac.fragment;

import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;

import com.fei.feilibs_1_0_0.base.fg.BaseFragment;
import com.fei.feilibs_1_0_0.net.net_http.OnResultListener;
import com.fei.mylibsdemo.R;
import com.fei.mylibsdemo.bean.PicBaseBean;
import com.fei.mylibsdemo.bean.PicBean;
import com.fei.mylibsdemo.net.NetClient;
import com.fei.mylibsdemo.tabac.adapter.PicShowAdapter;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

public class TabHomeFragment extends BaseFragment {

    private Button home_netTest_bt;
    private EasyRecyclerView home_showNet_erv;
    private PicShowAdapter mShowAdapter;
    private List<String> data;

    @Override
    protected int initLayout() {
        return R.layout.fragment_tabhome;
    }

    @Override
    protected void initView() {
        home_netTest_bt = findView(R.id.home_netTest_bt);
        home_showNet_erv = findView(R.id.home_showNet_erv);
    }

    @Override
    protected void initData() {
        super.initData();
        if(null == data){
            data = new ArrayList<>();
        }
        mShowAdapter = new PicShowAdapter(getContext(),data);
        home_showNet_erv.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        home_showNet_erv.setAdapter(mShowAdapter);
    }

    @Override
    protected void initListener() {
        super.initListener();
        home_netTest_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                netTest();
            }
        });
    }

    /**
     * 进行网络的测试访问
     */
    private void netTest() {
        NetClient.getPic("福利/100/1").post(new OnResultListener<PicBaseBean>() {
            @Override
            public void onSuccess(PicBaseBean result) {
                data.clear();
                for (PicBean bean : result.getResults()){
                    data.add(bean.getUrl());
                }
                mShowAdapter.setData(data);
            }

            @Override
            public void onFailure(int code, String message) {
                Logger.e(message);
            }
        });
    }
}
