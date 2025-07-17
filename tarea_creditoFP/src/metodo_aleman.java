import java.util.Scanner;

public class metodo_aleman {

    public static void main(String[] args) throws Exception {
        limpiarConsola();
        Scanner teclado = new Scanner(System.in);
        double dineroPrestamo = 0;
        int plazo = 0;
        int tiempo = 0;
        double interesAnual = 16.77;
        imprimirencabezado();
        dineroPrestamo = Integer.parseInt(variableentrada("Ingrese el valor del prestamo deseado => "));
        limpiarConsola();
        while (dineroPrestamo < 99) {
            imprimirencabezado();
            dineroPrestamo = Integer.parseInt(variableentrada("Ingrese el valor del prestamo deseado => "));
            limpiarConsola();
        }
        imprimirencabezado();
        encabezadotiempo();
        plazo = teclado.nextInt();
        switch (plazo) {
            case 1:
                tiempo = 3;
                break;
            case 2:
                tiempo = 6;
                break;
            case 3:
                tiempo = 9;
                break;
            case 4:
                tiempo = 12;
                break;
            default:
                System.out.println("No seleccionado ningún plazo");
                break;
        }
        double tasaMensual = interesAnual / 12 / 100;
        double capitalCuota = dineroPrestamo / tiempo; 
        double saldo = dineroPrestamo;
        limpiarConsola();
        imprimirencabezado();
        for (int i = 1; i <= tiempo; i++) {
            double interes = saldo * tasaMensual;   
            double cuotaTotal = capitalCuota + interes;  
            saldo = saldo - capitalCuota;  

            if (saldo < 0.01) {
                saldo = 0;
            }
            System.out.println(i + "     | " +
                    redondear(capitalCuota) + "   | " +
                    redondear(interes) + "   | " +
                    redondear(cuotaTotal) + "  | " +
                    redondear(saldo));
        }
    }
    public static void limpiarConsola() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    static void imprimirencabezado() {
        System.out.println("------------------------------------------");
        System.out.println("          GENERADOR DE CRÉDITO            ");
        System.out.println("------------------------------------------");
    }
    static void encabezadotiempo() {
        System.out.println("Seleccione el plazo a cancelar");
        System.out.println("1.Tres Meses\n2.Seis Meses\n3.Nueve Meses\n4.Doce Meses");
    }
    static String variableentrada(String texto) {
        System.out.print(texto);
        Scanner teclado = new Scanner(System.in);
        String resultado = teclado.nextLine();
        limpiarConsola();
        while (esNumero(resultado) == false) {
            imprimirencabezado();
            System.out.print(texto);
            resultado = teclado.nextLine();
            limpiarConsola();
        }
        return resultado;
    }
    public static String redondear(double numero) {
        return String.format("%.2f", numero);
    }
    public static boolean esNumero(String cadena) {
        if (cadena == "") {
            return false;
        }
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}