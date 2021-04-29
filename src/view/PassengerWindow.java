package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.Toolkit;

public class PassengerWindow{

    private JFrame frame;
    private JTextField txtName;
    private JTextField txtMobileNumber;
    private JTextField txtEmailAdress;
    private JButton btnSubmit;
    private JButton btnCancel;
    private JLabel lblShowdate;
    private JLabel lblShowbusid;
    private JLabel lblShowfrom;
    private JLabel lblShowto;
    private JLabel lblShowleavingtime;
    private JLabel lblShowarrivaltime;
    private JLabel lblShowseat;
    private JLabel lblShowdistance;
    private JLabel lblShowprice;
 
    private JLabel lblShowticketno;


    
    public void newScreen(ActionListener cancel, ActionListener submit, PassengerWindow window) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    window.frame.setVisible(true);
		    window.btnCancel.addActionListener(cancel);
		    window.btnSubmit.addActionListener(submit);
		    
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	});
	
    }
    
    
    public PassengerWindow() {
	initialize();
    }

    
    private void initialize() {
	frame = new JFrame();
	frame.setIconImage(Toolkit.getDefaultToolkit().getImage(PassengerWindow.class.getResource("/view/Bus-2-icon.png")));
	frame.setBounds(100, 100, 367, 475);
	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	frame.getContentPane().setLayout(null);
	
	JLabel lblBusTicketReservation = new JLabel("Reservation detials");
	lblBusTicketReservation.setFont(new Font("Tahoma", Font.BOLD, 15));
	lblBusTicketReservation.setBounds(80, 11, 155, 14);
	frame.getContentPane().add(lblBusTicketReservation);
	
	JLabel lblDate = new JLabel("Date:");
	lblDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblDate.setBounds(10, 36, 46, 14);
	frame.getContentPane().add(lblDate);
	
	JLabel lblBusId = new JLabel("Bus ID");
	lblBusId.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblBusId.setBounds(10, 61, 46, 14);
	frame.getContentPane().add(lblBusId);
	
	JLabel lblFrom = new JLabel("From:");
	lblFrom.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblFrom.setBounds(10, 86, 46, 14);
	frame.getContentPane().add(lblFrom);
	
	JLabel lblTo = new JLabel("To:");
	lblTo.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblTo.setBounds(10, 111, 46, 14);
	frame.getContentPane().add(lblTo);
	
	JLabel lblLeavingTime = new JLabel("Leaving time:");
	lblLeavingTime.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblLeavingTime.setBounds(10, 136, 98, 14);
	frame.getContentPane().add(lblLeavingTime);
	
	JLabel lblExpectedArrivalTime = new JLabel("Expected arrival time:");
	lblExpectedArrivalTime.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblExpectedArrivalTime.setBounds(10, 161, 144, 14);
	frame.getContentPane().add(lblExpectedArrivalTime);
	
	JLabel lblPassengerDetails = new JLabel("Passenger details:");
	lblPassengerDetails.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblPassengerDetails.setBounds(10, 293, 128, 20);
	frame.getContentPane().add(lblPassengerDetails);
	
	JLabel lblName = new JLabel("Name:");
	lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblName.setBounds(10, 324, 46, 14);
	frame.getContentPane().add(lblName);
	
	JLabel lblMob = new JLabel("Mob.:");
	lblMob.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblMob.setBounds(10, 349, 46, 14);
	frame.getContentPane().add(lblMob);
	
	JLabel lblMail = new JLabel("E-mail");
	lblMail.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblMail.setBounds(10, 374, 46, 14);
	frame.getContentPane().add(lblMail);
	
	txtName = new JTextField();
	txtName.setBounds(64, 323, 86, 20);
	frame.getContentPane().add(txtName);
	txtName.setColumns(10);
	
	txtMobileNumber = new JTextField();
	txtMobileNumber.setBounds(64, 348, 86, 20);
	frame.getContentPane().add(txtMobileNumber);
	txtMobileNumber.setColumns(10);
	
	txtEmailAdress = new JTextField();
	txtEmailAdress.setBounds(64, 373, 86, 20);
	frame.getContentPane().add(txtEmailAdress);
	txtEmailAdress.setColumns(10);
	
	btnSubmit = new JButton("Submit");
	btnSubmit.setBounds(42, 406, 89, 23);
	frame.getContentPane().add(btnSubmit);
	
	btnCancel = new JButton("Cancel");
	btnCancel.setBounds(174, 406, 89, 23);
	frame.getContentPane().add(btnCancel);
	
	lblShowdate = new JLabel("showDate");
	lblShowdate.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblShowdate.setBounds(174, 38, 105, 14);
	frame.getContentPane().add(lblShowdate);
	
	lblShowbusid = new JLabel("showBusID");
	lblShowbusid.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblShowbusid.setBounds(174, 63, 98, 14);
	frame.getContentPane().add(lblShowbusid);
	
	lblShowfrom = new JLabel("showFrom");
	lblShowfrom.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblShowfrom.setBounds(174, 82, 86, 23);
	frame.getContentPane().add(lblShowfrom);
	
	lblShowto = new JLabel("showTo");
	lblShowto.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblShowto.setBounds(174, 107, 86, 23);
	frame.getContentPane().add(lblShowto);
	
	lblShowleavingtime = new JLabel("showLeavingTime");
	lblShowleavingtime.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblShowleavingtime.setBounds(174, 136, 121, 14);
	frame.getContentPane().add(lblShowleavingtime);
	
	lblShowarrivaltime = new JLabel("showArrivalTime");
	lblShowarrivaltime.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblShowarrivaltime.setBounds(174, 161, 105, 14);
	frame.getContentPane().add(lblShowarrivaltime);
	
	JLabel lblSeat = new JLabel("Seat:");
	lblSeat.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblSeat.setBounds(10, 186, 46, 14);
	frame.getContentPane().add(lblSeat);
	
	lblShowseat = new JLabel("showSeat");
	lblShowseat.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblShowseat.setBounds(174, 183, 98, 20);
	frame.getContentPane().add(lblShowseat);
	
	JLabel lblDistance = new JLabel("Distance:");
	lblDistance.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblDistance.setBounds(10, 211, 98, 14);
	frame.getContentPane().add(lblDistance);
	
	lblShowdistance = new JLabel("showDistance");
	lblShowdistance.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblShowdistance.setBounds(174, 211, 61, 14);
	frame.getContentPane().add(lblShowdistance);
	
	JLabel lblPrice = new JLabel("Price:");
	lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblPrice.setBounds(10, 236, 46, 14);
	frame.getContentPane().add(lblPrice);
	
	JLabel lblTicketNo = new JLabel("Ticket No.:");
	lblTicketNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblTicketNo.setBounds(10, 261, 105, 14);
	frame.getContentPane().add(lblTicketNo);
	
	lblShowprice = new JLabel("showPrice");
	lblShowprice.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblShowprice.setBounds(171, 236, 155, 14);
	frame.getContentPane().add(lblShowprice);
	
	lblShowticketno = new JLabel("showTicketNo");
	lblShowticketno.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblShowticketno.setBounds(171, 261, 145, 14);
	frame.getContentPane().add(lblShowticketno);
    }

    public JTextField getTxtName() {
        return txtName;
    }

    public JTextField getTxtMobileNumber() {
        return txtMobileNumber;
    }

    public JTextField getTxtEmailAdress() {
        return txtEmailAdress;
    }

    public JButton getBtnSubmit() {
        return btnSubmit;
    }

    public JButton getBtnCancel() {
        return btnCancel;
    }

    public JLabel getLblShowdate() {
        return lblShowdate;
    }

    public JLabel getLblShowbusid() {
        return lblShowbusid;
    }

    public JLabel getLblShowfrom() {
        return lblShowfrom;
    }

    public JLabel getLblShowto() {
        return lblShowto;
    }

    public JLabel getLblShowleavingtime() {
        return lblShowleavingtime;
    }

    public JLabel getLblShowarrivaltime() {
        return lblShowarrivaltime;
    }

    public JFrame getFrame() {
        return frame;
    }
    
    public JLabel getLblShowseat() {
        return lblShowseat;
    }

    public JLabel getLblShowdistance() {
        return lblShowdistance;
    }
    public JLabel getLblShowprice() {
        return lblShowprice;
    }

    public JLabel getLblShowticketno() {
        return lblShowticketno;
    }
    
}
