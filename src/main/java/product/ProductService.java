package product;

import java.util.HashMap;
import java.util.Map;

public interface ProductService {

    Map<String, Product> productMap = new HashMap<>();

    public static Map<String,Product> getAll(){

        productMap.put("Meat",new Product("Meat",257,"Eat","отсутствует",0));
        productMap.put("Bread",new Product("Bread",25,"Eat","в наличии",0));
        productMap.put("Water",new Product("Water",156,"Drink","в наличии",10));
        productMap.put("Vine",new Product("Vine",300,"Drink","В наличии",6));

        return productMap;

    }

    public static Product add(Product product){
        productMap.put(product.getName(), product);
        return product;
    }
}

