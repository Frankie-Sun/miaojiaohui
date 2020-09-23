package com.example.miaojiaohui2.util;

import android.os.Build;
import android.os.Message;
import android.util.Log;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.ViewModelProviders;

import com.example.miaojiaohui2.db.CompanyEntity;
import com.example.miaojiaohui2.ui.company.CompanyViewModel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HttpGetRequest {
    private String url;
    private JSONObject jsonobject;
    private CompanyViewModel companyViewModel;
    private CompanyEntity companyEntity;

    public HttpGetRequest(String url){
        this.url = url;
    }
    public JSONObject get_josnobj(){
        return this.jsonobject;
    }
    public void fetch_company_list(){
        new Thread(){
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void run() {
                try {
                    URL urlobj = new URL(url);
                    HttpURLConnection coon = (HttpURLConnection) urlobj.openConnection();
                    coon.setRequestMethod("GET");
                    coon.setReadTimeout(6000);
                    //获取响应码
                    if(coon.getResponseCode() == 200){
                        //获取输入流
                        InputStream in = coon.getInputStream();
                        byte[] b = new byte[1024*512];
                        int len = 0;
                        //建立缓存流，保存所读取的字节数组
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        while ((len = in.read(b)) > -1){
                            baos.write(b,0,len);
                        }
                        String msg = baos.toString();
                        //TAG1: {"flag":"Success","errcode":"0","msg":"\u9996\u9875","data":{"countpage":12,"list":[{"aid":"250","mid":"1102","headimg":"https:\/\/thirdwx.qlogo.cn\/mmopen\/vi_32\/OfeDiaebPYp7XWqibDWdfMQqia6rWW0OV6g21uOV8kzzYe0bEOJ4u88fCiaswfFWM7pQKQHgfgGklOjeTbdcJT8UxQ\/132","content":"\u7f8e\u56fd\u7ea2\u67ab12-16cm\n\u91cd\u9633\u672814-30cm\n\u9020\u578b\u9ed1\u677e\uff0c\u9020\u578b\u9f99\u67cf\uff0c\u9020\u578b\u6994\u6986\uff0c\u9020\u578b\u5bf9\u63a5\u767d\u8721\uff0c\u9020\u578b\u7f57\u6c49\u677e\uff0c\u9020\u578b\u5143\u5b9d\u67ab\uff0c\u9020\u578b\u74dc\u5b50\u9ec4\u6768\n\u4e1b\u751f\u65e0\u60a3\u5b50\uff0c\u4e1b\u751f\u6734\u6811\uff0c\u4e1b\u751f\u9999\u6a1f\uff0c\u4e1b\u751f\u4e4c\u6855","address":"\u6c5f\u82cf\u7701\u9547\u6c5f\u5e02\u4e39\u5f92\u533a\u738b\u7532\u6751","company":"\u745e\u54f2\u56ed\u6797","telphone":"13905294777","realname":"\u4e01\u745e\u6e05","status":"1","goodslist":[{"id":"2705","vname":"\u6989\u6811","img1":"cloud:\/\/miaojiaohui-a4dh4.6d69-miaojiaohui-a4dh4-1300957126\/good_250_2705_44.jpg","img2":null,"img3":null},{"id":"2708","vname":"\u6989\u6811","img1":"cloud:\/\/miaojiaohui-a4dh4.6d69-miaojiaohui-a4dh4-1300957126\/good_250_2708_7.jpg","img2":null,"img3":null},{"id":"2709","vname":"\u9999\u6a1f","img1":"cloud:\/\/miaojiaohui-a4dh4.6d69-miaojiaohui-a4dh4-1300957126\/good_250_2709_46.jpg","img2":null,"img3":null}]},{"aid":"249","mid":"1096","headimg":"https:\/\/thirdwx.qlogo.cn\/mmopen\/vi_32\/Y2srjxQ5HK9CarRUyicMaictJEyCOr3w8q0O10k1no7ibn6JWj2IuIPwBqicv6jCI6XQuCvTg6RzQpTAjcmAibHkJlA\/132","content":"\u9e21\u722a\u69ed8-18cm\n\u7ea2\u68855-10cm\n\u82b1\u77f3\u69b47-9cm\n\u7ea2\u67ab3-8cm\n\u5782\u4e1d\u6d77\u68e06-10cm\n\u9999\u6a7c7-10cm\n\u897f\u5e9c\u6d77\u68e05-9cm\n13515255652","address":"\u6c5f\u82cf\u7701\u9547\u6c5f\u5e02\u4e39\u9633\u5e02\u82b1\u5bb6\u6751(\u9547\u6c5f\u5e02\u4e39\u9633\u5e02)","company":"\u9b4f\u56fd\u752b\u82d7\u5703","telphone":"13506113884","realname":"\u9b4f\u56fd\u752b","status":"1","goodslist":[{"id":"2623","vname":"\u9e21\u722a\u69ed","img1":"cloud:\/\/miaojiaohui-a4dh4.6d69-miaojiaohui-a4dh4-1300957126\/good_249_149_29.jpg","img2":null,"img3":null},{"id":"2617","vname":"\u7ea2\u67ab","img1":"cloud:\/\/miaojiaohui-a4dh4.6d69-miaojiaohui-a4dh4-1300957126\/good_249_146_88.jpg","img2":null,"img3":null},{"id":"2606","vname":"\u5782\u4e1d\u6d77\u68e0","img1":"cloud:\/\/miaojiaohui-a4dh4.6d69-miaojiaohui-a4dh4-1300957126\/good_249_154_53.jpg","img2":null,"img3":null}]},{"aid":"248","mid":"1094","headimg":"https:\/\/thirdwx.qlogo.cn\/mmopen\/vi_32\/ZtRQFSUiaicudwDmiarHmxCeicrOsr9hbyPTqG8qbUuxMqGIRBF42oBRTBs6FPcMrX6BB5dpnG5G7ibQeaaGa59910g\/132","content":"\u6989\u681115-20cm\n\u9e21\u722a\u69ed7-15cm\n\u7ea2\u53f6\u674e9-12cm\n\u5782\u4e1d\u6d77\u68e04-6cm\n\u897f\u5e9c\u6d77\u68e05-10cm\n\u65e0\u60a3\u5b507-10cm\n\u6842\u82b1p2-3m\n\u7ea2\u53f6\u77f3\u6960\u7403p1.2-2m\n\u683e\u68118-15cm\n\u65e5\u672c\u7ea2\u67ab9-11cm\n\u65e9\u6a3110-15cm","address":"\u6c5f\u82cf\u7701\u9547\u6c5f\u5e02\u4e39\u9633\u5e02105\u53bf\u9053\u897f\u9ebb\u6751(\u9547\u6c5f\u5e02\u4e39\u9633\u5e02)","company":"\u745e\u68ee\u82b1\u6728","telphone":"13852939138","realname":"\u5f20\u91d1\u745e","status":"1","goodslist":[{"id":"2602","vname":"\u5317\u7f8e\u6d77\u68e0","img1":"cloud:\/\/miaojiaohui-a4dh4.6d69-miaojiaohui-a4dh4-1300957126\/good_248_152_36.jpg","img2":null,"img3":null},{"id":"2601","vname":"\u5317\u7f8e\u6d77\u68e0","img1":"cloud:\/\/miaojiaohui-a4dh4.6d69-miaojiaohui-a4dh4-1300957126\/good_248_152_15.jpg","img2":null,"img3":null},{"id":"2600","vname":"\u897f\u5e9c\u6d77\u68e0","img1":"cloud:\/\/miaojiaohui-a4dh4.6d69-miaojiaohui-a4dh4-1300957126\/good_248_153_55.jpg","img2":null,"img3":null}]},{"aid":"247","mid":"1089","headimg":"https:\/\/thirdwx.qlogo.cn\/mmopen\/vi_32\/Q0j4TwGTfTJxYsvpJ0G0icpvtqD5T8ZnGd5YjCsIY9XRTbsct4R1P9nDUQxE7cuG0tZz2XEvj1OsVXsNNSeDlLg\/132","content":"\u6d77\u6850\u7403p100cm\n\u6d77\u6850\u6bdb\u7403\n\u77f3\u6960\u7403p100\n\u77f3\u6960\u6bdb\u7403\n\u91d1\u68ee\u5973\u8d1e\u6bdb\u7403\n\u77f3\u6960\u68118-10cm","addre
                        Log.e("TAG1",msg);
                        //JSON数据的解析：
                        JSONObject obj = new JSONObject(msg);
                        jsonobject = obj;
                        JSONObject data =new JSONObject(obj.getString("data"));
                  //      String companyList = data.getString("list");
                  //      Log.e("TAG1213232",companyList);

                        JSONArray comList = data.getJSONArray("list");
                        for(int i=0; i<comList.length(); i++){
                            int j = comList.length() - i - 1;
              //              Log.e("dtest",integer.toString(i)); I
                            JSONObject oj = comList.getJSONObject(i);
                            Log.e("dtest",Integer.toString(j));
                            //              Log.e("aid", oj.getString("aid"));
              //              Log.e("goodlist", oj.getString("goodslist"));

                            int aid = Integer.parseInt(oj.getString("aid"));
                            int mid = Integer.parseInt(oj.getString("mid"));
                            String headimg = oj.getString("headimg");
                            String content = oj.getString("content");
                            String address = oj.getString("address");
                            String companyname = oj.getString("company");
                            String telphone = oj.getString("telphone");
                            String realname = oj.getString("realname");
                            int status = Integer.parseInt(oj.getString("status"));
                            String good1 = "";
                            String good2 = "";
                            String good3 = "";



                            JSONArray goods_list = oj.getJSONArray("goodslist");
                            try{
                                good1 = goods_list.getJSONObject(0).getString("img1");
                                good2 = goods_list.getJSONObject(1).getString("img1");
                                good3 = goods_list.getJSONObject(2).getString("img1");
                               // Log.e("goodimg1", goods_list.getJSONObject(0).getString("img1"));
                               // Log.e("goodimg2", goods_list.getJSONObject(1).getString("img1"));
                               // Log.e("goodimg3", goods_list.getJSONObject(2).getString("img1"));
                            }catch (Exception e) {
                            }
                            try {
                                System.out.println(companyViewModel.recordNumber(243));
                                if(companyViewModel.recordNumber(aid) == 0) {
                                    companyViewModel.insertCompanyToDB(new CompanyEntity(aid, mid, headimg, content, address, companyname, telphone, realname, status, good1, good2, good3));
                                }
                                }catch(Exception e){
                                companyViewModel.updateCompanyToDB(new CompanyEntity(aid, mid, headimg, content, address, companyname, telphone, realname, status, good1, good2, good3));
                            }

                       //     System.out.println(companyViewModel.loadCompanybyid(243));
                       //     System.out.println(c.aid);
                       //     Log.e("goodimg2", goods_list.getJSONObject(2).getString("img1"));
                       //     Log.e("goodimg3", goods_list.getJSONObject(3).getString("img1"));

                        }
                  //      try {
                  //          companyViewModel.insertCompanyToDB(new CompanyEntity(1002, 1001, "test.png", "this is tes", "abcasnhoi", "nvidia", "127182y618", "realsun", 0, "img1", "img2", "img3"));
                  //      }catch (Exception e){
                  //          companyViewModel.updateCompanyToDB(new CompanyEntity(1002, 1001, "test.png", "this is tes", "abcasnhoi", "nvidia", "127182y618", "realsun", 0, "img1", "img2", "img3"));
                  //      }


                        //    Gson gson = new Gson();
                    //    System.out.println("1" + gson.toJson(companyList));

                    //    List<String> stringList = gson.fromJson(gson.toJson(companyList), new TypeToken<List<String>>() {
                    //    }.getType());
                    //    System.out.println(stringList);
                    //    for(String string: strings){
                    //        System.out.println(string);
                    //    }


                        //HashMap map = null;
                        //map.get("age")
                        //String status = jsonobject.getString("flag");
                        //String msg2 = jsonobject.getString("data");
                        //Log.e("TAG2",status + "   " + msg2);

                        /*
                        //1.创建Gson对象
                        Gson gson = new Gson();
                        //参数1：满足json对象格式的字符串
                        String data = obj.getString("data");
                        Essay e = gson.fromJson(data,Essay.class);



                        JSONObject data = obj.getJSONObject("data");
                        String title = data.getString("title");
                        String author = data.getString("author");
                        String content = data.getString("content");
                        Log.e("TAG","标题：" + title + "，作者：" + author + "，内容：" + content);
                        //将操作权交还给主线程

                        Message message = handler.obtainMessage();
                        //Essay e = new Essay(title,author,content);
                        message.obj =e;

                        //调用此方法，则会触发主线程中Handle对象里覆盖了的handleMessage方法
                        handler.sendMessage(message);
                        */
                    }
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }.start();

    }
}
