package CLASE;

import java.util.Scanner;
/*
 * Ingresar nombre y edad de una persona 
 * mostrar datos cargados
 * imprimir un mensaje si es mayor de edad 
 */
public class PERSONA {
private String nombre;
private int edad;
private Scanner teclado;
public void IinicializarVariables(){
    teclado = new Scanner(System.in);
    System.out.println("Ingrese el nombre");
    nombre=teclado.next();
    System.out.println("Ingrese la edad");
    edad=teclado.nextInt();
}
    
public void imprimirInformacion(){
    System.out.println("Nombre: "+nombre);
    System.out.println("Edad: "+edad);

}
public void ImprimirSiEsMayorEdad(){
    if (edad>=18) {
        System.out.println(nombre +" es mayor de edad");
    }else{
        System.out.println(nombre+" No es mayor de edad");
    }
}
public static void main(String[] args) {
    //crear una instancia persona
    PERSONA persona_1 = new PERSONA();
    // leer los datos de la persona a traves de metoso inicializacion de variable
    persona_1.IinicializarVariables();
    //imprimir datos de las personas 
    persona_1.imprimirInformacion();
    //Imprimir si es mayor de edad 
    persona_1.ImprimirSiEsMayorEdad();
   
}
}
