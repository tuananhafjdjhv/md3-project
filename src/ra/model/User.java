package ra.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class User  implements Serializable {
    private int id;
    private String name;
    private String userName;

    private String email;
    private String password;
    private String avatar;
    private boolean status = true;
    private Set<Role> roles = new HashSet<>();

    public User(int id, String name, String userName, String email, String password, String avatar, boolean status, Set<Role> roles) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.avatar = avatar;
        this.status = status;
        this.roles = roles;
    }

    public User() {
    }

    public User(int id, String name, String username, String email, String password, Set<Role> roleSet) {
        this.id = id;
        this.name = name;
        this.userName = username;
        this.email = email;
        this.password = password;
        this.roles = roleSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return
                "id= " + id +
                ", name= " + name  +
                ", UserName= " + userName  +
                ", email= " + email  +
                ", password= " + password  +
                ", status= " + status +
                '\n';
    }
}
