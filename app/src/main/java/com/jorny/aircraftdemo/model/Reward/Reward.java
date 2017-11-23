package com.jorny.aircraftdemo.model.Reward;


import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.jorny.aircraftdemo.model.LinearRunAirCraft;

/***
 * 宝贝
 */
public class Reward extends LinearRunAirCraft {

    public Reward(Bitmap bitmap){
        super(bitmap);
        mSpeed = 2;
        setSpeed(mSpeed);
    }
}