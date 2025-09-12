package com.csust.qian.model.vo;

import com.alibaba.fastjson2.annotation.JSONField;

import java.util.Date;
import java.util.List;

public class Topics {
    @JSONField(name = "topic_id")
    private long topicId;
    @JSONField(name = "group")
    private Group group;
    @JSONField(name = "type")
    private String type;
    @JSONField(name = "talk")
    private Talk talk;
    @JSONField(name = "show_comments")
    private List<Show_comments> showComments;
    @JSONField(name = "likes_count")
    private int likesCount;
    @JSONField(name = "tourist_likes_count")
    private int touristLikesCount;
    @JSONField(name = "rewards_count")
    private int rewardsCount;
    @JSONField(name = "comments_count")
    private int commentsCount;
    @JSONField(name = "reading_count")
    private int readingCount;
    @JSONField(name = "readers_count")
    private int readersCount;
    @JSONField(name = "digested")
    private boolean digested;
    @JSONField(name = "sticky")
    private boolean sticky;
    @JSONField(name = "create_time")
    private Date createTime;
    @JSONField(name = "user_specific")
    private UserSpecific userSpecific;
    @JSONField(name = "title")
    private String title;

    public long getTopicId() {
        return topicId;
    }

    public void setTopicId(long topicId) {
        this.topicId = topicId;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Talk getTalk() {
        return talk;
    }

    public void setTalk(Talk talk) {
        this.talk = talk;
    }

    public List<Show_comments> getShowComments() {
        return showComments;
    }

    public void setShowComments(List<Show_comments> showComments) {
        this.showComments = showComments;
    }

    public int getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(int likesCount) {
        this.likesCount = likesCount;
    }

    public int getTouristLikesCount() {
        return touristLikesCount;
    }

    public void setTouristLikesCount(int touristLikesCount) {
        this.touristLikesCount = touristLikesCount;
    }

    public int getRewardsCount() {
        return rewardsCount;
    }

    public void setRewardsCount(int rewardsCount) {
        this.rewardsCount = rewardsCount;
    }

    public int getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(int commentsCount) {
        this.commentsCount = commentsCount;
    }

    public int getReadingCount() {
        return readingCount;
    }

    public void setReadingCount(int readingCount) {
        this.readingCount = readingCount;
    }

    public int getReadersCount() {
        return readersCount;
    }

    public void setReadersCount(int readersCount) {
        this.readersCount = readersCount;
    }

    public boolean isDigested() {
        return digested;
    }

    public void setDigested(boolean digested) {
        this.digested = digested;
    }

    public boolean isSticky() {
        return sticky;
    }

    public void setSticky(boolean sticky) {
        this.sticky = sticky;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public UserSpecific getUserSpecific() {
        return userSpecific;
    }

    public void setUserSpecific(UserSpecific userSpecific) {
        this.userSpecific = userSpecific;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}