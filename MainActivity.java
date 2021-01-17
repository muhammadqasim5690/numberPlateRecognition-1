package com.example.numberplaterecog;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;



public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    Button btOpen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.image_view);
        btOpen = findViewById(R.id.btn_open);
        if (ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this,
                    new String[]{
                            Manifest.permission.CAMERA

                    },

                    100);
        }
        btOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 100);


            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        if(requestCode == 100){
            Bitmap captureImage = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(captureImage);

    }}
    public  Bitmap RemoveNoise(Bitmap captureImage)
    {
        for(int x = 0; x < captureImage.getWidth(); x++)
        {
            for(int y = 0; y <captureImage.getHeight(); y++)
            {
                int pixel = captureImage.getPixel(x, y);
                int R = Color.red(pixel);
                int G= Color.green(pixel);
                int B = Color.blue(pixel);
                if( R < 162 && G < 162 && B < 162)
                    captureImage.setPixel(x, y, Color.BLACK);


            }
        }
        for(int x=0; x<captureImage.getWidth(); x++)
        {
            for(int y=0; y<captureImage.getHeight(); y++)
            {
                int pixel = captureImage.getPixel(x, y);
                int R = Color.red(pixel);
                int G= Color.green(pixel);
                int B = Color.blue(pixel);
                if( R < 162 && G < 162 && B < 162)
                    captureImage.setPixel(x, y, Color.WHITE);


            }
        }
        return  captureImage;

    }
}