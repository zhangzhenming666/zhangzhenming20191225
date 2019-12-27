package com.bawei.day1.view.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import com.bawei.day1.R;
import com.bawei.day1.base.BaseActivity;
import com.bawei.day1.base.BaseFragment;
import com.bawei.day1.base.BasePresenter;
import com.bawei.day1.view.fragment.HomeFragment;
import com.bawei.day1.view.fragment.OthisFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private ViewPager viewPager;
    private RadioGroup rg;
    List<Fragment> fragmentList = new ArrayList<>();


    @Override
    protected void initData() {
        HomeFragment homeFragment = new HomeFragment();
        OthisFragment fenleiFragment = OthisFragment.getInstance("分类");
        OthisFragment faxianFragment = OthisFragment.getInstance("发现");
        OthisFragment gouwuFragment = OthisFragment.getInstance("购物车");
        OthisFragment myFragment = OthisFragment.getInstance("我的");
        fragmentList.add(homeFragment);
        fragmentList.add(fenleiFragment);
        fragmentList.add(faxianFragment);
        fragmentList.add(gouwuFragment);
        fragmentList.add(myFragment);

        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }
        });

    }

    @Override
    protected void initView() {
        viewPager =  findViewById(R.id.viewPager);
        rg =  findViewById(R.id.rg);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                rg.check(rg.getChildAt(position).getId());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rb:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.rb1:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.rb2:
                        viewPager.setCurrentItem(2);
                        break;
                    case R.id.rb3:
                        viewPager.setCurrentItem(3);
                        break;
                    case R.id.rb4:
                        viewPager.setCurrentItem(4);
                        break;
                }
            }
        });
    }

    @Override
    protected BasePresenter providePresenter() {
        return null;
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }
}
