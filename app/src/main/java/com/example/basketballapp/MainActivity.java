package com.example.basketballapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.basketballapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {


    private ActivityMainBinding binding;

    public  int PUNTUACION_L = 0;
    public  int PUNTUACION_V = 0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        EdgeToEdge.enable(this);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });




        binding.add1L.setOnClickListener(v -> {
            PUNTUACION_L += 1 ;
            binding.scoreL.setText(PUNTUACION_L) ;
        });
        binding.add2L.setOnClickListener(v -> {
            PUNTUACION_L += 2 ;
            binding.scoreL.setText(PUNTUACION_L) ;
        });
        binding.decreaseL.setOnClickListener(v -> {
            PUNTUACION_L -= 1 ;
            binding.scoreL.setText(String.valueOf(PUNTUACION_L));
            menorPuntuacionL();
        });

        binding.restart.setOnClickListener(v -> {
            PUNTUACION_V = 0;
            PUNTUACION_L = 0;
            binding.scoreV.setText((String.valueOf(PUNTUACION_V)));
            binding.scoreL.setText(String.valueOf((PUNTUACION_L)));
        });


        binding.add1V.setOnClickListener(v -> {
            PUNTUACION_V += 1;
            binding.scoreV.setText(String.valueOf(PUNTUACION_V));
            menorPuntuacionV();
        });
        binding.add2L.setOnClickListener(v -> {
            PUNTUACION_V += 2 ;
            binding.scoreV.setText(String.valueOf((PUNTUACION_V)));
        });
        binding.decreaseV.setOnClickListener(v -> {
            PUNTUACION_V -= 1 ;
            binding.scoreV.setText(String.valueOf((PUNTUACION_V)));
            menorPuntuacionL();
        });


    }
    public void  menorPuntuacionV() {
        if(PUNTUACION_V < 0){
            PUNTUACION_V = 0;
        }
    }
    public void  menorPuntuacionL() {
        if(PUNTUACION_L < 0){
            PUNTUACION_L = 0;
        }
    }
}