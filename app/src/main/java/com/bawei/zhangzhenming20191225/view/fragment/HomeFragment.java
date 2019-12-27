package com.bawei.zhangzhenming20191225.view.fragment;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.GetChars;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bawei.zhangzhenming20191225.R;
import com.bawei.zhangzhenming20191225.base.BaseFragment;
import com.bawei.zhangzhenming20191225.contact.IHomeContact;
import com.bawei.zhangzhenming20191225.model.bean.Bean;
import com.bawei.zhangzhenming20191225.model.bean.FlowBean;
import com.bawei.zhangzhenming20191225.presenter.HomePresenter;
import com.bawei.zhangzhenming20191225.view.acyivity.SecondActivity;
import com.bawei.zhangzhenming20191225.view.adapter.MyAdapter;
import com.bawei.zhangzhenming20191225.view.whight.FlowLayout;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment<HomePresenter> implements IHomeContact.IView {


    private EditText edit_text;
    private Button button;
    private FlowLayout fliw;
    private RecyclerView recyle;

    @Override
    protected HomePresenter providePresenter() {
        return new HomePresenter();
    }

    @Override
    protected void initData() {
     mPresenter.getHoneData("电脑");
     mPresenter.getFliwData();
    }

    @Override
    protected void initView(View inflate) {
        edit_text = inflate.findViewById(R.id.edit_text);
        button = inflate.findViewById(R.id.button_name);
        fliw = inflate.findViewById(R.id.fliw);
        recyle = inflate.findViewById(R.id.recyle);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = edit_text.getText().toString();
                mPresenter.getHoneData(s);
                fliw.addTag(s);
            }
        });
        fliw.setOnTagClickListener(new FlowLayout.OnTagClickListener() {
            @Override
            public void onTagClick(String tag) {
                mPresenter.getHoneData(tag);
            }
        });
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_home;
    }

    @SuppressLint("WrongConstant")
    @Override
    public void onHomeSuccess(Bean bean) {
        List<Bean.ResultBean> result = bean.getResult();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
        recyle.setLayoutManager(gridLayoutManager);
        MyAdapter myAdapter = new MyAdapter(result);
        myAdapter.setOnlitemClickListener(new MyAdapter.OnlitemClickListener() {
            @Override
            public void OnlitemClick(int presenter) {
                 startActivity(new Intent(getActivity(), SecondActivity.class));
            }
        });
        recyle.setAdapter(myAdapter);
    }

    @Override
    public void onHomeFailure(Throwable throwable) {
        Toast.makeText(getActivity(), "失败", Toast.LENGTH_SHORT).show();
        Log.e("TAG", "onHomeFailure: "+getActivity());
    }

    @Override
    public void onFlowSuccess(FlowBean flowBean) {
        fliw.removeAllViews();
        List<String> tags = flowBean.getTags();
        for (int i = 0; i < tags.size(); i++) {
            String s = tags.get(i);
            fliw.addTag(s);
        }
    }

    @Override
    public void onFlowFailure(Throwable throwable) {

    }
}
