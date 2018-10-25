package com.fei.mylibsdemo.net;

import com.fei.feilibs_1_0_0.net.net_http.DataType;
import com.fei.feilibs_1_0_0.net.net_http.HttpClient;
import com.fei.mylibsdemo.bean.PicBaseBean;

/**
 * @author fei
 * @date on 2018/10/25 0025
 * @describe TODO :
 **/
public class NetClient {

    private static String baseUrl = "http://gank.io/api/data/";


    /**
     * 获取图片资源
     * @return
     */
    public static HttpClient getPic(String url) {
        return new HttpClient.Builder()
                .baseUrl(baseUrl)
                .url(url)
                .bodyType(DataType.JSON_OBJECT, PicBaseBean.class)
                .build();
    }

}
