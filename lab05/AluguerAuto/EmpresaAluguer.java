package AluguerAuto;

import AluguerAuto.Motociclo.TipoMotociclo;

public class EmpresaAluguer { 
    public static void main(String[] args) { 
 
        EmpresaViaturas r = new EmpresaViaturas("Rental", "1234-567", "a@ua.pt"); 
        r.adicionarViatura(VehicleFactory.createMotociclo("00-AB-12", "Honda", "CBR 600", 100, TipoMotociclo.DESPORTIVO)); 
        r.adicionarViatura(VehicleFactory.createAutomovelLigeiro("22-CD-34", "Volkswagen", "Golf", 110, 123456789, 350)); 
        r.adicionarViatura(VehicleFactory.createTaxi("44-EF-56", "Mercedes-Benz", "E-Class", 150, 123456789, 400, 123)); 
        r.adicionarViatura(VehicleFactory.createPPEletrico("77-HI-89", "Tesla", "Model X", 500, 123456789, 50, 100, 200)); 
        r.adicionarViatura(VehicleFactory.createALEletrico("88-IJ-90", "Tesla", "Model 3", 500, 123456789, 500, 1000)); 
        r.adicionarViatura(VehicleFactory.createPesadoMercadorias("66-GH-78", "Volvo", "FH", 500, 123456789, 20000, 40000)); 
        r.adicionarViatura(VehicleFactory.createPesadoPassageiros("99-JK-00", "Volvo", "FH", 500, 2000, 123456789, 50)); 
 
        for(VeiculosMotorizados v : r.getViaturas()){ 
            System.out.println(v); 
        } 
    } 
}