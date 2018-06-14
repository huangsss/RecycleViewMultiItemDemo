package com.huangasys.recycleMapDemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.gson.Gson;
import com.huangasys.netUtils.JsonUtils;
import com.huangasys.recycleviewmultiitemdemo.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.huangasys.recycleMapDemo.LearnMap.MapListBean.MAP_TYPE_CERTIFICATE;
import static com.huangasys.recycleMapDemo.LearnMap.MapListBean.MAP_TYPE_COMPLETE;
import static com.huangasys.recycleMapDemo.LearnMap.MapListBean.MAP_TYPE_FIRST_UNLOCKED;
import static com.huangasys.recycleMapDemo.LearnMap.MapListBean.MAP_TYPE_NON_UNLOCKED;
import static com.huangasys.recycleMapDemo.LearnMap.MapListBean.MAP_TYPE_ONLY_BG;
import static com.huangasys.recycleMapDemo.LearnMap.MapListBean.MAP_TYPE_UNDERWAY;
import static com.huangasys.recycleMapDemo.LearnMap.MapListBean.MAP_TYPE_UNLOCKED;

/**
 * Created by huangasys on 2018/6/12.15:32
 *
 * @Describe:
 */

public class LearnMapActivity extends AppCompatActivity {

    RecyclerView mRvLearnMap;
    private ResultTableAdapter mAdapter;
    private LinearLayoutManager mLinearLayoutManager;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_layout);
        mRvLearnMap = findViewById(R.id.rv_learn_map);
        initRecycleView();
        initData();
    }

    private void initData() {
        String json = JsonUtils.getJSON("mapJson.json", this);
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONObject result = jsonObject.getJSONObject("result");
            String resultString = result.toString();
            Log.d("print", "initData: ---"+resultString);
            Gson gson = new Gson();
            LearnMap learnMap = gson.fromJson(resultString, LearnMap.class);
            dealData(learnMap);
            mAdapter.addData(learnMap.getMapList());
            //滑动到最底部;
            mRvLearnMap.scrollToPosition(mAdapter.getItemCount()-1);
            mLinearLayoutManager.scrollToPositionWithOffset(mAdapter.getItemCount()-1 -movePosition,0);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    //正在进行的点,自动移动到此位置
    private int movePosition = 0;

    private int addSize = 0;

    //是否全部完成
    boolean mIsComplete = false;
    public static final int  MAP_MIN_COLUMN = 6;

    //有几种地图背景
    private static final int MAP_STYPE_TYPE_SUM = 4;

    private LearnMap dealData(LearnMap data)
    {
        List<LearnMap.MapListBean> lists = data.getMapList();

        int size = lists.size();
        int temp = 0;


        mIsComplete = isComplete(lists);

        movePosition = 0;
        //设置类型
        for(int i = 0; i < size;i++)
        {

            LearnMap.MapListBean bean = lists.get(i);
            bean.setItem((temp % MAP_STYPE_TYPE_SUM) + 1);
            temp++;

            if(bean.getOpenStatus() == 1)
            {
                if(bean.getFinishPct() == 100)
                {
                    bean.setType(MAP_TYPE_COMPLETE);//已完成
                    movePosition = i;
                }else {
                    bean.setType(MAP_TYPE_UNDERWAY);//进行中
                    movePosition = i;
                }

            }else {
                bean.setType(MAP_TYPE_NON_UNLOCKED);//未解锁
            }

            if(i == 0 && bean.getOpenStatus() == 0)
            {
                bean.setType(MAP_TYPE_FIRST_UNLOCKED);    //待解锁
            }else if( i > 0 && lists.get(i-1).getOpenStatus() == 1 && lists.get(i-1).getFinishPct() == 100 && bean.getOpenStatus() == 0)
            {
                bean.setType(MAP_TYPE_UNLOCKED);    //待解锁
                movePosition = i;
            }

        }

        if(mIsComplete)
        {
            movePosition++;
        }

        //添加证书
        LearnMap.MapListBean bean2 = new LearnMap.MapListBean();
        bean2.setItem((size  % MAP_STYPE_TYPE_SUM) + 1);
        bean2.setType(MAP_TYPE_CERTIFICATE);
        lists.add(bean2);

        size = size + 1;

        addSize = 0;
        //添加背景节点,防止节点过少时的显示
        if(size < MAP_MIN_COLUMN)
        {
            addSize = MAP_MIN_COLUMN - size;

            for(int j = 0; j < addSize;j++)
            {
                LearnMap.MapListBean bean = new LearnMap.MapListBean();
                bean.setItem(((size + j) % MAP_STYPE_TYPE_SUM) + 1);
                bean.setType(MAP_TYPE_ONLY_BG);
                lists.add(bean);
            }
        }


        Collections.reverse(lists);
        return data;
    }

    private boolean isComplete(List<LearnMap.MapListBean> lists)
    {
        if(lists == null)
        {
            return false;
        }

        int size = lists.size();
        for(int i = 0; i < size;i++)
        {
            if(lists.get(i).getOpenStatus() != 1)
            {
                return false;
            }

            if (lists.get(i).getFinishPct() != 100)
            {
                return false;
            }

        }

        return true;
    }

    private void initRecycleView()
    {

        mLinearLayoutManager = new LinearLayoutManager(this);
        mRvLearnMap.setLayoutManager(mLinearLayoutManager);
        mAdapter = new ResultTableAdapter();
        mRvLearnMap.setAdapter(mAdapter);
    }


   public class ResultTableAdapter extends BaseMultiItemQuickAdapter<LearnMap.MapListBean,BaseViewHolder>{

       public ResultTableAdapter(){
           super(new ArrayList<LearnMap.MapListBean>());
           addItemType(1, R.layout.posts_item_saas_learn_map_item1);
           addItemType(2, R.layout.posts_item_saas_learn_map_item2);
           addItemType(3, R.layout.posts_item_saas_learn_map_item3);
           addItemType(4, R.layout.posts_item_saas_learn_map_item4);
       }

       @Override
       protected void convert(BaseViewHolder helper, LearnMap.MapListBean item) {

           helper.addOnClickListener(R.id.iv_learn_schedule);
           helper.addOnClickListener(R.id.iv_learn);

           helper.setText(R.id.tv_eval_name,item.getEvalName());


           if(item.getType() == MAP_TYPE_NON_UNLOCKED)
           {
               helper.setVisible(R.id.iv_learn_schedule,false);
               helper.setVisible(R.id.dv_view,false);
               helper.setVisible(R.id.tv_learn_schedule,false);
               helper.setVisible(R.id.iv_learn,true);
               helper.setVisible(R.id.tv_eval_name,true);
               helper.setImageResource(R.id.iv_learn,R.drawable.posts_ic_learn_map_unable_learn);
           }else if(item.getType() == MAP_TYPE_UNLOCKED){
               helper.setVisible(R.id.iv_learn_schedule,true);
               helper.setVisible(R.id.dv_view,true);
               helper.setVisible(R.id.tv_learn_schedule,false);
               helper.setVisible(R.id.iv_learn,true);
               helper.setVisible(R.id.tv_eval_name,true);
               helper.setImageResource(R.id.iv_learn, R.drawable.posts_ic_learn_map_learning);
               helper.setImageResource(R.id.iv_learn_schedule, R.drawable.posts_ic_learn_map_schedule_first_map);
               DiffuseView view = helper.getView(R.id.dv_view);
               view.start();
           }else if(item.getType() == MAP_TYPE_UNDERWAY){
               helper.setVisible(R.id.dv_view,true);
               helper.setVisible(R.id.iv_learn,true);
               helper.setVisible(R.id.tv_eval_name,true);
               helper.setImageResource(R.id.iv_learn, R.drawable.posts_ic_learn_map_learning);
               helper.setImageResource(R.id.iv_learn_schedule, R.drawable.posts_ic_learn_map_schedule);
               helper.setVisible(R.id.iv_learn_schedule,true);
               helper.setVisible(R.id.tv_learn_schedule,true);
               helper.setText(R.id.tv_learn_schedule,item.getFinishPct() + "%");

               DiffuseView view = helper.getView(R.id.dv_view);
               view.start();

           }else if(item.getType() == MAP_TYPE_COMPLETE){
               helper.setVisible(R.id.dv_view,false);
               helper.setVisible(R.id.iv_learn_schedule,false);
               helper.setVisible(R.id.tv_learn_schedule,false);
               helper.setVisible(R.id.iv_learn,true);
               helper.setVisible(R.id.tv_eval_name,true);
               helper.setImageResource(R.id.iv_learn, R.drawable.posts_ic_learn_map_complete);
           }else if(item.getType() == MAP_TYPE_FIRST_UNLOCKED)
           {
               helper.setVisible(R.id.dv_view,true);
               helper.setVisible(R.id.tv_learn_schedule,false);
               helper.setVisible(R.id.iv_learn,true);
               helper.setVisible(R.id.tv_eval_name,true);
               helper.setVisible(R.id.iv_learn_schedule,true);
               helper.setImageResource(R.id.iv_learn, R.drawable.posts_ic_learn_map_learning);
               helper.setImageResource(R.id.iv_learn_schedule, R.drawable.posts_ic_learn_map_schedule_first_map);

               DiffuseView view = helper.getView(R.id.dv_view);
               view.start();
           } else if(item.getType() == MAP_TYPE_ONLY_BG){
               helper.setVisible(R.id.dv_view,false);
               helper.setVisible(R.id.iv_learn_schedule,false);
               helper.setVisible(R.id.tv_learn_schedule,false);
               helper.setVisible(R.id.iv_learn,false);
               helper.setVisible(R.id.tv_eval_name,false);
           } else if(item.getType() == MAP_TYPE_CERTIFICATE){
               helper.setVisible(R.id.dv_view,false);
               helper.setVisible(R.id.iv_learn_schedule,true);
               helper.setVisible(R.id.tv_learn_schedule,false);
               helper.setVisible(R.id.iv_learn,true);
               helper.setVisible(R.id.tv_eval_name,true);
               helper.setImageResource(R.id.iv_learn_schedule, R.drawable.posts_ic_learn_map_certificate);
               helper.setImageResource(R.id.iv_learn, R.drawable.posts_ic_learn_map_learning);
           }
       }
   }

}
