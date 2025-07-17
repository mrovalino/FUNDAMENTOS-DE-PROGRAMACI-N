import java.util.Scanner;

public class Ejercicio5 {

    public static void ingresarStock(int[][] stock, Scanner teclado) {
        System.out.println("Ingrese el stock de los 8 productos en 3 almacenes:");
        for (int producto = 0; producto < 8; producto++) {
            for (int almacen = 0; almacen < 3; almacen++) {
                System.out.print("Stock del producto " + (producto + 1) + " en el almacén " + (almacen + 1) + ": ");
                stock[producto][almacen] = teclado.nextInt();
            }
        }
    }
    public static void mostrarInventarioPorProducto(int[][] stock) {
        System.out.println("\nInventario total por producto:");
        for (int producto = 0; producto < 8; producto++) {
            int totalProducto = 0;
            for (int almacen = 0; almacen < 3; almacen++) {
                totalProducto += stock[producto][almacen];
            }
            System.out.println("Producto " + (producto + 1) + ": " + totalProducto + " unidades");
        }
    }
    public static void mostrarInventarioAlmacen1(int[][] stock) {
        int totalAlmacen1 = 0;
        for (int producto = 0; producto < 8; producto++) {
            totalAlmacen1 += stock[producto][0];
        }
        System.out.println("\nInventario total en el almacén 1: " + totalAlmacen1 + " unidades");
    }
    public static void mostrarStockProducto4Almacen2(int[][] stock) {
        System.out.println("\nStock del producto 4 en el almacén 2: " + stock[3][1] + " unidades");
    }
    public static void mostrarValorTotalInventario(int[][] stock, int[] precios) {
        int valorTotal = 0;
        for (int producto = 0; producto < 8; producto++) {
            for (int almacen = 0; almacen < 3; almacen++) {
                valorTotal += stock[producto][almacen] * precios[producto];
            }
        }
        System.out.println("\nValor total del inventario: $" + valorTotal);
    }
    public static void mostrarAlmacenConMasStock(int[][] stock) {
        int[] totalPorAlmacen = new int[3];
        for (int almacen = 0; almacen < 3; almacen++) {
            for (int producto = 0; producto < 8; producto++) {
                totalPorAlmacen[almacen] += stock[producto][almacen];
            }
        }
        int maxStock = totalPorAlmacen[0];
        int almacenMayor = 1;
        for (int i = 1; i < 3; i++) {
            if (totalPorAlmacen[i] > maxStock) {
                maxStock = totalPorAlmacen[i];
                almacenMayor = i + 1;
            }
        }
        System.out.println("\nEl almacén con mayor cantidad de productos es el almacén " + almacenMayor);
    }
     public static void main(String[] args) {
        int[][] stock = new int[8][3];
        int[] precios = {100, 200, 50, 40, 80, 100, 60, 50};
        Scanner teclado = new Scanner(System.in);

        ingresarStock(stock, teclado);
        mostrarInventarioPorProducto(stock);
        mostrarInventarioAlmacen1(stock);
        mostrarStockProducto4Almacen2(stock);
        mostrarValorTotalInventario(stock, precios);
        mostrarAlmacenConMasStock(stock);
    }
}
