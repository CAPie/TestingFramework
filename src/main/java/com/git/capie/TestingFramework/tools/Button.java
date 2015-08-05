package com.git.capie.TestingFramework.tools;

import org.openqa.selenium.Keys;

public class Button {
    private Keys key;

    protected Button(Keys key) {
        this.key = key;
    }

    public void press() {
        ActionUtils.get().keyDownToBrowser(key);
    }
}
