package com.Test.Utility;

import org.openqa.selenium.By;

/**
 * Created by olu on 25/05/2017.
 */
public class TextField extends Support{

    public TextField(By selector) {
        this.setSelector(selector);
    }

    public TextField(By selector, String text) {
        this.setSelector(selector);
        this.setText(text);
    }

}
