package com.example.tests;

import static org.testng.Assert.assertEquals;
import java.util.Collections;
import java.util.List;
import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {
	
	@Test(dataProvider = "randomValidGroupGenerator")
	public void testAddGroupWithValidData(GroupData group) throws Exception {  
		app.getNavigationHelper().openMainPage();
		app.getNavigationHelper().gotoGroupsPage();

		// save old list state
		List<GroupData> oldList = app.getGroupHelper().getGroupsList();

		// actions
		app.getGroupHelper().addNewGroup();
		app.getGroupHelper().fillGroupForm(group);
		app.getGroupHelper().submitNewGroupForm();
		app.getNavigationHelper().gotoGroupsPage();
    
		// save new list state
		List<GroupData> newList = app.getGroupHelper().getGroupsList(); 
    
		// compare list's states
		// assertEquals(newList.size(), oldList.size() + 1);
		oldList.add(group);
		Collections.sort(oldList);
		assertEquals(newList, oldList);
	}
    
}
