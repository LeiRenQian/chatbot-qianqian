package com.csust.qian.model.aggregates;

import com.alibaba.fastjson2.annotation.JSONField;
import com.csust.qian.model.res.RespData;

public class UnAnsweredQuestionsAggregates {
    @JSONField(name = "succeeded")
    private boolean succeeded;
    @JSONField(name = "resp_data")
    private RespData respData;

    public boolean isSucceeded() {
        return succeeded;
    }

    public void setSucceeded(boolean succeeded) {
        this.succeeded = succeeded;
    }

    public RespData getRespData() {
        return respData;
    }

    public void setRespData(RespData respData) {
        this.respData = respData;
    }
}
