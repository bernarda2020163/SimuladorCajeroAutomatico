package latinasincloud;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

// SIMULADOR DE CAJERO AUTOMATICO //
/* CREAR UN PR0GRAMA QUE SIMULE UN CAJERO AUTOMATICO CON LAS SIGUIENTES FUNCIONES:

1) CONSULTA SALDO
2) DEPOSITAR DINERO
3) RETIRAR DINERO
4) SALIR
 */

        System.out.println("Bienvenido! este es un Simulador de Cajero Automático");

        Scanner scanner = new Scanner(System.in);// instanciar la clase Scanner
        int opcion = 0; // variable opcion inicializo
        double deposito = 0;
        double saldo = 0;
        double retiro = 0;
        /* String opcion =""; // variable opcion inicializo */
        do {
            System.out.println("-------Menú-------");
            System.out.println("1) CONSULTA SALDO"); // pido por pantalla
            System.out.println("2) DEPOSITAR DINERO"); // pido por pantalla
            System.out.println("3) RETIRAR DINERO"); // pido por pantalla
            System.out.println("4) SALIR  "); // pido por pantalla
            System.out.println("Seleccione una opción del menú : "); // pido por pantalla
            opcion = scanner.nextInt(); // Intenta leer un número

            scanner.nextLine();// limpiar buffer */


            switch (opcion) {
                case 1:
                    System.out.println("Usted a escogido opción 1) CONSULTA SALDO");
                    //solicitar el nombre y apellido y saludar
                    System.out.println("Su saldo es : " + "$" + saldo); // pregunta lo que necesita lo uesta por pantala y se salta una linea
                    break;
                case 2:
                    System.out.println("Usted a escogido opción 2) DEPOSITAR DINERO");
                    System.out.println("Ingrese su deposito :");
                    deposito = scanner.nextDouble();
                    if (deposito > 0) {
                        saldo +=deposito;
                        System.out.println("Su deposito de  :" + "$" + deposito + " pesos ha sido realizado con exito");
                    } else {
                        System.out.println("Debe ingresar un deposito");
                    }
                    break;
                case 3:
                    System.out.println("Usted a escogido opción3) RETIRAR DINERO");
                    System.out.println("Ingrese monto a retirar de dinero :");
                    retiro = scanner.nextDouble();
                    //validacion de saldo
                    if (saldo-retiro <= 0) {
                        System.out.println("El monto de retiro ingresado "+ retiro + " excede el máximo" );
                    } else {
                        saldo -=retiro;
                        System.out.println("Retiro realizado con éxito retire su dinero " + retiro );
                    }
                    break;
                case 4:
                    System.out.println("Usted a escogido opción 4) SALIR");
                    System.out.println("¡Hasta luego! Gracias por usar el cajero 👋");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta nuevamente.");
                    //System.out.println("Necesita algo mas del menú");
            }
            System.out.println(); // Salto de línea
        } while (opcion != 4);
        scanner.close();
    }
}


