package MetodosString;

public class MetodosCadenas {
    public static void MetodoChartAt() {
        // ChartAt retorna el primer elemento de un String
        String cadena = "HOLA MUNDO";
        char resultado = cadena.charAt(5);
        System.out.println(resultado);

        // longuitud
        int longuitud = cadena.length();
        System.out.println(longuitud);

        for (int i = 0; i < longuitud; i++) {
            System.out.println(cadena.charAt(i));
        }
    }

    public void MetodoCompare() {
        String cadena1 = "HOLA";
        String cadena2 = "HOLA MUNDO";
        System.out.println(cadena1.compareTo(cadena2));
    }

    public void MetodoCompareIgnorandoMayusculasYMinusculas() {

        String cadena1 = "Hola";
        String cadena2 = "HOLA";
        System.out.println(cadena1.compareToIgnoreCase(cadena2));
    }
 public void concatenarcadena(){
    String nombre = "Diego";
    String apellido = "García";
    String apellido2= "Cabrera";
    System.out.println(nombre.concat(" "+apellido).concat(" "+apellido2));
 }
 public void ValidarSubcadena(){
    String cadena = "Andres Canilo Lopez Ramirez";
    System.out.println(cadena.contains("Andres"));
    System.out.println(cadena.contains("Camilo"));
    System.out.println(cadena.contains("pez"));
 }

 public void Terminoen(){
    String cadena = "Ambato";
    System.out.println(cadena.endsWith("Amb"));
    System.out.println(cadena.endsWith("to"));
    System.out.println(cadena.endsWith("o"));
}
public void CadenasIguales(){
    String cadena1= "HOLA";
    String cadena2= "Hola";
    String cadena3= "Hellow";
System.out.println(cadena1.equals(cadena2));
System.out.println(cadena1.equals(cadena3));
}

   

    public static void main(String[] args) {
        MetodosCadenas obj = new MetodosCadenas();
        // MetodoChartAt();
        // obj.MetodoCompare();
       // obj.MetodoCompareIgnorandoMayusculasYMinusculas();
        //obj.concatenarcadena();
        //obj.ValidarSubcadena();
        //obj.Terminoen();
        //obj.CadenasIguales();

    }

}
