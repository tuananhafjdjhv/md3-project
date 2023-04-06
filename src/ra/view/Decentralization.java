package ra.view;

import ra.controller.UserController;
import ra.model.Role;
import ra.model.RoleName;
import ra.model.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Decentralization {
    UserController userController = new UserController();

    public void Decentralization() {
        User user = userController.getUserLogin();
        if (user == null) {
            Set<Role> roleSet = new HashSet<>();
            List<Role> roles = new ArrayList<>(roleSet);
            if (roles.get(0).getName() == RoleName.ADMIN) {
                System.out.println("------------Admin-----------");
                new NavBar().admin();
            } else if (roles.get(0).getName() == RoleName.USER) {
                System.out.println("------người dùng------");

            }
        } else {
            Set<Role> roleSet = new HashSet<>();
            List<Role> roles = new ArrayList<>(roleSet);
            if (roles.get(0).getName() == RoleName.ADMIN) {
                System.out.println("------------Admin-----------");
                new NavBar().admin();
            } else if (roles.get(0).getName() == RoleName.USER) {
                System.out.println("------người dùng------");

            }
        }
    }
}
