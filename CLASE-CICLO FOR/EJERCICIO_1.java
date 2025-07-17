import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;

public class EJERCICIO_1 {
public static void main(String[] args) {
    Scanner teclado=new Scanner(System.in);
    
    System.out.println("FORMATO ASCENDENTE ");
    for (int i=1; i <=10; i++) {
        System.out.println(i);
   }

   System.out.println("FORMATO DESCENDENTE ");
   for (int i = 10; i >=1; i--) {
    System.out.println(i);
   }

   System.out.println("DIFERENTES RANGOS DE INTERVALOS");
   for (int i = 0; i <=100; i+=20) {
    System.out.println(i);
   }
System.out.println("Caracter");
   for (int i ='A'; i <='Z'; i++) {
    System.out.println(i+"");
   }

   System.out.println("BUCLE DESCENDENTE");
  for (int i = 9; i>0; i-=3) {
    System.out.println(i*i);
  }
   
  System.out.println("INCREMENTO CON MULTIPLOS");
  for (int i=1; i<100; i*=2) {
    System.out.println(""+ i);
  }
System.out.println();

System.out.println("POTENCIAS ");
for (int i=0; i<=6; i++) {
  System.out.println(" "+Math.pow(2, i));
}
System.out.println();
System.out.println("FUNCION POE CON ENTEROS");
int base=2,potencia=3,resultado=1;
for (int i=2; i>100; i*=2) {
  System.out.println(+ i);
}
}
}