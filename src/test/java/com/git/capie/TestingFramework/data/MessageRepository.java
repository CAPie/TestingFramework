package com.git.capie.TestingFramework.data;

public class MessageRepository {
	private static char RETURN = ((char) 13);
	private static char NEWLINE = ((char) 10);

	private MessageRepository() {
	}

	public static String getLookingForJobMessage() {
		return "This message was send automatically using my own TestingFramework (Java, Selenium WebDriver)."
				+ RETURN
				+ NEWLINE
				+ "You can see source of this program on my GitHub profile: TestingFramework, branch: UkrNetCVSpamer."
				+ RETURN
				+ NEWLINE
				+ "I think it is cool for junior Automation QA which spent few days on programming this framework =)"
				+ RETURN
				+ NEWLINE
				+ "Please show it somebody who knows Java. "
				+ RETURN
				+ NEWLINE
				+ "--------------------------------------------"
				+ RETURN
				+ NEWLINE
				+ RETURN
				+ NEWLINE
				+ "Hello!"
				+ RETURN
				+ NEWLINE
				+ RETURN
				+ NEWLINE
				+ "My name is Olexandr. I've recently finished course \"Quality Assurance and Automated Testing\" at SoftServe IT Academy. I'm looking for a job on Junior Automation QA Engineer position at this moment."
				+ RETURN
				+ NEWLINE
				+ "I hope you will be interested in my candidacy."
				+ RETURN
				+ NEWLINE
				+ RETURN
				+ NEWLINE
				+ "My GitHub profile: https://github.com/CAPie"
				+ RETURN
				+ NEWLINE
				+ "My CV: https://docs.google.com/file/d/0B3H2xD1BaxWMZWZ2MHdKWG1zSU0"
				+ RETURN
				+ NEWLINE
				+ RETURN
				+ NEWLINE
				+ "Best regards,"
				+ RETURN
				+ NEWLINE
				+ "Olexandr Strilchuk."
				+ RETURN
				+ NEWLINE
				+ "strilchuk.work@gmail.com" + NEWLINE;
	}
}
