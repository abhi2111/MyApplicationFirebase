package com.example.abhujeeth.myapplicationfirebase;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Registration extends AppCompatActivity implements View.OnClickListener {

   private Button button;
    private EditText editText_one,editText_two;
    FirebaseAuth firebaseAuth;
    private String emailid,password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        button=(Button)findViewById(R.id.button_register);
        editText_one=(EditText)findViewById(R.id.editone);
        editText_two=(EditText)findViewById(R.id.edittwo);
        firebaseAuth=FirebaseAuth.getInstance();
        button.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        validate();

        firebaseAuth.createUserWithEmailAndPassword(emailid,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(Registration.this,"successfull",Toast.LENGTH_LONG).show();
                        }
                        else
                        {
                            Toast.makeText(Registration.this,task.getException().toString(),Toast.LENGTH_LONG).show();

                        }
                    }
                });

    }

    private void validate() {

         emailid=editText_one.getText().toString().trim();
         password=editText_two.toString().toString().trim();

        if(emailid.isEmpty())
        {
            Toast.makeText(Registration.this,"enter email",Toast.LENGTH_LONG);

        }
        if(password.isEmpty())
        {
            Toast.makeText(Registration.this,"enter password",Toast.LENGTH_LONG);

        }
    }
}
