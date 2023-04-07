package ra.service;

import ra.model.Cart;
import ra.model.CartItem;
import ra.model.User;

public interface ICartService extends IGenericService<Cart>{
    boolean addToCart (CartItem cartItem);
    User getUserLogin();
}
