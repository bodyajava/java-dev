package com.example.tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import com.example.fw.Folders;

public class TestFolderRemoval extends TestBase {
	
	@Test
	public void testFolderRemoval() {
		String folder = "new_folder6";
		Folders oldFolders = app.getFolderHelper().getFolders();
		app.getFolderHelper().createFolder(folder);
		app.getFolderHelper().removeFolder(folder);				
		
		Folders newFolders = app.getFolderHelper().getFolders();		
		assertThat(newFolders, equalTo(oldFolders));
	}


}
