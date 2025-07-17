
   import java.util.Scanner;

public class Ejercicio6 {

    public static void ingresarAsistencia(int[][] asistencia, Scanner teclado) {
        System.out.println("Ingrese la asistencia por materia y facultad:");
        for (int materia = 0; materia < 5; materia++) {
            for (int facultad = 0; facultad < 4; facultad++) {
                System.out.print("Asistencia en Materia " + (materia + 1) + ", Facultad " + (facultad + 1) + ": ");
                asistencia[materia][facultad] = teclado.nextInt();
            }
        }
    }
    public static void mostrarAsistenciaPorMateria(int[][] asistencia) {
        System.out.println("\nAsistencia total por materia:");
        for (int materia = 0; materia < 5; materia++) {
            int totalMateria = 0;
            for (int facultad = 0; facultad < 4; facultad++) {
                totalMateria += asistencia[materia][facultad];
            }
            System.out.println("Materia " + (materia + 1) + ": " + totalMateria + " asistentes");
        }
    }
    public static void mostrarAsistenciaFacultad3(int[][] asistencia) {
        int totalFacultad3 = 0;
        for (int materia = 0; materia < 5; materia++) {
            totalFacultad3 += asistencia[materia][2]; 
        }
        System.out.println("\nAsistencia total en la Facultad 3: " + totalFacultad3 + " asistentes");
    }
    public static void mostrarAsistenciaMateria2Facultad1(int[][] asistencia) {
        System.out.println("\nAsistencia en Materia 2 de Facultad 1: " + asistencia[1][0] + " asistentes");
    }
    public static void mostrarPorcentajePorFacultad(int[][] asistencia) {
        int[] totalPorFacultad = new int[4];
        int totalGeneral = 0;

        for (int facultad = 0; facultad < 4; facultad++) {
            for (int materia = 0; materia < 5; materia++) {
                totalPorFacultad[facultad] += asistencia[materia][facultad];
            }
            totalGeneral += totalPorFacultad[facultad];
        }
        System.out.println("\nPorcentaje de asistencia por facultad:");
        for (int facultad = 0; facultad < 4; facultad++) {
            double porcentaje = (double) totalPorFacultad[facultad] * 100 / totalGeneral;
            System.out.printf("Facultad %d: %.2f%%\n", facultad + 1, porcentaje);
        }
    }
    public static void mostrarFacultadConMayorAsistencia(int[][] asistencia) {
        int[] totalPorFacultad = new int[4];
        for (int facultad = 0; facultad < 4; facultad++) {
            for (int materia = 0; materia < 5; materia++) {
                totalPorFacultad[facultad] += asistencia[materia][facultad];
            }
        }
        int facultadMayor = 0;
        for (int i = 1; i < 4; i++) {
            if (totalPorFacultad[i] > totalPorFacultad[facultadMayor]) {
                facultadMayor = i;
            }
        }
        System.out.println("\nLa facultad con mayor asistencia es la Facultad " + (facultadMayor + 1));
    }
     public static void main(String[] args) {
        int[][] asistencia = new int[5][4]; 
        Scanner teclado = new Scanner(System.in);

        ingresarAsistencia(asistencia, teclado);
        mostrarAsistenciaPorMateria(asistencia);
        mostrarAsistenciaFacultad3(asistencia);
        mostrarAsistenciaMateria2Facultad1(asistencia);
        mostrarPorcentajePorFacultad(asistencia);
        mostrarFacultadConMayorAsistencia(asistencia);
    }
}
