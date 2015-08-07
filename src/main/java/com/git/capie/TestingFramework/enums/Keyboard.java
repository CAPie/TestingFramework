package com.git.capie.TestingFramework.enums;

import com.git.capie.TestingFramework.tools.Buttons;

public enum Keyboard {
    ALT(Buttons.ALT), CONTROL(Buttons.CONTROL), SHIFT(Buttons.SHIFT), 
    ESCAPE(Buttons.ESCAPE), SPACE(Buttons.SPACE), TAB(Buttons.TAB), 
    ARROW_DOWN(Buttons.ARROW_DOWN), ARROW_UP(Buttons.ARROW_UP),
    ARROW_LEFT(Buttons.ARROW_LEFT), ARROW_RIGHT(Buttons.ARROW_RIGHT),
    DELETE(Buttons.DELETE), ENTER(Buttons.ENTER), BACKSPACE(Buttons.BACKSPACE);

    private Buttons button;

    Keyboard(Buttons button){
        this.button = button;
    }

    public void press() {
        button.pressButton();
    }
}

