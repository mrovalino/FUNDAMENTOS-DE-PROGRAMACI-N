import java.util.Scanner;

public class CONDICIONALES3 {
public static void main(String[] args) {
    Scanner teclado =new Scanner(System.in);
float num1,num2,num3;//total;
System.out.println("Ingrese el primer número");
num1=teclado.nextFloat();
System.out.println("Ingrese el segundo numero");
num2=teclado.nextFloat();
System.out.println("Ingrese el tercer número");
num3=teclado.nextFloat();
//String total1=(num1>num2 & num1>num3)?+num1+"numero es mayor":(num2>num1 & num2>num3)?+num2+ "numero es mayor":+num3+" numero es mayor";
if (num1>num2 & num1>num3) {
    System.err.println("el numero "+num1+" es el mayor");
}
else{
    if (num2>num1 & num2>num3){
        System.err.println("el numero "+num2+2+" es el mayor");
    }else {
        System.err.println("el numero "+num3+" es el mayor");
    }
}//System.err.println(total1);

int edad =45;
String strigEdad;
strigEdad=Integer.toString(edad);
edad=Integer.parseInt(strigEdad);


}
}