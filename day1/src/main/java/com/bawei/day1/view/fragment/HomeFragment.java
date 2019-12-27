package com.bawei.day1.view.fragment;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bawei.day1.R;
import com.bawei.day1.base.BaseFragment;
import com.bawei.day1.contract.IHomeContract;
import com.bawei.day1.model.bean.BaseBean;
import com.bawei.day1.model.bean.FlowBean;
import com.bawei.day1.presenter.HomePresenter;
import com.bawei.day1.view.adapter.MyAdapter;
import com.bawei.day1.view.shuxing.FlowLayout;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment  extends BaseFragment<HomePresenter> implements IHomeContract.IView{
    private FlowLayout f1;
    private EditText name;
    private Button button;
    private RecyclerView recyclerview;
    @Override
    protected void initData() {
        mPresenter.onHomeData("手机");
        mPresenter.onFlowData();
    }
    @Override
    protected void initView(View inflate) {

        f1 = inflate.findViewById(R.id.fl);
        name = inflate.findViewById(R.id.et_name);
        button = inflate.findViewById(R.id.button_name);
        recyclerview = inflate.findViewById(R.id.recy_cler_view);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = name.getText().toString();
                mPresenter.onHomeData(s);
                f1.addTag(s);
            }
        });
        f1.setOnTagClickListener(new FlowLayout.OnTagClickListener() {
            @Override
            public void OnTagClick(String tag) {
                tag="手机";
               mPresenter.onHomeData(tag);
            }
        });
    }

    @Override
    protected HomePresenter providerPresenter() {
        return new HomePresenter();
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_home;
    }



    @SuppressLint("WrongConstant")
    @Override
    public void onHomeSuccess(BaseBean baseBean) {
        List<BaseBean.ResultBean> result = baseBean.getResult();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(gridLayoutManager);
        MyAdapter myAdapter = new MyAdapter(result);
        myAdapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(int posttion) {
               // startActivity(new Intent(getActivity(), SecondActivity.class));
            }
        });
        recyclerview.setAdapter(myAdapter);
    }


    @Override
    public void onHomeFailure(Throwable throwable) {
        Toast.makeText(getActivity(), "请求失败", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFlowSuccess(FlowBean flowBean) {
        f1.removeAllViews();
        List<String> tags = flowBean.getTags();
        for (int i = 0; i < tags.size(); i++) {
            String s = tags.get(i);
            f1.addTag(s);
        }
    }

    @Override
    public void onFlowFailure(Throwable throwable) {

    }
}