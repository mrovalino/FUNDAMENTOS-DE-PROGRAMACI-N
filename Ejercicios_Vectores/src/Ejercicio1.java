public class Ejercicio1{
    public static void main(String[] args) {
        int[] numeros = {10, 20, 30, 40}; 
        int suma = 0;
        for (int i = 0; i < numeros.length; i++) {
            suma = suma + numeros[i];
        }
        double promedio = (double) suma / numeros.length;
        System.out.println("Suma: " + suma);
        System.out.println("Promedio: " + promedio);
    }
}