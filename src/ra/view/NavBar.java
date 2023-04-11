package ra.view;

import ra.config.Config;
import ra.controller.UserController;
import ra.model.Role;
import ra.model.RoleName;
import ra.model.User;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NavBar {
    public void user() {
        while (true) {
            System.out.println("1.Show List Product");
            System.out.println("2.Search Product");
            System.out.println("3.Add to cart");
            System.out.println("4.Show your cart");
            System.out.println("5.Update user");
            System.out.println("6.Log Out");
            System.out.println("7. Delete Cart Item");
            int choice = Config.scanner().nextInt();
            switch (choice) {
                case 1:
                   new ProductView().showProduct();
                    break;
                case 2:
                    new ProductView().formSearchProduct();
                    break;
                case 3:
                    new CartView().addCartItem();
                    break;
                case 4:
                    new CartView().showCart();
                    break;
                case 5:
                    new UserView().updateUser();
                    break;
                case 6:
                    new UserView().logOut();
                    break;
                case 7:
                   new CartView().deleteCartItem();
                    break;
                default:
                    break;
            }
        }


    }

    public void admin() {
        while (true) {
            System.out.println("1. Category");
            System.out.println("2. Show List Product");
            System.out.println("3. Show List User");
            System.out.println("4. Create Product");
            System.out.println("5. Update Product");
            System.out.println("6. Delete Product");
            System.out.println("7. Đăng xuất");
            System.out.println("8. Block người dùng: ");

            int choice = Config.scanner().nextInt();
            switch (choice) {
                case 1:
                    new NavBar().navBar();
                    break;
                case 2:
                   new ProductView().showProduct();
                    break;
                case 3:
                    new UserView().showListUser();
                    break;
                case 4:
                    new ProductView().createProduct();
                    break;
                case 5:
                    new ProductView().formUpdateProduct();
                    break;
                case 6:
                    new ProductView().formDeleteProduct();
                    break;
                case 7:
                    new UserView().logOut();
                    break;
                case 8:
                    new UserView().changUserStatus();
                default:
                    break;
            }
        }

    }


    public void navBar() {
        System.out.println("*************************CATEGORY MANAGER*****************************");
        while (true){
            System.out.println("1.Show List Category");
            System.out.println("2.Create Category");
            System.out.println("3.Update Category");
            System.out.println("4.Delete Category");
            System.out.println("5.Back");
            int chooseMenu = Config.scanner().nextInt();
            switch (chooseMenu) {
                case 1:
                    new CategoryView().showFormCategoryList();
                    break;
                case 2:
                    new CategoryView().formCreateCategory();
                case 3:
                    new CategoryView().formUpdateCategory();
                case 4:
                    new CategoryView().formDeleteCategory();
                case 5:
                    admin();
                default:
                    break;
            }
        }

    }

    public static void loginRegister() {

        while (true) {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3.Show Lít Product");
            int chooseMenu = Config.scanner().nextInt();
            switch (chooseMenu) {
                case 1:
                    new UserView().formRegister();
                    break;
                case 2:
                    new UserView().formLogin();
                    break;
                case 3:
                   new  ProductView().showProduct();
                    break;
                default:
                    System.err.println("Nhập sai rồi");
                    break;
            }
        }
    }
}