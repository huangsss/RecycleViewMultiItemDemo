package com.huangasys.recycleGridMultiItemDemo;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.huangasys.recycleviewmultiitemdemo.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by huangasys on 2018/5/7.18:28
 *
 * @Describe:
 */

public class GridMultiActivity extends AppCompatActivity {


    private RecyclerView mRecyclerView;
    private GridMultiAdapter mGridMultiAdapter;
    private GridLayoutManager mGridLayoutManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_layout);
        mRecyclerView = findViewById(R.id.grid_recycle);
        getData();
    }

    @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
    private void getData() {
        //1.读取json;
        String json = getJSON("sites.json", this);
        //2.解析jsonArray;
        JsonParser jsonParser = new JsonParser();
        JsonArray asJsonArray = jsonParser.parse(json).getAsJsonArray();
        Gson gson = new Gson();
        ArrayList<SiteBean> siteBeanList = new ArrayList<>();
        for (JsonElement jsonElement : asJsonArray) {
            SiteBean siteBean = gson.fromJson(jsonElement, SiteBean.class);
            siteBeanList.add(siteBean);
        }

        //3.转换成需要的数据类;
        ArrayList<Object> items = new ArrayList<>();
        for (int i = 0; i < siteBeanList.size(); i++) {
            items.add(siteBeanList.get(i));
            for (int k = 0; k < siteBeanList.get(i).getSites().size(); k++) {
                items.add(siteBeanList.get(i).getSites().get(k));
            }
        }
        initRecycleView(items);
    }

    private void initRecycleView(ArrayList<Object> items) {
        mGridMultiAdapter = new GridMultiAdapter(items,this);
        mGridLayoutManager = new GridLayoutManager(this,3);
        mRecyclerView.setLayoutManager(mGridLayoutManager);
        mGridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                int itemViewType = mGridMultiAdapter.getItemViewType(position);
                Log.d("print", "getSpanSize: "+itemViewType);
                switch (itemViewType) {
                    case GridMultiAdapter.SITEText:
                        return 3 ;//标题的话跨多少列 这个值要跟整个列数相等 如果大于会出错，小于布局会乱;
                    case GridMultiAdapter.SITEImg:
                        return 1;//不跨列,就是分成三列显示;
                    default:
                        return -1;
                }
            }
        });



        mRecyclerView.setAdapter(mGridMultiAdapter);
    }

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
