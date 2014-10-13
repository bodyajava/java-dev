package com.example.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import com.example.tests.TestBase.Mode;
import com.thoughtworks.xstream.XStream;

import static com.example.tests.TestBase.generateRandomString;

public class ContactDataGenerator {

	public static void main(String[] args) throws IOException {
		if (args.length < 3) {
			System.out.println("Please provide following parameters: <amount of test data>, <file>, <file format>");
			return;
		}
		
		int amount = Integer.parseInt(args[0]);
		File file = new File(args[1]);
		String format = args[2];
		
		if (file.exists()) {
			System.out.println("File exists. Please remove it manually: " + file);
			return;			
		}
		
		if (amount < 0) {
			System.out.println("Invalid amount provided: " + amount);
			return;
		} else {
			List<ContactData> contacts = generateRandomContacts(amount);
			if (format.equals("csv")) {
				saveContactsToCsvFile(contacts, file);
			} else if (format.equals("xml")) {
				saveContactsToXmlFile(contacts, file);
			} else {
				System.out.println("Unknown file format rovided: " + format);
				return;
			}
		}
	}

	public static List<ContactData> generateRandomContacts(int amount) {
		List<ContactData> list = new ArrayList<ContactData>();
		for (int i = 0; i < amount; i++) {
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
			list.add(contact);
		}
		return list;
	}
	
	private static int generateWithin(int number) {
		Random rnd = new Random();
		int index = rnd.nextInt(number);
		return index;
	}

	private static void saveContactsToCsvFile(List<ContactData> contacts, File file) throws IOException {
		FileWriter writer = new FileWriter(file);
		for (ContactData contact : contacts) {
			writer.write(contact.getFirstname() + ","
					+ contact.getLastname() + ","
					+ contact.getAddress() + ","
					+ contact.getPhone_home() + ","
					+ contact.getPhone_mobile() + ","
					+ contact.getPhone_work() + ","
					+ contact.getEmail() + ","
					+ contact.getEmail2() + ","
					+ contact.getByday() + ","
					+ contact.getBymonth() + ","
					+ contact.getByyear() + ","
					+ contact.getAddress2() + ","
					+ contact.getPhone2() + ",!" + "\n");
		}
		writer.close();
	}
	
	public static List<ContactData> loadContactsFromCsvFile(File file) throws IOException {
		List<ContactData> list = new ArrayList<ContactData>();
		FileReader reader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(reader);
		String line = bufferedReader.readLine();
		while (line != null) {
			String[] part = line.split(",");
			ContactData contact = new ContactData()
				.withFirstname(part[0])
				.withLastname(part[1])
				.withAddress(part[2])
				.withPhoneHome(part[3])
				.withPhoneMobile(part[4])
				.withPhoneWork(part[5])
				.withEmail(part[6])
				.withEmail2(part[7])
				.withDayOfBirth(part[8])
				.withMonthOfBirth(part[9])
				.withYearOfBirth(part[10])
				.withAddress2(part[11])
				.withPhone2(part[12]);
			list.add(contact);
			line = bufferedReader.readLine();
		}
		
		bufferedReader.close();
		return list;
	}

	private static void saveContactsToXmlFile(List<ContactData> contacts, File file) throws IOException {
		XStream xstream = new XStream();
		xstream.alias("contact", ContactData.class);
		String xml = xstream.toXML(contacts);
		FileWriter writer = new FileWriter(file);
		writer.write(xml);
		writer.close();
	}
	
	public static List<ContactData> loadContactsFromXmlFile(File file) throws IOException {
		XStream xstream = new XStream();
		xstream.alias("contact", ContactData.class);
		return (List<ContactData>) xstream.fromXML(file);
	}

}
