package com.huangasys.recycleviewmultiitemdemo;

import java.util.List;

/**
 * Created by huangasys on 2018/4/17.15:55
 *
 * @Describe:
 */

public class DetailsBean {

    /**
     * result : {"shareLink":"http://cloud.zyveke.com/zywc/market/packetActivity?pId=1","totalCourseNum":80,"shareCount":0,"id":1,"groupList":[{"groupName":"八到位系列课程111","itemList":[{"status":1,"studySchedule":0,"thumbUrl":"http://192.168.1.252:18080/zhuoyue_cms/userfiles/1/images/photo/2016/09/B6001.jpg","courseId":41,"teacherName":"张瑾 金融业服务营销类高级培训师","courseName":"保险销售面谈前的两个准备让您事半功倍","airdate":"2018-01-03"},{"status":1,"studySchedule":0,"thumbUrl":"http://192.168.1.252:18080/zhuoyue_cms/userfiles/1/images/photo/2016/09/B6002.jpg","courseId":42,"teacherName":"张瑾 金融业服务营销类高级培训师","courseName":"保险产品呈现技巧--让客户真正动心","airdate":"2018-01-04"},{"status":1,"studySchedule":0,"thumbUrl":"http://192.168.1.252:18080/zhuoyue_cms/userfiles/3610b73a43ea4137a5126288d605e5de/images/photo/2016/12/464BCC0516864580B77906CC306BF3D5.jpg","courseId":88,"teacherName":"张瑾 金融业服务营销类高级培训师","courseName":"开门红不焦虑，轻松出业绩","airdate":"2018-01-30"},{"status":0,"studySchedule":0,"thumbUrl":"http://192.168.1.252:18080/zhuoyue_cms/userfiles/3610b73a43ea4137a5126288d605e5de/images/photo/2016/12/464BCC0516864580B77906CC306BF3D5.jpg","courseId":84,"teacherName":"卞维林 产能提升 银行网点销售化转型 网点效能提升","courseName":"2017年开门红营销最全体系课","airdate":"2018-02-21"}]},{"groupName":"开门红系列课程","itemList":[{"status":1,"studySchedule":0,"thumbUrl":"http://192.168.1.252:18080/zhuoyue_cms/userfiles/1/images/photo/2016/09/B6003.jpg","courseId":43,"teacherName":"张瑾 金融业服务营销类高级培训师","courseName":"如何玩转FABE，提升保险产品呈现技巧","airdate":"2018-01-10"},{"status":1,"studySchedule":0,"thumbUrl":"http://192.168.1.252:18080/zhuoyue_cms/userfiles/1/images/photo/2016/09/B8001.jpg","courseId":44,"teacherName":"梁月荣 卓越微课特邀嘉宾","courseName":"片区开发体系的四大关键","airdate":"2018-01-12"},{"status":1,"studySchedule":0,"thumbUrl":"http://192.168.1.252:18080/zhuoyue_cms/userfiles/3610b73a43ea4137a5126288d605e5de/images/photo/2017/03/%E4%BF%9D%E5%8D%AB%E6%88%98%E5%B0%8F.jpg","courseId":98,"teacherName":"卞维林 产能提升 银行网点销售化转型 网点效能提升","courseName":"【内部学习版】2017开门红二次攻势暨保卫战攻略","airdate":"2018-01-30"},{"status":1,"studySchedule":0.02,"thumbUrl":"http://192.168.1.252:18080/zhuoyue_cms/userfiles/3610b73a43ea4137a5126288d605e5de/images/photo/2017/03/%E4%BF%9D%E5%8D%AB%E6%88%98%E5%B0%8F.jpg","courseId":95,"teacherName":"周志虎 营销实战专家型讲师","courseName":"如何打造让客户依赖的社区银行？","airdate":"2018-02-28"},{"status":1,"studySchedule":0,"thumbUrl":"http://192.168.1.252:18080/zhuoyue_cms/userfiles/3610b73a43ea4137a5126288d605e5de/images/photo/2016/12/464BCC0516864580B77906CC306BF3D5.jpg","courseId":86,"teacherName":"曹力蔺 卓越微课百万名师","courseName":"春节天天乐线上营销活动策划与实施","airdate":"2018-02-28"}]}],"validDay":365,"packetName":"卞老师八到位专题课程包","discountNum":0,"profit":3,"packetCover":"https://zyweike.bj.bcebos.com/sass/2018/0/31/3bca21e618524b3996aec271e7de0ede.jpg","subClickNum":0,"packetStatus":1,"packetPrice":"10","beginTime":"2018-04-09 13:15:55","assistCount":0,"profitPct":"30%","watchCount":0,"couponBuy":0,"courseNum":9,"packetIntro":"卞老师八到位专题课程包介绍卞老师八到位专题课程包介绍卞老师八到位专题课程包介绍卞老师八到位专题课程包介绍卞老师八到位专题课程包介绍卞老师八到位专题课程包介绍卞老师八到位专题课程包介绍卞老师八到位专题课程包介绍卞老师八到位专题课程包介绍"}
     * sessionKey :
     * code : 1
     * msg : 查找成功！
     */

    private ResultBean result;
    private String sessionKey;
    private int code;
    private String msg;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static class ResultBean {
        /**
         * shareLink : http://cloud.zyveke.com/zywc/market/packetActivity?pId=1
         * totalCourseNum : 80
         * shareCount : 0
         * id : 1
         * groupList : [{"groupName":"八到位系列课程111","itemList":[{"status":1,"studySchedule":0,"thumbUrl":"http://192.168.1.252:18080/zhuoyue_cms/userfiles/1/images/photo/2016/09/B6001.jpg","courseId":41,"teacherName":"张瑾 金融业服务营销类高级培训师","courseName":"保险销售面谈前的两个准备让您事半功倍","airdate":"2018-01-03"},{"status":1,"studySchedule":0,"thumbUrl":"http://192.168.1.252:18080/zhuoyue_cms/userfiles/1/images/photo/2016/09/B6002.jpg","courseId":42,"teacherName":"张瑾 金融业服务营销类高级培训师","courseName":"保险产品呈现技巧--让客户真正动心","airdate":"2018-01-04"},{"status":1,"studySchedule":0,"thumbUrl":"http://192.168.1.252:18080/zhuoyue_cms/userfiles/3610b73a43ea4137a5126288d605e5de/images/photo/2016/12/464BCC0516864580B77906CC306BF3D5.jpg","courseId":88,"teacherName":"张瑾 金融业服务营销类高级培训师","courseName":"开门红不焦虑，轻松出业绩","airdate":"2018-01-30"},{"status":0,"studySchedule":0,"thumbUrl":"http://192.168.1.252:18080/zhuoyue_cms/userfiles/3610b73a43ea4137a5126288d605e5de/images/photo/2016/12/464BCC0516864580B77906CC306BF3D5.jpg","courseId":84,"teacherName":"卞维林 产能提升 银行网点销售化转型 网点效能提升","courseName":"2017年开门红营销最全体系课","airdate":"2018-02-21"}]},{"groupName":"开门红系列课程","itemList":[{"status":1,"studySchedule":0,"thumbUrl":"http://192.168.1.252:18080/zhuoyue_cms/userfiles/1/images/photo/2016/09/B6003.jpg","courseId":43,"teacherName":"张瑾 金融业服务营销类高级培训师","courseName":"如何玩转FABE，提升保险产品呈现技巧","airdate":"2018-01-10"},{"status":1,"studySchedule":0,"thumbUrl":"http://192.168.1.252:18080/zhuoyue_cms/userfiles/1/images/photo/2016/09/B8001.jpg","courseId":44,"teacherName":"梁月荣 卓越微课特邀嘉宾","courseName":"片区开发体系的四大关键","airdate":"2018-01-12"},{"status":1,"studySchedule":0,"thumbUrl":"http://192.168.1.252:18080/zhuoyue_cms/userfiles/3610b73a43ea4137a5126288d605e5de/images/photo/2017/03/%E4%BF%9D%E5%8D%AB%E6%88%98%E5%B0%8F.jpg","courseId":98,"teacherName":"卞维林 产能提升 银行网点销售化转型 网点效能提升","courseName":"【内部学习版】2017开门红二次攻势暨保卫战攻略","airdate":"2018-01-30"},{"status":1,"studySchedule":0.02,"thumbUrl":"http://192.168.1.252:18080/zhuoyue_cms/userfiles/3610b73a43ea4137a5126288d605e5de/images/photo/2017/03/%E4%BF%9D%E5%8D%AB%E6%88%98%E5%B0%8F.jpg","courseId":95,"teacherName":"周志虎 营销实战专家型讲师","courseName":"如何打造让客户依赖的社区银行？","airdate":"2018-02-28"},{"status":1,"studySchedule":0,"thumbUrl":"http://192.168.1.252:18080/zhuoyue_cms/userfiles/3610b73a43ea4137a5126288d605e5de/images/photo/2016/12/464BCC0516864580B77906CC306BF3D5.jpg","courseId":86,"teacherName":"曹力蔺 卓越微课百万名师","courseName":"春节天天乐线上营销活动策划与实施","airdate":"2018-02-28"}]}]
         * validDay : 365
         * packetName : 卞老师八到位专题课程包
         * discountNum : 0
         * profit : 3.0
         * packetCover : https://zyweike.bj.bcebos.com/sass/2018/0/31/3bca21e618524b3996aec271e7de0ede.jpg
         * subClickNum : 0
         * packetStatus : 1
         * packetPrice : 10
         * beginTime : 2018-04-09 13:15:55
         * assistCount : 0
         * profitPct : 30%
         * watchCount : 0
         * couponBuy : 0
         * courseNum : 9
         * packetIntro : 卞老师八到位专题课程包介绍卞老师八到位专题课程包介绍卞老师八到位专题课程包介绍卞老师八到位专题课程包介绍卞老师八到位专题课程包介绍卞老师八到位专题课程包介绍卞老师八到位专题课程包介绍卞老师八到位专题课程包介绍卞老师八到位专题课程包介绍
         */

        private String shareLink;
        private int totalCourseNum;
        private int shareCount;
        private int id;
        private int validDay;
        private String packetName;
        private int discountNum;
        private double profit;
        private String packetCover;
        private int subClickNum;
        private int packetStatus;
        private String packetPrice;
        private String beginTime;
        private int assistCount;
        private String profitPct;
        private int watchCount;
        private int couponBuy;
        private int courseNum;
        private String packetIntro;
        private List<GroupListBean> groupList;

        public String getShareLink() {
            return shareLink;
        }

        public void setShareLink(String shareLink) {
            this.shareLink = shareLink;
        }

        public int getTotalCourseNum() {
            return totalCourseNum;
        }

        public void setTotalCourseNum(int totalCourseNum) {
            this.totalCourseNum = totalCourseNum;
        }

        public int getShareCount() {
            return shareCount;
        }

        public void setShareCount(int shareCount) {
            this.shareCount = shareCount;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getValidDay() {
            return validDay;
        }

        public void setValidDay(int validDay) {
            this.validDay = validDay;
        }

        public String getPacketName() {
            return packetName;
        }

        public void setPacketName(String packetName) {
            this.packetName = packetName;
        }

        public int getDiscountNum() {
            return discountNum;
        }

        public void setDiscountNum(int discountNum) {
            this.discountNum = discountNum;
        }

        public double getProfit() {
            return profit;
        }

        public void setProfit(double profit) {
            this.profit = profit;
        }

        public String getPacketCover() {
            return packetCover;
        }

        public void setPacketCover(String packetCover) {
            this.packetCover = packetCover;
        }

        public int getSubClickNum() {
            return subClickNum;
        }

        public void setSubClickNum(int subClickNum) {
            this.subClickNum = subClickNum;
        }

        public int getPacketStatus() {
            return packetStatus;
        }

        public void setPacketStatus(int packetStatus) {
            this.packetStatus = packetStatus;
        }

        public String getPacketPrice() {
            return packetPrice;
        }

        public void setPacketPrice(String packetPrice) {
            this.packetPrice = packetPrice;
        }

        public String getBeginTime() {
            return beginTime;
        }

        public void setBeginTime(String beginTime) {
            this.beginTime = beginTime;
        }

        public int getAssistCount() {
            return assistCount;
        }

        public void setAssistCount(int assistCount) {
            this.assistCount = assistCount;
        }

        public String getProfitPct() {
            return profitPct;
        }

        public void setProfitPct(String profitPct) {
            this.profitPct = profitPct;
        }

        public int getWatchCount() {
            return watchCount;
        }

        public void setWatchCount(int watchCount) {
            this.watchCount = watchCount;
        }

        public int getCouponBuy() {
            return couponBuy;
        }

        public void setCouponBuy(int couponBuy) {
            this.couponBuy = couponBuy;
        }

        public int getCourseNum() {
            return courseNum;
        }

        public void setCourseNum(int courseNum) {
            this.courseNum = courseNum;
        }

        public String getPacketIntro() {
            return packetIntro;
        }

        public void setPacketIntro(String packetIntro) {
            this.packetIntro = packetIntro;
        }

        public List<GroupListBean> getGroupList() {
            return groupList;
        }

        public void setGroupList(List<GroupListBean> groupList) {
            this.groupList = groupList;
        }

        public static class GroupListBean {
            /**
             * groupName : 八到位系列课程111
             * itemList : [{"status":1,"studySchedule":0,"thumbUrl":"http://192.168.1.252:18080/zhuoyue_cms/userfiles/1/images/photo/2016/09/B6001.jpg","courseId":41,"teacherName":"张瑾 金融业服务营销类高级培训师","courseName":"保险销售面谈前的两个准备让您事半功倍","airdate":"2018-01-03"},{"status":1,"studySchedule":0,"thumbUrl":"http://192.168.1.252:18080/zhuoyue_cms/userfiles/1/images/photo/2016/09/B6002.jpg","courseId":42,"teacherName":"张瑾 金融业服务营销类高级培训师","courseName":"保险产品呈现技巧--让客户真正动心","airdate":"2018-01-04"},{"status":1,"studySchedule":0,"thumbUrl":"http://192.168.1.252:18080/zhuoyue_cms/userfiles/3610b73a43ea4137a5126288d605e5de/images/photo/2016/12/464BCC0516864580B77906CC306BF3D5.jpg","courseId":88,"teacherName":"张瑾 金融业服务营销类高级培训师","courseName":"开门红不焦虑，轻松出业绩","airdate":"2018-01-30"},{"status":0,"studySchedule":0,"thumbUrl":"http://192.168.1.252:18080/zhuoyue_cms/userfiles/3610b73a43ea4137a5126288d605e5de/images/photo/2016/12/464BCC0516864580B77906CC306BF3D5.jpg","courseId":84,"teacherName":"卞维林 产能提升 银行网点销售化转型 网点效能提升","courseName":"2017年开门红营销最全体系课","airdate":"2018-02-21"}]
             */

            private String groupName;
            private List<ItemListBean> itemList;

            public String getGroupName() {
                return groupName;
            }

            public void setGroupName(String groupName) {
                this.groupName = groupName;
            }

            public List<ItemListBean> getItemList() {
                return itemList;
            }

            public void setItemList(List<ItemListBean> itemList) {
                this.itemList = itemList;
            }

            public static class ItemListBean {
                /**
                 * status : 1
                 * studySchedule : 0.0
                 * thumbUrl : http://192.168.1.252:18080/zhuoyue_cms/userfiles/1/images/photo/2016/09/B6001.jpg
                 * courseId : 41
                 * teacherName : 张瑾 金融业服务营销类高级培训师
                 * courseName : 保险销售面谈前的两个准备让您事半功倍
                 * airdate : 2018-01-03
                 */

                private int status;
                private double studySchedule;
                private String thumbUrl;
                private int courseId;
                private String teacherName;
                private String courseName;
                private String airdate;

                public int getStatus() {
                    return status;
                }

                public void setStatus(int status) {
                    this.status = status;
                }

                public double getStudySchedule() {
                    return studySchedule;
                }

                public void setStudySchedule(double studySchedule) {
                    this.studySchedule = studySchedule;
                }

                public String getThumbUrl() {
                    return thumbUrl;
                }

                public void setThumbUrl(String thumbUrl) {
                    this.thumbUrl = thumbUrl;
                }

                public int getCourseId() {
                    return courseId;
                }

                public void setCourseId(int courseId) {
                    this.courseId = courseId;
                }

                public String getTeacherName() {
                    return teacherName;
                }

                public void setTeacherName(String teacherName) {
                    this.teacherName = teacherName;
                }

                public String getCourseName() {
                    return courseName;
                }

                public void setCourseName(String courseName) {
                    this.courseName = courseName;
                }

                public String getAirdate() {
                    return airdate;
                }

                public void setAirdate(String airdate) {
                    this.airdate = airdate;
                }
            }
        }
    }
}
