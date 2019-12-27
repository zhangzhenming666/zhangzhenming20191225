package com.bawei.day1.view.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bawei.day1.R;
import com.bawei.day1.base.BaseFragment;
import com.bawei.day1.base.BasePresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class OthisFragment extends BaseFragment {

    private TextView text_view;

    @Override
    protected void initView(View inflate) {
        text_view = inflate.findViewById(R.id.text_view);
    }

    @Override
    protected BasePresenter providerPresenter() {
        return null;
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_othis;
    }

    @Override
    protected void initData() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            String key = arguments.getString("key");
            text_view.setText(key);
        }
    }
    public static OthisFragment getInstance(String valie) {
        OthisFragment othisFragment = new OthisFragment();
        Bundle bundle = new Bundle();
        bundle.putString("key",valie);
        othisFragment.setArguments(bundle);
        return othisFragment;
    }

}
