
public class metal {
	public static int makePackage(int small, int big, int goal) {
		int reqbig = goal/5;
		System.out.println(goal%big);
		if(big > reqbig) {
			return (goal<=5*reqbig + small) ? (goal - 5*reqbig): -1;
		}
		else return (goal<=5*big + small) ? (goal - 5*big) : -1;
	}
	
	public static void main(String args[]) {
		int s1,s2, s3, b1, b2, g1, g2, g3;
		s1=4; s2 = 6; s3 = 1;
		b1 = 1; b2 = 2;
		g1 = 9; g2 = 10; g3 = 7;
		System.out.println("makePackage("+s1+" ,"+b1+" "+" ,"+g1+") -> " + makePackage(s1, b1, g1));
		System.out.println("makePackage("+s1+" ,"+b1+" "+" ,"+g2+") -> " + makePackage(s1, b1, g2));
		System.out.println("makePackage("+s2+" ,"+b2+" "+" ,"+g2+") -> " + makePackage(s2, b2, g2));
		System.out.println("makePackage("+s3+" ,"+b2+" "+" ,"+g3+") -> " + makePackage(s3, b2, g3));
		System.out.println("makePackage("+s2+" ,"+b2+" "+" ,"+g3+") -> " + makePackage(s2, b2, g3));
	}
}
