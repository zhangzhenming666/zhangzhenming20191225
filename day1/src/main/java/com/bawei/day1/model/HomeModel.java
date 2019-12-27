package com.bawei.day1.model;

import com.bawei.day1.contract.IHomeContract;
import com.bawei.day1.model.bean.BaseBean;
import com.bawei.day1.model.bean.FlowBean;
import com.bawei.day1.util.NetUtile;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URLEncoder;

/**
 * 时间：2019/12/26
 * 作者：张振明
 * 类的作用：
 */
public class HomeModel implements IHomeContract.IModel {
    @Override
    public void onHomeData(String keyword, final IModelCallBack iModelCallBack) {
        try {
            String encode = URLEncoder.encode(keyword, "UTF-8");
            String url = "http://172.17.8.100/small/commodity/v1/findCommodityByKeyword?page=1&count=5&keyword="+encode;
            NetUtile.getInstance().getJsonGet(url, new NetUtile.MyCallBack() {
                @Override
                public void ongetJson(String json) {
                    BaseBean baseBean = new Gson().fromJson(json, BaseBean.class);
                    iModelCallBack.onHomeSuccess(baseBean);
                }

                @Override
                public void onError(Throwable throwable) {
                    iModelCallBack.onHomeFailure(throwable);
                }
            });
        }catch (IOException i){
            i.printStackTrace();
        }
    }

    @Override
    public void onFlowData(final IModelCallBack iModelCallBack) {
        try {
            String encode = URLEncoder.encode("手机", "UTF-8");
            String url = "http://blog.zhaoliang5156.cn/baweiapi/"+encode;
            NetUtile.getInstance().getJsonGet(url, new NetUtile.MyCallBack() {
                @Override
                public void ongetJson(String json) {
                    FlowBean flowBean = new Gson().fromJson(json, FlowBean.class);
                    iModelCallBack.onFlowSuccess(flowBean);
                }

                @Override
                public void onError(Throwable throwable) {
                    iModelCallBack.onFlowFailure(throwable);
                }
            });
        }catch (IOException i){
            i.printStackTrace();
        }
    }
}
