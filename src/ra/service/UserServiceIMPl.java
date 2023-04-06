package ra.service;

import ra.config.Config;
import ra.model.User;

import java.util.List;

public class UserServiceIMPl implements IUserService {
    List<User> userList = new Config<User>().readFromFile(Config.PATH_USER);
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
    public boolean checkLogin(String userName, String password){
        List<User> list = new Config<User>().readFromFile(Config.PATH_USER);
        System.out.println(list);
        for (User user:list) {
            if (user.getUserName().equals(userName) && user.getPassword().equals(password)){
                list.add(user);
                new Config().writeToFile(Config.PATH_USER,list);
                return true;
            }
        }
        return false;
    }
    @Override
    public User getCurentUser() {
        if(new Config<User>().readFromFile(Config.PATH_USER).size()!=0){
            User user = new Config<User>().readFromFile(Config.PATH_USER).get(0);
            return user;
        }
        return null;
    }
}
