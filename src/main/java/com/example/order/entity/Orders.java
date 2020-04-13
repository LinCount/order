package com.example.order.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

//订单实体
public class Orders implements Serializable {
    private String o_id;//订单编号
    private Date o_time;//下单时间
    private Date s_time;//送达时间
    private String s_status;//接送状态
    private String is_send;//是否送达
    private String o_status;//订单状态
    private String p_status;//支付状态
    private BigDecimal o_money;//订单总额
    private String s_address;//送餐地址
    private String remark;//备注

    public String getO_id() {
        return o_id;
    }

    public void setO_id(String o_id) {
        this.o_id = o_id;
    }

    public Date getO_time() {
        return o_time;
    }

    public void setO_time(Date o_time) {
        this.o_time = o_time;
    }

    public Date getS_time() {
        return s_time;
    }

    public void setS_time(Date s_time) {
        this.s_time = s_time;
    }

    public String getS_status() {
        return s_status;
    }

    public void setS_status(String s_status) {
        this.s_status = s_status;
    }

    public String getIs_send() {
        return is_send;
    }

    public void setIs_send(String is_send) {
        this.is_send = is_send;
    }

    public String getO_status() {
        return o_status;
    }

    public void setO_status(String o_status) {
        this.o_status = o_status;
    }

    public String getP_status() {
        return p_status;
    }

    public void setP_status(String p_status) {
        this.p_status = p_status;
    }

    public BigDecimal getO_money() {
        return o_money;
    }

    public void setO_money(BigDecimal o_money) {
        this.o_money = o_money;
    }

    public String getS_address() {
        return s_address;
    }

    public void setS_address(String s_address) {
        this.s_address = s_address;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
