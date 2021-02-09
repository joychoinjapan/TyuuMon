package com.example.tyuumon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText ed_login_user_email,ed_login_user_pwd;
    private Button btn_lg_user;
    private TextView tv_find_pwd,tv_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        tv_register = findViewById(R.id.tv_register);
        ed_login_user_email = findViewById(R.id.ed_login_user_email);
        ed_login_user_pwd = findViewById(R.id.ed_login_user_pwd);

        Intent intent = getIntent();

        if(intent.getExtras()!= null){
            if(intent.getExtras().containsKey("fromRegisterActivity")){
                String email = intent.getExtras().getString("email");
                String pwd = intent.getExtras().getString("pwd");
                Log.e("TAGlogin","email:"+email+",pwd:"+pwd);
                ed_login_user_email.setText(email);
                ed_login_user_pwd.setText(pwd);
            }
        }









    }

    public void toRegisterPage(View view){
        startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
    }

    public void checkLoginUser(View view){
        if(ed_login_user_email.getText().toString().length()>0
                && ed_login_user_pwd.getText().toString().length()>0){
            startActivity(new Intent(LoginActivity.this,MainActivity.class));
        }else{
            Toast.makeText(this,"请输入账户和密码",Toast.LENGTH_SHORT).show();
        }
    }
}