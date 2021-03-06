package controller.commands;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import controller.LatexEditorController;
import model.Document;
import model.VersionsManager;

public class LoadCommand extends Command {
	
	public LoadCommand(LatexEditorController latexEditorController) {
		super(latexEditorController);	
	}


	@Override
	public void execute() {
		loadFromFile();
	}
	
	public void loadFromFile() {
		String fileContents = "";
		try {
			Scanner scanner = new Scanner(new FileInputStream(latexEditorController.getFilename()));
			while(scanner.hasNextLine()) {
				fileContents = fileContents + scanner.nextLine() + "\n";
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		latexEditorController.setDocumentContents(fileContents);
		
		latexEditorController.setType("emptyTemplate");
		
		fileContents = fileContents.trim();
		if(fileContents.startsWith("\\documentclass[11pt,twocolumn,a4paper]{article}")) {
			latexEditorController.setType("articleTemplate");
		}
		else if(fileContents.startsWith("\\documentclass[11pt,a4paper]{book}")) {
			latexEditorController.setType("bookTemplate");
		}
		else if(fileContents.startsWith("\\documentclass[11pt,a4paper]{report}")) {
			latexEditorController.setType("reportTemplate");
		}
		else if(fileContents.startsWith("\\documentclass{letter}")) {
			latexEditorController.setType("letterTemplate");
		}
	}


}
