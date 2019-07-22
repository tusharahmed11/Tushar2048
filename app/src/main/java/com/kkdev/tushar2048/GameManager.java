package com.kkdev.tushar2048;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.kkdev.tushar2048.sprites.Grid;

public class GameManager extends SurfaceView implements SurfaceHolder.Callback {
    private MainThread thread;
    private Grid grid;


    public GameManager(Context context, AttributeSet attrs){
        super(context, attrs);
        getHolder().addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        thread = new MainThread(holder,this);
        thread.setRunning(true);
        thread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        thread.setSurfaceHolder(holder);
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        while (retry){
            try {
                thread.setRunning(false);
                thread.join();
                retry = false;
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    public void update(){

    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }
}
