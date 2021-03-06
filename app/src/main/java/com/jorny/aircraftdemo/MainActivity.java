package com.jorny.aircraftdemo;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;

import com.jorny.aircraftdemo.model.SettingInfo;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private RadioButton mCanvasDialogRbtn;
    private RadioButton mSysDialogRbtn;
    private RadioButton mVoiceOpenRbtn;
    private RadioButton mVoiceCloseRbtn;
    private RadioButton mInfiniteCloseRbtn;
    private RadioButton mInfiniteOpenRbtn;
    private SettingInfo mSettingInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("设置");
        //获取控件id
        mVoiceOpenRbtn = (RadioButton) findViewById(R.id.voice_open_rbtn);
        mVoiceCloseRbtn = (RadioButton) findViewById(R.id.voice_close_rbtn);
        mInfiniteOpenRbtn = (RadioButton) findViewById(R.id.infinite_open_rbtn);
        mInfiniteCloseRbtn = (RadioButton) findViewById(R.id.infinite_close_rbtn);
        //设置监听事件
        mVoiceOpenRbtn.setOnCheckedChangeListener(this);
        mVoiceCloseRbtn.setOnCheckedChangeListener(this);
        mInfiniteOpenRbtn.setOnCheckedChangeListener(this);
        mInfiniteCloseRbtn.setOnCheckedChangeListener(this);
        //保存初始条件
        mSettingInfo = new SettingInfo(mVoiceOpenRbtn.isChecked(),  mInfiniteOpenRbtn.isChecked());
    }
    //进行跳转
    public void startGame(View view) {
        AirScraftGameActivity.navigate(MainActivity.this, mSettingInfo);
    }
    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
        if (checked) {
            switch (compoundButton.getId()) {
                case R.id.voice_open_rbtn:
                    mSettingInfo.setVoiceOpen(true);
                    break;
                case R.id.voice_close_rbtn:
                    mSettingInfo.setVoiceOpen(false);
                    break;
                case R.id.infinite_open_rbtn:
                    mSettingInfo.setBulleInfinite(true);
                    break;
                case R.id.infinite_close_rbtn:
                    mSettingInfo.setBulleInfinite(false);
                    break;
            }
        }
    }
}
