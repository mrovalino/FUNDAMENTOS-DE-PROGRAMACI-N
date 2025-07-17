import java.util.Scanner;

public class SENO_COSENO {
public static void main(String[] args) {
    Scanner teclado=new Scanner(System.in);
   for (int i = 0; i<=180; i+=15) {
    double anguloguloradianes=0d;
    anguloguloradianes=Math.toRadians(i);
    System.out.println("ANGULO: "+i+" -SENO() = "+Math.sin(anguloguloradianes)+" -coseno() = "+Math.cos(anguloguloradianes));
   }
   for (double i = 0; i <=1; i+=0.05) {
    double senoradianes= Math.asin(i);
    double senogrados=Math.toDegrees(senoradianes);
    double cosradianes=Math.acos(i);
    double cosgrados=Math.toDegrees(cosradianes);
    System.out.println("ANGULO: "+i+" -SENO() = "+senogrados+" -coseno() = "+cosgrados);
   }
}
}