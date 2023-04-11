package ra.controller;

import ra.model.Cart;
import ra.model.CartItem;
import ra.model.User;
import ra.service.CartServiceIMPL;
import ra.service.ICartService;

import java.util.ArrayList;
import java.util.List;

public class CartController {
    ICartService cartService = new CartServiceIMPL();
    public List<CartItem> getListCartItems(){
        User user = cartService.getUserLogin();
        Cart myCart = cartService.findByID(user.getId()) ;
        if (myCart==null){
            return new ArrayList<CartItem>();
        }
       return myCart.getListCartItem();

    }
    public void addToCart(CartItem cartItem){
        cartService.addToCart(cartItem);
    }
    public void deleteCartItem(int id){
        cartService.deleteById(id);
    }
}
