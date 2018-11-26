package ee402Tutorial5;

public class Student {
	private String name, mfFlag, address, id, phone;
	
	public Student(String aName, String anMFFlag, String anAddress, String anID, String aPhone){
		name = aName;
		mfFlag = anMFFlag;
		address = anAddress;
		id = anID;
		phone = aPhone;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getMFFlag() {
		return this.mfFlag;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	public String getID() {
		return this.id;
	}
	
	public String getPhone() {
		return this.phone;
	}
}
