package com.example.smd_assignment3_question1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private static  int SPLASH_TIME_OUT=1000;
    public FirebaseAuth auth ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        auth=FirebaseAuth.getInstance() ;
    }
    public void SignUpScreen(View v)
    {
        Intent intent=new Intent(this,SignupScreen.class) ;
        startActivity(intent);


    }
    public void CheckCrediantials(View v)
    {
        EditText editText1=(EditText) findViewById(R.id.editText);
        EditText editText2=(EditText) findViewById(R.id.editText2);

        String email="ABC" ;
                email=editText1.getText().toString();
        String password="ABC" ;
                password=editText2.getText().toString();
        if(TextUtils.isEmpty(editText1.getText().toString()) || TextUtils.isEmpty(editText2.getText().toString()))
        {
            Toast.makeText(this,"All Fields are necessary to filled",Toast.LENGTH_SHORT).show();
        }
        else
        {
            loginuser(editText1.getText().toString(),editText2.getText().toString());
            Toast.makeText(this,"Login Successful",Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(this,First_Screen_After_login.class);
            startActivity(intent);

        }


    }
    public void loginuser(String email,String password)
    {
        auth.signInWithEmailAndPassword(email,password);
    }
}
