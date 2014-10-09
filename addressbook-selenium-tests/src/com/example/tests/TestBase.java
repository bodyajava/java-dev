package com.example.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import com.example.fw.ApplicationManager;

public class TestBase {
	static ApplicationManager app;
	
	public static enum Mode {
	    ALPHA, ALPHANUMERIC, NUMERIC, PHONE, EMAIL 
	}

	@BeforeTest
	public void setUp() throws Exception {
		app = new ApplicationManager (); 
	  }

	@AfterTest
	public void tearDown() throws Exception {
		app.stop();
	  }
		
	@DataProvider
	public static Iterator<Object[]> randomValidGroupGenerator() {
		List<Object[]> list = new ArrayList<Object[]>();
		for (int i = 0; i < 5; i++) {
			GroupData group = new GroupData()
				.withName(generateRandomString(Mode.ALPHANUMERIC, 15, 0))
				.withHeader(generateRandomString(Mode.ALPHANUMERIC, 25, 0))
				.withFooter(generateRandomString(Mode.ALPHANUMERIC, 25, 0));
			list.add(new Object[]{group});
		}
		app.navigateTo().groupsPage();
		return list.iterator();
	  }

	@DataProvider
	public static Iterator<Object[]> randomValidContactGenerator() {
		List<Object[]> list = new ArrayList<Object[]>();
		for (int i = 0; i < 5; i++) {
			ContactData contact = new ContactData()
				.withFirstname(generateRandomString(Mode.ALPHA, 50, 0))
				.withLastname(generateRandomString(Mode.ALPHA, 50, 0))
				.withAddress(generateRandomString(Mode.ALPHANUMERIC, 100, 0))
				.withPhoneHome(generateRandomString(Mode.PHONE, 15, 1))
				.withPhoneMobile(generateRandomString(Mode.PHONE, 15, 1))
				.withPhoneWork(generateRandomString(Mode.PHONE, 15, 1))
				.withEmail(generateRandomString(Mode.EMAIL, 25, 0))
				.withEmail2(generateRandomString(Mode.EMAIL, 25, 0))
				.withDayOfBirth("" + generateWithin(32))
				.withMonthOfBirth("" + generateWithin(13))
				.withYearOfBirth(generateRandomString(Mode.NUMERIC, 4, 1))
				.withAddress2(generateRandomString(Mode.ALPHANUMERIC, 100, 0))
				.withPhone2(generateRandomString(Mode.PHONE, 15, 1));
			list.add(new Object[]{contact});
		}
		app.navigateTo().mainPage();
		return list.iterator();
	  }
	    
	public static String generateRandomString(Mode mode, int fieldSize, int fixed) {
		
		StringBuffer buffer = new StringBuffer();
		String characters = "";

		switch(mode){
		case ALPHA:
			characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
			break;
		case ALPHANUMERIC:
			characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
			break;
		case NUMERIC:
			characters = "1234567890";
		    break;
		case PHONE:
			characters = "1234567890.+-_()";
		    break;
		case EMAIL:
			characters = "1234567890.+-_()";
		    break;
		}
		
		Random rnd = new Random();
		int charactersLength = characters.length();
		int length = 0;
		
		if (fixed == 1) {
			length = fieldSize;
		} else {
			length = rnd.nextInt(fieldSize);
		}
		
		if (rnd.nextInt(9) == 0) {
			return "";	
		} else {
			for (int i = 0; i < length; i++) {
				double index = Math.random() * charactersLength;
				buffer.append(characters.charAt((int) index));
				// return "testString" + rnd.nextInt();
			}
			return buffer.toString();
		}
	}
	
	public static int generateWithin(int number) {
		Random rnd = new Random();
		int index = rnd.nextInt(number);
		return index;
	}

}
