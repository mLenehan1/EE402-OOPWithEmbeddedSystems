package ee4022018q4;

import ee4022018q4.CounterTimer;

public class TimeThread extends Thread {

	private boolean running = true;
	private CounterTimer owner;
	
	public TimeThread(CounterTimer owner) {
		this.owner = owner;
	}
	
	public void run() {
		while(running) {
			owner.updateTime();
			try {
				Thread.sleep(1000);
			}
			catch(InterruptedException e) {
				System.out.println(e.toString());
			}
		}
	}
}
