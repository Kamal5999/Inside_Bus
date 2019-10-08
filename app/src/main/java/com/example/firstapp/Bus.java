package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Bus extends AppCompatActivity implements View.OnClickListener {

    FirebaseAuth fh;
    Button out;
    TextView tt;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus);
        out=(Button)findViewById(R.id.signout);
        tt=(TextView)findViewById(R.id.print);
        out.setOnClickListener(this);
        fh=FirebaseAuth.getInstance();
        if(fh.getCurrentUser()==null)
        {
            finish();
            startActivity(new Intent(Bus.this,register.class));
        }
    }

    @Override
    public void onClick(View view)
    {
          finish();
        Intent in=new Intent(Bus.this,login.class);
        startActivity(in);
    }
}
