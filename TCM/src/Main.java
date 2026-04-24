import java.util.*;
import java.util.stream.*;
class Bogie {
    String type;
    int capacity;

    public Bogie(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return "Bogie Type: " + type + ", Capacity: " + capacity;
    }
}



class TrainConsistApp {

    public static void main(String[] args) {

        // Reusing bogie list
        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 60));
        bogies.add(new Bogie("First Class", 50));
        bogies.add(new Bogie("Sleeper", 80));

        System.out.println("Original Bogie List:");
        bogies.forEach(System.out::println);

        // ✅ Step 1: Extract capacity using map()
        // ✅ Step 2: Aggregate using reduce()
        int totalSeats = bogies.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);

        // Display result
        System.out.println("\nTotal Seating Capacity: " + totalSeats);

        // Verify original list unchanged
        System.out.println("\nOriginal List After Aggregation (Unchanged):");
        bogies.forEach(System.out::println);
    }
}