package view;

import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class AdministrationTab extends JPanel {
	private JPasswordField passwordField;
	private JTable table;
	private JTextField tfLogin;
	private JTextField tfPass;
	private JButton btnSubmit;
	private JLabel lblLogin;
	private JLabel lblPassword;
	private JButton btnAdd;
	private JButton btnDelete;
	private JButton btnFetch;
	private JScrollPane scrollPane;
	private JButton btnRefreshTable;

    
    public AdministrationTab() {
    	SpringLayout springLayout = new SpringLayout();
    	setLayout(springLayout);
    	
    	JLabel lblEnterAdministrationPassword = new JLabel("Enter administration password:");
    	springLayout.putConstraint(SpringLayout.NORTH, lblEnterAdministrationPassword, 7, SpringLayout.NORTH, this);
    	springLayout.putConstraint(SpringLayout.WEST, lblEnterAdministrationPassword, 10, SpringLayout.WEST, this);
    	lblEnterAdministrationPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
    	add(lblEnterAdministrationPassword);
    	
    	passwordField = new JPasswordField();
    	springLayout.putConstraint(SpringLayout.NORTH, passwordField, 6, SpringLayout.SOUTH, lblEnterAdministrationPassword);
    	springLayout.putConstraint(SpringLayout.WEST, passwordField, 10, SpringLayout.WEST, this);
    	add(passwordField);
    	
    	btnSubmit = new JButton("Submit");
    	springLayout.putConstraint(SpringLayout.NORTH, btnSubmit, 6, SpringLayout.SOUTH, passwordField);
    	add(btnSubmit);
    	
    	scrollPane = new JScrollPane();
    	springLayout.putConstraint(SpringLayout.EAST, passwordField, -82, SpringLayout.WEST, scrollPane);
    	springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 9, SpringLayout.NORTH, this);
    	springLayout.putConstraint(SpringLayout.WEST, scrollPane, 106, SpringLayout.EAST, lblEnterAdministrationPassword);
    	springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, -22, SpringLayout.SOUTH, this);
    	springLayout.putConstraint(SpringLayout.EAST, scrollPane, 572, SpringLayout.WEST, this);
    	add(scrollPane);
    	
    	table = new JTable(){  
	    public boolean isCellEditable(int row, int column){  
		return false;  
	    }
	};
    	table.setModel(new DefaultTableModel(
    		new Object[][] {
    			{null, null},
    			{null, null},
    			{null, null},
    			{null, null},
    			{null, null},
    		},
    		new String[] {
    			"User", "Password"
    		}
    	) {
    		Class[] columnTypes = new Class[] {
    			String.class, String.class
    		};
    		public Class getColumnClass(int columnIndex) {
    			return columnTypes[columnIndex];
    		}
    	});
    	scrollPane.setViewportView(table);
    	
    	lblLogin = new JLabel("Login:");
    	springLayout.putConstraint(SpringLayout.NORTH, lblLogin, 46, SpringLayout.SOUTH, passwordField);
    	springLayout.putConstraint(SpringLayout.WEST, lblLogin, 0, SpringLayout.WEST, lblEnterAdministrationPassword);
    	lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
    	add(lblLogin);
    	
    	lblPassword = new JLabel("Password:");
    	springLayout.putConstraint(SpringLayout.NORTH, lblPassword, 12, SpringLayout.SOUTH, lblLogin);
    	springLayout.putConstraint(SpringLayout.WEST, lblPassword, 0, SpringLayout.WEST, lblEnterAdministrationPassword);
    	lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
    	add(lblPassword);
    	
    	tfLogin = new JTextField();
    	springLayout.putConstraint(SpringLayout.NORTH, tfLogin, 17, SpringLayout.SOUTH, btnSubmit);
    	springLayout.putConstraint(SpringLayout.WEST, tfLogin, 36, SpringLayout.EAST, lblLogin);
    	springLayout.putConstraint(SpringLayout.EAST, tfLogin, -82, SpringLayout.WEST, scrollPane);
    	springLayout.putConstraint(SpringLayout.WEST, btnSubmit, 0, SpringLayout.WEST, tfLogin);
    	add(tfLogin);
    	tfLogin.setColumns(10);
    	
    	tfPass = new JTextField();
    	springLayout.putConstraint(SpringLayout.NORTH, tfPass, 6, SpringLayout.SOUTH, tfLogin);
    	springLayout.putConstraint(SpringLayout.WEST, tfPass, 11, SpringLayout.EAST, lblPassword);
    	springLayout.putConstraint(SpringLayout.EAST, tfPass, 0, SpringLayout.EAST, passwordField);
    	add(tfPass);
    	tfPass.setColumns(10);
    	
    	btnAdd = new JButton("Add");
    	springLayout.putConstraint(SpringLayout.NORTH, btnAdd, 14, SpringLayout.SOUTH, lblPassword);
    	springLayout.putConstraint(SpringLayout.WEST, btnAdd, 0, SpringLayout.WEST, lblEnterAdministrationPassword);
    	add(btnAdd);
    	
    	btnDelete = new JButton("Delete");
    	springLayout.putConstraint(SpringLayout.NORTH, btnDelete, 0, SpringLayout.NORTH, btnAdd);
    	springLayout.putConstraint(SpringLayout.WEST, btnDelete, 12, SpringLayout.EAST, btnAdd);
    	add(btnDelete);
    	
    	btnFetch = new JButton("Fetch");
    	springLayout.putConstraint(SpringLayout.NORTH, btnFetch, 0, SpringLayout.NORTH, btnAdd);
    	springLayout.putConstraint(SpringLayout.EAST, btnFetch, 0, SpringLayout.EAST, passwordField);
    	add(btnFetch);
    	
    	btnRefreshTable = new JButton("Refresh Table");
    	springLayout.putConstraint(SpringLayout.NORTH, btnRefreshTable, 5, SpringLayout.SOUTH, btnAdd);
    	springLayout.putConstraint(SpringLayout.WEST, btnRefreshTable, 10, SpringLayout.WEST, this);
    	springLayout.putConstraint(SpringLayout.EAST, btnRefreshTable, 0, SpringLayout.EAST, passwordField);
    	add(btnRefreshTable);
    	
    	showAdminTools(false);

    }
    
    public void showAdminTools(boolean visible){
	btnFetch.setVisible(visible);
	btnDelete.setVisible(visible);
	btnRefreshTable.setVisible(visible);
	btnAdd.setVisible(visible); 
	tfPass.setVisible(visible);
	tfLogin.setVisible(visible);
	lblPassword.setVisible(visible);
	lblLogin.setVisible(visible);
	table.setVisible(visible);
	scrollPane.setVisible(visible);
    }
    
    
    public void cleanAllFields(){
	tfPass.setText("");
	tfLogin.setText("");
	passwordField.setText("");
    }
    
    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public JTable getTable() {
        return table;
    }

    public JTextField getTfLogin() {
        return tfLogin;
    }

    public JTextField getTfPass() {
        return tfPass;
    }

    public JButton getBtnSubmit() {
        return btnSubmit;
    }

    public JLabel getLblLogin() {
        return lblLogin;
    }

    public JLabel getLblPassword() {
        return lblPassword;
    }

    public JButton getBtnAdd() {
        return btnAdd;
    }

    public JButton getBtnDelete() {
        return btnDelete;
    }

    public JButton getBtnFetch() {
        return btnFetch;
    }
    public JButton getBtnRefreshTable() {
        return btnRefreshTable;
    }
}
