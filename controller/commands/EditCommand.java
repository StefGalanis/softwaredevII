package controller.commands;

import controller.LatexEditorController;
import model.Document;

public class EditCommand extends Command {
	
	
	public EditCommand(LatexEditorController latexEditorController) {
		super(latexEditorController);
	}


	@Override
	public void execute() {
		// TODO Auto-generated method stub
		saveContents();
	}

	public void saveContents() {
		// TODO Auto-generated method stub
		if(latexEditorController.isVersionsManagerEnabled()) {
			latexEditorController.setCurrentVersion(latexEditorController.getCurrentDocument());
			System.out.println(latexEditorController.getCurrentDocument().getContents());
			latexEditorController.getCurrentDocument().changeVersion();
		}
		latexEditorController.setContents(latexEditorController.getText());
	}
	
}
