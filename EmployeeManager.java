package service;

import model.Employee;
import java.util.ArrayList;

public class EmployeeManager {

    private final ArrayList<Employee> employees = new ArrayList<>();

    public synchronized void addEmployee(Employee e) {
        employees.add(e);
        System.out.println("Employee Added.");
    }

    public synchronized void updateEmployee(int id, String newName, double newSalary) {
        for (Employee e : employees) {
            if (e.getId() == id) {
                e.setName(newName);
                e.setSalary(newSalary);
                System.out.println("Employee Updated.");
                return;
            }
        }
        System.out.println("Employee Not Found.");
    }

    public synchronized void removeEmployee(int id) {
        employees.removeIf(e -> e.getId() == id);
        System.out.println("Employee Removed.");
    }

    public synchronized void displayEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No Employees Available.");
            return;
        }
        employees.forEach(System.out::println);
    }

    public synchronized ArrayList<Employee> getEmployees() {
        return new ArrayList<>(employees);
    }
}
