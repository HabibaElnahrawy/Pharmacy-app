package com.example.pharmacyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;

public class SignUpMainActivity extends AppCompatActivity {
    private Button createAccountBtn;
    private EditText input_name;
    private EditText input_email;
    private EditText input_phoneNb;
    private EditText input_password;
    private ProgressDialog loading;
    FirebaseFirestore firestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_main);

        createAccountBtn=(Button) findViewById(R.id.createAccBtn);
        input_name=(EditText) findViewById(R.id.name);
        input_email=(EditText) findViewById(R.id.email);
        input_phoneNb=(EditText) findViewById(R.id.phoneNb);
        input_password=(EditText) findViewById(R.id.pass);

        loading=new ProgressDialog(this );

        createAccountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createAccount();
            }
        });

    }

    private void createAccount() {

        String name=input_name.getText().toString();
        String phoneNb=input_phoneNb.getText().toString();
        String email=input_email.getText().toString();
        String password=input_password.getText().toString();

        if(TextUtils.isEmpty(name))
        {
            Toast.makeText(this,"write your name please",Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(phoneNb))
        {
            Toast.makeText(this,"write your phone number please",Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(email))
        {
            Toast.makeText(this,"write your name please",Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(password))
        {
            Toast.makeText(this,"write your name please",Toast.LENGTH_SHORT).show();
        }
        else
        {
            loading.setTitle("create account");
            loading.setMessage("please wait.....");
            //3ashan lw el user das 3ala el screen may2flsh el loading
            loading.setCanceledOnTouchOutside(false);
            loading.show();
            ValidatePhone_number(name,phoneNb,password);
        }

    }

    private void ValidatePhone_number(String name, String phoneNb, String password) {
    final DatabaseReference rootRef;
        rootRef= FirebaseDatabase.getInstance().getReference();
        rootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(! (dataSnapshot.child("Users")).child(phoneNb).exists())
                {

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}