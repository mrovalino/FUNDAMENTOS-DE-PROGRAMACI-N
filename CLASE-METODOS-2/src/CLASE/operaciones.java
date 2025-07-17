package CLASE;

import java.util.Scanner;

public class operaciones {
private int num1,num2;
private double suma,resta,multiplicacion,division;
private Scanner teclado;

public void IngresodeDatos(){
    teclado=new Scanner(System.in);
    System.out.print("Ingrese el primer numero: ");
    num1=teclado.nextInt();
    System.out.print("Ingrese el segundo numero: ");
    num2=teclado.nextInt();
}
public void sumar(){
    suma=num1+num2;
    System.out.println("La suma: "+suma);
}

public void resta(){
    resta=num1-num2;
    System.out.println("La resta: "+resta);
}
public void multiplicacion(){
    multiplicacion=num1*num2;
    System.out.println("La multiplicacion: "+multiplicacion);
}
public void division(){
    division=num1/num2;
    System.out.println("La division: "+division);
}
public void residuo(){
    double resultado=0;
    resultado=Math.pow(num1, num2);
    System.out.println(resultado);
}

public static void main(String[] args) {
    operaciones operaciones_1=new operaciones();
    operaciones_1.IngresodeDatos();
    operaciones_1.sumar();
    operaciones_1.resta();
    operaciones_1.multiplicacion();
    operaciones_1.division();
    operaciones_1.residuo();
}
}
