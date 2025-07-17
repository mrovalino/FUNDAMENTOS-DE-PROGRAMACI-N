
import java.util.Scanner;

public class ejercicio7 {
    public static double obtenerRecargo(char tipoCliente) {
        tipoCliente = Character.toUpperCase(tipoCliente);
        if (tipoCliente == 'G') { 
            return 10.0;
        } else if (tipoCliente == 'A') { 
            return 5.0;
        } else {
            return 0.0; 
        }
    }
    public static double obtenerDescuento(char tipoCliente) {
        tipoCliente = Character.toUpperCase(tipoCliente);
        if (tipoCliente == 'G') { 
            return 15.0;
        } else if (tipoCliente == 'A') { 
            return 20.0;
        } else {
            return 0.0;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el tipo de cliente (G = General, A = Afiliado): ");
        char tipoCliente = scanner.next().charAt(0);
        System.out.print("Ingrese el tipo de pago (C = Contado, P = Plazos): ");
        char tipoPago = scanner.next().charAt(0);
        System.out.print("Ingrese el monto de la compra: ");
        double monto = scanner.nextDouble();
        double total = monto;
        double porcentaje;
        double ajuste;
        if (Character.toUpperCase(tipoPago) == 'C') {
            porcentaje = obtenerDescuento(tipoCliente);
            ajuste = monto * (porcentaje / 100.0);
            total -= ajuste;
            System.out.println("Descuento aplicado: " + ajuste);
        } else if (Character.toUpperCase(tipoPago) == 'P') {
            porcentaje = obtenerRecargo(tipoCliente);
            ajuste = monto * (porcentaje / 100.0);
            total += ajuste;
            System.out.println("Recargo aplicado: " + ajuste);
        } else {
            System.out.println("Tipo de pago no válido.");
            scanner.close();
            return;
        }
        System.out.println("Total a pagar: " + total);
    }
}