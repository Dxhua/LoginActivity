package com.example.administrator.loginactivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisteredActivity extends AppCompatActivity {
    private SharedPreferences prf;
    private SharedPreferences.Editor editor;
    private Button button_reg;
    private EditText r_name,r_account,r_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registered);
        prf = PreferenceManager.getDefaultSharedPreferences(this);
        button_reg = (Button) findViewById(R.id.registered);
        r_name = (EditText) findViewById(R.id.r_name);
        r_account = (EditText) findViewById(R.id.r_account);
        r_password = (EditText) findViewById(R.id.r_password);
        button_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prf  = getSharedPreferences("data1",MODE_PRIVATE);
                editor = prf.edit();
                editor.putString(r_account.getText().toString(),r_password.getText().toString());
                editor.apply();
                Toast.makeText(getApplicationContext(),"注册成功",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(RegisteredActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });


    }
}
