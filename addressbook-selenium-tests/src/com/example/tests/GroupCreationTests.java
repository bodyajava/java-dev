package com.example.tests;
//import org.junit.*;
import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {
  @Test
  public void testAddNonEmptyGroup() throws Exception {
    GroupData group = new GroupData();
	group.groupname = "New Congregation";
	group.header = "Description of Congregation";
	group.footer = "Full description of Congregation";
	app.getNavigationHelper().openMainPage();
    app.getNavigationHelper().gotoGroupsPage();
    app.getGroupHelper().addNewGroup();
    app.getGroupHelper().fillGroupForm(group);
    app.getGroupHelper().submitNewGroupForm();
    app.getNavigationHelper().gotoGroupsPage();
  }

  @Test
  public void testAddEmptyGroupCreation() throws Exception {
	app.getNavigationHelper().openMainPage();
    app.getNavigationHelper().gotoGroupsPage();
    app.getGroupHelper().addNewGroup();
    app.getGroupHelper().fillGroupForm(new GroupData("", "", ""));
    app.getGroupHelper().submitNewGroupForm();
    app.getNavigationHelper().gotoGroupsPage();
  }
}
