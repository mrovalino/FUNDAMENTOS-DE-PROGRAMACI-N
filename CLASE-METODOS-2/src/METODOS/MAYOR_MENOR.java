package METODOS;

import java.util.Scanner;

/*
 * INGRESAR 3 VALORES
 * IMPRIMI DATOS
 * DESPLEGAR CUAL ES EL MAYOR
 */
public class MAYOR_MENOR {

    public void CargarValores(){
        Scanner teclado= new Scanner(System.in);
        System.out.print("INGRESE EL PRIMER VALOR:");
        int valor1 = teclado.nextInt();
        System.out.print("INGRESE EL SEGUNDO VALOR:");
        int valor2 = teclado.nextInt();
        System.out.print("INGRESE EL TERCER VALOR:");
        int valor3 = teclado.nextInt();

        int mayor,menor;
        // que numero es mayor?
       mayor = CalcularNumeroMayor(valor1,valor2,valor3);
       System.out.println("el numero mayor es: "+mayor);
       menor=CalcularNumeroMenor(valor1,valor2 ,valor3 );
       System.out.println("el valor menor es: "+menor);
    }
    public int CalcularNumeroMayor(int v1,int v2, int v3){
        int numeromayor=0;
        if (v1>v2 && v1>v3) {
            numeromayor=v1;
        }else{
            if (v2>v3) {
                numeromayor=v2;
            }else{
                numeromayor=v3;
            }
        }
        return numeromayor;
    }
public int CalcularNumeroMenor(int v1,int v2, int v3){
    int numeromenor=0;
    if (v1<v2 && v1<v3) {
        numeromenor=v1;
    }else{
        if (v2<v3) {
            numeromenor=v2;
        }else{
            numeromenor=v3;
        }
    }
    return numeromenor;
}
    public static void main(String[] args) {
    MAYOR_MENOR mayomenor=new MAYOR_MENOR();
    mayomenor.CargarValores();
}
}