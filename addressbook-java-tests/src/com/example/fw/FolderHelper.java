package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;

import org.netbeans.jemmy.operators.JButtonOperator;
import org.netbeans.jemmy.operators.JDialogOperator;
import org.netbeans.jemmy.operators.JFrameOperator;
import org.netbeans.jemmy.operators.JLabelOperator;
import org.netbeans.jemmy.operators.JTextFieldOperator;
import org.netbeans.jemmy.operators.JTreeOperator;

public class FolderHelper {

	private final ApplicationManager manager;

	public FolderHelper(ApplicationManager applicationManager) {
		this.manager = applicationManager;
	}

	public Folders getFolders() {
		List<String> list = new ArrayList<String>();
		JTreeOperator tree = new JTreeOperator(manager.getApplication());
		Object[] folders = tree.getChildren(tree.getRoot());
		for (Object folder : folders) {
			list.add(folder.toString());
		}
		return new Folders (list);
	}

	public String createFolder(String folderName) {
		manager.getMenuHelper().pushCreateFolder();
		JDialogOperator dialog = new JDialogOperator(manager.getApplication());
		new JTextFieldOperator(dialog).setText(folderName);
		new JButtonOperator(dialog, "OK").push();
		return waitDialogMessage("Warning", 3000);
	}
	
	private String waitDialogMessage(String title, int timeout) {
		long start = System.currentTimeMillis();
		long currentTime = start;
		while (currentTime < start + timeout) {
			JDialog dialog = JDialogOperator.findJDialog(manager.getApplication().getOwner(), title, false, false);
			if (dialog != null) {
				JDialogOperator dialogOp = new JDialogOperator(dialog);
				String message = new JLabelOperator(dialogOp).getText(); 
				dialogOp.requestClose();
				return message;
			}

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			currentTime = System.currentTimeMillis();			
		}
		return null;
	}

}
