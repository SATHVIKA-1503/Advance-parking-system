package com.learncodewithrk.carparking.Booking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.learncodewithrk.carparking.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.util.HashMap;
import java.util.Map;

public class booking_slot2 extends AppCompatActivity {


    private static final String SLOT_KEY = "Slot";
    private static final String VEHICLE_KEY = "Vehicle";
    private static final String TIME_KEY = "Time";
    private static final String PHONE_KEY = "Phone";
    FirebaseFirestore db;
    TextView textDisplay;
    TextView message;
    EditText Slot, vehicle,Time, phone;
    Button Detail,save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_slot2);


        db = FirebaseFirestore.getInstance();
        textDisplay = findViewById(R.id.textDisplay);

        save    = findViewById(R.id.save);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNewslot1();
            }
        });

        Detail = (Button) findViewById(R.id.Detail);
        Detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent streamIntent = new Intent(booking_slot2.this, slot2_Detail_page.class);
                startActivity(streamIntent);
            }
        });

    }

    private void addRealtimeUpdate() {
        DocumentReference contactListener = db.collection("slot1").document("slot2");
        contactListener.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(DocumentSnapshot documentSnapshot, FirebaseFirestoreException e) {
                if (e != null ){
                    Log.d("ERROR", e.getMessage());
                    return;
                }
                if (documentSnapshot != null && documentSnapshot.exists()){
                    message.setText(documentSnapshot.getData().toString());
                }
            }
        });
    }
    private void DeleteData() {

        db.collection("slot1").document("slot2")
                .delete().addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {

                        Toast.makeText(booking_slot2.this, "Data deleted !",
                                Toast.LENGTH_SHORT).show();

                    }
                });
    }
    private void UpdateData() {

        DocumentReference contact = db.collection("slot1").document("slot2");
        contact.update(SLOT_KEY, "001");
        contact.update(VEHICLE_KEY, "Dcl-5656");
        contact.update(TIME_KEY, "4:56 PM");
        contact.update(PHONE_KEY, "+91 9599695872")
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(booking_slot2.this, "Updated Successfully",
                                Toast.LENGTH_SHORT).show();
                    }
                });

    }
    private void ReadSingleContact() {

        DocumentReference user = db.collection("slot1").document("slot2");
        user.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if (task.isSuccessful()){
                            DocumentSnapshot doc = task.getResult();
                            StringBuilder fields = new StringBuilder("field");
                            fields.append("Slot: ").append(doc.get("Slot"));
                            fields.append("\nVehicle: ").append(doc.get("Vehicle"));
                            fields.append("\nTime: ").append(doc.get("Time"));
                            fields.append("\nPhone: ").append(doc.get("Phone"));
                            message.setText(fields.toString());

                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                });

    }
    private void addNewslot1(){
        save    = findViewById(R.id.save);
        Slot    = findViewById(R.id.Slot);
        vehicle   = findViewById(R.id.vehicle);
        Time   = findViewById(R.id.Time);
        phone   = findViewById(R.id.phone);

        String mSlot = Slot.getText().toString();
        String mvehicle = vehicle.getText().toString();
        String mTime = Time.getText().toString();
        String mPhone = phone.getText().toString();

        Map<String, Object>newContact = new HashMap<>();
        newContact.put(SLOT_KEY, mSlot);
        newContact.put(VEHICLE_KEY, mvehicle);
        newContact.put(TIME_KEY, mTime);
        newContact.put(PHONE_KEY, mPhone);
        db.collection("slot1").document("slot2").set(newContact)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        AlertDialog alertDialog = new AlertDialog.Builder(booking_slot2.this).create();
                        alertDialog.setTitle("Booking successful");
                        alertDialog.setMessage("Time Period: Up to 1 hours: 10Rs");
                        // Alert dialog button
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        // Alert dialog action goes here
                                        // onClick button code here
                                        dialog.dismiss();// use dismiss to cancel alert dialog
                                    }
                                });
                        alertDialog.show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(booking_slot2.this, "ERROR" +e.toString(),
                                Toast.LENGTH_SHORT).show();
                        Log.d("TAG", e.toString());
                    }
                });
    }
}