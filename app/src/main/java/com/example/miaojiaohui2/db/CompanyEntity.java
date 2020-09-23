package com.example.miaojiaohui2.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class CompanyEntity {
    @PrimaryKey
    public int aid;

    @ColumnInfo(name = "mid")
    public int mid;

    @ColumnInfo(name = "headimg")
    public String headimg;

    @ColumnInfo(name = "content")
    public String content;

    @ColumnInfo(name = "address")
    public String address;

    @ColumnInfo(name = "companyname")
    public String companyname;

    @ColumnInfo(name = "telephone")
    public String telephone;

    @ColumnInfo(name = "realname")
    public String realname;

    @ColumnInfo(name = "status")
    public int status;

    @ColumnInfo(name = "good1")
    public String good1;

    @ColumnInfo(name = "good2")
    public String good2;

    @ColumnInfo(name = "good3")
    public String good3;

    /**
     * Room会使用这个构造器来存储数据，也就是当你从表中得到Company对象时候，Room会使用这个构造器
     * */
    public CompanyEntity(int aid, int mid, String headimg, String content, String address, String companyname, String telephone, String realname, int status, String good1, String good2, String good3){
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
}
