package com.fei.feilibs_1_0_0.net.net_http;

/**
 * @author fei
 * @date on 2018/10/24 0024
 * @describe TODO :
 **/
public class OnResultListener<T> {

    /**
     * 请求成功的情况
     *
     * @param result 需要解析的解析类
     */
    public void onSuccess(T result) {
    }

    /**
     * 响应成功，但是出错的情况
     *
     * @param code    错误码
     * @param message 错误信息
     */
//    public void onError(int code, String message) {
//    }

    /**
     * 请求失败的情况
     * @param code    错误码
     * @param message 失败信息
     */
    public void onFailure(int code,String message) {
    }

}