import java.util.Scanner;

public class ejercicio10 {
public static void main(String[] args) {
    Scanner teclado= new Scanner(System.in);
    System.out.print("Ingrese el primer número: ");
    double num1 = teclado.nextDouble();
    System.out.print("Ingrese el segundo número: ");
    double num2 = teclado.nextDouble();
    System.out.print("Ingrese la operación (+, -, *, /): ");
    char operacion = teclado.next().charAt(0);
    double resultado;
    boolean operacionValida = true;
    switch (operacion) {
        case '+':
            resultado = num1 + num2;
            break;
        case '-':
            resultado = num1 - num2;
            break;
        case '*':
            resultado = num1 * num2;
            break;
        case '/':
            if (num2 != 0) {
                resultado = num1 / num2;
            } else {
                System.out.println("Error: división por cero.");
                return;
            }
            break;
        default:
            System.out.println("Error: operación no válida.");
            operacionValida = false;
            resultado = 0; 
    }
    if (operacionValida) {
        System.out.println("Resultado: " + resultado);
    }
}
}
