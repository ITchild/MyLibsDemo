package com.fei.mylibsdemo.bean;

/**
 * @author fei
 * @date on 2018/10/25 0025
 * @describe TODO :
 **/
public class PicBean {
    private String _id;
    private String createdAt;
    private String desc;
    private String publishedAt;
    private String source;
    private String type;
    private String url;
    private String used;
    private String who;


    public String get_id() {
        //如果是String类型，那么判断是否为空，为空返回"",否则返回字段值本身
        return _id == null ? "" : _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getCreatedAt() {
        //如果是String类型，那么判断是否为空，为空返回"",否则返回字段值本身
        return createdAt == null ? "" : createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getDesc() {
        //如果是String类型，那么判断是否为空，为空返回"",否则返回字段值本身
        return desc == null ? "" : desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPublishedAt() {
        //如果是String类型，那么判断是否为空，为空返回"",否则返回字段值本身
        return publishedAt == null ? "" : publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getSource() {
        //如果是String类型，那么判断是否为空，为空返回"",否则返回字段值本身
        return source == null ? "" : source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getType() {
        //如果是String类型，那么判断是否为空，为空返回"",否则返回字段值本身
        return type == null ? "" : type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        //如果是String类型，那么判断是否为空，为空返回"",否则返回字段值本身
        return url == null ? "" : url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsed() {
        //如果是String类型，那么判断是否为空，为空返回"",否则返回字段值本身
        return used == null ? "" : used;
    }

    public void setUsed(String used) {
        this.used = used;
    }

    public String getWho() {
        //如果是String类型，那么判断是否为空，为空返回"",否则返回字段值本身
        return who == null ? "" : who;
    }

    public void setWho(String who) {
        this.who = who;
    }
}
