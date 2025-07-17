public class Delito {
private String provincia;
private String delito;
private boolean judicializado;
private String victima;
public Delito(String provincia, String delito, String udicializado, String victima) {
    this.provincia = provincia;
    this.delito = delito;
    this.judicializado = judicializado;
    this.victima = victima;
}
public String getProvincia() {
    return provincia;
}
public void setProvincia(String provincia) {
    this.provincia = provincia;
}
public String getDelito() {
    return delito;
}
public void setDelito(String delito) {
    this.delito = delito;
}
public boolean getJudicializado() {
    return judicializado;
}
public void setJudicializado(boolean judicializado) {
    this.judicializado = judicializado;
}
public String getVictima() {
    return victima;
}
public void setVictima(String victima) {
    this.victima = victima;

}
@Override
public String toString() {

    return "Provincia = "+ provincia+"\t" +"Delito = "+ delito+"\t" +"judializado = "+ judicializado+"\t" +"Victima = "+ victima  ;
                
}

public String ConvertirToCsv(){

return provincia+";"+delito+";"+judicializado+";"+victima+";";
}



}