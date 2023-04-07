package ra.view;

import ra.config.Config;
import ra.controller.CategoryController;
import ra.model.Category;

import java.util.List;

public class CategoryView {
    CategoryController categoryController = new CategoryController();
    List<Category> categoryList = categoryController.getListCategory();

    public void showFormCategoryList() {
        System.out.println("===============================TABLE CATEGORY =============================");
        System.out.println("======ID======NAME======");
        for (int i = 0; i < categoryList.size(); i++) {
            System.out.println("======" + categoryList.get(i).getId() + "======" + categoryList.get(i).getName()+"=====");
        }
        System.out.println("Nhấn back để quay lại Menu ");
        String backMenu = Config.scanner().nextLine();
        if (backMenu.equalsIgnoreCase("back")) {
           new NavBar().navBar();
        }
    }

    public void formCreateCategory() {

            int id = 0;
            if (categoryList.size() == 0) {
                id = 1;
            } else {
                id = categoryList.get(categoryList.size() - 1).getId()+1;
            }
            System.out.println("Nhập tên Category ");
            String name = Config.scanner().nextLine();
            Category category = new Category(id, name);
            categoryController.createCategoryToDB(category);
            System.out.println("Thêm mới thành công! ");
            System.out.println("Nhấn back hoặc backmenu để quay lại Menu");
            String backMenu = Config.scanner().nextLine();
            if (backMenu.equalsIgnoreCase("back")) {
                new NavBar().navBar();
            }
            if (backMenu.equalsIgnoreCase("backmenu")){
                new NavBar().admin();
            }
    }

    public void formUpdateCategory() {
        while (true) {
            System.out.println("Nhập id: ");
            int id = Config.scanner().nextInt();
            if (categoryController.detailCategory(id) == null) {
                System.err.println("Id không tồn tại ! vui lòng nhập lại");
            } else {
                System.out.println("Nhập name: ");
                String name = Config.scanner().nextLine();
                Category category = new Category(id, name);
                categoryController.updateCategory(category);
                System.out.println("Update Thành công!");
                System.out.println("nhập back để quay lại Menu: ");
                String backMenu = Config.scanner().nextLine();
                if (backMenu.equalsIgnoreCase("back")) {
                    new NavBar().navBar();
                    break;
                }
            }
        }
    }
    public void formDeleteCategory(){
        while (true){
            System.out.println("enter the id to delete");
            int id = Config.scanner().nextInt();
            categoryController.deleteCategory(id);
            System.out.println("nhập back để quay lại Menu: ");
            String backMenu = Config.scanner().nextLine();
            if (backMenu.equalsIgnoreCase("back")) {
              new  NavBar().navBar();
                break;
            }
        }
    }
}
