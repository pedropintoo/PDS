/**
 * @ Author: Pedro Pinto (pmap@ua.pt) & Guilherme Santos (gui.santos91@ua.pt)
 * @ Create Time: 2024-03-18
 */

package AluguerAuto;

import AluguerAuto.Ligeiro.Eletrico;
import AluguerAuto.Ligeiro.Taxi;
import AluguerAuto.Motociclo.Motociclo;
import AluguerAuto.Motociclo.TipoMotociclo;
import AluguerAuto.Pesado.PesadoMercadorias;
import AluguerAuto.Pesado.PesadoPassageiros;
import AluguerAuto.Pesado.PesadoPassageirosEletrico;
import AluguerAuto.Utils.UserInput;

import java.util.ArrayList;
import java.util.Comparator;

public class EmpresaViaturas {
    private final String nome;
    private final String codigoPostal;
    private final String email;

    private final ArrayList<VeiculosMotorizados> viaturas = new ArrayList<>();

    public EmpresaViaturas(String nome, String codigoPostal, String email) {
        if(isCodigoPostalValid(codigoPostal) && isEmailAddressValid(email)){
            this.nome = nome;
            this.codigoPostal = codigoPostal;
            this.email = email;
        }
        else{
            this.nome = null;
            this.codigoPostal = null;
            this.email = null;
            System.out.println("Error in Object creation");
        }
    }

    @Override
    public String toString(){
        return "Empresa: " + this.nome + ", Codigo postal: " + this.codigoPostal + ", Email: " + this.email;
    }


    // TODO: Validacao

    public static boolean isEmailAddressValid(String emailAddress){
        return emailAddress.matches("^\\w[a-zA-Z0-9_\\.]+@\\w+\\.\\w{2,}$");
    }

    public static boolean isCodigoPostalValid(String codigoPostal) {
        // Formato codigo postal valido: 0000-000
        return codigoPostal.matches("^[0-9]{4}-[0-9]{3}$");
    }

    // TODO: Adicionar e remover viaturas

    public void adicionarViatura(VeiculosMotorizados viatura){
        viaturas.add(viatura);
    }

    public void removerViatura(VeiculosMotorizados viatura){
        viaturas.remove(viatura);
    }

    public void removerTodasViaturas(){
        viaturas.clear();
    }

    // TODO: Ordenar as viaturas

    public void ordenarPorPotencia(){
        this.viaturas.sort((lhs, rhs) -> {
            // -1 - less than, 1 - greater than, 0 - equal
            return Integer.compare(rhs.getPotencia(), lhs.getPotencia());
        });
    }

    public void ordenarPorDistanciaPercorrida(){
        this.viaturas.sort((lhs, rhs) -> {
            // -1 - less than, 1 - greater than, 0 - equal
            return Integer.compare(rhs.distanciaTotal(), lhs.distanciaTotal());
        });
    }

    public void ordenarPorMarca(){
        this.viaturas.sort(Comparator.comparing(VeiculosMotorizados::getMarca));
    }

    // TODO: Gerar viaturas aleatoriamente
    //  (Motociclo, Taxi, Ligeiro eletrico, Pesado Mercadoria, Pesado Passageiros, Pesado Passageiros Eletrico)

    public void generateRandom(int numberEachGeneration){

        // Properties of VeiculosMotorizados
        String[] letras = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        int[] numeros = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        String[] marcas = {"Audi", "BMW", "Chevrolet", "Dodge", "Ferrari", "Honda", "Jaguar", "Kia", "Lamborghini", "Mercedes-Benz", "Nissan", "Porsche", "Rolls-Royce", "Toyota", "Volkswagen"};
        String[] modelos = {"A3", "A4", "A6", "Q3", "Q5", "Q7", "TT", "320i", "X1", "M5", "Camaro", "Corvette", "Challenger", "458 Italia", "LaFerrari", "Accord", "Civic", "NSX", "F-Type"};

        String matricula;
        String marca;
        String modelo;
        int potencia;

        // TODO: Generate Motociclo
        TipoMotociclo tipo;

        for(int i = 1; i <= numberEachGeneration; i++){
            matricula = letras[(int) (Math.random() * 26)]+letras[(int) (Math.random() * 25)]+"-"
                        +numeros[(int) (Math.random()*10)]+numeros[(int) (Math.random()*10)]+"-"
                        +letras[(int) (Math.random() * 26)]+letras[(int) (Math.random() * 25)];
            marca = marcas[(int) (Math.random()*15)];
            modelo = modelos[(int) (Math.random()*15)];
            potencia = (int) (Math.random()*400 + 100);

            tipo = (Math.random() >= 0.5) ? TipoMotociclo.DESPORTIVO : TipoMotociclo.ESTRADA;
            this.viaturas.add(new Motociclo(matricula, marca, modelo, potencia, tipo));
        }

        // TODO: Generate Taxi
        int numeroQuadro;
        int quantidadeBagageira;
        int numeroLicenca;

        for(int i = 1; i <= numberEachGeneration; i++){
            matricula = letras[(int) (Math.random() * 26)]+letras[(int) (Math.random() * 25)]+"-"
                    +numeros[(int) (Math.random()*10)]+numeros[(int) (Math.random()*10)]+"-"
                    +letras[(int) (Math.random() * 26)]+letras[(int) (Math.random() * 25)];
            marca = marcas[(int) (Math.random()*15)];
            modelo = modelos[(int) (Math.random()*15)];
            potencia = (int) (Math.random()*400 + 100);

            numeroQuadro = (int) (Math.random()*500);
            quantidadeBagageira = (int) (Math.random()*10);
            numeroLicenca = (int) (Math.random()*400 + 100);
            this.viaturas.add(new Taxi(matricula, marca, modelo, potencia, numeroQuadro, quantidadeBagageira, numeroLicenca));
        }

        // TODO: Generate Eletrico
        int autonomia;

        for(int i = 1; i <= numberEachGeneration; i++){
            matricula = letras[(int) (Math.random() * 26)]+letras[(int) (Math.random() * 25)]+"-"
                    +numeros[(int) (Math.random()*10)]+numeros[(int) (Math.random()*10)]+"-"
                    +letras[(int) (Math.random() * 26)]+letras[(int) (Math.random() * 25)];
            marca = marcas[(int) (Math.random()*15)];
            modelo = modelos[(int) (Math.random()*15)];
            potencia = (int) (Math.random()*400 + 100);

            numeroQuadro = (int) (Math.random()*500);
            quantidadeBagageira = (int) (Math.random()*10);
            autonomia = (int) (Math.random()*100 + 1);
            this.viaturas.add(new Eletrico(matricula, marca, modelo, potencia, numeroQuadro, quantidadeBagageira, autonomia));
        }

        // TODO: Generate Pesado Mercadorias

        // int numeroQuadro; already declared
        double peso;
        int cargaMax;

        for(int i = 1; i <= numberEachGeneration; i++){
            matricula = letras[(int) (Math.random() * 26)]+letras[(int) (Math.random() * 25)]+"-"
                    +numeros[(int) (Math.random()*10)]+numeros[(int) (Math.random()*10)]+"-"
                    +letras[(int) (Math.random() * 26)]+letras[(int) (Math.random() * 25)];
            marca = marcas[(int) (Math.random()*15)];
            modelo = modelos[(int) (Math.random()*15)];
            potencia = (int) (Math.random()*400 + 100);

            numeroQuadro = (int) (Math.random()*500);
            peso =  UserInput.roundPrecision(Math.random() + 1,2);
            cargaMax = (int) (Math.random()*40000 + 100);
            this.viaturas.add(new PesadoMercadorias(matricula, marca, modelo, potencia, numeroQuadro, peso, cargaMax));
        }

        // TODO: Generate Pesado Passageiros

        // int numeroQuadro;  // already declared
        // double peso;       // already declared
        int numeroMaxPassageiros;

        for(int i = 1; i <= numberEachGeneration; i++){
            matricula = letras[(int) (Math.random() * 26)]+letras[(int) (Math.random() * 25)]+"-"
                    +numeros[(int) (Math.random()*10)]+numeros[(int) (Math.random()*10)]+"-"
                    +letras[(int) (Math.random() * 26)]+letras[(int) (Math.random() * 25)];
            marca = marcas[(int) (Math.random()*15)];
            modelo = modelos[(int) (Math.random()*15)];
            potencia = (int) (Math.random()*400 + 100);

            numeroQuadro = (int) (Math.random()*500);
            peso =  UserInput.roundPrecision(Math.random() + 1,2);
            numeroMaxPassageiros = (int) (Math.random()*500 + 100);
            this.viaturas.add(new PesadoPassageiros(matricula, marca, modelo, potencia, numeroQuadro, peso, numeroMaxPassageiros));
        }

        // TODO: Generate Pesado Eletrico

        // int numeroQuadro;         // already declared
        // double peso;              // already declared
        // int numeroMaxPassageiros; // already declared

        for(int i = 1; i <= numberEachGeneration; i++){
            matricula = letras[(int) (Math.random() * 26)]+letras[(int) (Math.random() * 25)]+"-"
                    +numeros[(int) (Math.random()*10)]+numeros[(int) (Math.random()*10)]+"-"
                    +letras[(int) (Math.random() * 26)]+letras[(int) (Math.random() * 25)];
            marca = marcas[(int) (Math.random()*15)];
            modelo = modelos[(int) (Math.random()*15)];
            potencia = (int) (Math.random()*400 + 100);

            numeroQuadro = (int) (Math.random()*500);
            peso =  UserInput.roundPrecision(Math.random() + 1,2);
            numeroMaxPassageiros = (int) (Math.random()*500 + 100);
            autonomia = (int) (Math.random()*100 + 1);
            this.viaturas.add(new PesadoPassageirosEletrico(matricula, marca, modelo, potencia, numeroQuadro, peso, numeroMaxPassageiros, autonomia));
        }

    }

    // TODO: Imprimir todas as viaturas

    public void imprimirViaturas() {
        if (this.viaturas.size() > 0) {
            System.out.println("\n------ Viaturas da Empresa ------\n");
            for (int i = 0; i < this.viaturas.size(); i++) {
                System.out.println("[" + i + "] " + String.format("%-26s", this.viaturas.get(i).getClass().getSimpleName()) + ": " + this.viaturas.get(i));

            }
        }
    }
    public void imprimirViaturas(String Titulo) {
        if(this.viaturas.size() > 0){
            System.out.println("\n------ "+Titulo+" ------\n");
            for(int i = 0; i < this.viaturas.size(); i++){
                System.out.println("["+i+"] "+String.format("%-26s",this.viaturas.get(i).getClass().getSimpleName())+": "+this.viaturas.get(i));
            }
        }
    }

    // Getters

    public ArrayList<VeiculosMotorizados> getViaturas() {
        return this.viaturas;
    }
}
