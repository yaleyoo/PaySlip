import java.security.InvalidParameterException;

public class Entry {
    // inputs
    private String firstName;
    private String lastName;
    private float annualSalary;
    private float superRate;
    private String paymentStartDate;

    // results
    private String fullName;
    private String payPeriod;
    private int grossIncome;
    private int incomeTax;
    private int netIncome;
    private int superIncome;

    Entry(String[] str_arr) throws IndexOutOfBoundsException, NumberFormatException, InvalidParameterException{
        if (str_arr.length != 5)
            throw new IndexOutOfBoundsException();
        // first name
        this.firstName = str_arr[0].trim();
        // last name
        this.lastName = str_arr[1].trim();
        // annual Salary
        this.annualSalary = Float.parseFloat(str_arr[2].trim());
        // super rate
        String[] super_arr = str_arr[3].split("%");
        if (!str_arr[3].matches("^-*[0-9]+%$"))
            throw new InvalidParameterException("invalid argument super");
        String superRate_str = super_arr[0];
        this.superRate = Float.parseFloat(superRate_str.trim());
        // start date
        this.paymentStartDate = str_arr[4].trim();
    }

    float getAnnualSalary() {
        return annualSalary;
    }

    float getSuperRate() {
        return superRate;
    }

    String getPaymentStartDate() {
        return paymentStartDate;
    }

    String getPayPeriod() {
        if (this.payPeriod == null)
            this.payPeriod = this.paymentStartDate;
        return this.payPeriod;
    }

    int getGrossIncome() {
        if (this.grossIncome == 0)
            this.grossIncome = (int) this.annualSalary / 12;
        return this.grossIncome;
    }

    int getIncomeTax() {
        if (this.incomeTax == 0)
            this.incomeTax = calculate_income_tax();
        return this.incomeTax;
    }

    int getNetIncome() {
        if (this.netIncome == 0)
            this.netIncome = getGrossIncome() - getIncomeTax();
        return this.netIncome;
    }

    int getSuper() {
        if (this.superIncome == 0)
            this.superIncome = (int) (getGrossIncome() * this.superRate / 100);
        return this.superIncome;
    }

    String getFullName() {
        if (this.fullName == null)
            this.fullName = this.firstName + " " + this.lastName;
        return this.fullName;
    }

    private int calculate_income_tax(){
        if (this.annualSalary <= 18200)
            return 0;
        else if (this.annualSalary <= 37000)
            return (int) Math.round( ((this.annualSalary - 18200) * 0.19) / 12 );
        else if (this.annualSalary <= 87000)
            return (int) Math.round( ((3572 + (this.annualSalary - 37000) * 0.325)) / 12 );
        else if (this.annualSalary <= 180000)
            return (int) Math.round( ((19822 + (this.annualSalary - 87000) * 0.37)) / 12 );
        else {
            long temp = Math.round(((54232 + (this.annualSalary - 180000) * 0.45)) / 12);
            return Math.toIntExact(temp);
        }
    }

    String serialize(){
        return this.getFullName()+ "," + this.getPayPeriod() + "," + this.getGrossIncome() + ","
                + this.getIncomeTax() + "," + this.getNetIncome() + "," + this.getSuper();
    }
}