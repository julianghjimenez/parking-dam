package ies.puerto;

import java.util.Scanner;

public class Parking {

    static String nombreUsuario;
    static int opcion = 0;
    static float tarifaHora = 1.50f;
    static int totalVehiculos = 0;
    static int totalHorasRegistradas = 0;
    static int totalCalculosTarifa = 0;
    static float importeTotalCalculado = 0;
    static int cantidad = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Indique su nombre: ");
        nombreUsuario = scanner.nextLine();

        do {
            mostrarMenu();

            System.out.println("Elija una opcion: ");
            opcion = scanner.nextInt();
            while (opcion <= 0 || opcion > 4) {
                mostrarMenu();
                System.out.println("Opcion no válida");
                System.out.println("Elija una opcion: ");
                opcion = scanner.nextInt();
            }
            ;
            switch (opcion) {
                case 1:
                    registrarVehiculos(scanner);

                    break;
                case 2:

                    calcularTarifa(scanner);
                    break;
                case 3:
                    mostrarResumen();
                    break;

                default:
                    break;
            }
        } while (opcion != 4);
        System.out.println("Gracias por utilizar PARKING DAM-PRO");
        scanner.close();

    }

    /**
     * Menu principal para la asistencia del usuario
     */
    public static void mostrarMenu() {

        System.out.println();
        System.out.println("================================");
        System.out.println("         Menú principal         ");
        System.out.println("================================");

        System.out.println();

        System.out.println("1. Registrar vehículos");
        System.out.println("2. Calcular tarifa de estacionamiento");
        System.out.println("3. Mostrar resumen del día");
        System.out.println("4. Salir");

    }

    /**
     * Solicitud al ususario de datos del vehiculo a registrar
     * @param scanner objeto Scanner para leer desde teclado
     */
    public static void registrarVehiculos(Scanner scanner) {

        System.out.println();
        cantidad = leerEnteroPositivo(scanner, "¿Cuántos vehículos quieres registrar? ");

        for (int i = 1; i <= cantidad; i++) {
            System.out.println("Vehículo: " + i);
            System.out.print("Matrícula: ");
            String matricula = scanner.next();
            System.out.println("Matrícula registrada: " + matricula);

            int horas = leerEnteroPositivo(scanner, "Horas estacionado: ");

            totalVehiculos++;
            totalHorasRegistradas += horas;
        }

        System.out.println();
        System.out.println("Vehículos registrados en esta operación: " + cantidad);
    }

    /**
     * Calculo de la tarifa 
     * @param scanner objeto Scanner para leer desde teclado
     */
    public static void calcularTarifa(Scanner scanner) {

        System.out.println();
        int horas = leerEnteroPositivo(scanner, "Horas para calcular la tarifa: ");
        float importe = horas * tarifaHora;
        totalCalculosTarifa++;
        importeTotalCalculado += importe;

        System.out.println("Importe: " + importe + " EUR");
        return;
    }

    /**
     * Solicita un entero positivo y repite la lectura mientras el valor no sea positivo.
     *
     * @param scanner objeto Scanner para leer desde teclado
     * @param mensaje texto que se muestra antes de solicitar el valor
     * @return entero positivo introducido por el usuario
     */
    public static int leerEnteroPositivo(Scanner scanner, String mensaje) {
        System.out.print(mensaje);
        int valor = scanner.nextInt();

        while (valor <= 0) {
            System.out.println("Debe ser un entero positivo.");
            System.out.print(mensaje);
            valor = scanner.nextInt();
        }

        return valor;
    }

    /**
     * Resumen mostrado al final del programa
     */
    public static void mostrarResumen() {

        System.out.println();
        System.out.println("================================");
        System.out.println("         RESUMEN DEL DIA        ");
        System.out.println("================================");

        System.out.println();
        System.out.println("Usuario: " + nombreUsuario);
        System.out.println("Vehículos registrados: " + totalVehiculos);
        System.out.println("Horas registradas: " + totalHorasRegistradas);
        System.out.println("Cálculos de tarifa: " + totalCalculosTarifa);
        System.out.println("Importe total calculado: " + importeTotalCalculado);
        return;
    }

}
