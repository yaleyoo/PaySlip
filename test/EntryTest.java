import org.junit.Assert;
import org.junit.Test;

import java.security.InvalidParameterException;

public class EntryTest {
    private String testCase0 = "steve,guo,-1,9%,01 March – 31 March";
    private String testCase1 = "steve,guo,0,9%,01 March – 31 March";
    private String testCase2 = "steve,guo,10,9%,01 March – 31 March";
    private String testCase3 = "steve,guo,18199,9%,01 March – 31 March";
    private String testCase4 = "steve,guo,18200,9%,01 March – 31 March";
    private String testCase5 = "steve,guo,18201,9%,01 March – 31 March";
    private String testCase6 = "steve,guo,36999,9%,01 March – 31 March";
    private String testCase7= "steve,guo,37000,9%,01 March – 31 March";
    private String testCase8 = "steve,guo,37001,9%,01 March – 31 March";
    private String testCase9 = "steve,guo,86999,9%,01 March – 31 March";
    private String testCase10 = "steve,guo,87000,9%,01 March – 31 March";
    private String testCase11 = "steve,guo,87001,9%,01 March – 31 March";
    private String testCase12 = "steve,guo,179999,9%,01 March – 31 March";
    private String testCase13 = "steve,guo,180000,9%,01 March – 31 March";
    private String testCase14 = "steve,guo,180001,9%,01 March – 31 March";
    private String testCase15 = "steve,guo,0x0.000002P-126f,9%,01 March – 31 March";
    private String testCase16 = "steve,guo,0x1.fffffeP+127f,9%,01 March – 31 March";
    private String testCase17 = "steve,guo,afdsddw,9%,01 March – 31 March";
    private String testCase18 = "steve,guo,0,-9%,01 March – 31 March";
    private String testCase19 = "steve,guo,0,900%,01 March – 31 March";
    private String testCase20 = "steve,guo,0,9,01 March – 31 March";
    private String testCase21 = "steve,guo,0,abd,01 March – 31 March";
    private String testCase22 = "steve,guo,0,9%%,01 March – 31 March";
    private static final double DELTA = 1e-15;

    @Test
    public void testPayPeriod(){
        Entry entry = new Entry(testCase2.split(","));
        Assert.assertEquals(entry.getPayPeriod(), "01 March – 31 March");
    }

    @Test
    public void testFullName(){
        Entry entry = new Entry(testCase2.split(","));
        Assert.assertEquals(entry.getFullName(), "steve guo");
    }

    @Test
    public void testIncomeTax0(){
        Entry entry = new Entry(testCase0.split(","));
        Assert.assertEquals(0, entry.getIncomeTax());
    }

    @Test
    public void testIncomeTax1(){
        Entry entry = new Entry(testCase1.split(","));
        Assert.assertEquals(0, entry.getIncomeTax());
    }

    @Test
    public void testIncomeTax2(){
        Entry entry = new Entry(testCase2.split(","));
        Assert.assertEquals(0, entry.getIncomeTax());
    }

    @Test
    public void testIncomeTax3(){
        Entry entry = new Entry(testCase3.split(","));
        Assert.assertEquals(0, entry.getIncomeTax());
    }

    @Test
    public void testIncomeTax4(){
        Entry entry = new Entry(testCase4.split(","));
        Assert.assertEquals(0, entry.getIncomeTax());
    }

    @Test
    public void testIncomeTax5(){
        Entry entry = new Entry(testCase5.split(","));
        Assert.assertEquals(Math.round(0.19/12), entry.getIncomeTax(), DELTA);
    }

    @Test
    public void testIncomeTax6(){
        Entry entry = new Entry(testCase6.split(","));
        Assert.assertEquals(Math.round((36999-18200)*0.19/12), entry.getIncomeTax(), DELTA);
    }

    @Test
    public void testIncomeTax7(){
        Entry entry = new Entry(testCase7.split(","));
        Assert.assertEquals(Math.round((37000-18200)*0.19/12), entry.getIncomeTax(), DELTA);
    }

    @Test
    public void testIncomeTax8(){
        Entry entry = new Entry(testCase8.split(","));
        Assert.assertEquals(Math.round((3572+0.325)/12), entry.getIncomeTax(), DELTA);
    }

    @Test
    public void testIncomeTax9(){
        Entry entry = new Entry(testCase9.split(","));
        Assert.assertEquals(Math.round((3572+(86999-37000)*0.325)/12), entry.getIncomeTax(), DELTA);
    }

    @Test
    public void testIncomeTax10(){
        Entry entry = new Entry(testCase10.split(","));
        Assert.assertEquals(Math.round((3572+(87000-37000)*0.325)/12), entry.getIncomeTax(), DELTA);
    }

    @Test
    public void testIncomeTax11(){
        Entry entry = new Entry(testCase11.split(","));
        Assert.assertEquals(Math.round((19822+0.37)/12), entry.getIncomeTax(), DELTA);
    }

    @Test
    public void testIncomeTax12(){
        Entry entry = new Entry(testCase12.split(","));
        Assert.assertEquals(Math.round((19822+(179999-87000)*0.37)/12), entry.getIncomeTax(), DELTA);
    }

    @Test
    public void testIncomeTax13(){
        Entry entry = new Entry(testCase13.split(","));
        Assert.assertEquals(Math.round((19822+(180000-87000)*0.37)/12), entry.getIncomeTax(), DELTA);
    }

    @Test
    public void testIncomeTax14(){
        Entry entry = new Entry(testCase14.split(","));
        Assert.assertEquals(Math.round((54232+0.45)/12), entry.getIncomeTax(), DELTA);
    }

    @Test
    public void testIncomeTax15(){
        Entry entry = new Entry(testCase15.split(","));
        Assert.assertEquals(0, entry.getIncomeTax(), DELTA);
    }

    @Test (expected = ArithmeticException.class)
    public void testIncomeTax16(){
        Entry entry = new Entry(testCase16.split(","));
        entry.getIncomeTax();
    }

    @Test (expected = NumberFormatException.class)
    public void testIncomeTax17(){
        Entry entry = new Entry(testCase17.split(","));
    }

    @Test
    public void testGrossIncome(){
        Entry entry = new Entry(testCase10.split(","));
        Assert.assertEquals(87000/12, entry.getGrossIncome(), DELTA);
    }

    @Test
    public void testNetIncome(){
        Entry entry = new Entry(testCase10.split(","));
        Assert.assertEquals(87000/12-entry.getIncomeTax(), entry.getNetIncome());
    }

    @Test
    public void testSuper0(){
        Entry entry = new Entry(testCase18.split(","));
        Assert.assertEquals(entry.getGrossIncome()*-0.09, entry.getSuper(), DELTA);
    }

    @Test
    public void testSuper1(){
        Entry entry = new Entry(testCase19.split(","));
        Assert.assertEquals(entry.getGrossIncome()*9, entry.getSuper(), DELTA);
    }

    @Test (expected = InvalidParameterException.class)
    public void testSuper2(){
        Entry entry = new Entry(testCase20.split(","));
    }

    @Test (expected = InvalidParameterException.class)
    public void testSuper3(){
        Entry entry = new Entry(testCase21.split(","));
    }

    @Test (expected = InvalidParameterException.class)
    public void testSuper4(){
        Entry entry = new Entry(testCase22.split(","));
    }

    @Test
    public void testAnnualSalary(){
        Entry entry = new Entry(testCase1.split(","));
        Assert.assertEquals(0, entry.getAnnualSalary(), DELTA);
    }

    @Test
    public void testSuperRate(){
        Entry entry = new Entry(testCase1.split(","));
        Assert.assertEquals(9, entry.getSuperRate(), DELTA);
    }

    @Test
    public void testPaymentStartDate(){
        Entry entry = new Entry(testCase1.split(","));
        Assert.assertEquals("01 March – 31 March", entry.getPaymentStartDate());
    }

    @Test
    public void testSerialize(){
        Entry entry = new Entry(testCase1.split(","));
        Assert.assertEquals("steve guo,01 March – 31 March,0,0,0,0", entry.serialize());
    }
}
