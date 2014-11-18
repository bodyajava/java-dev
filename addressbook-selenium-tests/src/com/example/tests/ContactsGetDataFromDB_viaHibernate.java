package com.example.tests;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import com.example.fw.ApplicationManager;

public class ContactsGetDataFromDB_viaHibernate {
	
	public static void main (String[] args) throws IOException {
		Properties properties = new Properties();
		properties.load(new FileReader(new File("firefox.ppp")));
		ApplicationManager app = new ApplicationManager(properties);
	
		System.out.println(app.getHibernateHelper().listContacts());
	}

}
