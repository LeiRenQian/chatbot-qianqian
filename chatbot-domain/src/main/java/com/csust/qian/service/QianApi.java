package com.csust.qian.service;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.csust.qian.IQianApi;
import com.csust.qian.model.aggregates.UnAnsweredQuestionsAggregates;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import com.csust.qian.model.req.AnswerReq;
import com.csust.qian.model.req.ReqData;
import com.csust.qian.model.res.AnswerRes;
import com.csust.qian.model.res.RespData;
import com.csust.qian.model.vo.Topics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class QianApi implements IQianApi {
    private Logger logger = LoggerFactory.getLogger(QianApi.class);
/*
* 目的：获取特定社群groupId中某个用户userId（就是我自己）的所有未回答问题
* */
    @Override
    public List<Topics> queryUnAnsweredQuestionsTopicId(String groupId, String cookie, String userId) throws Exception {
        List<Topics> topics = new ArrayList<>();
        HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .connectTimeout(Duration.ofSeconds(10))
                .followRedirects(HttpClient.Redirect.NORMAL)
                .build();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create("https://api.zsxq.com/v2/groups/" + groupId + "/topics?scope=all&count=20"))
                .GET()
                .header("accept", "application/json, text/plain, */*")
                .header("cookie", cookie)
                .build();


        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        if (httpResponse.statusCode() == HttpURLConnection.HTTP_OK){
            String jsonBody = httpResponse.body();
            logger.info("拉取提问数据，groupId:{} jsonBody:{}", groupId, jsonBody);
            UnAnsweredQuestionsAggregates unAnsweredQuestionsAggregates = JSON.parseObject(jsonBody, UnAnsweredQuestionsAggregates.class);
            RespData respData = unAnsweredQuestionsAggregates.getRespData();
            List<Topics> tempTopics = respData.getTopics();
            for (Topics topic : tempTopics) {
                if (topic.getTalk().getOwner().getUserId().equals(userId)){
                    topics.add(topic);
                }
            }
            return topics;
        }else {
            throw new RuntimeException("queryUnAnsweredQuestionsTopicId Err Code is " + httpResponse.statusCode());
        }
    }
/*
* 回答所有topic问题
* */
    @Override
    public boolean answer(String groupId, String cookie, String topicId, String text) throws IOException, InterruptedException {
        AnswerReq answerReq = new AnswerReq(new ReqData(text));
        String paramJson = JSONObject.from(answerReq).toString();
        System.out.println("paramJson:" + paramJson);

        HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .connectTimeout(Duration.ofSeconds(10))
                .followRedirects(HttpClient.Redirect.NORMAL)
                .build();
//        HttpRequest httpRequest = HttpRequest.newBuilder()
//                .uri(URI.create("https://api.zsxq.com/v2/topics/" + topicId + "/comments"))
//                .POST(HttpRequest.BodyPublishers.ofString("{\n" +
//                        "  \"req_data\": {\n" +
//                        "    \"text\": \"愿此行终抵群星\\n\",\n" +
//                        "    \"image_ids\": [],\n" +
//                        "    \"mentioned_user_ids\": []\n" +
//                        "  }\n" +
//                        "}"))
//                .header("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/139.0.0.0 Safari/537.36")
//                .header("accept", "application/json, text/plain, */*")
//                .header("cookie", cookie)
//                .build();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create("https://api.zsxq.com/v2/topics/" + topicId + "/comments"))
                .POST(HttpRequest.BodyPublishers.ofString(paramJson))
                .header("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/139.0.0.0 Safari/537.36")
                .header("accept", "application/json, text/plain, */*")
                .header("cookie", cookie)
                .build();

        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        if (httpResponse.statusCode() == HttpURLConnection.HTTP_OK){
            String jsonBody = httpResponse.body();
            logger.info("回答星球问题结果，uid{} topicId:{} jsonStr:{}", groupId, topicId, jsonBody);
            AnswerRes answerRes = JSON.parseObject(jsonBody, AnswerRes.class);
            return answerRes.isSucceeded();
        }else {
            throw new RuntimeException("answer Err Code is " + httpResponse.statusCode());
        }
    }
}
