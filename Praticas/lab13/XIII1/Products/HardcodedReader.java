package Products;

import java.util.ArrayList;
import java.util.List;

public class HardcodedReader implements ProductsReader {
    private List<Product> list = new ArrayList<>(List.of(new Car("321", "hardcoded", 24)));

    @Override
    public List<Product> importFromProductsReader() {
        return this.list;
    }
    
}
