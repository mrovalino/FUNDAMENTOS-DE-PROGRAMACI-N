import java.util.Scanner;

public class ejerciocio5;
public static void main(String[] args) {
    Scanner teclado= new Scanner(System.in);
  double x,y,total,modulo;
  System.out.println("Ingrese el valor de X");
  x=teclado.nextDouble();
  System.out.println("ingrese el valor de Y");
  y=teclado.nextDouble();
 total=Math.sqrt(modulo);
  if (x>0 && y>0){
    System.out.println("el cuadrante es I");
  }
  else{
    if (x<0 && y>0) {
        System.out.println("el cuadrante es II");
    }
    else{
        if (x<0 && y<0){
        System.out.println("el cuadrante es el III");
    }else{
        System.out.println("el cuadrante es el IV");
    }
  }
  System.out.println("la distancia es "+total);
}
}
