import java.util.Random;

public class MTRIZ {

    public static void Imprimirmatrizenteros(int[][] _matriz1) {
        int _fila = _matriz1.length;
        int _columna = _matriz1[0].length;

        System.out.println("IMPRIMIENDO MATRIZ\n");
        for (int f = 0; f < _fila; f++) {
            for (int c = 0; c < _columna; c++) {
                System.out.print("V[" + f + "][" + c + "]= ");
                System.out.print(_matriz1[f][c] + "\t");
            }
            System.out.print("\n");
        }
    }

    public static int obtenerMayorValor(int[][] matriz) {
        int mayor = matriz[0][0];
        for (int[] fila : matriz) {
            for (int valor : fila) {
                if (valor > mayor) {
                    mayor = valor;
                }
            }
        }
        return mayor;
    }

    public static int obtenerMenorValor(int[][] matriz) {
        int menor = matriz[0][0];
        for (int[] fila : matriz) {
            for (int valor : fila) {
                if (valor < menor) {
                    menor = valor;
                }
            }
        }
        return menor;
    }

    public static void sumarColumnas(int[][] matriz) {
        System.out.println("\nSuma de cada columna (vertical):");
        for (int c = 0; c < matriz[0].length; c++) {
            int sumaCol = 0;
            for (int[] ints : matriz) {
                sumaCol += ints[c];
            }
            System.out.println("Columna " + c + ": " + sumaCol);
        }
    }

    public static void sumarFilas(int[][] matriz) {
        System.out.println("\nSuma de cada fila (horizontal):");
        for (int f = 0; f < matriz.length; f++) {
            int sumaFila = 0;
            for (int c = 0; c < matriz[0].length; c++) {
                sumaFila += matriz[f][c];
            }
            System.out.println("Fila " + f + ": " + sumaFila);
        }
    }

    public static int[][] generarMatrizAleatoria(int filas, int columnas, int tipo) {
        Random rand = new Random();
        int[][] matriz = new int[filas][columnas];

        for (int f = 0; f < filas; f++) {
            for (int c = 0; c < columnas; c++) {
                if (tipo == 1) {
                    matriz[f][c] = rand.nextInt(51);         // 0 a 50
                } else if (tipo == 2) {
                    matriz[f][c] = rand.nextInt(101) - 50;   // -50 a 50
                }
            }
        }
        return matriz;
    }

    public static void mostrarResultados(int[][] matriz, String titulo) {
        System.out.println("\n===== " + titulo + " =====");
        Imprimirmatrizenteros(matriz);

        int mayor = obtenerMayorValor(matriz);
        int menor = obtenerMenorValor(matriz);
        System.out.println("\nEl valor MAYOR de la matriz es: " + mayor);
        System.out.println("El valor MENOR de la matriz es: " + menor);

        sumarColumnas(matriz);
        sumarFilas(matriz);
    }

    // Método para sumar dos matrices
    public static int[][] sumarMatrices(int[][] m1, int[][] m2) {
        int filas = m1.length;
        int columnas = m1[0].length;
        int[][] resultado = new int[filas][columnas];

        for (int f = 0; f < filas; f++) {
            for (int c = 0; c < columnas; c++) {
                resultado[f][c] = m1[f][c] + m2[f][c];
            }
        }
        return resultado;
    }

    // Método para obtener suma total de una matriz
    public static int sumaTotal(int[][] matriz) {
        int suma = 0;
        for (int[] fila : matriz) {
            for (int valor : fila) {
                suma += valor;
            }
        }
        return suma;
    }

    // Método para comparar qué matriz tiene mayor suma total
    public static void compararMatrices(int[][] m1, int[][] m2) {
        int suma1 = sumaTotal(m1);
        int suma2 = sumaTotal(m2);

        System.out.println("\n===== COMPARACIÓN DE MATRICES =====");
        System.out.println("Suma total de MATRIZ 1: " + suma1);
        System.out.println("Suma total de MATRIZ 2: " + suma2);

        if (suma1 > suma2) {
            System.out.println("→ MATRIZ 1 tiene mayor suma total.");
        } else if (suma2 > suma1) {
            System.out.println("→ MATRIZ 2 tiene mayor suma total.");
        } else {
            System.out.println("→ Ambas matrices tienen la misma suma total.");
        }
    }

    public static void main(String[] args) {
        // Generar dos matrices
        int[][] matriz1 = generarMatrizAleatoria(3, 4, 1);
        int[][] matriz2 = generarMatrizAleatoria(3, 4, 2);

        // Mostrar resultados de ambas matrices
        mostrarResultados(matriz1, "MATRIZ TIPO 1 (0 a 50)");
        mostrarResultados(matriz2, "MATRIZ TIPO 2 (-50 a 50)");

        // Comparar cuál es mayor
        compararMatrices(matriz1, matriz2);

        // Sumar las dos matrices y mostrar resultados
        int[][] matrizResultado = sumarMatrices(matriz1, matriz2);
        mostrarResultados(matrizResultado, "MATRIZ RESULTADO (Suma de ambas)");
    }
}