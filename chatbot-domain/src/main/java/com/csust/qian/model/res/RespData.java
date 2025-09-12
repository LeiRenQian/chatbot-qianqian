package com.csust.qian.model.res;

import com.alibaba.fastjson2.annotation.JSONField;
import com.csust.qian.model.vo.Topics;

import java.util.List;

public class RespData {
    @JSONField(name = "topics")
    private List<Topics> topics;

    public void setTopics(List<Topics> topics) {
        this.topics = topics;
    }
    public List<Topics> getTopics() {
        return topics;
    }
}