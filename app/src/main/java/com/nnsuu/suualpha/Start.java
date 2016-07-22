package com.nnsuu.suualpha;

import com.nnsuu.suu.Suu;
import com.nnsuu.suu.actor.SuuActor;
import com.nnsuu.suu.actor.SuuButton;
import com.nnsuu.suu.actor.SuuText;
import com.nnsuu.suu.other.LoadMode;
import com.nnsuu.suu.scene.SuuScene;

/**
 * Created by user on 16-7-19.
 */
public class Start extends SuuScene{
    @Override
    public void op() {
        add("default_background1",new SuuActor("default_background",
                "png/default_background.png",
                960,540,1920,1080,LoadMode.Assert){
            @Override
            public void play() {
                if(getX()>=2880){
                    setX(-960);
                }
                setX(getX()+2);
            }
        });
        add("default_background2",new SuuActor("default_background",
                "png/default_background.png",
                -960,540,1920,1080,LoadMode.Assert){
            @Override
            public void play() {
                if(getX()>=2880){
                    setX(-960);
                }
                setX(getX()+2);
            }
        });

        add("default_title",new SuuText("default_title","Test Page",960,800,0,250,0,0xff000000,
                "font/KLS.ttf", LoadMode.Assert));

        add("default_button1",new SuuButton("default_button1",
                "png/default_button.png",960,350,550,100,1,2,
                "测试按钮",35,0xffffffff,null,LoadMode.Assert){
            @Override
            public void play() {
            }

            @Override
            public void touchDown() {
                setPlayID(6);
            }

            @Override
            public void touchMove(int x, int y) {
                if (!inActor(x,y)){
                    setPlayID(0);
                    retouch();
                }
            }

            @Override
            public void touchUp(int x, int y) {
                setPlayID(0);
            }
        });
        add("default_button2",new SuuButton("default_button2",
                "png/default_button.png",960,225,550,100,1,2,
                "button",35,0xffffffff,null,LoadMode.Assert){
            @Override
            public void play() {
            }

            @Override
            public void touchDown() {
                setPlayID(6);
            }

            @Override
            public void touchMove(int x, int y) {
                if (!inActor(x,y)){
                    setPlayID(0);
                    retouch();
                }
            }

            @Override
            public void touchUp(int x, int y) {
                setPlayID(0);
            }
        });

        add("default_fps",new SuuText("default_fps","fps:"+fps,1860,30,0,30,0,0xff000000));
    }

    @Override
    public void back() {
        super.back();
        Suu.app.finish();
    }

    @Override
    public void play() {
        super.play();
        fps++;
        if(System.currentTimeMillis()-time>=1000){
            ((SuuText)get("default_fps")).update("fps:"+fps);
            time = System.currentTimeMillis();
            fps = 0;
        }
    }

    long time = 0;
    int fps = 0;
}
