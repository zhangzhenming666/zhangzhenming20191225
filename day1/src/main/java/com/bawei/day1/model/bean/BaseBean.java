package com.bawei.day1.model.bean;

import java.util.List;

/**
 * 时间：2019/12/26
 * 作者：张振明
 * 类的作用：
 */
public class BaseBean {
    /**
     * result : [{"commodityId":140,"commodityName":"小白鞋男时尚新款运动休闲男鞋韩版潮流厚底原宿风板鞋","masterPic":"http://172.17.8.100/images/small/commodity/nx/nbx/6/1.jpg","price":398,"saleNum":0},{"commodityId":137,"commodityName":"唐狮冬季男士冬休闲鞋高帮男鞋男士板鞋休闲男鞋子高帮男鞋百搭休闲板鞋男","masterPic":"http://172.17.8.100/images/small/commodity/nx/nbx/3/1.jpg","price":79,"saleNum":3},{"commodityId":145,"commodityName":"如熙新款男鞋韩版学生时尚百搭潮流低帮男帆布鞋简约英伦风舒适男板鞋轻便耐磨系带潮鞋","masterPic":"http://172.17.8.100/images/small/commodity/nx/nfbx/4/1.jpg","price":119,"saleNum":3},{"commodityId":139,"commodityName":"秋季男鞋简约百搭男小白鞋韩版潮流男板鞋跑步鞋子ins超火的运动鞋学生时尚嘻哈潮鞋","masterPic":"http://172.17.8.100/images/small/commodity/nx/nbx/5/1.jpg","price":109,"saleNum":0},{"commodityId":136,"commodityName":"板鞋休闲鞋男男士休闲运动鞋男士鞋子休闲皮鞋男士休闲鞋男鞋","masterPic":"http://172.17.8.100/images/small/commodity/nx/nbx/2/1.jpg","price":99,"saleNum":0}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * commodityId : 140
         * commodityName : 小白鞋男时尚新款运动休闲男鞋韩版潮流厚底原宿风板鞋
         * masterPic : http://172.17.8.100/images/small/commodity/nx/nbx/6/1.jpg
         * price : 398
         * saleNum : 0
         */

        private int commodityId;
        private String commodityName;
        private String masterPic;
        private int price;
        private int saleNum;

        public int getCommodityId() {
            return commodityId;
        }

        public void setCommodityId(int commodityId) {
            this.commodityId = commodityId;
        }

        public String getCommodityName() {
            return commodityName;
        }

        public void setCommodityName(String commodityName) {
            this.commodityName = commodityName;
        }

        public String getMasterPic() {
            return masterPic;
        }

        public void setMasterPic(String masterPic) {
            this.masterPic = masterPic;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getSaleNum() {
            return saleNum;
        }

        public void setSaleNum(int saleNum) {
            this.saleNum = saleNum;
        }
    }
}
