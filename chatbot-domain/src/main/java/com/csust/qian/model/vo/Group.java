package com.csust.qian.model.vo;

import com.alibaba.fastjson2.annotation.JSONField;

public class Group {
    @JSONField(name = "group_id")
    private long groupId;
    @JSONField(name = "name")
    private String name;
    @JSONField(name = "type")
    private String type;
    @JSONField(name = "background_url")
    private String backgroundUrl;

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBackgroundUrl() {
        return backgroundUrl;
    }

    public void setBackgroundUrl(String backgroundUrl) {
        this.backgroundUrl = backgroundUrl;
    }
}