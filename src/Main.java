import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConsumoApi consumoApi = new ConsumoApi();

        try {
            while (true) {
                String menu = """
*******************************************
  Sea bienvenido/a al Conversor de Moneda 
*******************************************

1) Dólar => Peso argentino
2) Peso argentino => Dólar
3) Dólar => Real brasileño
4) Real brasileño => Dólar
5) Dólar => Peso colombiano
6) Peso colombiano => Dólar
7) Salir

*******************************************
""";

                System.out.println(menu);

                // Manejo de la opción del menú con excepciones
                int opcion = obtenerOpcionValida(scanner);

                if (opcion == 7) {
                    System.out.println("Gracias por usar el conversor de monedas.");
                    break;
                }

                // Manejo de la cantidad a convertir con excepciones
                double valorAconvertir = obtenerValorAConvertir(scanner);

                String monedaBase = "";
                String monedaDestino = "";

                // Determinamos la moneda base y destino según la opción seleccionada
                switch (opcion) {
                    case 1 -> {
                        monedaBase = "USD";
                        monedaDestino = "ARS";
                    }
                    case 2 -> {
                        monedaBase = "ARS";
                        monedaDestino = "USD";
                    }
                    case 3 -> {
                        monedaBase = "USD";
                        monedaDestino = "BRL";
                    }
                    case 4 -> {
                        monedaBase = "BRL";
                        monedaDestino = "USD";
                    }
                    case 5 -> {
                        monedaBase = "USD";
                        monedaDestino = "COP";
                    }
                    case 6 -> {
                        monedaBase = "COP";
                        monedaDestino = "USD";
                    }
                    default -> System.out.println("Opción no válida. Intente nuevamente.");
                }

                try {
                    // Obtiene la tasa de conversión desde la API
                    double tasaDeConversion = consumoApi.getExchangeRate(monedaBase, monedaDestino);
                    double resultadoDeLaConversion = tasaDeConversion * valorAconvertir;

                    // Imprime los resultados
                    System.out.printf("Tasa de cambio: 1 %s = %.2f %s\n", monedaBase, tasaDeConversion, monedaDestino);
                    System.out.printf("Cantidad convertida: %.2f %s\n", resultadoDeLaConversion, monedaDestino);
                } catch (Exception e) {
                    System.out.println("Error al obtener la tasa de conversión: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            System.out.println("¡Ocurrió un error inesperado! Detalles: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
    // Método para obtener la opción válida del menú
    private static int obtenerOpcionValida(Scanner scanner) {
        int opcion = -1;
        while (opcion < 1 || opcion > 7) {
            try {
                System.out.print("Elija una opción: ");
                opcion = Integer.parseInt(scanner.nextLine()); // Intentar parsear la opción
                if (opcion < 1 || opcion > 7) {
                    System.out.println("¡Error! Por favor ingrese un número válido entre 1 y 7.");
                }
            } catch (NumberFormatException e) {
                System.out.println("¡Error! Por favor ingrese un número válido.");
            }
        }
        return opcion;
    }


    // Método para obtener un valor de conversión válido
    private static double obtenerValorAConvertir(Scanner scanner) {
        double valorAconvertir = -1;
        while (valorAconvertir <= 0) {
            try {
                System.out.print("Ingrese la cantidad a convertir: ");
                valorAconvertir = Double.parseDouble(scanner.nextLine()); // Intentar parsear el valor
                if (valorAconvertir <= 0) {
                    System.out.println("El valor debe ser mayor que cero. Intente nuevamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("¡Error! Por favor ingrese un número válido.");
            }
        }
        return valorAconvertir;
    }
}