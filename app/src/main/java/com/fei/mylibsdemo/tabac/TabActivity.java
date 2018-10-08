package com.fei.mylibsdemo.tabac;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.fei.feilibs_1_0_0.base.ac.BaseActivity;
import com.fei.mylibsdemo.R;
import com.fei.mylibsdemo.tabac.fragment.TabHomeFragment;
import com.fei.mylibsdemo.tabac.fragment.TabSetFragment;
import com.fei.mylibsdemo.tabac.fragment.TabViewFragment;

public class TabActivity extends BaseActivity {
    private RadioGroup tab_tabs_rg;
    private RadioButton tab_home_rb;
    private RadioButton tab_view_rb;
    private RadioButton tab_set_rb;

    private Fragment currentFragment = new Fragment();
    private Fragment homeFragment;
    private Fragment viewFragment;
    private Fragment setFragment;


    @Override
    protected int initLayout() {
        return R.layout.activity_tabac;
    }

    @Override
    protected boolean isBackshow() {
        return true;
    }

    @Override
    protected void initView() {
        tab_tabs_rg = findView(R.id.tab_tabs_rg);
        tab_home_rb = findView(R.id.tab_home_rb);
        tab_view_rb = findView(R.id.tab_view_rb);
        tab_set_rb = findView(R.id.tab_set_rb);

        if (null == homeFragment) {
            homeFragment = new TabHomeFragment();
        }
        switchFragment(homeFragment);
    }

    @Override
    protected void initListener() {
        super.initListener();
        tab_tabs_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.tab_home_rb: //首页
                        if (null == homeFragment) {
                            homeFragment = new TabHomeFragment();
                        }
                        switchFragment(homeFragment);
                        break;
                    case R.id.tab_view_rb://视图
                        if (null == viewFragment) {
                            viewFragment = new TabViewFragment();
                        }
                        switchFragment(viewFragment);
                        break;
                    case R.id.tab_set_rb://设置
                        if (null == setFragment) {
                            setFragment = new TabSetFragment();
                        }
                        switchFragment(setFragment);
                        break;
                }
            }
        });
    }

    private void switchFragment(Fragment targetFragment) {
        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction();
        if (!targetFragment.isAdded()) {//第一次使用switchFragment()时currentFragment为null，所以要判断一下
            if (currentFragment != null) {
                transaction.hide(currentFragment);
            }
            transaction.add(R.id.tab_Cont_fl, targetFragment, targetFragment.getClass().getName());
        } else {
            transaction.hide(currentFragment).show(targetFragment);
        }
        currentFragment = targetFragment;
        transaction.commit();
    }

    public void JumpToAct(Class cls){
        JumpToAc(cls);
    }
}
