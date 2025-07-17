package METODOS_2;

import java.util.Scanner;

import CLASE.operaciones;

public class RANGOS {
private Scanner teclado;
private int rangoinicial;
private int rangofinal;

public void Datos(){
    teclado = new Scanner(System.in);
    System.out.print("INGRESE EL RANGO INICIAL: ");
    rangoinicial=teclado.nextInt();
    System.out.print("INGRESE EL RANGO FINAL: ");
    rangofinal=teclado.nextInt();

}
public void Imprimirelementos(){
    for (int i = rangoinicial; i < rangofinal; i++) {
        System.out.print(i+ " - ");

    }
    System.out.println();
}
public int DevolverCantidad(){
    int contador=0;
    for (int i = rangoinicial; i <= rangofinal; i++) {
        contador++;

    }
    return contador;
}
public int DEVOLVERSUMATORIA(){
    int sumatoria=0;
    for (int i=rangoinicial; i <= rangofinal; i++) {
        sumatoria+=i;
    }
    return sumatoria;
}

public double DevolverPromedio(){
    double promedio=(double)DEVOLVERSUMATORIA()/DevolverCantidad();
return promedio;

}

public void Imprimirnumerospares(){
    OperacionesRango OperacionesRango=new OperacionesRango();
   int cantidad= OperacionesRango.Devolvercuantospares(rangoinicial, rangofinal);
    System.out.println("Numeros pares: "+cantidad);
}
public static void main(String[] args) {
    RANGOS objetoSecuencia1= new RANGOS(); 
    objetoSecuencia1.Datos();
    objetoSecuencia1.Imprimirelementos();

    int cantidad=objetoSecuencia1.DevolverCantidad();
    System.out.println("Cantidad de elementos: "+ cantidad);

    System.out.println("Sumatoria de los elementos "+ objetoSecuencia1.DEVOLVERSUMATORIA());

    System.out.println("Promedio de los elementos: "+ objetoSecuencia1.DevolverPromedio());

    objetoSecuencia1.Imprimirnumerospares();
}
}
