package com.y.r.x.spring.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by r.x on 2018/10/3.
 */
@Component
@Slf4j
public class MockQueue {
    private BlockingQueue<Task<String>> receiveQueue = new LinkedBlockingDeque<>();
    private BlockingQueue<Task<String>> completeQueue = new LinkedBlockingDeque<>();

    public void put(Task<String> task) throws InterruptedException {
        receiveQueue.put(task);
    }

    public Task<String> get() throws InterruptedException {
        return completeQueue.take();
    }

    private void execute() {
        new Thread(() -> {
            while (true) {
                try {
                    Task<String> task = receiveQueue.take();
                    System.out.println("开始处理任务" + new Date().getTime());
                    Thread.sleep(3000);
                    task.setMessage("完成任务");
                    if (task.getTimeOut()) {
                        System.out.println("任务超时");
                        continue;
                    }
                    System.out.println("完成任务");
                    System.out.println("结束处理任务" + new Date().getTime());
                    completeQueue.put(task);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public MockQueue() {
        execute();
    }
}
