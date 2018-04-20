package com.huangasys.ExamMultiItemDemo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.gson.Gson;
import com.huangasys.recycleviewmultiitemdemo.JsonDatas;
import com.huangasys.recycleviewmultiitemdemo.R;

import java.lang.invoke.ConstantCallSite;
import java.util.List;

/**
 * Created by huangasys on 2018/4/20.14:25
 *
 * @Describe:
 */

public class ExamActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView mRecyclerView;
    private Button nextButton;
    private TextView mBottomText;
    private ProgressBar mProgressBar;
    private TextView titleText;
    private List<ExamBeanClass.ResultBean.QuesListBean> mQuesList;
    private int mListSize;
    int flag = 0;
    private QuestAnwswerAdapter mQuestAnwswerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_layout);
        mRecyclerView = findViewById(R.id.exam_recycleView);
        nextButton = findViewById(R.id.exam_button);
        mBottomText = findViewById(R.id.exam_bottom_text);
        mProgressBar = findViewById(R.id.exam_progress);
        titleText = findViewById(R.id.exam_title);
        nextButton.setOnClickListener(this);
        getData();
    }


    @SuppressLint("SetTextI18n")
    public void getData() {
        ExamBeanClass examBeanClass = new Gson().fromJson(JsonDatas.ExamJson2, ExamBeanClass.class);
        //题目列表;
        mQuesList = examBeanClass.getResult().getQuesList();
        mListSize = mQuesList.size();//题目集合的总数;
        Log.d("print", "getData:  题目总数为---"+mListSize);
        //首次进入默认显示第一题;
        mProgressBar.setProgress((int) 100*(1/mListSize));
        titleText.setText(mQuesList.get(flag).getQuesName());
        mBottomText.setText("1/" + mListSize);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        ExamBeanClass.ResultBean.QuesListBean quesListBean = mQuesList.get(flag);
        mQuestAnwswerAdapter = new QuestAnwswerAdapter(this,quesListBean.getItemList());
        mRecyclerView.setAdapter(mQuestAnwswerAdapter);
    }


    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View v) {
        Log.d("print", "onClick: 下一题");
        flag++;
        if (flag < mListSize) {
            mProgressBar.setProgress((int) 100*(flag+1/mListSize));
            mBottomText.setText((flag+1)+"/"+mListSize);
            titleText.setText(mQuesList.get(flag).getQuesName());
            mQuestAnwswerAdapter.setNewData(mQuesList.get(flag).getItemList());
            if (flag+1 == mListSize){
                nextButton.setText("提交");
            }
        }else{
            nextButton.setText("提交");
        }
    }

    class QuestAnwswerAdapter extends RecyclerView.Adapter<QuestAnwswerAdapter.AnswerViewHolder> {
        private Context mContext;
        private List<ExamBeanClass.ResultBean.QuesListBean.ItemListBean> answerItemList;

        public QuestAnwswerAdapter(Context context, List<ExamBeanClass.ResultBean.QuesListBean.ItemListBean> answerItemList) {
            mContext = context;
            this.answerItemList = answerItemList;
        }

        public void setNewData(List<ExamBeanClass.ResultBean.QuesListBean.ItemListBean> answerItemList) {
            this.answerItemList = answerItemList;
            notifyDataSetChanged();//刷新适配器;
        }

        @Override
        public AnswerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new AnswerViewHolder(LayoutInflater.from(mContext).inflate(R.layout.saas_course_exam_child_item, parent, false));
        }

        @Override
        public void onBindViewHolder(AnswerViewHolder holder, int position) {
            holder.questionText.setText(answerItemList.get(position).getItemName());
            char t = (char) (position + 65);
            holder.mCheckBox.setText(t + "");
            holder.childLinearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("print", "onClick: sdjflsdjfaslf");
                }
            });
        }

        @Override
        public int getItemCount() {
            return answerItemList.size();
        }

        class AnswerViewHolder extends RecyclerView.ViewHolder {
            TextView questionText;
            CheckBox mCheckBox;
            LinearLayout childLinearLayout;

            public AnswerViewHolder(View itemView) {
                super(itemView);
                questionText = itemView.findViewById(R.id.saas_exam_child_txt);
                mCheckBox = itemView.findViewById(R.id.saas_exam_child_cb);
                childLinearLayout = itemView.findViewById(R.id.saas_exam_child_answer);
            }
        }
    }
}
