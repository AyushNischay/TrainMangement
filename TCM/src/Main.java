import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");

        Set<String> bogieIds = new HashSet<>();

        bogieIds.add("B1");
        bogieIds.add("B2");
        bogieIds.add("B3");
        bogieIds.add("B2");
        bogieIds.add("B1");

        System.out.println("Unique bogie IDs: " + bogieIds);
    }
}