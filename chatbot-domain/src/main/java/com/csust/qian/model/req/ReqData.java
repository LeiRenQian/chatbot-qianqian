package com.csust.qian.model.req;

import com.alibaba.fastjson2.annotation.JSONField;

public class ReqData {
    @JSONField(name = "text")
    private String text;
    @JSONField(name = "image_ids")
    private String[] imageIds = new String[]{};
    @JSONField(name = "mentioned_user_ids")
    private String[] mentionedUserIds = new String[]{};

    public ReqData(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String[] getMentionedUserIds() {
        return mentionedUserIds;
    }

    public void setMentionedUserIds(String[] mentionedUserIds) {
        this.mentionedUserIds = mentionedUserIds;
    }

    public String[] getImageIds() {
        return imageIds;
    }

    public void setImageIds(String[] imageIds) {
        this.imageIds = imageIds;
    }
}
