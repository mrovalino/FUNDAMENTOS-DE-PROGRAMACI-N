public class Pregunta3 {
    private String ciudad;
    private double ingreso;
    private double egresos;

    public String getCiudad() {
        return ciudad;
    }

    public double getIngreso() {
        return ingreso;
    }

    public double getEgresos() {
        return egresos;
    }

    public Pregunta3(String ciudad, double egresos, double ingreso) {
        this.ciudad = ciudad;
        this.egresos = egresos;
        this.ingreso = ingreso;
    }

    @Override
    public String toString() {
        String resultado = "Ciudad: "+this.ciudad+"\t"+
                           "Ingresos: "+this.ingreso+"\t"+
                           "Egresoso: "+this.egresos;
        return resultado;
    }
    
}
