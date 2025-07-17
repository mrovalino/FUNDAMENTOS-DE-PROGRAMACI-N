import java.util.Scanner;

public class ejercicio8 {
public static void main(String[] args) {
    Scanner teclado=new Scanner(System.in);
      System.out.println("Ingresa el primer número: ");
      int num1 = teclado.nextInt();
      System.out.println("Ingresa el segundo número: ");
      int num2 = teclado.nextInt();
      System.out.println("Ingresa el tercer número: ");
      int num3 = teclado.nextInt();
      if ((num1 <= num2 && num2 <= num3) || (num1 >= num2 && num2 >= num3)) {
          System.out.println("Los números están en orden numérico.");
      } else {
          System.out.println("Los números NO están en orden numérico.");
      }
}
}
