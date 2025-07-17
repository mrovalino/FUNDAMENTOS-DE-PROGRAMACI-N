import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class ejercicio9 {
public static void main(String[] args) {
   Scanner teclado=new Scanner(System.in);
       System.out.print("Ingrese día de nacimiento: ");
        int diaNac = teclado.nextInt();
        System.out.print("Ingrese mes de nacimiento: ");
        int mesNac = teclado.nextInt();
        System.out.print("Ingrese año de nacimiento: ");
        int anioNac = teclado.nextInt();
        System.out.print("Ingrese día actual: ");
        int diaAct = teclado.nextInt();
        System.out.print("Ingrese mes actual: ");
        int mesAct = teclado.nextInt();
        System.out.print("Ingrese año actual: ");
        int anioAct = teclado.nextInt();
        LocalDate fechaNac = LocalDate.of(anioNac, mesNac, diaNac);
        LocalDate fechaAct = LocalDate.of(anioAct, mesAct, diaAct);
        if (fechaAct.isBefore(fechaNac)) {
            System.out.println("La fecha actual no puede ser anterior a la fecha de nacimiento.");
        } else {
            Period periodo = Period.between(fechaNac, fechaAct);
            if (periodo.getYears() >= 1) {
                System.out.println("Edad: " + periodo.getYears() + " años");
            } else {
                System.out.println("Edad: " + periodo.getMonths() + " meses y " + periodo.getDays() + " días");
            }
        }
}
}
