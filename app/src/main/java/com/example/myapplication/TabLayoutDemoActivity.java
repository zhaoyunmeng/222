package com.example.myapplication;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.bijie.edu.demo.ui.main.SectionsPagerAdapter;

/**
 * TabLayout 示例
 */
public class TabLayoutDemoActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout_demo);

        // 获取ViewPager对象
        ViewPager viewPager = findViewById(R.id.view_pager);

        // 初始化适配器
        SectionsPagerAdapter sectionsPagerAdapter =
                new SectionsPagerAdapter(this,getSupportFragmentManager());

        // 设置适配器
        viewPager.setAdapter(sectionsPagerAdapter);

        // 获取TabLayout对象
        TabLayout tabs = findViewById(R.id.tabs);

        // 将TabLayout和ViewPager关联起来
        tabs.setupWithViewPager(viewPager);
    }
}