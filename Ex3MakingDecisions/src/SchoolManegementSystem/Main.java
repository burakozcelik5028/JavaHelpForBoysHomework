package SchoolManegementSystem;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
    	
        Teacher metin = new Teacher();
        metin.setName("Muhammet Metin Molak");
        metin.setSalary(11350);
        
        Teacher erdem = new Teacher();
        erdem.setName("Erdem Bestas");
        erdem.setSalary(11250);
        
        Teacher taha = new Teacher();
        taha.setName("Mustafa Taha Kabar");
        taha.setSalary(10900);
                
        List<Teacher> teacherList = new ArrayList<>();
        teacherList.add(metin);
        teacherList.add(erdem);
        teacherList.add(taha);

        Student sertan = new Student();
        sertan.setName("Sertan Aygun");
        sertan.setGrade(67);
        sertan.setFeesTotal(1000);
        
        Student oguz = new Student();
        oguz.setName("Oguzhan Karatas");
        oguz.setGrade(22);
        oguz.setFeesTotal(800);
        
        Student cihan = new Student();
        cihan.setName("Cihan Turan");
        cihan.setGrade(32);
        cihan.setFeesTotal(600);
        
        List<Student> studentList = new ArrayList<>();
        studentList.add(sertan);
        studentList.add(oguz);
        studentList.add(cihan);

        School marmaraUniversity = new School(teacherList, studentList);

        oguz.calculateTuition(300);
        
        cihan.calculateTuition(80);
        cihan.print("Ödeme Başarılı!");
        
        sertan.calculateTuition(20);
        sertan.print("Ödemeniz Gerçekleştirildi. ");

        marmaraUniversity.showTotalGain();


        metin.receiveSalary(metin.getSalary());
        //  System.out.println("MARMARA UNIVERSITY SPENT SALARY TO: " + metin.getName()+" || REMAINING MONEY IS: $"+ MarmaraUniversity.getTotalMoneyEarned());

        erdem.receiveSalary(erdem.getSalary());
        //  System.out.println("MARMARA UNIVERSITY SPENT SALARY TO: " + erdem.getName()+" || REMAINING MONEY IS: $"+ MarmaraUniversity.getTotalMoneyEarned());

        System.out.println("-------------------------------------------------------------");
        sertan.print();

        System.out.println(sertan);

        oguz.print();
        System.out.println(oguz);

        cihan.print();
        System.out.println(cihan);

        System.out.println("--------------------------------------------------------------");
        System.out.println(metin);
        System.out.println(erdem);
        System.out.println(taha);
    }
}
