package com.example.tests;
import static org.testng.Assert.assertEquals;
import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class GroupUpdateTests extends TestBase {

  @Test
  public void updateCertainGroup() throws Exception {
	GroupData group = new GroupData();
	group.name = "Congregation in Paris";
	group.footer = "Full description about Spain";
	app.getNavigationHelper().openMainPage();
	app.getNavigationHelper().gotoGroupsPage();

	// save old list state
	List<GroupData> oldList = app.getGroupHelper().getGroupsList();
	
	// actions
	app.getGroupHelper().openGroupForUpdate(0);
	app.getGroupHelper().fillGroupForm(group);
	app.getGroupHelper().submitUpdatedGroupForm();
	app.getNavigationHelper().gotoGroupsPage();
	
	// save new list state
	List<GroupData> newList = app.getGroupHelper().getGroupsList(); 
	
	// compare list's states
	oldList.remove(0);
	oldList.add(group);
	Collections.sort(oldList);
	assertEquals(newList, oldList);
	}

}

