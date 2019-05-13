package ee4022016rq5;

import java.io.Serializable;
import java.util.Vector;
import java.util.Arrays;

public class Temperature implements Serializable {

	private static final long serialVersionUID = 1L;
	String name;
	Vector<Float> readings;
	
	public Temperature(String name) {
		readings = new Vector<Float>(10);
		this.name = name;
	}
	
	public int getSize() {return readings.size();}
	
	public Temperature(String name, float[] readings) {
		this(name);
		for(int i=0;i<readings.length;i++) {
			this.readings.add(new Float(readings[i]));
		}
	}
	
	public void addReading(float reading) {
		readings.add(new Float(reading));
	}
	
	public float getMedian() {
		Float[] values = readings.toArray((new Float[readings.size()]));
		Arrays.sort(values);
		return values[(readings.size()/2)-1].floatValue();
	}
	
	public float getMax() {
		float max = Float.MIN_VALUE;
		for(Float i:readings) {
			if(i.floatValue()>max) max=i.floatValue();
		}
		return max;
	}
	
	public float getMin() {
		float min = Float.MAX_VALUE;
		for(Float i:readings) {
			if(i.floatValue()<min) min=i.floatValue();
		}
		return min;
	}
	
	public float getAverage() {
		float sum = 0;
		for(Float i:readings) sum+=i.floatValue();
		return sum/readings.size();
	}
	
	public void check(float threshold) {
		for(Float i:readings) {
			if(i.floatValue()>=threshold) System.out.println("Value " + i + " exceeds the threshold");
		}
	}
	
	public void display() {
		System.out.println("The sensor " + name + " has values: ");
		for(Float i:readings) System.out.println(" " + i.toString());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
