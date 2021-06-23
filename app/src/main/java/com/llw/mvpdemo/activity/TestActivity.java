package com.llw.mvpdemo.activity;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.llw.mvpdemo.R;
import com.llw.mvpdemo.adapter.MainFragmentPagerAdapter;
import com.llw.mvpdemo.fragment.NetworkFragment;
import com.llw.mvpdemo.fragment.NormalFragment;
import com.llw.mvplibrary.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class TestActivity extends BaseActivity {

    List<Fragment> fragmentList = new ArrayList<>();
    MainFragmentPagerAdapter adapter;
    ViewPager viewPager;
    BottomNavigationView bnView;


    @Override
    public void initData(Bundle savedInstanceState) {
        viewPager = findViewById(R.id.vp);
        bnView = findViewById(R.id.bottom_nav_view);
        initViewPager();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_test;
    }

    private void initViewPager() {
        fragmentList.add(new NetworkFragment());
        fragmentList.add(new NormalFragment());

        adapter = new MainFragmentPagerAdapter(fragmentList, getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        //BottomNavigationView 点击事件监听
        bnView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int menuId = menuItem.getItemId();
                // 跳转指定页面：Fragment
                switch (menuId) {
                    case R.id.menu_home:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.menu_mine:
                        viewPager.setCurrentItem(1);
                        break;
                }
                return false;
            }
        });

        // ViewPager 滑动事件监听
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                //将滑动到的页面对应的 menu 设置为选中状态
                bnView.getMenu().getItem(i).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

    }

}
