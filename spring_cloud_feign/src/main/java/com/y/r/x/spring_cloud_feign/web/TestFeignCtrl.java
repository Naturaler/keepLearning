package com.y.r.x.spring_cloud_feign.web;

import com.y.r.x.spring_cloud_feign.service.TestFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by r.x on 2018/10/8.
 */
@RestController
public class TestFeignCtrl {

    @Autowired
    private TestFeign feign;

    @GetMapping("/testFeign")
    public String testFeign() {
        return feign.testFeign();
    }
}
