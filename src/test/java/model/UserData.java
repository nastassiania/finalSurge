package model;

public class UserData {

    private String firstName = "John";
    private String lastName = "Doe";
    private String emailForRegistration;
    private String emailForLogin = "test@test.by";
    private String timeZone = "(GMT+02:00) Minsk";
    private String password = "Qwerty159@";
    private String confirmPassword = "Qwerty159@";
    private String wrongConfirmPassword = "Qwerty159";


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getTempEmailForRegistration() {
        return emailForRegistration;
    }

    public String getEmailForLogin() {
        return emailForLogin;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public String getWrongConfirmPassword() {
        return wrongConfirmPassword;
    }
}
