package com.nancyngo.meatupsfinal;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

public class MatchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);

//        RotateAnimation rotate = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
//        rotate.setDuration(5000);
//        rotate.setInterpolator(new LinearInterpolator());
//
//        ImageView image= (ImageView) findViewById(R.id.imageView4);
//
//        image.startAnimation(rotate);
    }

    private ImageView btnClick3;

    public void onClick (View v){
        btnClick3 = findViewById(R.id.imageView4) ;

        if(v == btnClick3){


            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:" + "2898084078"));
            intent.putExtra("sms_body", "hi");
            startActivity(intent);
            finish();


        }
    }




}
