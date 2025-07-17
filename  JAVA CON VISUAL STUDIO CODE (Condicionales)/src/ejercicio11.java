import java.util.Scanner;

public class ejercicio11 {
public static void main(String[] args) {
    Scanner teclado=new Scanner(System.in);
    System.out.println("Ingrese el valor del monto");
    int valor=teclado.nextInt();
    int descuento;
    int total;
    int total1;
    if (valor>=100) {
        descuento=10;
        total=valor*descuento/100;
        total1=total-valor-total;
System.out.println("El valor final a paga es : "+total1);
    }
    else
    if (valor>=500) {
        descuento=20;
        total=descuento/100;
        total1=valor-total;
        System.out.println("El valor final a paga es : "+total1);
    }
}
}
