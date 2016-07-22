package com.nnsuu.suualpha;

import com.nnsuu.suu.Suu;
import com.nnsuu.suu.SuuActivity;
import com.nnsuu.suu.actor.SuuText;
import com.nnsuu.suu.anime.SuuAnime;
import com.nnsuu.suu.other.LoadMode;
import com.nnsuu.suu.scene.SuuScene;

public class Welcome extends SuuActivity {

    @Override
    public void op() {
        Suu.scenes.setScene(new SuuScene() {
            @Override
            public void op() {
                add("welcome",new SuuText("welcome","Suu",960,540,0,300,0,0xff000000,
                        "font/KLS.ttf", LoadMode.Assert));
                add(new SuuAnime("welcome",1200,this){
                    @Override
                    public void ed() {
                        super.ed();
                        Suu.scenes.setScene(new Start());
                    }
                });
                Suu.sounds.setBackgroundSound("sound/test.mp3",LoadMode.Assert);
//                Suu.sounds.play();
            }
        });
    }
}
