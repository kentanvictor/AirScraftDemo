package com.jorny.aircraftdemo.model.Bullet;

import android.graphics.Bitmap;

public class SuperBullet extends Bullet {
    public static final String TAG = Bullet.class.getSimpleName();

    public SuperBullet(Bitmap bitmap) {
        super(bitmap);
        setSpeed(-10);
        mPower = 2;
    }

}
