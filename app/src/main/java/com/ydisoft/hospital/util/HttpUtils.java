package com.ydisoft.hospital.util;

import android.util.Log;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/**
 * Created by franke2009 on 2016/05/07.
 */
public class HttpUtils {

    /**
     * get机制用的是在URL地址里面通过？号间隔，然后以name=value的形式给客户端传递参数。
     * @param path
* @return
     */
    public static String doGetMethod(String path){
        String result="";
        HttpURLConnection urlConnection = null;
        InputStreamReader inputStreamReader = null;
        try {
            URL url =  new URL(path);
            urlConnection = (HttpURLConnection)url.openConnection();
            inputStreamReader = new InputStreamReader(urlConnection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String readLine = null;
            while ((readLine=bufferedReader.readLine())!=null){
                result +=readLine;
            }
            inputStreamReader.close();
        } catch (Exception e) {
            Log.e(HttpUtils.class.getName(),e.getMessage());
        }finally {
            urlConnection.disconnect();
        }
        return result;
    }

    /**
     * post传输方式不在URL里传递，也正好解决了get传输量小、容易篡改及不安全等一系列不足。主要是通
     * 过对HttpURLConnection的设置，让其支持post传输方式，然后在通过相关属性传递参数（若需要传递中文字符，则可以通过URLEncoder编码，而在获取端采用URLDecoder解码即可）
     * @param path
     * @param params
     * @return
     */
    public static CommonResult doPostMethod(String path,Map<String,Object> params){
        CommonResult commonResult = null;
        String result="";
        HttpURLConnection urlConnection = null;
        InputStreamReader inputStreamReader = null;
        Gson gson = new Gson();
        try {
            URL url =  new URL(path);
            urlConnection = (HttpURLConnection)url.openConnection();
            urlConnection.setDoInput(true);
            urlConnection.setDoOutput(true);
            urlConnection.setRequestMethod("POST");
            urlConnection.setRequestProperty("Content-Type","application/json");
            urlConnection.setRequestProperty("Charset",Constants.DEFAUlT_CHARSET);
            urlConnection.connect();

            DataOutputStream dataOutputStream = new DataOutputStream(urlConnection.getOutputStream());
            //把Map转成JSON字符串
            String jsonStr = gson.toJson(params);
            dataOutputStream.writeBytes(jsonStr);
            dataOutputStream.flush();
            dataOutputStream.close();

            inputStreamReader = new InputStreamReader(urlConnection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String readLine = null;
            while ((readLine=bufferedReader.readLine())!=null){
                result +=readLine;
            }
            java.lang.reflect.Type type = new com.google.gson.reflect.TypeToken<CommonResult<?>>() {}.getType();
            commonResult =  gson.fromJson(result,type);
        } catch (Exception e) {
            Log.e(HttpUtils.class.getName(),e.getMessage());
        }finally {
            try {
                inputStreamReader.close();
            } catch (IOException e) {}
            urlConnection.disconnect();
        }
        return commonResult;
    }


}