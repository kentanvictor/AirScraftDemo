package com.jorny.aircraftdemo.model.EnemyAirCraft;

import android.graphics.Bitmap;

/***
 * 巡洋舰
 */
public class CruiserPlane extends EnemyAirCraft {
    public final static String TAG = CruiserPlane.class.getSimpleName();

    public CruiserPlane(Bitmap bitmap) {
        super(bitmap);
        mMaxLife = 8;
        mScore = 1000;
        mOriginalSpeed = 1;
        initEnemyAirCraftInfo();
    }
}
