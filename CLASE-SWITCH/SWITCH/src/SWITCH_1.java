import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int diasemana=0;
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el dia de la semana");
        diasemana=teclado.nextInt();
        switch (diasemana) {
            case 1:
                System.out.println("DOMINGO");
                break;
                case 2:
                System.out.println("LUNES");
                break;
                case 3:
                System.out.println("MARTES");
                break;
                case 4:
                System.out.println("MIERCOLES");
                break;
                case 5:
                System.out.println("JUEVES");
                break;
                case 6:
                System.out.println("VIERNES");
                break;
                case 7:
                System.out.println("SABADO");
                break;
            default:
            System.out.println("EL VALOR INGRESADO NO ESTA ASOCIADO A UN DIA DE LA SEMANA ");
                break;
        }
    }
}
