package threads;

import service.EmployeeManager;

public class AutoSaveThread extends Thread {

    private final EmployeeManager manager;

    public AutoSaveThread(EmployeeManager manager) {
        this.manager = manager;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(5000); // auto save every 5 sec
                System.out.println("\n[AutoSave] Saving Employee List...");
                System.out.println(manager.getEmployees());
            } catch (InterruptedException e) {
                System.out.println("AutoSave Stopped.");
                break;
            }
        }
    }
}
