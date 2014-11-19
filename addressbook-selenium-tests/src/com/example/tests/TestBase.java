package com.example.tests;

import static com.example.tests.ContactDataGenerator.loadContactsFromXmlFile;
import static com.example.tests.GroupDataGenerator.loadGroupsFromXmlFile;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
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

	@DataProvider
	public static Iterator<Object[]> randomValidContactGenerator() throws IOException {
		return wrapContactsIntoObjects(loadContactsFromXmlFile(new File("contacts.xml"))).iterator();
	}
	
	@DataProvider
	public static Iterator<Object[]> loadGroupsFromFile() throws IOException {
		app.navigateTo().groupsPage();
		return wrapGroupsIntoObjects(loadGroupsFromXmlFile(new File("groups.xml"))).iterator();
	}
	
	@BeforeTest
	public void setUp() throws Exception {
		String configFile = System.getProperty("configFile", "firefox.ppp");
		Properties properties = new Properties();
		properties.load(new FileReader(new File(configFile)));
		app = new ApplicationManager (properties); 
	  }

	
	@AfterTest
	public void tearDown() throws Exception {
		app.stop();
	  }
		
	
	public static List<Object[]> wrapGroupsIntoObjects(List<GroupData> groups) {
		List<Object[]> list = new ArrayList<Object[]>();
		for (GroupData group : groups) {
			list.add(new Object[]{group});
		}
		return list;
	}
	    
	public static List<Object[]> wrapContactsIntoObjects(List<ContactData> contacts) {
		List<Object[]> list = new ArrayList<Object[]>();
		for (ContactData contact : contacts) {
			list.add(new Object[]{contact});
		}
		return list;
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
	
}
