package com.example.sathishkumar.drawing;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by sathish kumar on 19-06-2016.
 */


public class drawing extends View {

    public drawing(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
    }
    public int x=50,y=50;


    int radius =40;
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        // Use Color.parseColor to define HTML colors
        paint.setColor(Color.parseColor("#CD5C5C"));
        canvas.drawCircle(x, y, radius, paint);
    }
}