package com.lavacoders.pato.homerokinator;

/**
 * Created by Pato on 02/03/2018.
 */

public class AdivinadorIntellijIDEA {

    /*
    package Mike;

import java.util.Scanner;

public class Adivinador {
    public static void main(String args[]) {



        String nombreUsuario = "";
        int maquinaRandom = 0;
        int menuPrincipal = 0;
        String ingresoUsuario = "";
        int primerIntento = 0;
        int segundoIntento = 0;
        int tercerIntento = 0;
        int cuartoIntento = 0;
        int quintoIntento = 0;
        String help = "";


        System.out.println("************************");
        System.out.println("Bienvenido al Adivinador");
        System.out.println("************************");

        System.out.println("");
        System.out.println("Por favor, ingrese su nombre");

        Scanner ingreseNom = new Scanner(System.in);
        nombreUsuario = ingreseNom.nextLine();

        System.out.println("");


        System.out.println(nombreUsuario + ", ingrese 1 y luego enter para comenzar a jugar. Ingrese 2 y luego enter para leer las reglas");
        Scanner ingresoMenu = new Scanner(System.in);
        menuPrincipal = ingresoMenu.nextInt();

        if (menuPrincipal == 2) {
            System.out.println("• Las reglas consisten en intentar adivinar el número que la máquina eligió en menos de 5 intentos.");
            System.out.println("• Todos los números posibles son múltiplos del número 2");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");

            System.out.println(nombreUsuario + ", ingrese 1 y luego enter para comenzar a jugar. Ingrese 2 y luego enter para leer las reglas");
            menuPrincipal = ingresoMenu.nextInt();

            System.out.println("¡Que comience el juego!");
            System.out.println("");
            System.out.println("");

            maquinaRandom = selectorNumeroMaquina();


            String resultadoFinal = selectorNumeroUsuario(maquinaRandom, nombreUsuario, primerIntento, segundoIntento, tercerIntento, cuartoIntento, quintoIntento);


            System.out.println("");
            System.out.println("¡" + nombreUsuario + ", muchas gracias por jugar!");
        } else if (menuPrincipal == 1) {

            System.out.println("¡Que comience el juego!");
            System.out.println("");
            System.out.println("");

            maquinaRandom = selectorNumeroMaquina();


            String resultadoFinal = selectorNumeroUsuario(maquinaRandom, nombreUsuario, primerIntento, segundoIntento, tercerIntento, cuartoIntento, quintoIntento);


            System.out.println("");
            System.out.println("¡" + nombreUsuario + ", muchas gracias por jugar!");
        } else {
            System.out.println("Comando no reconocido. Programa finalizado.");
        }
    }


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


    private static String selectorNumeroUsuario(int maquinaRandom, String nombreUsuario, int primerIntento, int segundoIntento, int tercerIntento, int cuartoIntento, int quintoIntento) {

        Scanner intentos = new Scanner(System.in);
        String selectorUsuarioFinal = "";
        System.out.println("Primer intento");
        primerIntento = intentos.nextInt();
        if (primerIntento == maquinaRandom) {
            System.out.println("Felicitaciones! Sos un Adivinador! Lo lograste con 4 intentos restantes.");
            selectorUsuarioFinal = "Felicitaciones! Sos un Adivinador! Lo lograste con 4 intentos restantes.";
        } else {
            System.out.println("No has adivinado.");
            System.out.println("Segundo intento");
            segundoIntento = intentos.nextInt();
            if (segundoIntento == maquinaRandom) {
                System.out.println("Felicitaciones! Sos un Adivinador! Lo lograste con 3 intentos restantes.");
                selectorUsuarioFinal = "Felicitaciones! Sos un Adivinador! Lo lograste con 3 intentos restantes.";
            } else {
                System.out.println("No has adivinado.");
                System.out.println("Tercer intento");
                tercerIntento = intentos.nextInt();
                if (tercerIntento == maquinaRandom) {
                    System.out.println("Felicitaciones! Sos un Adivinador! Lo lograste con 2 intentos restantes.");
                    selectorUsuarioFinal = "Felicitaciones! Sos un Adivinador! Lo lograste con 2 intentos restantes.";
                } else {
                    System.out.println("No has adivinado.");
                    System.out.println("Cuarto intento");
                    cuartoIntento = intentos.nextInt();
                    if (cuartoIntento == maquinaRandom) {
                        System.out.println("Felicitaciones! Sos un Adivinador! Lo lograste con 1 intento restante.");
                        selectorUsuarioFinal = "Felicitaciones! Sos un Adivinador! Lo lograste con 1 intento restante.";
                    } else {
                        System.out.println("No has adivinado.");
                        System.out.println("Ultimo intento");
                        quintoIntento = intentos.nextInt();
                        if (quintoIntento == maquinaRandom) {
                            System.out.println("Felicitaciones! Sos un Adivinador! Lo lograste con tu ultimo intento, culón.");
                            selectorUsuarioFinal = "Felicitaciones! Sos un Adivinador! Lo lograste con tu ultimo intento, culón.";
                        } else {
                            System.out.println("Has perdido :(");
                        }
                    }
                }
            }
        }


        return selectorUsuarioFinal;
    }


}


//TODO la maquina piensa un numero y yo adivino el numero que tiene
//TODO maquina generar un random para tener un valor interno y el usuario ingresa para ver si coincide.
//TODO Intellij IDEA Community Edition
    */

}
