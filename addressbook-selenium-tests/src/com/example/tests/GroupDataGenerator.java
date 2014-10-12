package com.example.tests;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.example.tests.TestBase.Mode;
import static com.example.tests.TestBase.generateRandomString;

public class GroupDataGenerator {

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
			List<GroupData> groups = generateRandomGroups(amount);
			if (format.equals("csv")) {
				saveGroupsToCsvFile(groups, file);
			} else if (format.equals("xml")) {
				saveGroupsToXmlFile(groups, file);
			} else {
				System.out.println("Unknown file format rovided: " + format);
				return;
			}
		}
	}

	public static List<GroupData> generateRandomGroups(int amount) {
		List<GroupData> list = new ArrayList<GroupData>();
		for (int i = 0; i < amount; i++) {
			GroupData group = new GroupData()
				.withName(generateRandomString(Mode.ALPHANUMERIC, 15, 0))
				.withHeader(generateRandomString(Mode.ALPHANUMERIC, 25, 0))
				.withFooter(generateRandomString(Mode.ALPHANUMERIC, 25, 0));
			list.add(group);
		}
		return list;
	}
	
	private static void saveGroupsToCsvFile(List<GroupData> groups, File file) throws IOException {
			FileWriter writer = new FileWriter(file);
			for (GroupData group : groups) {
				writer.write(group.getName() + ","
						+ group.getHeader() + ","
						+ group.getFooter() + "\n");
			}
			writer.close();
	}
	
	private static void saveGroupsToXmlFile(List<GroupData> groups, File file) {
		// TODO Auto-generated method stub
		
	}

	public static List<GroupData> loadGroupsFromCsvFile(int i) {
		// TODO Auto-generated method stub
		return null;
	}

}
