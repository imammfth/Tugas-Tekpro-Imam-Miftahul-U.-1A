import id.ac.polban.employee.model.*;
import id.ac.polban.employee.service.*;

public class Main {
    public static void main(String[] args) {
        Department dataDept = new Department("Data Science");
        EmploymentType fullTime = new EmploymentType("Full-Time");

        Employee emp1 = new Employee("Imam", dataDept, fullTime, 5000000);

        System.out.println("=== Data Pegawai Awal ===");
        System.out.println("ID        : " + emp1.getId());
        System.out.println("Nama      : " + emp1.getFullName());
        System.out.println("Divisi    : " + emp1.getDepartment().getDeptName());
        System.out.println("Tipe      : " + emp1.getEmploymentType().getTypeName());
        System.out.println("Gaji Awal : Rp " + emp1.getBaseSalary());

        EmployeeService service = new EmployeeService();
        service.registerEmployee(emp1);
        
        service.applySalaryIncrease(emp1.getId(), 25);

        System.out.println("\n=== Data Setelah Kenaikan Gaji ===");
        System.out.println("Gaji Baru : Rp " + service.findEmployeeById(emp1.getId()).getBaseSalary());

        System.out.println("\nNext Available ID: " + Employee.getNextId());
    }
}