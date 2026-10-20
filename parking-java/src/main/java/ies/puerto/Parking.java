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
     * 
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
     * 
     * @param scanner
     * @param cantidad
     */
    public static void registrarVehiculos(Scanner scanner) {

        System.out.println();
        System.out.println("¿Cuántos vehículos quieres registrar?");
        cantidad = scanner.nextInt();
        while (!(cantidad > 0)) {
            System.out.println("Debe ser un entero positivo");
            System.out.println();
            System.out.println("¿Cuántos vehículos quieres registrar?");
            cantidad = scanner.nextInt();
        }

        for (int i = 1; i <= cantidad; i++) {
            System.out.println("Vehículo: " + i);
            System.out.print("Matrícula: ");
            String matricula = scanner.next();
            System.out.println("Matrícula registrada: " + matricula);

            System.out.print("Horas estacionado: ");
            int horas = scanner.nextInt();

            while (!(horas > 0)) {
                System.out.println("Las horas deben ser mayor a 0.");
                System.out.print("Horas estacionado: ");
                horas = scanner.nextInt();
            }

            totalVehiculos++;
            totalHorasRegistradas += horas;
        }

        System.out.println();
        System.out.println("Vehículos registrados en esta operación: " + cantidad);
    }

    public static void calcularTarifa(Scanner scanner) {

        System.out.println();
        System.out.println("Horas para calcular la tarifa: ");
        int horas = scanner.nextInt();

        while (!(horas > 0)) {
            System.out.println("Las horas deben ser mayores que 0");
            System.out.println();
            System.out.println("Horas para calcular la tarifa: ");
            horas = scanner.nextInt();
        }
        float importe = horas * tarifaHora;
        totalCalculosTarifa++;
        importeTotalCalculado += importe;

        System.out.println("Importe: " + importe + " EUR");
        return;
    }

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
