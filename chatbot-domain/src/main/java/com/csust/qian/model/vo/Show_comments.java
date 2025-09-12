package com.csust.qian.model.vo;

import com.alibaba.fastjson2.annotation.JSONField;

import java.util.Date;

public class Show_comments {
    @JSONField(name = "comment_id")
    private long commentId;
    @JSONField(name = "create_time")
    private Date createTime;
    @JSONField(name = "owner")
    private Owner owner;
    @JSONField(name = "text")
    private String text;
    @JSONField(name = "likes_count")
    private int likesCount;
    @JSONField(name = "rewards_count")
    private int rewardsCount;
    @JSONField(name = "sticky")
    private boolean sticky;

    public long getCommentId() {
        return commentId;
    }

    public void setCommentId(long commentId) {
        this.commentId = commentId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(int likesCount) {
        this.likesCount = likesCount;
    }

    public int getRewardsCount() {
        return rewardsCount;
    }

    public void setRewardsCount(int rewardsCount) {
        this.rewardsCount = rewardsCount;
    }

    public boolean isSticky() {
        return sticky;
    }

    public void setSticky(boolean sticky) {
        this.sticky = sticky;
    }
}
