package com.example.sambennett.gopaintyourself;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;
import java.util.UUID;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    ImagePicker imagePicker;
    //custom drawing view
    private DrawingView drawingView;
    //buttons
    private ImageButton currColor, drawBtn, eraseBtn, newBtn, saveBtn;
    Cursor cursor;
    BrushSizeDialog brushSizeDialog;
    ColorPickerDialog colorPickerDialog;
    //colors
    private final int[] COLORS = {0xffca0029, 0xffff0000, 0xffffcc07, 0xff20ff8c,
            0xfff7ff0c, 0xff009900, 0xff990f8a, 0xfffbff65,
            0xff0000ff, 0xff9294d0, 0xff49ff0a, 0xffffcfee,
            0xff15fdff, 0xffdc94ff, 0xffffcc07, 0xff000000};

    private float brushSize = 10;
    private int colorNumber;
    private boolean isErase = false;

    //color picker
    ImageButton colorPicker;
    ImageButton bitmapImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //get drawing view
        drawingView = (DrawingView) findViewById(R.id.drawing_view);

        //color button
        currColor = (ImageButton) findViewById(R.id.color_picker);
        currColor.setBackgroundColor((COLORS[15]));

        //draw button
        drawBtn = (ImageButton) findViewById(R.id.draw_btn);
        drawBtn.setOnClickListener(this);

        //set initial size
        drawingView.setBrushSize(brushSize);

        //erase button
        eraseBtn = (ImageButton) findViewById(R.id.erase_btn);
        eraseBtn.setOnClickListener(this);

        //new button
        newBtn = (ImageButton) findViewById(R.id.new_btn);
        newBtn.setOnClickListener(this);

        //save button
        saveBtn = (ImageButton) findViewById(R.id.save_btn);
        saveBtn.setOnClickListener(this);

        colorPicker = (ImageButton) findViewById(R.id.color_picker);
        colorPicker.setOnClickListener(this);

        brushSizeDialog = new BrushSizeDialog(this);
        colorPickerDialog = new ColorPickerDialog(this);
        imagePicker = new ImagePicker(this);
        bitmapImage = (ImageButton) findViewById(R.id.imageBtn);
        bitmapImage.setOnClickListener(this);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        int index;
        if (v.getId() == R.id.draw_btn) {

          /*  brushSize = brushSizeDialog.SetBrushSizeDialog(v, drawingView );
            drawingView.setErase(false);
            drawingView.setBrushSize(brushSize);
            drawingView.setLastBrushSize(brushSize);*/
            brushSizeDialog.setBrushSizeDialog(v, drawingView);

        } else if (v.getId() == R.id.erase_btn) {

            brushSizeDialog.setBrushEraseSize(v, drawingView);
            //drawingView.setErase(true);
            //drawingView.setBrushSize(brushSize);

        } else if (v.getId() == R.id.new_btn) {
            //new button
            AlertDialog.Builder newDialog = new AlertDialog.Builder(this);
            newDialog.setTitle("New drawing");
            newDialog.setMessage("Start new drawing (you will lose the current drawing)?");
            newDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    drawingView.startNew();
                    dialog.dismiss();
                }
            });
            newDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            newDialog.show();
        } else if (v.getId() == R.id.save_btn) {
            //save drawing
            AlertDialog.Builder saveDialog = new AlertDialog.Builder(this);
            saveDialog.setTitle("Save drawing");
            saveDialog.setMessage("Save drawing to device Gallery?");
            saveDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    //save drawing
                    drawingView.setDrawingCacheEnabled(true);
                    //attempt to save
                    String imgSaved = MediaStore.Images.Media.insertImage(
                            getContentResolver(), drawingView.getDrawingCache(),
                            UUID.randomUUID().toString() + ".png", "drawing");
                    //feedback
                    if (imgSaved != null) {
                        Toast savedToast = Toast.makeText(getApplicationContext(),
                                "Drawing saved to Gallery!", Toast.LENGTH_SHORT);
                        savedToast.show();
                    } else {
                        Toast unsavedToast = Toast.makeText(getApplicationContext(),
                                "Oops! Image could not be saved.", Toast.LENGTH_SHORT);
                        unsavedToast.show();
                    }
                    drawingView.destroyDrawingCache();
                }
            });
            saveDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            saveDialog.show();
        } else if (v.getId() == R.id.color_picker) {
            colorPickerDialog.colorDialog(v, currColor, drawingView);
        }else if(v.getId() == R.id.imageBtn){
           // imagePicker.galleryPiker(v);
            //drawingView.setBitmap(R.drawable.coleman_close);
           imagePicker.setBackgroundImage(v, drawingView);
        }
    }

}