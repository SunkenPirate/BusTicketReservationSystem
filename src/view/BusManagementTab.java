package view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class BusManagementTab extends JPanel{

    
    private static final long serialVersionUID = 2528495411874650347L;
    private JTextField tfBusID;
    private JTextField tfBusName;
    private JTable     busTimeTable;
    private JTextField tfDistance;
    private JTextField tfSeatsOccupied;
    private JButton    btnAdd;
    private JButton    btnDelete;
    private JButton    btnUpdate;
    private JButton    btnRefreshTable;
    private JButton    btnFetchRecord;
    private JTextField tfFrom;
    private JTextField tfTo;
    private JComboBox<String>  cbBusType;
    private JComboBox<String>  cbHHFrom;
    private JComboBox<String>  cbMMFrom;
    private JComboBox<String>  cbHHTo;
    private JComboBox<String>  cbMMTo;

    public BusManagementTab() {
	JLabel lblBusId = new JLabel("Bus ID :");
	lblBusId.setBounds(10, 11, 49, 17);
	lblBusId.setFont(new Font("Tahoma", Font.PLAIN, 14));
	this.add(lblBusId);

	tfBusID = new JTextField();
	tfBusID.setBounds(86, 11, 150, 20);
	tfBusID.setDocument(new JTextFieldIntOnlyFilter()); 
	this.add(tfBusID);
	tfBusID.setColumns(10);

	JLabel lblBusName = new JLabel("Bus name :");
	lblBusName.setBounds(10, 36, 71, 17);
	lblBusName.setFont(new Font("Tahoma", Font.PLAIN, 14));
	this.add(lblBusName);

	tfBusName = new JTextField();
	tfBusName.setBounds(86, 36, 150, 20);
	this.add(tfBusName);
	tfBusName.setColumns(10);

	JLabel lblFrom = new JLabel("From :");
	lblFrom.setBounds(10, 120, 41, 17);
	lblFrom.setFont(new Font("Tahoma", Font.PLAIN, 14));
	this.add(lblFrom);

	JLabel lblTiming = new JLabel("Time :");
	lblTiming.setBounds(10, 145, 71, 20);
	lblTiming.setFont(new Font("Tahoma", Font.PLAIN, 14));
	this.add(lblTiming);

	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(256, 11, 790, 270);
	this.add(scrollPane);

	busTimeTable = new JTable(){  
	    public boolean isCellEditable(int row, int column){  
		return false;  
	    }
	};

	busTimeTable.setModel(new DefaultTableModel(
		new Object[][] {
		    {null, null, null, null, null, null, null, null, null},
		    {null, null, null, null, null, null, null, null, null},
		    {null, null, null, null, null, null, null, null, null},
		    {null, null, null, null, null, null, null, null, null},
		    {null, null, null, null, null, null, null, null, null},
		    {null, null, null, null, null, null, null, null, null},
		    {null, null, null, null, null, null, null, null, null},
		    {null, null, null, null, null, null, null, null, null},
		    {null, null, null, null, null, null, null, null, null},
		    {null, null, null, null, null, null, null, null, null},
		    {null, null, null, null, null, null, null, null, null},
		    {null, null, null, null, null, null, null, null, null},
		    {null, null, null, null, null, null, null, null, null},
		    {null, null, null, null, null, null, null, null, null},
		    {null, null, null, null, null, null, null, null, null},
		    {null, null, null, null, null, null, null, null, null},
		    {null, null, null, null, null, null, null, null, null},
		    {null, null, null, null, null, null, null, null, null},
		    {null, null, null, null, null, null, null, null, null},
		    {null, null, null, null, null, null, null, null, null},
		},
		new String[] {
			"Bus ID", "Bus name", "Bus type", "Seats occupied", "Source", "Timing source", "Destination", "Timing destination", "Distance"
		}
		) {
	    Class[] columnTypes = new Class[] {
		    Integer.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Double.class
	    };
	    public Class getColumnClass(int columnIndex) {
		return columnTypes[columnIndex];
	    }
	});
	
	
	scrollPane.setViewportView(busTimeTable);

	JLabel lblBusType_1 = new JLabel("Bus type:");
	lblBusType_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblBusType_1.setBounds(10, 64, 71, 20);
	this.add(lblBusType_1);

	JLabel lblTo_1 = new JLabel("To:");
	lblTo_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblTo_1.setBounds(10, 176, 46, 14);
	this.add(lblTo_1);

	JLabel lblTime = new JLabel("Time:");
	lblTime.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblTime.setBounds(10, 201, 46, 14);
	this.add(lblTime);

	JLabel lblDistance = new JLabel("Distance:");
	lblDistance.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblDistance.setBounds(10, 226, 71, 14);
	this.add(lblDistance);

	tfDistance = new JTextField();
	tfDistance.setBounds(86, 225, 150, 20);
	tfDistance.setDocument(new JTextFieldIntOnlyFilter()); 
	this.add(tfDistance);
	tfDistance.setColumns(10);

	btnAdd = new JButton("Add");
	btnAdd.setBounds(10, 256, 89, 23);
	this.add(btnAdd);

	btnDelete = new JButton("Delete");
	btnDelete.setBounds(136, 256, 89, 23);
	this.add(btnDelete);

	btnUpdate = new JButton("Update");
	btnUpdate.setBounds(136, 290, 89, 23);
	this.add(btnUpdate);

	btnRefreshTable = new JButton("Refresh table");
	btnRefreshTable.setBounds(505, 292, 190, 23);
	this.add(btnRefreshTable);

	JLabel lblSeatsOccupied = new JLabel("Seats occupied:");
	lblSeatsOccupied.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblSeatsOccupied.setBounds(10, 95, 76, 14);
	this.add(lblSeatsOccupied);

	tfSeatsOccupied = new JTextField();
	tfSeatsOccupied.setBounds(86, 94, 150, 20);
	this.add(tfSeatsOccupied);
	tfSeatsOccupied.setColumns(10);

	btnFetchRecord = new JButton("Fetch record");
	btnFetchRecord.setBounds(10, 290, 89, 23);
	this.add(btnFetchRecord);

	tfFrom = new JTextField();
	tfFrom.setBounds(86, 120, 150, 20);
	this.add(tfFrom);
	tfFrom.setColumns(10);

	JLabel label_3 = new JLabel(":");
	label_3.setBounds(147, 148, 10, 14);
	this.add(label_3);

	tfTo = new JTextField();
	tfTo.setBounds(86, 175, 150, 20);
	this.add(tfTo);
	tfTo.setColumns(10);

	cbHHFrom = new JComboBox<String>(GeneralView.hours);
	cbHHFrom.setBounds(96, 145, 48, 20);
	this.add(cbHHFrom);

	cbMMFrom = new JComboBox<String>(GeneralView.minutes);
	cbMMFrom.setBounds(157, 145, 49, 20);
	this.add(cbMMFrom);

	JLabel label_4 = new JLabel(":");
	label_4.setBounds(147, 202, 10, 14);
	this.add(label_4);

	cbHHTo = new JComboBox<String>(GeneralView.hours);
	cbHHTo.setBounds(96, 199, 48, 20);
	this.add(cbHHTo);

	cbMMTo = new JComboBox<String>(GeneralView.minutes);
	cbMMTo.setBounds(157, 199, 49, 20);
	this.add(cbMMTo);

	cbBusType = new JComboBox<String>(GeneralView.allowedBusTypes);
	cbBusType.setBounds(86, 67, 150, 20);
	this.add(cbBusType);
    }

    public JButton getBtnAdd() {
	return btnAdd;
    }

    public JButton getBtnDelete() {
	return btnDelete;
    }

    public JButton getBtnUpdate() {
	return btnUpdate;
    }

    public JButton getBtnRefreshTable() {
	return btnRefreshTable;
    }

    public JButton getBtnFetchRecord() {
	return btnFetchRecord;
    }

    public JTextField getTfBusID() {
	return tfBusID;
    }

    public JTextField getTfBusName() {
	return tfBusName;
    }

    public JTable getBusTimeTable() {
	return busTimeTable;
    }

    public JTextField getTfDistance() {
	return tfDistance;
    }

    public JTextField getTfSeatsOccupied() {
	return tfSeatsOccupied;
    }

    public JTextField getTfFrom() {
	return tfFrom;
    }

    public JTextField getTfTo() {
	return tfTo;
    }

    public JComboBox<String> getCbBusType() {
	return cbBusType;
    }

    public JComboBox<String> getCbHHFrom() {
	return cbHHFrom;
    }

    public JComboBox<String> getCbMMFrom() {
	return cbMMFrom;
    }

    public JComboBox<String> getCbHHTo() {
	return cbHHTo;
    }

    public JComboBox<String> getCbMMTo() {
	return cbMMTo;
    }
}