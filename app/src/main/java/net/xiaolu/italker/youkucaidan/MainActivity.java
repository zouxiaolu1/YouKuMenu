package net.xiaolu.italker.youkucaidan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView iv_home,iv_menu;
    private boolean isShowLevel2 = true;//是否显示二级菜单
    private boolean isShowLevel3 = true;//是否显示三级菜单
    private boolean isShowMenu = true;
    private RelativeLayout level1,level2,level3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initListener();

    }

    private void initListener() {
        iv_home.setOnClickListener(this);
        iv_menu.setOnClickListener(this);
    }

    private void initView() {
        setContentView(R.layout.activity_main);
        iv_home= (ImageView) findViewById(R.id.iv_home);
        iv_menu= (ImageView) findViewById(R.id.iv_menu);
        level1= (RelativeLayout) findViewById(R.id.level1);
        level2= (RelativeLayout) findViewById(R.id.level2);
        level3= (RelativeLayout) findViewById(R.id.level3);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_MENU){

            if(isShowMenu){

                int startOffset = 0;
                if(isShowLevel3){
                   AnimUtil.closeMenu(level3,startOffset);
                    isShowLevel3 =false;
                    startOffset += 200;
                }
                if(isShowLevel2){
                    AnimUtil.closeMenu(level2,startOffset);
                    isShowLevel2 =false;
                    startOffset +=200;
                }
                AnimUtil.closeMenu(level1,startOffset);
            }else {

                AnimUtil.showMenu(level1,0);
                AnimUtil.showMenu(level2,0);
                isShowLevel2 = true;
                AnimUtil.showMenu(level3,0);
                isShowLevel3 =true;

            }
            isShowMenu = !isShowMenu;
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.iv_home:
                if(AnimUtil.animCount != 0){
                    return;
                }
                if(isShowLevel2){
                    int startOffset = 0;
                    if(isShowLevel3){
                        AnimUtil.closeMenu(level3,startOffset);
                        startOffset +=200;
                        isShowLevel3 = false;
                    }
                    AnimUtil.closeMenu(level2,startOffset);
                }else {
                    AnimUtil.showMenu(level2,0);
                }
                isShowLevel2 = !isShowLevel2;
                break;
            case R.id.iv_menu:
                if(AnimUtil.animCount != 0){
                    return;
                }
                if(isShowLevel3){
                    AnimUtil.closeMenu(level3,0);
                }else {

                    AnimUtil.showMenu(level3,0);
                }
                isShowLevel3=!isShowLevel3;
                break;
            default:
                break;
        }
    }
}
