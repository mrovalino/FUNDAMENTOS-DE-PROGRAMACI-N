import java.util.Scanner;

public class Ejercicio1{
     public static void llenarMatriz(int[][] matriz, Scanner teclado) {
        System.out.println("Ingrese los valores para una matriz de 5x5:");
        for (int fila = 0; fila < 5; fila++) {
            for (int col = 0; col < 5; col++) {
                System.out.print("Ingrese el valor para la posición [" + fila + "][" + col + "]: ");
                matriz[fila][col] = teclado.nextInt();
            }
        }
    }
    public static void mostrarSumaFilas(int[][] matriz) {
        for (int fila = 0; fila < 5; fila++) {
            int sumaFila = 0;
            for (int col = 0; col < 5; col++) {
                sumaFila += matriz[fila][col];
            }
            System.out.println("Fila " + fila + ": " + sumaFila);
        }
    }
    public static void mostrarSumaColumnas(int[][] matriz) {
        for (int col = 0; col < 5; col++) {
            int sumaColumna = 0;
            for (int fila = 0; fila < 5; fila++) {
                sumaColumna += matriz[fila][col];
            }
            System.out.println("Columna " + col + ": " + sumaColumna);
        }
    }
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int[][] matriz = new int[5][5];
        llenarMatriz(matriz, teclado);
        System.out.println("\nSuma de cada fila:");
        mostrarSumaFilas(matriz);
        System.out.println("\nSuma de cada columna:");
        mostrarSumaColumnas(matriz);
    }
}
