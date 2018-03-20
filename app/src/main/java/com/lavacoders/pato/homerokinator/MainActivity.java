package com.lavacoders.pato.homerokinator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button buttonReglas = (Button) findViewById(R.id.btnReglas);
        buttonReglas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ReglasPopup.class));
                overridePendingTransition(R.anim.zoom_back_in, R.anim.zoom_back_out);
            }
        });

        Button buttonJuego = (Button) findViewById(R.id.btnPlay);
        buttonJuego.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ActivityDificultades.class));
                overridePendingTransition(R.anim.zoom_back_in, R.anim.zoom_back_out);
            }
        });

    }
}
