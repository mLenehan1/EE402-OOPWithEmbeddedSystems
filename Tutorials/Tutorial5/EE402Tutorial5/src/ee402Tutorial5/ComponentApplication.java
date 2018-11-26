package ee402Tutorial5;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class ComponentApplication extends Frame implements ActionListener{
	private Label l, aLabel, bLabel, multLabel;
	private Label[] lottoLabel;
	private TextField inField, aField, bField, multField;
	private TextField[] lottoField;
	private Button upper, lower, calculate, draw;
	
	public ComponentApplication() {
		/* *********************
		 * Q1
		 * *********************
		super("Hello World App");
		this.setLayout(new FlowLayout());
		l = new Label("Hello World!");
		this.add(l);
		this.pack();
		this.setVisible(true);
		*/
		
		/***********************
		 * Q2
		 ***********************
		super("Lower/UpperCase App");
		this.setLayout(new FlowLayout());
		this.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		inField = new TextField(20);
		upper = new Button("To Uppercase");
		lower = new Button("To Lowercase");
		upper.addActionListener(this);
		lower.addActionListener(this);
		this.add(inField);
		this.add(upper);
		this.add(lower);
		this.pack();
		this.setVisible(true);
		*/
		
		/*********************
		 * Q3
		 *********************
		super("Multiplication App");
		this.setLayout(new FlowLayout());
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		aField = new TextField(20);
		bField = new TextField(20);
		multField = new TextField(20);
		multField.setEditable(false);
		aLabel = new Label("A:");
		bLabel = new Label("B:");
		multLabel = new Label("A*B=");
		calculate = new Button("Calculate");
		calculate.addActionListener(this);
		this.add(aLabel);
		this.add(aField);
		this.add(bLabel);
		this.add(bField);
		this.add(multLabel);
		this.add(multField);
		this.add(calculate);
		this.pack();
		this.setVisible(true);
		*/
		
		/*******************
		 * Q4
		 */
		super("Lottery Application");
		this.setLayout(new FlowLayout());
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		lottoLabel = new Label[7];
		lottoField = new TextField[7];
		for(int i=0; i<7; i++) {
			lottoLabel[i] = new Label(new Integer(i+1) + ":");
			this.add(lottoLabel[i]);
			lottoField[i] = new TextField(20);
			lottoField[i].setEditable(false);
			this.add(lottoField[i]);
		}
		draw = new Button("Draw");
		draw.addActionListener(this);
		this.add(draw);
		this.pack();
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent a) {
		/*Q2
		 * if(a.getActionCommand().equals("To Uppercase")) {
		 * inField.setText(inField.getText().toUpperCase());
		}else if(a.getActionCommand().equals("To Lowercase")) {
			inField.setText(inField.getText().toLowerCase());
		}	
		 */
		/*Q3
		 * 	
		 *
		if(a.getActionCommand().equals("Calculate")) {
			multField.setText(new Integer(((Integer.valueOf(aField.getText()).intValue())*(Integer.valueOf(bField.getText()).intValue()))).toString());
		}
		*/
		if(a.getActionCommand().equals("Draw")) {
			for(int i=0; i<5; i++) {
				lottoField[i].setText(new Integer((int)(Math.random()*50)+1).toString());
			}
			for(int i=5; i<7; i++) {
				lottoField[i].setText(new Integer((int)(Math.random()*11)+1).toString());
			}
		}
	}
	
	public static void main(String[] args) {
		new ComponentApplication();
	}
	
}
