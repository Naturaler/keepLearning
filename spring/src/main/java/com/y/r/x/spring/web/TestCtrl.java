package com.y.r.x.spring.web;

import com.y.r.x.spring.service.MockQueue;
import com.y.r.x.spring.service.Task;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.Callable;

/**
 * Created by r.x on 2018/9/27.
 */
@RestController
@Slf4j
public class TestCtrl {
    @Autowired
    private MockQueue mockQueue;

    @GetMapping("/test")
    public String test() {
        return "hello world !";
    }

    @GetMapping("/callable")
    public Callable<String> callable() {
        System.out.println("主线程开启");
        Callable<String> result = () -> {
            System.out.println("子线程开启");
            Thread.sleep(3000);
            System.out.println("子线程结束");
            return "sleep";
        };
        System.out.println("主线程结束");
        return result;
    }

    @GetMapping("/task")
    public DeferredResult<String> task() throws InterruptedException {
        DeferredResult<String> result = new DeferredResult<>(4000L);
        Task<String> task = new Task<>();
        task.setMessage("异步任务");
        task.setResult(result);
        task.setTimeOut(false);
        result.onTimeout(() -> {
            System.out.println("DeferredResult 任务超时");
            task.setTimeOut(true);
            result.setErrorResult("任务超时");
        });
        mockQueue.put(task);
        return result;
    }
}
