package com.example.tests;
import java.util.List;
//import org.junit.*;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class GroupCreationTests extends TestBase {
	
  @Test
  public void testAddNonEmptyGroup() throws Exception {
    // save old list state
	List<GroupData> oldList = app.getGroupHelper().getGroupsList();
	  
	// actions - adding new record  
	GroupData group = new GroupData();
	group.name = "New";
	group.header = "Description of Congregation";
	group.footer = "Full description of Congregation";
	app.getNavigationHelper().openMainPage();
    app.getNavigationHelper().gotoGroupsPage();
    app.getGroupHelper().addNewGroup();
    app.getGroupHelper().fillGroupForm(group);
    app.getGroupHelper().submitNewGroupForm();
    app.getNavigationHelper().gotoGroupsPage();
    
    // save new list state
    List<GroupData> newList = app.getGroupHelper().getGroupsList(); 
    
    // compare list's states
    //assertEquals(newList.size(), oldList.size() + 1);
    
    oldList.add(group);
    assertEquals(newList, oldList);
  }

 /* 
 @Test
 public void testAddEmptyGroupCreation() throws Exception {
	app.getNavigationHelper().openMainPage();
    app.getNavigationHelper().gotoGroupsPage();
    app.getGroupHelper().addNewGroup();
    app.getGroupHelper().fillGroupForm(new GroupData("", "", ""));
    app.getGroupHelper().submitNewGroupForm();
    app.getNavigationHelper().gotoGroupsPage();
  }
  */
  
}
