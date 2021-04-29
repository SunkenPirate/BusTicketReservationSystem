package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SpringLayout;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class FareCalculatorPanel extends JPanel {

    private static final long serialVersionUID = 6731726915536079381L;
    private JComboBox<String> from;
    private JComboBox<String> to;
    private JButton btnCalculateFare;
    private JLabel lblShowfare;

    
    public FareCalculatorPanel() {
    	SpringLayout springLayout = new SpringLayout();
    	setLayout(springLayout);
    	
    	JLabel lblFrom = new JLabel("From:");
    	springLayout.putConstraint(SpringLayout.NORTH, lblFrom, 10, SpringLayout.NORTH, this);
    	springLayout.putConstraint(SpringLayout.WEST, lblFrom, 173, SpringLayout.WEST, this);
    	lblFrom.setFont(new Font("Tahoma", Font.PLAIN, 14));
    	add(lblFrom);
    	
    	from = new JComboBox<String>();
    	springLayout.putConstraint(SpringLayout.NORTH, from, 10, SpringLayout.NORTH, this);
    	springLayout.putConstraint(SpringLayout.WEST, from, 20, SpringLayout.EAST, lblFrom);
    	springLayout.putConstraint(SpringLayout.EAST, from, 169, SpringLayout.EAST, lblFrom);
    	add(from);
    	
    	JLabel lblTo = new JLabel("To:");
    	springLayout.putConstraint(SpringLayout.NORTH, lblTo, 0, SpringLayout.NORTH, lblFrom);
    	springLayout.putConstraint(SpringLayout.WEST, lblTo, 24, SpringLayout.EAST, from);
    	springLayout.putConstraint(SpringLayout.SOUTH, lblTo, 0, SpringLayout.SOUTH, lblFrom);
    	lblTo.setFont(new Font("Tahoma", Font.PLAIN, 14));
    	add(lblTo);
    	
    	to = new JComboBox<String>();
    	springLayout.putConstraint(SpringLayout.NORTH, to, 0, SpringLayout.NORTH, lblFrom);
    	springLayout.putConstraint(SpringLayout.WEST, to, 16, SpringLayout.EAST, lblTo);
    	springLayout.putConstraint(SpringLayout.EAST, to, 174, SpringLayout.EAST, lblTo);
    	add(to);
    	
    	btnCalculateFare = new JButton("Calculate fare");
    	springLayout.putConstraint(SpringLayout.NORTH, btnCalculateFare, 21, SpringLayout.SOUTH, from);
    	springLayout.putConstraint(SpringLayout.WEST, btnCalculateFare, 341, SpringLayout.WEST, this);
    	springLayout.putConstraint(SpringLayout.SOUTH, btnCalculateFare, -245, SpringLayout.SOUTH, this);
    	btnCalculateFare.setFont(new Font("Tahoma", Font.BOLD, 14));
    	add(btnCalculateFare);
    	
    	lblShowfare = new JLabel("");
    	springLayout.putConstraint(SpringLayout.NORTH, lblShowfare, 19, SpringLayout.SOUTH, btnCalculateFare);
    	springLayout.putConstraint(SpringLayout.WEST, lblShowfare, 360, SpringLayout.WEST, this);
    	springLayout.putConstraint(SpringLayout.SOUTH, lblShowfare, 147, SpringLayout.NORTH, this);
    	springLayout.putConstraint(SpringLayout.EAST, lblShowfare, -583, SpringLayout.EAST, this);
    	lblShowfare.setFont(new Font("Tahoma", Font.BOLD, 16));
    	add(lblShowfare);

    }
    
    public JComboBox<String> getCBFrom() {
        return from;
    }

    public JComboBox<String> getCBTo() {
        return to;
    }

    public JButton getBtnCalculateFare() {
        return btnCalculateFare;
    }

    public JLabel getLblShowfare() {
        return lblShowfare;
    }
}
