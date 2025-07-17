import java.util.Scanner;

public class ejercicio4 {
public static void main(String[] args) {
    Scanner teclado=new Scanner(System.in);
float numP,numR,total;
System.out.println("Ingrese el total de preguntas");
numP = teclado.nextFloat();
System.out.println("Ingrese el numero de respuestas correctas");
numR= teclado.nextFloat();
total=(100*numR)/numP;
if (total>=90){
    System.out.println("Nivel Óptimo");
}else{
        if (total>=75 & total<90){
System.out.println("Nivel Medio");
        }else{
    if (total>=50 & total<75) {
        System.out.println("Nivel Bajo");
    }else {
            if (total<50){
                System.out.println("fuera del nivel");
            }
        }
    }
}
        }
    }

