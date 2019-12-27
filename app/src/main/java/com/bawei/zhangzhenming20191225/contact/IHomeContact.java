package com.bawei.zhangzhenming20191225.contact;

import com.bawei.zhangzhenming20191225.model.bean.Bean;
import com.bawei.zhangzhenming20191225.model.bean.FlowBean;

/**
 * 时间：2019/12/25
 * 作者：张振明
 * 类的作用：
 */
public interface IHomeContact {
    interface IView {
        void onHomeSuccess(Bean bean);

        void onHomeFailure(Throwable throwable);

        void onFlowSuccess(FlowBean flowBean);

        void onFlowFailure(Throwable throwable);
    }

    interface IPresenter {
        void getHoneData(String keyword);

        void getFliwData();
    }

    interface IModel {
        void getHoneData(String keyword, IModelCallback iModelCallback);

        void getFliwData(IModelCallback iModelCallback);

        interface IModelCallback {
            void onHomeSuccess(Bean bean);

            void onHomeFailure(Throwable throwable);

            void onFlowSuccess(FlowBean flowBean);

            void onFlowFailure(Throwable throwable);
        }
    }

}
