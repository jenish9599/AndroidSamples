package com.jenish9599.android.cameraapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;

public class MainActivity extends Activity {


    private Button button;
    private ImageView imageView;
    static final int RQ_CODE = 1;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String path = "storage/cam_image.jpg";
        imageView.setImageDrawable(Drawable.createFromPath(path));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button)findViewById(R.id.Button);
        imageView = (ImageView)findViewById(R.id.image);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                File file = getFile();
                intent.putExtra(MediaStore.EXTRA_OUTPUT,Uri.fromFile(file));
                startActivityForResult(intent,RQ_CODE);
            }
        });
    }


    private File getFile(){
        File file = new File("storage/cameraApp");
        if(!file.exists())
        {
            file.mkdir();
        }

        File Image_file = new File(file,"cam_image.jpg");
        return Image_file;
    }
}
