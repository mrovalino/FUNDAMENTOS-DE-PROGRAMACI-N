public class App {
    public static void main(String[] args) throws Exception {
        float resultado=0;
       //resultado= 5*9/4-2+5^2*3/2;
       resultado=5*9/4-2+(float)Math.pow(5, 2)*3/2;

       resultado= 5*3/2f;
       System.out.println("resultado "+resultado );
       resultado=(float)3/2;
       System.out.println(resultado);

        int a=500, b=2000, c=3000;
       //boolean resultado2 =(a>=b)?true:false;
        //System.out.println(resultado2);

        String resultado3 =(a>b & a>c)?"A es mayor que b y C":(b>a & b>c)?"b es mayor a A y B":"C es mayor que A y C";
        System.out.println(resultado3);


    }
}