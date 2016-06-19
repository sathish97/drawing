package com.example.sathishkumar.drawing;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {

    public drawing s;
    int height= Resources.getSystem().getDisplayMetrics().heightPixels;
    int width= Resources.getSystem().getDisplayMetrics().widthPixels;
    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }
    public int getTitleBarHeight(){
        int viewtop = getWindow().findViewById(Window.ID_ANDROID_CONTENT).getTop();
        return  viewtop;
    }
        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button left = (Button) findViewById(R.id.left);
        Button right= (Button) findViewById(R.id.right);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.rr1);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        params.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
        drawing detailView= new drawing(this);
        relativeLayout.addView(detailView,params);
        s=detailView;

    }

    public void left(View view) {

        if(s.x<=0){
            s.x=width-s.radius;
        }
        else{
            s.x-=10;
        }
        s.invalidate();
    }
    public void right(View view) {

        if(s.y>=width){
            s.x=s.radius;
        }
        else{
            s.x+=10;
        }

        s.invalidate();

    }
    public void up(View view) {
        if(s.y<=0){
            s.y=height-getStatusBarHeight()-getTitleBarHeight()-s.radius;
        }
        else{
            s.y-=10;
        }
        s.invalidate();

    }
    public void down(View view) {
        if(s.y>=height-getStatusBarHeight()-getTitleBarHeight()){
            s.y=s.radius;
        }
        else{
            s.y+=10;
        }
        s.invalidate();

    }
}


