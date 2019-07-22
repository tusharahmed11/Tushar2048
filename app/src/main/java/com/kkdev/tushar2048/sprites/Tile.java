package com.kkdev.tushar2048.sprites;

import android.graphics.Canvas;

import com.kkdev.tushar2048.TileManagerCallback;

public class Tile implements Sprite {

    private int screenWidth, screenHeight, standardSize;
    private TileManagerCallback callback;
    private int count = 1;

    public Tile(int screenWidth, int screenHeight, int standardSize, TileManagerCallback callback) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.standardSize = standardSize;
        this.callback = callback;
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawBitmap(callback.getBitmap(count), screenWidth/2 - standardSize, screenHeight /2 - standardSize, null);
    }

    @Override
    public void update() {

    }
}