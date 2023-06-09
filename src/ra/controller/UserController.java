package ra.controller;

import ra.InputMethod;
import ra.config.Config;
import ra.dto.reponse.ResponseMessage;
import ra.dto.request.SingInDTO;
import ra.dto.request.SingUpDTO;
import ra.model.Role;
import ra.model.RoleName;
import ra.model.User;
import ra.service.IRoleService;
import ra.service.RoleServiceIMPL;
import ra.service.IUserService;
import ra.service.UserServiceIMPl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserController {
    private IUserService userService = new UserServiceIMPl();
    private IRoleService roleService = new RoleServiceIMPL();
    public ResponseMessage login(SingInDTO signin) {
        if (userService.checkLogin(signin.getUserName(), signin.getPassword())){
            return new ResponseMessage("Login Success");
        }else {
            return new ResponseMessage("Login Fail");
        }

    }
    public ResponseMessage register(SingUpDTO singup){
        if (userService.existedByUsername(singup.getUsername())){
            return new ResponseMessage("user_existed");
        }
        if (userService.existedByEmail(singup.getEmail())){
            return new ResponseMessage("email_existed");
        }
        Set<String> strRole = singup.getStrRole();
        Set<Role> roleSet = new HashSet<>();
        strRole.forEach(role -> {
            switch (role){
                case "1912":
                    roleSet.add(roleService.FindByName(RoleName.ADMIN));
                    break;
                case "mobile":
                    roleSet.add(roleService.FindByName(RoleName.USER));
                    break;
                default:
                    break;
            }
        });
        User user = new User(singup.getId(), singup.getName(), singup.getUsername(), singup.getEmail(), singup.getPassword(),roleSet);
        userService.save(user);
        return new ResponseMessage("created_success");
    }
    public List<User> getListUser(){
        return userService.findAll();
    }
    public User getUserLogin(){
        return userService.getCurentUser();
    }
    public void logOut()  {
        userService.logOut();
    }
    public void updateUserLogin(User user){
        userService.updateUserLogin(user);
    }
    public void save(User user) {
        userService.save(user);
    }
    public boolean changeUser(int id){
       return userService.changeUser(id);
    }
}
