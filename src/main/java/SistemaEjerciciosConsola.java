import java.util.Scanner;

public class SistemaEjerciciosConsola {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenuPrincipal();
            opcion = leerEnteroSeguro("Seleccione una opción (1-4): ");

            switch (opcion) {
                case 1:
                    ejecutarCalculadora();
                    break;
                case 2:
                    ejecutarRegistroCalificaciones();
                    break;
                case 3:
                    ejecutarControlCompras();
                    break;
                case 4:
                    System.out.println("\nSaliendo del sistema. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("\n[Error] Opción no válida. Intente entre 1 y 4.\n");
            }
        } while (opcion != 4);

        scanner.close();
    }

    private static void mostrarMenuPrincipal() {
        System.out.println("     Sistema de ejercicio    ");
        System.out.println("1. Calculadora con menú");
        System.out.println("2. Registro de calificaciones");
        System.out.println("3. Control de compras");
        System.out.println("4. Salir");
    }

    // Ejercicio 1:
    public static void ejecutarCalculadora() {
        int opcionCalc;
        do {
            System.out.println("\n 1. Calculadora con menu");
            System.out.println("1. Sumar");
            System.out.println("2. Restar");
            System.out.println("3. Multiplicar");
            System.out.println("4. Dividir");
            System.out.println("5. Volver al menú principal");

            opcionCalc = leerEnteroSeguro("Elija una operación (1-5): ");

            if (opcionCalc >= 1 && opcionCalc <= 4) {
                double num1 = leerDoubleSeguro("Ingrese el primer número: ");
                double num2 = leerDoubleSeguro("Ingrese el segundo número: ");

                procesarCalculo(opcionCalc, num1, num2);
            } else if (opcionCalc != 5) {
                System.out.println("[Error] Opción de calculadora inválida.");
            }
        } while (opcionCalc != 5);
    }

    private static void procesarCalculo(int operacion, double a, double b) {
        switch (operacion) {
            case 1:
                System.out.printf("Resultado: %.2f + %.2f = %.2f\n", a, b, (a + b));
                break;
            case 2:
                System.out.printf("Resultado: %.2f - %.2f = %.2f\n", a, b, (a - b));
                break;
            case 3:
                System.out.printf("Resultado: %.2f * %.2f = %.2f\n", a, b, (a * b));
                break;
            case 4:
                if (b == 0) {
                    System.out.println("[Error de validación] No es posible dividir entre cero.");
                } else {
                    System.out.printf("Resultado: %.2f / %.2f = %.2f\n", a, b, (a / b));
                }
                break;
        }
    }

    // Ejercicio 2:
    public static void ejecutarRegistroCalificaciones() {
        System.out.println("\n 2. Registro de calificaciones (0 a 10)");
        System.out.println("Ingrese notas válidas. Escriba -1 para finalizar y ver resultados.\n");

        int cantidadNotas = 0;
        double sumaNotas = 0;
        double nota;

        while (true) {
            nota = leerDoubleSeguro("Ingrese nota (-1 para terminar): ");

            if (nota == -1) {
                break;
            }

            if (nota >= 0 && nota <= 10) {
                cantidadNotas++;
                sumaNotas += nota;
            } else {
                System.out.println("[Advertencia] Nota fuera de rango. Debe estar entre 0 y 10.");
            }
        }

        System.out.println("\nReporte de calificaciones");
        if (cantidadNotas == 0) {
            System.out.println("No se registraron notas válidas (caso sin registros).");
        } else {
            double promedio = sumaNotas / cantidadNotas;
            System.out.println("Cantidad de notas válidas: " + cantidadNotas);
            System.out.printf("Promedio de calificaciones: %.2f\n", promedio);
        }
    }

    // Ejercicio 3:
    public static void ejecutarControlCompras() {
        System.out.println("\n 3. Control de compras");
        System.out.println("Ingrese precios mayores a 0. Escriba 0 para finalizar y ver el total.\n");

        int cantidadProductos = 0;
        double totalCompra = 0;
        double precio;

        while (true) {
            precio = leerDoubleSeguro("Ingrese precio del producto (0 para terminar): ");

            if (precio == 0) {
                break;
            }

            if (precio > 0) {
                cantidadProductos++;
                totalCompra += precio;
            } else {
                System.out.println("[Advertencia] El precio debe ser un valor positivo mayor a 0.");
            }
        }

        System.out.println("\nReporte de compras");
        if (cantidadProductos == 0) {
            System.out.println("No se registraron productos (caso sin registros / compra vacía).");
        } else {
            double promedioPrecio = totalCompra / cantidadProductos;
            System.out.println("Cantidad total de productos: " + cantidadProductos);
            System.out.printf("Costo total acumulado: $%.2f\n", totalCompra);
            System.out.printf("Promedio por producto: $%.2f\n", promedioPrecio);
        }
    }

    //metodos auxiliares de validacion y entrada
    private static int leerEnteroSeguro(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = scanner.nextLine();
            try {
                return Integer.parseInt(entrada.trim());
            } catch (NumberFormatException e) {
                System.out.println("[Error] Entrada no numérica. Por favor, ingrese un número entero válido.");
            }
        }
    }

    private static double leerDoubleSeguro(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = scanner.nextLine();
            try {
                return Double.parseDouble(entrada.trim());
            } catch (NumberFormatException e) {
                System.out.println("[Error] Entrada no numérica. Por favor, ingrese un número válido.");
            }
        }
    }
}
