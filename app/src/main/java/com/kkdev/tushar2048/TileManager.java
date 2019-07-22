package com.kkdev.tushar2048;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;

import com.kkdev.tushar2048.sprites.Sprite;
import com.kkdev.tushar2048.sprites.Tile;

import java.util.HashMap;

public class TileManager implements TileManagerCallback, Sprite {
    private Resources resources;
    private int standardSize, screenWidth, screenHeight;
    private Tile t;
    private HashMap<Integer, Bitmap> titleBitmaps = new HashMap<>();

    public TileManager(Resources resources, int standardSize, int screenWidth, int screenHeight) {
        this.resources = resources;
        this.standardSize = standardSize;
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        initBitmap();

        t = new Tile(screenWidth,screenHeight,standardSize,this);

    }
    private void initBitmap(){
        //start from here
    }

    @Override
    public void draw(Canvas canvas) {
        t.draw(canvas);
    }

    @Override
    public void update() {

    }

    @Override
    public Bitmap getBitmap(int count) {
        return null;
    }
}
