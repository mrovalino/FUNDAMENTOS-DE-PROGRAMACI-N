import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.LinkedList;

public class App {


    public static void main(String[] args) throws Exception {
        //
        String ruta="ARCHIVOS/src/DelitosProvincia.csv";
 //TRY SIRVE PARA CONTROLAR  CATCH
        try (BufferedReader reader = new BufferedReader(new FileReader(ruta))){
            String linea;
            LinkedList<Delito> listaDelito = new LinkedList<>();
            boolean cabecera=true;

              while ((linea =reader.readLine())!=null) {
                //saltar cabecera
                if (cabecera==true) {
                    cabecera=false;
                    continue;
                }

                String [] partes = linea.split(";");
                if (partes.length==4) {
                    String _provincia=partes[0];
                    String _delitos=partes[1];
                    boolean _judicialisado=Boolean.parseBoolean(partes[2]);
                    String _victima=partes[3];
//crear el objeto delito
       Delito _delitotmp = new Delito(_provincia, _delitos, _delitos, _victima);
//agragar delito a la lista
       //      listaDelito.add(new Delito(_provincia, _delitos, _delitos, _victima));
listaDelito.add(_delitotmp);

                }


              }


//imprimir la lista de delitos

for (Delito delito : listaDelito) {
System.out.println("----imprimir lista delitos---");
    System.out.println(delito.toString());
}

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("EXISTE UN ERROR EN EL PROCESO"+"\n"+e.getMessage());
        }

//agreagar un nuevo delito
Delito nuevoDelito= new Delito("Azuay", "bola", ruta, "lol");
try (FileWriter fw=new FileWriter(ruta,true)){
    fw.write(nuevoDelito.ConvertirToCsv());//agregar una nueva linea
} catch (Exception e) {
            System.out.println("EXISTE UN ERROR EN EL PROCESO"+"\n"+e.getMessage());
    // TODO: handle exception
}




    }
}