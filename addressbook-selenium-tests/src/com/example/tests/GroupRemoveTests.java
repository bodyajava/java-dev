package com.example.tests;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import com.example.utils.SortedListOf;

public class GroupRemoveTests extends TestBase {
	
	@Test
	public void deleteCertainGroup() {
		
		app.navigateTo().groupsPage();
		SortedListOf<GroupData> oldList = app.getGroupHelper().getGroupsList();
		
		int index = app.getGroupHelper().generateIndexBasedOnListSize(oldList.size());
		app.getGroupHelper().deleteGroup(index);
		
		SortedListOf<GroupData> newList = app.getGroupHelper().getGroupsList();
		
		oldList.remove(index);
		assertEquals(newList, oldList);
	}

}
