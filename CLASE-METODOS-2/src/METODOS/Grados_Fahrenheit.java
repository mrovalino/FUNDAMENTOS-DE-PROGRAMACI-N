package METODOS;

import java.util.Scanner;

public class Grados_Fahrenheit {
public double grados,fahrenheit;
public void Cargar_Valores(){
    Scanner teclado = new Scanner (System.in);
    System.out.println("Ingrese el valor segun la conversion ha realizar");
    System.out.println("1. Conversion de Celcius a Faherenheint");
    System.out.println("2. Conversion de Faherenheint a Celcius ");
    int tipoconv=teclado.nextInt();
    switch (tipoconv) {
        case 1:
        double concelcius;
        System.out.println("ingrese el valor de celcius");
        double celcius=teclado.nextDouble();
        concelcius=Conversion_Faherenheit_Celcius(celcius);
        System.out.println("El resultado de feherenheint a celcius es:" + concelcius);
            break;
        case 2:
            double confaheren;
            System.out.println("Ingrese el valor de faherenheint");
            double faherenheint=teclado.nextDouble();
            confaheren=Conversion_celcius_Faherenheit(faherenheint);
            System.out.println("El resultado de Celcius a feherenheint es:" + confaheren);
            break;
        default:
            break;
    }
}
public double Conversion_celcius_Faherenheit(double cel){
    double confa=0;
    confa=(cel*9/5)+32;
    return confa;
}
public double Conversion_Faherenheit_Celcius(double fah){
    double concel=0;
    concel=(fah-32)/1.8;
    return concel;
}
public static void main(String[] args) {
    Grados_Fahrenheit gradosfaherenheit = new Grados_Fahrenheit();
     gradosfaherenheit.Cargar_Valores();
}
}
