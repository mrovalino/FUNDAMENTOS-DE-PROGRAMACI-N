import java.util.Scanner;
//DIEGO GARCIA 24/04/2025
public class EJERCICIO_EN_CLASE {
public static void main(String[] args) {
    Scanner teclado=new Scanner(System.in);
   int ri=0,rf=0,contadordeprimos=0,sumatoriaprimos=0;
   double promedio;
    System.out.println("Ingrese el rango inicial");
    ri=teclado.nextInt();
    System.out.println("Ingrese el rango Final");
    rf=teclado.nextInt();

    for (int i =ri; i <=rf; i++) {

    boolean bEsprimo=true;

    for (int f = 2; f <i; f++) {
        if (i % f==0) {
            bEsprimo=false;
        }
   }
   if (bEsprimo==true) {
   // System.out.println(i+ " Es primo");
    contadordeprimos+=1;
    sumatoriaprimos=sumatoriaprimos+i;
   }
    }
 if (contadordeprimos!=0) {
    promedio= sumatoriaprimos/contadordeprimos;
    System.out.println("Numeros de primos encontrados = "+contadordeprimos);
    System.out.println("Numeros de primos encontrados = "+promedio);
 }else{
    System.out.println("No se encontraron numeros primos en este rango");
 }
}
}
