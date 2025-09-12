package com.csust.qian;

import com.csust.qian.model.aggregates.UnAnsweredQuestionsAggregates;
import com.csust.qian.model.vo.Topics;

import java.io.IOException;
import java.util.List;

public interface IQianApi {
    List<Topics> queryUnAnsweredQuestionsTopicId(String groupId, String cookie, String userId) throws Exception;
    boolean answer(String groupId, String cookie, String topicId, String text) throws IOException, InterruptedException;
}
