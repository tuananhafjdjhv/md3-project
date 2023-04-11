package ra.view;

import ra.config.Config;
import ra.controller.CartController;
import ra.controller.UserController;
import ra.dto.reponse.ResponseMessage;
import ra.dto.request.SingInDTO;
import ra.dto.request.SingUpDTO;
import ra.model.Role;
import ra.model.RoleName;
import ra.model.User;
import ra.validate.Validate;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserView {
    UserController userController = new UserController();
    List<User> userList = userController.getListUser();

    public void formRegister() {

        SingUpDTO sing1 = new SingUpDTO();
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
        String email = "";
        while (true){
           email =  Config.scanner().nextLine();
            if (!Validate.validate(email)){
                System.err.println("email ko đúng định dang!");
                System.err.println("Hãy nhập lại");
            } else {
                sing1.setEmail(email);
                break;
            }
        }
        System.out.println("Nhập password:");
        String password = Config.scanner().nextLine();
        System.out.println("Nhập quyền role: ");
        String role = Config.scanner().nextLine();
        Set<String> strRole = new HashSet<>();
        strRole.add(role);
        SingUpDTO sing = new SingUpDTO(id, name, username, email, password, strRole);
        ResponseMessage responseMessage = userController.register(sing);
//        System.err.println("Tên tài khoản đã tồn tại " + responseMessage.getMessage());
        if (responseMessage.getMessage().equals("user_existed")) {
            System.err.println("user_existed");
            username = Config.scanner().nextLine();
            sing.setUsername(username);
            formRegister();
        } else if (responseMessage.getMessage().equals("email_existed")) {
            System.err.println("email_existed");
            email = Config.scanner().nextLine();
            sing.setEmail(email);
            formRegister();
        } else if (responseMessage.getMessage().equals("created_success")) {
            formLogin();
        }

    }

    public User getUserLogin() {
        return userController.getUserLogin();
    }

    public void formLogin() {
        SingInDTO sing = new SingInDTO();
        System.out.println("--------Login-------");
        System.out.println("Nhập UserName:");
        sing.setUserName(Config.scanner().nextLine());
        System.out.println("Nhập mật khẩu:");
        sing.setPassword(Config.scanner().nextLine());

        ResponseMessage message = userController.login(sing);

        if (message.getMessage().equals("Login Success")) {
            User userLogin = getUserLogin();
            if (userLogin != null) {
                Set<Role> roleSet = userLogin.getRoles();
                List<Role> roleList = new ArrayList<>(roleSet);
                if (roleList.get(0).getName() == RoleName.ADMIN) {
                    new NavBar().admin();
                } else {
                    new NavBar().user();
                }
            }
            new NavBar().loginRegister();
        } else {
            System.err.println("TÀi khoản hoặc Mật khẩu sai!! Vui  lòng nhập lại");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            formLogin();
        }
    }

    public void showListUser() {
        System.out.println(userController.getListUser());
        System.out.println("Enter back to return Login Register: ");
        String back = Config.scanner().nextLine();
        if (back.equalsIgnoreCase("back")) {
            new NavBar().admin();
        }
    }

    public void updateUser() {
        User userLogin = getUserLogin();
        System.out.println("Nhập tên tài khoản: ");
        userLogin.setUserName(Config.scanner().nextLine());
        System.out.println("Nhập password: ");
        userLogin.setPassword(Config.scanner().nextLine());
        userController.save(userLogin);
        userController.updateUserLogin(userLogin);
        System.out.println("Update thành công");
    }

    public void logOut() {
        userController.logOut();
        new NavBar().loginRegister();
    }

    public void changUserStatus() {
        System.out.println(userController.getListUser());
        System.out.println("Nhập id cần block: ");
        int id = Config.scanner().nextInt();
        userController.changeUser(id);
        System.out.println("Block thành công!!");
    }
}
