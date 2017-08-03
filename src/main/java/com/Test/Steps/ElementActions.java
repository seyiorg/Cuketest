package com.Test.Steps;

import com.Test.PageObjects.SignUp;
import com.Test.PageObjects.Snippet;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by olu on 25/05/2017.
 */
public class ElementActions {

    private SignUp signup;
    private Snippet snippet;

    //Constructor
    public ElementActions(SignUp signup, Snippet snippet) {
        this.signup = signup;
        this.snippet = snippet;
    }

    @Then("^the \"([^\"]*)\" notification message should display the text \"([^\"]*)\"$")
    public void theNotificationMessageShouldDisplayTheText(String form, String text) throws Throwable {
        switch (form) {
            case "SignUp":
                signup.assertSignUpNotification(text);
                break;
        }
    }

    @Then("^the snippet is displayed successfully$")
    public void theSnippetIsDisplayedSuccessfully() throws Throwable {
        snippet.assertSnippetDisplayed();
    }
}
