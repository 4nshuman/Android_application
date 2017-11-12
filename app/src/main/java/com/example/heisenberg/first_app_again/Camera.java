package com.example.heisenberg.first_app_again;

import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by heisenberg on 11/5/17.
 */

public class Camera extends AppCompatActivity implements View.OnClickListener {

    ImageView iV;
    Button clickPic;
    ImageButton setWall;
    Intent cameraIntent;
    int cameraResults;
    Bitmap bmp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.camera);

        initializeComponents();
        InputStream is = getResources().openRawResource(+ R.mipmap.ic_launcher);
        bmp = BitmapFactory.decodeStream(is);
        clickPic.setOnClickListener(this);
        setWall.setOnClickListener(this);
    }

    private void initializeComponents() {
        iV = (ImageView) findViewById(R.id.imageView);
        clickPic = (Button) findViewById(R.id.btntakePic);
        setWall = (ImageButton) findViewById(R.id.setWall);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btntakePic :
                cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, cameraResults);
                break;

            case R.id.setWall :
                try {
                    //getApplicationContext().setWallpaper(bmp);
                    WallpaperManager wM = WallpaperManager.getInstance(getApplicationContext());
                    wM.setBitmap(bmp);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            Bundle dataFromCamera = data.getExtras();
            bmp = (Bitmap) dataFromCamera.get("data");
            iV.setImageBitmap(bmp);
        }
    }
}
