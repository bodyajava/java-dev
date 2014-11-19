package com.example.tests;

import static com.example.tests.GroupDataGenerator.loadGroupsFromXmlFile;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.example.utils.SortedListOf;

public class GroupUpdateTests extends TestBase {
		
	@Test(dataProvider = "loadGroupsFromFile", dataProviderClass = TestBase.class)
	public void updateCertainGroup(GroupData group) throws Exception {
		
		//SortedListOf<GroupData> oldList = app.getGroupHelper().getGroupsList();
		SortedListOf<GroupData> oldList = new SortedListOf<GroupData>(app.getHibernateHelper().listGroups());
		
		int index = app.getGroupHelper().generateIndexBasedOnListSize(oldList.size());
		app.getGroupHelper().updateGroup(group, index);
		
		SortedListOf<GroupData> newList = app.getGroupHelper().getGroupsList();
		
		assertThat(newList, equalTo(oldList.without(index).withAdded(group)));
	}

}

