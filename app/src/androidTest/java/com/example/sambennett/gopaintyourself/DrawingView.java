package com.example.sambennett.gopaintyourself;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import java.util.Vector;

/**
 * Created by sambennett on 3/20/15.
 */
public class DrawingView extends View {

    private int currentWidth;
    private int currentHeight;
    private Vector<Object> drawOrder;

    public DrawingView(Context context) {
        this(context, null, 0);
    }

    public DrawingView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DrawingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);


    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        currentWidth = w;
        currentHeight = h;
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);



    }
}
