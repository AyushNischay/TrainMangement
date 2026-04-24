import java.util.*;
import java.util.stream.Collectors;
class Bogie {
    String type;
    int capacity;
    public Bogie(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Bogie Type: " + type + ", Capacity: " + capacity;
    }
}
class train {
    public static void main(String[] args) {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 60));
        bogies.add(new Bogie("First Class", 50));
        bogies.add(new Bogie("Sleeper", 80));
        System.out.println("Original Bogie List:");
        bogies.forEach(System.out::println);
        List<Bogie> filteredBogies = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());
        System.out.println("\nFiltered Bogies (Capacity > 60):");
        filteredBogies.forEach(System.out::println);
        System.out.println("\nOriginal List After Filtering (Unchanged):");
        bogies.forEach(System.out::println);
    }
}