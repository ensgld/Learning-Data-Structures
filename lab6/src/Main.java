// Main class
public class Main {
    public static void main(String[] args) {
        // Create a Magical Garden
        MagicalGarden garden = new MagicalGarden();

        // Add plants
        garden.add("Rose");
        garden.add("Violet");
        garden.add("Daisy");
        garden.add("Lavender");

        // List the plants in the garden
        garden.listPlants();

        // Create an iterator
        GardenIterator iterator = new GardenIterator(garden);

        // Traverse the garden using iterator
        System.out.print("Traversal with iterator: ");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        // Remove plants
        garden.remove("Violet");
        garden.remove("Rose");

        // List the updated plants
        garden.listPlants();
    }
}