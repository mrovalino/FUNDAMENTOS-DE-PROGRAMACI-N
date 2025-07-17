import java.util.Scanner;

public class Ejercicio7 {

    public static int ingresarMatriz(int[][] matriz, Scanner scanner, String nombre) {
        int suma = 0;
        System.out.println("\nIngrese los elementos de la matriz " + nombre + ":");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(nombre + "[" + i + "][" + j + "]: ");
                matriz[i][j] = scanner.nextInt();
                suma += matriz[i][j];
            }
        }
        return suma;
    }
    public static int[][] sumarMatrices(int[][] A, int[][] B) {
        int n = A.length;
        int[][] suma = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                suma[i][j] = A[i][j] + B[i][j];
            }
        }
        return suma;
    }
    public static int mostrarMatrizYMayor(int[][] matriz, String titulo) {
        int mayor = Integer.MIN_VALUE;
        System.out.println("\n" + titulo);
        for (int[] fila : matriz) {
            for (int valor : fila) {
                System.out.print(valor + "\t");
                if (valor > mayor) {
                    mayor = valor;
                }
            }
            System.out.println();
        }
        return mayor;
    }
    public static int[][] multiplicarMatrices(int[][] A, int[][] B) {
        int n = A.length;
        int[][] producto = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    producto[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return producto;
    }
    public static void mostrarMatriz(int[][] matriz, String titulo) {
        System.out.println("\n" + titulo);
        for (int[] fila : matriz) {
            for (int valor : fila) {
                System.out.print(valor + "\t");
            }
            System.out.println();
        }
    }
     public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Ingrese el tamaño n de las matrices (n x n): ");
        int n = teclado.nextInt();
        int[][] A = new int[n][n];
        int[][] B = new int[n][n];
        int sumaTotal = ingresarMatriz(A, teclado, "A");
        sumaTotal += ingresarMatriz(B, teclado, "B");
        int[][] suma = sumarMatrices(A, B);
        int mayorElemento = mostrarMatrizYMayor(suma, "Matriz Suma (A + B):");
        double promedio = (double) sumaTotal / (2 * n * n);
        System.out.printf("\nPromedio de todos los elementos de A y B: %.2f\n", promedio);
        int[][] producto = multiplicarMatrices(A, B);
        mostrarMatriz(producto, "Matriz Producto (A x B):");
        System.out.println("\nElemento mayor en la matriz suma: " + mayorElemento);
    }
}
