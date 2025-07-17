package Sobrecargas;

public class Sobrecargas1 {
public int SUMAR (int valor1, int valor2){
int resultado=0;
resultado=valor1+valor2;
return resultado;
}

public double SUMAR(double valor1,double valor2){
    double resultado=0;
    resultado=valor1+valor2;
    return resultado;
}

public double SUMAR(double valor1,double valor2,double valor3){
    double resultado=0;
    resultado=valor1+valor2+valor3;
    return resultado;
}
public static void main(String[] args) {
    Sobrecargas1 obj= new Sobrecargas1();
    int suma=obj.SUMAR(10, 20);
    System.out.println(suma);
    double suma2=obj.SUMAR(4.587, 3.14159);
    System.out.println(suma2);
    double suma3=obj.SUMAR(4.587, 3.14159,6.784);
    System.out.println(suma3);
}
}
