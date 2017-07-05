package com.example.abhujeeth.myapplicationfirebase;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Main2Activity extends AppCompatActivity  implements View.OnClickListener{


    private Button button;
    private EditText editTextone;
    private EditText editTexttwo;
    private FirebaseAuth firebaseAuth;
    String email,password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

       editTextone=(EditText)findViewById(R.id.editthree);
        editTexttwo=(EditText)findViewById(R.id.editfour);
        firebaseAuth=FirebaseAuth.getInstance();

        button=(Button)findViewById(R.id.buttonthree);
        button.setOnClickListener(this);
        if(firebaseAuth.getCurrentUser() == null){
            //closing this activity
            finish();
            //starting login activity
            startActivity(new Intent(this, Registration.class));
        }
        
    }

    @Override
    public void onClick(View v) {
        signinUser();

    }

    public void signinUser()
    {

        if(email.isEmpty())
        {
            Toast.makeText(this,"enter emailid",Toast.LENGTH_LONG);
        }
        if(password.isEmpty())
        {
            Toast.makeText(this,"enter password",Toast.LENGTH_LONG);
        }
       email =editTextone.getText().toString().trim();
        password=editTexttwo.getText().toString().trim();
        Log.d("hi","hi");

        firebaseAuth.getInstance().signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                Log.d("hiii","hiii");
               if(task.isSuccessful()) {
                   finish();
                   Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                   startActivity(intent);
               }
                else {
                   Log.w("tag", "createUserWithEmail:failure", task.getException());


                   Toast.makeText(Main2Activity.this, task.getException().toString(), Toast.LENGTH_LONG).show();
               }
            }
        });

    }
}
