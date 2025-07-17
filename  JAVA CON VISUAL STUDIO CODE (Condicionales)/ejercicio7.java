import java.util.Scanner;

public class ejercicio7 {
public static void main(String[] args) {
    Scanner teclado=new Scanner(System.in);
    System.out.print("Ingresa el primer número: ");
    double num1 = scanner.nextDouble();
    System.out.print("Ingresa el segundo número: ");
    double num2 = scanner.nextDouble();
    System.out.println("Selecciona la operación:");
    System.out.println("1 - Suma");
    System.out.println("2 - Resta");
    System.out.println("3 - Multiplicación");
    System.out.println("4 - División");
    System.out.print("Escribe el número de la operación: ");
    int seleccionOp = scanner.nextInt();
    switch (seleccionOp) {
        case 1:
            System.out.println("Resultado: " + (num1 + num2));
            break;
        case 2:
            System.out.println("Resultado: " + (num1 - num2));
            break;
        case 3:
            System.out.println("Resultado: " + (num1 * num2));
            break;
        case 4:
            if (num2 != 0) {
                System.out.println("Resultado: " + (num1 / num2));
            } else {
                System.out.println("Error: No se puede dividir por cero.");
            }
            break;
        default:
            System.out.println("Operación no válida.");
    }
}
}
