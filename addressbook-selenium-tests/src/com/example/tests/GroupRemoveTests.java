package com.example.tests;
import org.testng.annotations.Test; 

public class GroupRemoveTests extends TestBase {

	@Test
	public void deleteCertainGroup() {
		app.getNavigationHelper().openMainPage();
	    app.getNavigationHelper().gotoGroupsPage();
	    app.getGroupHelper().deleteGroup(3);
	    app.getNavigationHelper().gotoGroupsPage();
	}

}
