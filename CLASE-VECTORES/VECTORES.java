public class VECTORES {

    public static void ImprimirVectoresEnteros(int[]vector){
        System.out.println("Imprimir vector");
        for (int i = 0; i < vector.length; i++) {
            System.out.println(vector[i]);
        }
    }

    public static void ImprimirVectoresDobles(double[]vector){
        System.out.println("Imprimir vector");
        for (int i = 0; i < vector.length; i++) {
            System.out.println(vector[i]);
        }
    }

public static double devolverpromediodeCalificaciones(double[] vector){
double promedio=0, sumatoria=0;
for (int i = 0; i < vector.length; i++) {
    sumatoria=sumatoria+vector[i];
}
promedio= sumatoria/vector.length;

return promedio;
}
    
public static void main(String[] args) {
    //metodo 1 vectores preestablecidos
    int [] edades = new int[6];
    //asignaacion de los valores
    edades[0] = 5;
    edades[1] = 6;
    edades[2] = 8;
    edades[3] = 4;
    edades[4] = 7;
    edades[5] = 2;

String []alumnos =new String[2];
alumnos[0]="juan";
alumnos[1]="luis";
    
//Metodo 2 con valores pre asignados
double[] calificaciones= new double[]{2.8,8.4,9.6,6.5,7.2,3.3,7.7};
boolean[] estados={true,false,true};

//System.out.println(edades.length);
//System.out.println(alumnos.length);
//System.out.println(calificaciones.length);
//System.out.println(estados.length);

//Merodo 3 Bajo demanda
 int[] estaturas;
 System.out.println("Usuario cuantos alumnos vamos a evaluar");
 int numElementos=4;
 //instanciar
 estaturas=new int [numElementos];

 estaturas[0]=165;
 estaturas[1]=180;
 estaturas[2]=161;
 estaturas[3]=190;
 
 //imprimir vectores
//ImprimirVectoresEnteros(edades);
//ImprimirVectoresEnteros(estaturas);
ImprimirVectoresDobles(calificaciones);

//imprimir el primedio de calificaciones

double promedio= devolverpromediodeCalificaciones(calificaciones);
System.out.println("Promedio= "+ promedio);

}
}
