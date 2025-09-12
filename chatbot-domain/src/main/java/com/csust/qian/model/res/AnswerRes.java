package com.csust.qian.model.res;

public class AnswerRes {
    private boolean succeeded;

    public AnswerRes(boolean succeeded) {
        this.succeeded = succeeded;
    }

    public boolean isSucceeded() {
        return succeeded;
    }

    public void setSucceeded(boolean succeeded) {
        this.succeeded = succeeded;
    }
}
