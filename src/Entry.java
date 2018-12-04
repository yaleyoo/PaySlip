public class Entry {
    // inputs
    private String firstName;
    private String lastName;
    private float annualSalary;
    private float superRate;
    private String paymentStartDate;

    // results
    private String _fullName;
    private String _payPeriod;
    private int _grossIncome;
    private int _incomeTax;
    private int _netIncome;
    private int _super;

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

    String get_payPeriod() {
        if (this._payPeriod == null)
            this._payPeriod = this.paymentStartDate;
        return this._payPeriod;
    }

    int get_grossIncome() {
        if (this._grossIncome == 0)
            this._grossIncome = (int) this.annualSalary / 12;
        return this._grossIncome;
    }

    int get_incomeTax() {
        if (this._incomeTax == 0)
            this._incomeTax = calculate_income_tax();
        return _incomeTax;
    }

    int get_netIncome() {
        if (this._netIncome == 0)
            this._netIncome = this._grossIncome - this._incomeTax;
        return _netIncome;
    }

    int get_super() {
        if (this._super == 0)
            this._super = (int) (this._grossIncome * this.superRate / 100);
        return _super;
    }

    String get_fullName() {
        if (this._fullName == null)
            this._fullName = this.firstName + " " + this.lastName;
        return this._fullName;
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
        return this.get_fullName()+ "," + this.get_payPeriod() + "," + this.get_grossIncome() + ","
                + this.get_incomeTax() + "," + this.get_netIncome() + "," + this.get_super();
    }
}