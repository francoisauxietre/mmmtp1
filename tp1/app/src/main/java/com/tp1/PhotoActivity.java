package com.tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;

public class PhotoActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView profilImageView;
    private ImageButton buttonCamera;

    static final int REQUEST_IMAGE_CAPTURE = 1;
//    private int REQUEST_CAMERA=1;
    private int SELECT_FILES=0;
//    private Uri imageUri;


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
                Log.i("TAG", "on click");
                if(items[item].equals("Take photo")){
                    take_picture();
                }

                if(items[item].equals("Chose from library")){
                    librayIntent();
                }

                if(items[item].equals("Cancel")){
                    dialog.dismiss();
                }
            }

        });
        builder.create();
        builder.show();

    }




    private void take_picture(){


        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
//            takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }

//        Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//        camera_intent.putExtra("android.intent.extras.CAMERA_FACING", 1);
//        startActivityForResult(camera_intent, REQUEST_CAMERA);

//        File file = new File(storage(), "MyFile.jpg");
//        Uri uri = Uri.fromFile(file);
//
//        Uri uriSavedImage=Uri.fromFile(new File("/sdcard/flashCropped.png"));
//        Intent cameraIntent=new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
//        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
//        startActivityForResult(cameraIntent, REQUEST_CAMERA);


    }

    private void librayIntent(){
        Log.i("TAG", "library");
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