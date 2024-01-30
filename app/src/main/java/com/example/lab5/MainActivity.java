package com.example.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String username,password;
    Database DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn=findViewById(R.id.button);
        Button login=findViewById(R.id.login);
        EditText usernameText=findViewById(R.id.username);
        EditText passwordText=findViewById(R.id.password);
        DB=new Database(this);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username=usernameText.getText().toString();
                password=passwordText.getText().toString();
                boolean result=DB.insertData(username,password);
                if(result==true){
                    Toast.makeText(getApplicationContext(),"Data Inserted",Toast.LENGTH_LONG).show();
                    Log.i("result","Data inserted");
                }else{
                    Object data;
                    Toast.makeText(getApplicationContext(),"Cannot Insert data",Toast.LENGTH_LONG).show();
                            Log.i("result","failed");
                }

            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username=usernameText.getText().toString();
                password=passwordText.getText().toString();
                Boolean cr=DB.getData(username,password);
                if(cr==false){
                    Toast.makeText(getApplicationContext(),"Invalid credentials",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(),"Welcome"+username,Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}