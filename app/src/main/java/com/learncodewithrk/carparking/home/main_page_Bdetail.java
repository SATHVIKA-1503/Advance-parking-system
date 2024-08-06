package com.learncodewithrk.carparking.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.learncodewithrk.carparking.Booking.slot1_Detail_page;
import com.learncodewithrk.carparking.Booking.slot2_Detail_page;
import com.learncodewithrk.carparking.Booking.slot3_Detail_page;
import com.learncodewithrk.carparking.Booking.slot4_Detail_page;
import com.learncodewithrk.carparking.Booking.slot5_Detail_page;
import com.learncodewithrk.carparking.Booking.slot6_Detail_page;
import com.learncodewithrk.carparking.R;

public class main_page_Bdetail extends AppCompatActivity {
    ImageView slot_1, slot_2, slot_3, slot_4, slot_5, slot_6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page_bdetail);

        slot_1 = (ImageView) findViewById(R.id.slot_1);
        slot_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent streamIntent = new Intent(main_page_Bdetail.this, slot1_Detail_page.class);
                startActivity(streamIntent);
            }
        });

        slot_2 = (ImageView) findViewById(R.id.slot_2);
        slot_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent streamIntent = new Intent(main_page_Bdetail.this, slot2_Detail_page.class);
                startActivity(streamIntent);
            }
        });
        slot_3 = (ImageView) findViewById(R.id.slot_3);
        slot_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent streamIntent = new Intent(main_page_Bdetail.this, slot3_Detail_page.class);
                startActivity(streamIntent);
            }
        });

        slot_4 = (ImageView) findViewById(R.id.slot_4);
        slot_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent streamIntent = new Intent(main_page_Bdetail.this, slot4_Detail_page.class);
                startActivity(streamIntent);
            }
        });

        slot_5 = (ImageView) findViewById(R.id.slot_5);
        slot_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent streamIntent = new Intent(main_page_Bdetail.this, slot5_Detail_page.class);
                startActivity(streamIntent);
            }
        });

        slot_6 = (ImageView) findViewById(R.id.slot_6);
        slot_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent streamIntent = new Intent(main_page_Bdetail.this, slot6_Detail_page.class);
                startActivity(streamIntent);
            }
        });

    }
}
