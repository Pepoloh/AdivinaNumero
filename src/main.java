import java.util.Random;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        do {
            // Escribir menu
            escribirMenu();

            //Pedir opcion
            pedirOpcion();

            //Leer opcion y almacenarla
            int opcion = leerNumero();
            int min;
            int max;
            int maxIntentos;
            switch (opcion) {
                // Si la opcion es 0, salir
                case 0:
                    System.exit(0);
                    break;
                    
                case 1:
                        min = 1;
                        max = 10;
                        maxIntentos = 3;
                        play (min, max, maxIntentos);
                        break;
                case 2:
                    min = 1;
                    max = 50;
                    maxIntentos = 5;
                    break;
                        
            }
        }while (true);

    }



    private static void play(int min, int max, int maxIntentos) {
        //Generar numero aleatorio y almacenarlo
        int numeroGenerado = generarNumeroAleatorio(min, max);

        System.out.println(numeroGenerado);


        //Variable para numero de intentos actuales
        int intentos = 0;
        int numeroUsuario = 0;
        while (intentos < maxIntentos) {
            // Pedir nuemro a usuario
            pedirNumero();
            // Leer numero y gaurdarlo
            numeroUsuario = leerNumero();
            //Incrementar el numero de tiradas
            intentos++;
            //comprobar numeros
            comprobarNumeros (numeroUsuario, numeroGenerado, intentos, maxIntentos);
            //Si acerto el numero, salir del bucle
            if (numeroUsuario == numeroGenerado) {
                break;
            }


        }
        //Si agotamos intentos, escribir numero a adivinar
        if (intentos >= maxIntentos && numeroUsuario != numeroGenerado) {
            System.out.println("El numero generado era" + numeroGenerado);
        }

    }






    private static void comprobarNumeros(int numeroUsuario, int numeroGenerado, int intentos, int maxIntentos) {
        if (numeroUsuario == numeroGenerado) {
            System.out.println("Acertaste el numero en: " + intentos );
        } else if (numeroGenerado < numeroUsuario) {
            System.out.println("El numero es mas pequeño");
        }
        else{
            if (intentos < maxIntentos) {
                System.out.println("El numero es mayor");
            }
        }

    }


    private static void pedirNumero() {
        System.out.println( "Escriba su nuemero");
    }

    private static int generarNumeroAleatorio(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }


    private static int leerNumero() {
        Scanner escaner = new Scanner(System.in);
        return escaner.nextInt();
        
    }

    private static void pedirOpcion() {
        System.out.println( "Escoje tu opcion favorita:");
    }

    private static void escribirMenu() {
        System.out.println("\n ADIVINA EL NUMERO MAGICO\n" + "1. Del 1 al 10 (3 intentos)\n" + "2. Del 1 al 50  (5 intentos)\n" + "0. Salir");
    }
}
