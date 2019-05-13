package ee4022016rq4;

import java.awt.*;
import java.awt.event.*;
import java.util.StringTokenizer;

import javax.swing.*;

public class StringHistogram extends JFrame implements ActionListener, WindowListener {
	
	private static final long serialVersionUID = 1L;
	int histogram[] = new int[10];
	JButton goButton;
	JTextArea textArea;
	JProgressBar[] progress = new JProgressBar[10];
	
	public StringHistogram(String[] args){
		super("EE402 2016R String Histogram");
		textArea = new JTextArea(5, 100);
		JScrollPane scroll = new JScrollPane(textArea);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		for(int i=0; i<args.length;i++) {
			textArea.append(args[i]+" ");
		}
		goButton = new JButton("Calculate Histogram");
		goButton.addActionListener(this);
		Panel left = new Panel(new GridLayout(0,1));
		for(int i=0;i<10;i++) {
			left.add(new JLabel("" + (i+1) + " letters:"));
		}
		Panel middle = new Panel(new GridLayout(0,1));
		for(int i=0; i<10;i++) {
			progress[i] = new JProgressBar();
			progress[i].setValue(0);
			progress[i].setStringPainted(true);
			middle.add(progress[i]);
		}
		this.addWindowListener(this);
		this.add("West", left);
		this.add("Center", middle);
		this.add("North", scroll);
		this.add("South", goButton);
		this.setSize(500, 350);
		this.setVisible(true);
	}
	
	@Override
	public void windowActivated(WindowEvent arg0) {}
	@Override
	public void windowClosed(WindowEvent arg0) {}
	@Override
	public void windowClosing(WindowEvent arg0) {System.exit(0);}
	@Override
	public void windowDeactivated(WindowEvent arg0) {}
	@Override
	public void windowDeiconified(WindowEvent arg0) {}
	@Override
	public void windowIconified(WindowEvent arg0) {}
	@Override
	public void windowOpened(WindowEvent arg0) {}
	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i=0; i<10; i++) {
			histogram[i] = 0;
		}
		StringTokenizer strToken = new StringTokenizer(this.textArea.getText(), " ");
		int numberTokens = strToken.countTokens();
		while(strToken.hasMoreElements()) {
			int length = strToken.nextToken().length();
			if(length<=10) histogram[length-1]++;
		}
		for(int i=0; i<10; i++) {
			int value = (histogram[i]*100)/numberTokens;
			progress[i].setValue(value);
			progress[i].setString(""+value+"%");
		}
	}
	
	public static void main(String[] args) {
		new StringHistogram(args);
	}
	
}
