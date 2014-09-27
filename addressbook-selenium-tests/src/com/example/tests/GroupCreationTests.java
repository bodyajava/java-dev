package com.example.tests;
import java.util.Collections;
import java.util.List;
//import org.junit.*;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class GroupCreationTests extends TestBase {
	
  @Test
  public void testAddNonEmptyGroup() throws Exception {  
	GroupData group = new GroupData();
	group.name = "a";
	group.header = "Description of Congregation";
	group.footer = "Full description of Congregation";
	app.getNavigationHelper().openMainPage();
    app.getNavigationHelper().gotoGroupsPage();

    // save old list state
	List<GroupData> oldList = app.getGroupHelper().getGroupsList();

	// actions
	app.getGroupHelper().addNewGroup();
    app.getGroupHelper().fillGroupForm(group);
    app.getGroupHelper().submitNewGroupForm();
    app.getNavigationHelper().gotoGroupsPage();
    
    // save new list state
    List<GroupData> newList = app.getGroupHelper().getGroupsList(); 
    
    // compare list's states
    // assertEquals(newList.size(), oldList.size() + 1);
    oldList.add(group);
    Collections.sort(oldList);
    assertEquals(newList, oldList);
  }
  
 @Test
 public void testAddEmptyGroupCreation() throws Exception {
	GroupData group = new GroupData("", "", "");
	app.getNavigationHelper().openMainPage();
	app.getNavigationHelper().gotoGroupsPage();
	
	// save old list state
	List<GroupData> oldList = app.getGroupHelper().getGroupsList();
	
	// actions
	app.getGroupHelper().addNewGroup();
	app.getGroupHelper().fillGroupForm(group);
	app.getGroupHelper().submitNewGroupForm();
	app.getNavigationHelper().gotoGroupsPage();
	
	// save new list state
	List<GroupData> newList = app.getGroupHelper().getGroupsList(); 
	
	// compare list's states
	// assertEquals(newList.size(), oldList.size() + 1);
	oldList.add(group);
	Collections.sort(oldList);
	assertEquals(newList, oldList);
  }
  
}
