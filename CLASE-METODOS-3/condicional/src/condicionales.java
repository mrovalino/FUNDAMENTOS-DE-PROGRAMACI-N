import java.util.Scanner;

public class condicionales {
public static void main(String[] args) {
    Scanner teclado = new Scanner(System.in);
float nota1,nota2,nota3,promedio;
    System.out.println("Ingrese la nota 1");
nota1=teclado.nextInt();
System.out.println("Ingrese la nota 2");
nota2=teclado.nextInt();
System.out.println("ingrese la nota 3 ");
nota3=teclado.nextInt();
promedio=(nota1+nota2+nota3)/3;
String promedio1=(promedio<7 & promedio>4)?"SUPLETORIO":(promedio>=7 & promedio<=4)?"APRUEVA":"REPRUEBA";
System.err.println(promedio1);
}
}
