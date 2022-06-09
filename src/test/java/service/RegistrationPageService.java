package service;

import model.UserData;
import page.RegistrationPage;
import page.UserProfilePage;

public class RegistrationPageService {

    private static final String REGISTRATION_URL = "https://log.finalsurge.com/register.cshtml?page_redirect=%2fUserProfile.cshtml";

    private RegistrationPage registrationPage = new RegistrationPage();
    private UserData userData = new UserData();

    public UserProfilePage registerSuccessfully(){
        try{
            registrationPage.openPage(REGISTRATION_URL)
                    .fillInFirstName(userData.getFirstName())
                    .fillInLastName(userData.getLastName())
                    .chooseTimeZone(userData.getTimeZone())
                    .fillInEmail(userData.getTempEmailForRegistration())
                    .fillInPassword(userData.getPassword())
                    .fillInConfirmPassword(userData.getConfirmPassword())
                    .clickCreateNewAccountButton();}
        catch (Exception exception){
//            log.error("Registration failed");
        }
        return new UserProfilePage();

    }

    public RegistrationPage registerWithWrongConfirmPassword(){
        try{
            registrationPage.openPage(REGISTRATION_URL)
                    .fillInFirstName(userData.getFirstName())
                    .fillInLastName(userData.getLastName())
                    .chooseTimeZone(userData.getTimeZone())
                    .fillInEmail(userData.getTempEmailForRegistration())
                    .fillInPassword(userData.getPassword())
                    .fillInConfirmPassword(userData.getWrongConfirmPassword())
                    .clickCreateNewAccountButton();}
        catch (Exception exception){
//            log.error("Registration failed");
        }
        return new RegistrationPage();

    }

}
