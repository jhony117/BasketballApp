package com.example.basketballapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.basketballapp.databinding.ActivityResultadosBinding;

public class Resultados extends AppCompatActivity {

    public static final  String LOCAL = "LOCAL";
     public static  final String  VISITANTE = "VISITANTE";

     private ActivityResultadosBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        ActivityResultadosBinding binding = ActivityResultadosBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_resultados);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });



//Bundle extra = getIntent().getExtras();
        Intent intent = getIntent();
        int localScore = Integer.parseInt(LOCAL);
        int visitanteScore =Integer.parseInt(VISITANTE);
        //no me resive los datos esta actividad
        binding.resultado.setText("sii");
        binding.localSC.setText(String.valueOf(localScore));
        binding.visitanteR.setText(String.valueOf(visitanteScore));

        if(localScore > visitanteScore){
            binding.resultado.setText("el equipo local ha ganado");
        }
        if(visitanteScore > localScore){
            binding.resultado.setText("el equipo visitante ah ganado");
        }
        if(visitanteScore == localScore){
            binding.resultado.setText("ha sifo un empate");
        }



    }



}