package com.nnsuu.suualpha;

import android.os.Bundle;

import com.nnsuu.suu.Suu;
import com.nnsuu.suu.SuuActivity;
import com.nnsuu.suu.scene.SuuScene;

public class Welcome extends SuuActivity {

    @Override
    public void op() {
        Suu.scenes.setScene(new SuuScene() {
            @Override
            public void op() {

            }
        });
    }
}
