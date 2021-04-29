package view;

import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JToggleButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;

public class AirConditionedLayout extends BusLayout{


    private static final long serialVersionUID = 1L;
    

    public AirConditionedLayout() {

	setBorder(new LineBorder(new Color(255, 0, 0), 3, true));
	setLayout(null);

	JToggleButton seat1 = new JToggleButton("");
	seat1.setName("seat1");
	seat1.setToolTipText("");
	seat1.setSelectedIcon(new ImageIcon(AirConditionedLayout.class.getResource("/view/occupiedSeat.png")));
	seat1.setIcon(new ImageIcon(AirConditionedLayout.class.getResource("/view/freeSeat.png")));
	seat1.setBounds(10, 27, 35, 32);
	add(seat1);

	JToggleButton seat4 = new JToggleButton("");
	seat4.setName("seat4");
	seat4.setSelectedIcon(new ImageIcon(AirConditionedLayout.class.getResource("/view/occupiedSeat.png")));
	seat4.setIcon(new ImageIcon(AirConditionedLayout.class.getResource("/view/freeSeat.png")));
	seat4.setToolTipText("");
	seat4.setBounds(55, 27, 35, 32);
	add(seat4);

	JToggleButton seat7 = new JToggleButton("");
	seat7.setName("seat7");
	seat7.setSelectedIcon(new ImageIcon(AirConditionedLayout.class.getResource("/view/occupiedSeat.png")));
	seat7.setIcon(new ImageIcon(AirConditionedLayout.class.getResource("/view/freeSeat.png")));
	seat7.setToolTipText("");
	seat7.setBounds(100, 27, 35, 32);
	add(seat7);

	JToggleButton seat10 = new JToggleButton("");
	seat10.setName("seat10");
	seat10.setSelectedIcon(new ImageIcon(AirConditionedLayout.class.getResource("/view/occupiedSeat.png")));
	seat10.setIcon(new ImageIcon(AirConditionedLayout.class.getResource("/view/freeSeat.png")));
	seat10.setToolTipText("");
	seat10.setBounds(145, 27, 35, 32);
	add(seat10);

	JToggleButton seat13 = new JToggleButton("");
	seat13.setName("seat13");
	seat13.setSelectedIcon(new ImageIcon(AirConditionedLayout.class.getResource("/view/occupiedSeat.png")));
	seat13.setIcon(new ImageIcon(AirConditionedLayout.class.getResource("/view/freeSeat.png")));
	seat13.setToolTipText("");
	seat13.setBounds(190, 27, 35, 32);
	add(seat13);

	JToggleButton seat16 = new JToggleButton("");
	seat16.setName("seat15");
	seat16.setSelectedIcon(new ImageIcon(AirConditionedLayout.class.getResource("/view/occupiedSeat.png")));
	seat16.setIcon(new ImageIcon(AirConditionedLayout.class.getResource("/view/freeSeat.png")));
	seat16.setToolTipText("");
	seat16.setBounds(235, 27, 35, 32);
	add(seat16);

	JToggleButton seat19 = new JToggleButton("");
	seat19.setName("seat19");
	seat19.setSelectedIcon(new ImageIcon(AirConditionedLayout.class.getResource("/view/occupiedSeat.png")));
	seat19.setIcon(new ImageIcon(AirConditionedLayout.class.getResource("/view/freeSeat.png")));
	seat19.setToolTipText("");
	seat19.setBounds(280, 27, 35, 32);
	add(seat19);

	JToggleButton seat22 = new JToggleButton("");
	seat22.setName("seat22");
	seat22.setSelectedIcon(new ImageIcon(AirConditionedLayout.class.getResource("/view/occupiedSeat.png")));
	seat22.setIcon(new ImageIcon(AirConditionedLayout.class.getResource("/view/freeSeat.png")));
	seat22.setToolTipText("");
	seat22.setBounds(325, 27, 35, 32);
	add(seat22);

	JToggleButton seat25 = new JToggleButton("");
	seat25.setName("seat25");
	seat25.setSelectedIcon(new ImageIcon(AirConditionedLayout.class.getResource("/view/occupiedSeat.png")));
	seat25.setIcon(new ImageIcon(AirConditionedLayout.class.getResource("/view/freeSeat.png")));
	seat25.setToolTipText("");
	seat25.setBounds(370, 27, 35, 32);
	add(seat25);

	JToggleButton seat28 = new JToggleButton("");
	seat28.setName("seat28");
	seat28.setSelectedIcon(new ImageIcon(AirConditionedLayout.class.getResource("/view/occupiedSeat.png")));
	seat28.setIcon(new ImageIcon(AirConditionedLayout.class.getResource("/view/freeSeat.png")));
	seat28.setToolTipText("");
	seat28.setBounds(415, 27, 35, 32);
	add(seat28);

	JToggleButton seat29 = new JToggleButton("");
	seat29.setName("seat29");
	seat29.setSelectedIcon(new ImageIcon(AirConditionedLayout.class.getResource("/view/occupiedSeat.png")));
	seat29.setIcon(new ImageIcon(AirConditionedLayout.class.getResource("/view/freeSeat.png")));
	seat29.setToolTipText("");
	seat29.setBounds(415, 77, 35, 32);
	add(seat29);

	JToggleButton seat26 = new JToggleButton("");
	seat26.setName("seat26");
	seat26.setSelectedIcon(new ImageIcon(AirConditionedLayout.class.getResource("/view/occupiedSeat.png")));
	seat26.setIcon(new ImageIcon(AirConditionedLayout.class.getResource("/view/freeSeat.png")));
	seat26.setToolTipText("");
	seat26.setBounds(370, 77, 35, 32);
	add(seat26);

	JToggleButton seat23 = new JToggleButton("");
	seat23.setName("seat23");
	seat23.setSelectedIcon(new ImageIcon(AirConditionedLayout.class.getResource("/view/occupiedSeat.png")));
	seat23.setIcon(new ImageIcon(AirConditionedLayout.class.getResource("/view/freeSeat.png")));
	seat23.setToolTipText("");
	seat23.setBounds(325, 77, 35, 32);
	add(seat23);

	JToggleButton seat20 = new JToggleButton("");
	seat20.setName("seat20");
	seat20.setSelectedIcon(new ImageIcon(AirConditionedLayout.class.getResource("/view/occupiedSeat.png")));
	seat20.setIcon(new ImageIcon(AirConditionedLayout.class.getResource("/view/freeSeat.png")));
	seat20.setToolTipText("");
	seat20.setBounds(280, 77, 35, 32);
	add(seat20);

	JToggleButton seat17 = new JToggleButton("");
	seat17.setName("seat17");
	seat17.setSelectedIcon(new ImageIcon(AirConditionedLayout.class.getResource("/view/occupiedSeat.png")));
	seat17.setIcon(new ImageIcon(AirConditionedLayout.class.getResource("/view/freeSeat.png")));
	seat17.setToolTipText("");
	seat17.setBounds(235, 77, 35, 32);
	add(seat17);

	JToggleButton seat14 = new JToggleButton("");
	seat14.setName("seat14");
	seat14.setSelectedIcon(new ImageIcon(AirConditionedLayout.class.getResource("/view/occupiedSeat.png")));
	seat14.setIcon(new ImageIcon(AirConditionedLayout.class.getResource("/view/freeSeat.png")));
	seat14.setToolTipText("");
	seat14.setBounds(190, 77, 35, 32);
	add(seat14);

	JToggleButton seat11 = new JToggleButton("");
	seat11.setName("seat11");
	seat11.setSelectedIcon(new ImageIcon(AirConditionedLayout.class.getResource("/view/occupiedSeat.png")));
	seat11.setIcon(new ImageIcon(AirConditionedLayout.class.getResource("/view/freeSeat.png")));
	seat11.setToolTipText("");
	seat11.setBounds(145, 77, 35, 32);
	add(seat11);

	JToggleButton seat8 = new JToggleButton("");
	seat8.setName("seat8");
	seat8.setSelectedIcon(new ImageIcon(AirConditionedLayout.class.getResource("/view/occupiedSeat.png")));
	seat8.setIcon(new ImageIcon(AirConditionedLayout.class.getResource("/view/freeSeat.png")));
	seat8.setToolTipText("");
	seat8.setBounds(100, 77, 35, 32);
	add(seat8);

	JToggleButton seat5 = new JToggleButton("");
	seat5.setName("seat5");
	seat5.setSelectedIcon(new ImageIcon(AirConditionedLayout.class.getResource("/view/occupiedSeat.png")));
	seat5.setIcon(new ImageIcon(AirConditionedLayout.class.getResource("/view/freeSeat.png")));
	seat5.setToolTipText("");
	seat5.setBounds(55, 77, 35, 32);
	add(seat5);

	JToggleButton seat2 = new JToggleButton("");
	seat2.setName("seat2");
	seat2.setSelectedIcon(new ImageIcon(AirConditionedLayout.class.getResource("/view/occupiedSeat.png")));
	seat2.setIcon(new ImageIcon(AirConditionedLayout.class.getResource("/view/freeSeat.png")));
	seat2.setToolTipText("");
	seat2.setBounds(10, 77, 35, 32);
	add(seat2);

	JToggleButton seat30 = new JToggleButton("");
	seat30.setName("seat30");
	seat30.setSelectedIcon(new ImageIcon(AirConditionedLayout.class.getResource("/view/occupiedSeat.png")));
	seat30.setIcon(new ImageIcon(AirConditionedLayout.class.getResource("/view/freeSeat.png")));
	seat30.setToolTipText("1");
	seat30.setBounds(415, 157, 35, 32);
	add(seat30);

	JToggleButton seat27 = new JToggleButton("");
	seat27.setName("seat27");
	seat27.setSelectedIcon(new ImageIcon(AirConditionedLayout.class.getResource("/view/occupiedSeat.png")));
	seat27.setIcon(new ImageIcon(AirConditionedLayout.class.getResource("/view/freeSeat.png")));
	seat27.setToolTipText("");
	seat27.setBounds(370, 157, 35, 32);
	add(seat27);

	JToggleButton seat24 = new JToggleButton("");
	seat24.setName("seat24");
	seat24.setSelectedIcon(new ImageIcon(AirConditionedLayout.class.getResource("/view/occupiedSeat.png")));
	seat24.setIcon(new ImageIcon(AirConditionedLayout.class.getResource("/view/freeSeat.png")));
	seat24.setToolTipText("");
	seat24.setBounds(325, 157, 35, 32);
	add(seat24);

	JToggleButton seat21 = new JToggleButton("");
	seat21.setName("seat21");
	seat21.setName("seat21");
	seat21.setSelectedIcon(new ImageIcon(AirConditionedLayout.class.getResource("/view/occupiedSeat.png")));
	seat21.setIcon(new ImageIcon(AirConditionedLayout.class.getResource("/view/freeSeat.png")));
	seat21.setToolTipText("");
	seat21.setBounds(280, 157, 35, 32);
	add(seat21);

	JToggleButton seat18 = new JToggleButton("");
	seat18.setName("seat18");
	seat18.setSelectedIcon(new ImageIcon(AirConditionedLayout.class.getResource("/view/occupiedSeat.png")));
	seat18.setIcon(new ImageIcon(AirConditionedLayout.class.getResource("/view/freeSeat.png")));
	seat18.setToolTipText("");
	seat18.setBounds(235, 157, 35, 32);
	add(seat18);

	JToggleButton seat15 = new JToggleButton("");
	seat15.setName("seat15");
	seat15.setSelectedIcon(new ImageIcon(AirConditionedLayout.class.getResource("/view/occupiedSeat.png")));
	seat15.setIcon(new ImageIcon(AirConditionedLayout.class.getResource("/view/freeSeat.png")));
	seat15.setToolTipText("");
	seat15.setBounds(190, 157, 35, 32);
	add(seat15);

	JToggleButton seat12 = new JToggleButton("");
	seat12.setName("seat12");
	seat12.setSelectedIcon(new ImageIcon(AirConditionedLayout.class.getResource("/view/occupiedSeat.png")));
	seat12.setIcon(new ImageIcon(AirConditionedLayout.class.getResource("/view/freeSeat.png")));
	seat12.setToolTipText("");
	seat12.setBounds(145, 157, 35, 32);
	add(seat12);

	JToggleButton seat9 = new JToggleButton("");
	seat9.setName("seat9");
	seat9.setSelectedIcon(new ImageIcon(AirConditionedLayout.class.getResource("/view/occupiedSeat.png")));
	seat9.setIcon(new ImageIcon(AirConditionedLayout.class.getResource("/view/freeSeat.png")));
	seat9.setToolTipText("");
	seat9.setBounds(100, 157, 35, 32);
	add(seat9);

	JToggleButton seat6 = new JToggleButton("");
	seat6.setName("seat6");
	seat6.setSelectedIcon(new ImageIcon(AirConditionedLayout.class.getResource("/view/occupiedSeat.png")));
	seat6.setIcon(new ImageIcon(AirConditionedLayout.class.getResource("/view/freeSeat.png")));
	seat6.setToolTipText("");
	seat6.setBounds(55, 157, 35, 32);
	add(seat6);

	JToggleButton seat3 = new JToggleButton("");
	seat3.setName("seat3");
	seat3.setSelectedIcon(new ImageIcon(AirConditionedLayout.class.getResource("/view/occupiedSeat.png")));
	seat3.setIcon(new ImageIcon(AirConditionedLayout.class.getResource("/view/freeSeat.png")));
	seat3.setToolTipText("");
	seat3.setBounds(10, 157, 35, 32);
	add(seat3);
	
	JLabel label = new JLabel("1");
	label.setFont(new Font("Tahoma", Font.BOLD, 14));
	label.setBounds(20, 142, 16, 14);
	add(label);
	
	JLabel label_1 = new JLabel("2");
	label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
	label_1.setBounds(20, 62, 16, 14);
	add(label_1);
	
	JLabel label_2 = new JLabel("3");
	label_2.setFont(new Font("Tahoma", Font.BOLD, 14));
	label_2.setBounds(22, 11, 16, 14);
	add(label_2);
	
	JLabel label_3 = new JLabel("4");
	label_3.setFont(new Font("Tahoma", Font.BOLD, 14));
	label_3.setBounds(65, 142, 16, 14);
	add(label_3);
	
	JLabel label_4 = new JLabel("5");
	label_4.setFont(new Font("Tahoma", Font.BOLD, 14));
	label_4.setBounds(65, 62, 16, 14);
	add(label_4);
	
	JLabel label_5 = new JLabel("6");
	label_5.setFont(new Font("Tahoma", Font.BOLD, 14));
	label_5.setBounds(67, 11, 16, 14);
	add(label_5);
	
	JLabel label_6 = new JLabel("7");
	label_6.setFont(new Font("Tahoma", Font.BOLD, 14));
	label_6.setBounds(110, 142, 16, 14);
	add(label_6);
	
	JLabel label_7 = new JLabel("8");
	label_7.setFont(new Font("Tahoma", Font.BOLD, 14));
	label_7.setBounds(110, 62, 16, 14);
	add(label_7);
	
	JLabel label_8 = new JLabel("9");
	label_8.setFont(new Font("Tahoma", Font.BOLD, 14));
	label_8.setBounds(112, 11, 16, 14);
	add(label_8);
	
	JLabel label_9 = new JLabel("10");
	label_9.setFont(new Font("Tahoma", Font.BOLD, 14));
	label_9.setBounds(155, 142, 18, 14);
	add(label_9);
	
	JLabel label_10 = new JLabel("11");
	label_10.setFont(new Font("Tahoma", Font.BOLD, 14));
	label_10.setBounds(155, 62, 25, 14);
	add(label_10);
	
	JLabel label_11 = new JLabel("12");
	label_11.setFont(new Font("Tahoma", Font.BOLD, 14));
	label_11.setBounds(157, 11, 23, 14);
	add(label_11);
	
	JLabel label_12 = new JLabel("13");
	label_12.setFont(new Font("Tahoma", Font.BOLD, 14));
	label_12.setBounds(200, 142, 25, 14);
	add(label_12);
	
	JLabel label_13 = new JLabel("14");
	label_13.setFont(new Font("Tahoma", Font.BOLD, 14));
	label_13.setBounds(200, 62, 25, 14);
	add(label_13);
	
	JLabel label_14 = new JLabel("15");
	label_14.setFont(new Font("Tahoma", Font.BOLD, 14));
	label_14.setBounds(202, 11, 23, 14);
	add(label_14);
	
	JLabel label_15 = new JLabel("16");
	label_15.setFont(new Font("Tahoma", Font.BOLD, 14));
	label_15.setBounds(245, 142, 25, 14);
	add(label_15);
	
	JLabel label_16 = new JLabel("17");
	label_16.setFont(new Font("Tahoma", Font.BOLD, 14));
	label_16.setBounds(245, 62, 25, 14);
	add(label_16);
	
	JLabel label_17 = new JLabel("18");
	label_17.setFont(new Font("Tahoma", Font.BOLD, 14));
	label_17.setBounds(247, 11, 23, 14);
	add(label_17);
	
	JLabel label_18 = new JLabel("19");
	label_18.setFont(new Font("Tahoma", Font.BOLD, 14));
	label_18.setBounds(290, 142, 25, 14);
	add(label_18);
	
	JLabel label_19 = new JLabel("20");
	label_19.setFont(new Font("Tahoma", Font.BOLD, 14));
	label_19.setBounds(290, 62, 25, 14);
	add(label_19);
	
	JLabel label_20 = new JLabel("21");
	label_20.setFont(new Font("Tahoma", Font.BOLD, 14));
	label_20.setBounds(292, 11, 23, 14);
	add(label_20);
	
	JLabel label_21 = new JLabel("22");
	label_21.setFont(new Font("Tahoma", Font.BOLD, 14));
	label_21.setBounds(335, 142, 25, 14);
	add(label_21);
	
	JLabel label_22 = new JLabel("23");
	label_22.setFont(new Font("Tahoma", Font.BOLD, 14));
	label_22.setBounds(335, 62, 25, 14);
	add(label_22);
	
	JLabel label_23 = new JLabel("24");
	label_23.setFont(new Font("Tahoma", Font.BOLD, 14));
	label_23.setBounds(337, 11, 23, 14);
	add(label_23);
	
	JLabel label_24 = new JLabel("25");
	label_24.setFont(new Font("Tahoma", Font.BOLD, 14));
	label_24.setBounds(380, 142, 25, 14);
	add(label_24);
	
	JLabel label_25 = new JLabel("26");
	label_25.setFont(new Font("Tahoma", Font.BOLD, 14));
	label_25.setBounds(380, 62, 25, 14);
	add(label_25);
	
	JLabel label_26 = new JLabel("27");
	label_26.setFont(new Font("Tahoma", Font.BOLD, 14));
	label_26.setBounds(382, 11, 23, 14);
	add(label_26);
	
	JLabel label_27 = new JLabel("28");
	label_27.setFont(new Font("Tahoma", Font.BOLD, 14));
	label_27.setBounds(425, 142, 25, 14);
	add(label_27);
	
	JLabel label_28 = new JLabel("29");
	label_28.setFont(new Font("Tahoma", Font.BOLD, 14));
	label_28.setBounds(425, 62, 25, 14);
	add(label_28);
	
	JLabel label_29 = new JLabel("30");
	label_29.setFont(new Font("Tahoma", Font.BOLD, 14));
	label_29.setBounds(427, 11, 23, 14);
	add(label_29);

    }
  
}
