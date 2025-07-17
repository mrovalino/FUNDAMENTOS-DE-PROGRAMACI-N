import java.util.Random;
import java.util.Scanner;

public class VECTORES_2 {
//Teclado a definir el tamaño del vector
// valores aleatoria entre 20-50
//primedio
//maximo
//minimo
//rango
 public static void main(String[] args) {   
   Random random=new Random(); 
    Scanner teclado=new Scanner(System.in);

    int vector[];
    System.out.println("Define la longuitud del vector: ");
    int longuitud= teclado.nextInt();
    vector= new int[longuitud]; 

for (int i = 0; i < vector.length; i++) {
    vector[i]=random.nextInt(20, 51);
}

double promedio=0, sumatoria=0;
for (int i = 0; i < vector.length; i++) {
    sumatoria= sumatoria + vector[i];
}

promedio= sumatoria/vector.length;

int mayor =vector[0];
for (int i = 0; i < vector.length; i++) {
    if (mayor<vector [i]) {
        mayor=vector[i];
    }
}


}
}

