package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class SettingsActivity extends AppCompatActivity
{

    private Context context;

    private TextView tvUsername;
    private TextView tvPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);


        tvUsername = findViewById(R.id.username);
        tvPwd = findViewById(R.id.pwd);

        context = this;
         // 获取传递的数据，返回 Bundle 对象
//        Bundle bundle = getIntent().getExtras();
//         //  通过Bundle对象获取具体的值
//        String value = bundle.getString("key", "");
//        Log.d("------key------", value);


//        String username = SharedPreferenceUtil.getString(context, "username");
//        String pwd = SharedPreferenceUtil.getString(context, "pwd");

//        tvUsername.setText(username);
//        tvPwd.setText(pwd);

    }


    public void testClick()
    {

    }

    /**
     * 点击返回键时调用
     */
    @Override
    public void onBackPressed()
    {
//        super.onBackPressed();
        // Intent 对象保存返回的数据
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("result", "result");
        // 正常返回，必须设置为Activity.RESULT_OK
        intent.putExtras(bundle);
        // 设置返回码，并携带传递的数据
        setResult(Activity.RESULT_OK, intent);
        finish();
    }
}
