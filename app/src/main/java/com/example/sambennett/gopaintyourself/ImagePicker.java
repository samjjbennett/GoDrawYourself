package com.example.sambennett.gopaintyourself;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by Jason on 3/22/2015.
 * galleryPicker gets a image from the gallery on sd card
 *
 */
public class ImagePicker {

    Activity activity;
    DrawingView drawingView;
    private final int GALLERY_REQUEST_CODE = 2222;
    public ImagePicker(Activity activity){
        this.activity = activity;
    }

    public void galleryPiker(View v){
        final Intent galleryIntent = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

        activity.startActivityForResult(galleryIntent, GALLERY_REQUEST_CODE);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data,  DrawingView drawingView) {
        //super.onActivityResult(requestCode, resultCode, data);

        // To Handle Gallery Result
        if (data != null && requestCode == GALLERY_REQUEST_CODE) {

            Uri selectedImageUri = data.getData();
            String[] fileColumn = { MediaStore.Images.Media.DATA };

            Cursor imageCursor = activity.getContentResolver().query(selectedImageUri,
                    fileColumn, null, null, null);
            imageCursor.moveToFirst();

            int fileColumnIndex = imageCursor.getColumnIndex(fileColumn[0]);
            String picturePath = imageCursor.getString(fileColumnIndex);

            Bitmap pictureObject = BitmapFactory.decodeFile(picturePath);

          //  drawingView.setBitmap(pictureObject);
            //backGroundImageView.setImageBitmap(pictureObject);
        }
    }

    public void setBackgroundImage(View v,final DrawingView drawingView){


        final Dialog bitmapDialog = new Dialog(activity);
        bitmapDialog.setTitle("Select Image:");
        bitmapDialog.setContentView(R.layout.image_chooser);
        //listen for clicks on size buttons
        ImageButton leeBtn = (ImageButton)bitmapDialog.findViewById(R.id.lee);
        leeBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                drawingView.setBitmap(R.drawable.lee_close);
                bitmapDialog.dismiss();
            }
        });
        ImageButton nicBtn = (ImageButton)bitmapDialog.findViewById(R.id.nicolson);
        nicBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                drawingView.setBitmap(R.drawable.nicholson_close);
                bitmapDialog.dismiss();
            }
        });
        final ImageButton colBtn = (ImageButton)bitmapDialog.findViewById(R.id.colemon);
        colBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                drawingView.setBitmap(R.drawable.coleman_close);
                bitmapDialog.dismiss();
            }
        });
        //show and wait for user interaction
        bitmapDialog.show();

    }
}
