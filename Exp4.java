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
import java.util.*;

class Card {
    private String symbol, value;

    public Card(String symbol, String value) {
        this.symbol = symbol;
        this.value = value;
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return value + " of " + symbol;
    }
}

class CardCollection {
    private Collection<Card> cards = new ArrayList<>();

    public void addCard(Card card) {
        cards.add(card);
    }

    public void displayCardsBySymbol(String symbol) {
        cards.stream().filter(c -> c.getSymbol().equalsIgnoreCase(symbol)).forEach(System.out::println);
    }
}

public class Exp4M {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CardCollection collection = new CardCollection();

        collection.addCard(new Card("Hearts", "Ace"));
        collection.addCard(new Card("Spades", "King"));

        System.out.print("Enter a symbol to search: ");
        String symbol = scanner.nextLine();

        collection.displayCardsBySymbol(symbol);
        scanner.close();
    }
}
//OUTPUT
        // Enter a symbol to search: hearts
        // Ace of Hearts

//HARD
import java.util.concurrent.locks.*;

class TicketBookingSystem {
    private boolean[] seats;
    private Lock lock;

    public TicketBookingSystem(int seatCount) {
        seats = new boolean[seatCount];
        lock = new ReentrantLock();
    }

    public void bookSeat(int seatNumber, String customer) {
        lock.lock();
        try {
            if (!seats[seatNumber]) {
                seats[seatNumber] = true;
                System.out.println(customer + " successfully booked seat " + seatNumber);
            } else {
                System.out.println("Seat " + seatNumber + " is already booked.");
            }
        } finally {
            lock.unlock();
        }
    }
}

class BookingThread extends Thread {
    private TicketBookingSystem system;
    private int seatNumber;
    private String customer;

    public BookingThread(TicketBookingSystem system, int seatNumber, String customer, int priority) {
        this.system = system;
        this.seatNumber = seatNumber;
        this.customer = customer;
        setPriority(priority);
    }

    @Override
    public void run() {
        system.bookSeat(seatNumber, customer);
    }
}

public class Exp4H {
    public static void main(String[] args) {
        TicketBookingSystem system = new TicketBookingSystem(10);
        
        Thread vip1 = new BookingThread(system, 3, "VIP_1", Thread.MAX_PRIORITY);
        Thread vip2 = new BookingThread(system, 3, "VIP_2", Thread.MAX_PRIORITY);
        Thread user1 = new BookingThread(system, 3, "User_1", Thread.MIN_PRIORITY);
        Thread user2 = new BookingThread(system, 3, "User_2", Thread.NORM_PRIORITY);
        
        vip1.start();
        vip2.start();
        user1.start();
        user2.start();
    }
}
//OUTPUT
        // VIP_1 successfully booked seat 3
        // Seat 3 is already booked.
        // Seat 3 is already booked.
        // Seat 3 is already booked.
