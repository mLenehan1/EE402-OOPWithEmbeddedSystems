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
import java.awt.Graphics;
import java.awt.Graphics2D;

public class ServerGui extends JFrame implements Runnable{

	private volatile Status guiStatus =  1;
	private JFrame frame;
	private JPanel graphPanel, selectPanel, mainPanel;
	private JTextField textField;
	private JCheckBox checkBox1, checkBox2;
	
	//Class to Draw Graph Axis
	public class PanelGraphic extends JComponent{
		
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;
			g2.draw(new Line2D.Double(50, 400, 50, 100));
			g2.draw(new Line2D.Double(50,  400,  400,  400));
		}
	}
	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	public ServerGui() {
		this.graphPanel = new JPanel(new BorderLayout());
		this.selectPanel = new JPanel(new BorderLayout());
		selectPanel.setSize(450, 20);
		this.textField = new JTextField("Enter Sampling Rate");
		this.checkBox1 = new JCheckBox("Test1");
		this.checkBox2 = new JCheckBox("Test2");
		selectPanel.add(textField, BorderLayout.NORTH);
		selectPanel.add(checkBox1, BorderLayout.EAST);
		selectPanel.add(checkBox2, BorderLayout.WEST);
		graphPanel.add(new JLabel("Temperature Graph", SwingConstants.LEFT), BorderLayout.PAGE_START);
		graphPanel.add(new PanelGraphic(), BorderLayout.CENTER);
		this.mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(selectPanel, BorderLayout.SOUTH);
		mainPanel.add(graphPanel);
		JFrame frame = new JFrame("Temperature App");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(mainPanel);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setSize(450, 450);	
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new ServerGui();
			}
		});
	}
}
