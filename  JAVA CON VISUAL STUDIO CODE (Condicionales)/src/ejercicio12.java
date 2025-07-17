import java.util.Scanner;

public class ejercicio12 {
public static void main(String[] args) {
    Scanner teclado=new Scanner(System.in);
    String tri;
    System.out.println("Defina el valor del primer lado :");
    float lado1=teclado.nextFloat();
    System.out.println("Defina el valor del segundo lado :");
    float lado2=teclado.nextFloat();
    System.out.println("Defina el valor del tercer lado :");
    float lado3=teclado.nextFloat();
    if (lado1==lado2 && lado1==lado3) {
       tri="Equilátero";
      System.out.println("el triangulo es :"+tri);
    }
    else
     if (lado1==lado2 ||  lado1==lado3) {
       tri="sósceles";
      System.out.println("el triangulo es :"+tri);
    }
    else
      if (lado1!= lado2 && lado1!=lado3 && lado2!=lado3) {
       System.out.println("Ninguno de los lados son iguales");
      }
    }
}
