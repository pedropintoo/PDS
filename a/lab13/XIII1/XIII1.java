
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import Products.Car;
import Products.HardcodedReader;
import Products.Jeep;
import Products.Motorcycle;
import Products.OldJeep;
import Products.Product;
import Products.ProductsReader;
import Products.TextFileReader;
import Products.Van;

// Notas:
// Não altere o código apresentado na alinea 1
// Deve completar o código das alineas 2 e 3
// Pode comentar código para garantir que vai executando parcialmente

public class XIII1{

	public static void main(String[] args) throws FileNotFoundException {
		PrintStream fl = new PrintStream(new File("pds2022.txt"));
		test(System.out); // executa e escreve na consola
		fl.println(System.getProperty("user.dir"));
		fl.println(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()));
		test(fl); // executa e escreve no ficheiro
		fl.close();
	}

	private static void test(PrintStream out) {
		question1(out);
		question2(out);
		question3(out);
	}

	private static void question1(PrintStream out) {
		out.println("\nQuestion 1) ----------------------------------\n");
		ToShare market = new ToShare();
		Product[] cars = {
			new Car("ZA11ZB", "Tesla, Grey, 2021", 100),
			new Van("AA22BB", "Chevrolet Chevy, 2020", 180),
			new Motorcycle("ZA33ZB", "Touring, 750, 2022", 85),
			new Car("BB44ZB", "Ford Mustang, Red, 2021", 150), 
		};
		for (Product item : cars) 
			market.add(item);

		out.println("--- All Products :");
		for (Product item : market.getProducts())
			out.println(item);		
	
		Client u1 = new Client("187", "Peter Pereira");
		Client u2 = new Client("957", "Anne Marques");
		Client u3 = new Client("826", "Mary Monteiro");
		market.share("ZA11ZB", u1);
		market.share(cars[2], u2);
		market.share("BB44ZB", u3);

		out.println("--- Shared Products :\n" + market.sharedProducts());
		market.giveBack(cars[0]);
		market.giveBack("BB44ZB");
		out.println("--- Shared Products :\n" + market.sharedProducts());
		
		market.remove("ZA11ZB");
		OldJeep oj = new OldJeep("JJ0011;Some old SUV;88.5"); // assume "code;description;points"
		market.add(new Jeep(oj));
		out.println("--- All Products :");
		for (Product item : market)
			out.println(item);	
	}

	private static void question2(PrintStream out) {
		out.println("\nQuestion 2 (output example) ----------------------------------\n");
		ToShare market = new ToShare();

		market.setProductsReader(new TextFileReader("products.txt"));
		market.importFromProductsReader();		

		out.println("--- All Products :");
		for (Product p : market) 
			out.println(p);

		market.setProductsReader(new HardcodedReader());
		market.importFromProductsReader();	

		out.println("--- All Products :");
		for (Product p : market) 
			out.println(p);

	}

	private static void question3(PrintStream out) {
		out.println("\nQuestion 3) ----------------------------------\n");
		// Completar

		ToShare shareIt = new ToShare();

		Client u1 = new Client("1", "Pedro");
		Client u2 = new Client("2","João");
		Client u3 = new Client("3","Jorguinho");

		out.println(shareIt.share("UA0001", u1)); // true
		out.println(shareIt.share("UA0001", u2)); // false (já está emprestada)
		out.println(shareIt.share("UA0001", u3));

		out.println(shareIt.giveBack("UA0001")); // true (devolvida por u1, emprestado a u2)
		out.println(shareIt.giveBack("UA0001")); // true (devolvida por u2)
		out.println(shareIt.giveBack("UA0001")); // true (devolvida por u3)

		out.println(shareIt.giveBack("UA0001")); // false
		out.println("--- Repeated output... ---");
	}


}
