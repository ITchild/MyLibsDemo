package com.fei.feilibs_1_0_0.base.ac;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.MenuItem;
import android.view.View;

import com.fei.feilibs_1_0_0.utils.StringUtil;

/**
 * 所有Activity的基类 进行一些通用化的操作
 * @author fei
 */
public abstract class BaseActivity extends RxBusBaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayout());
        showActionBarBack();//ActionBar的Back初始化
        initView();
        initData();
        initListener();
    }

    /**
     * 抽象方法 （设置activity的Layout的方法）
     *
     * @return
     */
    protected abstract int initLayout();

    /**
     * ActionBar的back按钮是否显示
     * @return
     */
    protected abstract boolean isBackshow();

    /**
     * ActionBar 的Back按钮的初始化
     */
    private void showActionBarBack() {
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        if (null != actionBar) {
            actionBar.setHomeButtonEnabled(isBackshow());
            actionBar.setDisplayHomeAsUpEnabled(isBackshow());
        }
    }

    /**
     * 抽象方法（初始化View的方法）
     */
    protected abstract void initView();

    /**
     * 初始化数据的方法（非必须实现的方法）
     */
    protected void initData() {

    }

    /**
     * 初始化监听事件的方法（非必须实现的方法）
     */
    protected void initListener() {

    }

    /**
     * 省去类型转换  将此方法写在基类Activity
     */
    protected <T extends View> T findView(int id) {
        return (T) super.findViewById(id);
    }

    /**
     * 跳转Activity
     *
     * @param cls
     */
    protected void JumpToAc(Class cls) {
        Intent intent = new Intent();
        intent.setClass(this, cls);
        startActivity(intent);
    }

    /**
     * antionBar中返回按钮的监听
     *
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * 判断字符串是否为null或空字符
     * @param str
     * @return
     */
    protected boolean isStrEmpty(String str){
        return StringUtil.isEmpty(str);
    }

    /**
     * 得到资源文件中的String字符串
     * @param res
     * @return
     */
    protected String getStr(int res){
        return getResources().getString(res);
    }

    /**
     * 获取资源文件中的颜色值
     * @param res
     * @return
     */
    protected int getRColor(int res){
        return ContextCompat.getColor(this,res);
    }

}
