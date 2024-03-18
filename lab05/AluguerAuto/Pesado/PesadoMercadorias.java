package AluguerAuto.Pesado;

public class PesadoMercadorias extends Pesado {
    private final int cargaMax;

    public PesadoMercadorias(String matricula, String marca, String modelo, int potencia, int numeroQuadro, double peso, int cargaMax) {
        super(matricula, marca, modelo, potencia, numeroQuadro, peso);
        this.cargaMax = cargaMax;
    }

    @Override
    public String toString() {
        return super.toString() + ", cargaMax=" + cargaMax;
    }
}
