package com.example.tests;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import com.example.utils.SortedListOf;

public class GroupUpdateTests extends TestBase {
	
	@Test(dataProvider = "randomValidGroupGenerator")
	public void updateCertainGroup(GroupData group) throws Exception {
		
		SortedListOf<GroupData> oldList = app.getGroupHelper().getGroupsList();
		
		int index = app.getGroupHelper().generateIndexBasedOnListSize(oldList.size());
		app.getGroupHelper().updateGroup(group, index);
		
		SortedListOf<GroupData> newList = app.getGroupHelper().getGroupsList();
		oldList.remove(index);
		oldList.add(group);
		assertEquals(newList, oldList);
	}

}

