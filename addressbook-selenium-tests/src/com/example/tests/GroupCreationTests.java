package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import org.testng.annotations.Test;
import com.example.utils.SortedListOf;

public class GroupCreationTests extends TestBase {

	@Test(dataProvider = "loadGroupsFromFile", dataProviderClass = TestBase.class)
	public void testAddGroupWithValidData(GroupData group) throws Exception { 
		
		// SortedListOf<GroupData> oldList = app.getGroupHelper().getGroupsList();
		// SortedListOf<GroupData> oldList = new SortedListOf<GroupData>(app.getHibernateHelper().listGroups());
		SortedListOf<GroupData> oldList = app.getModel().getGroups();
		
		app.getGroupHelper().createGroup(group);
		
		//SortedListOf<GroupData> newList = app.getGroupHelper().getGroupsList();
		SortedListOf<GroupData> newList = app.getModel().getGroups();
		
		// assertThat(newList, equalTo(oldList.withAdded(group)));
		assertThat(newList, equalTo(oldList));
		
		if (checkMe()) {
			if ("yes".equals(app.getProperty("check.db"))) {
				assertThat(newList, equalTo(app.getHibernateHelper().listGroups()));
				System.out.println("Compared with DB");
			}
			if ("yes".equals(app.getProperty("check.ui"))) {
				assertThat(newList, equalTo(app.getGroupHelper().getUIGroups()));
				System.out.println("Compared with UI");
			}
		}
		
	}
    
}
