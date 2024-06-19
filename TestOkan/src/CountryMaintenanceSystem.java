import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeSet;

class Node {

    String countryName;
    int population;
    String capitalCity;
    String largestCity;
    String language;
    String currency;
    Node prev;
    Node next;

    public Node(String countryName, int population, String capitalCity, String largestCity, String language, String currency) {
        this.countryName = countryName;
        this.population = population;
        this.capitalCity = capitalCity;
        this.largestCity = largestCity;
        this.language = language;
        this.currency = currency;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLinkedList {

    Node head;

    public void addNode(String countryName, int population, String capitalCity, String largestCity, String language, String currency) {
        Node newNode = new Node(countryName, population, capitalCity, largestCity, language, currency);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public boolean deleteNode(String countryName) {
        Node current = head;
        while (current != null) {
            if (current.countryName.equalsIgnoreCase(countryName)) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                }
                if (current.next != null) {
                    current.next.prev = current.prev;
                }
                if (current == head) {
                    head = current.next;
                }
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void printAll() {
        TreeSet<Node> sortedSet = new TreeSet<>(Comparator.comparing(node -> node.countryName.toLowerCase()));
        Node current = head;
        while (current != null) {
            sortedSet.add(current);
            current = current.next;
        }
        int count = 1;
        for (Node node : sortedSet) {
            System.out.println(count++ + ". " + node.countryName + " " + node.population + " " + node.capitalCity + " " + node.largestCity + " " + node.language + " " + node.currency);

        }

    }

    public void executeQuery(String query) {
        StringTokenizer st = new StringTokenizer(query);
        String command = st.nextToken().toLowerCase();
        if (command.equals("query")) {
            if (st.countTokens() < 3) {
                System.out.println("Invalid query format: Insufficient tokens.");
                return;
            }
            String attribute = st.nextToken().toLowerCase();
            String operator = st.nextToken();
            String value = st.nextToken().toLowerCase();
            Node current = head;
            TreeSet<Node> sortedSet = new TreeSet<>(Comparator.comparing(node -> node.countryName.toLowerCase()));
            boolean found = false;
            while (current != null) {
                if (attribute.equals("population") && compare(current.population, operator, Integer.parseInt(value))) {
                    sortedSet.add(current);
                    found = true;
                } else if (attribute.equals("country") && compareString(current.countryName, operator, value)) {
                    sortedSet.add(current);
                    found = true;
                } else if (attribute.equals("capital_city") && compareString(current.capitalCity, operator, value)) {
                    sortedSet.add(current);
                    found = true;
                } else if (attribute.equals("largest_city") && compareString(current.largestCity, operator, value)) {
                    sortedSet.add(current);
                    found = true;
                } else if (attribute.equals("language") && compareString(current.language, operator, value)) {
                    sortedSet.add(current);
                    found = true;
                } else if (attribute.equals("currency") && compareString(current.currency, operator, value)) {
                    sortedSet.add(current);
                    found = true;
                }
                current = current.next;
            }
            if (!found) {
                System.out.println("No matching countries found.");
            } else {
                int count = 1;
                for (Node node : sortedSet) {
                    System.out.println(count++ + ". " + node.countryName + " " + node.population + " " + node.capitalCity + " " + node.largestCity + " " + node.language + " " + node.currency);
                }
            }
        } else if (command.equals("add")) {
            if (st.countTokens() < 6) {
                System.out.println("Invalid add query format: Insufficient tokens.");
                return;
            }
            String countryName = st.nextToken();
            int population = Integer.parseInt(st.nextToken().replace(".", ""));
            String capitalCity = st.nextToken();
            String largestCity = st.nextToken();
            String language = st.nextToken();
            String currency = st.nextToken();
            addNode(countryName, population, capitalCity, largestCity, language, currency);
            System.out.println("A new country has been added.");
        } else if (command.equals("delete")) {
            if (st.countTokens() < 1) {
                System.out.println("Invalid delete query format: Insufficient tokens.");
                return;
            }
            String countryName = st.nextToken();
            if (deleteNode(countryName)) {
                System.out.println(countryName + " has been removed from the list.");
            } else {
                System.out.println(countryName + " was not found in the list.");
            }
        } else if (command.equals("queryprint_all")) {
            printAll();
        }
        System.out.println();
    }

    public boolean compare(int value1, String operator, int value2) {
        switch (operator) {
            case "=":
                return value1 == value2;
            case ">":
                return value1 > value2;
            case "<":
                return value1 < value2;
            default:
                return false;
        }
    }

    public boolean compareString(String value1, String operator, String value2) {
        switch (operator) {
            case "=":
                return value1.equalsIgnoreCase(value2);
            case ">":
                return value1.compareToIgnoreCase(value2) > 0;
            case "<":
                return value1.compareToIgnoreCase(value2) < 0;
            default:
                return false;
        }
    }
}

public class CountryMaintenanceSystem {

    public static void main(String[] args) {
        DoublyLinkedList countries = new DoublyLinkedList();

        // Reading input.txt file and adding countries to the list
        try ( BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line);
                String countryName = st.nextToken();
                int population = Integer.parseInt(st.nextToken().replace(".", ""));
                String capitalCity = st.nextToken();
                String largestCity = st.nextToken();
                String language = st.nextToken();
                String currency = st.nextToken();
                countries.addNode(countryName, population, capitalCity, largestCity, language, currency);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Reading query.txt file and executing queries
        try ( BufferedReader br = new BufferedReader(new FileReader("query.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                countries.executeQuery(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}