package com.example.primeiroapptest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
        SharedPreferences sharedPreferences =
                getSharedPreferences(getString(R.string.pref_key), context.MODE_PRIVATE);

        context = LoginActivity.this;

        btnLogin = findViewById(R.id.btnLogar);
        txtUser = findViewById(R.id.txtUser);
        txtSenha = findViewById(R.id.txtSenha);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try{


                    String user = txtUser.getText().toString();
                    String password = txtSenha.getText().toString();

                    if(user.equals("admin") && password.equals("admin")){

                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("usuario" , txtUser.getText().toString());

                        if(editor.commit()){

                            Intent tela = new Intent(context, MenucActivity.class);
                            startActivity(tela);
                            finish();


                        }else{

                            exibirToast("Aconteceu alguem erro!");

                        }

                    }else{
                        exibirToast("Usuário ou Senha incorretos!");
                    }


                }catch(Exception ex){

                    exibirToast(ex.getMessage());

                }

            }
        });

        String nome_usuario = sharedPreferences.getString("usuario","");
        if (!nome_usuario.equals("")) {

            Intent tela = new Intent(context, MenucActivity.class);
            startActivity(tela);

        }

    }
    private void exibirToast(String texto){
        try{
            Toast.makeText(context, texto, Toast.LENGTH_LONG).show();

        }catch (Exception ex){
            Log.e("ERROR", ex.getMessage());

        }
    }

}

