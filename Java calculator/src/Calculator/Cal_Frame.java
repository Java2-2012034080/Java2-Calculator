package Calculator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Cal_Frame extends JFrame implements ActionListener {


	private JPanel panel;
	private JTextArea log;
	private JTextField show;
	private Font font;
	private JButton[] but;
	private String[] but_name = { 
			"log", "1/x", "%", "root", "/", // 0~4
 			"-/+", "7", "8", "9","x", //5~9
			"C", "4", "5", "6", "-",  //10~14
			"","1", "2", "3", "+",  //15~19
			"0", "", ".", "", "=", }; //20~24

	private double result = 0;
	private double n1=0;
	private double n2=0;
	
	private String text1="";
	private String text2="";
	private String operator="";
	private boolean bool=false;

	
	
	private int count=0;
		

	public Cal_Frame() {
		
	
		
		setSize(400,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("박지훈 / 김영민 계산기");
		
		show = new JTextField(10);
		log = new JTextArea(5,10);
		panel = new JPanel();
		show.setEditable(false);
		JScrollPane scroll = new JScrollPane(log);
		font = new Font("f",Font.BOLD,50);
		show.setFont(font);
		
		setLayout(new BorderLayout());
		add(show, BorderLayout.NORTH);
		add(panel, BorderLayout.CENTER);
		add(scroll, BorderLayout.SOUTH);
		panel.setLayout(new GridLayout(0, 5, 3, 3));
		
		but = new JButton[but_name.length];
		for (int i = 0; i < but.length; i++) {
			but[i] = new JButton(but_name[i]);
			panel.add(but[i]);
			but[i].addActionListener(this);
			
			if(i==15||i==21||i==22||i==23){
				but[i].setForeground(Color.BLACK);
				but[i].setBackground(Color.BLACK);
				continue;
				}
			if(i%5==4){
				but[i].setForeground(Color.WHITE);
				but[i].setBackground(Color.BLUE);
				continue;
				}
			if(i==10){
				but[i].setForeground(Color.WHITE);
				but[i].setBackground(Color.RED);
				continue;
				}
			but[i].setForeground(Color.WHITE);
			but[i].setBackground(Color.BLACK);
		}
		
		setVisible(true);
		
	}

	public void actionPerformed(ActionEvent e) {
		
		
		if(bool){
			show.setText("");
			bool=false;
		}
		
		for(int i=0; i<but.length; i++){
			if(e.getSource()==but[i]){
				switch(i){
				case 6: //7
				case 7: //8
				case 8: //9
				case 11: //4
				case 12: //5
				case 13: //6
				case 16: //1
				case 17: //2
				case 18: //3
				case 20: //0
					
					text1=text1+but_name[i];
					show.setText(text1);
				
					break;
					
					
				case 0: //log
					n1=Double.parseDouble(text1);
					n1=Math.log10(n1);
					text1=Double.toString(n1);
					show.setText(text1);
					
					break;
				case 1: //inverse
					
					n1=Double.parseDouble(text1);
					n1=1/n1;
					text1=Double.toString(n1);
					show.setText(text1);
					
						
					break;
				case 2: //%
					text2 = show.getText();
					text1= "";
					show.setText("%");
					bool= true;
					if(count++==0)
						result=Integer.parseInt(text2);
					else	
						n2=Integer.parseInt(text2);
					calculating();
					operator="%";
					log.append(text2+operator);
					break;
				case 3: //root
					
					n1=Double.parseDouble(text1);
					n1=Math.sqrt(n1);
					text1=Double.toString(n1);
					show.setText(text1);
					
					break;
				case 4: // 나누기
					text2 = show.getText();
					text1= "";
					show.setText("/");
					bool= true;
					if(count++==0)
						result=Double.parseDouble(text2);
					else	
						n2=Double.parseDouble(text2);
					calculating();
					operator="/";
					log.append(text2+operator);
					break;
				case 5: // 부호
					
					n1=Double.parseDouble(text1);
					n1=n1*(-1);
					text1=Double.toString(n1);
					show.setText(text1);
					
					break;
				case 9: // 곱하기
					text2 = show.getText();
					text1= "";
					show.setText("x");
					bool= true;
					if(count++==0)
						result=Double.parseDouble(text2);
					else	
						n2=Double.parseDouble(text2);
					calculating();
					operator="x";
					log.append(text2+operator);
					break;
				case 10: // c
					text1=""; text2="";
					count=0;
					n2=0;
					result=0;
					show.setText(null);
					log.append("\n");
					break;
				case 14: //-
					text2 = show.getText();
					text1= "";
					show.setText("-");
					bool= true;
					if(count++==0)
						result=Double.parseDouble(text2);
					else	
						n2=Double.parseDouble(text2);
					calculating();
					operator="-";
					log.append(text2+operator);
					break;
				case 19: //+
					text2 = show.getText();
					text1= "";
					show.setText("+");
					bool= true;
					if(count++==0)
						result=Double.parseDouble(text2);
					else	
						n2=Double.parseDouble(text2);
					calculating();
					operator="+";
					log.append(text2+operator);
					break;
				case 22: // 소수점은 구현하지 못하였습니다 ㅠㅠ
					break;
				case 24: //=
					text2 = show.getText();
					n2=Double.parseDouble(text2);
					calculating();
					show.setText(""+result);
					log.append(text2+"="+result+"\n");
					result=0;
					n2=0;
					count=0;
					text1=""; text2="";
					break;
				}
			}		
		}		
	}

	public void calculating()
	{
		if(operator.equals("+"))
			result+=n2;
		if(operator.equals("-"))
			result-=n2;
		if(operator.equals("/"))
			result/=n2;
		if(operator.equals("*"))
			result*=n2;
		if(operator.equals("%"))
			result%=n2;
		else
			return;
	}

}
