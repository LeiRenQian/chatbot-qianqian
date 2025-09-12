package com.csust.qian.model.vo;

import com.alibaba.fastjson2.annotation.JSONField;

import java.util.List;

public class UserSpecific {
    @JSONField(name = "liked")
    private boolean liked;
    @JSONField(name = "liked_emojis")
    private List<String> likedEmojis;
    @JSONField(name = "subscribed")
    private boolean subscribed;

    public boolean isLiked() {
        return liked;
    }

    public void setLiked(boolean liked) {
        this.liked = liked;
    }

    public List<String> getLikedEmojis() {
        return likedEmojis;
    }

    public void setLikedEmojis(List<String> likedEmojis) {
        this.likedEmojis = likedEmojis;
    }

    public boolean isSubscribed() {
        return subscribed;
    }

    public void setSubscribed(boolean subscribed) {
        this.subscribed = subscribed;
    }
}
