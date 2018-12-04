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

    Entry(String[] str_arr) throws Exception{
        if (str_arr.length != 5)
            throw new IndexOutOfBoundsException();
        // first name
        this.firstName = str_arr[0].trim();
        // last name
        this.lastName = str_arr[1].trim();
        // annual Salary - assume the input is valid, otherwise, should catch the exception
        this.annualSalary = Float.parseFloat(str_arr[2].trim());
        // super rate - assume the input is valid, otherwise, should catch the exception
        String superRate_str = str_arr[3].split("%")[0];
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
            this.netIncome = this.grossIncome - this.incomeTax;
        return this.netIncome;
    }

    int getSuper() {
        if (this.superIncome == 0)
            this.superIncome = (int) (this.grossIncome * this.superRate / 100);
        return this.superIncome;
    }

    String getFullName() {
        if (this.fullName == null)
            this.fullName = this.firstName + " " + this.lastName;
        return this.fullName;
    }

    private int calculate_income_tax(){
        if (this.annualSalary >= 0) {
            if (this.annualSalary <= 18200)
                return 0;
            else if (this.annualSalary <= 37000)
                return (int) Math.round( ((this.annualSalary - 18200) * 0.19) / 12 );
            else if (this.annualSalary <= 87000)
                return (int) Math.round( ((3572 + (this.annualSalary - 37000) * 0.325)) / 12 );
            else if (this.annualSalary <= 180000)
                return (int) Math.round( ((19822 + (this.annualSalary - 87000) * 0.37)) / 12 );
            else
                return (int) Math.round( ((54232 + (this.annualSalary - 180000) * 0.45)) / 12 );
        }
        else{
            return -1;
        }
    }

    String serialize(){
        return this.getFullName()+ "," + this.getPayPeriod() + "," + this.getGrossIncome() + ","
                + this.getIncomeTax() + "," + this.getNetIncome() + "," + this.getSuper();
    }
}