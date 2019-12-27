package com.bawei.zhangzhenming20191225.view.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bawei.zhangzhenming20191225.R;
import com.bawei.zhangzhenming20191225.base.BaseFragment;
import com.bawei.zhangzhenming20191225.base.BasePresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class OthisFragment extends BaseFragment {


    private TextView textView;

    @Override
    protected BasePresenter providePresenter() {
        return null;
    }

    @Override
    protected void initData() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            String key = arguments.getString("key");
            textView.setText(key);
        }
    }

    @Override
    protected void initView(View inflate) {
        textView = inflate.findViewById(R.id.textView);
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_othis;
    }

    public static OthisFragment getInstance(String valie) {
        OthisFragment othisFragment = new OthisFragment();
        Bundle bundle = new Bundle();
        bundle.putString("key",valie);
        othisFragment.setArguments(bundle);
        return othisFragment;
    }
}
