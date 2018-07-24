package com.tenquare.user.controller;

import entity.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: Shaoyuan Du
 * @Description:
 * @Date: Created in 16:55 2018/7/23
 * @Version:
 */
@ControllerAdvice
public class BaseExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result error(Exception e) {
        e.printStackTrace();
        return new Result(false, 20001, e.getMessage());
    }
}
