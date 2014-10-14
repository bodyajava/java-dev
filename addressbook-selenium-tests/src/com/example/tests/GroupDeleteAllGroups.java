package com.example.tests;

import org.testng.annotations.Test;

public class GroupDeleteAllGroups extends TestBase{

	@Test
	public void deleteAllGroups() {
		app.getGroupHelper().deleteAllGroups();
	}


}
