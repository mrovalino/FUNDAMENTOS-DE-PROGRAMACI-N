
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;

public class EjercicioArchcivo {
    public static void main(String[] args) {
        LinkedList<Cuenta> lista;
        String ruta = "src/IngresosEgresos.csv";


        lista = CargaArchivoCSV(ruta);
        //Imprimir lsita
        System.out.println("Imprimir lista");
        ImprimirLista(lista);
        // Pregunta1 : Total ingresos y egresos
        System.out.println("Pregunta 1");
        PreguntarIngresosEgresos(lista);
        // Pregunta 2: Toatal ingreso y egresos costa
        System.out.println("Pregunta 2");
        PreguntarIngresosEgresosCosta(lista);
        //Pregunta 3: Total ingresos y Egresos costa por ciudad
        System.out.println("Pregunta 3");
        DevolverValorPorCiuad(lista);
    }
    private static void ImprimirLista(LinkedList<Cuenta> _lista){
        System.out.println("Imprimiendo la lista de cuenta");
        for (Cuenta cuenta : _lista) {
            System.out.println(cuenta.toString());
        }
    }
    private static LinkedList<Cuenta> CargaArchivoCSV(String ruta) {
        LinkedList<Cuenta> _lista = new LinkedList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(ruta))){
            String linea;

            boolean tieneCabecera = true;
            while ((linea = reader.readLine())!=null) {
                if (tieneCabecera==true) {
                    tieneCabecera=false;
                    continue;
                }
                String[] parte = linea.split(";");
                if (parte.length == 7) {
                   int id = Integer.parseInt(parte[0]);
                   String nombre = parte[1];
                   String apellido = parte[2];
                   String ciudad = parte[3];
                   String genero = parte[4];
                   double ingresos = Double.parseDouble(parte[5]);
                   double egresos = Double.parseDouble(parte[6]);
                   Cuenta cuenta = new Cuenta(id, nombre, apellido, ciudad, genero, ingresos, egresos);
                   _lista.add(cuenta);
                }
            }
        } catch (Exception e) {
            System.out.println("Error al cargar el archivo: "+e.getMessage());
        }
        return _lista;
    }
    private static void PreguntarIngresosEgresos(  LinkedList<Cuenta> _lista){
        double sumatoriaingresos = 0;
        double sumatoriaegresos = 0;
        for (Cuenta cuenta : _lista) {
            sumatoriaingresos=sumatoriaingresos+cuenta.getIngresos();
            sumatoriaegresos=sumatoriaegresos+cuenta.getEgresos();
        }
        System.out.println("Sumatoria de Ingresos: "+ sumatoriaingresos);
        System.out.println("Sumatoria de Egresos: "+ sumatoriaegresos);
    }
    private static void PreguntarIngresosEgresosCosta(  LinkedList<Cuenta> _lista){
         double sumatoriaingresos = 0;
        double sumatoriaegresos = 0;
        for (Cuenta cuenta : _lista) {
            if (cuenta.getCiudad().equals("Guayaquil")|| cuenta.getCiudad().equals("Portoviejo")) {
                sumatoriaingresos=sumatoriaingresos+cuenta.getIngresos();
                sumatoriaegresos=sumatoriaegresos+cuenta.getEgresos();
            }
        }
        System.out.println("Sumatoria de Ingresos: "+ sumatoriaingresos);
        System.out.println("Sumatoria de Egresos: "+ sumatoriaegresos);
    }
    private static void DevolverValorPorCiuad(LinkedList<Cuenta> _lista){
        double ingresosGuayaquil = 0, egresoGuayaquil =0;
        double ingresosPortoviejo = 0, egresosPortoviejo = 0;
        for (Cuenta cuenta : _lista) {
            if (cuenta.getCiudad().equals("Guayaquil")) {
                ingresosGuayaquil += cuenta.getIngresos();
                egresoGuayaquil += cuenta.getEgresos();
            }
            if (cuenta.getCiudad().equals("Portoviejo")) {
                ingresosPortoviejo += cuenta.getIngresos();
                egresosPortoviejo += cuenta.getEgresos();
            }
        }
        LinkedList<Pregunta3> listaPreguntas = new LinkedList<>();
        listaPreguntas.add(new Pregunta3("Guayaquil", egresoGuayaquil, ingresosGuayaquil));
        listaPreguntas.add(new Pregunta3("Portoviejo", egresosPortoviejo, ingresosPortoviejo));

        for (Pregunta3 pregunta3 : listaPreguntas) {
            System.out.println(pregunta3.toString());
        }
    }   
}

