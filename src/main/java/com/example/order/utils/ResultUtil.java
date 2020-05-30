package com.example.order.utils;

import java.util.List;
import java.util.Map;

//接口json数据拼接类
public class  ResultUtil<T> {
    private final int code;//数据获取状态码
    private final String message;//运行信息
    private final T data;//返回的数据
    private final List<T> dataList;
    public ResultUtil(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.dataList=null;
    }
    public ResultUtil(int code, String message, List<T> data) {
        this.code = code;
        this.message = message;
        this.data=null;
        this.dataList=data;
    }
    public ResultUtil(int state, T data) {
        if(state==1){
            this.code = 200;
            this.message ="获取成功";
        }else {
            this.code = 202;
            this.message ="失败成功";
        }
        this.data = data;
        this.dataList=null;
    }
    public ResultUtil(int state, List<T> data) {
        if(state==1){
            this.code = 200;
            this.message ="获取成功";
        }else {
            this.code = 202;
            this.message ="失败成功";
        }
        this.data = null;
        this.dataList=data;
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

    public List<T> getDataList() {
        return dataList;
    }
}
