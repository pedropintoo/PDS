import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Map.Entry;
import Products.Product;
import Products.ProductsReader;

public class ToShare implements Iterable<Product> {
    private Map<String, Queue<Client>> clientsStructure;
    private Map<String, Product> listProducts;
    private ProductsReader pReader;

    public ToShare() {
        this.clientsStructure = new HashMap<>();
        this.listProducts = new HashMap<>();
    }

    public void add(Product product) {
        listProducts.put(product.code(), product);
    }

    public List<Product> getProducts() {
        List<Product> sorted =  new ArrayList<>(this.listProducts.values());
        sorted.sort(Comparator.comparingDouble(Product::points).reversed());
        return sorted;
    }

    public boolean share(String code, Client client) {
        Queue<Client> clientsForProduct = this.clientsStructure.get(code);
        // not check if Product exists!

        if (clientsForProduct == null) {
            clientsForProduct = new LinkedList<>();
            this.clientsStructure.put(code, clientsForProduct);
        }

        clientsForProduct.add(client);
        
        return clientsForProduct.size() == 1;
    }

    public boolean share(Product product, Client client) {
        return share(product.code(), client);
    }

    @Override
    public Iterator<Product> iterator() {
        return this.getProducts().iterator();
    }

    public String sharedProducts() {
        StringBuilder sb = new StringBuilder();
        int total = 0;

        for (Entry<String, Queue<Client>> entry : this.clientsStructure.entrySet()) {
            Client client = entry.getValue().peek();
            
            if (client == null) continue; // not shared!

            Product product = this.listProducts.get(entry.getKey());
            
            sb.append("\n\t");
            sb.append(product.getClass().getSimpleName() + " " + product.code());
            sb.append(" shared with " + client);
            total++;
        }

        return "Total : " + total + sb;
    }

    public boolean giveBack(String code) {
        try {
            this.clientsStructure.get(code).remove();
        } 
        catch (Exception e) {
            return false;
        }
        
        // notify!
        Client currClient = this.clientsStructure.get(code).peek();

        if (currClient != null) {
            currClient.notifyAvailability();
            this.clientsStructure.get(code).forEach(c -> {
                if (!c.equals(currClient)) System.out.println(c);
            });
        }

        return true;
    }

    public boolean giveBack(Product product) {
        return giveBack(product.code());
    }

    public void remove(String code) {
        this.clientsStructure.remove(code);
    }

    public void setProductsReader(ProductsReader pReader) {
        this.pReader = pReader;
    }

    public void importFromProductsReader() {
        List<Product> importedList = this.pReader.importFromProductsReader();

        importedList.forEach(p -> this.listProducts.put(p.code(), p));
    }

}
