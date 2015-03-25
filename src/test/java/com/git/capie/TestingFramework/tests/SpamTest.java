package com.git.capie.TestingFramework.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.git.capie.TestingFramework.data.EmailRepository;
import com.git.capie.TestingFramework.data.ListUtils;
import com.git.capie.TestingFramework.data.MessageRepository;
import com.git.capie.TestingFramework.data.UrlRepository;
import com.git.capie.TestingFramework.pages.AfterSendLetterPage;
import com.git.capie.TestingFramework.pages.LoginPage;
import com.git.capie.TestingFramework.pages.WriteNewLetterPage;
import com.git.capie.TestingFramework.tools.WebDriverUtils;

public class SpamTest {
	private String SUBJECT = "Junior Automation QA Enginner";
	
	@DataProvider(name="emails")
	public Object[][] getEmails(){
		return ListUtils.listToArray(EmailRepository.getMyEmail());
	}
	
	@BeforeClass
	public void login(){
		WebDriverUtils.get().goToURL(UrlRepository.getUkrNetLoginPageUrl());
		new LoginPage().login("strilchuk.additional@ukr.net", "Selenium").goToWriteNewLetter();
	}
	
	@Test(dataProvider = "emails")
	public void sendEMail(String email){
		System.out.println(email);
		System.out.println(MessageRepository.getLookingForJobMessage());
		WriteNewLetterPage writeNewLetterPage = new WriteNewLetterPage();
		writeNewLetterPage.typeToAdressField(email);
		writeNewLetterPage.typeToSubjectField(SUBJECT);
		writeNewLetterPage.typeMessage(MessageRepository.getLookingForJobMessage());
		AfterSendLetterPage afterSendLetterPage = writeNewLetterPage.sendMessage();
		afterSendLetterPage.goToWriteNewLetter();
	}
}
