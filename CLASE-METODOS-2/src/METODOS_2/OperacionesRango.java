package METODOS_2;

public class OperacionesRango {
public int Devolvercuantospares(int rangoinicial, int rangofinal){
    int cantidadpares=0;
    for (int i = rangoinicial; i <= rangofinal; i++) {
        if (i%2==0) {
            cantidadpares++;
        }
    }
    return cantidadpares;
}
}
