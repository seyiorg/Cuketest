package com.Test.Steps;

import com.Test.PageObjects.SignUp;
import com.Test.PageObjects.Snippet;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

/**
 * Created by olu on 25/05/2017.
 */
public class Forms {

    private SignUp signup;
    private Snippet snipet;

    //Constructor
    public Forms(SignUp signup, Snippet snippet) {
        this.signup = signup;
        this.snipet = snippet;
    }

    @When("^I complete the \"([^\"]*)\" form$")
    public void i_complete_the_form(String form) throws Throwable {
        switch (form){
            case "SignUp":
                signup.completeSignUpForm();
                break;
            case "New Snippet":
                snipet.addSnippet();
                break;
            default:
                throw new Exception("No argument passed");
        }
    }

    @And("^the fields on the \"([^\"]*)\" are enabled$")
    public void theFieldsOnTheAreEnabled(String form) throws Throwable {
        switch (form){
            case "Sign Up Form":
                signup.assertSignUpFormEnabled();
                break;
            default:
                throw new Exception("No argument passed");
        }
    }
}
