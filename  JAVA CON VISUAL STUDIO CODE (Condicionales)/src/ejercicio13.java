import java.util.Random;
import java.util.Scanner;

public class ejercicio13 {
public static void main(String[] args) {
   Random random = new Random();
Scanner teclado=new Scanner(System.in);
        int puntosUsuario = 0;
        int puntosComputadora = 0;
        int ronda = 1;

        System.out.println("¡Bienvenido a Piedra, Papel o Tijeras! Mejor de 3 rondas.");

        while (puntosUsuario < 2 && puntosComputadora < 2) {
            System.out.println("\n--- Ronda " + ronda + " ---");
            System.out.println("Elige piedra, papel o tijeras: ");
            String usuario = teclado.next().toLowerCase();
            if (!usuario.equals("piedra") && !usuario.equals("papel") && !usuario.equals("tijeras")) {
                System.out.println("Entrada inválida. Intenta de nuevo.");
                continue;
            }
            int eleccionComputadora = random.nextInt(3);
            String computadora = "";
            if (eleccionComputadora == 0) {
                computadora = "piedra";
            } else if (eleccionComputadora == 1) {
                computadora = "papel";
            } else {
                computadora = "tijeras";
            }
            System.out.println("La computadora eligió: " + computadora);
            if (usuario.equals(computadora)) {
                System.out.println("¡Empate!");
            } else if (
                (usuario.equals("piedra") && computadora.equals("tijeras")) ||
                (usuario.equals("papel") && computadora.equals("piedra")) ||
                (usuario.equals("tijeras") && computadora.equals("papel"))
            ) {
                System.out.println("¡Ganaste esta ronda!");
                puntosUsuario++;
            } else {
                System.out.println("La computadora gana esta ronda.");
                puntosComputadora++;
            }
            System.out.println("Marcador -> Tú: " + puntosUsuario + " | Computadora: " + puntosComputadora);
            ronda++;
        }
        if (puntosUsuario == 2) {
            System.out.println("\n🎉 ¡Felicidades! Ganaste el juego.");
        } else {
            System.out.println("\n💻 La computadora ganó el juego. ¡Suerte la próxima!");
        }
}
}
