package POO;

public class Persona {
String apellido;
String nombre;
String cedula;
int edad;

public Persona(){
}

public Persona(String _apellido, String _nombre, String _cedula, int _edad){
apellido= _apellido;
nombre=_nombre;
cedula=_cedula;
edad=_edad;
}


public Persona(String _cedula){
    cedula=_cedula;
}

public void InicializarValorPersona(String _apellido, String _nombre, String _cedula, int _edad){
    apellido= _apellido;
nombre=_nombre;
cedula=_cedula;
edad=_edad;
}
public static void main(String[] args) {
    Persona  persona=new Persona();
    persona.apellido= "García";
    persona.nombre= "Diego";
    persona.cedula = "1805379813";
    persona.edad= 19;

    Persona person2=new Persona("Carrera "," Diego ","1805379813 ", 19  );

    Persona person3=new Persona("1805379813");

    Persona persona4=new Persona();
    persona4.InicializarValorPersona("Lopez", "Camila", "1807984155", 17);
}
}
