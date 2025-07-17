import java.util.Scanner;

public class ejercicio5 {
public static void main(String[] args) {
      Scanner teclado = new Scanner(System.in);
      System.out.println("Ingre el valor uno");
      int num1=teclado.nextInt();
      System.out.println("Ingre el valor dos");
      int num2=teclado.nextInt();
    if (num1 != 0 && num2 % num1 == 0) {
        System.out.println(num1 + " es divisor de " + num2);
    } else if (num2 != 0 && num1 % num2 == 0) {
        System.out.println(num2 + " es divisor de " + num1);
    } else {
        System.out.println("Ninguno es divisor del otro.");
    }

}
}
