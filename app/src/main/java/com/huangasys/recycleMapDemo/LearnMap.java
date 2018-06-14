package com.huangasys.recycleMapDemo;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

/**
 * 功能:
 * author:lwg
 */

public class LearnMap {

    private List<MapListBean> mapList;
    private String postName;
    public List<MapListBean> getMapList()
    {
        return mapList;
    }

    public void setMapList(List<MapListBean> mapList)
    {
        this.mapList = mapList;
    }

    public String getPostName()
    {
        return postName;
    }

    public void setPostName(String postName)
    {
        this.postName = postName;
    }

    public static class MapListBean implements MultiItemEntity {
        /**
         * evalId : 1
         * evalName : 客户服务
         * finishPct : 0
         * openStatus : 1
         */

        public static final int MAP_TYPE_CERTIFICATE = -3;//证书页面
        public static final int MAP_TYPE_ONLY_BG = -2;//仅显示背景
        public static final int MAP_TYPE_FIRST_UNLOCKED  = -1;//首次待解锁
        public static final int MAP_TYPE_NON_UNLOCKED  = 0;//未解锁
        public static final int MAP_TYPE_UNLOCKED  = 1;//待解锁
        public static final int MAP_TYPE_UNDERWAY  = 2;//进行中
        public static final int MAP_TYPE_COMPLETE = 3;//已完成

        private int item = 1;//从1开始,1到4
        private int type = 0;//-3 证书页面,-2 仅显示背景,-1 首次待解锁,0 未解锁,1 待解锁,2 进行中,3 已完成

        private int evalId;
        private String evalName;
        private int finishPct;
        private int openStatus;//0未开启  1已开启

        public int getEvalId()
        {
            return evalId;
        }

        public void setEvalId(int evalId)
        {
            this.evalId = evalId;
        }

        public String getEvalName()
        {
            return evalName;
        }

        public void setEvalName(String evalName)
        {
            this.evalName = evalName;
        }

        public int getFinishPct()
        {
            return finishPct;
        }

        public void setFinishPct(int finishPct)
        {
            this.finishPct = finishPct;
        }

        public int getOpenStatus()
        {
            return openStatus;
        }

        public void setOpenStatus(int openStatus)
        {
            this.openStatus = openStatus;
        }

        @Override
        public int getItemType()
        {
            return item;
        }

        public void setItem(int item)
        {
            this.item = item;
        }

        public int getType()
        {
            return type;
        }

        public void setType(int type)
        {
            this.type = type;
        }
    }
}
