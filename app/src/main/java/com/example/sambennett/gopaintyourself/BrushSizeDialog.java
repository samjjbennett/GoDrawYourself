package com.example.sambennett.gopaintyourself;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

/**
 * Created by Jason on 3/22/2015.
 */
public class BrushSizeDialog {

    private  float  brushSize;
    DrawingView drawingView;
    public Activity activity;
    public Dialog dialog;
    public Button yes, no;
    //brush sizes
    private final float SMALLBRUSH = 10;
    private final float MEDIUMBRUSH = 20;
    private final float LARGEBRUSH = 30;

    public BrushSizeDialog(Activity a) {
        this.activity = a;
        // TODO Auto-generated constructor stub
        this.activity = a;


    }
    public void setBrushSizeDialog(View v,final DrawingView drawingView){
        final Dialog brushDialog = new Dialog(activity);
        brushDialog.setTitle("Brush size:");
        brushDialog.setContentView(R.layout.brush_chooser);
        //listen for clicks on size buttons
        ImageButton smallBtn = (ImageButton)brushDialog.findViewById(R.id.small_brush);
        smallBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                drawingView.setErase(false);
                drawingView.setBrushSize(SMALLBRUSH);
                drawingView.setLastBrushSize(SMALLBRUSH);
                brushDialog.dismiss();
            }
        });
        ImageButton mediumBtn = (ImageButton)brushDialog.findViewById(R.id.medium_brush);
        mediumBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                drawingView.setErase(false);
                drawingView.setBrushSize(MEDIUMBRUSH);
                drawingView.setLastBrushSize(MEDIUMBRUSH);
                brushDialog.dismiss();
            }
        });
        ImageButton largeBtn = (ImageButton)brushDialog.findViewById(R.id.large_brush);
        largeBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                drawingView.setErase(false);
                drawingView.setBrushSize(LARGEBRUSH);
                drawingView.setLastBrushSize(LARGEBRUSH);
                brushDialog.dismiss();
            }
        });
        //show and wait for user interaction
        brushDialog.show();


    }

    public void setBrushEraseSize(View v, final DrawingView drawingView){
        //switch to erase - choose size
        final Dialog eraseDialog = new Dialog(activity);
        eraseDialog.setTitle("Eraser size:");
        eraseDialog.setContentView(R.layout.brush_chooser);
        //size buttons
        ImageButton smallBtn = (ImageButton)eraseDialog.findViewById(R.id.small_brush);
        smallBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                drawingView.setErase(true);
                drawingView.setBrushSize(SMALLBRUSH);
                eraseDialog.dismiss();
            }
        });
        ImageButton mediumBtn = (ImageButton)eraseDialog.findViewById(R.id.medium_brush);
        mediumBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                drawingView.setErase(true);
                drawingView.setBrushSize(MEDIUMBRUSH);
                eraseDialog.dismiss();
            }
        });
        ImageButton largeBtn = (ImageButton)eraseDialog.findViewById(R.id.large_brush);
        largeBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                drawingView.setErase(true);
                drawingView.setBrushSize(LARGEBRUSH);
                eraseDialog.dismiss();
            }
        });
        //show and wait for user interaction
        eraseDialog.show();
    }
}
