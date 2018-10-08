package com.y.r.x.spring_cloud_client.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by r.x on 2018/10/8.
 */
@RestController
public class TestClient {
    @Value("${server.port}")
    private String port;

    @GetMapping("/port")
    public String getPort() {
        return "port:{" + port + "}";
    }
}
