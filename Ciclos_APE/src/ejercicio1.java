import java.util.Scanner;

public class ejercicio1 {
    public static void main(String[] args) throws Exception {;
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingresa el primer número: ");
        int inicio = teclado.nextInt();
        System.out.println("Ingresa el segundo número: ");
        int fin = teclado.nextInt();
        if (inicio > fin) {
            int temp = inicio;
            inicio = fin;
            fin = temp;
        }
        int contador = 0;
        int numero = inicio;
        while (numero <= fin) {
            contador++;
            numero++;
        }
        System.out.println("La cantidad de números enteros en el rango es: " + contador);
    }
}
