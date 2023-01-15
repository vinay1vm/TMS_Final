package com.example.tms_final;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ServiceRequest extends AppCompatActivity {

    public void onBackPressed()
    {
        super.onBackPressed();
        startActivity(new Intent(ServiceRequest.this, ResidentHome.class));
        finish();

    }


    FirebaseDatabase db=FirebaseDatabase.getInstance();
    DatabaseReference reference=db.getReference().child("Requests").child(GlobalVar.door_no);
    RecyclerView recyclerView;

    srAdapter sradaptr;
    ArrayList<SrModel> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_request);
        getSupportActionBar().hide();

        Button SR=findViewById(R.id.addSR);


        recyclerView=findViewById(R.id.SRrecview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list=new ArrayList<>();
        sradaptr=new srAdapter(list,this);
        recyclerView.setAdapter(sradaptr);

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                    Log.e("SR Java",dataSnapshot.toString());
                    SrModel srmodel=dataSnapshot.getValue(SrModel.class);
                    list.add(srmodel);
                }
                sradaptr.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });




        SR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ServiceRequest.this, AddServiceRequest.class));
            }
        });

    }
}