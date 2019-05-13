/* The Server Gui Class - Created by Michael Lenehan for EE402 Assignment 2 (Dec 2018)
 * 
 */

package ee402;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;

public class ServerGui extends JFrame implements Runnable{

	private volatile int status = 1;
	private JFrame frame;
	private JPanel selectPanel, mainPanel;
	private JTextField textField;
	private ArrayList<TempService> temps;
	private GraphPanel graphPanel;
	
	//Class to Draw Graph Axis
	public class GraphPanel extends JComponent{
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private ArrayList<TempService> inTemps;
		private Double x1, x2, y1, y2;
		
		GraphPanel(ArrayList<TempService> temps){
			System.out.println("BP1");
			if(temps.isEmpty()) {
				this.inTemps = new ArrayList<TempService>();
				System.out.println("Empty");
			}
			else {
				this.inTemps = temps;
				System.out.println("List Available");
				System.out.println(this.inTemps);
			}
		}
		
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;
			g2.draw(new Line2D.Double(50, 400, 50, 100));
			g2.draw(new Line2D.Double(50,  400,  400,  400));
			System.out.println(this.inTemps.size());
			System.out.println("BP3");
			if(temps.size()==1 || temps.isEmpty()) {System.out.println("BP4");}
			else {
				System.out.println("BP5");
				for(int i = 0; i<temps.size()-1; i++) {
					y1 = (double) Integer.parseInt(temps.get(i).getTemp());
					y2 = (double) Integer.parseInt(temps.get(i+1).getTemp());
					x1 = (double) Integer.parseInt(temps.get(i).getTime());
					x2 = (double) Integer.parseInt(temps.get(i+1).getTime());
					System.out.println("Time1 " + x1);
					System.out.println("Time2 " + x2);
					System.out.println("Temp1 " + y1);
					System.out.println("Temp2 " + y2);
					g2.draw(new Line2D.Double(x1/1000, y1/1000, x2/1000, y2/1000));
				}
			}
		}
	}
	
	public ServerGui() {
		update(1, new ArrayList<TempService>(20));
	}
	
	/*public static void main(String[] args) throws InterruptedException {
		ServerGui test = new ServerGui();
		Thread.sleep(10000);
	}*/

	@Override
	public void run() {
		switch(status) {
		case 1:
			this.mainPanel = new JPanel();
			graphPanel = new GraphPanel(new ArrayList<TempService>());
			textField = new JTextField("Enter Sampling Frequency");
			mainPanel.setLayout(new BorderLayout());
			mainPanel.add(textField, BorderLayout.NORTH);
			mainPanel.add(graphPanel, BorderLayout.CENTER);
			frame = new JFrame("Temperature App");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.add(mainPanel);
			frame.pack();
			frame.setLocationRelativeTo(null);
			frame.setSize(450, 450);	
			frame.setVisible(true);
			break;
		case 2:
			System.out.println("Update");
			System.out.println(this.temps);
			graphPanel = new GraphPanel(this.temps);
			mainPanel.add(graphPanel);
			frame.repaint();
			break;
		}	
	}
	
	public void update(int status, ArrayList<TempService> temps) {
		setStatus(status, temps);
		SwingUtilities.invokeLater(this);
	}
	
	private synchronized void setStatus(int status, ArrayList<TempService> setTemps) {
		this.status = status;
		this.temps = setTemps;
		//System.out.println(this.temps);
	}
}
