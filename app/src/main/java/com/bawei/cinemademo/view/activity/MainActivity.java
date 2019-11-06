package com.bawei.cinemademo.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.bawei.cinemademo.R;
import com.bawei.cinemademo.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @describe(描述)：MainActivity
 * @data（日期）: 2019/11/5
 * @time（时间）: 17:04
 * @author（作者）: 盖磊
 **/
public class MainActivity extends BaseActivity {

    @BindView(R.id.main_text)
    TextView mainText;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        mainText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,LoginActivity.class));
            }
        });
    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        // TODO: add setContentView(...) invocation
//        ButterKnife.bind(this);
//    }
}
