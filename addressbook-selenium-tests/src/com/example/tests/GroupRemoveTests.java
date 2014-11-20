package com.example.tests;

import org.testng.annotations.Test;
import com.example.utils.SortedListOf;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class GroupRemoveTests extends TestBase {
	
	@Test
	public void deleteCertainGroup() {
		
		SortedListOf<GroupData> oldList = app.getModel().getGroups();
		
		app.navigateTo().groupsPage();
		int index = app.getGroupHelper().generateIndexBasedOnListSize(oldList.size());
		app.getGroupHelper().deleteGroup(index);
		
		SortedListOf<GroupData> newList = app.getModel().getGroups();
		
		assertThat(newList, equalTo(oldList));
		assertThat(newList, equalTo(app.getHibernateHelper().listGroups()));
		System.out.println("Compared with DB");
		assertThat(newList, equalTo(app.getGroupHelper().getUIGroups()));
		System.out.println("Compared with UI");
	}

}
