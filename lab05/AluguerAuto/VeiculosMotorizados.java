package AluguerAuto;

import AluguerAuto.Interfaces.KmPercorridosInterface;

public abstract class VeiculosMotorizados implements KmPercorridosInterface {
    private int distanciaPercorrida;
    private int ultimaPercorrida;

    private final String matricula;
    private final String marca;
    private final String modelo;
    private final int potencia;

    public VeiculosMotorizados(String matricula, String marca, String modelo, int potencia) {
        assert isMatriculaValida(matricula);

        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.potencia = potencia;
    }

    @Override
    public String toString() {
        return "dPercorrida=" + distanciaPercorrida +
                ", matricula='" + matricula + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", potencia=" + potencia;
    }

    // Validations

    private boolean isMatriculaValida(String matricula){
        // Formato matriculas validas: AA-00-AA
        return matricula.matches("^[A-Z]{2}-[0-9]{2}-[A-Z]{2}$");
    }


    // TODO: Public methods by interface --> KmPercorridosInterface

    @Override
    public void trajeto(int quilometros){
        this.ultimaPercorrida = quilometros;
        this.distanciaPercorrida += quilometros;
    }

    @Override
    public int ultimoTrajeto(){
        return this.ultimaPercorrida;
    }

    @Override
    public int distanciaTotal(){
        return this.distanciaPercorrida;
    }

    // Getters
    public int getPotencia() {
        return this.potencia;
    }

    public String getMarca() {
        return this.marca;
    }

}
