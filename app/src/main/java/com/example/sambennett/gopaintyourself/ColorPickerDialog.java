package com.example.sambennett.gopaintyourself;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * Created by Jason on 3/22/2015.
 */
public class ColorPickerDialog {
    Activity activity;

    //colors
    private final int[] COLORS = { 0xffca0029,0xffff0000,0xffffcc07,0xff20ff8c,
                                   0xfff7ff0c,0xff009900,0xff990f8a,0xfffbff65,
                                   0xff0000ff,0xff9294d0,0xff49ff0a,0xffffcfee,
                                   0xff15fdff,0xffdc94ff,0xffffcc07,0xff000000};
    //color image buttons
    ImageButton[] colorBtns;
    private int paintColor;
    public ColorPickerDialog(Activity a) {
        this.activity = a;
        colorBtns = new ImageButton[16];
    }

    public void colorDialog(View v,final ImageButton currentColor, final DrawingView drawingView){

        drawingView.setErase(false);

       // currentColor = (ImageButton)v.findViewById(R.id.color_picker);
        final Dialog colorDialog = new Dialog(activity);
        colorDialog.setTitle("Eraser size:");
        colorDialog.setContentView(R.layout.color_chooser);


        colorBtns[0] = (ImageButton) colorDialog.findViewById(R.id.maroon);
        colorBtns[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paintColor = COLORS[0];

                currentColor.setBackgroundColor(paintColor);
                colorDialog.dismiss();
            }
        });
        colorBtns[1] = (ImageButton) colorDialog.findViewById(R.id.red);
        colorBtns[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paintColor =COLORS[1];
                drawingView.setColor(paintColor);
                currentColor.setBackgroundColor(paintColor);
                colorDialog.dismiss();
            }
        });
        colorBtns[2] = (ImageButton) colorDialog.findViewById(R.id.orange);
        colorBtns[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paintColor = COLORS[2];
                drawingView.setColor(paintColor);
                currentColor.setBackgroundColor(paintColor);
                colorDialog.dismiss();
            }
        });
        colorBtns[3] = (ImageButton) colorDialog.findViewById(R.id.light_green);
        colorBtns[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paintColor = COLORS[3];
                drawingView.setColor(paintColor);
                currentColor.setBackgroundColor(paintColor);
                colorDialog.dismiss();
            }
        });
        colorBtns[4] = (ImageButton) colorDialog.findViewById(R.id.yellow);
        colorBtns[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paintColor = COLORS[4];
                drawingView.setColor(paintColor);
                currentColor.setBackgroundColor(paintColor);
                colorDialog.dismiss();
            }
        });
        colorBtns[5] = (ImageButton) colorDialog.findViewById(R.id.green);
        colorBtns[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paintColor = COLORS[5];
                drawingView.setColor(paintColor);
                currentColor.setBackgroundColor(paintColor);
                colorDialog.dismiss();
            }
        });
        colorBtns[6] = (ImageButton) colorDialog.findViewById(R.id.purple);
        colorBtns[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paintColor = COLORS[6];
                drawingView.setColor(paintColor);
                currentColor.setBackgroundColor(paintColor);
                colorDialog.dismiss();
            }
        });
        colorBtns[7] = (ImageButton) colorDialog.findViewById(R.id.light_yellow);
        colorBtns[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paintColor = COLORS[7];
                drawingView.setColor(paintColor);
                currentColor.setBackgroundColor(paintColor);
                colorDialog.dismiss();
            }
        });
        colorBtns[8] = (ImageButton) colorDialog.findViewById(R.id.blue);
        colorBtns[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paintColor = COLORS[8];
                drawingView.setColor(paintColor);
                currentColor.setBackgroundColor(paintColor);
                colorDialog.dismiss();
            }
        });
        colorBtns[9] = (ImageButton) colorDialog.findViewById(R.id.light_blue);
        colorBtns[9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paintColor = COLORS[9];
                drawingView.setColor(paintColor);
                currentColor.setBackgroundColor(paintColor);
                colorDialog.dismiss();
            }
        });
        colorBtns[10] = (ImageButton) colorDialog.findViewById(R.id.neon_green);
        colorBtns[10].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paintColor = COLORS[10];
                drawingView.setColor(paintColor);
                currentColor.setBackgroundColor(paintColor);
                colorDialog.dismiss();
            }
        });
        colorBtns[11] = (ImageButton) colorDialog.findViewById(R.id.light_pink);
        colorBtns[11].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paintColor = COLORS[11];
                drawingView.setColor(paintColor);
                currentColor.setBackgroundColor(paintColor);
                colorDialog.dismiss();
            }
        });
        colorBtns[12] = (ImageButton) colorDialog.findViewById(R.id.turquoise);
        colorBtns[12].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paintColor =COLORS[12];
                drawingView.setColor(paintColor);
                currentColor.setBackgroundColor(paintColor);
                colorDialog.dismiss();
            }
        });
        colorBtns[13] = (ImageButton) colorDialog.findViewById(R.id.pink);
        colorBtns[13].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paintColor = COLORS[13];
                drawingView.setColor(paintColor);
                currentColor.setBackgroundColor(paintColor);
                colorDialog.dismiss();
            }
        });
        colorBtns[14] = (ImageButton) colorDialog.findViewById(R.id.light_purple);
        colorBtns[14].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paintColor =COLORS[14];
                drawingView.setColor(paintColor);
                currentColor.setBackgroundColor(paintColor);
                colorDialog.dismiss();
            }
        });
        colorBtns[15] = (ImageButton) colorDialog.findViewById(R.id.black);
        colorBtns[15].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paintColor = COLORS[15];
                drawingView.setColor(paintColor);
                currentColor.setBackgroundColor(paintColor);
                colorDialog.dismiss();
            }
        });
        colorDialog.show();


    }

}
