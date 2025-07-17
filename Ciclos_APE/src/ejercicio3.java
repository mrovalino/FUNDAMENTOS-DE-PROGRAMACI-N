import java.util.Scanner;

public class ejercicio3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("");
                int numero = scanner.nextInt();
            
        int inverso = 0;
        int digito;
        while (numero != 0) {
            digito = numero % 10;          // Tomar el último dígito
            inverso = inverso * 10 + digito; // Agregar el dígito al inverso
            numero = numero / 10;            // Quitar el último dígito
        }

        System.out.println("El número invertido es: " + inverso);
    }


    }
  
