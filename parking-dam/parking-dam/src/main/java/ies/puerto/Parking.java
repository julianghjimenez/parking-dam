package ies.puerto;

import java.util.Scanner;

/**
 * @author JulianGabrielHernandezJimenez
 * @version tarea-04
 */

public class Parking {

    private static final float TARIFA_HORA = 1.50f;

    /**
     * Coordina la ejecucion del programa de aparcamiento.
     *
     * @param args argumentos de la linea de comandos
     */
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        int opcion;
        int totalVehiculos = 0;
        int totalHorasRegistradas = 0;
        int totalCalculosTarifa = 0;
        float importeTotalCalculado = 0f;

        System.out.println("====================================");
        System.out.println("          PARKING DAM-PRO           ");
        System.out.println("====================================");
        System.out.println();

        System.out.print("Introduce tu nombre: ");
        String nombreUsuario = teclado.nextLine();

        do {
            mostrarMenu();

            opcion = leerEnteroPositivo(teclado, "Selecciona una opcion: ");

            switch (opcion) {

                case 1:
                    System.out.println();
                    System.out.println("====================================");
                    System.out.println("       REGISTRO DE VEHICULOS        ");
                    System.out.println("====================================");

                    int cantidad = leerEnteroPositivo(
                            teclado,
                            "Cuantos vehiculos deseas registrar: "
                    );

                    int horasOperacion = registrarVehiculos(teclado, cantidad);

                    totalVehiculos += cantidad;
                    totalHorasRegistradas += horasOperacion;

                    System.out.println();
                    System.out.println("Registro completado correctamente.");
                    System.out.println("Vehiculos registrados: " + cantidad);
                    System.out.println("Horas registradas: " + horasOperacion);
                    System.out.println();

                    break;

                case 2:
                    System.out.println();
                    System.out.println("====================================");
                    System.out.println("          CALCULAR TARIFA           ");
                    System.out.println("====================================");

                    int horas = leerEnteroPositivo(
                            teclado,
                            "Introduce las horas de estacionamiento: "
                    );

                    float importe = calcularTarifa(horas, TARIFA_HORA);

                    totalCalculosTarifa++;
                    importeTotalCalculado += importe;

                    System.out.printf("Tarifa por hora: %.2f euros%n", TARIFA_HORA);
                    System.out.printf("Importe total: %.2f euros%n", importe);
                    System.out.println();

                    break;

                case 3:
                    mostrarResumen(
                            nombreUsuario,
                            totalVehiculos,
                            totalHorasRegistradas,
                            totalCalculosTarifa,
                            importeTotalCalculado
                    );

                    break;

                case 4:
                    System.out.println();
                    System.out.println("====================================");
                    System.out.println("Gracias por utilizar PARKING DAM-PRO");
                    System.out.println("Hasta pronto, " + nombreUsuario + ".");
                    System.out.println("====================================");

                    break;

                default:
                    System.out.println();
                    System.out.println("Opcion no valida. Intentalo de nuevo.");
                    System.out.println();

                    break;
            }

        } while (opcion != 4);

        teclado.close();
    }

    /**
     * Muestra las opciones disponibles del menu principal.
     */
    public static void mostrarMenu() {
        System.out.println("====================================");
        System.out.println("             MENU PRINCIPAL         ");
        System.out.println("====================================");
        System.out.println("1. Registrar vehiculos");
        System.out.println("2. Calcular tarifa");
        System.out.println("3. Mostrar resumen");
        System.out.println("4. Salir");
        System.out.println("====================================");
    }

    /**
     * Solicita y valida un numero entero positivo.
     *
     * @param teclado lector para obtener datos del usuario
     * @param mensaje texto mostrado al solicitar el dato
     * @return numero entero positivo validado
     */
    public static int leerEnteroPositivo(Scanner teclado, String mensaje) {
        int numero;

        System.out.print(mensaje);
        numero = teclado.nextInt();

        while (numero <= 0) {
            System.out.println("Error: debes introducir un numero mayor que cero.");
            System.out.print(mensaje);
            numero = teclado.nextInt();
        }

        return numero;
    }

    /**
     * Registra una cantidad determinada de vehiculos y suma sus horas.
     *
     * Solicita la matricula y las horas de estacionamiento de cada vehiculo.
     * Devuelve las horas registradas para que main actualice los acumuladores.
     *
     * @param teclado lector para obtener datos del usuario
     * @param cantidad numero de vehiculos que se van a registrar
     * @return total de horas registradas en esta operacion
     */
    public static int registrarVehiculos(Scanner teclado, int cantidad) {
        int totalHorasOperacion = 0;

        for (int i = 1; i <= cantidad; i++) {
            System.out.println();
            System.out.println("Vehiculo " + i + " de " + cantidad);

            System.out.print("Introduce la matricula: ");
            String matricula = teclado.next();

            int horas = leerEnteroPositivo(
                    teclado,
                    "Introduce las horas de estacionamiento: "
            );

            totalHorasOperacion += horas;

            System.out.println("Vehiculo registrado: " + matricula);
            System.out.println("Horas registradas: " + horas);
        }

        return totalHorasOperacion;
    }

    /**
     * Calcula el importe total de un estacionamiento.
     *
     * Multiplica el numero de horas por el precio de una hora.
     *
     * @param horas numero de horas de estacionamiento
     * @param tarifaHora precio por cada hora de estacionamiento
     * @return importe total calculado
     */
    public static float calcularTarifa(int horas, float tarifaHora) {
        return horas * tarifaHora;
    }

    /**
     * Muestra el resumen de las operaciones realizadas durante la sesion.
     *
     * @param nombreUsuario nombre del usuario
     * @param totalVehiculos numero total de vehiculos registrados
     * @param totalHorasRegistradas numero total de horas registradas
     * @param totalCalculosTarifa numero de calculos de tarifa realizados
     * @param importeTotalCalculado suma de los importes calculados
     */
    public static void mostrarResumen(
            String nombreUsuario,
            int totalVehiculos,
            int totalHorasRegistradas,
            int totalCalculosTarifa,
            float importeTotalCalculado) {

        System.out.println();
        System.out.println("====================================");
        System.out.println("          RESUMEN DEL PARKING       ");
        System.out.println("====================================");
        System.out.println();

        System.out.println("Usuario: " + nombreUsuario);
        System.out.println("Total de vehiculos registrados: " + totalVehiculos);
        System.out.println("Total de horas registradas: " + totalHorasRegistradas);
        System.out.println("Calculos de tarifa realizados: " + totalCalculosTarifa);
        System.out.printf("Importe total calculado: %.2f euros%n", importeTotalCalculado);

        System.out.println();
        System.out.println("====================================");
        System.out.println();
    }
}