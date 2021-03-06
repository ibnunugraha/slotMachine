package com.example.ibnu.myapplication;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;
import java.util.logging.Handler;

public class MainActivity extends AppCompatActivity {

    Button b_roll;

    ImageView image1, image2, image3;

    Random r;
    int img1, img2, img3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        r = new Random();

        b_roll = (Button) findViewById(R.id.b_roll);

        image1 = (ImageView) findViewById(R.id.image1);
        image2 = (ImageView) findViewById(R.id.image2);
        image3 = (ImageView) findViewById(R.id.image3);

        b_roll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick( View view ) {
                // animate first image
                image1.setImageResource(R.drawable.anim);
                final AnimationDrawable image1anim = (AnimationDrawable) image1.getDrawable();
                image1anim.start();

                // animate second image
                image2.setImageResource(R.drawable.anim);
                final AnimationDrawable image2anim = (AnimationDrawable) image2.getDrawable();
                image2anim.start();

                // animate third image
                image3.setImageResource(R.drawable.anim);
                final AnimationDrawable image3anim = (AnimationDrawable) image3.getDrawable();
                image3anim.start();

                //stop the animation and apply the images
                android.os.Handler handler = new android.os.Handler();
                handler.postDelayed( new Runnable() {
                    @Override
                    public void run() {
                        image1anim.stop();
                        image2anim.stop();
                        image3anim.stop();

                        setImages();

                        getScore();
                    }
                }, 500);

            }
        });
    }

    public void setImages(){
        //randomize images
        img1 = r.nextInt(5) + 1;
        img2 = r.nextInt(5) + 1;
        img3 = r.nextInt(5) + 1;

        switch (img1){
            case 1:
                image1.setImageResource(R.drawable.ic_casino);
                break;
            case 2:
                image1.setImageResource(R.drawable.ic_cherry);
                break;
            case 3:
                image1.setImageResource(R.drawable.ic_diamond);
                break;
            case 4:
                image1.setImageResource(R.drawable.ic_heart);
                break;
            case 5:
                image1.setImageResource(R.drawable.ic_casino);
                break;
        }
        switch (img2){
            case 1:
                image2.setImageResource(R.drawable.ic_casino);
                break;
            case 2:
                image2.setImageResource(R.drawable.ic_cherry);
                break;
            case 3:
                image2.setImageResource(R.drawable.ic_diamond);
                break;
            case 4:
                image2.setImageResource(R.drawable.ic_heart);
                break;
            case 5:
                image2.setImageResource(R.drawable.ic_casino);
                break;
        }
        switch (img3){
            case 1:
                image3.setImageResource(R.drawable.ic_casino);
                break;
            case 2:
                image3.setImageResource(R.drawable.ic_cherry);
                break;
            case 3:
                image3.setImageResource(R.drawable.ic_diamond);
                break;
            case 4:
                image3.setImageResource(R.drawable.ic_heart);
                break;
            case 5:
                image3.setImageResource(R.drawable.ic_casino);
                break;
        }
    }

    public void getScore(){
        //3 of the same image
        if( img1 == img2 && img2 == img3 ) {
            Toast.makeText(this, "Jackpot!", Toast.LENGTH_SHORT).show();
        }

        if( img1 == img2 || img2 == img3 || img3 == img1 ) {
            Toast.makeText(this, "Awesome!", Toast.LENGTH_SHORT).show();
        }
    }
}
