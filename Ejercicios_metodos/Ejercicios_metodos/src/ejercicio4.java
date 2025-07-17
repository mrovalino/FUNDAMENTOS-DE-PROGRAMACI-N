
import java.text.Normalizer;
import java.util.Scanner;

public class ejercicio4 {

    public static int contarPalabras(String frase) {
        frase = frase.trim();
        if (frase.isEmpty()) {
            return 0;
        }
        String[] palabras = frase.split("\\s+");
        return palabras.length;
    }
    public static int contarLetras(String frase) {
        int contador = 0;
        for (int i = 0; i < frase.length(); i++) {
            char c = frase.charAt(i);
            if (Character.isLetter(c)) {
                contador++;
            }
        }
        return contador;
    }
    public static int contarVocales(String frase) {
        String fraseNormalizada = Normalizer.normalize(frase, Normalizer.Form.NFD)
                .replaceAll("[\\p{InCombiningDiacriticalMarks}]", "")
                .toLowerCase();
        int contador = 0;
        for (int i = 0; i < fraseNormalizada.length(); i++) {
            char c = fraseNormalizada.charAt(i);
            if ("aeiou".indexOf(c) != -1) {
                contador++;
            }
        }
        return contador;
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String opcion;
        do {
            System.out.print("Ingrese una frase: ");
            String frase = teclado.nextLine();

            int cantidadPalabras = contarPalabras(frase);
            int cantidadLetras = contarLetras(frase);
            int cantidadVocales = contarVocales(frase);

            System.out.println("\n--- Resultados ---");
            System.out.println("Cantidad de palabras: " + cantidadPalabras);
            System.out.println("Cantidad de letras: " + cantidadLetras);
            System.out.println("Cantidad de vocales: " + cantidadVocales);

            System.out.print("\n¿Desea analizar otra frase? (s/n): ");
            opcion = teclado.nextLine().trim().toLowerCase();
        } while (opcion.equals("s"));

        System.out.println("Programa finalizado.");
    }
}
