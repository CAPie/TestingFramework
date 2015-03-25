package com.git.capie.TestingFramework.pages;

import com.git.capie.TestingFramework.controls.Button;
import com.git.capie.TestingFramework.controls.IButton;

public class AfterSendLetterPage extends BaseLeftFrame{
	private class AfterSendLetterUIMap{
		public final IButton writeOneMore;
		public final IButton backToIncoming;
		
		public AfterSendLetterUIMap(){
			this.writeOneMore = Button.getByXpath(".//*[@id='screens']/div/div[3]/div[1]/div[2]/button[1]");
			this.backToIncoming = Button.getByXpath(".//*[@id='screens']/div/div[3]/div[1]/div[2]/button[2]");
		}
	}
	
	private AfterSendLetterUIMap controls;
	
	public AfterSendLetterPage(){
		super();
		controls = new AfterSendLetterUIMap();
	}
	
	public WriteNewLetterPage writeOneMoreLetter(){
		controls.writeOneMore.click();
		return new WriteNewLetterPage();
	}
	
	public IncomingLettersPage goToIncommingLetters(){
		controls.backToIncoming.click();
		return new IncomingLettersPage();
	}
}
