package ee402Tutorial5;

import java.util.Vector;

public class Programme {
	private String title;
	private int year, calYear;
	Vector<Student> students;
	
	public Programme(String aTitle, int aYear, int aCalYear, Vector<Student> someStudents) {
		title = aTitle;
		year = aYear;
		calYear = aCalYear;
		students = someStudents;
	}
	
	public static void main(String[] args) {
		Student[] studArray = new Student[5];
		studArray[0] = new Student("Michael", "Male", "A12B12", "123456", "087123456");
		studArray[1] = new Student("Mark", "Male", "A12B13", "123457", "087123457");
		studArray[2] = new Student("Ciaran", "Male", "A12B14", "123458", "087123458");
		studArray[3] = new Student("Sarah", "Female", "A12B15", "123459", "087123459");
		studArray[4] = new Student("Conor", "Male", "A12B16", "123460", "087123460");
		Vector<Student> studVector = new Vector<Student>();
		for(int i=0;i<studArray.length; i++) {
			studVector.add(studArray[i]);
		}
		Programme programmeList = new Programme("ECE", 4, 2018, studVector);
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public String getYear() {
		return ((Integer)this.year).toString();
	}
	
	public String getCalYear() {
		return ((Integer)this.calYear).toString();
	}
}
