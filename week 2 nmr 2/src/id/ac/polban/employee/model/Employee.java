package id.ac.polban.employee.model;

public class Employee {
    private static int nextId = 1; 
    
    private int id;
    private String fullName;
    private Department department;
    private EmploymentType employmentType;
    private double baseSalary;

    public Employee(String fullName, Department department, EmploymentType employmentType, double baseSalary) {
        this.id = nextId++; 
        this.fullName = fullName;
        this.department = department;
        this.employmentType = employmentType;
        this.baseSalary = baseSalary;
    }

    public static int getNextId() {
        return nextId;
    }

    public int getId() { return id; }
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    
    public Department getDepartment() { return department; }
    public void setDepartment(Department department) { this.department = department; }
    
    public EmploymentType getEmploymentType() { return employmentType; }
    public void setEmploymentType(EmploymentType employmentType) { this.employmentType = employmentType; }
    
    public double getBaseSalary() { return baseSalary; }
    public void setBaseSalary(double baseSalary) { this.baseSalary = baseSalary; }
}