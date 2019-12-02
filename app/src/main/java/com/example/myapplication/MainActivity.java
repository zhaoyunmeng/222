package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //设置布局文件
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.text);

        //获取Intent对象
        Intent intent = getIntent();
        // 取出Intent传递值
        String username = intent.getStringExtra("key_username");
        // 设置文本框的内容
        textView.setText(username);


        TextView tvBack = findViewById(R.id.back);
        tvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent();
                i.putExtra("key_result", "毕节学院");
                // 将数据传递上一个页面
                setResult(Activity.RESULT_OK, i);
                finish();
            }
        });

    }

}
