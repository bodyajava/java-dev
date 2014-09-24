package com.example.fw;

import org.openqa.selenium.By;
import com.example.tests.GroupData;

public class GroupHelper extends HelperBase{

	public GroupHelper(ApplicationManager manager) {
		super(manager);
	}

	public void addNewGroup() {
	    click(By.name("new"));
	}

	public void fillGroupForm(GroupData group) {
	    type(By.name("group_name"), group.groupname);
	    type(By.name("group_header"), group.header);
	    type(By.name("group_footer"), group.footer);   
	}

	public void submitNewGroupForm() {
	    click(By.name("submit"));		
	}

	public void gobackToGroupPage() {
	    click(By.name("group page"));
	}

	public void selectGroupByIndex(int index) {
		click(By.xpath("//input[@name='selected[]'][" + index + "]"));
	}

	public void deleteGroup(int index) {
		selectGroupByIndex(index);
	    click(By.name("delete"));
	}

	public void openGroupForUpdate(int index) {
		selectGroupByIndex(index);
		click(By.name("edit"));
	}

	public void submitUpdatedGroupForm() {
	    click(By.name("update"));
	}

}
