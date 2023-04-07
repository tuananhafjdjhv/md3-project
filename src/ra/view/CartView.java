package ra.view;

import ra.config.Config;
import ra.controller.CartController;
import ra.controller.ProductController;
import ra.model.CartItem;
import ra.model.Product;

import java.util.List;

public class CartView {

    CartController cartController = new CartController();
    ProductController productController = new ProductController();
    public void showCart(){
        List<CartItem> listCartItems = cartController.getListCartItems();
        System.out.println("Đây là list cart");
        float total = 0;
        for (CartItem cartitem : listCartItems) {
            total+= cartitem.getProduct().getPrice()*cartitem.getQuantity();
            System.out.printf("{product: %s , quantity : %d} \n",cartitem.getProduct(),cartitem.getQuantity());
        }
        System.out.println("Total : " +total);
    }
    public void addCartItem(){
        System.out.println("Enter product id");
        Product product = productController.findById(Config.scanner().nextInt());
        if (product == null) {
            System.err.println("Id not found");
            addCartItem();
        }else {
            System.out.println("Enter quantity");
            int quantity = Config.scanner().nextInt();
            CartItem  newCartItem = new CartItem(product,quantity);
            cartController.addToCart(newCartItem);
            System.out.println("add to cart success");
        }
    }
}
