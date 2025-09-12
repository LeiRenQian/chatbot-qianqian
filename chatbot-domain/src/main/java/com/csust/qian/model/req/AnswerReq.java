package com.csust.qian.model.req;

import com.alibaba.fastjson2.annotation.JSONField;

public class AnswerReq {
    @JSONField(name = "req_data")
    private ReqData reqData;

    public AnswerReq(ReqData reqData) {
        this.reqData = reqData;
    }

    public ReqData getReqData() {
        return reqData;
    }

    public void setReqData(ReqData reqData) {
        this.reqData = reqData;
    }
}
