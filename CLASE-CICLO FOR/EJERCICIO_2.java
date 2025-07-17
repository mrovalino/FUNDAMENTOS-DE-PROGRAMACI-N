import java.util.Scanner;

public class EJERCICIO_2 {
public static void main(String[] args) {
    Scanner teclado=new Scanner(System.in);
    System.out.println("Tabla de multiplicar");
    int num,resultado;
    num=teclado.nextInt();
    for (int i = 1; i<=12 ; i++) {
        resultado=num*i;
        System.out.println(num+" x "+i+" "+" = "+resultado);
    }
}
}
