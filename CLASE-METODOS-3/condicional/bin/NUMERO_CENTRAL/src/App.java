import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        float num1,num2,num3;
        Scanner teclado= new Scanner(System.in);
        System.out.println("INGRESE EL PRIMER NÚMERO");
        num1 = teclado.nextFloat();
        System.out.println("INGRESE EL SEGUNDO NÚMERO");
        num2 = teclado.nextFloat();
        System.out.println("INGRESE EL TERCER NÚMERO");
        num3 = teclado.nextFloat();
        if (num1>num2 && num1>num3) {
       if (num2>num3) {
        System.out.println("EL NÚMERO DEL MEDIO ES "+num2);
       }else{
        
       }

        }
    }
}
