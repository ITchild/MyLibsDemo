package com.fei.feilibs_1_0_0.base.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.fei.feilibs_1_0_0.bean.RxBusMsgBean;
import com.fei.feilibs_1_0_0.rxbus.RxBus;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * @author fei
 * 消息RxBus的注册和解除注册
 */

public class RxBusBaseDialog extends Dialog {

    public RxBusBaseDialog(@NonNull Context context) {
        super(context);
    }

    public RxBusBaseDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected RxBusBaseDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Disposable register = RxBus.getInstance().register(RxBusMsgBean.class, new Consumer<RxBusMsgBean>() {
            @Override
            public void accept(@NonNull RxBusMsgBean msgBean) {
                /**这个地方获取到数据。并执行相应的操作*/
                doRxBus(msgBean);
            }
        });
        RxBus.getInstance().addSubscription(this,register);
    }

    /**
     * 数据返回的处理
     * @param bean
     */
    protected void doRxBus(@NonNull RxBusMsgBean bean){

    }

    @Override
    protected void onStop() {
        super.onStop();
        RxBus.getInstance().unSubscribe(this);
    }
}
