import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;


@SuppressWarnings("serial")
public class Store extends JFrame{
	public Store() {
		super("Store");
		setSize(new Dimension(400,400));		
		setLayout(new FlowLayout());
		initialize();
		setVisible(true);
		
	}
	
	public void initialize() {
		InventoryPanel panel = new InventoryPanel();
		add(panel);
		InventoryPanel panel2 = new InventoryPanel();
		add(panel2);
	}
}
