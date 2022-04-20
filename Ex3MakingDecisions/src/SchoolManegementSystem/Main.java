package SchoolManegementSystem;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;  

public class Main {

    public static void main(String[] args) {
    	School marmaraUniversity = new School();

		List<Teacher> teacherList = createTeacher();
		for (Teacher teacher : teacherList) {
			System.out.println(teacher);
		}
		
        List<Student> studentList = createStudent();
        for (Student student : studentList) {
			student.print();
			System.out.println(student);
			System.out.println();
		}
        
        boolean flag = true;
        for(;flag;) {
        	@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
        	
        	System.out.println();
        	System.out.println("Please Choose One of the Options: ");
        	System.out.println("1- Create Teacher");
        	System.out.println("2- Create Student");
        	System.out.println("3- Cloose Program(any input except 1 and 2 will cloose the program!)");
        	
        	try {
				int input = sc.nextInt();
				if (input == 1) {
					List<Teacher> newteacherList = createTeacher();
					
					for (Teacher teacher : newteacherList) {
						teacherList.add(teacher);
					}
					
					for (Teacher teacher : teacherList) {
						System.out.println(teacher);
					}
					
				} else if(input == 2) {
					List<Student> newStudentList = createStudent();
					
					for (Student student : newStudentList) {
						studentList.add(student);
					}
					
					for (Student student : studentList) {
						student.print();
						System.out.println(student);
						System.out.println();
					}
				} else {
					System.out.print("If you really want to quit please type true, if you want to continue please type false: ");
					try {
						boolean inputQ = sc.nextBoolean();
						if(inputQ) {
							flag = false;
						}
					} catch (Exception e) {
						sc.nextLine();
					}
					
				}
			} catch (InputMismatchException e) {
				sc.nextLine();
				// TODO: handle exception
			}
        }

        marmaraUniversity.setStudents(studentList);
        marmaraUniversity.setTeachers(teacherList);

        marmaraUniversity.showTotalGain();
        
        writeFile(marmaraUniversity);
    }
    
    public static ArrayList<Teacher> createTeacher(){
    	ArrayList<Teacher> teacherList = new ArrayList<Teacher>();
    	boolean logout = true;
    	@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
    	
    	for(;logout;) {
    		System.out.println();
    		System.out.print("Please type a name to create teacher: ");
    		String name = sc.nextLine();
    		
    		System.out.print("Please type how much salary that teacher has: ");
    		double salary = 0;
    		try {
				salary = sc.nextDouble();
				sc.nextLine();
			} catch (InputMismatchException e) {
				sc.nextLine();
				System.out.print("Please type integer value: ");
				salary = sc.nextDouble();
				sc.nextLine();
			}
    		
    		
    		Teacher newTeacher = new Teacher();
    		newTeacher.setName(name);
    		newTeacher.setSalary(salary);
    		
    		teacherList.add(newTeacher);
    		
    		System.out.println("Which operation do you want to do next?");
    		System.out.println("1- Create new teacher.");
    		System.out.println("2- Give salary to teacher " + newTeacher.getName());
    		System.out.println("3- Create new student. ");
    		System.out.print("Pleae type number of step you want to continue(if your input is different than given options, you will continue from step 3): ");
    		try {
    			int continueNumber = sc.nextInt();
    			if (continueNumber == 1) {
    				sc.nextLine();
				} else if(continueNumber == 2) {
					newTeacher.receiveSalary(newTeacher.getSalary());
					sc.nextLine();
				} else {
					logout = false;
					sc.nextLine();
				}
			} catch (InputMismatchException e) {
				logout = false;
			}
    		System.out.println("");
    	}
    	return teacherList;
    	
    }
    
    public static ArrayList<Student> createStudent(){
    	
    	ArrayList<Student> studentList = new ArrayList<Student>();
    	boolean logout = true;
    	@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
    	
    	for(;logout;) {
    		System.out.println();
    		System.out.print("Please type a name to create new student: ");
    		String name = sc.nextLine();
    		    		
    		System.out.print("Please type grade of student " + name +": ");
    		float grade = 0;
    		try {
    			grade = sc.nextFloat();
    			sc.nextLine();
			} catch (InputMismatchException e) {
				sc.nextLine();
				System.out.print("Please write a proper value for grade: ");
				grade = sc.nextFloat();
				sc.nextLine();
			}
    		
    		System.out.print("Please write total Fee for student " + name + ": ");
    		int totalFee = 0;
    		try {
				totalFee = sc.nextInt();
				sc.nextLine();
			} catch (InputMismatchException e) {
				sc.nextLine();
				System.out.print("Please write a proper int value for fee: ");
				totalFee = sc.nextInt();
				sc.nextLine();
			}
    		
    		Student newStudent = new Student();
    		newStudent.setName(name);
    		newStudent.setFeesTotal(totalFee);
    		newStudent.setGrade(grade);
    		newStudent.setRemainigAmount();
    		
    		studentList.add(newStudent);
    		
    		System.out.println("Which operation do you want to do next?");
    		System.out.println("1- Create new student.");
    		System.out.println("2- Pay fee for student " + newStudent.getName());
    		System.out.println("3- Exit. ");
    		System.out.print("Pleae type number of step you want to continue(if your input is different than given options, you will continue from step 3): ");
    		try {
    			int continueNumber = sc.nextInt();
    			if (continueNumber == 1) {
    				sc.nextLine();
				} else if(continueNumber == 2) {
					System.out.println("Please type how much money do you want to pay(You can pay min:$1 max:$"+newStudent.getRemainigAmount()+"): ");
					try {
						int payment = sc.nextInt();
						newStudent.calculateTuition(payment);
						sc.nextLine();
					} catch (InputMismatchException e) {
						sc.nextLine();
						System.out.println("Please type proper input! How much money do you want to pay(You can pay min:$1 max:$"+newStudent.getRemainigAmount()+"): ");
						int payment = sc.nextInt();
						newStudent.calculateTuition(payment);
						sc.nextLine();
					}
					
				} else {
					logout = false;
					sc.nextLine();
				}
			} catch (InputMismatchException e) {
				logout = false;
			}
    		System.out.println("");
    	}
    	
		return studentList;
    	
    }
    
    public static void writeFile(School school) {
    	try {
    	      File myObj = new File("filename.txt");
    	      FileWriter myWriter = new FileWriter("filename.txt");

	    	  myWriter.write("-------------Teachers Info------------- \n");
    	      for (Teacher teacher : school.getTeachers()) {
    	    	  myWriter.write(teacher.toString()+"\n");    	    	  
    	      }
    	      
    	      myWriter.write("\n");

	    	  myWriter.write("-------------Students Info------------- \n");
    	      for (Student student : school.getStudents()) {
    	    	  myWriter.write(student.toString()+"\n");
    	      }
    	      
    	      myWriter.write("\n");
	    	  myWriter.write("-------------University Info------------- \n");
	    	  myWriter.write(school.showTotalGain());
	    	  
    	      myWriter.close();
    	      if (myObj.createNewFile()) {
    	        System.out.println("File created: " + myObj.getName());
    	      } else {
    	        System.out.println("File already exists.");
    	      }
    	    } catch (Exception e) {
    	      System.out.println("An error occurred.");
    	      e.printStackTrace();
    	    }
    }
}
