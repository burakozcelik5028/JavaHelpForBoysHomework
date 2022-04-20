package SchoolManegementSystem;

/**
 * Created By Erdem BeÅŸtaÅŸ
 * tution, name, id,tutionPaid, grade
 */
public class Student extends User implements TuitionCalculator {

	private int feesTotal;
    private float grade;
    private int paidTotalAmount;
	private int remainigAmount;
    
    public void setPaidTotalAmount(int payment) {
		this.paidTotalAmount = paidTotalAmount + payment;
	}
    
    public int getRemainigAmount() {
		return remainigAmount;
	}

	public void setRemainigAmount() {
		this.remainigAmount = feesTotal-paidTotalAmount;
	}

    public Student() {
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }
    
    public void setFeesTotal(int feesTotal) {
        this.feesTotal = feesTotal;
    }

    @Override
    public int calculateTuition(int paidAmount) {
        if (paidAmount <= 0) {
            System.out.println("Negatif Ödeme yapılamaz!");
        }

        if (isProperPayment(paidAmount)) {
        	System.out.println("üüüüüüüüüüüüüüüüüüüüüüüüüüüü");
        	setPaidTotalAmount(paidAmount);
        	setRemainigAmount();
        	System.out.println("feeTotal " + feesTotal);
        	System.out.println("paidAmount " + paidAmount);
        	System.out.println("paidTotalAmount " + paidTotalAmount);
        	System.out.println("remainingamount " + remainigAmount);
            return paidTotalAmount;
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

    public int getFeesTotal() {
        return feesTotal;
    }

    @Override
    public String toString() {
        return "Student's NAME: " + id + ". " + name + " || TOTAL FEES PAID: $" + getPaidTotalAmount() + " || REMAINS: $" + getRemainigAmount();
    }

}