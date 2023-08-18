package entities;

public class Manager extends Staff{
    private double salaryResponsible; //lương trách nhiệm

    public Manager(String name, double salary, double salaryResponsible) {
        super(name, salary);
        salaryResponsible = salaryResponsible;
    }

    public double getSalaryResponsible() {
        return salaryResponsible;
    }

    public void setSalaryResponsible(double salaryResponsible) {
        salaryResponsible = salaryResponsible;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "salaryResponsible=" + salaryResponsible +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public double income() {
        return (salary+salaryResponsible);
    }

    @Override
    public double vat() {

        if (income()>11000000.0 ){
            return income() * 0.1;

        }else
            return 0;
    }
}
