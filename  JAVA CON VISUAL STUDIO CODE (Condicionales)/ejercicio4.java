import java.util.Scanner;

public class ejercicio4 {
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        System.out.println("Ingrese el DÍA");
        int dia=teclado.nextInt();
        System.out.println("Ingrese el MES");
        int mes=teclado.nextInt();
        System.out.println("Ingrese el AÑO");
        int año=teclado.nextInt();
        int mes1=0;
        int dia1=0;
        int año1=0;
        switch (mes) {
            case 1,3,5,7,8,10,12:
                mes1=31;
                break;
            case 4,6,9,11:
                mes1=30;
                break;
            case 2:
            if ((año % 4 == 0 && año % 100 != 0) || (año % 400 == 0)) {
                mes1=29;
            } else {
                mes1=28;
            } 
            System.out.println("MES ingresado incorrectamente");
                break;
        }
        if (dia<mes1) {
            dia1=dia+1;
            System.out.println("La fecha del día siguiente es: "+dia1+" / "+mes+" / "+año);
        }
         else
         if (dia==mes1) {
            dia=dia1+1;
            mes1=mes+1;
            if (mes1==13) {
                año1=año+1;
                mes1=1;
                System.out.println("La fecha del día siguiente es: "+dia+" / "+mes1+" / "+año1);
            }
            else
            System.out.println("La fecha del día siguiente es: "+dia+" / "+mes1+" / "+año);
         }
    }
}
