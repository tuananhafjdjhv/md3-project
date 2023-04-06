package ra.dto.request;

import java.util.HashSet;
import java.util.Set;

public class SingUpDTO {
    private int id;
    private String username;
    private String name;
    private String email;
    private String password;
    private Set<String> strRole = new HashSet<>();

    public SingUpDTO(int id, String username, String name, String email, String password, Set<String> strRole) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.email = email;
        this.password = password;
        this.strRole = strRole;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Set<String> getStrRole() {
        return strRole;
    }

    public void setStrRole(Set<String> strRole) {
        this.strRole = strRole;
    }

    public SingUpDTO() {
    }

    @Override
    public String toString() {
        return "SingUpDTO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", strRole=" + strRole +
                '}';
    }
}
