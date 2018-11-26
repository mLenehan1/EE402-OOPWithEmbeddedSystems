package EE402Tut4;
import EE402Tut4.Names;
import EE402Tut4.Statistics;
import java.lang.*;

public class Application {

	static int count = 0;

	public static String firstTwo(String inString) {
		try {
			return new String(inString.substring(0, 2));
		}
		catch(StringIndexOutOfBoundsException e) {
			return new String("");
		}
	}
	
	public static boolean badString(String inString) {
		String matchString = new String("bad");
		if(matchString.regionMatches(0, inString, 0, 3)==true || matchString.regionMatches(0, inString, 1, 3)==true){
			return true;
		}
		else return false;		
	}
	
	public static String nTwice(String inString, int n) {
		return new String(inString.substring(0, n)+inString.substring(inString.length()-n, inString.length()));
	}
	
	public static int countX(String inString) {
		if(inString.charAt(0)=='x') {
			count++;
		}
		if(inString.substring(1, inString.length()).length()!=0) {
			inString = inString.substring(1, inString.length());
			countX(inString);
		}
		return count;
	}
	
	public static int[] lotteryNumbers() {
		int[] numbers = new int[7];
		for(int i=0;i<numbers.length-2;i++) {numbers[i] = (int)(Math.random()*50)+1;}
		for(int i=numbers.length-2;i<numbers.length;i++) {numbers[i] = (int)(Math.random()*11)+1;}
		return numbers;
	}
	
	public static Integer multiplyCMD(String[] vals) {
		try {
			int int1 = Integer.valueOf(vals[0]).intValue();
			int int2 = Integer.valueOf(vals[1]).intValue();
			return new Integer(int1*int2);
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Invalid Number of Numbers");
			return new Integer(0);
		}
	}
	
	public static void main(String[] args) {
		
		Names nameList[] = new Names[5];
		nameList[0] = new Names("Teresa Green");
		nameList[1] = new Names("Rick O'Shea");
		nameList[2] = new Names("Robin Banks");
		nameList[3] = new Names("Barry Cade");
		nameList[4] = new Names("Sam Pull");
		
		for(int i=0;i<nameList.length;i++){ nameList[i].display();}
		
		System.out.println(firstTwo(""));
		System.out.println(badString("xbadx"));
		System.out.println(badString("xxbadx"));
		System.out.println(badString(""));
		System.out.println(nTwice("Chocolate", 1));
		System.out.println(countX("xxtestingxx"));
		System.out.println("EoP");
		int[] lottoNumbers = lotteryNumbers();
		for(int i=0;i<lottoNumbers.length;i++) {
			System.out.println(lottoNumbers[i]);
		}
		System.out.println("Multiplied Value: " + multiplyCMD(args));
		
		double[] anArray = {1,2,3,4,5,6,7,8};
		Statistics testStat = new Statistics(anArray, anArray.length);
		testStat.display();
		System.out.println(testStat.average());
		System.out.println(testStat.min());
		System.out.println(testStat.max());
		System.out.println(testStat.median());
	}

}
