import java.util.Scanner;

public class ejercicio9 {
public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa el primer número: ");
        int num1 = scanner.nextInt();
        System.out.print("Ingresa el segundo número: ");
        int num2 = scanner.nextInt();
        int sumaDiv1 = 0;
        int sumaDiv2 = 0;
        int i = 1;
        // Sumar divisores de num1
        do {
            if (num1 % i == 0) {
                sumaDiv1 += i;
            }
            i++;
        } while (i <= num1 / 2); // Solo necesitamos hasta la mitad del número
        i = 1; // Reiniciamos i para el segundo número
        // Sumar divisores de num2
        do {
            if (num2 % i == 0) {
                sumaDiv2 += i;
            }
            i++;
        } while (i <= num2 / 2);
        // Comprobamos si son amigos
        if (sumaDiv1 == num2 && sumaDiv2 == num1) {
            System.out.println(num1 + " y " + num2 + " son números amigos.");
        } else {
            System.out.println(num1 + " y " + num2 + " no son números amigos.");
        }
}
}
