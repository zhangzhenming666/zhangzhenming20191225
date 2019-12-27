package com.bawei.day1.presenter;

import com.bawei.day1.base.BasePresenter;
import com.bawei.day1.contract.IHomeContract;
import com.bawei.day1.model.HomeModel;
import com.bawei.day1.model.bean.BaseBean;
import com.bawei.day1.model.bean.FlowBean;

/**
 * 时间：2019/12/26
 * 作者：张振明
 * 类的作用：
 */
public class HomePresenter extends BasePresenter<IHomeContract.IView> implements IHomeContract.IPresenter {

    private HomeModel homeModel;

    @Override
    protected void initModel() {
        homeModel = new HomeModel();
    }

    @Override
    public void onHomeData(String keyword) {

        homeModel.onHomeData(keyword, new IHomeContract.IModel.IModelCallBack() {
            @Override
            public void onHomeSuccess(BaseBean baseBean) {
                view.onHomeSuccess(baseBean);
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
    public void onFlowData() {
        homeModel.onFlowData(new IHomeContract.IModel.IModelCallBack() {
            @Override
            public void onHomeSuccess(BaseBean baseBean) {
                view.onHomeSuccess(baseBean);
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
}
