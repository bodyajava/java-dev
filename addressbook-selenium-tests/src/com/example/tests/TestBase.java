package com.example.tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.example.fw.ApplicationManager;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass

public class TestBase {
	static ApplicationManager app;

	@BeforeTest
	public void setUp() throws Exception {
		app = new ApplicationManager (); 
	  }

	@AfterTest
	public void tearDown() throws Exception {
		app.stop();
	  }
	
}
