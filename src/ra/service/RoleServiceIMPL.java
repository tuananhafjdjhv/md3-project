package ra.service;

import ra.model.Role;
import ra.model.RoleName;

import java.util.ArrayList;
import java.util.List;

public class RoleServiceIMPL implements IRoleService{
    public static List<Role> roles = new ArrayList<>();
    static {
        roles.add(new Role(1,RoleName.USER));
        roles.add(new Role(2,RoleName.ADMIN));
    }
    @Override
    public Role FindByName(RoleName name) {
        for (int i = 0; i < roles.size(); i++) {
            if (roles.get(i).getName()== name){
                return roles.get(i);
            }
        }
        return null;
    }
}
