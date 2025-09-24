package latinasincloud;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;



public class Main {
    public static void main(String[] args) {

    System.out.println("\n Bienvenido! este es un Simulador de Cajero Automático \n");


    // SIMULADOR DE CAJERO AUTOMATICO //
/* CREAR UN PR0GRAMA QUE SIMULE UN CAJERO AUTOMATICO CON LAS SIGUIENTES FUNCIONES:

1) CONSULTA SALDO
2) DEPOSITAR DINERO
3) RETIRAR DINERO
4) SALIR
 */



        Scanner scanner = new Scanner(System.in);// instanciar la clase Scanner
        final int PIN_CORRECTO = 1234; //defino una clave correcta
        final int MAX_INTENTOS = 3; //defino numero maximo de intentos
        int intentosFallidos = 0;
        double saldo = 30000.0; // Saldo inicial
        List<String> historialTransacciones = new ArrayList<>(); //una lista para historial de transacciones

        /*int opcion = 0; // variable opcion inicializo
        double deposito = 0;
        double saldo = 0;
        double retiro = 0;
        /* String opcion =""; // variable opcion inicializo */

        // Validación del PIN de seguridad
        while (intentosFallidos < MAX_INTENTOS) {
            System.out.print("Por favor, ingrese su PIN: ");
            if (scanner.hasNextInt()) {
                int pinIngresado = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer

                if (pinIngresado == PIN_CORRECTO) {
                    System.out.println("PIN correcto. Acceso concedido.");
                    break; // Salir del bucle de validación
                } else {
                    intentosFallidos++;
                    System.out.println("PIN incorrecto. Intentos restantes: " + (MAX_INTENTOS - intentosFallidos));
                }
            } else {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
                scanner.nextLine(); // Limpiar el buffer
                intentosFallidos++;
            }
        }

        if (intentosFallidos == MAX_INTENTOS) {
            System.out.println("Ha excedido el número de intentos. Su tarjeta ha sido bloqueada. 🔒");
            scanner.close();
            return; // Termina la ejecución del programa
        }

        int opcion;
        do {
            System.out.println("-------Menú-------");
            System.out.println("1) CONSULTA SALDO"); // pido por pantalla
            System.out.println("2) DEPOSITAR DINERO"); // pido por pantalla
            System.out.println("3) RETIRAR DINERO"); // pido por pantalla
            System.out.println("4) Historial de Transacciones");
            System.out.println("5) Salir");
            System.out.print("Seleccione una opción: ");

            // Usar try-catch para manejar entradas no numéricas
            try {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer
            } catch (java.util.InputMismatchException e) {
                System.out.println("Opción no válida. Por favor, ingrese un número.");
                scanner.nextLine(); // Limpiar el buffer
                opcion = 0; // Se asigna 0 para que el bucle continúe
            }



            switch (opcion) {
                case 1:
                    System.out.println("Usted a escogido opción 1) CONSULTA SALDO");
                    //solicitar el nombre y apellido y saludar
                    System.out.println("Su saldo actual es:" + "$" + saldo); // pregunta lo que necesita lo uesta por pantala y se salta una linea
                    historialTransacciones.add("Consulta de Saldo: $" + saldo);
                    break;
                case 2:
                    System.out.println("Usted a escogido opción 2) DEPOSITAR DINERO");
                    System.out.println("Ingrese su deposito : $");
                    double deposito = scanner.nextDouble();
                    scanner.nextLine(); // Limpiar el buffer
                    if (deposito > 0) {
                        saldo += deposito;
                        System.out.println("Depósito de $" + deposito + " realizado con éxito.");
                        System.out.println("Nuevo saldo: $" + saldo);
                        historialTransacciones.add("Depósito: +$" + deposito);
                    } else {
                        System.out.println("La cantidad a depositar debe ser mayor que cero.");
                    }
                    break;
                    case 3:
                    System.out.println("Usted a escogido opción3) RETIRAR DINERO");
                    System.out.println("Ingrese monto a retirar de dinero : $");
                        double retiro = scanner.nextDouble();
                        scanner.nextLine(); // Limpiar el buffer
                        if (retiro > 0 && retiro <= saldo) {
                            saldo -= retiro;
                            System.out.println("Retiro de $" + retiro + " realizado con éxito.");
                            System.out.println("Nuevo saldo: $" + saldo);
                            historialTransacciones.add("Retiro: -$" + retiro);
                        } else {
                            System.out.println("Monto de retiro no válido. Asegúrese de que sea un número positivo y no exceda su saldo actual.");
                        }
                    break;
                case 4:
                    System.out.println("\n--- Historial de Transacciones ---");
                    if (historialTransacciones.isEmpty()) {
                        System.out.println("No se han realizado transacciones aún.");
                    } else {
                        for (String transaccion : historialTransacciones) {
                            System.out.println(transaccion);
                        }
                    }
                    break;
                case 5:
                    System.out.println("\nUsted ha escogido SALIR.");
                    System.out.println("¡Hasta luego! Gracias por usar el cajero.");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente nuevamente.");
            }
        } while (opcion != 5);

        scanner.close();
    }
}


