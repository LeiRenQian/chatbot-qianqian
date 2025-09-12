package com.csust;

import com.alibaba.fastjson2.JSON;
import com.csust.qian.IQianApi;
import com.csust.qian.model.aggregates.UnAnsweredQuestionsAggregates;
import com.csust.qian.model.vo.Topics;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class SpringBootRunTest {
    private Logger logger = LoggerFactory.getLogger(SpringBootRunTest.class);
    @Value("${chatbot-qianqian.groupId}")
    private String groupId;
    @Value("${chatbot-qianqian.cookie}")
    private String cookie;
    @Resource
    private IQianApi qianApi;

    @Test
    public void test_qianApi() throws Exception {
        List<Topics> topics = qianApi.queryUnAnsweredQuestionsTopicId(groupId, cookie, "184242521441182");
        for (Topics topic : topics) {
            System.out.println(topic);
            String topid_id = String.valueOf(topic.getTopicId());
            String text = topic.getTitle();

            logger.info("topicId: {} text: {}", topid_id, text);
//            回答问题
            qianApi.answer(groupId, cookie, topid_id, text);
        }
    }
}
