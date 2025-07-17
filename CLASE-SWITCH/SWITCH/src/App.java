import java.lang.classfile.instruction.SwitchCase;
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

        System.out.println("INGRESE EL SABOR DEL HELADO");
        String saborhelado =teclado.next();
        switch (saborhelado) {
            case "limon":
                System.out.println("El precio es: $2.50");
                break;
                case "uva":
                System.out.println("El precio es: $1.50");
                break;
                case "Cafe":
                System.out.println("El precio es: $2.00");
                break;
            default:
            System.out.println("NO DISPONEMOS EL SABOR DE HELADO");
                break;
        }

        //enero mayo agosto = descuento del 15%
        //febrero abril junio septiembre = descuento del 18%
        //marzo julio octubre noviembre diceimbre = descuento del 25%

        System.out.println("INGRESE EL MES de la venta");
        int mes;
        mes=teclado.nextInt();
        System.out.println("INGRESE EL VALOR DE LA COMPRA");
        Float valor=teclado.nextFloat();
        switch (mes) {
         case 1,5,8:
        System.out.println("DESCUENTO DEL 15%: VALOR DESCUENTO($) "+valor*0.15);
        break;
         case 2,4,6,9:
         System.out.println("DESCEUNTO DEL 18%: VALOR DESCUENTO($) "+valor*0.18);
         break;
        case 3,7,11,12:
        System.out.println("DESCUENTO DEL 25%: VALOR DESCUENTO($) "+valor*0.25);
        break;
            default:
            System.out.println("EL MES INGRESADO NO ESTA EN EL RANGO");
                break;
        }
    }
}
