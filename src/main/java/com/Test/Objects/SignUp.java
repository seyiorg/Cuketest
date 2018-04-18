package com.Test.Objects;

import com.Test.Utility.Button;
import com.Test.Utility.Notifcations;
import com.Test.Utility.Support;
import com.Test.Utility.TextField;
import org.openqa.selenium.By;

import static com.Test.Utility.Hooks.randomString;

/**
 * Created by olu on 25/05/2017.
 */
public class SignUp extends Support{

    private TextField username_field;
    private TextField password_field;
    private Button create_account_button;
    private String username_data = getUsername_data();
    private String password_data = getPassword_data();
    private Notifcations signUp_notification;


    //Constructors
    public SignUp() {
        username_field = new TextField(By.name("uid"));
        password_field = new TextField(By.name("pw"));
        create_account_button = new Button(By.xpath("//input[@type='submit']"));
        signUp_notification = new Notifcations(By.xpath("//div[1]/following::div[1]"));
    }

    //getter methods
    public TextField getUsername_field() {
        return username_field;
    }

    public TextField getPassword_field() {
        return password_field;
    }

    public Button getCreate_account() {
        return create_account_button;
    }

    public String getUsername_data() {
        username_data = "Test" + randomString;
        return username_data;
    }

    public String getPassword_data() {
        password_data = "password";
        return password_data;
    }

    //assert form elements are enabled
    public void assertSignUpFormEnabled(){
        assertElementEnabled(username_field.getSelector());
        assertElementEnabled(password_field.getSelector());
        assertElementEnabled(create_account_button.getSelector());
    }

    //complete signup form
    public void completeSignUpForm() throws Exception {
        completeTextField(username_field.getSelector(), username_data);
        completeTextField(password_field.getSelector(), password_data);
        clickOnElement(create_account_button.getSelector());
    }

    //verify signup notification
    public void assertSignUpNotification(String text) throws InterruptedException {
        assertDisplayedText(signUp_notification.getSelector(), text);
    }
}
