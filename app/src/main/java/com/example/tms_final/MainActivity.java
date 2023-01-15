package com.example.tms_final;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReferenceFromUrl("https://tms-final-51d73-default-rtdb.firebaseio.com/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        EditText usern=findViewById(R.id.username);
        EditText password=findViewById(R.id.pass);
        TextView reglink=findViewById(R.id.register);
        Button loginbt=findViewById(R.id.loginbtn);
        // EditText Email=findViewById(R.id.regEmail);


        loginbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String usernames= usern.getText().toString();
                String pass= password.getText().toString();
                //String email= Email.getText().toString();

                if(usernames.isEmpty() || pass.isEmpty()){
                    Toast.makeText(MainActivity.this, "fields cant be empty", Toast.LENGTH_SHORT).show();
                }
                else{
                    DatabaseReference reference= FirebaseDatabase.getInstance().getReference("users");
                    Query charuser=reference.orderByChild("email").equalTo(usernames);

                    charuser.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {

                            if(snapshot.exists()){

                                String dbpass = snapshot.child(usernames).child("password").getValue(String.class);
                                if(dbpass.equals(pass)){

                                    Toast.makeText(MainActivity.this, "here", Toast.LENGTH_SHORT).show();


                                    String name=snapshot.child(usernames).child("full_name").getValue(String.class);
                                    String email=snapshot.child(usernames).child("email").getValue(String.class);
                                    String doorno=snapshot.child(usernames).child("door_no").getValue(String.class);
                                    String phno=snapshot.child(usernames).child("ph_no").getValue(String.class);


                                    Intent intent=new Intent(getApplicationContext(),ResidentHome.class);

                                    GlobalVar.door_no = doorno;
                                    GlobalVar.name = name;
                                    GlobalVar.email = email;
                                    GlobalVar.phno = phno;

                                    startActivity(intent);
                                    Toast.makeText(MainActivity.this, "Login Success", Toast.LENGTH_SHORT).show();

                                }
                                else {

                                    Toast.makeText(MainActivity.this, "Wrong Passsword", Toast.LENGTH_SHORT).show();
                                }

                            }
                            else {
                                Toast.makeText(MainActivity.this, "No such user", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

                }
            }
        });


        reglink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,SignUp.class));
            }
        });
    }
    }
