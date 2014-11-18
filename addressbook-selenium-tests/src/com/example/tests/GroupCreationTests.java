package com.example.tests;

import static com.example.tests.GroupDataGenerator.loadGroupsFromCsvFile;
import static com.example.tests.GroupDataGenerator.loadGroupsFromXmlFile;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.example.utils.SortedListOf;

public class GroupCreationTests extends TestBase {
	
	@DataProvider
	public static Iterator<Object[]> loadGroupsFromFile() throws IOException {
		app.navigateTo().groupsPage();
		return wrapGroupsIntoObjects(loadGroupsFromXmlFile(new File("groups.xml"))).iterator();
	  }

	@Test(dataProvider = "loadGroupsFromFile")
	public void testAddGroupWithValidData(GroupData group) throws Exception { 
		
		// SortedListOf<GroupData> oldList = app.getGroupHelper().getGroupsList();
		SortedListOf<GroupData> oldList = new SortedListOf<GroupData>(app.getHibernateHelper().listGroups());
		
		app.getGroupHelper().createGroup(group);
		
		SortedListOf<GroupData> newList = app.getGroupHelper().getGroupsList();
		//SortedListOf<GroupData> newList = new SortedListOf<GroupData>(app.getHibernateHelper().listGroups());
		
		assertThat(newList, equalTo(oldList.withAdded(group)));
	}
    
}
