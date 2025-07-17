package POO;

import java.util.Scanner;

public class Estudio {
String materia="FP";
int tiempo=60 ;

public void imprimirInformacion(){
    System.out.println("Materia = "+ materia+ " - "+" Tiempo de Estudio = "+tiempo+" en minutos");
}

public void ActualizarInformacion(String _materia, int _tiempo){
    materia=_materia;
    tiempo=_tiempo;
}
 public void IngresarAtributos(){
    Scanner teclado = new Scanner(System.in);
    System.out.println("Ingrese la materia");
    materia=teclado.next();
    System.out.println("Ingrese el triempo");
    tiempo=teclado.nextInt();
 }

public static void main(String[] args) throws Exception{
    Estudio estudio = new Estudio();
    estudio.materia= "Fundamentos de programacion";
    estudio.tiempo= 90;
    estudio.imprimirInformacion();

    estudio.ActualizarInformacion("Fisica", 30);
    estudio.imprimirInformacion();

    estudio.IngresarAtributos();
    estudio.imprimirInformacion();
}

}
