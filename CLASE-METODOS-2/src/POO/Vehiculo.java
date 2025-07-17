package POO;
public class Vehiculo {
    String marca;
    String modelo;
    int año;
    double precio;
    String color;

    public void imprimirInformacionVehiculo() {
        System.out.println("----------------------------------");
        System.out.println("INFORMACION DEL VEHICULO");
        System.out.println("----------------------------------");
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Año: " + año);
        System.out.println("Precio: " + precio);
        System.out.println("Color: " + color);
    }

    public void Actualizar_Datos(String _marca, String _modelo, int _año, double _precio, String _color) {
        marca = _marca;
        modelo = _modelo;
        año = _año;
        precio = _precio;
        color = _color;
    }

public double Calcular_promedio(double precio1, double precio2, double precio3){
    double promedio=(precio1+precio2+precio3)/3;
return promedio;
}
public double Ganancia15pc(double vehi1,double vehi2, double vehi3){
    double gananciaV1= vehi1*0.15;
    double gananciaV2= vehi2*0.15;
    double gananciaV3= vehi3*0.15;
return gananciaV1+gananciaV2+gananciaV3;
}

    public static void main(String[] args) {
        Vehiculo vehiculo_1 = new Vehiculo();
        vehiculo_1.marca = "KIA";
        vehiculo_1.modelo = "Cerato";
        vehiculo_1.año = 2016;
        vehiculo_1.color = "negro";
        vehiculo_1.precio = 12000;

        vehiculo_1.imprimirInformacionVehiculo();
Vehiculo vehiculo_2 = new Vehiculo();
        vehiculo_2.Actualizar_Datos("KIA", "Soluto", 2025, 19000, "Negro");
        vehiculo_2.imprimirInformacionVehiculo();
Vehiculo vehiculo_3 = new Vehiculo();
        vehiculo_3.Actualizar_Datos("HYUNDAI", "Accent", 2025, 17500, "Azul");
        vehiculo_3.imprimirInformacionVehiculo();
double promedio = vehiculo_1.Calcular_promedio(vehiculo_1.precio,vehiculo_2.precio,vehiculo_3.precio);
System.out.println("Promedio de los precios: "+ promedio);

double ganancia15=vehiculo_1.Ganancia15pc(vehiculo_1.precio,vehiculo_2.precio,vehiculo_3.precio);
System.out.println("ganancia al 15%: "+ ganancia15);


    }
}
