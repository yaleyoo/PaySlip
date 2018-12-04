public class Structure{
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public float getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualSalary(float annualSalary) {
        this.annualSalary = annualSalary;
    }

    public float getSuperRate() {
        return superRate;
    }

    public void setSuperRate(float superRate) {
        this.superRate = superRate;
    }

    public String getPaymentStartDate() {
        return paymentStartDate;
    }

    public void setPaymentStartDate(String paymentStartDate) {
        this.paymentStartDate = paymentStartDate;
    }

    public String get_payPeriod() {
        return _payPeriod;
    }

    public void set_payPeriod(String _payPeriod) {
        this._payPeriod = _payPeriod;
    }

    public int get_grossIncome() {
        return _grossIncome;
    }

    public void set_grossIncome(int _grossIncome) {
        this._grossIncome = _grossIncome;
    }

    public int get_incomeTax() {
        return _incomeTax;
    }

    public void set_incomeTax(int _incomeTax) {
        this._incomeTax = _incomeTax;
    }

    public int get_netIncome() {
        return _netIncome;
    }

    public void set_netIncome(int _netIncome) {
        this._netIncome = _netIncome;
    }

    public int get_super() {
        return _super;
    }

    public void set_super(int _super) {
        this._super = _super;
    }

    public String get_fullName() {
        return _fullName;
    }

    public void set_fullName(String _fullName) {
        this._fullName = _fullName;
    }
}