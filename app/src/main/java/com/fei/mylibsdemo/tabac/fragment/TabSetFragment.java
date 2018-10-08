package com.fei.mylibsdemo.tabac.fragment;

import android.view.View;

import com.fei.feilibs_1_0_0.base.fg.BaseFragment;
import com.fei.mylibsdemo.DialogActivity;
import com.fei.mylibsdemo.R;
import com.fei.mylibsdemo.tabac.TabActivity;

public class TabSetFragment extends BaseFragment implements View.OnClickListener{
    @Override
    protected void initView() {

    }

    @Override
    protected void initListener() {
        super.initListener();
        findView(R.id.set_dialog_bt).setOnClickListener(this);
    }

    @Override
    protected int initLayout() {
        return R.layout.fragment_tabset;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.set_dialog_bt :
                if(null != getActivity() && getActivity() instanceof TabActivity){
                    ((TabActivity)getActivity()).JumpToAct(DialogActivity.class);
                }
                break;
        }
    }
}
