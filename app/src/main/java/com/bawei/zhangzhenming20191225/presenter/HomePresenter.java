package com.bawei.zhangzhenming20191225.presenter;

import com.bawei.zhangzhenming20191225.base.BasePresenter;
import com.bawei.zhangzhenming20191225.contact.IHomeContact;
import com.bawei.zhangzhenming20191225.model.HomeModel;
import com.bawei.zhangzhenming20191225.model.bean.Bean;
import com.bawei.zhangzhenming20191225.model.bean.FlowBean;

/**
 * 时间：2019/12/25
 * 作者：张振明
 * 类的作用：
 */
public class HomePresenter extends BasePresenter<IHomeContact.IView> implements IHomeContact.IPresenter {

    private HomeModel homeModel;

    @Override
    protected void initModeel() {
        homeModel = new HomeModel();
    }

    @Override
    public void getHoneData(String keyword) {
        homeModel.getHoneData(keyword, new IHomeContact.IModel.IModelCallback() {
            @Override
            public void onHomeSuccess(Bean bean) {
                view.onHomeSuccess(bean);
            }

            @Override
            public void onHomeFailure(Throwable throwable) {
                view.onHomeFailure(throwable);
            }

            @Override
            public void onFlowSuccess(FlowBean flowBean) {
                view.onFlowSuccess(flowBean);
            }

            @Override
            public void onFlowFailure(Throwable throwable) {
                view.onFlowFailure(throwable);
            }
        });
    }

    @Override
    public void getFliwData() {

    }
}
