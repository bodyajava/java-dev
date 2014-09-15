package com.example.tests;

//import org.junit.*;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

  @Test
  public void testAddNonEmptyGroup() throws Exception {
    GroupData group = new GroupData();
	group.groupname = "New Congregation";
	group.header = "Description of Congregation";
	group.footer = "Full description of Congregation";

	openMainPage();
    driver.findElement(By.linkText("add new")).click();
    driver.findElement(By.name("firstname")).clear();
    driver.findElement(By.name("firstname")).sendKeys("Bogdan");
    driver.findElement(By.name("lastname")).clear();
    driver.findElement(By.name("lastname")).sendKeys("Laukhin");
    driver.findElement(By.name("address")).clear();
    driver.findElement(By.name("address")).sendKeys("ak. Dubinovici");
    driver.findElement(By.name("home")).clear();
    driver.findElement(By.name("home")).sendKeys("+37323162114");
    driver.findElement(By.name("mobile")).clear();
    driver.findElement(By.name("mobile")).sendKeys("+37369840320");
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys("bodyagmail@yandex.com");
    new Select(driver.findElement(By.name("bday"))).selectByVisibleText("18");
    new Select(driver.findElement(By.name("bmonth"))).selectByVisibleText("December");
    driver.findElement(By.name("byear")).clear();
    driver.findElement(By.name("byear")).sendKeys("1980");
    new Select(driver.findElement(By.name("new_group"))).selectByVisibleText("New Congregation");
    driver.findElement(By.name("address")).clear();
    driver.findElement(By.name("address")).sendKeys("ak. Dubinovici, 20, Balt, Moldova");
    driver.findElement(By.name("address2")).clear();
    driver.findElement(By.name("address2")).sendKeys("ak. Dubinovici, 20, Balt, Moldova");
    driver.findElement(By.name("phone2")).clear();
    driver.findElement(By.name("phone2")).sendKeys("Balt, Moldova");
    driver.findElement(By.name("submit")).click();
    driver.findElement(By.linkText("home")).click();

  
  
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
