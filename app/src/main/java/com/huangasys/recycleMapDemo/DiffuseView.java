package com.huangasys.recycleMapDemo;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;


import com.huangasys.recycleviewmultiitemdemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能:这是一个自定义圆圈扩散View
 * author:lwg
 */

public class DiffuseView extends View {

    /** 扩散圆圈颜色 */
    private int mColor = 0xffffca3d;
    /** 圆圈中心颜色 */
    private int mCoreColor = 0xffffca3d;
    /** 中心圆半径 */
    private float mCoreRadius = 150;
    /** 扩散圆宽度 */
    private int mDiffuseWidth = 3;
    /** 最大宽度 */
    private Integer mMaxWidth = 255;
    /** 是否正在扩散中 */
    private boolean mIsDiffuse = false;
    // 透明度集合
    private List<Integer> mAlphas = new ArrayList<>();
    // 扩散圆半径集合
    private List<Integer> mWidths = new ArrayList<>();
    private Paint mPaint;

    public DiffuseView(Context context) {
        this(context, null);
    }

    public DiffuseView(Context context, AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public DiffuseView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.PostsDiffuseView, defStyleAttr, 0);
        mColor = a.getColor(R.styleable.PostsDiffuseView_diffuse_color, mColor);
        mCoreColor = a.getColor(R.styleable.PostsDiffuseView_diffuse_coreColor, mCoreColor);
        mCoreRadius = a.getDimension(R.styleable.PostsDiffuseView_diffuse_coreRadius, mCoreRadius);
        mDiffuseWidth = a.getDimensionPixelSize(R.styleable.PostsDiffuseView_diffuse_width, mDiffuseWidth);
        mMaxWidth = a.getDimensionPixelSize(R.styleable.PostsDiffuseView_diffuse_maxWidth, mMaxWidth);
        a.recycle();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mAlphas.add(255);
        mWidths.add(0);
    }

    @Override
    public void invalidate() {
        if(hasWindowFocus()){
            super.invalidate();
        }
    }

    @Override
    public void onDraw(Canvas canvas) {
        // 绘制扩散圆
        mPaint.setColor(mColor);

        for (int i = 0; i < mAlphas.size(); i++) {
            // 设置透明度
            Integer alpha = mAlphas.get(i);
            mPaint.setAlpha(alpha);
            // 绘制扩散圆
            Integer width = mWidths.get(i);
            canvas.drawCircle(getWidth() / 2, getHeight() / 2, mCoreRadius + width, mPaint);

            if(alpha > 0 && width <= mMaxWidth){

                mWidths.set(i, width + mDiffuseWidth);
                int v1 = (int) (255 - 255 * (mWidths.get(i) / (mMaxWidth * 1.0)));
                mAlphas.set(i, v1);
            }
        }
        // 判断当扩散圆扩散到指定宽度时添加新扩散圆
//        if (mWidths.get(0) == mMaxWidth / 3) {
//            mAlphas.add(255);
//            mWidths.add(0);
//        }
        // 超过10个扩散圆，删除最外层
        if(mWidths.size() >= 6){
            mWidths.remove(0);
            mAlphas.remove(0);
        }

        // 绘制中心圆及图片
        mPaint.setAlpha(255);
        mPaint.setColor(mCoreColor);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, mCoreRadius, mPaint);

        if(mIsDiffuse){
            getHandler().postDelayed(
                    runnable,32);

        }
    }

    private Runnable runnable= new Runnable() {

        int i = 0;

        @Override
        public void run()
        {
            i++;

            if(i == mMaxWidth / mDiffuseWidth /5)
            {
                i = 0;
                mAlphas.add(255);
                mWidths.add(0);
            }
            invalidate();
        }
    };

    /**
     * 开始扩散
     */
    public void start() {
        mIsDiffuse = true;
        invalidate();
    }

    /**
     * 停止扩散
     */
    public void stop() {
        mIsDiffuse = false;
    }

    /**
     * 是否扩散中
     */
    public boolean isDiffuse(){
        return mIsDiffuse;
    }

    /**
     * 设置扩散圆颜色
     */
    public void setColor(int colorId){
        mColor = colorId;
    }

    /**
     * 设置中心圆颜色
     */
    public void setCoreColor(int colorId){
        mCoreColor = colorId;
    }


    /**
     * 设置中心圆半径
     */
    public void setCoreRadius(int radius){
        mCoreRadius = radius;
    }

    /**
     * 设置扩散圆宽度(值越小宽度越大)
     */
    public void setDiffuseWidth(int width){
        mDiffuseWidth = width;
    }

    /**
     * 设置最大宽度
     */
    public void setMaxWidth(int maxWidth){
        mMaxWidth = maxWidth;
    }
}
