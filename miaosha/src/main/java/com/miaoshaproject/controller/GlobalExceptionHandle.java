package com.miaoshaproject.controller;

import com.miaoshaproject.error.BusinessException;
import com.miaoshaproject.error.EmBusinessError;
import com.miaoshaproject.response.CommonReturnType;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandle {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public CommonReturnType doError(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Exception ex) {
        ex.printStackTrace();
        Map<String, Object> responseData = new HashMap<>();
        if (ex instanceof BusinessException) {
            BusinessException businessException = (BusinessException)ex;
            responseData.put("errCode", businessException.getErrorCode());
            responseData.put("errMsg", businessException.getErrorMsg());
        } else if (ex instanceof ServletRequestBindingException) { // 参数缺失 或 错误 405
            responseData.put("errCode", EmBusinessError.PARAMETER_VALIDATION_ERROR.getErrorCode());
            responseData.put("errMsg", "url绑定路由问题");
        } else if (ex instanceof NoHandlerFoundException) { // 404
            responseData.put("errCode", EmBusinessError.PARAMETER_VALIDATION_ERROR.getErrorCode());
            responseData.put("errMsg", "没有找到对应的访问路径");
        } else {
            responseData.put("errCode", EmBusinessError.PARAMETER_VALIDATION_ERROR.getErrorCode());
            responseData.put("errMsg", EmBusinessError.PARAMETER_VALIDATION_ERROR.getErrorMsg());
        }
        return CommonReturnType.creat(responseData,"fail");
    }
}