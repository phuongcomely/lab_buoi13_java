package entities;

public abstract class Staff {
    private static int autoId;
    protected int id; //protected cho các class con gọi trực
    // tiếp ko cần qua get.
    protected String name;
    protected double salary;

    public Staff( String name, double salary) {
        this.id = ++autoId;
        this.name = name;
        this.salary = salary;
    }

    public static int getAutoId() {
        return autoId;
    }

    public static void setAutoId(int autoId) {
        Staff.autoId = autoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
    public abstract double income();
    public abstract double vat();

}
