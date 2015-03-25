package com.git.capie.TestingFramework.pages;

import com.git.capie.TestingFramework.controls.Button;
import com.git.capie.TestingFramework.controls.IButton;
import com.git.capie.TestingFramework.controls.ILink;
import com.git.capie.TestingFramework.controls.Link;


public class BaseLeftFrame {
	private class BaseLeftFrameUIMap{
		public final IButton writeLetter;
		public final ILink incomingLetters;
		public final ILink draft;
		public final ILink sent;
		public final ILink removed;
		
		public BaseLeftFrameUIMap() {
			this.writeLetter = Button.getByXpath(".//*[@id='content']/aside/button");
			this.incomingLetters = Link.getById("0");
			this.draft = Link.getById("500001");
			this.sent = Link.getById("500000");
			this.removed = Link.getById("500002");
		}
	}
	
	private BaseLeftFrameUIMap controls;
	
	public BaseLeftFrame(){
		controls = new BaseLeftFrameUIMap();
	}
	
	public WriteNewLetterPage goToWriteNewLetter(){
		controls.writeLetter.click();
		return new WriteNewLetterPage();
	}
	
	public IncomingLettersPage goToIncomingLettersPage(){
		controls.incomingLetters.click();
		return new IncomingLettersPage();
	}
}
