package CLASE;
/*
 * Solicitar los 3 lados del triangulo
 * visualizar los datos ingresado 
 * Immprimir el lado mas grande
 * Si el triangulo es equilatero
 */

import java.util.Scanner;

public class triangulo {
private int lado1,lado2,lado3;
private Scanner teclado;
public void Inicializar(){
teclado=new Scanner(System.in);
System.out.print("Ingrese el lado 1: ");
lado1=teclado.nextInt();
System.out.print("Ingrese el lado 2: ");
lado2=teclado.nextInt();
System.out.print("Ingrese el lado 3: ");
lado3=teclado.nextInt();
}
public void ImmprimirladosTriangulo(){
System.out.println("Lado1: "+ lado1);
System.out.println("Lado2: "+ lado2);
System.out.println("Lado3: "+ lado3);
}
public void ImprimirLadoMasGrande(){
    if (lado1>lado2 && lado1>lado3) {
        System.out.println(lado1);
    }else{
        if (lado2>lado3) {
            System.out.println(lado2);
        }else{
            System.out.println(lado3);
        }
    }
}
public void ValidarSiEsEquilatero(){
    if (lado1==lado2 && lado2==lado3) {
        System.out.println("El triangulo es equilatero");
    }else{
        System.out.println("El triangulo NO es equilatero");
    }
}

public void ValidarSiValorEsCorrecto(){
if (lado1<(lado2+lado3)) {
    System.out.println("El triangulo es correcto");
}else{
    if (lado2<(lado1+lado3)) {
        System.out.println("El triangulo es correcto");
    }else{
        if (lado3<(lado1+lado2)) {
            System.out.println("El triangulo es correcto");
        }
    }
}
}

public static void main(String[] args) {
triangulo triangulo_1=new triangulo();
triangulo_1.Inicializar();
triangulo_1.ImmprimirladosTriangulo();
triangulo_1.ImprimirLadoMasGrande();
triangulo_1.ValidarSiEsEquilatero();
triangulo_1.ValidarSiValorEsCorrecto();
}
}
