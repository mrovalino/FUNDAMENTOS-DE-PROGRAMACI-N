 import java.util.Random;
import java.util.Scanner;

public class Ejercicio4 {

    int[][] ventas = new int[4][5];
    double[] precios = new double[5];
    double[] recaudacionSucursal = new double[4];
    double recaudacionTotal = 0;
    public void ingresarPrecios(Scanner scanner) {
        System.out.println("Ingrese los precios de los 5 artículos:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Precio del artículo " + (i + 1) + ": ");
            precios[i] = scanner.nextDouble();
        }
    }
    public void ingresarVentas(Random random) {
        System.out.println("Ingrese las cantidades vendidas en las 4 sucursales para los 5 artículos:");
        for (int i = 0; i < 4; i++) {
            System.out.println("Sucursal " + (i + 1) + ":");
            for (int j = 0; j < 5; j++) {
                ventas[i][j] = random.nextInt(1, 20); 
            }
        }
    }
    public void mostrarTotalArticulos() {
        System.out.println("Cantidad total de cada artículo:");
        for (int j = 0; j < 5; j++) {
            int totalArticulo = 0;
            for (int i = 0; i < 4; i++) {
                totalArticulo += ventas[i][j];
            }
            System.out.println("Artículo " + (j + 1) + ": " + totalArticulo + " unidades.");
        }
    }
    public void mostrarCantidadSucursal2() {
        System.out.println("Cantidad de artículos vendidos en la Sucursal 2:");
        for (int j = 0; j < 5; j++) {
            System.out.println("Artículo " + (j + 1) + ": " + ventas[1][j] + " unidades.");
        }
    }
    public void mostrarCantidadArticuloSucursal1() {
        System.out.println("Cantidad del artículo 3 en la Sucursal 1: " + ventas[0][2] + " unidades.");
    }
    public void calcularRecaudacionPorSucursal() {
        System.out.println("Recaudación total de cada sucursal:");
        for (int i = 0; i < 4; i++) {
            recaudacionSucursal[i] = 0;
            for (int j = 0; j < 5; j++) {
                recaudacionSucursal[i] += ventas[i][j] * precios[j];
            }
            System.out.println("Sucursal " + (i + 1) + ": $" + recaudacionSucursal[i]);
            recaudacionTotal += recaudacionSucursal[i];
        }
    }
    public void mostrarRecaudacionTotal() {
        System.out.println("Recaudación total de la empresa: $" + recaudacionTotal);
    }
    public void mostrarSucursalMayorRecaudacion() {
        int sucursalMayorRecaudacion = 0;
        for (int i = 1; i < 4; i++) {
            if (recaudacionSucursal[i] > recaudacionSucursal[sucursalMayorRecaudacion]) {
                sucursalMayorRecaudacion = i;
            }
        }
        System.out.println("La sucursal con mayor recaudación es la Sucursal " + (sucursalMayorRecaudacion + 1));
    }
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Random random = new Random();
        Ejercicio4 ejercicio = new Ejercicio4();
        ejercicio.ingresarPrecios(teclado);
        ejercicio.ingresarVentas(random);
        ejercicio.mostrarTotalArticulos();
        ejercicio.mostrarCantidadSucursal2();
        ejercicio.mostrarCantidadArticuloSucursal1();
        ejercicio.calcularRecaudacionPorSucursal();
        ejercicio.mostrarRecaudacionTotal();
        ejercicio.mostrarSucursalMayorRecaudacion();
    }
}