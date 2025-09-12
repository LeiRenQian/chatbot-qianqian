package com.csust.qian.model.vo;

import com.alibaba.fastjson2.annotation.JSONField;

public class Talk {
    @JSONField(name = "owner")
    private Owner owner;
    @JSONField(name = "text")
    private String text;
    public void setOwner(Owner owner) {
        this.owner = owner;
    }
    public Owner getOwner() {
        return owner;
    }

    public void setText(String text) {
        this.text = text;
    }
    public String getText() {
        return text;
    }

}
