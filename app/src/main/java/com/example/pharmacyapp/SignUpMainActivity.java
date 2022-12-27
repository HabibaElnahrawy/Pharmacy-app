package com.example.pharmacyapp;

/*
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

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
            ValidatePhone_number(name,phoneNb,password,email);
        }

    }

    private void ValidatePhone_number(String name, String phoneNb, String password,String email) {
    final DatabaseReference rootRef;
        rootRef= FirebaseDatabase.getInstance().getReference();
        rootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //lw el phone number doesnt exist yb2a han create new account
                if(!(dataSnapshot.child("Users").child(phoneNb).exists()))
                {
                    HashMap<String,Object> userData=new HashMap<>();
                    userData.put("Phone:",phoneNb);
                    userData.put("Name:",name);
                    userData.put("Email:",email);
                    userData.put("Password:",password);

                    rootRef.child("Users").child(phoneNb).updateChildren(userData)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            //if the task is successful
                            if(task.isSuccessful())
                            {
                                Toast.makeText(SignUpMainActivity.this,"3ashhhhhh el account has been created",Toast.LENGTH_SHORT).show();
                                loading.dismiss();
                                //from ---> to
                                Intent intent =new Intent(SignUpMainActivity.this, LoginMainActivity.class);
                                startActivity(intent);
                            }
                            else
                            {
                                loading.dismiss();
                                Toast.makeText(SignUpMainActivity.this,"try againnnn",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                }
                else
                {
                    Toast.makeText(SignUpMainActivity.this,"this"+phoneNb+ "already exists",Toast.LENGTH_SHORT).show();
                    loading.dismiss();
                    Toast.makeText(SignUpMainActivity.this,"please use anothetr phone number",Toast.LENGTH_SHORT).show();


                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}*/



import android.app.ProgressDialog;
import android.content.Intent;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class SignUpMainActivity extends AppCompatActivity
{
    private Button CreateAccountButton;
    private EditText InputName, InputPhoneNumber, InputPassword, InputEmail;
    private ProgressDialog loadingBar;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_main);


        CreateAccountButton = (Button) findViewById(R.id.createAccBtn);
        InputName = (EditText) findViewById(R.id.name);
        InputPassword = (EditText) findViewById(R.id.pass);
        InputPhoneNumber = (EditText) findViewById(R.id.phoneNb);
        InputEmail = (EditText) findViewById(R.id.email);
        loadingBar = new ProgressDialog(this);


        CreateAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                CreateAccount();
            }
        });
    }



    private void CreateAccount()
    {
        String name = InputName.getText().toString();
        String phone = InputPhoneNumber.getText().toString();
        String password = InputPassword.getText().toString();
        String email = InputEmail.getText().toString();

        if (TextUtils.isEmpty(name))
        {
            Toast.makeText(this, "Please write your name...", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(phone))
        {
            Toast.makeText(this, "Please write your phone number...", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(email))
        {
            Toast.makeText(this, "Please write your email...", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(password))
        {
            Toast.makeText(this, "Please write your password...", Toast.LENGTH_SHORT).show();
        }
        else
        {
            loadingBar.setTitle("Create Account");
            loadingBar.setMessage("Please wait, while we are checking the credentials.");
            loadingBar.setCanceledOnTouchOutside(false);
            loadingBar.show();

            ValidatephoneNumber(name, phone, password, email);
        }
    }



    private void ValidatephoneNumber(final String name, final String phone, final String password,final String email)
    {
        final DatabaseReference RootRef;
        RootRef = FirebaseDatabase.getInstance().getReference();

        RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                if (!(dataSnapshot.child("Users").child(phone).exists()))
                {
                    HashMap<String, Object> userdataMap = new HashMap<>();
                    userdataMap.put("phone", phone);
                    userdataMap.put("password", password);
                    userdataMap.put("name", name);
                    userdataMap.put("email", email);

                    RootRef.child("Users").child(phone).updateChildren(userdataMap)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task)
                                {
                                    if (task.isSuccessful())
                                    {
                                        Toast.makeText(SignUpMainActivity.this, "Congratulations, your account has been created.", Toast.LENGTH_SHORT).show();
                                        loadingBar.dismiss();

                                        Intent intent = new Intent(SignUpMainActivity.this, LoginMainActivity.class);
                                        startActivity(intent);
                                    }
                                    else
                                    {
                                        loadingBar.dismiss();
                                        Toast.makeText(SignUpMainActivity.this, "Network Error: Please try again after some time...", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
                else
                {
                    Toast.makeText(SignUpMainActivity.this, "This " + phone + " already exists.", Toast.LENGTH_SHORT).show();
                    loadingBar.dismiss();
                    Toast.makeText(SignUpMainActivity.this, "Please try again using another phone number.", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(SignUpMainActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
