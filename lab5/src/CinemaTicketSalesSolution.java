import java.util.LinkedList;
import java.util.Queue;

class Customer {
    String name;
    int age;
    int ticketCount;

    public Customer(String name, int age, int ticketCount) {
        this.name = name;
        this.age = age;
        this.ticketCount = ticketCount;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Ticket Count: " + ticketCount;
    }
}

public class CinemaTicketSalesSolution {
    private Queue<Customer> queue;
    private long processTime;

    public CinemaTicketSalesSolution() {
        this.queue = new LinkedList<>();
        this.processTime = 0;
    }

    public void addCustomer(String name, int age, int ticketCount) {
        if (age > 0 && ticketCount > 0) {
            Customer newCustomer = new Customer(name, age, ticketCount);
            queue.add(newCustomer);
            System.out.println(name + " added to the queue.");
        } else {
            System.out.println("Invalid input. Please enter a valid age and ticket count.");
        }
    }

    public void buyTickets(int ticketCount) {
        while (ticketCount > 0 && !queue.isEmpty()) {
            Customer customer = queue.peek();
            int ticketsToBuy = Math.min(ticketCount, customer.ticketCount);
            System.out.println(customer.name + " bought " + ticketsToBuy + " tickets.");
            customer.ticketCount -= ticketsToBuy;
            if (customer.ticketCount <= 0) {
                queue.poll();
                System.out.println(customer.name + " removed from the queue.");
            }
            processTime += ticketsToBuy * 5; // Adding 5 units of processing time for each ticket purchase
            ticketCount -= ticketsToBuy;
        }

        if (ticketCount > 0) {
            System.out.println("Not enough tickets available for all customers.");
        }
    }

    public void showCustomerInfo() {
        if (!queue.isEmpty()) {
            System.out.println("Next customer: " + queue.peek());
        } else {
            System.out.println("Queue is empty.");
        }
    }

    public boolean isQueueEmpty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        CinemaTicketSalesSolution cinemaTicketSales = new CinemaTicketSalesSolution();
        cinemaTicketSales.addCustomer("Ahmet", 25, 5);
        cinemaTicketSales.addCustomer("Ayşe", 30, 3);
        cinemaTicketSales.buyTickets(6);
        cinemaTicketSales.showCustomerInfo();
        System.out.println("Process time: "+cinemaTicketSales.processTime);
    }
}
