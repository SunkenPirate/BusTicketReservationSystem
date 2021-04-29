package controller;

import java.awt.EventQueue;

import view.GeneralView;
import view.Login;


public class ApplicationRunner {

    
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    Controller appController = new Controller();
		    appController.start();
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	});


    }

}
