package com.jorny.aircraftdemo.model.EnemyAirCraft;


import android.graphics.Bitmap;

/***
 * 战斗机
 */
public class FighterPlane extends EnemyAirCraft {
    public final static String TAG = FighterPlane.class.getSimpleName();

    public FighterPlane(Bitmap bitmap) {
        super(bitmap);
        mMaxLife = 4;
        mScore = 400;
        mOriginalSpeed = 3;
        initEnemyAirCraftInfo();
    }
}
