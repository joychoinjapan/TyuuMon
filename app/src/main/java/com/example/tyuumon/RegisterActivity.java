package com.example.tyuumon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {
    private EditText ed_re_user_email,ed_re_user_pwd;
    private Button btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ed_re_user_email = findViewById(R.id.ed_re_user_email);
        ed_re_user_pwd = findViewById(R.id.ed_re_user_pwd);
        btn_register = findViewById(R.id.btn_register);

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = ed_re_user_email.getText().toString();
                String pwd = ed_re_user_pwd.getText().toString();
                Log.e("TAG","email:"+email+",pwd:"+pwd);

                Bundle bundle = new Bundle();
                bundle.putString("email",email);
                bundle.putString("pwd",pwd);

                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                intent.putExtras(bundle);
                intent.putExtra("fromRegisterActivity",true);

                startActivity(intent);
            }
        });



    }

}