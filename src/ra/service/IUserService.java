package ra.service;

import ra.model.User;

public interface IUserService extends IGenericService<User> {
    boolean existedByUsername(String username);
    boolean existedByEmail(String email);
    boolean checkLogin(String s, String p);

    User getCurentUser();
}
