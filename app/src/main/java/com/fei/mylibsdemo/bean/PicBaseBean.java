package com.fei.mylibsdemo.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fei
 * @date on 2018/10/25 0025
 * @describe TODO :
 **/
public class PicBaseBean {
    private boolean error;
    private List<PicBean> results;

    public boolean isError() {
        //其它类型返回字段值本身
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<PicBean> getResults() {
        //如果是List类型，而且为空时返回一个新建的空列表，否则返回字段值本身
        if (results == null) {
            return new ArrayList<>();
        }
        return results;
    }

    public void setResults(List<PicBean> results) {
        this.results = results;
    }
}
