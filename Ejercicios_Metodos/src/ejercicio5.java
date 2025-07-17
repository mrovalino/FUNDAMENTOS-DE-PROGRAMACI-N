import java.util.Scanner;

public class ejercicio5  {
    public static String clasificarCaracter(char c) {
        if (Character.isDigit(c)) {
            return "Número";
        } else if (Character.isLetter(c)) {
            if (esVocal(c)) {
                return "Vocal";
            } else if (Character.isUpperCase(c)) {
                return "Letra mayúscula";
            } else {
                return "Letra minúscula";
            }
        } else {
            return "Símbolo";
        }
    }
    public static boolean esVocal(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese un carácter: ");
        char caracter = scanner.next().charAt(0);
        String resultado = clasificarCaracter(caracter);
        System.out.println("El carácter ingresado es: " + resultado);
    }
}