import java.util.Scanner;

public class ejercicio7 {

     public static boolean esPalindromo(String palabra) {
        String palabraProcesada = palabra.toLowerCase();
        String palabraInvertida = new StringBuilder(palabraProcesada).reverse().toString();
        return palabraProcesada.equals(palabraInvertida);
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String opcion;
        do {
            System.out.print("Ingrese una palabra: ");
            String palabra = teclado.nextLine();
            if (esPalindromo(palabra)) {
                System.out.println("La palabra \"" + palabra + "\" es un palíndromo.");
            } else {
                System.out.println("La palabra \"" + palabra + "\" no es un palíndromo.");
            }
            System.out.print("¿Desea verificar otra palabra? (s/n): ");
            opcion = teclado.nextLine().trim().toLowerCase();
        } while (opcion.equals("s"));

        System.out.println("Programa finalizado.");
    }
}
