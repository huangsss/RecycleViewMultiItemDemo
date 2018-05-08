package com.huangasys.recycleGridMultiItemDemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.huangasys.recycleviewmultiitemdemo.R;

import java.util.ArrayList;


/**
 * Created by huangasys on 2018/5/8.12:34
 *
 * @Describe:
 */

public class GridMultiAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int SITEText = 0;//标题 跨一列 也就是合并两列
    public static final int SITEImg = 1;//不跨列

    private ArrayList<Object> items;
    private Context mContext;

    public GridMultiAdapter(ArrayList<Object> items, Context context) {
        this.items = items;
        this.mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        switch (viewType) {
            case SITEText:
                return new TextViewHolder(inflater.inflate(R.layout.item_name_layout, parent, false));
            case SITEImg:
                return new ImageViewHolder(inflater.inflate(R.layout.grid_item_img_layout, parent, false));
            default:
                break;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof TextViewHolder) {
            //文字;
            SiteBean siteBean = (SiteBean) items.get(position);
            ((TextViewHolder) holder).text.setText(siteBean.getName());
        } else if (holder instanceof ImageViewHolder) {
            SiteBean.SitesBean sitesBean = (SiteBean.SitesBean) items.get(position);
            //图片+文字;
            ((ImageViewHolder) holder).gridImgText.setText(sitesBean.getName());
            Glide.with(mContext).load(sitesBean.getAvatar_url()).into(((ImageViewHolder) holder).gridImg);
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    @Override
    public int getItemViewType(int position) {
        if (items.get(position) instanceof SiteBean) {
            return SITEText;
        } else if (items.get(position) instanceof SiteBean.SitesBean) {
            return SITEImg;
        }
        return -1;
    }

    class TextViewHolder extends RecyclerView.ViewHolder {

        TextView text;

        public TextViewHolder(View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.tv_name);
        }
    }

    class ImageViewHolder extends RecyclerView.ViewHolder {
        ImageView gridImg;
        TextView gridImgText;

        public ImageViewHolder(View itemView) {
            super(itemView);
            gridImgText = itemView.findViewById(R.id.grid_item_text);
            gridImg = itemView.findViewById(R.id.grid_item_img);
        }
    }
}
