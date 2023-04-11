package ra.service;

import ra.config.Config;
import ra.model.Cart;
import ra.model.CartItem;
import ra.model.Category;
import ra.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserServiceIMPl implements IUserService {
    List<User> userList = new Config<User>().readFromFile(Config.PATH_USER);
    List<CartItem> cartList = new Config<CartItem>().readFromFile(Config.PATH_CART);
    @Override
    public List<User> findAll() {
        return userList;
    }

    @Override
    public void save(User user) {
        userList.add(user);
         new Config<User>().writeToFile(Config.PATH_USER,userList);
    }

    @Override
    public User findByID(int id) {
        for (User user: userList) {
            if (user.getId() == id) return user;
        }
        System.out.println("khong tim thay user co id nay!");
        return null;
    }

    @Override
    public void deleteById(int id) {
        for (CartItem cartItem : cartList) {
            if (cartItem.getId() == id) {
                cartList.remove(cartItem);
                new Config<CartItem>().writeToFile(Config.PATH_CART,cartList);
                System.out.println("Xóa thành công!!");
                return;
            }
        }
        System.err.println("In not found !");
    }

    @Override
    public boolean existedByUsername(String username) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getUserName().equals(username)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean existedByEmail(String email) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getUserName().equals(email)){
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean checkLogin(String userName, String password){
        List<User> list = new ArrayList<>();
        for (User user:userList) {
            if (user.getUserName().equals(userName) && user.getPassword().equals(password)){
                list.add(user);
                new Config().writeToFile(Config.PATH_CURRENT_USER,list);
                return true;
            }
        }
        return false;
    }
    @Override
    public User getCurentUser() {
        if(new Config<User>().readFromFile(Config.PATH_CURRENT_USER).size()!=0){
            User user = new Config<User>().readFromFile(Config.PATH_CURRENT_USER).get(0);
            return user;
        }
        return null;
    }
    @Override
    public void logOut() {
        List<User> users = new Config<User>().readFromFile(Config.PATH_CURRENT_USER);
        users.remove(0);
        new Config<User>().writeToFile(Config.PATH_CURRENT_USER,users);
//        new Config<User>().deleteFile(Config.PATH_CURRENT_USER);
    }
    @Override
    public void updateUserLogin(User user) {
        List<User> users = new Config<User>().readFromFile(Config.PATH_CURRENT_USER);
        users.set(0,user);
        new Config<User>().writeToFile(Config.PATH_CURRENT_USER,users);
//        new Config<User>().writeToFile(Config.PATH_USER,users);
    }
    @Override
    public boolean changeUser(int id){
        if (findByID(id) == null){
            return false;
        } else {
            for (int i = 0; i < userList.size(); i++) {
                if (userList.get(i).getId() == id ){
                    List<User> users = new Config<User>().readFromFile(Config.PATH_USER);
                    userList.get(i).setStatus(false);
                    new Config<User>().writeToFile(Config.PATH_USER,users);
                }
            }
            return  true;
        }

    }
}
