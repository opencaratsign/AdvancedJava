

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSlider;


@SuppressWarnings("serial")
public class MusicPlayer extends JFrame implements ActionListener
{
	
	public MusicPlayer() {
		super("Music Player");
		init();
		setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void init() {
		this.setSize(new Dimension(500, 500)); 
		this.setLayout(new FlowLayout());
		initializeComponents();
	}
	
	//Generate buttons
	private void initializeComponents() {
		JMenuBar menuBar = new JMenuBar();
		
		JMenu fileMenu = createMenu("file", new String[] {"new", "open"});
		JMenu editMenu = createMenu("view",
				new String[] {"negative"}
		);
		
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		setJMenuBar(menuBar);
		
		JButton playButton = new JButton("Play");
		playButton.setActionCommand("playClicked");
		playButton.addActionListener(this);
		playButton.setLocation(0, 30);
		add(playButton);
		JButton pauseButton = new JButton("Pause");
		pauseButton.setActionCommand("pauseClicked");
		pauseButton.addActionListener(this);
		add(pauseButton);
		JButton stopButton = new JButton("Stop");
		stopButton.setActionCommand("stopClicked");
		stopButton.addActionListener(this);
		add(stopButton);
		
		JLabel label = new JLabel("A music player.");
		add(label);
		JSlider volume = new JSlider();
		add(volume);
		
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
	

	@Override
	//Directions for button commands
	public void actionPerformed(ActionEvent e) {
		 if (e.getActionCommand().equals("playClicked")) {
			 System.out.println("Yay!");
		}
		 
		 if (e.getActionCommand().equals("pauseClicked")) {
			 System.out.println("Nay!");
		 }
		 
		 if (e.getActionCommand().equals("stopClicked")) {
			 System.out.println("Stop!");
		 }

	}

}
