package cl.martin.joaquin.services;

import cl.martin.joaquin.entities.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService {

    public List<Product> fetchProductsByCategory(){
        Product product1 = new Product();
        Product product2 = new Product();
        product1.setName("Joaquín");
        product2.setName("Martín");
        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);
        return products;
    }
}
