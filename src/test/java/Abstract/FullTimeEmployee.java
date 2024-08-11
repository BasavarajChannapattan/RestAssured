package Abstract;

public class FullTimeEmployee extends  Employee{

    public FullTimeEmployee(String name, int paymentPerHour)
    {
     super(name, paymentPerHour);
    }

    @Override
    public int calaculateSalary()
    {
        return getPaymentPerHour() * 8;
    }
}
