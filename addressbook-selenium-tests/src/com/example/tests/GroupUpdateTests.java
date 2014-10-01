package com.example.tests;

import static org.testng.Assert.assertEquals;
import java.util.Collections;
import java.util.List;
import org.testng.annotations.Test;
import com.example.fw.GenerateDataHelper;

public class GroupUpdateTests extends TestBase {

  @Test(dataProvider = "randomValidGroupGenerator", dataProviderClass = GenerateDataHelper.class)
  public void updateCertainGroup(GroupData group) throws Exception {
	app.getNavigationHelper().openMainPage();
	app.getNavigationHelper().gotoGroupsPage();

	List<GroupData> oldList = app.getGroupHelper().getGroupsList();
	
	int index = app.getGroupHelper().generateIndexBasedOnListSize(oldList.size());
	app.getGroupHelper().openGroupForUpdate(index);
	app.getGroupHelper().fillGroupForm(group);
	app.getGroupHelper().submitUpdatedGroupForm();
	app.getNavigationHelper().gotoGroupsPage();
	
	List<GroupData> newList = app.getGroupHelper().getGroupsList(); 
	
	oldList.remove(index);
	oldList.add(group);
	Collections.sort(oldList);
	assertEquals(newList, oldList);
	}

}

