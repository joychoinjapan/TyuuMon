package com.example.tyuumon.Util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Message;
import android.util.Log;

import com.example.tyuumon.beans.DetailsItem;
import com.example.tyuumon.beans.MenuItem;
import com.google.gson.Gson;

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
import java.util.ArrayList;
import java.util.List;

public class NetWrokUtil {
    private String url;

    public NetWrokUtil(String url) {
        this.url = url;

    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<MenuItem> getMessage(){

        final Gson gson = new Gson();
        List<MenuItem> menuItemsList = new ArrayList<>();
        try {
            URL url1 = new URL(this.url);
            HttpURLConnection connection = (HttpURLConnection) url1.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(6000);
            if(connection.getResponseCode() == HttpURLConnection.HTTP_OK){
                //5.判断响应吗并获取响应数据
                InputStream in = connection.getInputStream();
                byte[] b = new byte[1024];
                //在循环中读取数据
                int len = 0;
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                while ((len = in.read(b))>-1){
                    //写入缓存流
                    baos.write(b,0,len);
                }
                String msg = new String(baos.toByteArray());
                JSONObject jo = new JSONObject(msg);
                JSONArray jsonArray = jo.getJSONArray("data");

                for( int i = 0;i<jsonArray.length();i++){
                    JSONObject item = jsonArray.getJSONObject(i);
                    MenuItem menuItem = gson.fromJson(item.toString(), MenuItem.class);
                    Log.i("menuItem",menuItem.toString());
                    Bitmap bitmap = this.getPics(menuItem.getImg());
                    menuItem.setBitmap(bitmap);
                    menuItemsList.add(menuItem);
                }
                return menuItemsList;
            };
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Bitmap getPics(String url){
        HttpURLConnection connection = null;
        try {
            URL url1 = new URL(url);
            connection = (HttpURLConnection) url1.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(6000);
            connection.setDoInput(true);
            connection.setRequestProperty("charset", "UTF-8");
            connection.connect();
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                Log.e("Thread2222", "OK2");
                InputStream in = connection.getInputStream();
                Bitmap bitmap = BitmapFactory.decodeStream(in);
                return bitmap;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }

    public DetailsItem getDetails(){
        final Gson gson = new Gson();
        try {
            URL url1 = new URL(this.url);
            HttpURLConnection connection = (HttpURLConnection) url1.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(6000);
            if(connection.getResponseCode() == HttpURLConnection.HTTP_OK){
                //5.判断响应吗并获取响应数据
                InputStream in = connection.getInputStream();
                byte[] b = new byte[1024];
                //在循环中读取数据
                int len = 0;
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                while ((len = in.read(b))>-1){
                    //写入缓存流
                    baos.write(b,0,len);
                }
                String msg = new String(baos.toByteArray());
                JSONObject jo = new JSONObject(msg);
                JSONObject data = jo.getJSONObject("data");
                DetailsItem detailsItem = gson.fromJson(data.toString(),DetailsItem.class);
                Log.i("detailsItem",detailsItem.toString());
                Bitmap bitmap = this.getPics(detailsItem.getImg());
                detailsItem.setBitmap(bitmap);
                return detailsItem;
            };
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

}
