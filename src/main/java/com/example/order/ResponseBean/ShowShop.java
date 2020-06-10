package com.example.order.ResponseBean;

import com.example.order.entity.Preferential;
import com.example.order.entity.Shop;

import java.util.Arrays;

public class ShowShop {
    public String id;//商店id
    public String img;//图片路径
    public String shopname;//商店名称
    public Object[] info=new Object[3];//info[0].评论星级 info[1].月售量 info[2]起送价
    public Object[] label;//类型标签
    public String[] activities=new String[10];//activities[0],activities[1],activities[2]优惠活动标签最多三个

    public ShowShop(Shop shop) {
        this.id=shop.getS_id();
        this.img=shop.getShopPicture();
        this.shopname=shop.getName();
        this.info[0]=shop.getStar();
        this.info[1]=shop.getSaleInMoon();
        this.info[2]=shop.getBeginDelive();
        String[] index=shop.getType().split(",");
        if (null==index) {
           String[] a=new String[1];
           a[1]=null;
           this.label=a;
        }else {
            this.label=index;
        }
        if(shop.getPreferSet().isEmpty()){
            this.activities=null;
        }else {
            if(shop.getPreferSet().size()<=3){
                int  i=0;
                for (Preferential pre:shop.getPreferSet()) {
                    this.activities[i]="满"+pre.getFull()+" 减"+pre.getBackUser();
                    i++;
                }
                String[] change=new String[i];
                for(i=i-1;i>=0;i--){
                    change[i]=this.activities[i];
                }
                this.activities=change;
            }
        }
    }

    @Override
    public String toString() {
        return "ShowShop{" +
                "id='" + id + '\'' +
                ", img='" + img + '\'' +
                ", shopname='" + shopname + '\'' +
                ", info=" + Arrays.toString(info) +
                ", label=" + Arrays.toString(label) +
                ", activities=" + Arrays.toString(activities) +
                '}';
    }
}
