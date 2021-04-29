package controller;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.itextpdf.text.DocumentException;

import model.BusTicketCalculations;
import model.DataBaseModel;
import model.EmailMessage;
import model.LoginDB;
import net.proteanit.sql.DbUtils;
import view.GeneralView;
import view.Login;
import view.PassengerWindow;

public class Controller {

    private static final Integer DEFAULT_BUS_ID = 100;
    private GeneralView theView;
    private DataBaseModel dbModel;
    private PassengerWindow passenger;
    private String seatNumberSelected;
    private LoginDB logDB;
    private Login loginView;
    private final String ADMINISTRATION_PASSWORD = "admin";

    
    public void start(){
	theView = new GeneralView (this);
	dbModel = new DataBaseModel();
	loginView = new Login();
	loginView.setVisible(true);
	try {
	    logDB = new LoginDB(dbModel);
	} catch (Exception e) {
	    e.printStackTrace();
	} 

	loginView.getBtnSubmit().addActionListener(new ActionListener(){
	    public void actionPerformed(ActionEvent arg0) {
		String pwd = new String(loginView.getPfPassword().getPassword());
		String login = loginView.getTfLogin().getText();

		if(!login.equals("") && !pwd.equals("") && verifyUser(login, pwd)){
		    JOptionPane.showMessageDialog(theView.getFrame(),"Password correct");
		    startBusApplication();
		    loginView.setVisible(false);
		}else{
		    JOptionPane.showMessageDialog(theView.getFrame(),"Incorrect login or password");
		}

	    }  
	});

    }

    
    public void startBusApplication() {

	theView.getFrame().setVisible(true);
	passenger = new PassengerWindow();
	seatNumberSelected = null;
	initializeListeners();
	getAndShowBusTimeTable();
	getAndShowTicketTable();
	theView.getBusManagementPanel().getTfBusID().setText(suggestBusID().toString());
	fillFromComboBox(theView.getReservationPanel().getFromDropDown());
	fillToComboBox(theView.getReservationPanel().getToDropDown(), theView.getReservationPanel().getFromDropDown());
	fillFromComboBox(theView.getFareCalculatorPanel().getCBFrom());
	fillToComboBox(theView.getFareCalculatorPanel().getCBTo(), theView.getFareCalculatorPanel().getCBFrom());
    }
    
    private void initializeListeners() {
	
	theView.getBusManagementPanel().getBtnAdd().addActionListener(new AddBusListener());
	theView.getBusManagementPanel().getBtnRefreshTable().addActionListener(new RefreshTableListener());
	theView.getBusManagementPanel().getBtnFetchRecord().addActionListener(new FetchBusListener());
	theView.getBusManagementPanel().getBtnDelete().addActionListener(new DeleteBusListener());
	theView.getBusManagementPanel().getBtnUpdate().addActionListener(new UpdateBusListener());

	
	theView.getTabbedPane().addChangeListener(new TabbedPaneChangeListener());

	
	theView.getReservationPanel().getFromDropDown().addActionListener(new FromCBSelectedListener());
	theView.getReservationPanel().getBtnGetBusDetails().addActionListener(new BtnGetBusDetailsListener());
	theView.getReservationPanel().getBtnReset().addActionListener(new BtnResetListener());
	theView.getReservationPanel().getBtnLoadBuss().addActionListener(new BtnLoadListener());
	theView.getReservationPanel().getBtnMakeReservation().addActionListener(new BtnMakeReservationListener());

	
	theView.getTicketsPanel().getBtnRefreshTable().addActionListener(new RefreshTicketTableListener());
	theView.getTicketsPanel().getBtnFetch().addActionListener(new FetchTicketListener());
	theView.getTicketsPanel().getBtnUpdate().addActionListener(new UpdateTicketListener());
	theView.getTicketsPanel().getBtnDelete().addActionListener(new DeleteTicketListener());
	theView.getTicketsPanel().getBtnPrintSave().addActionListener(new PrintSaveTicketListener());

	
	theView.getFareCalculatorPanel().getCBFrom().addActionListener(new FromFareCBSelectedListener());
	theView.getFareCalculatorPanel().getBtnCalculateFare().addActionListener(new CalculateFareListener());

	
	theView.getAdminPanel().getBtnSubmit().addActionListener(new submitAdminPwdListener());
	theView.getAdminPanel().getBtnRefreshTable().addActionListener(new RefreshAdminTabListener());
	theView.getAdminPanel().getBtnAdd().addActionListener(new AddUserListener());
	theView.getAdminPanel().getBtnDelete().addActionListener(new DeleteUserListener());
	theView.getAdminPanel().getBtnFetch().addActionListener(new FetchUserListener());

    }

    

    public class AddBusListener implements ActionListener{

	public void actionPerformed(ActionEvent arg0) {

	    int busID = Integer.parseInt(theView.getBusManagementPanel().getTfBusID().getText());
	    String busName = theView.getBusManagementPanel().getTfBusName().getText();
	    String busType = (String) theView.getBusManagementPanel().getCbBusType().getSelectedItem();
	    String seatsOccupied = (String) theView.getBusManagementPanel().getTfSeatsOccupied().getText();
	    String source = (String) theView.getBusManagementPanel().getTfFrom().getText();   
	    String timing = (String) theView.getBusManagementPanel().getCbHHFrom().getSelectedItem() 
		    + ":" + (String) theView.getBusManagementPanel().getCbMMFrom().getSelectedItem();
	    String destination = theView.getBusManagementPanel().getTfTo().getText();
	    String timingDestination = (String) theView.getBusManagementPanel().getCbHHTo().getSelectedItem() 
		    + ":" + (String) theView.getBusManagementPanel().getCbMMTo().getSelectedItem();
	    double distance = Double.parseDouble(theView.getBusManagementPanel().getTfDistance().getText());

	    try {
		dbModel.insertNewBus(busID,busName, busType, seatsOccupied, source, timing, destination, timingDestination, distance);
		getAndShowBusTimeTable();
		cleanBusMangementFields();
	    } catch (Exception e) {
		JOptionPane.showMessageDialog(null, "Done!!!");
	    }
	}
    }

    public class RefreshTableListener implements ActionListener{

	public void actionPerformed(ActionEvent arg0) {
	    getAndShowBusTimeTable();
	}
    }

    public class FetchBusListener implements ActionListener{

	public void actionPerformed(ActionEvent arg0) {
	    JTable busTimeTable = theView.getBusManagementPanel().getBusTimeTable();
	    int row =  busTimeTable.getSelectedRow();
	    if(row >= 0){
		theView.getBusManagementPanel().getTfBusID().setText(Integer.toString((Integer) busTimeTable.getValueAt(row, 0))); //busID
		theView.getBusManagementPanel().getTfBusName().setText((String) busTimeTable.getValueAt(row, 1)); //bus Name
		theView.getBusManagementPanel().getCbBusType().setSelectedIndex(findBusType((String) busTimeTable.getValueAt(row, 2)));
		theView.getBusManagementPanel().getTfSeatsOccupied().setText((String) busTimeTable.getValueAt(row, 3));
		theView.getBusManagementPanel().getTfFrom().setText((String) busTimeTable.getValueAt(row, 4));
		theView.getBusManagementPanel().getCbHHFrom().setSelectedIndex(findHour(busTimeTable.getValueAt(row, 5)));
		theView.getBusManagementPanel().getCbMMFrom().setSelectedIndex(findMinutes(busTimeTable.getValueAt(row, 5)));
		theView.getBusManagementPanel().getTfTo().setText((String) busTimeTable.getValueAt(row, 6));
		theView.getBusManagementPanel().getCbHHTo().setSelectedIndex(findHour(busTimeTable.getValueAt(row, 7)));
		theView.getBusManagementPanel().getCbMMTo().setSelectedIndex(findMinutes(busTimeTable.getValueAt(row, 7)));
		theView.getBusManagementPanel().getTfDistance().setText(Float.toString((Float) busTimeTable.getValueAt(row, 8)));
	    }else{
		JOptionPane.showMessageDialog(theView.getFrame(),"Not possible to fetch the bus. Refresh and try again");

	    }
	}
    }

    public class DeleteBusListener implements ActionListener{

	public void actionPerformed(ActionEvent arg0) {
	    try {
		String busId = theView.getBusManagementPanel().getTfBusID().getText();
		dbModel.deleteTicketAssociatedWithBus(busId);
		System.out.println(busId);
		dbModel.deleteBusWithID(Integer.parseInt(busId));
		getAndShowBusTimeTable();
		cleanBusMangementFields();


	    } catch (NumberFormatException e) {
		JOptionPane.showMessageDialog(theView.getFrame(),"Number Format Exception! use the correct input");
		e.printStackTrace();
	    } catch (Exception e) {
		JOptionPane.showMessageDialog(null, "Done!!!");;

	    }
	}
    }

    public class UpdateBusListener implements ActionListener{

	public void actionPerformed(ActionEvent arg0) {
	    int busID = Integer.parseInt(theView.getBusManagementPanel().getTfBusID().getText());
	    String busName = theView.getBusManagementPanel().getTfBusName().getText();
	    String busType = (String) theView.getBusManagementPanel().getCbBusType().getSelectedItem();
	    String seatsOccupied = (String) theView.getBusManagementPanel().getTfSeatsOccupied().getText();
	    String source = (String) theView.getBusManagementPanel().getTfFrom().getText();   
	    String timing = (String) theView.getBusManagementPanel().getCbHHFrom().getSelectedItem() 
		    + ":" + (String) theView.getBusManagementPanel().getCbMMFrom().getSelectedItem();
	    String destination = theView.getBusManagementPanel().getTfTo().getText();
	    String timingDestination = (String) theView.getBusManagementPanel().getCbHHTo().getSelectedItem() 
		    + ":" + (String) theView.getBusManagementPanel().getCbMMTo().getSelectedItem();
	    double distance = Double.parseDouble(theView.getBusManagementPanel().getTfDistance().getText());
	    System.out.println(busID);
	    try {
		dbModel.updateBusRecord(busID,busName, busType, seatsOccupied, source, timing, destination, timingDestination, distance);
		getAndShowBusTimeTable();
		cleanBusMangementFields();
	    } catch (Exception e) {
		JOptionPane.showMessageDialog(null, "Done!!!");
	    }
	}
    }

    

    public class TabbedPaneChangeListener implements ChangeListener {

	public void stateChanged(ChangeEvent arg0) {
	    if(theView.getTabbedPane().getSelectedIndex() == theView.getTabbedPane().indexOfTab("Reservation")){ //if reservation panel is selected
		fillFromComboBox(theView.getReservationPanel().getFromDropDown());
		fillToComboBox(theView.getReservationPanel().getToDropDown(), theView.getReservationPanel().getFromDropDown());
	    }else if(theView.getTabbedPane().getSelectedIndex() == theView.getTabbedPane().indexOfTab("Tickets Management")){
		getAndShowTicketTable();
	    }else if(theView.getTabbedPane().getSelectedIndex() == theView.getTabbedPane().indexOfTab("Administration")){
		theView.getAdminPanel().showAdminTools(false);
	    }
	}
    }

    
    public class FromCBSelectedListener implements ActionListener{

	public void actionPerformed(ActionEvent arg0) {
	    fillToComboBox(theView.getReservationPanel().getToDropDown(), theView.getReservationPanel().getFromDropDown());
	}
    }

    public class BtnGetBusDetailsListener implements ActionListener {

	public void actionPerformed(ActionEvent e) {
	    String to = theView.getReservationPanel().getToDropDown().getSelectedItem().toString();
	    String from = theView.getReservationPanel().getFromDropDown().getSelectedItem().toString();

	    theView.getReservationPanel().busBasicInfoEnabled(false);
	    theView.getReservationPanel().busDetailsEnabled(true);

	    fillBusListDropDown(from, to);
	    try {
		dbModel.getBusDetials(from, to);
	    } catch (Exception e1) {
		JOptionPane.showMessageDialog(null, "Done!!!");
	    }
	}
    }

    public class BtnResetListener implements ActionListener {


	public void actionPerformed(ActionEvent e) {
	    String to = theView.getReservationPanel().getToDropDown().getSelectedItem().toString();
	    String from = theView.getReservationPanel().getFromDropDown().getSelectedItem().toString();

	    theView.getReservationPanel().busBasicInfoEnabled(true);
	    theView.getReservationPanel().deleteLayoutPanel();
	    theView.getReservationPanel().busDetailsEnabled(false);
	    try {
		dbModel.getBusDetials(from, to);
	    } catch (Exception e1) {
		JOptionPane.showMessageDialog(null, "Done!!!");
	    }
	}
    }

    public class BtnLoadListener implements ActionListener {


	public void actionPerformed(ActionEvent e) {
	    String id = theView.getReservationPanel().getBusListDropDown().getSelectedItem().toString().split(" ")[0];
	    updateBusLayoutAccordingToDatabase(id);
	    addListenerToTheSeatButtons();
	}

    }

    public class BtnMakeReservationListener implements ActionListener {

	public void actionPerformed(ActionEvent e) {
	    if(seatNumberSelected != null){
		passenger.newScreen(new BtnPassengerPanelCancelListener(), new BtnPassengerPanelSubmitListener(), passenger);
		theView.getReservationPanel().disableWholePanel();
		fillInTicketInfoOnPassengerScreen();

		
		passenger.getFrame().addWindowListener(new java.awt.event.WindowAdapter() {
		    public void windowClosing(java.awt.event.WindowEvent e) {
			theView.getReservationPanel().busDetailsEnabled(true);
			e.getWindow().dispose();
		    }
		});
	    }else{
		JOptionPane.showMessageDialog(theView.getFrame(),"Seat must be selected");
	    }
	}
    }
    
    public class RefreshTicketTableListener implements ActionListener{

	public void actionPerformed(ActionEvent arg0) {
	    getAndShowTicketTable();

	}
    }

    public class FetchTicketListener implements ActionListener{

	public void actionPerformed(ActionEvent e) {
	    JTable ticketTable = theView.getTicketsPanel().getTicketTable();
	    int row =  ticketTable.getSelectedRow();
	    if(row >= 0){
		theView.getTicketsPanel().getTfTicketNumber().setText(Long.toString((Long) ticketTable.getValueAt(row, 0))); //Ticket number
		theView.getTicketsPanel().getTfPassengerName().setText((String) ticketTable.getValueAt(row, 9)); //bus Name
		theView.getTicketsPanel().getTfMobile().setText((String) ticketTable.getValueAt(row, 10)); // Mobile
		theView.getTicketsPanel().getTfEmail().setText((String) ticketTable.getValueAt(row, 11)); // Email
	    }else{
		JOptionPane.showMessageDialog(theView.getFrame(),"Not possible to fetch the bus. Refresh and try again");

	    }
	}
    }

    public class UpdateTicketListener implements ActionListener{

	public void actionPerformed(ActionEvent arg0) {
	    try{
		long ticketNumber = Long.parseLong(theView.getTicketsPanel().getTfTicketNumber().getText());
		if(ticketNumber > 0){
		    String passengerName = theView.getTicketsPanel().getTfPassengerName().getText();
		    String mobile = (String) theView.getTicketsPanel().getTfMobile().getText();
		    String email = (String) theView.getTicketsPanel().getTfEmail().getText();
		    try {
			dbModel.updateTicketRecord(ticketNumber, passengerName, mobile, email);
			getAndShowTicketTable();
			cleanTicketManagementFields();
		    } catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Done!!!");
		    }
		}else{
		    JOptionPane.showMessageDialog(theView.getFrame(),"You must enter valid ticket number");
		}
	    }catch(NumberFormatException e1){
		JOptionPane.showMessageDialog(theView.getFrame(),"You must enter valid ticket number");
	    }
	}
    }

    public class DeleteTicketListener implements ActionListener{

	public void actionPerformed(ActionEvent ae) {
	    try {
		if(!theView.getTicketsPanel().getTfTicketNumber().getText().equals("")){
		    ResultSet rs = dbModel.getTicketTable();
		    if(rs.next()){
			int busId = Integer.parseInt(rs.getString("busId"));
			String seat = rs.getString("seat");
			makeSeatVaccant(busId, seat);
			dbModel.deleteTicketWithNumber(theView.getTicketsPanel().getTfTicketNumber().getText());
			getAndShowTicketTable();
			cleanTicketManagementFields();
		    }

		}else{
		    JOptionPane.showMessageDialog(theView.getFrame(),"Insert correct ticket number");
		}
	    } catch (NumberFormatException e) {
		JOptionPane.showMessageDialog(theView.getFrame(),"Number Format Exception! use the correct input");
		e.printStackTrace();
	    } catch (Exception e) {
		JOptionPane.showMessageDialog(null, "Done!!!");

	    }
	}
    }

    public class PrintSaveTicketListener implements ActionListener {

	public void actionPerformed(ActionEvent e) {
	    System.out.println("tu");
	    try {
		String ticketNumber = theView.getTicketsPanel().getTfTicketNumber().getText();
		if(!ticketNumber.equals("")){
		    ResultSet theTicket = dbModel.getTicketWithNo(ticketNumber);
		    if(theTicket.next()){
			System.out.println("tam");
			String source = theTicket.getString("source");
			String destination =theTicket.getString("destination");
			String date = theTicket.getString("date");
			String timing = theTicket.getString("timing");
			String distance = theTicket.getString("distance");
			String cost = theTicket.getString("cost");
			String busId = theTicket.getString("busId");
			String seat = theTicket.getString("seat");
			String passengerName = theTicket.getString("passengerName");
			String email = theTicket.getString("email");
			String mobile = theTicket.getString("mobile");

			PassengerWindow tmpPassenger = new PassengerWindow();

			tmpPassenger.getLblShowfrom().setText(source);
			tmpPassenger.getLblShowto().setText(destination);
			tmpPassenger.getLblShowdate().setText(date);
			tmpPassenger.getLblShowleavingtime().setText(timing);
			tmpPassenger.getLblShowdistance().setText(distance);
			   
			tmpPassenger.getLblShowbusid().setText(busId);
			tmpPassenger.getLblShowseat().setText(seat);
			tmpPassenger.getTxtName().setText(passengerName);
			tmpPassenger.getTxtEmailAdress().setText(email);
			tmpPassenger.getTxtMobileNumber().setText(mobile);
			tmpPassenger.getTxtName().setEditable(false);
			tmpPassenger.getTxtEmailAdress().setEditable(false);
			tmpPassenger.getTxtMobileNumber().setEditable(false);

			
			tmpPassenger.newScreen(null, null, tmpPassenger);
			String fileName = null;
			int returnVal = theView.getPrinter().showSaveDialog(null);
			if(returnVal == JFileChooser.APPROVE_OPTION) {
			    fileName = theView.getPrinter().getSelectedFile().getAbsolutePath();

			    try {
				Image ticketImage = model.PDFPrinter.getImageFromPanel(tmpPassenger.getFrame());
				model.PDFPrinter.printCwToPdf(ticketImage, fileName + ".pdf", ticketNumber);

				
				String textTicket = builtTxtTicket(ticketNumber, source, destination, date, timing,
					distance, cost, busId, seat,passengerName, mobile);
				LinkedList <String> to = new LinkedList<String>();
				to.add(email);
				EmailMessage wiadomosc = new EmailMessage.EmailBuilder("marek.czwartek@wp.pl", to)
					.addSubject("Ticket purchase confirmation " + ticketNumber)
					.addContent(textTicket)
					.build();

				wiadomosc.send("adrianroguski1990", "smtp.wp.pl", 465);

			    } catch (DocumentException  e1) {
				JOptionPane.showMessageDialog(theView.getFrame(), "Problem with the file you want write to. Please check the file!");
				e1.printStackTrace();
			    }catch (IOException   e2) {
				JOptionPane.showMessageDialog(theView.getFrame(), "Problem with image you want to print out!");
				e2.printStackTrace();
			    }catch(javax.mail.internet.AddressException me){
				JOptionPane.showMessageDialog(theView.getFrame(), "Email adress incorrect!");
				me.printStackTrace();
			    }
			}
			tmpPassenger.getFrame().dispatchEvent(new WindowEvent(passenger.getFrame(), WindowEvent.WINDOW_CLOSING));
			cleanTicketManagementFields();
		    }

		}else{
		    JOptionPane.showMessageDialog(theView.getFrame(), "Ticket number incorrect!");
		}

	    } catch (Exception e3) {
		JOptionPane.showMessageDialog(null, "Done!!!");
	    }
	}
    }

    

    public class FromFareCBSelectedListener implements ActionListener{
	public void actionPerformed(ActionEvent arg0) {
	    fillToComboBox(theView.getFareCalculatorPanel().getCBTo(), theView.getFareCalculatorPanel().getCBFrom());
	}
    }

    public class CalculateFareListener implements ActionListener{
	public void actionPerformed(ActionEvent arg0) {
	    String from = theView.getFareCalculatorPanel().getCBFrom().getSelectedItem().toString();
	    String to = theView.getFareCalculatorPanel().getCBTo().getSelectedItem().toString();
	    try {
		ResultSet theBus = dbModel.getBusDetials(from, to);
		if(theBus.next()){
		    float distance = Float.parseFloat(theBus.getString("Distance"));
		    theView.getFareCalculatorPanel().getLblShowfare().setText(Double.toString(BusTicketCalculations.getTicketPrice(distance)) + " z�.");
		}else{
		    JOptionPane.showMessageDialog(passenger.getFrame(),"No bus found");
		}
	    } catch (Exception e) {
		JOptionPane.showMessageDialog(null, "Done!!!");
	    }

	}

    }

    
    
    public class submitAdminPwdListener implements ActionListener{
	public void actionPerformed(ActionEvent arg0) {
	    String pwd = new String(theView.getAdminPanel().getPasswordField().getPassword());
	    if(ADMINISTRATION_PASSWORD.equals(pwd)){
		theView.getAdminPanel().showAdminTools(true);
		getAndShowAdminTable();
		theView.getAdminPanel().getPasswordField().setText("");
	    }else{
		JOptionPane.showMessageDialog(theView.getFrame(),"Password incorrect ! Try again");
	    }
	}
    }

    private void addListenerToTheSeatButtons() {
	SeatButtonPressed seatPressed = new SeatButtonPressed();
	for(JToggleButton seat : theView.getReservationPanel().getBusLayout().getAllSeatButtons()){
	    seat.addItemListener(seatPressed);
	}
    }


    
    public void getAndShowBusTimeTable(){
	JTable busTimeTable = theView.getBusManagementPanel().getBusTimeTable();
	ResultSet rs;
	try {
	    rs = dbModel.getBusTimeTable();
	    busTimeTable.setModel(DbUtils.resultSetToTableModel(rs));
	    busTimeTable.changeSelection(0, 0, false, false); 
	} catch (Exception e) {
	    JOptionPane.showMessageDialog(null, "Done!!!");
	}
    }

    
    public void getAndShowTicketTable(){
	JTable ticketTable = theView.getTicketsPanel().getTicketTable();
	ResultSet rs;
	try {
	    rs = dbModel.getTicketTable();
	    ticketTable.setModel(DbUtils.resultSetToTableModel(rs));
	    ticketTable.changeSelection(0, 0, false, false); 
	} catch (Exception e) {
	    JOptionPane.showMessageDialog(null, "Done!!!");
	}
    }

    
    public void getAndShowAdminTable(){
	JTable adminTable = theView.getAdminPanel().getTable();
	ResultSet rs;
	try {
	    rs = logDB.getAdminTable();
	    adminTable.setModel(DbUtils.resultSetToTableModel(rs));
	    adminTable.changeSelection(0, 0, false, false); 
	} catch (Exception e) {
	    JOptionPane.showMessageDialog(null, "Done!!!");
	}
    }
    
    public void cleanBusMangementFields() {
	theView.getBusManagementPanel().getTfBusID().setText(suggestBusID().toString());
	theView.getBusManagementPanel().getTfBusName().setText("");
	theView.getBusManagementPanel().getCbBusType().setSelectedIndex(0);
	theView.getBusManagementPanel().getTfSeatsOccupied().setText("");
	theView.getBusManagementPanel().getTfFrom().setText("");   
	theView.getBusManagementPanel().getCbHHFrom().setSelectedIndex(0);
	theView.getBusManagementPanel().getCbMMFrom().setSelectedIndex(0);
	theView.getBusManagementPanel().getTfTo().setText("");
	theView.getBusManagementPanel().getCbHHTo().setSelectedIndex(0);
	theView.getBusManagementPanel().getCbMMTo().setSelectedIndex(0);
	theView.getBusManagementPanel().getTfDistance().setText("");

    }
    
    
    private Integer suggestBusID() {
	try {
	    ResultSet rs = dbModel.getAllBusID();
	    if(rs.next()){
		ArrayList<ArrayList<Integer>> idList = (ArrayList<ArrayList<Integer>>) DbUtils.resultSetToNestedList(rs);
		return  idList.get(idList.size() - 1).get(0) + 1;
	    }else{
		return DEFAULT_BUS_ID;
	    }
	} catch (Exception e) {
	    JOptionPane.showMessageDialog(null, "Done!!!");
	}
	return null;
    }

    public class FetchAdminDataListener implements ActionListener{

	public void actionPerformed(ActionEvent arg0) {
	    JTable adminTable = theView.getAdminPanel().getTable();
	    int row =  adminTable.getSelectedRow();
	    if(row >= 0){
		theView.getAdminPanel().getTfLogin().setText((String) adminTable.getValueAt(row, 0)); //Login
		theView.getAdminPanel().getTfPass().setText((String) adminTable.getValueAt(row, 1));  //Password
	    }else{
		JOptionPane.showMessageDialog(theView.getFrame(),"Not possible to fetch the bus. Refresh and try again");

	    }
	}
    }

    
    public void makeSeatVaccant(int busId, String seat){
	try {
	    ResultSet theBus = dbModel.getBusWithID(Integer.toString(busId));
	    if(theBus.next()){
		String newSeatsOccupied = "";
		String seatsOccupied = theBus.getString("seatsOccupied");
		for(String s : seatsOccupied.split(";")){
		    if(!s.equals(seat)){
			newSeatsOccupied += s;
		    }
		}
		dbModel.updateBusSeats(busId, newSeatsOccupied);
	    }
	} catch (Exception e) {
	    JOptionPane.showMessageDialog(null, "Done!!!");
	}
    }

    public void fillInTicketInfoOnPassengerScreen() {
	String date = theView.getReservationPanel().getDDField().getText()
		+ "/" + theView.getReservationPanel().getMMField().getText()
		+ "/" + theView.getReservationPanel().getYYYYField().getText();
	passenger.getLblShowdate().setText(date);
	passenger.getLblShowseat().setText(seatNumberSelected);

	String id = theView.getReservationPanel().getBusListDropDown().getSelectedItem().toString().split(" ")[0];
	try {
	    ResultSet theBus = dbModel.getBusWithID(id);
	    if(theBus.next()){

		String arrivalTime = theBus.getString("timingDestination");
		String sourceTime = theBus.getString("timingSource");
		String from = theBus.getString("source");
		String to = theBus.getString("destination");
		String distance = theBus.getString("distance");
		String ticketNumber = Long.toString(getUniqueID());

		passenger.getLblShowarrivaltime().setText(arrivalTime);
		passenger.getLblShowleavingtime().setText(sourceTime);
		passenger.getLblShowbusid().setText(id);
		passenger.getLblShowfrom().setText(from);
		passenger.getLblShowto().setText(to);
		passenger.getLblShowdistance().setText(distance);
		passenger.getLblShowprice().setText(Double.toString(BusTicketCalculations.getTicketPrice(Double.parseDouble(distance))) + " Tk.");
		passenger.getLblShowticketno().setText(ticketNumber);
	    }
	} catch (Exception e1) {
	    JOptionPane.showMessageDialog(null, "Done!!!");
	}
    }
    
    public class RefreshAdminTabListener implements ActionListener{

	public void actionPerformed(ActionEvent e) {
	    getAndShowAdminTable();

	}
    }

    public class AddUserListener implements ActionListener{

	public void actionPerformed(ActionEvent arg0) {

	    String username = theView.getAdminPanel().getTfLogin().getText();
	    String password = theView.getAdminPanel().getTfPass().getText();

	    try {
		logDB.addNewUser(username, password);
		getAndShowAdminTable();
		theView.getAdminPanel().cleanAllFields();
	    } catch (Exception e) {
		JOptionPane.showMessageDialog(null, "Done!!!");
	    }
	}
    }
    public class FetchUserListener implements ActionListener{

	public void actionPerformed(ActionEvent arg0) {

	    JTable adminTable = theView.getAdminPanel().getTable();
	    int row =  adminTable.getSelectedRow();
	    if(row >= 0){
		theView.getAdminPanel().getTfLogin().setText((String) adminTable.getValueAt(row, 0));
		theView.getAdminPanel().getTfPass().setText((String) adminTable.getValueAt(row, 1)); 
	    }else{
		JOptionPane.showMessageDialog(theView.getFrame(),"Not possible to fetch the record. Refresh and try again");
	    }
	}
    }

    public class DeleteUserListener implements ActionListener{

	public void actionPerformed(ActionEvent arg0) {

	    try {
		if(!theView.getAdminPanel().getTfLogin().getText().equals("")){
		    String username = theView.getAdminPanel().getTfLogin().getText();
		    logDB.deleteUser(username);
		    getAndShowAdminTable();
		    theView.getAdminPanel().cleanAllFields();

		}else{
		    JOptionPane.showMessageDialog(theView.getFrame(),"Insert correct username");
		}
	    } catch (Exception e) {
		JOptionPane.showMessageDialog(null, "Done!!!");

	    }
	}
    }

    
    
    public class BtnPassengerPanelCancelListener implements ActionListener {

   	public void actionPerformed(ActionEvent e) {
   	    theView.getReservationPanel().busDetailsEnabled(true);
   	    passenger.getFrame().dispatchEvent(new WindowEvent(passenger.getFrame(), WindowEvent.WINDOW_CLOSING));
   	}
       }

    public class BtnPassengerPanelSubmitListener implements ActionListener {

	public void actionPerformed(ActionEvent e) {
	    String passengerName = "";
	    String email = "";
	    String mobile = "";

	    passengerName = passenger.getTxtName().getText();
	    email = passenger.getTxtEmailAdress().getText();
	    mobile = passenger.getTxtMobileNumber().getText();

	    
	    if(passengerName.isEmpty() || email.isEmpty() || mobile.isEmpty()){
		JOptionPane.showMessageDialog(passenger.getFrame(),"Name, e-mail and phone number must be entered!");
	    }else{
		if(email.contains("@")){
		    
		    String source = passenger.getLblShowfrom().getText();
		    String destination = passenger.getLblShowto().getText();
		    String date = passenger.getLblShowdate().getText();
		    String timing = passenger.getLblShowleavingtime().getText();
		    String distance = passenger.getLblShowdistance().getText();
		    String cost = Double.toString(model.BusTicketCalculations.getTicketPrice(Double.parseDouble(distance)));
		    String busId = passenger.getLblShowbusid().getText();
		    String seat = passenger.getLblShowseat().getText();
		    String ticketNumber = passenger.getLblShowticketno().getText();
		    try {
			
			dbModel.addNewTicket(ticketNumber, source, destination, date, timing, distance, cost, busId, seat, passengerName, mobile, email);

			
			String fileName = null;
			int returnVal = theView.getPrinter().showSaveDialog(null);
			if(returnVal == JFileChooser.APPROVE_OPTION) {
			    fileName = theView.getPrinter().getSelectedFile().getAbsolutePath();
			    try {
				Image ticketImage = model.PDFPrinter.getImageFromPanel(passenger.getFrame());
				model.PDFPrinter.printCwToPdf(ticketImage, fileName + ".pdf", ticketNumber);

				
				String textTicket = builtTxtTicket(ticketNumber, source, destination, date, timing,
					distance, cost, busId, seat,passengerName, mobile);
				LinkedList <String> to = new LinkedList<String>();
				to.add(email);
				EmailMessage wiadomosc = new EmailMessage.EmailBuilder("marek.czwartek@wp.pl", to)
					.addSubject("Ticket purchase confirmation " + ticketNumber)
					.addContent(textTicket)
					.build();

				wiadomosc.send("adrianroguski1990", "smtp.wp.pl", 465);

			    } catch (DocumentException  e5) {
				JOptionPane.showMessageDialog(theView.getFrame(), "Problem with the file you want write to. Please check the file!");
				e5.printStackTrace();
			    }catch (IOException   e2) {
				JOptionPane.showMessageDialog(theView.getFrame(), "Problem with image you want to print out!");
				e2.printStackTrace();
			    }catch(javax.mail.internet.AddressException me){
				JOptionPane.showMessageDialog(theView.getFrame(), "Email adress incorrect!");
				me.printStackTrace();
			    }
			}
			
			updateSeatsInTheBus(busId, seat);

		    } catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Done!!!");
		    }

		    
		    new BtnPassengerPanelCancelListener().actionPerformed(null);
		    new BtnResetListener().actionPerformed(null);

		}else{
		    JOptionPane.showMessageDialog(passenger.getFrame(),"Incorrect e-mail adress");
		}
	    }
	}

    }
    
    public class SeatButtonPressed implements ItemListener{

	public void itemStateChanged(ItemEvent event) {
	    if(event.getStateChange() == ItemEvent.SELECTED){
		JToggleButton buttonPressed = (JToggleButton) event.getItem();
		theView.getReservationPanel().getBusLayout().disableTheRestOfButtons(buttonPressed);
		seatNumberSelected = buttonPressed.getName().substring(4);
	    }else if(event.getStateChange() == ItemEvent.DESELECTED){
		
		String id = theView.getReservationPanel().getBusListDropDown().getSelectedItem().toString().split(" ")[0];
		theView.getReservationPanel().deleteLayoutPanel();
		updateBusLayoutAccordingToDatabase(id);
		addListenerToTheSeatButtons();
		seatNumberSelected = null;
	    }
	}
    }
    
    
    public void  cleanTicketManagementFields(){
	JTable ticketTable = theView.getTicketsPanel().getTicketTable();
	if(ticketTable.getRowCount() > 0){ 
	    theView.getTicketsPanel().getTfTicketNumber().setText(Long.toString((Long) ticketTable.getValueAt(0, 0))); 
	}else{
	    theView.getTicketsPanel().getTfTicketNumber().setText("0"); 
	}
	theView.getTicketsPanel().getTfTicketNumber().setText("");
	theView.getTicketsPanel().getTfPassengerName().setText("");
	theView.getTicketsPanel().getTfMobile().setText("");
	theView.getTicketsPanel().getTfEmail().setText("");

    }
    
    public String builtTxtTicket(String ticketNumber, String source,
	    String destination, String date, String timing, String distance,
	    String cost, String busId, String seat, String passengerName,
	    String mobile) {
	String textTicket = "Your purchase comfirmation: \n"+
		"Ticket number: " + ticketNumber + "\n"+
		"From: " + source + "\n"+
		"To: " + destination + "\n"+
		"Date: " + date + "\n"+
		"Leaving " + timing + "\n"+
		"Distance: " + distance + "\n"+
		"Price: " + cost + "\n"+
		"Bus ID " + busId + "\n"+
		"Seat number: " + seat + "\n"+
		"Passenger name: " + passengerName + "\n"+
		"Mob.: " + mobile + "\n"
		;
	return textTicket;
    }
    
    public void updateBusLayoutAccordingToDatabase(String id) {
	try {
	    ResultSet theBus = dbModel.getBusWithID(id);
	    if(theBus.next()){
		String busType = theBus.getString("busType");
		String seatsOccupied = theBus.getString("seatsOccupied");
		theView.getReservationPanel().getLblShowbustype().setText(busType);
		theView.getReservationPanel().addLayoutPanel(busType, seatsOccupied);
	    }
	} catch (Exception e1) {
	    JOptionPane.showMessageDialog(null, "Done!!!");
	}
    }

    
    public int findBusType(String myBusType) {
	int i = 0;
	for(String str : GeneralView.allowedBusTypes){
	    if(str.toLowerCase().equals(myBusType.toLowerCase())){
		return i;
	    }
	    i++;
	}
	return i;
    }


    
    public int findHour(Object hh) {
	String HH = hh.toString().substring(0,2);
	int i = 0;
	for(String str : GeneralView.hours){
	    if(str.toLowerCase().equals(HH)){
		return i;
	    }
	    i++;
	}
	return i;
    }

    
    public int findMinutes(Object time) {
	String mm = time.toString().substring(3,5);
	int i = 0;
	for(String str : GeneralView.minutes){
	    if(str.toLowerCase().equals(mm)){
		return i;
	    }
	    i++;
	}
	return i;
    }

    
    public void fillFromComboBox(JComboBox<String> fromCB){
	HashSet <String> fromList = new HashSet <String> ();
	if(fromCB.getItemCount() > 0){
	    fromCB.removeAllItems();
	}

	try {
	    ResultSet rs = dbModel.getBusTimeTable();
	    String name = "";
	    while(rs.next()){
		name = rs.getString("source");
		if(!fromList.contains(name)){
		    fromList.add(name);
		    fromCB.addItem(name);
		}
	    }

	} catch (Exception e) {
	    JOptionPane.showMessageDialog(null, "Done!!!");
	}

    }

    
    public void fillToComboBox(JComboBox<String> toCB, JComboBox<String> fromCB) {
	if(fromCB.getItemCount() > 0){
	    toCB.removeAllItems();
	    if(fromCB.getSelectedItem() == null){
		System.out.print(theView.getReservationPanel().getFromDropDown().getItemCount() + "!!!!!!!!!!");
	    }
	    try {
		ResultSet rs = dbModel.getBusTimeTable();
		String to = "";
		String from = "";
		while(rs.next()){
		    to = rs.getString("destination");
		    from = rs.getString("source");

		    if(fromCB.getSelectedItem().toString().toLowerCase().equals(from.toLowerCase())){
			toCB.addItem(to);
		    }
		}
	    } catch (Exception e) {
		JOptionPane.showMessageDialog(null, "Done!!!");
	    }
	}
    }
    
    public void fillBusListDropDown(String from, String to){
	theView.getReservationPanel().getBusListDropDown().removeAllItems();
	try {
	    ResultSet rs = dbModel.getBusDetials(from, to);
	    String busID = "";
	    String company = "";
	    String time = "";
	    while(rs.next()){
		busID = rs.getString("busId");
		company = rs.getString("busName");
		time = rs.getString("timingSource");
		theView.getReservationPanel().getBusListDropDown().addItem(busID + " " +company + " " + time);
	    }
	} catch (Exception e) {
	    JOptionPane.showMessageDialog(null, "Done!!!");
	}
    }

    

    
    public long getUniqueID() {
	return new Date().getTime();
    }
    
    public void updateSeatsInTheBus(String id, String seat) throws Exception{
	ResultSet rs = dbModel.getBusWithID(id);
	if(rs.next()){
	    String newSeats = rs.getString("seatsOccupied");
	    newSeats = newSeats + ";" + seat;
	    dbModel.updateBusSeats(Integer.parseInt(id), newSeats);
	}

    }

    
    public boolean verifyUser(String username, String pwd){
	try {
	    ResultSet user = logDB.getUser(username);
	    if(user.next()){
		String password = user.getString("password");
		if(pwd.equals(password)){
		    return true;
		}
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return false;
    }

    
    public void showDbErrorMessage(Exception e){
	JOptionPane.showMessageDialog(theView.getFrame(),"Done!!!");
	System.out.println(e.getMessage());
    }
}
