import java.util.Scanner;

public class ejercicio8  {
    public static int invertirNumero(int numero) {
        int numeroInvertido = 0;
        while (numero != 0) {
            int digito = numero % 10;
            numeroInvertido = numeroInvertido * 10 + digito;
            numero /= 10;
        }
        return numeroInvertido;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese un número entero: ");
        int numero = scanner.nextInt();
        int numeroInvertido = invertirNumero(numero);
        System.out.println("El número invertido es: " + numeroInvertido);
    }
}