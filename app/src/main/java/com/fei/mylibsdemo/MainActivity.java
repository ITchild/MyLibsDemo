package com.fei.mylibsdemo;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.fei.feilibs_1_0_0.bean.RxBusMsgBean;
import com.fei.feilibs_1_0_0.base.ac.BaseActivity;
import com.fei.feilibs_1_0_0.rxbus.RxBus;
import com.fei.mylibsdemo.tabac.TabActivity;

public class MainActivity extends BaseActivity implements View.OnClickListener{

    private Button main_bt;
    private TextView main_tv;
    private final int MSG_WHAT = 1000;

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected boolean isBackshow() {
        return false;
    }

    @Override
    protected void initView() {
        main_bt = findView(R.id.main_bt);
        main_tv = findView(R.id.main_tv);
    }

    @Override
    protected void initListener() {
        super.initListener();
        main_bt.setOnClickListener(this);
        findView(R.id.main_dialogAc_bt).setOnClickListener(this);
        findView(R.id.main_tabAc_bt).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.main_bt :
                RxBusMsgBean busMsgBean = new RxBusMsgBean();
                busMsgBean.setWhat(MSG_WHAT);
                busMsgBean.setMsg("这是RxBus发送的消息");
                RxBus.getInstance().post(busMsgBean);
                break;
            case R.id.main_dialogAc_bt :
                JumpToAc(DialogActivity.class);
                break;
            case R.id.main_tabAc_bt :
                JumpToAc(TabActivity.class);
                break;
        }
    }

    @Override
    protected void doRxBus(RxBusMsgBean bean) {
        super.doRxBus(bean);
        if(null == bean){
            return;
        }
        switch (bean.getWhat()){
            case MSG_WHAT :
                if(null != main_tv){
                    main_tv.setText(isStrEmpty(bean.getMsg())? "" : bean.getMsg());
                }
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        subScribeRxbus(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unSubscribeRxBus(this);
    }
}
