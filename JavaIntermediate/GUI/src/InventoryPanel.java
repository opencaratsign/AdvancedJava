import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;


public class InventoryPanel extends JPanel{
	
	String[] columns;
	Object[][] data;
	
	public InventoryPanel() {
		super();
		this.setSize(new Dimension(400,200));
		initialize();
		setLayout(new GridLayout());
		setVisible(true);
	}
	

	
	private void initialize() {
		Object[][] data = {
			 {"Apples", new Double(0.99)},
			 {"Bananas", new Double(0.56)},
			 {"Bread", new Double(1.99)},
			 {"Peanut Butter", new Double(2.50)},
			 {"Jelly", new Double(1.50)} 			 	
			};
		String[] columns = {"Name", "Price"};
		JTable table = new JTable(data, columns);
		table.
		add(table);
		
	}
}
