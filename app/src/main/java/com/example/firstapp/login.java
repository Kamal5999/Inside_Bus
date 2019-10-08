package com.example.firstapp;

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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity  implements View.OnClickListener {


    private ProgressDialog progressDialog;
    private FirebaseAuth fh;
    String email,pass;
    Button logb,newb;
    EditText user,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        logb =(Button) findViewById(R.id.login);
        newb=(Button) findViewById(R.id.newuser);
        user =(EditText) findViewById(R.id.email);
        progressDialog =new ProgressDialog(this);
        password =(EditText) findViewById(R.id.password);
        logb.setOnClickListener(this);
        fh=FirebaseAuth.getInstance();
        newb.setOnClickListener(this);
    }
    private void loginu()
    {
        email=user.getText().toString();
        pass=password.getText().toString();
        if(TextUtils.isEmpty(email)||TextUtils.isEmpty(pass))
        {
            Toast.makeText(this,"please fill all the details",Toast.LENGTH_LONG);
        }
        else
        {
            progressDialog.setMessage("Connecting");
            progressDialog.show();

            fh.signInWithEmailAndPassword(email,pass)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            progressDialog.dismiss();
                            if(task.isSuccessful())
                            {
                                Intent i=new Intent(login.this,Bus.class);
                                startActivity(i);
                            }
                        }
                    });

        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.login:
                loginu();
            case R.id.newuser:
                Intent i=new Intent(this,register.class);
                startActivity(i);
        }
    }
}
