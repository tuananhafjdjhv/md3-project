package ra.view;

import ra.config.Config;

public class NavBar {
    public void admin() {
        System.out.println("1.Show category");
        System.out.println("2. Show List Product");
        System.out.println("3. Show List User");
        System.out.println("4. Create Product");
        System.out.println("5. Update Product");
        System.out.println("6. Delete Product");
        while (true) {
            int choice = Config.scanner().nextInt();
            switch (choice) {
                case 1:
                    new CategoryView().showFormCategoryList();
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

    public static void productManager() {
        while (true) {
            System.out.println("=====================Product Management===============================");
            System.out.println("1.Show List Product");
            System.out.println("2.Create Product");
            System.out.println("3.Update Product");
            System.out.println("4.Delete Product");
            System.out.println("5.Search Product");
            System.out.println(" nhap lua chon: ");
            int chooseMenu = Config.scanner().nextInt();
            switch (chooseMenu) {
                case 1:
                    new ProductView().showProduct();
                    break;
                case 2:
                    new ProductView().createProduct();
                    break;
                case 3:
                    new ProductView().formUpdateProduct();
                    break;
                case 4:
                    new ProductView().formDeleteProduct();
                    break;
                case 5:
                    new ProductView().formSearchProduct();
                    break;
            }
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