package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SpringLayout;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TicketsManagementTab extends JPanel {
	
    private static final long serialVersionUID = -1705120952169642162L;
	private JTextField tfTicketNumber;
	private JTextField tfPassengerName;
	private JTextField tfMobile;
	private JTextField tfEmail;
	private JTable ticketTable;
	private JScrollPane scrollPane;
	private JButton btnRefreshTable;
	private JButton btnDelete;
	private JButton btnUpdate;
	private JButton btnFetch;
	private JButton btnPrintSave;

    
    public TicketsManagementTab() {
    	SpringLayout springLayout = new SpringLayout();
    	setLayout(springLayout);
    	
    	JLabel lblTicketNumber = new JLabel("Ticket number:");
    	lblTicketNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
    	springLayout.putConstraint(SpringLayout.NORTH, lblTicketNumber, 10, SpringLayout.NORTH, this);
    	springLayout.putConstraint(SpringLayout.WEST, lblTicketNumber, 10, SpringLayout.WEST, this);
    	add(lblTicketNumber);
    	
    	tfTicketNumber = new JTextField();
    	springLayout.putConstraint(SpringLayout.NORTH, tfTicketNumber, 0, SpringLayout.NORTH, lblTicketNumber);
    	springLayout.putConstraint(SpringLayout.WEST, tfTicketNumber, 37, SpringLayout.EAST, lblTicketNumber);
    	springLayout.putConstraint(SpringLayout.EAST, tfTicketNumber, 150, SpringLayout.EAST, lblTicketNumber);
    	add(tfTicketNumber);
    	tfTicketNumber.setDocument(new JTextFieldIntOnlyFilter()); 
    	tfTicketNumber.setColumns(10);
    	
    	JLabel lblPassengerName = new JLabel("Passenger name:");
    	springLayout.putConstraint(SpringLayout.WEST, lblPassengerName, 0, SpringLayout.WEST, lblTicketNumber);
    	lblPassengerName.setFont(new Font("Tahoma", Font.PLAIN, 14));
    	add(lblPassengerName);
    	
    	JLabel lblMobile = new JLabel("Mobile:");
    	springLayout.putConstraint(SpringLayout.WEST, lblMobile, 0, SpringLayout.WEST, lblTicketNumber);
    	lblMobile.setFont(new Font("Tahoma", Font.PLAIN, 14));
    	add(lblMobile);
    	
    	JLabel lblEmail = new JLabel("e-mail:");
    	springLayout.putConstraint(SpringLayout.WEST, lblEmail, 0, SpringLayout.WEST, lblTicketNumber);
    	lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
    	add(lblEmail);
    	
    	tfPassengerName = new JTextField();
    	springLayout.putConstraint(SpringLayout.SOUTH, lblPassengerName, 0, SpringLayout.SOUTH, tfPassengerName);
    	springLayout.putConstraint(SpringLayout.NORTH, tfPassengerName, 6, SpringLayout.SOUTH, tfTicketNumber);
    	springLayout.putConstraint(SpringLayout.WEST, tfPassengerName, 0, SpringLayout.WEST, tfTicketNumber);
    	springLayout.putConstraint(SpringLayout.EAST, tfPassengerName, 0, SpringLayout.EAST, tfTicketNumber);
    	add(tfPassengerName);
    	tfPassengerName.setColumns(10);
    	
    	tfMobile = new JTextField();
    	springLayout.putConstraint(SpringLayout.SOUTH, lblMobile, 0, SpringLayout.SOUTH, tfMobile);
    	springLayout.putConstraint(SpringLayout.NORTH, tfMobile, 6, SpringLayout.SOUTH, tfPassengerName);
    	springLayout.putConstraint(SpringLayout.WEST, tfMobile, 0, SpringLayout.WEST, tfTicketNumber);
    	springLayout.putConstraint(SpringLayout.EAST, tfMobile, 0, SpringLayout.EAST, tfTicketNumber);
    	tfMobile.setDocument(new JTextFieldIntOnlyFilter());
    	add(tfMobile);
    	tfMobile.setColumns(10);
    	
    	tfEmail = new JTextField();
    	springLayout.putConstraint(SpringLayout.SOUTH, lblEmail, 0, SpringLayout.SOUTH, tfEmail);
    	springLayout.putConstraint(SpringLayout.NORTH, tfEmail, 6, SpringLayout.SOUTH, tfMobile);
    	springLayout.putConstraint(SpringLayout.WEST, tfEmail, 0, SpringLayout.WEST, tfTicketNumber);
    	springLayout.putConstraint(SpringLayout.EAST, tfEmail, 0, SpringLayout.EAST, tfTicketNumber);
    	add(tfEmail);
    	tfEmail.setColumns(10);
    	
    	JLabel lblInfoYouCan = new JLabel("INFO: You can only update passenger info and");
    	springLayout.putConstraint(SpringLayout.WEST, lblInfoYouCan, 10, SpringLayout.WEST, this);
    	add(lblInfoYouCan);
    	
    	JLabel lblIfYouWant = new JLabel("other info please delte ticket and buy it again");
    	springLayout.putConstraint(SpringLayout.WEST, lblIfYouWant, 10, SpringLayout.WEST, this);
    	springLayout.putConstraint(SpringLayout.SOUTH, lblIfYouWant, -10, SpringLayout.SOUTH, this);
    	springLayout.putConstraint(SpringLayout.SOUTH, lblInfoYouCan, -26, SpringLayout.NORTH, lblIfYouWant);
    	add(lblIfYouWant);
    	
    	JLabel lblNewLabel = new JLabel("resend / print new ticket. If you want to update ");
    	springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 6, SpringLayout.SOUTH, lblInfoYouCan);
    	springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 10, SpringLayout.WEST, this);
    	springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel, -30, SpringLayout.SOUTH, this);
    	add(lblNewLabel);
    	
    	btnFetch = new JButton("Fetch");
    	springLayout.putConstraint(SpringLayout.NORTH, btnFetch, 23, SpringLayout.SOUTH, lblEmail);
    	springLayout.putConstraint(SpringLayout.WEST, btnFetch, 0, SpringLayout.WEST, lblTicketNumber);
    	add(btnFetch);
    	
    	btnUpdate = new JButton("Update");
    	springLayout.putConstraint(SpringLayout.NORTH, btnUpdate, 0, SpringLayout.NORTH, btnFetch);
    	springLayout.putConstraint(SpringLayout.WEST, btnUpdate, 6, SpringLayout.EAST, btnFetch);
    	add(btnUpdate);
    	
    	btnDelete = new JButton("Delete");
    	springLayout.putConstraint(SpringLayout.WEST, btnDelete, 6, SpringLayout.EAST, btnUpdate);
    	springLayout.putConstraint(SpringLayout.SOUTH, btnDelete, 0, SpringLayout.SOUTH, btnFetch);
    	add(btnDelete);
    	
    	btnRefreshTable = new JButton("Refresh table");
    	springLayout.putConstraint(SpringLayout.NORTH, btnRefreshTable, 35, SpringLayout.SOUTH, btnFetch);
    	springLayout.putConstraint(SpringLayout.WEST, btnRefreshTable, 0, SpringLayout.WEST, lblTicketNumber);
    	springLayout.putConstraint(SpringLayout.EAST, btnRefreshTable, 0, SpringLayout.EAST, btnDelete);
    	add(btnRefreshTable);
    	
    	scrollPane = new JScrollPane();
    	springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 2, SpringLayout.NORTH, lblTicketNumber);
    	springLayout.putConstraint(SpringLayout.WEST, scrollPane, 16, SpringLayout.EAST, tfTicketNumber);
    	springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, 0, SpringLayout.SOUTH, lblIfYouWant);
    	springLayout.putConstraint(SpringLayout.EAST, scrollPane, 790, SpringLayout.EAST, tfTicketNumber);
    	add(scrollPane);
    	
    	ticketTable = new JTable(){  
	    public boolean isCellEditable(int row, int column){  
		return false;  
	    }
	};
	
    	ticketTable.setModel(new DefaultTableModel(
    		new Object[][] {
    			{null, null, null, null, null, null, null, null, null, null, null, null},
    			{null, null, null, null, null, null, null, null, null, null, null, null},
    		},
    		new String[] {
    			"Ticket number", "Source", "Destination", "Date", "Leaving", "Distance", "Cost", "Bus ID", "Seat", "Pass. name", "Mobile", "Email"
    		}
    	) {
    		Class[] columnTypes = new Class[] {
    			Float.class, String.class, String.class, String.class, String.class, Float.class, Float.class, Integer.class, Integer.class, String.class, String.class, String.class
    		};
    		public Class getColumnClass(int columnIndex) {
    			return columnTypes[columnIndex];
    		}
    	});
    	ticketTable.getColumnModel().getColumn(5).setPreferredWidth(56);
    	ticketTable.getColumnModel().getColumn(6).setPreferredWidth(44);
    	ticketTable.getColumnModel().getColumn(7).setPreferredWidth(50);
    	ticketTable.getColumnModel().getColumn(8).setPreferredWidth(39);
    	scrollPane.setViewportView(ticketTable);
    	
    	btnPrintSave = new JButton("Print & save ticket");
    	springLayout.putConstraint(SpringLayout.NORTH, btnPrintSave, 6, SpringLayout.SOUTH, btnFetch);
    	springLayout.putConstraint(SpringLayout.WEST, btnPrintSave, 0, SpringLayout.WEST, lblTicketNumber);
    	springLayout.putConstraint(SpringLayout.EAST, btnPrintSave, 0, SpringLayout.EAST, btnDelete);
    	add(btnPrintSave);

    }
    
    public JTable getTicketTable() {
	    return ticketTable;
	}

    public JButton getBtnRefreshTable() {
        return btnRefreshTable;
    }

    public JButton getBtnDelete() {
        return btnDelete;
    }

    public JButton getBtnUpdate() {
        return btnUpdate;
    }

    public JButton getBtnFetch() {
        return btnFetch;
    }

    public JTextField getTfTicketNumber() {
        return tfTicketNumber;
    }

    public JTextField getTfPassengerName() {
        return tfPassengerName;
    }

    public JTextField getTfMobile() {
        return tfMobile;
    }

    public JTextField getTfEmail() {
        return tfEmail;
    }

    public JButton getBtnPrintSave() {
        return btnPrintSave;
    }
}
