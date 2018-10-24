package com.fei.mylibsdemo.tabac.fragment;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.fei.feilibs_1_0_0.base.fg.BaseFragment;
import com.fei.feilibs_1_0_0.net.net_http.HttpClient;
import com.fei.feilibs_1_0_0.net.net_http.OnResultListener;
import com.fei.mylibsdemo.R;
import com.orhanobut.logger.Logger;

public class TabHomeFragment extends BaseFragment {

    private Button home_netTest_bt;
    private TextView home_showNet_tv;

    @Override
    protected int initLayout() {
        return R.layout.fragment_tabhome;
    }

    @Override
    protected void initView() {
        home_netTest_bt = findView(R.id.home_netTest_bt);
        home_showNet_tv = findView(R.id.home_showNet_tv);
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
        HttpClient client = new HttpClient.Builder()
                .baseUrl("http://gank.io/api/data/")
                .url("福利/10/1")
                .build();
        client.get(new OnResultListener<String>() {

            @Override
            public void onSuccess(String result) {
                Logger.i(result);
            }

            @Override
            public void onError(int code, String message) {
                Logger.e(message);
            }

            @Override
            public void onFailure(String message) {
                Logger.e(message);
            }
        });
    }
}
