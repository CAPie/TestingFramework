package com.git.capie.TestingFramework.pages;

import com.git.capie.TestingFramework.controls.Button;
import com.git.capie.TestingFramework.controls.CheckBox;
import com.git.capie.TestingFramework.controls.CheckBoxWithLabel;
import com.git.capie.TestingFramework.controls.IButton;
import com.git.capie.TestingFramework.controls.ICheckBoxWithLabel;
import com.git.capie.TestingFramework.controls.ILink;
import com.git.capie.TestingFramework.controls.ITextField;
import com.git.capie.TestingFramework.controls.Label;
import com.git.capie.TestingFramework.controls.Link;
import com.git.capie.TestingFramework.controls.TextField;


public class LoginPage {
	private class LoginPageUIMap {
		public final ILink UkrNetImg;
		public final ITextField loginField;
		public final ITextField passwdField;
		public final ICheckBoxWithLabel publicPlaceChBox;
		public final ILink forgotPassword;
		public final ILink registration;
		public final IButton loginButton;
		
		public LoginPageUIMap() {
			this.UkrNetImg = Link.getByCssSelector(".logo");
			this.loginField = TextField.getById("login");
			this.passwdField= TextField.getById("password");
			this.publicPlaceChBox = CheckBoxWithLabel.get(CheckBox.getByXpath(".//*[@id='login-form']/label/input"), Label.getByXpath(".//*[@id='login-form']/label/span").makeLabelClickable());
			this.forgotPassword = Link.getById("recovery-link");
			this.registration = Link.getById("signup-link");
			this.loginButton = Button.getByXpath(".//*[@id='login-form']/div[3]/button");
		}
	}
	
	private LoginPageUIMap controls;
	
	public LoginPage(){
		this.controls = new LoginPageUIMap();
	}
	
	public IncomingLettersPage login(String login, String password){
		controls.loginField.sendKeys(login);
		controls.passwdField.sendKeys(password);
		controls.loginButton.click();
		return new IncomingLettersPage();
	}
}
