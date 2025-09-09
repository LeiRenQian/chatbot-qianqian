package com.csust;

import jdk.internal.net.http.HttpClientBuilderImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.http.client.JdkHttpClientBuilder;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class ApiTest {
    @Test
    public void query_unanswered_questions() throws IOException, InterruptedException {

        HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .connectTimeout(Duration.ofSeconds(10))
                .followRedirects(HttpClient.Redirect.NORMAL)
                .build();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create("https://api.zsxq.com/v2/groups/28885518425541/topics?scope=all&count=1"))
                .GET()
                .header("accept", "application/json, text/plain, */*")
                .header("cookie", "zsxq_access_token=A42019D3-AB77-425B-B509-EFE2E5356433_97508E7F9EDA2189; abtest_env=product")
                .build();


        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        if (httpResponse.statusCode() == HttpURLConnection.HTTP_OK){
            String body = httpResponse.body();
            System.out.println(body);
        }else {
            System.out.println(httpResponse.statusCode());
        }

    }
    @Test
    public void answer() throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .connectTimeout(Duration.ofSeconds(10))
                .followRedirects(HttpClient.Redirect.NORMAL)
                .build();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create("https://api.zsxq.com/v2/topics/8854588124125212/comments"))
                .POST(HttpRequest.BodyPublishers.ofString("{\n" +
                        "  \"req_data\": {\n" +
                        "    \"text\": \"你还好吗？\\n\",\n" +
                        "    \"image_ids\": [],\n" +
                        "    \"mentioned_user_ids\": []\n" +
                        "  }\n" +
                        "}"))
                .header("accept", "application/json, text/plain, */*")
                .header("cookie", "zsxq_access_token=A42019D3-AB77-425B-B509-EFE2E5356433_97508E7F9EDA2189; abtest_env=product")
                .build();


        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        if (httpResponse.statusCode() == HttpURLConnection.HTTP_OK){
            String body = httpResponse.body();
            System.out.println(body);
        }else {
            System.out.println(httpResponse.statusCode());
        }
    }
}
