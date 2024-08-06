package com.learncodewithrk.carparking.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.learncodewithrk.carparking.R;

public class student_detail extends AppCompatActivity {
    ImageView telegram, instagram, inquiry, faq, share;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_detail);



        share = (ImageView) findViewById(R.id.share);
        share.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Intent.ACTION_SEND);
                myIntent.setType("text/plain");
                String shareBody = "your app link";
                String shareSUb = "You Subject here";
                myIntent.putExtra(Intent.EXTRA_SUBJECT, shareSUb);
                myIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(myIntent, "Share Using"));


            }

        });



        telegram = findViewById(R.id.telegram);
        instagram = findViewById(R.id.instagram);

        faq = findViewById(R.id.faq);

        telegram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://t.me/learncodewithrk");


            }
        });

        instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://www.instagram.com/_rohits.rk_/");


            }
        });




        inquiry = (ImageView) findViewById(R.id.inquiry);
        inquiry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                String uriText = "mailto:" + Uri.encode("example@gmail") + "?subject=" +
                        Uri.encode("Support ") + "&body=" + Uri.encode("");

                Uri uri = Uri.parse(uriText);
                intent.setData(uri);
                startActivity(Intent.createChooser(intent, "Send Email"));
            }
        });

        faq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://goo.gl/maps/aK2kGa769QdtmhUK6");


            }
        });


    }

    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));


    }
}
