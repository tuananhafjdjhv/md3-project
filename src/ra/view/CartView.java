package ra.view;

import ra.InputMethod;
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
//        System.out.println("Đây là list cart");
        float total = 0;
        if (listCartItems.size() > 0) {
            for (CartItem cartitem : listCartItems) {
                total+= cartitem.getProduct().getPrice()*cartitem.getQuantity();
                System.out.printf("{product: %s , quantity : %d} \n",cartitem.getProduct(),cartitem.getQuantity());
            }
        } else {
            System.err.print("\n" +
                    "Hiện tại không có sản phẩm nào trong giỏ hàng của bạn!" +
                    " Hãy thêm vào nhé!");
        }
        System.out.println("Tổng tiền : " +total+" USD");

    }
    public void addCartItem(){
        System.out.println("Nhập id sản phẩm muốn thêm: ");
        Product product = productController.findById(InputMethod.getInteger());
        if (product == null) {
            System.err.println("Id không có! ");
            addCartItem();
        }else {
            System.out.println("Nhập số lượng: ");
            int quantity = InputMethod.getInteger();
            CartItem  newCartItem = new CartItem(product,quantity);
            cartController.addToCart(newCartItem);
            System.out.println("Thêm vào giỏ hàng thành công!");
        }
    }
    public void deleteCartItem(){
        System.out.println("Nhập id cần xóa trong giỏ hàng: ");
       int id = InputMethod.getInteger();
        cartController.deleteCartItem(id);
    }
}
