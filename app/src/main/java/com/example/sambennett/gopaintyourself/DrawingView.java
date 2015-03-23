package com.example.sambennett.gopaintyourself;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import java.util.Vector;

/**
 * Created by sambennett on 3/20/15.
 */
public class DrawingView extends View {

    private int currentWidth;
    private int currentHeight;
    private Vector<Object> drawOrder;
    //initial color BLACK
    private int paintColor = 0xFF000000;
    //brush sizes
    private float brushSize, lastBrushSize;
    //erase flag
    private boolean erase=false;

    private Bitmap bitmap;

    public DrawingView(Context context) {
        this(context, null, 0);
    }
    public DrawingView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }
    public DrawingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setupDrawing();

    }

    public void setupDrawing(){


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

    //update color
    public void setColor(int newColor){
        paintColor = newColor;
    }

    //set brush size
    public void setBrushSize(float newSize){
        float pixelAmount = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                newSize, getResources().getDisplayMetrics());
        brushSize=pixelAmount;
    }

    //get and set last brush size
    public void setLastBrushSize(float lastSize){
        lastBrushSize=lastSize;
    }
    public float getLastBrushSize(){
        return lastBrushSize;
    }

    //set erase true or false
    public void setErase(boolean isErase){
        erase=isErase;
    }

    //start new drawing
    public void startNew(){
    }
    public void setBitmap(int id){
        bitmap = BitmapFactory.decodeResource(getResources(),id);
        //Clear canvas
        // This adds the image to the canvas
        // drawBitmap(bitmap, new Matrix(), null);
    }
}
