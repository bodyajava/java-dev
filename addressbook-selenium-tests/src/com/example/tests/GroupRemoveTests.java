package com.example.tests;

import org.testng.annotations.Test;
import com.example.utils.SortedListOf;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class GroupRemoveTests extends TestBase {
	
	@Test
	public void deleteCertainGroup() {
		
		app.navigateTo().groupsPage();
		//SortedListOf<GroupData> oldList = app.getGroupHelper().getGroupsList();
		SortedListOf<GroupData> oldList = new SortedListOf<GroupData>(app.getHibernateHelper().listGroups());
		
		int index = app.getGroupHelper().generateIndexBasedOnListSize(oldList.size());
		app.getGroupHelper().deleteGroup(index);
		
		SortedListOf<GroupData> newList = app.getGroupHelper().getGroupsList();
		
		assertThat(newList, equalTo(oldList.without(index)));
	}

}
