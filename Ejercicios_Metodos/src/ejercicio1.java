import java.util.Scanner;

public class ejercicio1 {
    double ladouno;
    double ladodos;
public void pedirDatos(){
Scanner teclado = new Scanner(System.in);
System.out.println("Ingrese el valor el lado ");
ladouno = teclado.nextDouble();
}
public double encontrarArea(){
double respuesta = ladouno+ladouno+ladouno+ladouno;
System.out.println("el Àrea del cuadrado es :"+respuesta);
return respuesta ;
}
public double encontrarPerimetro(){
double respuesta1 = ladouno*4;
System.out.println("el Perimetro del cuadrado es :"+respuesta1);
return respuesta1 ;
}
public static void main(String[] args) {
    ejercicio1 isnstancia = new ejercicio1();
    isnstancia.pedirDatos();
    isnstancia.encontrarArea();
    isnstancia.encontrarPerimetro();
}
}
