package ra.controller;

import ra.model.Product;
import ra.service.ProductServiceIMPL;

import java.util.List;

public class ProductController {
    private static ProductServiceIMPL productService = new ProductServiceIMPL();
    public List<Product> showProduct(){
        List<Product> productList = productService.findAll();
        return productList;
    }
    public void createProduct(Product product){
        productService.save(product);
    }
    public void updateProduct(Product product){
        productService.save(product);
    }

    public Product findById(int id){
        return productService.findByID(id);
    }
    public void deleteProductById(int id) {
        productService.deleteById(id);
    }
    public List<Product> searchProductByName(String name){
     return productService.searchProductByName(name);
    }
}
