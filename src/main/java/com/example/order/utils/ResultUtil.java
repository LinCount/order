package com.example.order.utils;

import java.util.Map;

//接口json数据拼接类
public class  ResultUtil<T> {
    private final int code;//数据获取状态码
    private final String message;//运行信息
    private final T data;//返回的数据

    public ResultUtil(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }
}
