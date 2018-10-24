package com.fei.feilibs_1_0_0.base.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.View;

import com.fei.feilibs_1_0_0.bean.RxBusMsgBean;
import com.fei.feilibs_1_0_0.rxbus.RxBus;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public abstract class BaseDialog extends Dialog {
    protected Context mContext;

    protected BaseDialog(@NonNull Context context) {
        super(context);
        mContext = context;
    }

    protected BaseDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        mContext = context;
    }

    protected BaseDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        mContext = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayout());
        initView();
        initData();
        initListener();
    }
    /**
     * 设置布局资源文件
     * @return
     */
    protected abstract int setLayout();

    /**
     * 省去类型转换  将此方法写在基类Dialog
     */
    protected <T extends View> T findView(int id) {
        return (T) findViewById(id);
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
     * 获取资源文件中的字符串
     *
     * @param res
     * @return
     */
    protected String getStr(int res) {
        return null != mContext ? mContext.getResources().getString(res) : "";
    }

    /**
     * 获取资源文件中的颜色值
     * @param res
     * @return
     */
    protected int getRColor(int res) {
        return null != mContext ? ContextCompat.getColor(mContext, res) : 0;
    }


    protected void subScribeRxbus(Context context){
        Disposable register = RxBus.getInstance().register(RxBusMsgBean.class, new Consumer<RxBusMsgBean>() {
            @Override
            public void accept(@NonNull RxBusMsgBean msgBean) {
                /**这个地方获取到数据。并执行相应的操作*/
                doRxBus(msgBean);
            }
        });
        RxBus.getInstance().addSubscription(context,register);
    }

    /**
     * 数据返回的处理
     * @param bean
     */
    protected void doRxBus(@NonNull RxBusMsgBean bean){

    }

    /**
     * 取消订阅RxBus
     */
    protected void unSubscribeRxBus(Context context){
        RxBus.getInstance().unSubscribe(context);
    }
}
