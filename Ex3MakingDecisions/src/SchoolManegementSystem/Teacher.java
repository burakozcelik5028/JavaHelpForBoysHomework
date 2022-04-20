package SchoolManegementSystem;


/** Created By Erdem Beştaş
 *id,name,salary
 */
public class Teacher extends User {

    private double salary;
    private double salaryEarned;

    public Teacher(){
        this.salaryEarned = 0;
    }

    public double getSalary(){
        return salary;
    };
    
    public  int getId(){
        return id;
    };

    public void setSalary(double salary){
        this.salary= salary;
    }

    public void receiveSalary(double salary){
        salaryEarned += salary;
    }

    @Override
    public String toString() {
        return "TEACHER'S NAME With The ID "+ getId() +": "+name+" || TOTAL SALARY EARNED: $"+ salaryEarned;
    }
}
