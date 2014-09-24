package com.example.tests;
import org.testng.annotations.Test;

public class GroupUpdateTests extends TestBase {

	@Test
	public void updateCertainGroup() throws Exception {
	    GroupData group = new GroupData();
		group.groupname = "Congregation in Spain";
		group.footer = "Full description about Spain";
		app.getNavigationHelper().openMainPage();
	    app.getNavigationHelper().gotoGroupsPage();
	    app.getGroupHelper().openGroupForUpdate(1);
	    app.getGroupHelper().fillGroupForm(group);
	    app.getGroupHelper().submitUpdatedGroupForm();
	    app.getNavigationHelper().gotoGroupsPage();
	}

	@Test
	public void updateCertainGroup2() throws Exception {
	    GroupData group = new GroupData();
		group.header = "some any text";
		group.footer = group.header;
		app.getNavigationHelper().openMainPage();
	    app.getNavigationHelper().gotoGroupsPage();
	    app.getGroupHelper().openGroupForUpdate(1);
	    app.getGroupHelper().fillGroupForm(group);
	    app.getGroupHelper().submitUpdatedGroupForm();
	    app.getNavigationHelper().gotoGroupsPage();
	}

}

