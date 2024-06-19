import java.util.Arrays;

// Magical Garden class
class MagicalGarden {
    private int capacity; // Capacity of the garden
    int size; // Current size of the garden
    String[] plants; // Array of plants in the garden

    // Constructor method
    public MagicalGarden() {
        capacity = 10; // Default capacity at the beginning
        size = 0;
        plants = new String[capacity];
    }

    // Adding a plant
    public void add(String plantName) {
        if (size == capacity) {
            capacity *= 2; // Double the capacity
            String[] newPlants = new String[capacity];
            for (int i = 0; i < size; i++) {
                newPlants[i] = plants[i];
            }
            plants = newPlants;
        }
        plants[size++] = plantName;
    }

    // Removing a specific plant
    public void remove(String plantName) {
        boolean found = false;
        for (int i = 0; i < size; i++) {
            if (plants[i].equals(plantName)) {
                found = true;
                for (int j = i; j < size - 1; j++) {
                    plants[j] = plants[j + 1];
                }
                size--;
                break;
            }
        }
        if (!found) {
            System.out.println("Error: " + plantName + " plant not found!");
        }
    }

   

    // Listing the plants in the garden
    public void listPlants() {
        System.out.print("Magical Garden: ");
        for (int i = 0; i < size; i++) {
            System.out.print(plants[i] + " ");
        }
        System.out.println();
    }
}