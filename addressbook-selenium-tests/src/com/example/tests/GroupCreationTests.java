package com.example.tests;

import static com.example.tests.GroupDataGenerator.loadGroupsFromCsvFile;
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
		return wrapGroupsIntoObjects(loadGroupsFromCsvFile(new File("groups.txt"))).iterator();
	  }

	@Test(dataProvider = "loadGroupsFromFile")
	public void testAddGroupWithValidData(GroupData group) throws Exception { 
		
		SortedListOf<GroupData> oldList = app.getGroupHelper().getGroupsList();
		
		app.getGroupHelper().createGroup(group);
		
		SortedListOf<GroupData> newList = app.getGroupHelper().getGroupsList(); 
		
		assertThat(newList, equalTo(oldList.withAdded(group)));
	}
    
}
