package ra.service;

import ra.config.Config;
import ra.model.Cart;
import ra.model.CartItem;
import ra.model.User;

import java.util.ArrayList;
import java.util.List;

public class CartServiceIMPL implements  ICartService{
    private User user = new UserServiceIMPl().getCurentUser();
    private List<Cart> listCart = new Config<Cart>().readFromFile(Config.PATH_CART);
    @Override
    public boolean addToCart(CartItem cartItem) {
        Cart carts = findByID(user.getId());
        if (carts != null) {
            for (CartItem cart : carts.getListCartItem()) {
                if (cart.getProduct().getProductId() ==cartItem.getProduct().getProductId()) {
                    cart.setQuantity(cart.getQuantity() + cartItem.getQuantity());
                    save(carts);
                    return true;
                }
            }
            List<CartItem> cartItemList = carts.getListCartItem();
            cartItemList.add(cartItem);
            carts.setListCartItem(cartItemList);
            save(carts);
            return true;
        }else {
            List<CartItem>  listCartItems= new ArrayList<>();
            listCartItems.add(cartItem);
            Cart newCart = new Cart(user,listCartItems);
            save(newCart);
            return true;
        }
    }

    @Override
    public User getUserLogin() {
        return user;
    }

    @Override
    public List<Cart> findAll() {
        return listCart;
    }

    @Override
    public void save(Cart cart) {
        boolean check = false;
        for (int i = 0; i < listCart.size() ; i++) {
            if (listCart.get(i).getUser().equals(cart.getUser())){
                listCart.set(i,cart);
                check = true;
                break;
            }
        }
        if (!check) {
            listCart.add(cart);
        }
        new Config<Cart>().writeToFile(Config.PATH_CART,listCart);
    }

    @Override
    public Cart findByID(int id) {

        for (Cart cart : listCart) {
            System.out.println(cart);
            if(cart.getUser().getId()== id){
                return cart;
            }
        }
        return null;
    }

    @Override
    public void deleteById(int id) {

    }
}
