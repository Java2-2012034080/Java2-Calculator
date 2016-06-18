package Calculator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Cal_Frame extends JFrame implements ActionListener {


	private JPanel panel;
	private JTextArea show;
	private JButton[] but;
	private String[] but_name = { 
			"Back", "1/x", "%", "root", "/", // 0~4
 			"-/+", "7", "8", "9","x", //5~9
			"C", "4", "5", "6", "-",  //10~14
			"","1", "2", "3", "+",  //15~19
			"0", "00", ".", "", "=", }; //20~24

	private double result = 0;
	private double n=0;
	

	public Cal_Frame() {
		
		setSize(400,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("¹ÚÁöÈÆ / ±è¿µ¹Î °è»ê±â");
		
		show = new JTextArea(5,10);
		panel = new JPanel();
		show.setEditable(false);
		JScrollPane scroll = new JScrollPane(show);
		
		setLayout(new BorderLayout());
		add(scroll, BorderLayout.NORTH);
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 5, 3, 3));
		
		but = new JButton[but_name.length];
		for (int i = 0; i < but.length; i++) {
			but[i] = new JButton(but_name[i]);
			panel.add(but[i]);
			but[i].addActionListener(this);
			but[i].setForeground(Color.WHITE);
			but[i].setBackground(Color.BLACK);
		}
		
		setVisible(true);
		
	}

	public void actionPerformed(ActionEvent e) {
		
		
			
			
		
	}


}
