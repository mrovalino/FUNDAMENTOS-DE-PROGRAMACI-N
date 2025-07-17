public class ProductoyExportaciones {
private String pais;
private String mes;
private String TipoPrducto;
private int anio;
private int id;
private int pesoToneladas;
private int montoMillonesDolares;
public String getPais() {
    return pais;
}
public void setPais(String pais) {
    this.pais = pais;
}
public String getMes() {
    return mes;
}
public void setMes(String mes) {
    this.mes = mes;
}
public String getTipoPrducto() {
    return TipoPrducto;
}
public void setTipoPrducto(String tipoPrducto) {
   this.TipoPrducto = tipoPrducto;
}
public int getAnio() {
    return anio;
}
public void setAnio(int anio) {
    this.anio = anio;
}
public int getId() {
    return id;
}
public void setId(int id) {
    this.id = id;
}
public int getPesoToneladas() {
    return pesoToneladas;
}
public void setPesoToneladas(int pesoToneladas) {
    this.pesoToneladas = pesoToneladas;
}
public int getMontoMillonesDolares() {
    return montoMillonesDolares;
}
public void setMontoMillonesDolares(int montoMillonesDolares) {
    this.montoMillonesDolares = montoMillonesDolares;
}
@Override
public String toString() {
    // TODO Auto-generated method stub
    return  "Id = "+ id +"\\" +  "  Mes  = "+ mes+"\\" +"  año = "+ anio +"" +"Pais = "+ pais+"\\" +" Tipo de producto = "+ TipoPrducto+"\\"
    +" Peso en Toneladas = "+pesoToneladas+"\\"+"Monto en millones$ = "+ montoMillonesDolares;
}
public ProductoyExportaciones(int id, String mes, int anio ,String pais, String tipoPrducto, int pesoToneladas,
        int montoMillonesDolares) {
    this.pais = pais;
    this.mes = mes;
    this.TipoPrducto = tipoPrducto;
    this.anio = anio;
    this.id = id;
    this.pesoToneladas = pesoToneladas;
    this.montoMillonesDolares = montoMillonesDolares;
}
}
