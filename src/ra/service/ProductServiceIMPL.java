package ra.service;

import ra.config.Config;
import ra.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceIMPL implements IProduct{
     List<Product> productList = new Config<Product>().readFromFile(Config.PATH_PRODUCT);
    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public void save(Product product) {
        if (findByID(product.getProductId())==null){
            productList.add(product);
        }else{
            productList.set(productList.indexOf(product), product);
        }
        new Config<Product>().writeToFile(Config.PATH_PRODUCT,productList);
    }

    @Override
    public Product findByID(int id) {
        for (Product product:productList
             ) {
            if (id==product.getProductId()){
                return product;
            }
        }
        return null;
    }

    @Override
    public void deleteById(int id) {
        productList.remove(findByID(id));
        new Config<Product>().writeToFile(Config.PATH_PRODUCT,productList);
    }
    public List<Product> searchProductByName(String nameProduct)
    {
        List<Product> productListSearch = new ArrayList<Product>();
        for (Product product : productList) {
            if (product.getProductName().toLowerCase().contains(nameProduct.toLowerCase())){
                productListSearch.add(product);
            }
        }
     return productListSearch;
    }
}
