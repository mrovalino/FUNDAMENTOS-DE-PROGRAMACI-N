import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int mayor, medio = 0, menor;
        Scanner teclado= new Scanner(System.in);
        System.out.println("Ingresa el primer valor");
        int num1= teclado.nextInt();
        System.out.println("Ingresa el primer valor");
        int num2= teclado.nextInt();
        System.out.println("Ingresa el primer valor");
        int num3= teclado.nextInt();
        if (num1>num2 && num1>num3) {
           mayor=num1;
           if (num2>num3) {
            medio=num2;
            menor=num3;
           }
           else
           {
            medio=num3;
            menor=num2;
           }
           if (num2>num1 && num2>num3) {
            mayor=num2;
            if (num1>num3) {
                medio=num1;
                menor=num3;
            }
            else
             {
                medio=num3;
                menor=num1;
            }
           } 
        }
        else
        mayor=num3;
        if (num1>num2) {
         medio=num1;
         menor=num2;
        }
        else
         {
         medio=num2;
         menor=num1;
        }
System.out.println("el nùmero del medio es "+ medio);
        }
    }

