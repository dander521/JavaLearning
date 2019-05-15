package com.miaoshaproject.response;

public class CommonReturnType {

    private String status;
    private Object data;


    public static CommonReturnType creat(Object result) {
        return CommonReturnType.creat(result, "Success");
    }

    public static CommonReturnType creat(Object result, String status) {
        CommonReturnType commonReturnType = new CommonReturnType();
        commonReturnType.setData(result);
        commonReturnType.setStatus(status);
        return commonReturnType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
