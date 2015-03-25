package com.git.capie.TestingFramework.pages;

import com.git.capie.TestingFramework.controls.Button;
import com.git.capie.TestingFramework.controls.IButton;
import com.git.capie.TestingFramework.controls.ILink;
import com.git.capie.TestingFramework.controls.ITextField;
import com.git.capie.TestingFramework.controls.Link;
import com.git.capie.TestingFramework.controls.TextField;

public class WriteNewLetterPage extends BaseLeftFrame{
	private class WriteNewLetterPageUIMap{
		public final IButton sendMessage;
		public final ILink dismisMessage;
		public final ITextField addresField;
		public final ITextField subjectField;
		//public final IButton attachFile;
		// public final IButton attachFileFromEDisk;
		public final ITextField messageField;
		
		public WriteNewLetterPageUIMap(){
			this.sendMessage = Button.getByXpath(".//*[@id='screens']/div/div[1]/div/button");
			this.dismisMessage = Link.getByXpath(".//*[@id='screens']/div/div[1]/div/a[1]");
			this.addresField = TextField.getByName("toInput");
			this.subjectField = TextField.getByName("subject");
			//this.attachFile = Button.getByXpath(".//*[@id='screens']/div/div[2]/section[1]/div[1]/div[2]/input[2]");
			// this.attachFileFromEDisk;
			this.messageField = TextField.getByXpath(".//*[@id='screens']/div/div[2]/section[3]/div/div[3]");
		}
	}
	
	private WriteNewLetterPageUIMap controls;
	
	public WriteNewLetterPage(){
		super();
		controls = new WriteNewLetterPageUIMap();
	}
	
	public void typeToAdressField(String addres){
		controls.addresField.sendKeys(addres);
	}
	
	public void typeToSubjectField(String subject){
		controls.subjectField.sendKeys(subject);
	}
	
	public void typeMessage(String message){
		controls.messageField.sendKeys(message);
	}
	
	public void dismisMessage(){
		controls.dismisMessage.click();
	}
	
	public AfterSendLetterPage sendMessage(){
		controls.sendMessage.click();
		return new AfterSendLetterPage();
	}
}
