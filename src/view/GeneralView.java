package view;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import javax.swing.JFileChooser;
import controller.Controller;

import javax.swing.JTable;
import java.awt.Toolkit;


public class GeneralView {
    private JFrame     Frame;
    private BusManagementTab busManagementPanel;
    private ReservationTab reservationPanel;
    private JFileChooser printer ;
    public static final String[] hours = new String[] {"00", "01", "02", "03", "04", "05", "06",
	    "07", "08", "09", "10", "11", "12",
	    "13", "14", "15", "16", "17", "18",
	    "19", "20", "21", "22", "23"};
    
    public static final String[] minutes = new String[] {"00", "01", "02", "03", "04", "05", "06",
	        "07", "08", "09", "10", "11", "12",
	        "13", "14", "15", "16", "17", "18",
	        "19", "20", "21", "22", "23",
	        "24", "25", "26", "27", "28",
	        "29", "30", "31", "32", "33",
	        "34", "35", "36", "37", "38",
	        "39", "40", "41", "42", "43",
	        "44", "45", "46", "47", "48",
	        "49", "50", "51", "52", "53",
	        "54", "55", "56", "57", "58",
	        "59", "60"	    
	        };
    
    public static final String[] allowedBusTypes = new String[] {"Normal", "Air-Conditioned"
    }; 
    private JTable table;
    private JTabbedPane tabbedPane;
    private TicketsManagementTab ticketsPanel;
    private FareCalculatorPanel fareCalculatorPanel;
    private AdministrationTab adminPanel;

    
    
    public GeneralView(Controller theController) {
	initialize();
    }

    
    private void initialize() {
	
	Frame = new JFrame();
	Frame.setIconImage(Toolkit.getDefaultToolkit().getImage(GeneralView.class.getResource("/view/Bus-2-icon.png")));
	getFrame().setBounds(100, 100, 1079, 557);
	getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	getFrame().getContentPane().setLayout(new BoxLayout(getFrame().getContentPane(), BoxLayout.X_AXIS));
	
	JPanel mainAplicationPanel = new JPanel();
	getFrame().getContentPane().add(mainAplicationPanel);
	mainAplicationPanel.setLayout(null);
	
	JLabel lblBusTicketReservation = new JLabel("Bus Ticket Reservation");
	lblBusTicketReservation.setBounds(351, 34, 602, 57);
	lblBusTicketReservation.setFont(new Font("Tahoma", Font.BOLD, 27));
	mainAplicationPanel.add(lblBusTicketReservation);
	
	JLabel lblBusImage = new JLabel("");
	lblBusImage.setIcon(new ImageIcon(GeneralView.class.getResource("/view/busImage.jpg")));
	lblBusImage.setBounds(105, 11, 176, 104);
	mainAplicationPanel.add(lblBusImage);
	
	tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	tabbedPane.setBounds(10, 147, 1061, 361);
	mainAplicationPanel.add(tabbedPane);
	
	
	reservationPanel = new ReservationTab();
	tabbedPane.addTab("Reservation", null, reservationPanel, null);
	reservationPanel.setLayout(null);
	
	
	
	busManagementPanel = new BusManagementTab();
	tabbedPane.addTab("Bus Management", null, busManagementPanel, null);
	busManagementPanel.setLayout(null);
	
	ticketsPanel = new TicketsManagementTab();
	tabbedPane.addTab("Tickets Management", null, ticketsPanel, null);
	
	fareCalculatorPanel = new FareCalculatorPanel();
	tabbedPane.addTab("Fare Calculator", null, fareCalculatorPanel, null);
	
	
	adminPanel = new AdministrationTab();
	tabbedPane.addTab("Administration", null, adminPanel, null);
	printer = new JFileChooser();
    }

    public JFileChooser getPrinter() {
        return printer;
    }

    public JFrame getFrame() {
	return Frame;
    }

    public BusManagementTab getBusManagementPanel() {
        return busManagementPanel;
    }

    public ReservationTab getReservationPanel() {
        return reservationPanel;
    }

    public JTabbedPane getTabbedPane() {
        return tabbedPane;
    }

    public TicketsManagementTab getTicketsPanel() {
        return ticketsPanel;
    }
    public FareCalculatorPanel getFareCalculatorPanel() {
        return fareCalculatorPanel;
    }

    public AdministrationTab getAdminPanel() {
        return adminPanel;
    }
}
