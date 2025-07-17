import java.util.Scanner;

public class SENTENCIAS {
public static void main(String[] args) {
    Scanner teclado=new Scanner(System.in);
//sumatoria de numeros excepto mutiplos de 3
int rangoinicial=0,rangofinal=0,sumatoria=0;

System.out.print("Ingrese el rango inferior: ");
rangoinicial=teclado.nextInt();
System.out.print("Ingrese el rango Superior: ");
rangofinal=teclado.nextInt();

for (int i = rangoinicial; i <=rangofinal; i++) {
    //if (i%3!=0) {
   // sumatoria+=i;    
   // }
   if (i==7) {
   continue;
   }
   System.out.print(i+" ");
   //sumatoria+=i;
}
//System.out.println(sumatoria);
}
}
