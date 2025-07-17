public class Ejercicio2{
  public static void llenarDiagonal(int[][] matriz) {
        for (int fila = 0; fila < matriz.length; fila++) {
            for (int col = 0; col < matriz[fila].length; col++) {
                if (fila == col) {
                    matriz[fila][col] = 1;
                } else {
                    matriz[fila][col] = 0;
                }
            }
        }
    }
    public static void mostrarMatriz(int[][] matriz) {
        System.out.println("Contenido de la matriz diagonal:");
        for (int fila = 0; fila < matriz.length; fila++) {
            for (int col = 0; col < matriz[fila].length; col++) {
                System.out.print(matriz[fila][col] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[][] diagonal = new int[5][5];
        llenarDiagonal(diagonal);
        mostrarMatriz(diagonal);
    }
}
