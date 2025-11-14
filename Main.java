import model.Employee;
import service.EmployeeManager;
import threads.AutoSaveThread;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        EmployeeManager manager = new EmployeeManager();

        AutoSaveThread autoSave = new AutoSaveThread(manager);
        autoSave.start();

        while (true) {
            System.out.println("\n===== Employee Management System =====");
            System.out.println("1. Add Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Remove Employee");
            System.out.println("4. Display All Employees");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int ch = sc.nextInt();

            switch (ch) {

                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();

                    sc.nextLine(); // clear buffer
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Salary: ");
                    double salary = sc.nextDouble();

                    manager.addEmployee(new Employee(id, name, salary));
                    break;

                case 2:
                    System.out.print("Enter ID to Update: ");
                    int uid = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Name: ");
                    String newName = sc.nextLine();

                    System.out.print("Enter New Salary: ");
                    double newSalary = sc.nextDouble();

                    manager.updateEmployee(uid, newName, newSalary);
                    break;

                case 3:
                    System.out.print("Enter ID to Remove: ");
                    int rid = sc.nextInt();
                    manager.removeEmployee(rid);
                    break;

                case 4:
                    manager.displayEmployees();
                    break;

                case 5:
                    autoSave.interrupt(); // stop thread safely
                    System.out.println("Exiting Program...");
                    return;

                default:
                    System.out.println("Invalid Choice.");
            }
        }
    }
}
