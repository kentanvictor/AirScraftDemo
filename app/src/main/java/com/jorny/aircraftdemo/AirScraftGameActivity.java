package com.jorny.aircraftdemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import com.jorny.aircraftdemo.Server.MusicServer;
import com.jorny.aircraftdemo.model.SettingInfo;
import com.jorny.aircraftdemo.view.AirCraftDisPlayView;

public class AirScraftGameActivity extends AppCompatActivity {
    public final static String KEY_SETTING_INFO = "settingInfo";
    private AirCraftDisPlayView mAirPlayView;
    private boolean isSystemDialog;
    private boolean isVoiceOpen;
    private MusicServer mMusicServer;
    private SettingInfo mSettingInfo;
    private boolean isBulleInfinite;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initWindow();
        setContentView(R.layout.airscraft_game_activity);

        Intent intent = getIntent();
        //得到传递过来的数据
        mSettingInfo= intent.getParcelableExtra(KEY_SETTING_INFO);
        isSystemDialog =mSettingInfo.isSysDialog();
        isVoiceOpen = mSettingInfo.isVoiceOpen();
        isBulleInfinite = mSettingInfo.isBulleInfinite();
        mAirPlayView = (AirCraftDisPlayView) findViewById(R.id.airPlayView);
        int dialogType = AirCraftDisPlayView.DIALOG_TYPE_NATIVE ;
        mAirPlayView.setDialogType(dialogType);
        mAirPlayView.setBulleInfinite(isBulleInfinite);
        if (isVoiceOpen) {
            mMusicServer = new MusicServer();
            mAirPlayView.setGameStatusChangeListener(new AirCraftDisPlayView.GameStatusChangeListener() {
                @Override
                public void onGameStatusChange(int status) {
                    switch (status) {
                        case AirCraftDisPlayView.STATUS_GAME_PAUSED:
                            mMusicServer.pause();
                            break;
                        case AirCraftDisPlayView.STATUS_GAME_STARTED:
                            mMusicServer.play();
                            break;
                        case AirCraftDisPlayView.STATUS_GAME_OVER:
                            mMusicServer.stop();
                            break;
                    }
                }
            });
        }
        mAirPlayView.startByReady();

    }

    /***
     * 初始化Windows
     */
    private  void initWindow()
    {
        //设置无标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //设置全屏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // fixBug为解决设置主题为NoActionBar后 Canvas.getHeight为0的bug.
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }

    public static void navigate(Context context, SettingInfo settingInfo) {
        Intent intent = new Intent(context, AirScraftGameActivity.class);
        intent.putExtra(KEY_SETTING_INFO,settingInfo);
        context.startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mMusicServer!=null)
        {
            mMusicServer.releasePlayer();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mMusicServer != null) {
            mMusicServer.pause();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mMusicServer != null) {
            mMusicServer.play();
        }
    }
}
