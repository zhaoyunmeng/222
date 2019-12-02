package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * readme
 */
public class LoginActivity extends AppCompatActivity
{
    private Context context;

    private EditText edtUsername;

    private EditText edtPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        context = this;

        // 通过id找到布局文件的控件
        edtUsername = findViewById(R.id.edit_username);
        edtPwd = findViewById(R.id.edit_password);
        TextView btnLogin = findViewById(R.id.tv_log_in);

        // 注册点击事件
        btnLogin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // 取出输入框里面的文本并转化为字符串
                String username = edtUsername.getText().toString();
                String pwd = edtPwd.getText().toString();

                // 判断输入的内容是否为空
                // username == null || username == ""
                if (username == null || username == "")
                {
                    Toast.makeText(context, "请输入用户名", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(pwd))
                {
                    Toast.makeText(context, "请输入密码", Toast.LENGTH_SHORT).show();
                    return;
                }

                // 创建一个intent对象
                Intent intent = new Intent(context, SettingsActivity.class);
                // 传递数据 以键值对的形式
                intent.putExtra("key_username", username);
                intent.putExtra("key_pwd", pwd);
                // 跳转到目标ctivity,该方法不能从目标Activity返回数据
                startActivity(intent);

                // 跳转到目标Activity，并且能够从目标Activity返回数据
//                startActivityForResult(intent, 1);
//                startActivityForResult(intent, 2);
            }
        });
    }


    /**
     * 接收从目标Activity返回的数据
     * @param requestCode 请求码，用于区分是那个方法执行的跳转
     * @param resultCode 返回码，正常情况下返回Activity.RESULT_OK
     * @param intent 返回的数据
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent intent)
    {
        super.onActivityResult(requestCode, resultCode, intent);
        // 先判断结果码
        if (resultCode == Activity.RESULT_OK)
        {
            // 在判断返回码
            if (requestCode == 1)
            {
                // 处理结果
                String result = intent.getStringExtra("key_result");
                edtUsername.setText(result);
            }
        }
    }

}
