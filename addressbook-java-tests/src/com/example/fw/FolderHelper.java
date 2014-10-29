package com.example.fw;

import java.util.ArrayList;
import java.util.List;
import org.netbeans.jemmy.operators.JButtonOperator;
import org.netbeans.jemmy.operators.JDialogOperator;
import org.netbeans.jemmy.operators.JTextFieldOperator;
import org.netbeans.jemmy.operators.JTreeOperator;

public class FolderHelper extends HelperBase {

	public FolderHelper(ApplicationManager applicationManager) {
		super(applicationManager);
	}

	public Folders getFolders() {
		List<String> list = new ArrayList<String>();
		JTreeOperator tree = new JTreeOperator(mainFrame);
		Object[] folders = tree.getChildren(tree.getRoot());
		for (Object folder : folders) {
			list.add(folder.toString());
		}
		return new Folders(list);
	}

	public String createFolder(String folderName) {
		manager.getMenuHelper().pushCreateFolder();
		JDialogOperator dialog = new JDialogOperator(mainFrame);
		new JTextFieldOperator(dialog).setText(folderName);
		new JButtonOperator(dialog, "OK").push();
		return waitDialogMessage("Warning", 3000);
	}
	
	public void removeFolder(String folder2) {
		JTreeOperator tree = new JTreeOperator(mainFrame);
		tree.selectRow(1);
		manager.getMenuHelper().pushRemoveFolder();
		JDialogOperator dialog = new JDialogOperator(mainFrame);
		new JButtonOperator(dialog, "Yes").push();
	}

}
