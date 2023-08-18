package entities;

public class AdminiStaff extends Staff{


    public AdminiStaff(String name, double salary) {
        super(name, salary);
    }

    @Override
    public double income() {
        return salary;
    }

    @Override
    public double vat() {
        if (income()>11000000.0 ){
            return income() * 0.1;

        }else
            return 0;
    }

}
