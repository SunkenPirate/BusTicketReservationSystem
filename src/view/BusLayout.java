package view;

import java.awt.Component;
import java.util.LinkedList;

import javax.swing.JPanel;
import javax.swing.JToggleButton;



public abstract class BusLayout extends JPanel{

    
    private static final long serialVersionUID = -958590561813322031L;

    
    public void loadOccupiedSeats(String seatsList) {
	String [] seatsArray = seatsList.split(";");
	for (String seat : seatsArray){
	    disableSeat("seat" + seat);
	}
    }

    
    public LinkedList<JToggleButton> getAllSeatButtons(){
	LinkedList<JToggleButton> seatButtons = new LinkedList<JToggleButton>();
	Component[] comp = this.getComponents();
	for (int i = 0;i<comp.length;i++) {
	    if (comp[i] instanceof JToggleButton) {
		seatButtons.add((JToggleButton)comp[i]);
	    }
	}
	return seatButtons;

    }
    
    public JToggleButton getSelectedSeat(String seatName){
	JToggleButton seat;
	Component[] comp = this.getComponents();
	for (int i = 0;i<comp.length;i++) {
	    if (comp[i] instanceof JToggleButton) {
		seat = (JToggleButton)comp[i];
		if(seat.getName().equals(seatName)){
		    return (JToggleButton)comp[i];
		}
	    }
	}
	return null;

    }

    
    public void disableSeat(String seatName){

	JToggleButton seat;
	Component[] comp = this.getComponents();
	for (int i = 0;i<comp.length;i++) {
	    if (comp[i] instanceof JToggleButton) {
		seat = (JToggleButton)comp[i];
		if(seat.getName().equals(seatName)){
		    seat.setSelected(true);
		    seat.setEnabled(false);
		}
	    }
	}
    }

    
    public void enableSeat(String seatName){

	JToggleButton seat;
	Component[] comp = this.getComponents();
	for (int i = 0;i<comp.length;i++) {
	    if (comp[i] instanceof JToggleButton) {
		seat = (JToggleButton)comp[i];
		if(seat.getName().equals(seatName)){
		    seat.setSelected(false);
		    seat.setEnabled(true);
		}
	    }
	}
    }

    
    public void disableTheRestOfButtons(JToggleButton buttonPressed) {
	for(JToggleButton button : getAllSeatButtons()){
	    if(!buttonPressed.getName().toLowerCase().equals(button.getName().toLowerCase())){
		button.setEnabled(false);
	    }
	}

    }


    public void enableAllSeatButtons() {
	for(JToggleButton button : getAllSeatButtons()){
	    button.setEnabled(true);
	}

    }
}
