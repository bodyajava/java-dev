package com.example.fw;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.example.tests.GroupData;
import com.example.utils.SortedListOf;

public class GroupHelper extends WebDriverHelperBase{

	public GroupHelper(ApplicationManager manager) {
		super(manager);
	}
	
	public SortedListOf<GroupData> getUIGroups() {
		SortedListOf<GroupData> groups = new SortedListOf<GroupData>();
		
		List<WebElement> records = driver.findElements(By.xpath("//input"));
		if (records.size() > 3) {
			List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
			for (WebElement checkbox : checkboxes) {
				String title = checkbox.getAttribute("title");
				String name = title.substring("Select (".length(), title.length() - ")".length());
				groups.add(new GroupData().withName(name));
			}
		}
		return groups;
	}
	
	public void createGroup(GroupData group) {
		addNewGroup();
		fillGroupForm(group);
		submitNewGroupForm();
		returnToGroupsPage();
		manager.getModel().addGroup(group);
	}

	public void updateGroup(GroupData group, int index) {
		openGroupForUpdate(index);
		fillGroupForm(group);
		submitUpdatedGroupForm();
		returnToGroupsPage();
		manager.getModel().removeGroup(index).addGroup(group);
	}

	public GroupHelper deleteGroup(int index) {
		selectGroupByIndex(index);
	    clickDeleteButton();
	    returnToGroupsPage();
	    manager.getModel().removeGroup(index);
	    return this;
	}

	public GroupHelper openGroupForUpdate(int index) {
		selectGroupByIndex(index);
		clickEditButton();
	    return this;
	}


	// LOW LEVEL METHODS =================================================================================
	
	public GroupHelper addNewGroup() {
	    click(By.name("new"));
	    return this;
	}

	public GroupHelper fillGroupForm(GroupData group) {
	    type(By.name("group_name"), group.getName());
	    type(By.name("group_header"), group.getHeader());
	    type(By.name("group_footer"), group.getFooter());   
	    return this;
	}

	public GroupHelper submitNewGroupForm() {
	    click(By.name("submit"));	
	    return this;
	}

	public GroupHelper returnToGroupsPage() {
	    click(By.linkText("group page"));
	    return this;
	}

	public void selectGroupByIndex(int index) {
		click(By.xpath("//input[@name='selected[]'][" + (index+1) + "]"));
	}

	public void clickDeleteButton() {
		click(By.name("delete"));
	}

	public void clickEditButton() {
		click(By.name("edit"));
	}

	public GroupHelper submitUpdatedGroupForm() {
	    click(By.name("update"));
	    return this;
	}

	public void deleteAllGroups() {
		manager.navigateTo().groupsPage();
		List<WebElement> rows = driver.findElements(By.name("selected[]"));
		int index = rows.size();
		for (int i = 0; i < index; i++) {
			selectGroupByIndex(i);
		}
	    clickDeleteButton();
	    returnToGroupsPage();
	}

}
