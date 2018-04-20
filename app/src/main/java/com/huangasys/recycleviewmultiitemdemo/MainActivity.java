package com.huangasys.recycleviewmultiitemdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private MultiItemAdapter mMultiItemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.recycleView);

        mMultiItemAdapter = new MultiItemAdapter(new ArrayList());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mMultiItemAdapter);
        PagerSnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(mRecyclerView);

        initData();
    }

    private void initData() {
        DetailsBean detailsBean = new Gson().fromJson(JsonDatas.json, DetailsBean.class);//数据
        List<ItemEntity> itemEntityList = new ArrayList<>();
        List<DetailsBean.ResultBean.GroupListBean> groupList = detailsBean.getResult().getGroupList();
        for (int i = 0; i < groupList.size(); i++) {
            //第一类型
            ItemEntity itemEntity = new ItemEntity();
            itemEntity.setType(ItemEntity.TYPE_NAME);
            itemEntity.setGroupName(groupList.get(i).getGroupName());
            itemEntityList.add(itemEntity);
            //第二类型;
            List<DetailsBean.ResultBean.GroupListBean.ItemListBean> itemListBeanList = groupList.get(i).getItemList();
            for (int j = 0; j < itemListBeanList.size(); j++) {
                DetailsBean.ResultBean.GroupListBean.ItemListBean itemListBean = itemListBeanList.get(j);
                ItemEntity itemEntity2 = new ItemEntity();
                itemEntity2.setType(ItemEntity.TYPE_CLASS);
                itemEntity2.setCourseId(itemListBean.getCourseId());
                itemEntity2.setAirdate(itemListBean.getAirdate());
                itemEntity2.setCourseName(itemListBean.getCourseName());
                itemEntity2.setStatus(itemListBean.getStatus());
                itemEntity2.setStudySchedule(itemListBean.getStudySchedule());
                itemEntity2.setTeacherName(itemListBean.getTeacherName());
                itemEntity2.setThumbUrl(itemListBean.getThumbUrl());
                itemEntityList.add(itemEntity2);
            }
        }
//mMultiItemAdapter
        mMultiItemAdapter.setNewData(itemEntityList);

    }

    class MultiItemAdapter extends BaseMultiItemQuickAdapter<ItemEntity, BaseViewHolder> {

        /**
         * Same as QuickAdapter#QuickAdapter(Context,int) but with
         * some initialization data.
         *
         * @param data A new list is created out of this one to avoid mutable list
         */
        public MultiItemAdapter(List data) {
            super(data);
            addItemType(ItemEntity.TYPE_NAME, R.layout.item_name_layout);
            addItemType(ItemEntity.TYPE_CLASS, R.layout.item_class_layout);
        }

        @Override
        protected void convert(BaseViewHolder helper, ItemEntity item) {
            switch (item.getItemType()) {
                case ItemEntity.TYPE_NAME:
                    //文字;
                    helper.setText(R.id.tv_name, item.getGroupName());
                    break;
                case ItemEntity.TYPE_CLASS:
                    //班级布局;
                    helper.setText(R.id.tv_classes_title, item.getCourseName());
                    ImageView ivClassesCover = helper.getView(R.id.iv_classes_cover);
//                    ImageManager.getInstance().loadUrlImage(item.getThumbUrl(),ivClassesCover);
                    helper.setText(R.id.tv_teacher, item.getTeacherName());

                    ProgressBar bar = helper.getView(R.id.pb_classes);


                    if (item.getStatus() == 0) {
                        helper.setVisible(R.id.tv_state, true);
                        bar.setVisibility(View.GONE);
                        helper.setVisible(R.id.tv_progress, false);
                        helper.setText(R.id.tv_date, "更新时间:" + item.getAirdate());
                        helper.setTextColor(R.id.tv_date, getColors(R.color.green3b));
                    } else {
                        helper.setVisible(R.id.tv_state, false);
                        bar.setVisibility(View.VISIBLE);
                        bar.setMax(100);
                        bar.setProgress((int) (item.getStudySchedule() * 100));
                        helper.setVisible(R.id.tv_progress, true);
                        helper.setText(R.id.tv_progress, "已学" + (int) (item.getStudySchedule() * 100) + "%");
                        helper.setText(R.id.tv_date, item.getAirdate());
                        helper.setTextColor(R.id.tv_date, getColors(R.color.tv66));
                    }
                    break;
            }
        }
    }

    protected int getColors(int id) {
        return getResources().getColor(id);
    }
}
