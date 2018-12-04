import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Structure> inputs = new ArrayList<Structure>();
	    while (!sc.hasNext("0")){
	        String str = sc.nextLine();
	        Structure s = new Structure();
            String[] str_arr = str.split(",");

            // first name
            s.setFirstName(str_arr[0]);
            // last name
            s.setLastName(str_arr[1]);
            // annual Salary - assume the input is valid, otherwise, should catch the exception
            s.setAnnualSalary(Float.parseFloat(str_arr[2]));
            // super rate - assume the input is valid, otherwise, should catch the exception
            String superRate_str = str_arr[3].split("%")[0];
            s.setSuperRate(Float.parseFloat(superRate_str));
            // start date
            s.setPaymentStartDate(str_arr[4]);

            inputs.add(s);
        }

	    for (Structure s: inputs){
	        // generate full name
	        s.set_fullName(s.getFirstName() + " " + s.getLastName());
	        // generate pay period
	        s.set_payPeriod(s.getPaymentStartDate());
	        // calculate gross income
	        s.set_grossIncome( (int) s.getAnnualSalary() / 12 );
            // calculate income tax
            s.set_incomeTax( calculate_income_tax(s.getAnnualSalary()) );
            // calculate net income
            s.set_netIncome( s.get_grossIncome() - s.get_incomeTax() );
            // calculate super
            s.set_super( (int) (s.get_grossIncome() * s.getSuperRate() / 100) );

            System.out.println(s.get_fullName()+ "," + s.get_payPeriod() + "," + s.get_grossIncome() + ","
                    + s.get_incomeTax() + "," + s.get_netIncome() + "," + s.get_super());
        }
    }

    private static int calculate_income_tax(float income){
        if (income >= 0) {
            if (income <= 18200)
                return 0;
            else if (income <= 37000)
                return (int) Math.round( ((income - 18200) * 0.19) / 12 );
            else if (income <= 87000)
                return (int) Math.round( ((3572 + (income - 37000) * 0.325)) / 12 );
            else if (income <= 180000)
                return (int) Math.round( ((19822 + (income - 87000) * 0.37)) / 12 );
            else
                return (int) Math.round( ((54232 + (income - 180000) * 0.45)) / 12 );
        }
        else{
            System.out.println("[ERROR] - Annual Salary should be a positive number.");
            return -1;
        }
    }

}
