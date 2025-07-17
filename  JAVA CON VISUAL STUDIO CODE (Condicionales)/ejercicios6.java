import java.util.Scanner;

public class ejercicios6 {
public static void main(String[] args) {
    Scanner teclado=new Scanner(System.in);
    System.out.println("Ingrese la nota de 1 a 100");
    int nota=teclado.nextInt();
    String nota1;
    if (nota>=90) {
        nota1="A";
        System.out.println("Su nota es : "+nota1);
    }
    else
    if (nota>=80) {
        nota1="B";
        System.out.println("Su nota es : "+nota1);
    }
    else
    if (nota>=70) {
        nota1="C";
        System.out.println("Su nota es : "+nota1);
    }
    else
    if (nota>=69) {
        nota1="D";
        System.out.println("Su nota es : "+nota1);
    }
    else
    if (nota>0) {
        nota1="D";
        System.out.println("Su nota es : "+nota1);
    }
}
}
