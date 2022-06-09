package service;

import model.UserData;
import page.LoginLogoutPage;
import page.UserProfilePage;

public class LoginLogoutPageService {

    private static final String LOGIN_URL = "https://log.finalsurge.com/login.cshtml";

    private LoginLogoutPage loginPage = new LoginLogoutPage();
    private UserData userData = new UserData();
    private UserProfilePage userProfilePage = new UserProfilePage();

    public UserProfilePage logInSuccessfully(){
        try{
            loginPage.openPage(LOGIN_URL)
                    .fillInEmail(userData.getEmailForLogin())
                    .fillInPassword(userData.getPassword())
                    .clickLoginButton();}
        catch (Exception exception){
//            log.error("Registration failed");
        }
        return new UserProfilePage();

    }

    public LoginLogoutPage logOut(){
            userProfilePage.clickLogOutButton();
        return new LoginLogoutPage();

    }

    public UserProfilePage logInUnsuccessfullyWithWrongPassword(){
        try{
            loginPage.openPage(LOGIN_URL)
                    .fillInEmail(userData.getEmailForLogin())
                    .fillInPassword(userData.getWrongConfirmPassword())
                    .clickLoginButton();}
        catch (Exception exception){
//            log.error("Registration failed");
        }
        return new UserProfilePage();

    }

}
