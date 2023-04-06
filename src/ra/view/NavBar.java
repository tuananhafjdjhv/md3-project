package ra.view;

import ra.config.Config;
import ra.controller.UserController;
import ra.model.Role;
import ra.model.RoleName;
import ra.model.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NavBar {
    public void user() {

            System.out.println("1.Show List Product");
            System.out.println("2.Search Product");
            System.out.println("3.Add to cart");
            System.out.println("4.Show your cart");
            System.out.println("5.Update user");
            System.out.println("6.Log Out");
            int choice = Config.scanner().nextInt();
            switch (choice) {
                case 1:
                    new ProductView().showProduct();
                    break;
                case 2:
                    new ProductView().formSearchProduct();
                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:
                    new UserView().updateUser();
                    break;
                case 6:
                    new UserView().logOut();
                    break;
                default:
                    break;
            }

    }

    public static void admin() {
        System.out.println("1.Show category");
        System.out.println("2. Show List Product");
        System.out.println("3. Show List User");
        System.out.println("4. Create Product");
        System.out.println("5. Update Product");
        System.out.println("6. Delete Product");

            int choice = Config.scanner().nextInt();
            switch (choice) {
                case 1:
                    NavBar.NavBar();
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
            }
        }


    public static void NavBar() {
        System.out.println("*************************CATEGORY MANAGER*****************************");
        System.out.println("1.Show List Category");
        System.out.println("2.Create Category");
        System.out.println("3.Update Category");
        System.out.println("4.Delete Category");
        System.out.println();
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
        }
    }

    public static void LoginRegister() {

        while (true) {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. ShowList User");
            System.out.println("4.Show Lít Product");
            int chooseMenu = Config.scanner().nextInt();
            switch (chooseMenu) {
                case 1:
                    new UserView().formRegister();
                    break;
                case 2:
                    new UserView().formLogin();
                    break;
                case 3:
                    new UserView().showListUser();
                    break;
                case 4:
                    new ProductView().showProduct();
                    break;
                default:
                    System.out.println("Nhập sai rồi");
                    break;
            }
        }
    }
}