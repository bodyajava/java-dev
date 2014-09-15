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

	openMainPage();
    gotoGroupsPage();
    addNewGroup();
    fillGroupForm(group);
    submitGroupForm();
    gobackToGroupPage();
  }

  @Test
  public void testAddEmptyGroupCreation() throws Exception {
	openMainPage();
    gotoGroupsPage();
    addNewGroup();
    fillGroupForm(new GroupData("", "", ""));
    submitGroupForm();
    gobackToGroupPage();
  }
}
