public class Ejercicio8 {

public static int calcularDeterminante2x2(int a, int b, int c, int d) {
        return (a * d) - (b * c);
    }
    public static void mostrarResultado(double x, double y) {
        System.out.println("Solución del sistema:");
        System.out.println("x = " + x);
        System.out.println("y = " + y);
    }
    
    public static void main(String[] args) {
        int[][] A = {
            {7, 4},
            {5, -2}
        };
        int[] B = {13, 19};
        int detA = calcularDeterminante2x2(A[0][0], A[0][1], A[1][0], A[1][1]);
        if (detA == 0) {
            System.out.println("El sistema no tiene solución única.");
            return;
        }
        int detX = calcularDeterminante2x2(B[0], A[0][1], B[1], A[1][1]);
        int detY = calcularDeterminante2x2(A[0][0], B[0], A[1][0], B[1]);
        double x = (double) detX / detA;
        double y = (double) detY / detA;
        mostrarResultado(x, y);
    }
 }
