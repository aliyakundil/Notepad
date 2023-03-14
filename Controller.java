import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.io.File;
import java.io.FileWriter;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.print.*;



//class Controller implements ActionListener, Printable {
public class Controller implements ActionListener {  
          
	private Viewer viewer;
	                                     
	public Controller(Viewer viewer) {
		this.viewer = viewer;
	}      

	public void actionPerformed(ActionEvent event) {
		String textFromTextArea = viewer.getTextFromTextArea();
		JTextArea textField = viewer.getTextField();
		String command = event.getActionCommand();

		if(command.equals("Exit")) {
				System.out.println("");
				System.exit(1);
		} else if(command.equals("New Document")) {
				viewer.update("");
		} else if(command.equals("Open File")) {
				String textFromFile = readFromFile();
//				String textFromFile = openFile();

				if(!textFromFile.equals("")) {
                		viewer.update(textFromFile); 
                        }   
		} else if(command.equals("Save File")) {
				String textToFile = viewer.getTextFromTextArea();
				saveToFile(textToFile);
				}  

		switch(command) {

			case "New":
				newDocument();
			break;
			case "Cut":
				viewer.getTextField().cut();
			break;
			case "Paste":
				viewer.getTextField().paste();
			break;
			case "Copy":
				viewer.getTextField().copy();
			break;
			case "Print":
				PrintText printText = new PrintText();
				printText.printerJob(textFromTextArea);
			break;                     

		} 
	}

		public void newDocument() {

			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showOpenDialog(new JFrame());

			File file = fc.getSelectedFile();

			String fileName = file.getName();

			viewer.setAlmas(fileName);
    	}



	    public void saveToFile(String value ) {

			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showSaveDialog(viewer.getMainFrame());

			if(returnVal == 0) {

			File fileName = fc.getSelectedFile();
			FileOutputStream out = null;
				try {
					out = new FileOutputStream(fileName);
					for (int i = 0; i < value.length(); i++) {
					int c = value.charAt(i);
					out.write(c);
					}
					out.close();
				} catch (IOException e) {
					System.out.println(e);
				}
			}	
		}

		private String readFromFile()  {
			String text = "";
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showOpenDialog(viewer.getMainFrame());

			if(returnVal == 0) {

			File fileName = fc.getSelectedFile();
			FileInputStream in = null;
				try {
					in = new FileInputStream(fileName);
					int c;
					
					while ((c = in.read()) !=-1) {
					char symbol = (char)c;
					text = text + symbol;
				}
					in.close();
				} catch(IOException e) {
					System.out.println(e);
				}
			}
			return text;
		
	}
	
}
		