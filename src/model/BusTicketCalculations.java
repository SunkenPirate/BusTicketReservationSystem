package model;


public class BusTicketCalculations {
    
    private static double farePerKilometer = 2.5;
   
    public static double getTicketPrice (double distance){
	return distance*farePerKilometer;
    }
}
