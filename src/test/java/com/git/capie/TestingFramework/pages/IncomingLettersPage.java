package com.git.capie.TestingFramework.pages;

import com.git.capie.TestingFramework.controls.ITextField;
import com.git.capie.TestingFramework.controls.TextField;

public class IncomingLettersPage extends BaseLeftFrame{
	
	private class IncomingLettersPageUIMap{
		public final ITextField searchInLetters;
		
		IncomingLettersPageUIMap(){
			this.searchInLetters = TextField.getByXpath(".//*[@id='msglist']/div[1]/div[1]/input");
		}
	}
	
	private IncomingLettersPageUIMap controls;
	
	public IncomingLettersPage(){
		super();
		controls = new IncomingLettersPageUIMap();
	}
	
	public void searchLetter(String text){
		controls.searchInLetters.sendKeys(text);
	}
}
