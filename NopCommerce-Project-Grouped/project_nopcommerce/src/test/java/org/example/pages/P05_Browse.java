package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P05_Browse {

    public P05_Browse(){
        PageFactory.initElements(Hooks.driver,this);
    }


}
