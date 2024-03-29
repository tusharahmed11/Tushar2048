package com.kkdev.tushar2048.sprites;

import android.graphics.Canvas;

import com.kkdev.tushar2048.TileManagerCallback;

public class Tile implements Sprite {

    private int screenWidth, screenHeight, standardSize;
    private TileManagerCallback callback;
    private int count = 1;
    private int currentX, currentY;
    private int destX, destY;
    private boolean moving = false;
    private int speed = 10;

    public Tile(int screenWidth, int screenHeight, int standardSize, TileManagerCallback callback, int matrixX, int matrixY) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.standardSize = standardSize;
        this.callback = callback;
        currentX = destX = screenWidth / 2 - 2 * standardSize + matrixX +standardSize;
        currentY = destY = screenHeight / 2 - 2 * standardSize + matrixY +standardSize;
    }
    public void move(int matrixX, int matrixY){
        moving = true;
        destX = screenWidth / 2 - 2 * standardSize + matrixX +standardSize;
        destY = screenHeight / 2 - 2 * standardSize + matrixY +standardSize;
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawBitmap(callback.getBitmap(count), screenWidth / 2 - standardSize,  screenHeight / 2 -  standardSize, null);
        if (moving && currentX == destX && currentY == destY){
            moving = false;
        }
    }

    @Override
    public void update() {
        if (currentX < destX){
            if (currentX + speed > destX){
                currentX = destX;
            }else {
                currentX += speed;
            }
        }else if(currentX > destX){
            if (currentX - speed < destX){
                currentX = destX;
            }else {
                currentX -= speed;
            }
        }
        if (currentY < destY){
            if (currentY + speed > destY){
                currentY = destY;
            }else {
                currentY += speed;
            }
        }else if (currentY > destY){
            if (currentY - speed < destY){
                currentY = destY;
            }else {
                currentY -= speed;
            }
        }
    }
}
