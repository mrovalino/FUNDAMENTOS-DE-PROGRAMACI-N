import java.util.Scanner;

public class ejercicio2 {
    
        public static void main(String[] args) {
            Scanner teclado= new Scanner(System.in);
            System.out.println("Ingrese el valor a determinar");
            int valor=teclado.nextInt();
        if (valor>1) {
            System.out.println("EL valor elevdo al cuadradoes :"+Math.sqrt(valor));
        }
        else
        {
        System.out.println("No existe raiz negativa");
        }
        }
    }
