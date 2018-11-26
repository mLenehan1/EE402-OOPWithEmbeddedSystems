package ee402Tutorial5;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

@SuppressWarnings("serial")
public class StudentRecordBrowser extends Frame implements ActionListener{
	private Label[] browserLabels;
	private TextField[] browserFields;
	private Button[] browserButtons;
	private Programme inputProgramme;
	private int currentStudIndex;
	
	public StudentRecordBrowser(Programme inProgramme) {
		super("DCU Student Record Browser");
		this.setLayout(new GridLayout(0,2));
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		inputProgramme = inProgramme;
		currentStudIndex = 0;
		browserLabels = new Label[9];
		browserFields = new TextField[9];
		browserButtons = new Button[2];
		for(int i=0; i<9; i++) {
			browserLabels[i] = new Label();
			browserFields[i] = new TextField();
			browserFields[i].setEditable(false);
			switch(i){
			case 0: 
				browserLabels[i].setText("Programme Title");
				this.add(browserLabels[i]);
				browserFields[i].setText(inputProgramme.getTitle());
				this.add(browserFields[i]);
				break;
			case 1: 
				browserLabels[i].setText("Year");
				this.add(browserLabels[i]);
				browserFields[i].setText(inputProgramme.getYear());
				this.add(browserFields[i]);
				break;
			case 2: 
				browserLabels[i].setText("Calendar Year");
				this.add(browserLabels[i]);
				browserFields[i].setText(inputProgramme.getCalYear());
				this.add(browserFields[i]);
				break;
			case 3: 
				browserLabels[i].setText("Number Students");
				this.add(browserLabels[i]);
				browserFields[i].setText(((Integer)inputProgramme.students.size()).toString());
				this.add(browserFields[i]);
				break;
			case 4: 
				browserLabels[i].setText("Student Name");
				this.add(browserLabels[i]);
				browserFields[i].setText(inputProgramme.students.elementAt(currentStudIndex).getName());
				this.add(browserFields[i]);
				break;
			case 5: 
				browserLabels[i].setText("Student ID");
				this.add(browserLabels[i]);
				browserFields[i].setText(inputProgramme.students.elementAt(currentStudIndex).getID());
				this.add(browserFields[i]);
				break;
			case 6: 
				browserLabels[i].setText("Telephone");
				this.add(browserLabels[i]);
				browserFields[i].setText(inputProgramme.students.elementAt(currentStudIndex).getPhone());
				this.add(browserFields[i]);
				break;
			case 7: 
				browserLabels[i].setText("Sex");
				this.add(browserLabels[i]);
				browserFields[i].setText(inputProgramme.students.elementAt(currentStudIndex).getMFFlag());
				this.add(browserFields[i]);
				break;
			case 8: 
				browserLabels[i].setText("Address");
				this.add(browserLabels[i]);
				browserFields[i].setText(inputProgramme.students.elementAt(currentStudIndex).getAddress());
				this.add(browserFields[i]);
				break;
			}
		}
		browserButtons[0] = new Button("<");
		browserButtons[0].addActionListener(this);
		this.add(browserButtons[0]);
		browserButtons[1] = new Button(">");
		browserButtons[1].addActionListener(this);
		this.add(browserButtons[1]);
		this.pack();
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent a) {
		if(a.getActionCommand().equals("<")) {
			if(currentStudIndex == 0) {currentStudIndex = inputProgramme.students.size()-1;}
			else currentStudIndex --;
			for(int i=0;i<browserLabels.length; i++){
				switch(i){
				case 0: 
					browserLabels[i].setText("Programme Title");
					this.add(browserLabels[i]);
					browserFields[i].setText(inputProgramme.getTitle());
					this.add(browserFields[i]);
					break;
				case 1: 
					browserLabels[i].setText("Year");
					this.add(browserLabels[i]);
					browserFields[i].setText(inputProgramme.getYear());
					this.add(browserFields[i]);
					break;
				case 2: 
					browserLabels[i].setText("Calendar Year");
					this.add(browserLabels[i]);
					browserFields[i].setText(inputProgramme.getCalYear());
					this.add(browserFields[i]);
					break;
				case 3: 
					browserLabels[i].setText("Number Students");
					this.add(browserLabels[i]);
					browserFields[i].setText(((Integer)inputProgramme.students.size()).toString());
					this.add(browserFields[i]);
					break;
				case 4: 
					browserLabels[i].setText("Student Name");
					this.add(browserLabels[i]);
					browserFields[i].setText(inputProgramme.students.elementAt(currentStudIndex).getName());
					this.add(browserFields[i]);
					break;
				case 5: 
					browserLabels[i].setText("Student ID");
					this.add(browserLabels[i]);
					browserFields[i].setText(inputProgramme.students.elementAt(currentStudIndex).getID());
					this.add(browserFields[i]);
					break;
				case 6: 
					browserLabels[i].setText("Telephone");
					this.add(browserLabels[i]);
					browserFields[i].setText(inputProgramme.students.elementAt(currentStudIndex).getPhone());
					this.add(browserFields[i]);
					break;
				case 7: 
					browserLabels[i].setText("Sex");
					this.add(browserLabels[i]);
					browserFields[i].setText(inputProgramme.students.elementAt(currentStudIndex).getMFFlag());
					this.add(browserFields[i]);
					break;
				case 8: 
					browserLabels[i].setText("Address");
					this.add(browserLabels[i]);
					browserFields[i].setText(inputProgramme.students.elementAt(currentStudIndex).getAddress());
					this.add(browserFields[i]);
					break;
				}
			}
		}else if(a.getActionCommand().equals(">")) {
			if(currentStudIndex == inputProgramme.students.size()-1) {currentStudIndex = 0;}
			else currentStudIndex ++;
			for(int i=0;i<browserLabels.length; i++){
				switch(i){
				case 0: 
					browserLabels[i].setText("Programme Title");
					this.add(browserLabels[i]);
					browserFields[i].setText(inputProgramme.getTitle());
					this.add(browserFields[i]);
					break;
				case 1: 
					browserLabels[i].setText("Year");
					this.add(browserLabels[i]);
					browserFields[i].setText(inputProgramme.getYear());
					this.add(browserFields[i]);
					break;
				case 2: 
					browserLabels[i].setText("Calendar Year");
					this.add(browserLabels[i]);
					browserFields[i].setText(inputProgramme.getCalYear());
					this.add(browserFields[i]);
					break;
				case 3: 
					browserLabels[i].setText("Number Students");
					this.add(browserLabels[i]);
					browserFields[i].setText(((Integer)inputProgramme.students.size()).toString());
					this.add(browserFields[i]);
					break;
				case 4: 
					browserLabels[i].setText("Student Name");
					this.add(browserLabels[i]);
					browserFields[i].setText(inputProgramme.students.elementAt(currentStudIndex).getName());
					this.add(browserFields[i]);
					break;
				case 5: 
					browserLabels[i].setText("Student ID");
					this.add(browserLabels[i]);
					browserFields[i].setText(inputProgramme.students.elementAt(currentStudIndex).getID());
					this.add(browserFields[i]);
					break;
				case 6: 
					browserLabels[i].setText("Telephone");
					this.add(browserLabels[i]);
					browserFields[i].setText(inputProgramme.students.elementAt(currentStudIndex).getPhone());
					this.add(browserFields[i]);
					break;
				case 7: 
					browserLabels[i].setText("Sex");
					this.add(browserLabels[i]);
					browserFields[i].setText(inputProgramme.students.elementAt(currentStudIndex).getMFFlag());
					this.add(browserFields[i]);
					break;
				case 8: 
					browserLabels[i].setText("Address");
					this.add(browserLabels[i]);
					browserFields[i].setText(inputProgramme.students.elementAt(currentStudIndex).getAddress());
					this.add(browserFields[i]);
					break;
				}
			}
		}
	}
	
	public void addDetails() {
		
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
		new StudentRecordBrowser(programmeList);
	}
	
}
