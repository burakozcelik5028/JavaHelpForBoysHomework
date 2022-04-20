package SchoolManegementSystem;


/** Created By Erdem Beştaş
 *id,name,salary
 */
public class Teacher extends User {

    private int salary;
    private int salaryEarned;

    public Teacher(int salary, String name){
        this.salary=salary;
        super.name= name;
        this.salaryEarned = 0;
    }

    public int getSalary(){
        return salary;
    };
    public  int getId(){
        return id;
    };

    public void setSalary(int salary){
        this.salary= salary;
    }

    public void receiveSalary(int salary){
        salaryEarned += salary;
    }

    @Override
    public String toString() {
        return "TEACHER'S NAME: "+id+". "+name+" || TOTAL SALARY EARNED: $"+ salaryEarned;
    }
}
