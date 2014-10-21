package com.example.fw;

import java.util.Properties;
import org.netbeans.jemmy.ClassReference;
import org.netbeans.jemmy.operators.JFrameOperator;

public class ApplicationManager {
	
	private static ApplicationManager singletone; 
	private Properties properties;
	private FolderHelper folderHelper;
	private MenuHelper menuHelper;
	private JFrameOperator mainFrame;
	
	public static ApplicationManager getInstance() {
		if (singletone == null) {
			singletone = new ApplicationManager();
		}
		return singletone;
	}

	public void stop() {
		getApplication().requestClose();
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	public String getProperty(String key) {
		return properties.getProperty(key);
	}
	
	public String getProperty(String key, String defaultValue) {
		return properties.getProperty(key, defaultValue);
	}

	public JFrameOperator getApplication() {
		if (mainFrame == null) {
			try {
				new ClassReference("addressbook.AddressBookFrame").startApplication();
				mainFrame = new JFrameOperator("jAddressBook");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return mainFrame;
	}

	public FolderHelper getFolderHelper() {
		if (folderHelper == null) {
			folderHelper = new FolderHelper(this);
		}
		return folderHelper;
	}

	public MenuHelper getMenuHelper() {
		if (menuHelper == null) {
			menuHelper = new MenuHelper(this);
		}
		return menuHelper;
	}

}
