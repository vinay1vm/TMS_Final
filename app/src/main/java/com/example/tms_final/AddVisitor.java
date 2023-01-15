package com.example.tms_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddVisitor extends AppCompatActivity {

    DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReferenceFromUrl("https://tms-final-51d73-default-rtdb.firebaseio.com/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_visitor);
        getSupportActionBar().hide();


        Button Add=findViewById(R.id.addbtn);
        EditText name=findViewById(R.id.visname);
        EditText add=findViewById(R.id.VisAdd);
        EditText con=findViewById(R.id.VisCon);
        EditText date=findViewById(R.id.VisDate);
        EditText time=findViewById(R.id.VisTime);

//        StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
//        StrictMode.setThreadPolicy(policy);



        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Name=name.getText().toString();
                String Add=add.getText().toString();
                String Con=con.getText().toString();
                String Date=date.getText().toString();
                String Time=time.getText().toString();
                String msg="test"+GlobalVar.name+"invited you on"+Date+","+Time+"to door number"+GlobalVar.door_no;

                if(Name.isEmpty() || Add.isEmpty() || Con.isEmpty() || Date.isEmpty() || Time.isEmpty()){
                    Toast.makeText(AddVisitor.this, "Fields cant be empty", Toast.LENGTH_SHORT).show();

                }
                else{

                    Counter.Count();
                    databaseReference.child("Counter").child("id").setValue(Counter.id);

                    databaseReference.child("Visitors").child(GlobalVar.door_no).child(String.valueOf(Counter.id)).child("Visitor_Id").setValue(String.valueOf(Counter.id));
                    databaseReference.child("Visitors").child(GlobalVar.door_no).child(String.valueOf(Counter.id)).child("Resident_full_name").setValue(GlobalVar.name);
                    databaseReference.child("Visitors").child(GlobalVar.door_no).child(String.valueOf(Counter.id)).child("Resident_ph_no").setValue(GlobalVar.phno);
                    databaseReference.child("Visitors").child(GlobalVar.door_no).child(String.valueOf(Counter.id)).child("Guest_full_name").setValue(Name);
                    databaseReference.child("Visitors").child(GlobalVar.door_no).child(String.valueOf(Counter.id)).child("Guest_Address").setValue(Add);
                    databaseReference.child("Visitors").child(GlobalVar.door_no).child(String.valueOf(Counter.id)).child("Guest_Contact").setValue(Con);
                    databaseReference.child("Visitors").child(GlobalVar.door_no).child(String.valueOf(Counter.id)).child("Guest_Date").setValue(Date);
                    databaseReference.child("Visitors").child(GlobalVar.door_no).child(String.valueOf(Counter.id)).child("Guest_Time").setValue(Time);
                    databaseReference.child("Visitors").child(GlobalVar.door_no).child(String.valueOf(Counter.id)).child("Door_No").setValue(GlobalVar.door_no);


                    // Visitor list DB

                    databaseReference.child("Visitor_list").child(String.valueOf(Counter.id)).child("Visitor_Id").setValue(String.valueOf(Counter.id));
                    databaseReference.child("Visitor_list").child(String.valueOf(Counter.id)).child("Resident_full_name").setValue(GlobalVar.name);
                    databaseReference.child("Visitor_list").child(String.valueOf(Counter.id)).child("Resident_ph_no").setValue(GlobalVar.phno);
                    databaseReference.child("Visitor_list").child(String.valueOf(Counter.id)).child("Guest_full_name").setValue(Name);
                    databaseReference.child("Visitor_list").child(String.valueOf(Counter.id)).child("Guest_Address").setValue(Add);
                    databaseReference.child("Visitor_list").child(String.valueOf(Counter.id)).child("Guest_Contact").setValue(Con);
                    databaseReference.child("Visitor_list").child(String.valueOf(Counter.id)).child("Guest_Date").setValue(Date);
                    databaseReference.child("Visitor_list").child(String.valueOf(Counter.id)).child("Guest_Time").setValue(Time);
                    databaseReference.child("Visitor_list").child(String.valueOf(Counter.id)).child("Door_No").setValue(GlobalVar.door_no);

                    int cc=Counter.id;

                    Toast.makeText(AddVisitor.this, "Visitor Added!", Toast.LENGTH_SHORT).show();















                    startActivity(new Intent(AddVisitor.this,Visitor.class));
                }


            }



        });

    }
}