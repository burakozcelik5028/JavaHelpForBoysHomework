package SchoolManegementSystem;

import java.util.List;


public class School {

    private List<Teacher> teachers;
	private List<Student> students;

    private CalculatorHelper calculatorHelper = new CalculatorHelper();

    public School() {
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }
    
    public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public String showTotalGain() {
    	String output = "Marmara University earned : $" + calculatorHelper.calculateGain(students);
        System.out.println("Marmara University earned : $" + calculatorHelper.calculateGain(students));
        return output;

    }
}
