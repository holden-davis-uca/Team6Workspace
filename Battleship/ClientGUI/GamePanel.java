package ClientGUI;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import ClientCommunication.LobbyControl;
	
	
public class GamePanel extends JPanel{
	private JTextField textField;
	public GamePanel() {
		setLayout(null);
		
		JButton button11 = new JButton("");
		button11.setBounds(10, 75, 41, 41);
		add(button11);
		
		JButton button12 = new JButton("");
		button12.setBounds(61, 75, 41, 41);
		add(button12);
		
		JButton button13 = new JButton("");
		button13.setBounds(112, 75, 41, 41);
		add(button13);
		
		JButton button14 = new JButton("");
		button14.setBounds(163, 75, 41, 41);
		add(button14);
		
		JButton button15 = new JButton("");
		button15.setBounds(214, 75, 41, 41);
		add(button15);
		
		JButton button16 = new JButton("");
		button16.setBounds(10, 127, 41, 41);
		add(button16);
		
		JButton button17 = new JButton("");
		button17.setBounds(61, 127, 41, 41);
		add(button17);
		
		JButton button18 = new JButton("");
		button18.setBounds(112, 127, 41, 41);
		add(button18);
		
		JButton button19 = new JButton("");
		button19.setBounds(163, 127, 41, 41);
		add(button19);
		
		JButton button110 = new JButton("");
		button110.setBounds(214, 127, 41, 41);
		add(button110);
		
		JButton button115 = new JButton("");
		button115.setBounds(214, 179, 41, 41);
		add(button115);
		
		JButton button114 = new JButton("");
		button114.setBounds(163, 179, 41, 41);
		add(button114);
		
		JButton button113 = new JButton("");
		button113.setBounds(112, 179, 41, 41);
		add(button113);
		
		JButton button112 = new JButton("");
		button112.setBounds(61, 179, 41, 41);
		add(button112);
		
		JButton button111 = new JButton("");
		button111.setBounds(10, 179, 41, 41);
		add(button111);
		
		JButton button116 = new JButton("");
		button116.setBounds(10, 231, 41, 41);
		add(button116);
		
		JButton button117 = new JButton("");
		button117.setBounds(61, 231, 41, 41);
		add(button117);
		
		JButton button118 = new JButton("");
		button118.setBounds(112, 231, 41, 41);
		add(button118);
		
		JButton button119 = new JButton("");
		button119.setBounds(163, 231, 41, 41);
		add(button119);
		
		JButton button120 = new JButton("");
		button120.setBounds(214, 231, 41, 41);
		add(button120);
		
		JButton button121 = new JButton("");
		button121.setBounds(10, 283, 41, 41);
		add(button121);
		
		JButton button122 = new JButton("");
		button122.setBounds(61, 283, 41, 41);
		add(button122);
		
		JButton button123 = new JButton("");
		button123.setBounds(112, 283, 41, 41);
		add(button123);
		
		JButton button124 = new JButton("");
		button124.setBounds(163, 283, 41, 41);
		add(button124);
		
		JButton button125 = new JButton("");
		button125.setBounds(214, 283, 41, 41);
		add(button125);
		
		JButton button225 = new JButton("");
		button225.setBounds(214, 604, 41, 41);
		add(button225);
		
		JButton button224 = new JButton("");
		button224.setBounds(163, 604, 41, 41);
		add(button224);
		
		JButton button223 = new JButton("");
		button223.setBounds(112, 604, 41, 41);
		add(button223);
		
		JButton button222 = new JButton("");
		button222.setBounds(61, 604, 41, 41);
		add(button222);
		
		JButton button221 = new JButton("");
		button221.setBounds(10, 604, 41, 41);
		add(button221);
		
		JButton button216 = new JButton("");
		button216.setBounds(10, 552, 41, 41);
		add(button216);
		
		JButton button217 = new JButton("");
		button217.setBounds(61, 552, 41, 41);
		add(button217);
		
		JButton button218 = new JButton("");
		button218.setBounds(112, 552, 41, 41);
		add(button218);
		
		JButton button219 = new JButton("");
		button219.setBounds(163, 552, 41, 41);
		add(button219);
		
		JButton button220 = new JButton("");
		button220.setBounds(214, 552, 41, 41);
		add(button220);
		
		JButton button215 = new JButton("");
		button215.setBounds(214, 500, 41, 41);
		add(button215);
		
		JButton button214 = new JButton("");
		button214.setBounds(163, 500, 41, 41);
		add(button214);
		
		JButton button213 = new JButton("");
		button213.setBounds(112, 500, 41, 41);
		add(button213);
		
		JButton button212 = new JButton("");
		button212.setBounds(61, 500, 41, 41);
		add(button212);
		
		JButton button211 = new JButton("");
		button211.setBounds(10, 500, 41, 41);
		add(button211);
		
		JButton button26 = new JButton("");
		button26.setBounds(10, 448, 41, 41);
		add(button26);
		
		JButton button27 = new JButton("");
		button27.setBounds(61, 448, 41, 41);
		add(button27);
		
		JButton button28 = new JButton("");
		button28.setBounds(112, 448, 41, 41);
		add(button28);
		
		JButton button29 = new JButton("");
		button29.setBounds(163, 448, 41, 41);
		add(button29);
		
		JButton button210 = new JButton("");
		button210.setBounds(214, 448, 41, 41);
		add(button210);
		
		JButton button25 = new JButton("");
		button25.setBounds(214, 396, 41, 41);
		add(button25);
		
		JButton button24 = new JButton("");
		button24.setBounds(163, 396, 41, 41);
		add(button24);
		
		JButton button23 = new JButton("");
		button23.setBounds(112, 396, 41, 41);
		add(button23);
		
		JButton button22 = new JButton("");
		button22.setBounds(61, 396, 41, 41);
		add(button22);
		
		JButton button21 = new JButton("");
		button21.setBounds(10, 396, 41, 41);
		add(button21);
		
		textField = new JTextField();
		textField.setBounds(10, 335, 245, 50);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblTitle = new JLabel("BattleShip");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(0, 0, 266, 14);
		add(lblTitle);
	}
}
