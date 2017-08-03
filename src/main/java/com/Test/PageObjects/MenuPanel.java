package com.Test.PageObjects;

import com.Test.Utility.Link;
import com.Test.Utility.Support;
import org.openqa.selenium.By;

/**
 * Created by olu on 25/05/2017.
 */
public class MenuPanel extends Support{

    public Link home_link;
    public Link new_snippet_link;

    public MenuPanel() {
        home_link = new Link(By.xpath("//a[text() = 'Home']"));
        new_snippet_link = new Link(By.xpath("//a[text() = 'New Snippet']"));
    }

}
