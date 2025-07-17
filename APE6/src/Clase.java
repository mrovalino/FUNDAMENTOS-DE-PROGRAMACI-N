import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;
public class Clase {
public static void main(String[] args) {
    
String ruta="APE6/src/ProductosExportacion.csv";

LinkedList<ProductoyExportaciones> listaexportacio = new LinkedList<>();

try(BufferedReader reader= new BufferedReader(new FileReader(ruta))) {
    
String linea ;
boolean cabecera=true;

while ((linea=reader.readLine())!=null) {
     if (cabecera==true) {
        cabecera=false;
        continue;
     }

String [] partes = linea.split(";");


     if (partes.length==7) {


        int _id=Integer.parseInt(partes[0]);
  

        String _mes = partes[1];
        int _anio=Integer.parseInt(partes[2]);
        String _pais = partes[3];
       String _Tipoproducto = partes[4];
        int _peso=Integer.parseInt(partes[5]);
        int _monto=Integer.parseInt(partes[6]);
    ProductoyExportaciones _producyexpor = new ProductoyExportaciones(_id, _mes, _anio, _pais, _Tipoproducto, _peso, _monto);
     listaexportacio.add(_producyexpor);
 }
}
} catch (Exception e) {
    System.out.println("****Existe error****"+e.getMessage());
}
PaisesNorteamericanosmasexpor(listaexportacio);
ExportacionesporAño(listaexportacio);
  PorcentajeporSemestre(listaexportacio);
PromediodelPesoProducto(listaexportacio);
}
public static void PaisesNorteamericanosmasexpor(LinkedList<ProductoyExportaciones>_listaexpor){
System.out.println("***PREGUNTA 1***");
System.out.println("***Cual fue el pais de norteamerica con mas exportaciones***");
     int montoEEUU=0;
         int montomex=0;
             int montoCanada=0;
             String paismay="";
          for (ProductoyExportaciones productoyExportaciones : _listaexpor) {
             String pais=productoyExportaciones.getPais();
            if (pais.equals("***Estados Unidos")) {
                montoEEUU+=productoyExportaciones.getMontoMillonesDolares();
                paismay = "***Estados Unidos";
            }else if(pais.equals("Mexico")){
                        montomex+=productoyExportaciones.getMontoMillonesDolares();
                paismay = "***Mexico ";
            } else if(pais.equals("***Canada")){
              
                     montoCanada+=productoyExportaciones.getMontoMillonesDolares();
                   ;
                paismay = "***Canada ";
            }
          }
          int auxiliarmay=0;
 if(montoEEUU>auxiliarmay){
     auxiliarmay=montoEEUU;
 }
 if (montomex>auxiliarmay) {
    auxiliarmay=montomex;
 }
 if (montoCanada>auxiliarmay) {
    auxiliarmay=montoCanada;
 }
System.out.println("***El valor de Canada es:$"+ montoCanada);
System.out.println("***El valor de MExico es: $"+ montomex);
System.out.println("***El valor de EEUU es:$"+ montoEEUU);
 System.out.println("***El pais mayor es:"+paismay);
System.out.println("***El monto mayor $"+auxiliarmay);
}
private static void Extraerinformacion(LinkedList<ProductoyExportaciones> _listaproexpor){
  System.out.println("impirmir");
for (ProductoyExportaciones producexportaciones : _listaproexpor) {
    System.out.println(producexportaciones.toString());
}
}
public static void ExportacionesporAño(LinkedList<ProductoyExportaciones>_listaexpor){
System.out.println("***PREGUNTA 2*** ");
System.out.println("***Cantidad y montos de exportaciones por año");
    LinkedList<Integer> añosEncontrados= new LinkedList<>();
for (ProductoyExportaciones productoyExportaciones : _listaexpor) {
    int año=productoyExportaciones.getAnio();
    boolean yaexiste=false;
    for (Integer añosexistentes : añosEncontrados) {
        if (añosexistentes==año) {
            yaexiste=true;
               break;
        }
    }
    if (!yaexiste) {
        añosEncontrados.add(año);
       }
    }
       for (Integer años : añosEncontrados) {  
       int cantidad=0;
       long montototal=0;
        for (ProductoyExportaciones  valor : _listaexpor) {
            if (valor.getAnio()==años){
                cantidad++;
                montototal+=valor.getMontoMillonesDolares();
            }
        }
    System.out.println("Año: "+años + " CANTTIDAD TOTAL  "+cantidad+" MONTO TOTAL DE $:"+montototal);
}
}
public static void PorcentajeporSemestre(LinkedList<ProductoyExportaciones>_listaexpor){
    System.out.println("***PREGUNTA 3*** ");
System.out.println("***Porcentaje de montos por semestre***");
    long semestremonto1=0;
    long semestremonto2=0;
    for (ProductoyExportaciones producto : _listaexpor) {   
     String mes=producto.getMes();
     int monto=producto.getMontoMillonesDolares();
     if(mes.equals("Enero") ||mes.equals("Febrero")||mes.equals("Marzo") ||
     mes.equals("Abril") ||mes.equals("Mayo") ||mes.equals("Junio")){
     semestremonto1+=monto;
     }else if (mes.equals("Julio") ||mes.equals("Agosto")||mes.equals("Septiembre") ||
     mes.equals("Octubre") ||mes.equals("Noviembre") ||mes.equals("Diciembre"))
      {
          semestremonto2+=monto;
      }
    }
    double total = semestremonto1 + semestremonto2;
     double Porcentaje1 = (semestremonto1 / total) *100;
     double Porcentaje2 = (semestremonto2 / total) *100;
System.out.println("***EL valor del primersemestre es de "+semestremonto1+" con un porcentaje de : "+Porcentaje1);
System.out.println("***EL valor del segundosemestre es de "+semestremonto2+" con un porcentaje de : "+Porcentaje2);
}
public static void PromediodelPesoProducto(LinkedList<ProductoyExportaciones>_listaexpor){
    System.out.println("***PREGUNTA 4*** ");
System.out.println("***S");
LinkedList<String> articulos= new LinkedList<>();
for (ProductoyExportaciones valor : _listaexpor) {
    int año=valor.getAnio();
    if (año==2022|| año==2023|| año==2024) {
        String tipoproducto=valor.getTipoPrducto();
        boolean yaexiste=false;
        for (String existe : articulos) {
            if (existe.equals(tipoproducto)) {
                yaexiste=true;
                break;
            }
        }
     if (!yaexiste) {
        articulos.add(tipoproducto);
     }
    }
}
for (String tipoproducto : articulos) {
    int totalpeso=0;
    int cantidad=0;
for (ProductoyExportaciones  peso : _listaexpor) {
    int año=peso.getAnio();
    if (año==2022|| año==2023|| año==2024) {
        if (peso.getTipoPrducto().equals(tipoproducto)) {
            totalpeso+=peso.getPesoToneladas();
            cantidad++;   
        }
    }  
}
double promedio = totalpeso / cantidad;
    System.out.println("***El tipo producto es: "+ tipoproducto+" el promedio es "+promedio);
}
}
}



























