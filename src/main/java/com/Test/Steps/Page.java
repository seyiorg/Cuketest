package com.Test.Steps;

import com.Test.Objects.MenuPanel;
import com.Test.Objects.SignUp;
import com.Test.Utility.Support;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

/**
 * Created by olu on 25/05/2017.
 */
public class Page extends Support {

    private SignUp signup;
    private MenuPanel mp;

    //Constructor
    public Page(SignUp signup, MenuPanel mp) {
        this.signup = signup;
        this.mp = mp;
    }

    @Given("^I am on the \"([^\"]*)\" page$")
    public void i_am_on_the_page(String page) throws Throwable {
        gotoPage(page);
    }

    @Given("^I have signed in successfully$")
    public void iHaveSignedInSuccessfully() throws Throwable {
       signup.completeSignUpForm();
    }

    @When("^I navigate to the \"([^\"]*)\" page$")
    public void iNavigateToThePage(String page) throws Throwable {
        switch (page){
            case"New Snippet":
                clickOnElement(mp.home_link.getSelector());
                clickOnElement(mp.new_snippet_link.getSelector());
                break;
        }
    }
}
