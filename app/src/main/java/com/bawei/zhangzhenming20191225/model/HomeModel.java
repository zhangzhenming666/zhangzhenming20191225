package com.bawei.zhangzhenming20191225.model;

import com.bawei.zhangzhenming20191225.contact.IHomeContact;
import com.bawei.zhangzhenming20191225.model.bean.Bean;
import com.bawei.zhangzhenming20191225.model.bean.FlowBean;
import com.bawei.zhangzhenming20191225.util.NetUtil;
import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * 时间：2019/12/25
 * 作者：张振明
 * 类的作用：
 */
public class HomeModel implements IHomeContact.IModel {
    @Override
    public void getHoneData(String keyword, final IModelCallback iModelCallback) {
        try {
            String encode = URLEncoder.encode(keyword, "UTF-8");
            String http = "http://172.17.8.100/small/commodity/v1/findCommodityByKeyword?page=1&count=5&keyword=" + encode;
            NetUtil.getInstance().getJsonGet(http, new NetUtil.MyCallback() {
                @Override
                public void getJson(String json) {
                    Bean bean = new Gson().fromJson(json, Bean.class);
                    iModelCallback.onHomeSuccess(bean);
                }

                @Override
                public void Eroor(Throwable throwable) {
                    iModelCallback.onHomeFailure(throwable);
                }
            });
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getFliwData(final IModelCallback iModelCallback) {
        try {
            String encode = URLEncoder.encode("电脑", "UTF-8");
            final String util = "http://blog.zhaoliang5156.cn/baweiapi/" + encode;
            NetUtil.getInstance().getJsonGet(util, new NetUtil.MyCallback() {
                @Override
                public void getJson(String json) {
                    FlowBean flowBean = new Gson().fromJson(json, FlowBean.class);
                    iModelCallback.onFlowSuccess(flowBean);
                }

                @Override
                public void Eroor(Throwable throwable) {
                    iModelCallback.onFlowFailure(throwable);
                }
            });
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
