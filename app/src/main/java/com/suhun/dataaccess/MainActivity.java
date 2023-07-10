package com.suhun.dataaccess;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences sp;
    private SharedPreferences.Editor speditor;
    private EditText inputAccount,inputPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp = getSharedPreferences("config", MODE_PRIVATE);
        speditor = sp.edit();
        initView();
    }
    private void initView(){
        inputAccount = findViewById(R.id.account);
        inputPassword = findViewById(R.id.password);
        inputAccount.setText(sp.getString("account", null));
        inputPassword.setText(sp.getString("password", null));
    }

    public void finishFun(View view){
        speditor.putString("account", inputAccount.getText().toString());
        speditor.putString("password", inputPassword.getText().toString());
        speditor.commit();
    }
}