package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import org.testng.annotations.Test;
import com.example.utils.SortedListOf;

public class GroupUpdateTests extends TestBase {
		
	@Test(dataProvider = "loadGroupsFromFile", dataProviderClass = TestBase.class)
	public void updateCertainGroup(GroupData group) throws Exception {
		
		SortedListOf<GroupData> oldList = app.getModel().getGroups();
		
		int index = app.getGroupHelper().generateIndexBasedOnListSize(oldList.size());
		app.getGroupHelper().updateGroup(group, index);
		
		SortedListOf<GroupData> newList = app.getModel().getGroups();
		
		//assertThat(newList, equalTo(oldList.without(index).withAdded(group)));
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

