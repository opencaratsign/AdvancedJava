import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Rawr extends JFrame implements ActionListener{
	
	ChatClient client;
	JTextArea pane;
	JTextField field;
	private JScrollPane scroll;
	
	public static void main(String[] args) {
		new Rawr();
		
	}
	
	public Rawr() {
		super("Rawr Istant Messenger");
		setSize(new Dimension(600,600));
		setLayout(new FlowLayout());
		client = new ChatClient();		
		initialize();
		
		Timer t = new Timer();
		t.schedule(new UpdateTask(), 0, 100);
		
		/*Thread updateThread = new Thread(new UpdateTask());
		*updateThread.start();
		*/
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private void initialize() {
		pane = new JTextArea(30,30);
		scroll = new JScrollPane(pane);
		add(scroll, BorderLayout.CENTER);
		
		
		field = new JTextField(20);
		field.addActionListener(this);
		add(field, BorderLayout.SOUTH);
	}

	public void update() {
		String update = client.getUpdate();
		while (! update.equals("")) {
			String contents = pane.getText();
			pane.setText(update + contents);
			JScrollBar scrollbar = scroll.getVerticalScrollBar();
			scrollbar.setValue(scrollbar.getMinimum());
			update = client.getUpdate();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == field) {
			String message = field.getText();
			if (! message.equals("")) {
				client.submit(message);
			}
			field.setText("");
			
		}
		
	}
	
	class UpdateTask extends TimerTask {

		@Override
		public void run() {
			update();
		}
		
	}
	
}
