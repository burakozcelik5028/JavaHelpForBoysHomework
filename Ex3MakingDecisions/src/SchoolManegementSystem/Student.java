package SchoolManegementSystem;

/**
 * Created By Erdem BeÅŸtaÅŸ
 * tution, name, id,tutionPaid, grade
 */
public class Student extends User implements TuitionCalculator {
	
    private float grade;
    private int paidTotalAmount;
    private double feesTotal;

    public Student(){}

    public void setGrade(float grade) {
        this.grade = grade;
    }

    @Override
    public int calculateTuition(int paidAmount) {
        if (paidAmount <= 0) {
            System.out.println("Negatif Ödeme yapılamaz!");
        }

        if (isProperPayment(paidAmount)) {
            return paidTotalAmount += paidAmount;
        }
        return paidTotalAmount;
    }


    private boolean isProperPayment(int paidAmount) {
        if (feesTotal - paidAmount < 0) {
            System.out.println("Okul ücretinde fazla Ödeme yapılamaz. Tekrar deneyiniz. Öğrenci isim: " + this.name);
            return false;
        }
        return true;
    }

    public float getGrade() {
        return grade;
    }

    public int getPaidTotalAmount() {
        return paidTotalAmount;
    }

    public double getFeesTotal() {
        return feesTotal;
    }

    public double getRemainingFees() {
        return feesTotal - paidTotalAmount;
    }

    @Override
    public String toString() {
        return "Student's NAME: " + id + ". " + name + " || TOTAL FEES PAID: $" + (feesTotal - paidTotalAmount) + " || REMAINS: $" + getRemainingFees();
    }

}