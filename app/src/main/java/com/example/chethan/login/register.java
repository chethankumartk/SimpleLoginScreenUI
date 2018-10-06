package com.example.chethan.login;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class register extends AppCompatActivity {

    EditText user,pass;
    Button log;
    FirebaseAuth mAuth;
    ProgressBar pb;
    TextView alreadyy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        user=(EditText)findViewById(R.id.username);
        pass=(EditText)findViewById(R.id.password);
        log=findViewById(R.id.login1);
        alreadyy=findViewById(R.id.already);
        mAuth=FirebaseAuth.getInstance();
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(user.getText().toString().trim()))
                {
                    Toast.makeText(getApplicationContext(),"Enter Email Address",Toast.LENGTH_SHORT).show();
                }
                if(TextUtils.isEmpty(pass.getText().toString().trim()))
                {
                    Toast.makeText(getApplicationContext(),"Enter Password",Toast.LENGTH_SHORT).show();
                }
                if(pass.getText().toString().length()<6)
                {
                    Toast.makeText(getApplicationContext(),"password should contain more than 6 letters",Toast.LENGTH_SHORT).show();
                }


                pb.setVisibility(View.VISIBLE);
                mAuth.createUserWithEmailAndPassword(user.getText().toString().trim(),pass.getText().toString().trim()).addOnCompleteListener(register.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                       pb.setVisibility(View.GONE);
                       if(!task.isSuccessful())
                       {
                           Toast.makeText(getApplicationContext(),"Failed to register",Toast.LENGTH_SHORT).show();

                       }
                       else
                       {
                           startActivity(new Intent(register.this,logout.class));
                       }

                    }
                });
            }
        }
        );




        alreadyy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(register.this,MainActivity.class));

            }
        });
    }
}
