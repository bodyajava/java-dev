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
	
	List<GroupData> oldList = app.getGroupHelper().getGroupsList();
	
	int index = app.getGroupHelper().generateIndexBasedOnListSize(oldList.size());
	app.getGroupHelper().deleteGroup(index);
	app.getNavigationHelper().gotoGroupsPage();
	
	List<GroupData> newList = app.getGroupHelper().getGroupsList(); 
	
	oldList.remove(index);
	Collections.sort(oldList);
	assertEquals(newList, oldList);
	}

}
