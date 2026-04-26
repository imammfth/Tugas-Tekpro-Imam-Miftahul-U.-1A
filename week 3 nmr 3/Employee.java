public class Employee implements Sortable {
    private String name;
    private double salary;
    private int hireday;
    private int hiremonth;
    private int hireyear;

    // Constructor bawaan dari soal
    public Employee(String n, double s, int day, int month, int year) {
        name = n;
        salary = s;
        hireday = day;
        hiremonth = month;
        hireyear = year;
    }

    public void print() {
        System.out.println(name + " " + salary + " " + hireYear());
    }

    public void raiseSalary(double byPercent) {
        salary *= 1 + byPercent / 100;
    }

    public int hireYear() {
        return hireyear;
    }

    // --- Tambahan implementasi dari interface Sortable ---
    @Override
    public int compare(Sortable b) {
        Employee eb = (Employee) b;
        if (this.salary < eb.salary) return -1;
        if (this.salary > eb.salary) return 1;
        return 0;
    }
}