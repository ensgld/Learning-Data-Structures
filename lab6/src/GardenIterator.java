// Iterator class
class GardenIterator {
    private MagicalGarden garden;
    private int index;

    // Constructor method
    public GardenIterator(MagicalGarden garden) {
        this.garden = garden;
        index = 0;
    }

    // Get the next plant
    public String next() {
        return garden.plants[index++];
    }

    // Check if there is a next plant
    public boolean hasNext() {
        return index < garden.size;
    }
}
