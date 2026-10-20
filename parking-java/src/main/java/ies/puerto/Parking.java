package ies.puerto;

import java.util.Scanner;

public class Parking {

    static String nombreUsuario;
    static int opcion = 0;
    double tarifaHora = 1.50;
    int totalVehiculos = 0;
    float totalHorasRegistradas = 0;
    float totalCalculosTarifa = 0;
    float importeTotalCalculado = 0;

    static void main() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Indique su nombre: ");
        nombreUsuario = scanner.nextLine();

        do {
            mostrarMenu();

            System.out.println("Elija una opcion: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;

                default:
                    break;
            }
        } while (opcion != 4);

    }

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
}
