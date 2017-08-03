package com.Test.PageObjects;

import com.Test.Utility.Button;
import com.Test.Utility.Panel;
import com.Test.Utility.Support;
import com.Test.Utility.TextField;
import org.openqa.selenium.By;

import static java.lang.Thread.sleep;

/**
 * Created by olu on 25/05/2017.
 */
public class Snippet extends Support{

    private TextField addNewSippet;
    private Button submit;
    private Panel allSnippets;
    private String snippet = "This is a test snippet";

    public Snippet() throws InterruptedException {

        addNewSippet = new TextField(By.name("snippet"));
        submit = new Button(By.xpath("//*[@type = 'submit']"));
        allSnippets = new Panel(By.xpath("//div/table"));
    }


    public void addSnippet() throws Exception {
        completeTextField(addNewSippet.getSelector(), snippet);
        clickOnElement(submit.getSelector());
    }

    public void assertSnippetDisplayed() throws Exception {
        elementContainsText(allSnippets.getSelector(), snippet);
    }
}
