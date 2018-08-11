package net.xiaolu.italker.youkucaidan;

import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.RelativeLayout;

/**
 * Created by 何丽婷 on 2018/8/10.
 */
public class AnimUtil {
    public static int animCount = 0;
    public static void closeMenu(RelativeLayout rl,int setStartOffset){

        for(int i=0;i<rl.getChildCount();i++){
            rl.getChildAt(i).setEnabled(false);
        }

        RotateAnimation animation=new RotateAnimation(0,-180, Animation.RELATIVE_TO_SELF,0.5f
                ,Animation.RELATIVE_TO_SELF,1);
        animation.setDuration(500);
        animation.setFillAfter(true);
        animation.setStartOffset(setStartOffset);
        animation.setAnimationListener(new MyAnimationListener());
        rl.startAnimation(animation);
    }

    public static void showMenu(RelativeLayout rl,int setStartOffset){

        for(int i=0;i<rl.getChildCount();i++){
            rl.getChildAt(i).setEnabled(true);
        }

        RotateAnimation animation=new RotateAnimation(-180,0, Animation.RELATIVE_TO_SELF,0.5f
                ,Animation.RELATIVE_TO_SELF,1);
        animation.setDuration(500);
        animation.setFillAfter(true);
        animation.setStartOffset(setStartOffset);
        animation.setAnimationListener(new MyAnimationListener());
        rl.startAnimation(animation);
    }
    static class MyAnimationListener implements Animation.AnimationListener{

        @Override
        public void onAnimationStart(Animation animation) {
            animCount++;
        }

        @Override
        public void onAnimationEnd(Animation animation) {

            animCount--;
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    }
}
