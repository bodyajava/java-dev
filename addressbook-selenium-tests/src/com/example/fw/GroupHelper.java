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

	public void submitGroupForm() {
	    click(By.name("submit"));		
	}

	public void gobackToGroupPage() {
	    click(By.name("group page"));
	}

}
