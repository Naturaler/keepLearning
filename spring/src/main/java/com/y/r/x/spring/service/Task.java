package com.y.r.x.spring.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * Created by r.x on 2018/10/3.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task<T> {
    private DeferredResult<String> result;
    private T message;
    private Boolean isTimeOut;

    public DeferredResult<String> getResult() {
        return result;
    }

    public void setResult(DeferredResult<String> result) {
        this.result = result;
    }

    public T getMessage() {
        return message;
    }

    public void setMessage(T message) {
        this.message = message;
    }

    public Boolean getTimeOut() {
        return isTimeOut;
    }

    public void setTimeOut(Boolean timeOut) {
        isTimeOut = timeOut;
    }
}
