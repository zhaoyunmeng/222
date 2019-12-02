package com.example.myapplication;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.loader.ImageLoader;

public class GlideImageLoader extends ImageLoader
{
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {

        //Glide 加载图片简单用法
        Glide.with(context).load(path)
                .placeholder(R.drawable.bg_banner)
                .error(R.drawable.bg_banner)
                .into(imageView);

//        int imgRes = (int) path;
//        // 加载本地图片
//        imageView.setImageResource(imgRes);

    }

}