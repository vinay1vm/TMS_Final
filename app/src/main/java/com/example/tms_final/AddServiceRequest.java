package com.example.tms_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddServiceRequest extends AppCompatActivity {

    DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReferenceFromUrl("https://tms-final-51d73-default-rtdb.firebaseio.com/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_service_request);
        getSupportActionBar().hide();

//Spinner Declaration
        String[] arraySpinner = new String[] {" ", "Plumber", "Laundry", "Electrican"};
        Spinner s = (Spinner) findViewById(R.id.serviceList);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);


//        ActivityCompat.requestPermissions(this,
//                new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
//                        Manifest.permission.READ_EXTERNAL_STORAGE},
//                PackageManager.PERMISSION_GRANTED);



        EditText desc=findViewById(R.id.editText);
        TextView attachment=findViewById(R.id.attach);
        Button submit=findViewById(R.id.SrSubmit);




        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Spinval= s.getSelectedItem().toString();
                String descc=desc.getText().toString();


                if(Spinval.equals(" ") || descc.isEmpty())  {

                    Toast.makeText(AddServiceRequest.this, "Fields cant be empty", Toast.LENGTH_SHORT).show();

                }else {

                    Counter.Count();
                    databaseReference.child("Counter").child("id").setValue(Counter.id);

                    if (Spinval.equals("Plumber")) {

                        uploadvend(Spinval,descc);
                        upload(Spinval,descc);

                        Toast.makeText(AddServiceRequest.this, "Request Raised", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(AddServiceRequest.this, ServiceRequest.class));


                    }
                    if (Spinval.equals("Laundry")) {

                        uploadvend(Spinval,descc);
                        upload(Spinval,descc);

                        Toast.makeText(AddServiceRequest.this, "Request Raised", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(AddServiceRequest.this, ServiceRequest.class));


                    }
                    if (Spinval.equals("Electrican")) {

                        uploadvend(Spinval,descc);
                        upload(Spinval,descc);

                        Toast.makeText(AddServiceRequest.this, "Request Raised", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(AddServiceRequest.this, ServiceRequest.class));


                    }

                }

            }

            private void uploadvend(String spinval , String descc) {

                databaseReference.child("VendorRequests").child(spinval).child(String.valueOf(Counter.id)).child("full_name").setValue(GlobalVar.name);
                databaseReference.child("VendorRequests").child(spinval).child(String.valueOf(Counter.id)).child("door_no").setValue(GlobalVar.door_no);
                databaseReference.child("VendorRequests").child(spinval).child(String.valueOf(Counter.id)).child("email").setValue(GlobalVar.email);
                databaseReference.child("VendorRequests").child(spinval).child(String.valueOf(Counter.id)).child("ph_no").setValue(GlobalVar.phno);
                databaseReference.child("VendorRequests").child(spinval).child(String.valueOf(Counter.id)).child("description").setValue(descc);
                databaseReference.child("VendorRequests").child(spinval).child(String.valueOf(Counter.id)).child("Request_Id").setValue(String.valueOf(Counter.id));

            }

            private void upload(String spinval, String descc) {

                databaseReference.child("Requests").child(GlobalVar.door_no).child(String.valueOf(Counter.id)).child("type").setValue(spinval);
                databaseReference.child("Requests").child(GlobalVar.door_no).child(String.valueOf(Counter.id)).child("full_name").setValue(GlobalVar.name);
                databaseReference.child("Requests").child(GlobalVar.door_no).child(String.valueOf(Counter.id)).child("door_no").setValue(GlobalVar.door_no);
                databaseReference.child("Requests").child(GlobalVar.door_no).child(String.valueOf(Counter.id)).child("email").setValue(GlobalVar.email);
                databaseReference.child("Requests").child(GlobalVar.door_no).child(String.valueOf(Counter.id)).child("ph_no").setValue(GlobalVar.phno);
                databaseReference.child("Requests").child(GlobalVar.door_no).child(String.valueOf(Counter.id)).child("description").setValue(descc);
                databaseReference.child("Requests").child(GlobalVar.door_no).child(String.valueOf(Counter.id)).child("Request_Id").setValue(String.valueOf(Counter.id));



            }
        });






    }
    }
