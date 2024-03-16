package Users;

public class RegularUser extends AbstractUser {
    public RegularUser(String userEmail, String userPassword){
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }

    @Override
    public String getEmail() {
        return userEmail;
    }

    @Override
    public String getPassword() {
        return userPassword;
    }
}
