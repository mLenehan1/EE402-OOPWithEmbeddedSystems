package EE402Tut4;

import java.util.Arrays;

public class Statistics {

	private double[] array;
	int arrayLength;
	public Statistics(double[] anArray, int arrLength) {
		array = anArray;
		arrayLength = arrLength;
	}
	public void display() {
		System.out.print("Array[ ");
		for(int i=0;i<this.arrayLength;i++) {
			System.out.print(this.array[i] + " ");
		}
		System.out.println("]");
	}
	public double average() {
		double count = 0;
		for(int i=0;i<this.arrayLength;i++) {count+=this.array[i];}
		return count/this.arrayLength;
	}
	public double min() {
		double minVal = this.array[0];
		for(int i=1;i<this.arrayLength;i++) {
			if(this.array[i]<minVal) {minVal = this.array[i];}
		}
		return minVal;
	}
	public double max() {
		double maxVal = this.array[0];
		for(int i=1;i<this.arrayLength;i++) {
			if(this.array[i]>maxVal) {maxVal = this.array[i];}
		}
		return maxVal;
	}
	public double[] sort() {
		double[] sorted = Arrays.sort(array);
	}
	public double median() {
		if(this.arrayLength%2 ==0) {
			return (this.array[(this.arrayLength/2)-1]+this.array[this.arrayLength/2])/2;
		}
		else return this.array[this.arrayLength/2];
	}
}
