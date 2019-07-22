package com.kkdev.tushar2048;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class MainThread extends Thread {

    private SurfaceHolder surfaceHolder;
    private GameManager gameManager;
    private int targetFps = 60;
    private Canvas canvas;
    private boolean running;

    public MainThread(SurfaceHolder surfaceHolder, GameManager gameManager){
        super();
        this.surfaceHolder = surfaceHolder;
        this.gameManager = gameManager;
    }
    public void setRunning(boolean isRunning){
        running = isRunning;
    }
    public void setSurfaceHolder(SurfaceHolder surfaceHolder){
        this.surfaceHolder = surfaceHolder;
    }

    @Override
    public void run() {
        long startTime, tileMills, wailTime;
        long targetTime = 1000 / targetFps;

        while (running){
            startTime = System.nanoTime();
            canvas = null;
            try {
                canvas = surfaceHolder.lockCanvas();
                synchronized (surfaceHolder){
                    gameManager.update();
                    gameManager.draw(canvas);
                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                if (canvas != null){
                    try {
                        surfaceHolder.unlockCanvasAndPost(canvas);

                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
            tileMills = (System.nanoTime()-startTime) / 1000000;
            wailTime = targetTime - tileMills;
            try {
                if (wailTime > 0 ){
                    sleep(wailTime);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }
}
