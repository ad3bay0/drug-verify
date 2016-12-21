package com.ad3bay0.drugverify.util;

import android.content.Context;
import android.content.Intent;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

/**
 * Created by root on 12/20/16.
 */

public class DrugVerifyUtil {


    protected static void exitApp(Context context){



        //return intent;

    }


    public static Animation createAnimation(){

        Animation anim = new AlphaAnimation(0.0f,1.0f);
        anim.setDuration(200); //You can manage the blinking time with this parameter
        anim.setStartOffset(20);
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(10);
        return anim;

    }
}
