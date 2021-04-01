package com.example.primeiroapptest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MenucActivity extends AppCompatActivity {
    Button btnBotoes, btnToast, btnLogout;
    TextView lblUsuario;
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuc);

        SharedPreferences sharedPreferences =
                getSharedPreferences(getString(R.string.pref_key), context.MODE_PRIVATE);


        context = MenucActivity.this;


        lblUsuario = findViewById(R.id.lblUsuario);
        btnBotoes = findViewById(R.id.btnBotoes);
        btnToast = findViewById(R.id.btnToast);
        btnLogout = findViewById(R.id.btnLogout);

        String nome_usuario = sharedPreferences.getString("usuario","");
        lblUsuario.setText("Bem-Vindo - "+ nome_usuario);


        btnBotoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent tela = new Intent(context, BotoesActivity.class);
                startActivity(tela);


            }
        });

        btnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                exibirToast("!!!Bem-Vindo na tela de menu!!!");
            }
        });

        //Tudo Certo...



        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try{

                    //Zerar o shared

                    sharedPreferences.edit().clear().commit();

                    Intent tela = new Intent(context, LoginActivity.class);
                    startActivity(tela);
                    finish();

                }catch (Exception ex){

                    exibirToast("Erro!");
                }
            }
        });



    }

    private void exibirToast(String texto){
        try{
            Toast.makeText(context, texto, Toast.LENGTH_LONG).show();

        }catch (Exception ex){

        }
    }
}