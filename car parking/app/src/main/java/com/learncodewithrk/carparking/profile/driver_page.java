package com.learncodewithrk.carparking.profile;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.learncodewithrk.carparking.R;

public class driver_page extends AppCompatActivity {

    ListView listView;
    String mTitle[] = {"Abhay Singh", "Abhishek", "Amit", "Anup", "Aadi","Darsh","Dev KUmar"};
    String mDescription[] = {"This person is called a valet. The valet parking service....", "This person is called a valet. The valet parking service....", "This person is called a valet. The valet parking service....", "This person is called a valet. The valet parking service....", "This person is called a valet. The valet parking service....","This person is called a valet. The valet parking service....","This person is called a valet. The valet parking service...."};
    int images[] = {R.drawable.person1, R.drawable.person2, R.drawable.person3, R.drawable.person4, R.drawable.person5,R.drawable.person6,R.drawable.person7};
    // so our images and other things are set in array

    // now paste some images in drawable
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_page);


        listView = findViewById(R.id.listView);
        // now create an adapter class

        MyAdapter adapter = new MyAdapter(this, mTitle, mDescription, images);
        listView.setAdapter(adapter);
        // there is my mistake...
        // now again check this..

        // now set item click on list view
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position ==  0) {
                    Intent streamIntent = new Intent(driver_page.this, Abhay_Singh_profile.class);
                   startActivity(streamIntent);
                }
                if (position ==  1) {
                   Intent streamIntent = new Intent(driver_page.this, Abhishek_profile.class);
                  startActivity(streamIntent);
                }
                if (position ==  2) {
                   Intent streamIntent = new Intent(driver_page.this, Amit_profile.class);
                    startActivity(streamIntent);
                }
                if (position ==  3) {

                    Intent streamIntent = new Intent(driver_page.this, Anup_profile.class);
                    startActivity(streamIntent);
                }
                if (position ==  4) {
                  Intent streamIntent = new Intent(driver_page.this, Aadi_profile.class);
                    startActivity(streamIntent);
                }
                if (position ==  5) {

                  Intent streamIntent = new Intent(driver_page.this, Darsh_profile.class);
                  startActivity(streamIntent);
                }

                if (position ==  6) {
                   Intent streamIntent = new Intent(driver_page.this, Dev_profile.class);
                    startActivity(streamIntent);

                }


            }
        });
        // so item click is done now check list view
    }

    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String rTitle[];
        String rDescription[];
        int rImgs[];

        MyAdapter (Context c, String title[], String description[], int imgs[]) {
            super(c, R.layout.row, R.id.textView1, title);
            this.context = c;
            this.rTitle = title;
            this.rDescription = description;
            this.rImgs = imgs;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            ImageView images = row.findViewById(R.id.image);
            TextView myTitle = row.findViewById(R.id.textView1);
            TextView myDescription = row.findViewById(R.id.textView2);

            // now set our resources on views
            images.setImageResource(rImgs[position]);
            myTitle.setText(rTitle[position]);
            myDescription.setText(rDescription[position]);




            return row;
        }
    }
}