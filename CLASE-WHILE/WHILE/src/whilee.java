import java.util.Scanner;

public class whilee {
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        System.out.println("IMPRIMIR LOS 20 PRIMEROS NÚMEROS");
        int num=1; int sumatoria =0;
        System.out.println("HASTA QUE NUMERO");
        int numfin=teclado.nextInt();

        while (num<=numfin) {
            System.out.println(num);
            sumatoria=sumatoria+num;
            num=num+1;
        }
        System.out.println("LA SUMATORIA ES "+sumatoria);
    }
}
