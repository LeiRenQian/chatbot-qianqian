package com.csust.qian.model.vo;

import com.alibaba.fastjson2.annotation.JSONField;

public class Owner {
    @JSONField(name = "user_id")
    private String userId;
    @JSONField(name = "name")
    private String name;
    @JSONField(name = "avatar_url")
    private String avatarUrl;
    @JSONField(name = "location")
    private String location;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
