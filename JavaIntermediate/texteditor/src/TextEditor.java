/**
 Provided in 2013 TechLab Education
 
 The MIT License (MIT)
 
 Permission is hereby granted, free of charge, to any person obtaining a copy
 of this software and associated documentation files (the "Software"), to deal
 in the Software without restriction, including without limitation the rights
 to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 copies of the Software, and to permit persons to whom the Software is
 furnished to do so, subject to the following conditions:
 
 The above copyright notice and this permission notice shall be included in
 all copies or substantial portions of the Software.
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;

import javax.swing.*;

@SuppressWarnings("serial")
/**
 * A simple text editor view.
 * @author (your name) 
 */
public class TextEditor extends JApplet 
	implements ActionListener {
	private TextEditorModel model;

	// add components here
	private JTextField field;
	private JTextArea area;
	
	// Remember whether or not we have saved our work.
	private boolean saved = false;
	private String saveFile;

	/**
	 * Called by the browser or applet viewer to inform this JApplet that it has
	 * been loaded into the system. It is always called before the first time
	 * that the start method is called.
	 */
	public void init() {
		// Create a model and view object.
		model = new TextEditorModel();
		// Set the size of this applet to the size that the view wants.
		this.setSize(new Dimension(500, 500));
		// Make a new content pane to organize what we put into the applet.
		this.setLayout(new GridLayout());
		
		initializeComponents();
	}

	/**
	 * Initializes the components of this applet.
	 */
	public void initializeComponents() {
		// Initialize the buttons.
		JMenuBar menuBar = new JMenuBar();
		
		JMenu fileMenu = createMenu("file", new String[] {"new", "open", "save", "save as"});
		JMenu editMenu = createMenu("edit",
				new String[] {"remove profanity", "remove troll", "encode", "decode", "remove insults"}
		);
		
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		setJMenuBar(menuBar);
				
		// Initializing a text area.
		area = new JTextArea();
		area.setLineWrap(true);
		area.setBackground(Color.BLUE);
		area.setFont(new Font("Arial", 20, 20));
		add(area);
	}
	
	public JMenu createMenu(String name, String[] items) {
		JMenu menu = new JMenu(name);
		for(String item : items) {
			menu.add(createItem(item));
		}
		return menu;
	}
	
	public JMenuItem createItem(String name) {
		JMenuItem item = new JMenuItem(name);
		item.setActionCommand(name);
		item.addActionListener(this);
		return item;
	}

	/**
	 * This method is called whenever a component with an action value is
	 * activated.
	 */
	public void actionPerformed(ActionEvent a) {
		if (a.getSource() == field) {
			// Then our text field is sending us data.
		}
		else {
			// Otherwise, some other component is sending us data.
			String action = a.getActionCommand();
			if (action.equals("new")) {
				System.out.println("new.");
			}
			// Get the file name to open, then set the text area to the contents.
			if (action.equals("open")) {
				JFileChooser fc = new JFileChooser();
				int returnVal = fc.showOpenDialog(this);

		        if (returnVal == JFileChooser.APPROVE_OPTION) {
		            File file = fc.getSelectedFile();
		            area.setText(model.openFile(file.getAbsolutePath()));
		        } else {
		            
		        }
			}
			// Save the contents of the text area to a file, making a new file if necessary.
			if (action.equals("save")) {
				if (saved) {
					model.saveFile(saveFile, area.getText());
				} else {
					JFileChooser fc = new JFileChooser();
					int returnVal = fc.showSaveDialog(this);

			        if (returnVal == JFileChooser.APPROVE_OPTION) {
			            File file = fc.getSelectedFile();
			            saveFile = file.getAbsolutePath();
			            model.saveFile(file.getAbsolutePath(),area.getText());
			            saved = true;
			        } 
				}
			
			}
			// Saves the contents of the text area to a new file, even if it has already been saved.
			if (action.equals("save as")) {
				JFileChooser fc = new JFileChooser();
				int returnVal = fc.showSaveDialog(this);

		        if (returnVal == JFileChooser.APPROVE_OPTION) {
		            File file = fc.getSelectedFile();
		           model.saveFile(file.getAbsolutePath(),area.getText());
		        } else {
		           }
		       
			}
			
			if (action.equals("undo")) {
				//blah blah
			}
			
			if (action.equals("remove profanity")) {
				String text = area.getText();
				text = text.replaceAll("\\bheck\\b", "cow");
				text = text.replaceAll("\\bdarn\\b", "baaa");
				area.setText(text);
			}
			
			if (action.equals("remove troll")) {
				String text = area.getText();
				text = text.replaceAll("tr(ol)+", "...");
				text = text.replaceAll("y+e+", "yay");
				text = text.replaceAll("(wub)+", "beep");
				area.setText(text);
			}
			
			if (action.equals("encode")) {
				String text = area.getText();
				String newText = "";
				char[] array = text.toCharArray();
				
				for (char letter : text.toCharArray()) {
					if (Character.isLetter(letter)) {
						newText = newText + (char)(letter + 1);
					}
					else {
						newText = newText + letter;
					}
				}
				area.setText(newText);
			}
			
			if (action.equals("decode")) {
				String text = area.getText();
				area.setText(text);
			}
			
			if (action.equals("remove insults")) {
				String text = area.getText();
				text = text.replaceAll("you (suck|are terrible) at ([^\\.\\,])", "you are good at $2 and not $1");
				area.setText(text);
			}
		}
	}
}
