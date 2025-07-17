import java.util.Scanner;

public class ejerciciotres {
public static void main(String[] args) {
    Scanner teclado = new Scanner(System.in);
    System.out.println("Escriba el número a calcular");
    int numero=teclado.nextInt();
    if (numero % 2 == 0) {
        System.out.println("Es par");
    } else {
        System.out.println("Es impar");
    }
}
}
