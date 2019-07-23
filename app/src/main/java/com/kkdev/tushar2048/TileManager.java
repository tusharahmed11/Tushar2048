package com.kkdev.tushar2048;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import com.kkdev.tushar2048.sprites.Sprite;
import com.kkdev.tushar2048.sprites.Tile;

import java.util.ArrayList;
import java.util.HashMap;

public class TileManager implements TileManagerCallback, Sprite {
    private Resources resources;
    private int standardSize, screenWidth, screenHeight;
    private Tile t;
    private ArrayList<Integer> drawable = new ArrayList<>();
    private HashMap<Integer, Bitmap> titleBitmaps = new HashMap<>();
    private Tile[][] matrix = new Tile[4][4];

    public TileManager(Resources resources, int standardSize, int screenWidth, int screenHeight) {
        this.resources = resources;
        this.standardSize = standardSize;
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        initBitmap();

        t = new Tile(screenWidth,screenHeight,standardSize,this,1,1);
        matrix[1][1] = t;
    }
    private void initBitmap(){
        drawable.add(R.drawable.one);
        drawable.add(R.drawable.two);
        drawable.add(R.drawable.three);
        drawable.add(R.drawable.four);
        drawable.add(R.drawable.five);
        drawable.add(R.drawable.six);
        drawable.add(R.drawable.seven);
        drawable.add(R.drawable.eight);
        drawable.add(R.drawable.nine);
        drawable.add(R.drawable.ten);
        drawable.add(R.drawable.eleven);
        drawable.add(R.drawable.twelve);
        drawable.add(R.drawable.thirteen);
        drawable.add(R.drawable.fourteen);
        drawable.add(R.drawable.fifteen);
        drawable.add(R.drawable.sixteen);
        for (int i = 1; i <= 16; i++){
            Bitmap bmp = BitmapFactory.decodeResource(resources, drawable.get(i-1));
            Bitmap tileBmp = Bitmap.createScaledBitmap(bmp, standardSize,standardSize,false);
            titleBitmaps.put(i,tileBmp);
        }
    }

    @Override
    public void draw(Canvas canvas) {
        t.draw(canvas);
    }

    @Override
    public void update() {

    }

    @Override
    public Bitmap getBitmap(int count)
    {
        return titleBitmaps.get(count);
    }
    public void onSwipe(SwipeCallback.Direction direction){
        switch (direction){
            case UP:
                break;
            case DOWN:
                break;
            case LEFT:
                break;
            case RIGHT:
                break;
        }
    }
}
