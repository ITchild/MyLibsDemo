package com.fei.feilibs_1_0_0.base.fg;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fei.feilibs_1_0_0.bean.RxBusMsgBean;
import com.fei.feilibs_1_0_0.rxbus.RxBus;
import com.fei.feilibs_1_0_0.utils.StringUtil;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public abstract class BaseFragment extends Fragment {
    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(initLayout(), container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        initData();
        initListener();
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
     * 抽象方法 （设置fragment的Layout的方法）
     *
     * @return
     */
    protected abstract int initLayout();

    /**
     * 省去类型转换  将此方法写在基类Fragment
     */
    protected <T extends View> T findView(int id) {
        return (T) view.findViewById(id);
    }

    /**
     * 判断字符串是否为null或空字符
     *
     * @param str
     * @return
     */
    protected boolean isStrEmpty(String str) {
        return StringUtil.isEmpty(str);
    }

    /**
     * 得到资源文件中的字符串
     *
     * @param res
     * @return
     */
    protected String getStr(int res) {
        return null != getActivity() ? getActivity().getResources().getString(res) : "";
    }

    /**
     * 获取资源文件中的颜色值
     *
     * @param res
     * @return
     */
    protected int getRColor(int res) {
        return null != getActivity() ? ContextCompat.getColor(getActivity(), res) : 0;
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
    protected void unSubscribeRxBus(Context context){
        RxBus.getInstance().unSubscribe(context);
    }

}
