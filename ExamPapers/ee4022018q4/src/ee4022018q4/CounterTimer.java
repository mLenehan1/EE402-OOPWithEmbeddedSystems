package ee4022018q4;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.time.*;

public class CounterTimer extends JFrame implements ActionListener, WindowListener{
	private static final long serialVersionUID = 1L;
	JButton stopButton, quitButton;
	JLabel currentTime, alarmTime;
	JProgressBar progressBar;
	TimeThread timeThread;
	TimerThread timerThread;
	JComboBox<String> timerChoice;
	LocalTime time, setTime;
	long diffTime;
	
	public CounterTimer() {
		super("EE402 Countdown Timer Q4 2018");
		this.setLayout(new BorderLayout());
		Font f = new Font(new JLabel().getFont().getFontName(), Font.BOLD, 36);
		JPanel controls = new JPanel(new FlowLayout());
		String[] timerChoices = {"None", "10 Seconds", "20 Seconds", "30 Seconds", "1 Minute"};
		controls.add(new JLabel("Choose time:"));
		timerChoice = new JComboBox<String>(timerChoices);
		timerChoice.addActionListener(this);
		controls.add(timerChoice);
		this.getContentPane().add(controls, BorderLayout.NORTH);
		
		JPanel timers = new JPanel(new BorderLayout());
		JPanel timers_center = new JPanel();
		timers_center.setLayout(new BoxLayout(timers_center, BoxLayout.X_AXIS));
		JPanel cur = new JPanel();
		cur.setBorder(new TitledBorder("Current Time"));
		currentTime = new JLabel("00:00:00");
		currentTime.setFont(f);
		cur.add(currentTime);
		JPanel alarm = new JPanel();
		alarm.setBorder(new TitledBorder("Alarm Time"));
		alarmTime = new JLabel("00:00:00");
		alarmTime.setFont(f);
		alarm.add(alarmTime);
		timers_center.add(cur);
		timers_center.add(alarm);
		timers.add(timers_center, BorderLayout.CENTER);
		
		progressBar = new JProgressBar(JProgressBar.HORIZONTAL, 0, 120);
		progressBar.setPreferredSize(new Dimension(400, 30));
		JPanel progress = new JPanel(new BorderLayout());
		progressBar.setStringPainted(true);
		progress.add(progressBar);
		timers.add(progress, BorderLayout.SOUTH);
		
		this.getContentPane().add(timers, BorderLayout.CENTER);
		setTime = LocalTime.MIDNIGHT;
		this.timeThread = new TimeThread(this);
		this.timeThread.start();
		
		this.stopButton = new JButton("Stop");
		this.quitButton = new JButton("Quit");
		this.stopButton.addActionListener(this);
		this.quitButton.addActionListener(this);
		JPanel buttons = new JPanel();
		buttons.setLayout(new FlowLayout());
		buttons.add(stopButton);
		stopButton.setEnabled(false);
		buttons.add(quitButton);
		this.getContentPane().add(buttons, BorderLayout.SOUTH);
		
		this.addWindowListener(this);
		this.pack();
		this.setVisible(true);
		
	}
	
	public void updateTime() {
		LocalTime time = LocalTime.now();
		String timeText = String.format("%02d:%02d:%02d", time.getHour(), time.getMinute(), time.getSecond());
		currentTime.setText(timeText);
		String alarmText = String.format("%02d:%02d:%02d", setTime.getHour(), setTime.getMinute(), setTime.getSecond());
		alarmTime.setText(alarmText);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(this.quitButton)) {
			System.exit(0);
		}
		if(e.getSource().equals(this.stopButton)) {
			this.timerThread.stopTimer();
			this.alarm();
		}
		if(e.getSource().equals(this.timerChoice)) {
			this.stopButton.setEnabled(true);
			int numSeconds = 0;
			if(timerChoice.getSelectedItem().equals("None")) numSeconds = 0;
			else if(timerChoice.getSelectedItem().equals("10 Seconds")) numSeconds = 10;
			else if(timerChoice.getSelectedItem().equals("20 Seconds")) numSeconds = 20;
			else if(timerChoice.getSelectedItem().equals("30 Seconds")) numSeconds = 30;
			else numSeconds = 60;
			if(numSeconds>0) {
				this.setTime = LocalTime.now().plusSeconds(numSeconds);
				this.timerChoice.setEnabled(false);
				this.timerThread = new TimerThread(this, numSeconds);
				this.timerThread.start();
				updateTime();
			}
			
		}
	}
	
	public void setStatus(float done) {
		this.progressBar.setValue((int)(100*done));
	}
	
	public void alarm() {
		this.timerChoice.setEnabled(true);
		this.timerChoice.setSelectedIndex(0);
		JOptionPane.showMessageDialog(this, "Timer Done!", "Alarm", JOptionPane.INFORMATION_MESSAGE);
		this.stopButton.setEnabled(false);
	}
	
	public static void main(String args[]) {
		new CounterTimer();
	}

	@Override
	public void windowActivated(WindowEvent arg0) {		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		System.exit(0);
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {		
	}
}
