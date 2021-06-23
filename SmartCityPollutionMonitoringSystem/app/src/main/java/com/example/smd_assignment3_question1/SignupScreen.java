package com.example.smd_assignment3_question1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class SignupScreen extends AppCompatActivity {

    public FirebaseAuth auth ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_screen);
        auth=FirebaseAuth.getInstance();
    }
    public void SigninScreen(View v)
    {
        Intent intent=new Intent(this,MainActivity.class) ;
        startActivity(intent);
    }

    public void signupbutton(View v)
    {
        EditText et1=(EditText)findViewById(R.id.editText);
        EditText et2=(EditText)findViewById(R.id.editText11);
        EditText et3=(EditText)findViewById(R.id.editText3);
        if(TextUtils.isEmpty(et1.getText().toString()) || TextUtils.isEmpty(et2.getText().toString())
        || TextUtils.isEmpty(et3.getText().toString()))
        {
            Toast.makeText(this,"All Fields are necessary to sign up",Toast.LENGTH_SHORT).show();
        }
        else
        {
            registeruser(et2.getText().toString(),et3.getText().toString()) ;

            Toast.makeText(this,"Sign up Successfully ",Toast.LENGTH_SHORT).show();
        }

    }

    public void registeruser(String email,String password)
    {
        auth.createUserWithEmailAndPassword(email,password);


    }
}
