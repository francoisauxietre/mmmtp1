package com.tp1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class PhotoActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView profilImageView;
    private ImageButton buttonCamera;
    private int REQUEST_CAMERA=1;
    private int SELECT_FILES=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            setContentView(R.layout.activity_photo);
            setUserInterface();

        } catch (Exception e) {
            Log.i("info", "error while taking photo in PhotoActivity");
            Toast.makeText(this, "error, please retry", Toast.LENGTH_SHORT).show();
        }
    }

    private void setUserInterface() {
        this.profilImageView = findViewById(R.id.imageView_profil);
        this.buttonCamera = findViewById(R.id.imageButton_camera);
        this.buttonCamera.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.imageButton_camera:
            selectImage();
            break;
        }
    }

    private void selectImage() {

        final CharSequence[] items = {"Take photo", "Chose from library", "Cancel"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("add a photo");
        Log.i("info", "----------------testt---------");
        builder.setItems(items, new DialogInterface.OnClickListener(){


            @Override
            public void onClick(DialogInterface dialog, int item) {
                boolean result =  true;

                if(items[item].equals("Take photo")){
                    cameraIntent();
                }

                if(items[item].equals("Chose from library")){
                    librayIntent();
                }

                if(items[item].equals("Cancel")){
                    dialog.dismiss();
                }
            }

        });
    }
    private void cameraIntent(){
        Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(camera_intent, REQUEST_CAMERA);
    }

    private void librayIntent(){
        Intent library_Intent = new Intent();
        library_Intent.setType("images/*");
        library_Intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(library_Intent, "Select file"),SELECT_FILES );

    }

}

//public void checkPermission(String permission, int requestCode)
//{
//
//    // Checking if permission is not granted
//    if (ContextCompat.checkSelfPermission(
//            MainActivity.this,
//            permission)
//        == PackageManager.PERMISSION_DENIED) {
//        ActivityCompat
//            .requestPermissions(
//                MainActivity.this,
//                new String[] { permission },
//                requestCode);
//    }
//    else {
//        Toast
//            .makeText(MainActivity.this,
//                      "Permission already granted",
//                      Toast.LENGTH_SHORT)
//            .show();
//    }
//}