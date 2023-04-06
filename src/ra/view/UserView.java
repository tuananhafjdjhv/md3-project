package ra.view;

import ra.config.Config;
import ra.controller.UserController;
import ra.dto.reponse.ResponseMessage;
import ra.dto.request.SingInDTO;
import ra.dto.request.SingUpDTO;
import ra.model.Role;
import ra.model.RoleName;
import ra.model.User;
import sun.applet.Main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserView {
    UserController userController = new UserController();
    List<User> userList = userController.getListUser();

    public void formRegister() {
        System.out.println("size------>" + userList.size());
        int id = 0;
        if (userList.size() == 0 || userList == null) {
            id = 1;
        } else {
            id = userList.get(userList.size() - 1).getId() + 1;
        }
        System.out.println("Nhập name:");
        String name = Config.scanner().nextLine();
        System.out.println("Nhập username:");
        String username = Config.scanner().nextLine();
        System.out.println("Nhập email:");
        String email = Config.scanner().nextLine();
        System.out.println("Nhập password:");
        String password = Config.scanner().nextLine();
        System.out.println("Nhập quyền role: ");
        String role = Config.scanner().nextLine();
        Set<String> strRole = new HashSet<>();
        strRole.add(role);
        SingUpDTO sing = new SingUpDTO(id, name, username, email, password, strRole);
            System.out.println("chay quay lai-->" + sing);
            ResponseMessage responseMessage = userController.register(sing);
            System.out.println("reponse Messeger " + responseMessage.getMessage());
            if (responseMessage.getMessage().equals("user_existed")) {
                username = Config.scanner().nextLine();
                sing.setUsername(username);
            } else if (responseMessage.getMessage().equals("email_existed")) {
                System.out.println("email existed");
                email = Config.scanner().nextLine();
                sing.setEmail(email);
            } else if (responseMessage.getMessage().equals("created_success")) {
                formLogin();
            }

    }
    public User getUserLogin(){
        return userController.getUserLogin();
    }

    public void formLogin() {

        System.out.println("--------Login-------");
        System.out.println("Nhập UserName:");
        String userName = Config.scanner().nextLine();
        System.out.println("Nhập mật khẩu:");
        String password = Config.scanner().nextLine();
        SingInDTO sing = new SingInDTO(userName, password);
        ResponseMessage message = userController.login(sing);
        User userLogin = getUserLogin();
        if (userLogin!=null) {
            if (message.getMessage().equals("Login Success")){
                Set<Role> roleSet = userLogin.getRoles();
                List<Role> roleList = new ArrayList<>(roleSet);
                if (roleList.get(0).getName()== RoleName.ADMIN){
                    NavBar.admin();
                }else {
                   new NavBar().user();
                }
            }
        } else {
            System.err.println("tên đăng nhập hoặc mật khẩu sai!!");
                NavBar.LoginRegister();
        }
//        System.out.println("Nhập back để về Login Register: ");
//        String back = Config.scanner().nextLine();
//        if (back.equalsIgnoreCase("back")) {
//            NavBar.LoginRegister();
//        }
    }

    public void showListUser() {
        System.out.println(userController.getListUser());
        System.out.println("Enter back to return Login Register: ");
        String back = Config.scanner().nextLine();
        if (back.equalsIgnoreCase("back")) {
            NavBar.LoginRegister();
        }
    }
    public void updateUser(){

    }
    public  void logOut(){

    }
}
