import java.util.Scanner;

public class ejercicio11 {
public static void main(String[] args) {
    int inicio, fin;

    System.out.print("Ingrese el inicio del rango: ");
    inicio = scanner.nextInt();
    System.out.print("Ingrese el fin del rango: ");
    fin = scanner.nextInt();

    int contadorPrimos = 0;
    int numero = inicio;

    do {
        if (esPrimo(numero)) {
            contadorPrimos++;
        }
        numero++;
    } while (numero <= fin);

    System.out.println("Entre " + inicio + " y " + fin + " hay " + contadorPrimos + " números primos.");
}

// Función para verificar si un número es primo
public static boolean esPrimo(int n) {
    if (n < 2) {
        return false;
    }
    int i = 2;
    while (i <= Math.sqrt(n)) {
        if (n % i == 0) {
            return false;
        }
        i++;
    }
    return true;
}
}
