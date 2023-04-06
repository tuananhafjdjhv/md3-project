package ra.view;

import ra.config.Config;
import ra.controller.CategoryController;
import ra.controller.ProductController;
import ra.model.Category;
import ra.model.Product;

import java.util.List;

public class ProductView {
    private static ProductController productController = new ProductController();
    private static CategoryController categoryController = new CategoryController();
    List<Product> productList = productController.showProduct();

    public void showProduct() {
        System.out.println("=================Product Management=======================");
        for (Product product : productList) {
            System.out.println(product);
        }
    }

    private static List<Product> getList() {
        return productController.showProduct();
    }

    public void createProduct() {
        Product product = new Product();
        if (getList().size() == 0) {
            product.setProductId(1);
        } else {
            product.setProductId(getList().get(getList().size() - 1).getProductId() + 1);
        }
        System.out.println(" Enter the name ");
        product.setProductName(Config.scanner().nextLine());
        for (Category category : categoryController.getListCategory()) {
            System.out.println(category);
        }
        System.out.println("Enter select category by id");
        int id = Config.scanner().nextInt();
        product.setCategory(categoryController.detailCategory(id));
        System.out.println("Enter the price");
        product.setPrice(Config.scanner().nextFloat());
        System.out.println("Enter the status: ");
        product.setProductStatus(Config.scanner().hasNextBoolean());
        productController.createProduct(product);
    }

    public void formUpdateProduct() {
        System.out.println("Enter the id");
        int id = Config.scanner().nextInt();
        Product product = productController.findById(id);
        if (product == null) {
            System.err.println("Id not found");
        } else {
            System.out.println("Enter new name");
            product.setProductName(Config.scanner().nextLine());
            System.out.println("Enter new price");
            product.setPrice(Config.scanner().nextFloat());
            System.out.println("Enter new status");
            product.setProductStatus(Config.scanner().nextBoolean());
            for (Category category : categoryController.getListCategory()) {
                System.out.println(category);
            }
            System.out.println("Enter select category by id");
            int idCategory = Config.scanner().nextInt();
            product.setCategory(categoryController.detailCategory(idCategory));
            productController.updateProduct(product);
            System.out.println("Update Success!");
            System.out.println("Enter the any key to continue or Enter back to return Menu: ");

        }

    }

    public void formDeleteProduct() {
        System.out.println("Enter id product want to delete");
        int idDelete = Config.scanner().nextInt();
        if (productController.findById(idDelete) == null) {
            System.err.println("Id not found");
        } else {
            productController.deleteProductById(idDelete);
            System.out.println("Delete success!");
        }

    }

    public void formSearchProduct() {
        System.out.println("Enter product name to search");
        String searchName = Config.scanner().nextLine();
        List<Product> listSearch = productController.searchProductByName(searchName);
        if (listSearch.size() == 0) {
            System.out.println("Product not match");
        } else {
            for (Product product : listSearch) {
                System.out.println(product);
            }
        }
    }
}
