package com.example.miaojiaohui2.ui.company;

import java.io.Serializable;

public class Company implements Serializable {
//    public String imgPath;//图片地址
//    public String goodsName;//货物名称
//    public String goodsPrice;//货物价格
    public int aid;
    public int mid;
    public String headimg;
    public String address;
    public String content;
    public String companyname;
    public String telephone;
    public String realname;
    public int status;
    public String good1;
    public String good2;
    public String good3;

    public Company(int aid, int mid, String headimg, String content, String address, String companyname, String telephone, String realname, int status, String good1, String good2, String good3) {
        this.aid = aid;
        this.mid = mid;
        this.headimg = headimg;
        this.content = content;
        this.address = address;
        this.companyname = companyname;
        this.telephone = telephone;
        this.realname = realname;
        this.status = status;
        this.good1 = good1;
        this.good2 = good2;
        this.good3 = good3;
    }

    public int getaid() {
        return aid;
    }

    public String getheadimg() {
        return headimg;
    }

    /*
    public Company(String imgPath, String goodsName, String goodsPrice) {
        this.imgPath = imgPath;
        this.goodsName = goodsName;
        this.goodsPrice = goodsPrice;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(String goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    @Override
    public String toString() {
        return "GoodsEntity{" +
                "imgPath='" + imgPath + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", goodsPrice='" + goodsPrice + '\'' +
                '}';
    }
     */

}
