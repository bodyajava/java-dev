package com.example.tests;
import static org.testng.Assert.assertEquals;
import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test; 

public class GroupRemoveTests extends TestBase {

  @Test
  public void deleteCertainGroup() {
	app.getNavigationHelper().openMainPage();
	app.getNavigationHelper().gotoGroupsPage();
	
	// save old list state
	List<GroupData> oldList = app.getGroupHelper().getGroupsList();
	
	// actions
	app.getGroupHelper().deleteGroup(0);
	app.getNavigationHelper().gotoGroupsPage();
	
	// save new list state
	List<GroupData> newList = app.getGroupHelper().getGroupsList(); 
	
	// compare list's states
	oldList.remove(0);
	Collections.sort(oldList);
	assertEquals(newList, oldList);
	}

}
