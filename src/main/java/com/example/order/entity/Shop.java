package com.example.order.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

//商家实体
public class Shop  implements Serializable {
    private String s_id;//餐馆编号
    private String shopName;//餐馆名称
    private String address;//地址
    private String phone;//联系方式
    private String name;//负责人
    private String licence;//营业照
    private String shopPicture;//商店图片
    private String type;//类型标签
    private String remark;//简介
    private Float star;//评论平均星级
    private Integer sanNumber;//用户浏览次数
    private Integer saleInMoon;//月售量
    private Integer beginDelive;//起送价
    private Set<Preferential> preferSet;//优惠的set集合
    public String getS_id() {
        return s_id;
    }

    public void setS_id(String s_id) {
        this.s_id = s_id;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLicence() {
        return licence;
    }

    public void setLicence(String licence) {
        this.licence = licence;
    }

    public String getShopPicture() {
        return shopPicture;
    }

    public void setShopPicture(String shopPicture) {
        this.shopPicture = shopPicture;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Float getStar() {
        return star;
    }

    public void setStar(Float star) {
        this.star = star;
    }

    public Integer getSanNumber() {
        return sanNumber;
    }

    public void setSanNumber(Integer sanNumber) {
        this.sanNumber = sanNumber;
    }

    public Integer getSaleInMoon() {
        return saleInMoon;
    }

    public void setSaleInMoon(Integer saleInMoon) {
        this.saleInMoon = saleInMoon;
    }

    public Integer getBeginDelive() {
        return beginDelive;
    }

    public void setBeginDelive(Integer beginDelive) {
        this.beginDelive = beginDelive;
    }

    public Set<Preferential> getPreferSet() {
        return preferSet;
    }

    public void setPreferSet(Set<Preferential> preferSet) {
        this.preferSet = preferSet;
    }
}
