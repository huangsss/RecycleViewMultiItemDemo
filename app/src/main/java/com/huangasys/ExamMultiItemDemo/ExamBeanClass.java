package com.huangasys.ExamMultiItemDemo;

import java.util.List;

/**
 * Created by huangasys on 2018/4/20.14:21
 *
 * @Describe:
 */

public class ExamBeanClass {


    /**
     * result : {"startTime":null,"quesList":[{"itemList":[{"isAnswer":1,"itemId":6037,"itemName":"hddh","itemNo":1},{"isAnswer":0,"itemId":6038,"itemName":"考虑考虑","itemNo":2},{"isAnswer":0,"itemId":6039,"itemName":"会哈快集合","itemNo":3}],"quesId":1132,"quesName":"还矮","quesNo":1,"quesScore":18,"quesType":1},{"itemList":[{"isAnswer":0,"itemId":6040,"itemName":"啊啊啊","itemNo":1},{"isAnswer":1,"itemId":6041,"itemName":"11","itemNo":2},{"isAnswer":0,"itemId":6042,"itemName":"哈哈哈","itemNo":3}],"quesId":1133,"quesName":"fgg","quesNo":2,"quesScore":10,"quesType":1}],"titlePrompt":"","examId":"167","isTimeFlag":0,"examDesc":"好几家","endTime":null,"examName":"考虑考虑到其","submitStatus":1}
     * sessionKey :
     * code : 1
     * msg : 查询成功！
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
         * startTime : null
         * quesList : [{"itemList":[{"isAnswer":1,"itemId":6037,"itemName":"hddh","itemNo":1},{"isAnswer":0,"itemId":6038,"itemName":"考虑考虑","itemNo":2},{"isAnswer":0,"itemId":6039,"itemName":"会哈快集合","itemNo":3}],"quesId":1132,"quesName":"还矮","quesNo":1,"quesScore":18,"quesType":1},{"itemList":[{"isAnswer":0,"itemId":6040,"itemName":"啊啊啊","itemNo":1},{"isAnswer":1,"itemId":6041,"itemName":"11","itemNo":2},{"isAnswer":0,"itemId":6042,"itemName":"哈哈哈","itemNo":3}],"quesId":1133,"quesName":"fgg","quesNo":2,"quesScore":10,"quesType":1}]
         * titlePrompt :
         * examId : 167
         * isTimeFlag : 0
         * examDesc : 好几家
         * endTime : null
         * examName : 考虑考虑到其
         * submitStatus : 1
         */

        private Object startTime;
        private String titlePrompt;
        private String examId;
        private int isTimeFlag;
        private String examDesc;
        private Object endTime;
        private String examName;
        private int submitStatus;
        private List<QuesListBean> quesList;

        public Object getStartTime() {
            return startTime;
        }

        public void setStartTime(Object startTime) {
            this.startTime = startTime;
        }

        public String getTitlePrompt() {
            return titlePrompt;
        }

        public void setTitlePrompt(String titlePrompt) {
            this.titlePrompt = titlePrompt;
        }

        public String getExamId() {
            return examId;
        }

        public void setExamId(String examId) {
            this.examId = examId;
        }

        public int getIsTimeFlag() {
            return isTimeFlag;
        }

        public void setIsTimeFlag(int isTimeFlag) {
            this.isTimeFlag = isTimeFlag;
        }

        public String getExamDesc() {
            return examDesc;
        }

        public void setExamDesc(String examDesc) {
            this.examDesc = examDesc;
        }

        public Object getEndTime() {
            return endTime;
        }

        public void setEndTime(Object endTime) {
            this.endTime = endTime;
        }

        public String getExamName() {
            return examName;
        }

        public void setExamName(String examName) {
            this.examName = examName;
        }

        public int getSubmitStatus() {
            return submitStatus;
        }

        public void setSubmitStatus(int submitStatus) {
            this.submitStatus = submitStatus;
        }

        public List<QuesListBean> getQuesList() {
            return quesList;
        }

        public void setQuesList(List<QuesListBean> quesList) {
            this.quesList = quesList;
        }

        public static class QuesListBean {
            /**
             * itemList : [{"isAnswer":1,"itemId":6037,"itemName":"hddh","itemNo":1},{"isAnswer":0,"itemId":6038,"itemName":"考虑考虑","itemNo":2},{"isAnswer":0,"itemId":6039,"itemName":"会哈快集合","itemNo":3}]
             * quesId : 1132
             * quesName : 还矮
             * quesNo : 1
             * quesScore : 18
             * quesType : 1
             */

            private int quesId;
            private String quesName;
            private int quesNo;
            private int quesScore;
            private int quesType;
            private List<ItemListBean> itemList;

            public int getQuesId() {
                return quesId;
            }

            public void setQuesId(int quesId) {
                this.quesId = quesId;
            }

            public String getQuesName() {
                return quesName;
            }

            public void setQuesName(String quesName) {
                this.quesName = quesName;
            }

            public int getQuesNo() {
                return quesNo;
            }

            public void setQuesNo(int quesNo) {
                this.quesNo = quesNo;
            }

            public int getQuesScore() {
                return quesScore;
            }

            public void setQuesScore(int quesScore) {
                this.quesScore = quesScore;
            }

            public int getQuesType() {
                return quesType;
            }

            public void setQuesType(int quesType) {
                this.quesType = quesType;
            }

            public List<ItemListBean> getItemList() {
                return itemList;
            }

            public void setItemList(List<ItemListBean> itemList) {
                this.itemList = itemList;
            }

            public static class ItemListBean {
                /**
                 * isAnswer : 1
                 * itemId : 6037
                 * itemName : hddh
                 * itemNo : 1
                 */

                private int isAnswer;
                private int itemId;
                private String itemName;
                private int itemNo;

                public int getIsAnswer() {
                    return isAnswer;
                }

                public void setIsAnswer(int isAnswer) {
                    this.isAnswer = isAnswer;
                }

                public int getItemId() {
                    return itemId;
                }

                public void setItemId(int itemId) {
                    this.itemId = itemId;
                }

                public String getItemName() {
                    return itemName;
                }

                public void setItemName(String itemName) {
                    this.itemName = itemName;
                }

                public int getItemNo() {
                    return itemNo;
                }

                public void setItemNo(int itemNo) {
                    this.itemNo = itemNo;
                }
            }
        }
    }
}
