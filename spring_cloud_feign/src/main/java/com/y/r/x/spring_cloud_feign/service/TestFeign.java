package com.y.r.x.spring_cloud_feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by r.x on 2018/10/8.
 */
@FeignClient("eureka-client2")
public interface TestFeign {

    @GetMapping("/port")
    String testFeign();
}
