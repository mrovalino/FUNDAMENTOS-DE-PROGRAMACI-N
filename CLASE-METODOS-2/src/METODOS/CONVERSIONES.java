package METODOS;

import java.util.Scanner;

public class CONVERSIONES {
    private double num1,num2,celcius,farenheit;
    private Scanner teclado;
public void InicializarVariables(){
    Scanner teclado = new Scanner(System.in);
System.out.print("Ingrese los grados celcius: ");
num1=teclado.nextDouble();
System.out.print("Ingrese los grados farenheit: ");
num2=teclado.nextDouble();
}
public void Celci(){
celcius=(num2-32)/1.8;
System.out.println("Los grados en celcius son: "+ celcius);
}
public void faren(){
    farenheit=(num1*1.8)+32;
    System.out.println("Los grados en farenheit son : "+farenheit);
}
public static void main(String[] args) {
CONVERSIONES inicio =new CONVERSIONES();

inicio.InicializarVariables();
inicio.Celci();
inicio.faren();
}
}
