package id.ac.polban.employee.service;

import java.util.HashMap;
import java.util.Map;
import id.ac.polban.employee.model.*;

public class EmployeeService {
    private Map<Integer, Employee> employeeDatabase = new HashMap<>();

    public void registerEmployee(Employee employee) {
        employeeDatabase.put(employee.getId(), employee);
    }
    
    public Employee findEmployeeById(int id) {
        return employeeDatabase.get(id);
    }

    public void applySalaryIncrease(int id, double percentage) {
        Employee emp = employeeDatabase.get(id);
        if (emp != null) {
            double increaseAmount = emp.getBaseSalary() * (percentage / 100);
            emp.setBaseSalary(emp.getBaseSalary() + increaseAmount);
        }
    }
}
