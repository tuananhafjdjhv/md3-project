package ra.service;

import ra.model.Role;
import ra.model.RoleName;

import java.util.List;

public interface IRoleService {
    Role FindByName(RoleName name);
}
