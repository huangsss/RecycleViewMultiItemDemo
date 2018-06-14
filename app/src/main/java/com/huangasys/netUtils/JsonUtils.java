package com.huangasys.netUtils;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 * Created by huangasys on 2018/6/12.16:11
 *
 * @Describe:
 */

public class JsonUtils {


    //读取本地assets获得JSON数据;
    public static String getJSON(String filename, Context context){

        StringBuilder builder = new StringBuilder();
        try {
            InputStream in = context.getAssets().open(filename);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
            String line = null;
            while((line = bufferedReader.readLine())!=null){
                builder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.i("abc", builder.toString());
        try {
            return new String(builder.toString().getBytes(),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "解析失败";
    }
}
