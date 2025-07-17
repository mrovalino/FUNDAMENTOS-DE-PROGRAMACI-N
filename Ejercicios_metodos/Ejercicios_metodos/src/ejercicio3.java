import java.util.Scanner;

public class ejercicio3 {

    public static void calcularPromedios(int inicio, int fin) {
        int sumaTotal = 0, sumaPares = 0, sumaImpares = 0, sumaPrimos = 0;
        int conteoTotal = 0, conteoPares = 0, conteoImpares = 0, conteoPrimos = 0;

        for (int i = inicio; i <= fin; i++) {
            sumaTotal += i;
            conteoTotal++;
            if (i % 2 == 0) {
                sumaPares += i;
                conteoPares++;
            } else {
                sumaImpares += i;
                conteoImpares++;
            }

            if (esPrimo(i)) {
                sumaPrimos += i;
                conteoPrimos++;
            }
        }
        System.out.println("**********************");
        System.out.println("\n--- Resultados ---");
        System.out.println("**********************");
        System.out.printf("Promedio de todos los números: %.2f%n", (double) sumaTotal / conteoTotal);
        System.out.printf("Promedio de números pares: %.2f%n", conteoPares > 0 ? (double) sumaPares / conteoPares : 0);
        System.out.printf("Promedio de números impares: %.2f%n", conteoImpares > 0 ? (double) sumaImpares / conteoImpares : 0);
        System.out.printf("Promedio de números primos: %.2f%n", conteoPrimos > 0 ? (double) sumaPrimos / conteoPrimos : 0);
    }
    public static boolean esPrimo(int numero) {
        if (numero <= 1) return false;
        if (numero == 2) return true;
        if (numero % 2 == 0) return false;
        for (int i = 3; i <= Math.sqrt(numero); i += 2) {
            if (numero % i == 0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        boolean repetir;
        do {
            System.out.print("Ingrese el número inicial del rango: ");
            int inicio = teclado.nextInt();
            System.out.print("Ingrese el número final del rango: ");
            int fin = teclado.nextInt();
            if (inicio > fin) {
                System.out.println("El número inicial debe ser menor o igual al número final.");
            } else {
                calcularPromedios(inicio, fin);
            }
            System.out.print("¿Desea repetir el proceso? (si o no): ");
            String respuesta = teclado.next();
            repetir = respuesta.equalsIgnoreCase("si");
        } while (repetir);
              System.out.println("Programa finalizado.");
    }
}