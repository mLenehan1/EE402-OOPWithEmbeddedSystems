package ee4022018q4;

public class TimerThread extends Thread {
	
	private boolean running = true;
	private int numSeconds = 0, elapsed = 0;
	private CounterTimer owner;
	
	public TimerThread(CounterTimer owner, int numSeconds) {
		this.numSeconds = numSeconds;
		this.owner = owner;
	}
	
	public void stopTimer() {
		this.running = false;
		owner.setStatus(0.0f);
	}
	
	public void run() {
		while(running) {
			elapsed++;
			owner.setStatus((float)elapsed/(float)numSeconds);
			try {
				Thread.sleep(1000);
			}
			catch(InterruptedException e) {
				System.out.println(e.toString());
			}
			if(elapsed>=numSeconds) {
				running = false;
				owner.alarm();
			}
		}
	}

}
