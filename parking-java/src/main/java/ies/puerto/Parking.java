package ies.puerto;

import java.util.Scanner;


public class Parking {

    static String nombreUsuario;
    int opcion = 0;
    double tarifaHora = 1.50;
    int totalVehiculos = 0;
    float totalHorasRegistradas = 0;
    float totalCalculosTarifa = 0;
    float importeTotalCalculado = 0;

    static void main() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Indique su nombre: ");
        nombreUsuario = scanner.nextLine();

        System.out.println();
        System.out.println("================================");
        System.out.println("         Menú principal         ");
        System.out.println("================================");


    }
}
