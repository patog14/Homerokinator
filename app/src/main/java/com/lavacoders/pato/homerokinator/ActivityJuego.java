package com.lavacoders.pato.homerokinator;

import android.content.Intent;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Vibrator;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewAnimator;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import org.apache.commons.lang3.StringUtils;

import libs.mjn.prettydialog.PrettyDialog;
import libs.mjn.prettydialog.PrettyDialogCallback;


public class ActivityJuego extends AppCompatActivity {


    public int lives = 5;
    private Button buttonOk;
    private EditText ingresoOk;
    private ImageView vidaRoja4;
    private ImageView vidaRoja3;
    private ImageView vidaRoja2;
    private ImageView vidaRoja1;
    private EditText ingresoUsuario2;
    private RelativeLayout gameLose;
    private RelativeLayout inGame;
    private Button reglas2;
    private Button btnAgain;
    private Button btnBackMenu;
    private ImageView logoHomero;
    private int maquinaRandom;
    private MediaPlayer wrongSound;
    private MediaPlayer rightSound;
    private MediaPlayer tadaSound;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);


        buttonOk = (Button) findViewById(R.id.btnOk);
        ingresoOk = (EditText) findViewById(R.id.ingresoUsuario2);
        vidaRoja4 = findViewById(R.id.vidaRoja4);
        vidaRoja3 = findViewById(R.id.vidaRoja3);
        vidaRoja2 = findViewById(R.id.vidaRoja2);
        vidaRoja1 = findViewById(R.id.vidaRoja1);
        ingresoUsuario2 = (EditText) findViewById(R.id.ingresoUsuario2);
        gameLose = findViewById(R.id.gameLose);
        inGame = findViewById(R.id.inGame);
        reglas2 = (Button) findViewById(R.id.btnReglas2);
        btnAgain = findViewById(R.id.btnAgain);
        btnBackMenu = findViewById(R.id.btnBackMenu);
        logoHomero = findViewById(R.id.logo);

        maquinaRandom = selectorNumeroMaquina();
        wrongSound = MediaPlayer.create(this, R.raw.wrong_sound);
        rightSound = MediaPlayer.create(this, R.raw.right_sound);
        tadaSound = MediaPlayer.create(this, R.raw.tada);


        // Animación al tocar la foto de Homero
        logoHomero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                YoYo.with(Techniques.Tada)
                        .duration(350)
                        .playOn(logoHomero);

                Vibrator v = (Vibrator) getSystemService(VIBRATOR_SERVICE);
                v.vibrate(500);

                tadaSound.start();

            }
        });


        // Funciónes que hacen que el teclado se cierre al tocar afuera del EditText (2 veces por haber 2 layouts en la misma activity)
        findViewById(R.id.inGame).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager im = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                im.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
            }

        });

        findViewById(R.id.mainGameLayout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager im = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                im.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
            }

        });





        // Vibración al tocar la foto de Homero
        ingresoUsuario2.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    evaluarIngreso();

                }
                return false;
            }
        });


        //Pop-up Reglas
        reglas2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ActivityJuego.this, ReglasPopup.class));
                overridePendingTransition(R.anim.zoom_back_in, R.anim.right_out);
            }
        });


        // Llamado a la función que hace la comparación entre el número ingresado y el random
        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                evaluarIngreso();
            }
        });


        // Botón "Jugar otra vez"
        btnAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityJuego.super.finish();
                startActivity(new Intent(ActivityJuego.this, ActivityJuego.class));
            }
        });


        // Botón "Volver al menú"
        btnBackMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ActivityJuego.this, MainActivity.class));
            }
        });

    }


    // 4 diálogos de error, cada uno correspondiente al numero de error (del 4 al 1)
    private void dialogError4() {
        new PrettyDialog(this)
                .setTitle("No has acertado")
                .setMessage("4 intentos restantes")
                .setIcon(R.drawable.error)
                .setIconTint(R.color.pdlg_color_red)
                .addButton(
                        "OK",     // button text
                        R.color.pdlg_color_white,  // button text color
                        R.color.pdlg_color_red,  // button background color
                        new PrettyDialogCallback() {  // button OnClick listener
                            @Override
                            public void onClick() {

                            }
                        }
                )
                .setAnimationEnabled(true)
                .show();

    }

    private void dialogError3() {
        new PrettyDialog(this)
                .setTitle("No has acertado")
                .setMessage("3 intentos restantes")
                .setIcon(R.drawable.error)
                .setIconTint(R.color.pdlg_color_red)
                .addButton(
                        "OK",     // button text
                        R.color.pdlg_color_white,  // button text color
                        R.color.pdlg_color_red,  // button background color
                        new PrettyDialogCallback() {  // button OnClick listener
                            @Override
                            public void onClick() {

                            }
                        }
                )
                .setAnimationEnabled(true)
                .show();

    }

    private void dialogError2() {
        new PrettyDialog(this)
                .setTitle("No has acertado")
                .setMessage("2 intentos restantes")
                .setIcon(R.drawable.error)
                .setIconTint(R.color.pdlg_color_red)
                .addButton(
                        "OK",     // button text
                        R.color.pdlg_color_white,  // button text color
                        R.color.pdlg_color_red,  // button background color
                        new PrettyDialogCallback() {  // button OnClick listener
                            @Override
                            public void onClick() {

                            }
                        }
                )
                .setAnimationEnabled(true)
                .show();

    }

    private void dialogError1() {
        new PrettyDialog(this)
                .setTitle("No has acertado")
                .setMessage("Último intento")
                .setIcon(R.drawable.error)
                .setIconTint(R.color.pdlg_color_red)
                .addButton(
                        "OK",     // button text
                        R.color.pdlg_color_white,  // button text color
                        R.color.pdlg_color_red,  // button background color
                        new PrettyDialogCallback() {  // button OnClick listener
                            @Override
                            public void onClick() {

                            }
                        }
                )
                .setAnimationEnabled(true)
                .show();

    }


    // Diálogo al ganar
    private void dialogSuccess() {
        new PrettyDialog(this)
                .setTitle("¡Has acertado!")
                .setMessage("¡Felicitaciones!")
                .setIcon(R.drawable.success)
                .setIconTint(R.color.pdlg_color_green)
                .addButton(
                        "OK",     // button text
                        R.color.pdlg_color_white,  // button text color
                        R.color.pdlg_color_green,  // button background color
                        new PrettyDialogCallback() {  // button OnClick listener
                            @Override
                            public void onClick() {
                                startActivity(new Intent(ActivityJuego.this, GameWinPopup.class));
                            }
                        }
                )
                .setAnimationEnabled(true)
                .show();
    }


    // Función que compara el numero ingresado por el usuario con el random generado del array
    private void evaluarIngreso() {
        String ingreso2 = ingresoOk.getText().toString();
        int ingreso2final = 0;

        if (buttonOk.isClickable()) {


            // (Primer If) Validacion sobre si se ingreso un numero o una letra
            if (StringUtils.isNumeric(ingreso2)) {
                ingreso2final = Integer.parseInt(ingreso2);
                if (ingreso2final != maquinaRandom) {
                    // Inicialización del sonido de error
                    wrongSound.start();
                    // Mensaje en pantalla
                    Toast.makeText(ActivityJuego.this, "No has acertado", Toast.LENGTH_SHORT).show();
                    // Llamado a la función encargada de manejar las vidas, la cual termina mostrando la actividad correspondiente a haber perdido
                    checkLifes(vidaRoja4, vidaRoja3, vidaRoja2, vidaRoja1, vidaRoja4, ingresoUsuario2);
                    if (lives == 0) {
                        gameOverLose(gameLose, inGame, lives);
                    }


                } else {
                    // Inicialización del sonido al ganar
                    rightSound.start();
                    Toast.makeText(ActivityJuego.this, "Felicitaciones! Has ganado.", Toast.LENGTH_SHORT).show();
                    // Cambio a la actividad por haber ganado
                    gameOverWin(ingresoUsuario2, buttonOk, lives, reglas2);

                }
            } else {
                //Mensaje en pantalla cuando se quiere introductir un espacio en blanco.
                Toast.makeText(ActivityJuego.this, "El dato que introduciste no es valido", Toast.LENGTH_SHORT).show();
            }


            //TODO: Hacer un loop usando ingreso2final == maquinaRandom que sirva para reemplazar todos los ifs hechos en mi java
            //Ver en el Ij IDEA el ultimo comentario con el intento que no funciono usando for
            //TODO: 2 caminos: El primero es el que quiero intentar el cual consiste en que las vidas bajen pero que tambien mediante un toast se muestre los intentos restantes. El segundo camino puede ser que el toast se repita en loop siempre diciendo que no fue correcto y que las vidas bajen.


        }

    }


    // Función que se encarga de contar la cantidad de vidas actuales, la cual va disminuyendo con cada error.
    private void checkLifes(ImageView cuatroVidas, ImageView dosVidas, ImageView tresVidas, ImageView unaVida, ImageView ceroVidas, EditText ingresoUsuario2) {
        lives--;
        if (lives == 4) {
//            cuatroVidas.setVisibility(View.INVISIBLE);
//            tresVidas.setVisibility(View.VISIBLE);

            //Llamado al diálogo de error
            dialogError4();

            YoYo.with(Techniques.FadeOutDown)
                    .duration(350)
                    .playOn(findViewById(R.id.vidaRoja1));

        } else if (lives == 3) {
//            tresVidas.setVisibility(View.INVISIBLE);
//            dosVidas.setVisibility(View.VISIBLE);

            dialogError3();

            YoYo.with(Techniques.FadeOutDown)
                    .duration(350)
                    .playOn(findViewById(R.id.vidaRoja2));

        } else if (lives == 2) {
//            dosVidas.setVisibility(View.INVISIBLE);
//            unaVida.setVisibility(View.VISIBLE);

            dialogError2();

            YoYo.with(Techniques.FadeOutDown)
                    .duration(350)
                    .playOn(findViewById(R.id.vidaRoja3));

        } else if (lives == 1) {
//            unaVida.setVisibility(View.INVISIBLE);
//            ceroVidas.setVisibility(View.VISIBLE);

            dialogError1();

            YoYo.with(Techniques.FadeOutDown)
                    .duration(350)
                    .playOn(findViewById(R.id.vidaRoja4));

        } else {
            //Toast.makeText(this, "PERDISTE :(", Toast.LENGTH_SHORT).show();

        }

    }


    // Función que se encarga de lo que pasa al ganar
    private void gameOverWin(EditText ingresoUsuario2, Button buttonOk, int lives, Button reglas2) {
        if (lives > 0) {
            ingresoUsuario2.setVisibility(View.INVISIBLE);
            buttonOk.setVisibility(View.INVISIBLE);
            reglas2.setVisibility(View.INVISIBLE);

            dialogSuccess();
        }

        //TODO Crear una nueva activity para hacer un popup con una felicitacion por haber ganado y los mismos botones que abajo.
    }


    // Función que se encarga de lo que pasa al perder
    private void gameOverLose(RelativeLayout gameLose, RelativeLayout inGame, int lives) {
        //TODO Una vez desaparecido todo en pantalla menos el homero, poner dos botones de "Try Again" y "Volver al menu"
        if (lives == 0) {
            gameLose.setVisibility(View.VISIBLE);
            inGame.setVisibility(View.INVISIBLE);
        }
    }


    // Numero aleatorio elegido por la maquina
    private static int selectorNumeroMaquina() {

        int numeros[] = new int[10];

        numeros[0] = 2;
        numeros[1] = 4;
        numeros[2] = 6;
        numeros[3] = 8;
        numeros[4] = 10;
        numeros[5] = 12;
        numeros[6] = 14;
        numeros[7] = 16;
        numeros[8] = 18;
        numeros[9] = 20;

        int random = (int) (Math.random() * 10);


        return numeros[random];
    }


}


//TODO Dudas: Diferencia entre declarar buttokOk dentro del onCreate con arriba del Override.
//TODO        El visibility no esta mostrando las fotos superpuestas.
//TODO        #292929
//TODO        android:theme="@style/AppTheme.NoActionPato" = Viejo theme de las activity
//TODO
//TODO
//TODO
//TODO
//TODO