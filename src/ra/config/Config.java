package ra.config;

import ra.controller.UserController;
import ra.model.Role;
import ra.model.RoleName;
import ra.model.User;
import ra.view.NavBar;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class  Config<T> {
    public static Scanner scanner(){
        Scanner scanner = new Scanner(System.in);
        return scanner;
    }

    public static final String PATH_CART ="C:\\Users\\Thu Nguyen\\Desktop\\JAVA\\MVC-Demo-CRUD-Product\\src\\ra\\DataBase\\cart.txt";
    public static final String PATH_CATEGORY="C:\\Users\\Thu Nguyen\\Desktop\\JAVA\\MVC-Demo-CRUD-Product\\src\\ra\\DataBase\\category.txt";
    public static final String PATH_PRODUCT = "C:\\Users\\Thu Nguyen\\Desktop\\JAVA\\MVC-Demo-CRUD-Product\\src\\ra\\DataBase\\product.txt";
    public static final String PATH_USER = "C:\\Users\\Thu Nguyen\\Desktop\\JAVA\\MVC-Demo-CRUD-Product\\src\\ra\\DataBase\\user.txt";
    public static final String PATH_CURRENT_USER ="C:\\Users\\Thu Nguyen\\Desktop\\JAVA\\MVC-Demo-CRUD-Product\\src\\ra\\DataBase\\currentuser.txt";
    public List<T> readFromFile(String pathFile) {
        List<T> tList = new ArrayList<>();
        try {
            File file = new File(pathFile);
            if (file.exists()){
                FileInputStream fileInputStream = new FileInputStream(pathFile);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                tList = (List<T>) objectInputStream.readObject();
                fileInputStream.close();
                objectInputStream.close();
            }

        } catch (FileNotFoundException f) {
            System.err.println("File not Found!");
        }catch (IOException i) {
            System.err.println("IOE exception");
        } catch (ClassNotFoundException c) {
            System.err.println("Class not Found!");
        }
        return tList;
    }

    // phuong thuc ghi file
    public void writeToFile(String pathFile, List<T> tList) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(pathFile);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(tList);
            fileOutputStream.close();
            objectOutputStream.close();
        }catch (FileNotFoundException f){
            System.err.println("File not Found!");
        }catch (IOException i){
            System.err.println("IOE exception!");
        }
    }
//    public void deleteFile(String pathCurrentUser){
//        try {
//            PrintWriter pw = new PrintWriter(Config.PATH_CURRENT_USER,pathCurrentUser);
//            pw.close();
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//    public void changeRole(){
//        User userLogin = getUserLogin();
//        if (userLogin != null) {
//            Set<Role> roleSet = userLogin.getRoles();
//            List<Role> roleList = new ArrayList<>(roleSet);
//            if (roleList.get(0).getName() == RoleName.ADMIN) {
//                new NavBar().admin();
//            } else {
//                new NavBar().user();
//            }
//        }
//    }
//    public User getUserLogin() {
//        return userController.getUserLogin();
//    }
//    UserController userController = new UserController();

}
