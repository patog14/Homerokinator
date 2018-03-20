package com.lavacoders.pato.homerokinator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityDificultades extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dificultades);


        Button diffFacil = findViewById(R.id.diffFacil);
        Button diffNormal = findViewById(R.id.diffNormal);
        Button diffDificil = findViewById(R.id.diffDificil);


        diffFacil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ActivityDificultades.this, ActivityJuego.class));
                overridePendingTransition(R.anim.zoom_back_in, R.anim.zoom_back_out);
            }
        });

        diffNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ActivityDificultades.this, ActivityJuego.class));
                overridePendingTransition(R.anim.zoom_back_in, R.anim.zoom_back_out);
            }
        });

        diffDificil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ActivityDificultades.this, ActivityJuego.class));
                overridePendingTransition(R.anim.zoom_back_in, R.anim.zoom_back_out);
            }
        });


    }
}
