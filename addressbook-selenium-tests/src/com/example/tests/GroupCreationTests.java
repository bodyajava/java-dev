package com.example.tests;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import org.testng.annotations.Test;
import com.example.utils.SortedListOf;

public class GroupCreationTests extends TestBase {
	
	@Test(dataProvider = "randomValidGroupGenerator")
	public void testAddGroupWithValidData(GroupData group) throws Exception { 
		
		SortedListOf<GroupData> oldList = app.getGroupHelper().getGroupsList();
		
		app.getGroupHelper().createGroup(group);
		
		SortedListOf<GroupData> newList = app.getGroupHelper().getGroupsList(); 
		
		assertThat(newList, equalTo(oldList.withAdded(group)));
	}
    
}
