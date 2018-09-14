package com.fei.feilibs_1_0_0.base.fg;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.fei.feilibs_1_0_0.bean.RxBusMsgBean;
import com.fei.feilibs_1_0_0.rxbus.RxBus;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class RxBusBaseFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
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
    public void onDestroy() {
        super.onDestroy();
        RxBus.getInstance().unSubscribe(this);
    }

}
