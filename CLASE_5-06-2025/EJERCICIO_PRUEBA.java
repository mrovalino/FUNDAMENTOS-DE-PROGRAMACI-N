import java.util.Random;
import java.util.Scanner;

public class EJERCICIO_PRUEBA {
public static void Cargarvaloresaleatorios(int[]vector){
    Random random= new Random();
    for (int i = 0; i < vector.length; i++) {
        vector[i]=random.nextInt(1,20);
    }
}

public static void Imprimirvector(int[]vector){
System.out.println("------IMPRIMIENDO VECTOR-----");
    for (int i = 0; i < vector.length; i++) {

        System.out.println(vector[i]);
    }
}

public static void Restardosvectores(int[]v1,int[]v2,int[]vresta){
    for (int i = 0; i < vresta.length; i++) {
        vresta[i]=v1[i]-v2[i];
    }
}

public static void Multiplicardosvectores(int[]v1,int[]v2,int[]vproducto){
    for (int i = 0; i < vproducto.length; i++) {
        vproducto[i]=v1[i]*v2[i];
    }
}


public static void Cargarmayordosvectores(int[]v1,int[]v2,int[]vmayor){
    for (int i = 0; i < vmayor.length; i++) {
        vmayor[i]=Obtenermayor(v1[i],v2[i]);
    }
}

public static int Obtenermayor(int numero1, int numero2){
    if (numero1>=numero2) {
        return numero1;
    }else{
        return numero2;
    }
}
    public static void main(String[] args) {
    Scanner teclado=new Scanner(System.in);
    int longitudvector=0;
    int[] vector1;
    int[] vector2;
    int[] resta;
    int[] producto;
    int[] mayor;

System.out.println("Ingrese la longuitud del vector");
longitudvector=teclado.nextInt();

vector1=new int[longitudvector];
vector2=new int[longitudvector];
resta=new int[longitudvector];
producto=new int[longitudvector];
mayor=new int[longitudvector];


Cargarvaloresaleatorios(vector1);
Cargarvaloresaleatorios(vector2);

Imprimirvector(vector1);
Imprimirvector(vector2);

Restardosvectores(vector1, vector2, resta);
Multiplicardosvectores(vector1, vector2, producto);

Cargarmayordosvectores(vector1,vector2,mayor);

System.out.println("vector1"+"  \t  "+"vector2"+"  \t  "+"resta"+"  \t  "+"producto"+"  \t"+"mayor");
for (int i = 0; i < mayor.length; i++) {
    System.out.println(vector1[i]+ "  \t  "+ vector2[i]+"  \t  "+resta[i]+"  \t  "+producto[i]+"  \t  "+mayor[i]);

}
}
}
