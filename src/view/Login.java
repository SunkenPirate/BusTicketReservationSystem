package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.SpringLayout;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class Login extends JFrame {

    
    private static final long serialVersionUID = -3266034216160504470L;
    private JPanel contentPane;
    private JTextField tfLogin;
    private JPasswordField pfPassword;
    private JButton btnSubmit;

    public JTextField getTfLogin() {
        return tfLogin;
    }

    public JPasswordField getPfPassword() {
        return pfPassword;
    }

    public JButton getBtnSubmit() {
        return btnSubmit;
    }

    
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    Login frame = new Login();
		    frame.setVisible(true);
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	});
    }

    
    public Login() {
    	setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/view/Bus-2-icon.png")));
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 450, 300);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	SpringLayout sl_contentPane = new SpringLayout();
	contentPane.setLayout(sl_contentPane);
	
	JLabel lblLogin = new JLabel("Login:");
	lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
	contentPane.add(lblLogin);
	
	tfLogin = new JTextField();
	sl_contentPane.putConstraint(SpringLayout.NORTH, tfLogin, 0, SpringLayout.NORTH, lblLogin);
	sl_contentPane.putConstraint(SpringLayout.WEST, tfLogin, 6, SpringLayout.EAST, lblLogin);
	sl_contentPane.putConstraint(SpringLayout.EAST, tfLogin, 304, SpringLayout.WEST, contentPane);
	contentPane.add(tfLogin);
	tfLogin.setColumns(10);
	
	JLabel lblPassword = new JLabel("Password:");
	sl_contentPane.putConstraint(SpringLayout.NORTH, lblPassword, 162, SpringLayout.NORTH, contentPane);
	sl_contentPane.putConstraint(SpringLayout.SOUTH, lblLogin, -9, SpringLayout.NORTH, lblPassword);
	sl_contentPane.putConstraint(SpringLayout.WEST, lblPassword, 86, SpringLayout.WEST, contentPane);
	sl_contentPane.putConstraint(SpringLayout.EAST, lblLogin, 0, SpringLayout.EAST, lblPassword);
	lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
	contentPane.add(lblPassword);
	
	pfPassword = new JPasswordField();
	sl_contentPane.putConstraint(SpringLayout.NORTH, pfPassword, 0, SpringLayout.NORTH, lblPassword);
	sl_contentPane.putConstraint(SpringLayout.WEST, pfPassword, 6, SpringLayout.EAST, lblPassword);
	sl_contentPane.putConstraint(SpringLayout.EAST, pfPassword, -120, SpringLayout.EAST, contentPane);
	contentPane.add(pfPassword);
	
	btnSubmit = new JButton("Submit");
	sl_contentPane.putConstraint(SpringLayout.NORTH, btnSubmit, 6, SpringLayout.SOUTH, pfPassword);
	sl_contentPane.putConstraint(SpringLayout.WEST, btnSubmit, 0, SpringLayout.WEST, tfLogin);
	sl_contentPane.putConstraint(SpringLayout.EAST, btnSubmit, -120, SpringLayout.EAST, contentPane);
	contentPane.add(btnSubmit);
	
	JLabel lblNewLabel = new JLabel("");
	sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, contentPane);
	sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 0, SpringLayout.WEST, lblLogin);
	contentPane.add(lblNewLabel);
	lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/view/yellowbus.jpg")));
    }
}
