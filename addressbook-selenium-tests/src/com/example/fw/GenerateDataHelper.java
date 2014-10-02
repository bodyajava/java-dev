package com.example.fw;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.DataProvider;

import com.example.tests.ContactData;
import com.example.tests.GroupData;

public class GenerateDataHelper extends HelperBase{

	public GenerateDataHelper(ApplicationManager manager) {
		super(manager);
	}
	
	public static enum Mode {
	    ALPHA, ALPHANUMERIC, NUMERIC, PHONE, EMAIL 
	}
	
	@DataProvider
	public static Iterator<Object[]> randomValidGroupGenerator() {
		List<Object[]> list = new ArrayList<Object[]>();
		for (int i = 0; i < 5; i++) {
			GroupData group = new GroupData();
			group.name = generateRandomString(Mode.ALPHANUMERIC, 15, 0);
			group.header = generateRandomString(Mode.ALPHANUMERIC, 25, 0);
			group.footer = generateRandomString(Mode.ALPHANUMERIC, 25, 0);
			list.add(new Object[]{group});
		}
		return list.iterator();
	  }

	@DataProvider
	public static Iterator<Object[]> randomValidContactGenerator() {
		List<Object[]> list = new ArrayList<Object[]>();
		for (int i = 0; i < 5; i++) {
			ContactData contact = new ContactData();
			contact.firstname = generateRandomString(Mode.ALPHA, 50, 0);
			contact.lastname = generateRandomString(Mode.ALPHA, 50, 0);
		    contact.address = generateRandomString(Mode.ALPHANUMERIC, 100, 0);
		    contact.phone_home = generateRandomString(Mode.PHONE, 15, 1); 
		    contact.phone_mobile = generateRandomString(Mode.PHONE, 15, 1);
		    contact.phone_work = generateRandomString(Mode.PHONE, 15, 1);
		    contact.email = generateRandomString(Mode.EMAIL, 25, 0);
		    contact.email2 = generateRandomString(Mode.EMAIL, 25, 0);
		    //contact.byday = selectDropDownItemByRandom("bday");
		    // contact.bymonth = "January";
		    contact.byyear = generateRandomString(Mode.NUMERIC, 4, 1);
		    contact.address2 = generateRandomString(Mode.ALPHANUMERIC, 100, 0);
		    contact.phone2 = generateRandomString(Mode.PHONE, 15, 1);
			list.add(new Object[]{contact});
		}
		return list.iterator();
	  }
	    
	public static String generateRandomString(Mode mode, int fieldSize, int fixed) {
		
		StringBuffer buffer = new StringBuffer();
		String characters = "";

		switch(mode){
		case ALPHA:
			characters = "abcdefghijklmnopqrstuvwxyz ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			break;
		case ALPHANUMERIC:
			characters = "abcdefghijklmnopqrstuvwxyz ABCDEFGHIJKLMNOPQRSTUVWXYZ 1234567890";
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
		
		if (rnd.nextInt(3) == 0) {
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
