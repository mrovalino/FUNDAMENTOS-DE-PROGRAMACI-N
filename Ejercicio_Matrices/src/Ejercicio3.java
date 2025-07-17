public class Ejercicio3 {
     public static void llenarMarco(int[][] matriz) {
        int filas = matriz.length;
        int columnas = matriz[0].length;

        for (int fila = 0; fila < filas; fila++) {
            for (int col = 0; col < columnas; col++) {
                if (fila == 0 || fila == filas - 1 || col == 0 || col == columnas - 1) {
                    matriz[fila][col] = 1; 
                } else {
                    matriz[fila][col] = 0; 
                }
            }
        }
    }
    public static void mostrarMatriz(int[][] matriz) {
        System.out.println("Contenido de la matriz 'marco':");
        for (int fila = 0; fila < matriz.length; fila++) {
            for (int col = 0; col < matriz[fila].length; col++) {
                System.out.print(matriz[fila][col]);
            }
            System.out.println(); 
        }
    }
        public static void main(String[] args) {
        int filas = 5;
        int columnas = 15;
        int[][] marco = new int[filas][columnas];
        llenarMarco(marco);
        mostrarMatriz(marco);
    }
}
