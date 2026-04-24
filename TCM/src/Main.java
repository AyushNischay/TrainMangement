import java.util.*;
import java.util.stream.*;
class Bogie {
    String type;
    int capacity;

    public Bogie(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
    }

    public String getType() {
        return type;
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
        bogies.add(new Bogie("AC Chair", 65));

        System.out.println("Original Bogie List:");
        bogies.forEach(System.out::println);

        // ✅ Grouping bogies by type
        Map<String, List<Bogie>> groupedBogies = bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getType));

        // ✅ Display grouped result
        System.out.println("\nGrouped Bogies by Type:");
        for (Map.Entry<String, List<Bogie>> entry : groupedBogies.entrySet()) {
            System.out.println("\nType: " + entry.getKey());
            entry.getValue().forEach(System.out::println);
        }

        // Verify original list unchanged
        System.out.println("\nOriginal List After Grouping (Unchanged):");
        bogies.forEach(System.out::println);
    }
}