package com.git.capie.TestingFramework.controls;

public class VoidControlStub implements IVoidControlStub,
        IButton, ILabel, ILabelClickable, ILink, ICheckBox,
        IDropDownList, IRadioButton, ITextField {
    private static final String ELEMENT_UNEXISTS = "Element Unexists";
    private static final String VOID_ACTION = "Void Action: %s";


    private VoidControlStub() {
    }

    public static IVoidControlStub get() {
        return new VoidControlStub();
    }

    public IButton toIButton() {
        return this;
    }

    public ILabel toILabel() {
        return this;
    }

    public ILabelClickable toILabelClickable() {
        return this;
    }

    public ILink toILink() {
        return this;
    }

    public ICheckBox toICheckBox() {
        return this;
    }

    public IDropDownList toIDropDownList() {
        return this;
    }

    public IRadioButton toIRadioButton() {
        return this;
    }

    public ITextField toITextField(){
        return this;
    }

    public void click() {
        System.out.println(String.format(VOID_ACTION, "Click"));
    }

    public void doubleClick() {
        System.out.println(String.format(VOID_ACTION, "Double click"));
    }

    public void hover() {
        System.out.println(String.format(VOID_ACTION, "Hover"));
    }

    public String getAttribute(String attribute) {
        return ELEMENT_UNEXISTS;
    }


    public String getName()  {
        return ELEMENT_UNEXISTS;
    }

    public boolean isChecked() {
        return false;
    }

    public void check() {
        System.out.println(String.format(VOID_ACTION, "Check"));
    }

    public void uncheck() {
        System.out.println(String.format(VOID_ACTION, "Uncheck"));
    }

    public void submit() {
        System.out.println(String.format(VOID_ACTION, "Submit"));
    }

    public String getContent() {
        return ELEMENT_UNEXISTS;
    }

    public String getText() {
        return ELEMENT_UNEXISTS;
    }

    public boolean isDisplayed() {
        System.out.println(ELEMENT_UNEXISTS);
        return false;
    }

    public boolean isEnabled() {
        System.out.println(ELEMENT_UNEXISTS);
        return false;
    }

    public void sendKeys(String text) {
        System.out.println(String.format(VOID_ACTION, "Send Keys: \"" + text + "\""));
    }

    public String getUrl()  {
        return ELEMENT_UNEXISTS;
    }

    public ILabelClickable makeClickable() {
        return this;
    }

    public boolean isInvisible() {
        return false;
    }

    public void selectByIndex(int index) {
        System.out.println(String.format(VOID_ACTION, "Select By Index"));
    }

    public void selectByText(String text) {
        System.out.println(String.format(VOID_ACTION, "Select By Text"));
    }

    public void selectByPartialText(String partialText) {
        System.out.println(String.format(VOID_ACTION, "Select By Partial Text"));
    }

    public IControl getSelectedElement() {
        System.out.println(ELEMENT_UNEXISTS);
        return this;
    }
}
