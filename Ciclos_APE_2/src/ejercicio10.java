import java.util.Scanner;

public class ejercicio10 {
public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa el número: ");
        int numero = scanner.nextInt();
        System.out.print("Ingresa la base: ");
        int base = scanner.nextInt();
        boolean pertenece = true;
        int digito;
        int numOriginal = numero; // Guardamos el número original para mostrarlo después
        do {
            digito = numero % 10; // Tomar el último dígito
            if (digito >= base) {
                pertenece = false;
                break;
            }
            numero = numero / 10; // Eliminar el último dígito
        } while (numero > 0);
        if (pertenece) {
            System.out.println("El número " + numOriginal + " pertenece a la base " + base + ".");
        } else {
            System.out.println("El número " + numOriginal + " NO pertenece a la base " + base + ".");
        }
}
}
