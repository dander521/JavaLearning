package com.miaoshaproject.controller;

import com.miaoshaproject.error.BusinessException;
import com.miaoshaproject.error.EmBusinessError;
import com.miaoshaproject.response.CommonReturnType;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class BaseController {

    public static final String CONTENT_TYPE_FORMED="application/x-www-form-urlencoded";

//    // 定义exceptionhandler 解决exception
//    @ExceptionHandler(Exception.class)
//    @ResponseStatus(HttpStatus.OK)
//    @ResponseBody // 不添加 会寻找本地文件
//    public Object handlerException(HttpServletRequest request, Exception ex) {
//        Map<String, Object> responseData = new HashMap<>();
//        if (ex instanceof BusinessException) {
//            BusinessException businessException = (BusinessException)ex;
//            responseData.put("errCode", businessException.getErrorCode());
//            responseData.put("errMsg", businessException.getErrorMsg());
//        } else {
//            responseData.put("errCode", EmBusinessError.UNKNOW_ERROR.getErrorCode());
//            responseData.put("errMsg", EmBusinessError.UNKNOW_ERROR.getErrorMsg());
//        }
//        ex.printStackTrace();
//        return CommonReturnType.creat(responseData, "fail");
//    }
}
