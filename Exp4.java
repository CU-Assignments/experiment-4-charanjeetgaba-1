//EASY
import java.util.ArrayList;

class Employee {
    int id;
    String name;
    double salary;

    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Salary: " + salary;
    }
}

public class Exp4E {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        
        employees.add(new Employee(1, "Charanjeet", 50000));
        employees.add(new Employee(2, "Atul", 60000));
        employees.add(new Employee(3, "Anmol", 55000));

        System.out.println("Employees:");
        for (Employee emp : employees) {
            System.out.println(emp);
        }

        employees.removeIf(emp -> emp.id == 3);
        System.out.println("\nAfter Removal:");
        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }
}
//OUTPUT
    // Employees:
    // ID: 1, Name: Charanjeet, Salary: 50000.0
    // ID: 2, Name: Atul, Salary: 60000.0
    // ID: 3, Name: Anmol, Salary: 55000.0
    
    // After Removal:
    // ID: 1, Name: Charanjeet, Salary: 50000.0
    // ID: 2, Name: Atul, Salary: 60000.0

//MEDIUM
