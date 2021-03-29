package com.example.primeiroapptest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity {
    
    Button btnLogin;
    EditText txtUser, txtSenha;

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        context = LoginActivity.this;

        btnLogin = findViewById(R.id.btnLogar);
        txtUser = findViewById(R.id.txtUser);
        txtSenha = findViewById(R.id.txtSenha);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = txtUser.getText().toString();
                String password = txtSenha.getText().toString();

                if(user.equals("admin") && password.equals("admin")){
                    Intent tela = new Intent(context, MenuActivity.class);
                    startActivity(tela);
                    finish();

                }else{

                    exibirToast("Usuário ou Senha incorretos");
                }

            }
        });
    }
    private void exibirToast(String texto){
        try{
            Toast.makeText(context, texto, Toast.LENGTH_LONG).show();

        }catch (Exception ex){
            Log.e("ERROR", ex.getMessage());

        }
    }

}

