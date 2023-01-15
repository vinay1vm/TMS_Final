package com.example.tms_final;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Bills extends AppCompatActivity {

    public void onBackPressed()
    {
        super.onBackPressed();
        startActivity(new Intent(Bills.this, ResidentHome.class));
        finish();

    }

    FirebaseDatabase db=FirebaseDatabase.getInstance();
    DatabaseReference reference=db.getReference().child("UsersForBills");//.child(GlobalVar.door_no);
    RecyclerView recyclerView;

    BAdapter bAdapter;
    ArrayList<Bmodel> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bills);
        getSupportActionBar().hide();

        recyclerView=findViewById(R.id.billrecy);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list=new ArrayList<>();
        bAdapter=new BAdapter(list,this);
        recyclerView.setAdapter(bAdapter);

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                    Log.e("Bills Java", "onDataChange: "+dataSnapshot.toString());
                    Bmodel bmodel=dataSnapshot.getValue(Bmodel.class);
                    list.add(bmodel);
                }
                bAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}