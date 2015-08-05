package com.git.capie.TestingFramework.tools;


import org.openqa.selenium.Keys;

public enum Buttons {

    ALT(Keys.ALT), CONTROL(Keys.CONTROL), SHIFT(Keys.SHIFT), ESCAPE(Keys.ESCAPE), SPACE(Keys.SPACE),
    TAB(Keys.TAB), ARROW_DOWN(Keys.ARROW_DOWN), ARROW_UP(Keys.ARROW_UP), ARROW_LEFT(Keys.ARROW_LEFT),
    ARROW_RIGHT(Keys.ARROW_RIGHT), DELETE(Keys.DELETE), ENTER(Keys.ENTER), BACKSPACE(Keys.BACK_SPACE);

    Button button;

    private Buttons(Keys key) {
        this.button = new Button(key);
    }

    public void pressButton(){
        this.button.press();
    }

    // TODO In future
    /*
    public void pressButtons(KeyboardButtons[] keyboardButtons){
        this.button.press();
    }
    */
}
