package ra.dto.request;

public class SingInDTO {
    private String userName;
    private String password;

    public SingInDTO() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public SingInDTO(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
