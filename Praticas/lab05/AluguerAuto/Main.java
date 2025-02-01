/**
 * @ Author: Pedro Pinto (pmap@ua.pt) & Guilherme Santos (gui.santos91@ua.pt)
 * @ Create Time: 2024-03-18
 */


package AluguerAuto;

import AluguerAuto.Pesado.PesadoPassageirosEletrico;

public class Main {
    public static void main(String[] args){
        // TODO: Funcao para testar, onde criei aleatoriamente viaturas e testei metodos

        EmpresaViaturas empresaViaturas = new EmpresaViaturas("Pedro Company","3770-059","company@ua.pt");
        System.out.println(empresaViaturas);

        // TODO: Gera 1 viatura de cada tipo
        empresaViaturas.generateRandom(5);

        // Default print
        empresaViaturas.imprimirViaturas();

        // TODO: Ordenar por marca
        empresaViaturas.ordenarPorMarca();
        empresaViaturas.imprimirViaturas("Viaturas por Marca");

        // TODO: Ordenar por potencia
        empresaViaturas.ordenarPorPotencia();
        empresaViaturas.imprimirViaturas("Viaturas por Potencia");

        // TODO: O que tem mais potencia vai percorrer 100 km
        empresaViaturas.getViaturas().get(0).trajeto(100);
        System.out.println("\nCarro com mais potencia: " + empresaViaturas.getViaturas().get(0).getClass().getSimpleName() +": "+ empresaViaturas.getViaturas().get(0));


        // TODO: Ordenar por distancia percorrida
        empresaViaturas.ordenarPorDistanciaPercorrida();
        empresaViaturas.imprimirViaturas("Viaturas por Distancia Percorrida");

        // TODO: Limpar as viaturas da empresa
        empresaViaturas.removerTodasViaturas();

        // TODO: Adicionar um ligeiro eletrico (autonomia = 25%) e adicionar autonomia (simular carregamento até 60%)
        empresaViaturas.adicionarViatura(new PesadoPassageirosEletrico("AA-77-BB","BMW","z8",700,2500,0,25,25));
        PesadoPassageirosEletrico viaturaPassageirosEletrico = (PesadoPassageirosEletrico) empresaViaturas.getViaturas().get(0);
        System.out.println("\nViatura de Passageiros eletrica: " + empresaViaturas.getViaturas().get(0).getClass().getSimpleName() +": "+ empresaViaturas.getViaturas().get(0));
        viaturaPassageirosEletrico.carregar(60); // 'Até 60%'
        System.out.println("Carregado até 60% --> autonomia="+ ((PesadoPassageirosEletrico) empresaViaturas.getViaturas().get(0)).autonomia());

        // TODO: Remover uma viatura especifica
        empresaViaturas.removerViatura(viaturaPassageirosEletrico);

        // Final print
        empresaViaturas.imprimirViaturas(); // ! não imprime nada porque não tem viaturas
    }
}
