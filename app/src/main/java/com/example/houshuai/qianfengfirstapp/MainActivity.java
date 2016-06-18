package com.example.houshuai.qianfengfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Window;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.houshuai.fragment.NewsFragment;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        /*初始化试图*/
        initView();
    }

    private void initView() {
        /*toolbar*/
        toolbar = (Toolbar) findViewById(R.id.tb_show);
      setSupportActionBar(toolbar);
        toolbar.setLogo(R.mipmap.ic_launcher);
        toolbar.setTitle("仿QQ新闻");

        /*选择菜单项*/
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.rg_title);
        RadioButton rd = (RadioButton) radioGroup.getChildAt(0);
        rd.setChecked(true);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_showNews:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fl_showTitle, new NewsFragment()).addToBackStack(null).commit();
                        break;
                    case R.id.rb_showIng:
                        RadioButton childAt = (RadioButton) group.getChildAt(0);
                        childAt.setChecked(false);
                        Intent intent = new Intent(MainActivity.this, TwoActivity.class);
                        startActivity(intent);

                        break;
                    default:
                        break;
                }
            }
        });
    }
}
