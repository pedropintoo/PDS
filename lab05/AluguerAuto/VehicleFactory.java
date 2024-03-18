package AluguerAuto;

import AluguerAuto.Pesado.*;
import AluguerAuto.Ligeiro.*;
import AluguerAuto.Motociclo.*;

public class VehicleFactory{
    public static VeiculosMotorizados createMotociclo(String matricula, String marca, String modelo, int potencia, TipoMotociclo tipo){
        return new Motociclo(matricula, marca, modelo, potencia, tipo);
    }
    
    public static VeiculosMotorizados createAutomovelLigeiro(String matricula, String marca, String modelo, int potencia, int numeroQuadro, int capacidadeBagageira){
        return new AutomovelLigueiro(matricula, marca, modelo, potencia, numeroQuadro, capacidadeBagageira);
    }

    public static VeiculosMotorizados createTaxi(String matricula, String marca, String modelo, int potencia, int numeroQuadro, int capacidadeBagageira, int numeroLicenca){
        return new Taxi(matricula, marca, modelo, potencia, numeroQuadro, capacidadeBagageira, numeroLicenca);
    }
    
    public static VeiculosMotorizados createPPEletrico(String matricula, String marca, String modelo, int potencia, int numeroQuadro, double peso, int numeroMaxPassageiros, int autonomia){
        return new PesadoPassageirosEletrico(matricula, marca, modelo, potencia, numeroQuadro, peso, numeroMaxPassageiros, autonomia);
    }

    public static VeiculosMotorizados createALEletrico(String matricula, String marca, String modelo, int potencia, int numeroQuadro, int capacidadeBagageira, int autonomia){
        return new Eletrico(matricula, marca, modelo, potencia, numeroQuadro, capacidadeBagageira, autonomia);
    }

    public static VeiculosMotorizados createPesadoMercadorias(String matricula, String marca, String modelo, int potencia, int numeroQuadro, double peso, int cargaMax){
        return new PesadoMercadorias(matricula, marca, modelo, potencia, numeroQuadro, peso, cargaMax);
    }

    public static VeiculosMotorizados createPesadoPassageiros(String matricula, String marca, String modelo, int potencia, int numeroQuadro, double peso, int numeroMaxPassageiros){
        return new Pesado(matricula, marca, modelo, potencia, numeroQuadro, peso);
    }
}
