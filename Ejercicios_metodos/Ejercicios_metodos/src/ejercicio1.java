
import java.util.Scanner;

public class ejercicio1 {

     public static long calcularFactorial(int num) {
        long factorial = 1;
        for (int i = 2; i <= num; i++) {
            factorial *= i;
        }
        return factorial;
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int num;
        do {
            System.out.print("Introduce un número entero >= 0: ");
            num = teclado.nextInt();
        } while (num < 0);
        long resultado = calcularFactorial(num);
        System.out.printf("%d! = %d%n", num, resultado);
    }

}
