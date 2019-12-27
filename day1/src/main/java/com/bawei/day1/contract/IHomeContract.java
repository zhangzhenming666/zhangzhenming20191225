package com.bawei.day1.contract;

import com.bawei.day1.model.bean.BaseBean;
import com.bawei.day1.model.bean.FlowBean;

/**
 * 时间：2019/12/26
 * 作者：张振明
 * 类的作用：
 */
public interface IHomeContract {

    interface IView{
        void onHomeSuccess(BaseBean baseBean);

        void onHomeFailure(Throwable throwable);

        void onFlowSuccess(FlowBean flowBean);

        void onFlowFailure(Throwable throwable);
    }

    interface IPresenter{
        void onHomeData(String keyword);

        void onFlowData();
    }

    interface IModel{

        void onHomeData(String keyword,IModelCallBack iModelCallBack);

        void onFlowData(IModelCallBack iModelCallBack);

        interface IModelCallBack{
            void onHomeSuccess(BaseBean baseBean);

            void onHomeFailure(Throwable throwable);

            void onFlowSuccess(FlowBean flowBean);

            void onFlowFailure(Throwable throwable);
        }
    }

}
