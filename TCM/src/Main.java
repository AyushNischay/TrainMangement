import java.util.*;
import java.util.stream.*;
class TrainConsistApp {
    public static void main(String[] args) {
        // ✅ Create large dataset
        List<Bogie> bogies = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 100000; i++) {
            int capacity = 40 + random.nextInt(50); // range: 40–89
            bogies.add(new Bogie("Passenger", capacity));
        }
        // -------------------------------
        // ✅ Loop-based filtering
        // -------------------------------
        long loopStart = System.nanoTime();
        List<Bogie> loopResult = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.getCapacity() > 60) {
                loopResult.add(b);
            }
        }
        long loopEnd = System.nanoTime();
        long loopTime = loopEnd - loopStart;
        // -------------------------------
        // ✅ Stream-based filtering
        // -------------------------------
        long streamStart = System.nanoTime();
        List<Bogie> streamResult = bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());
        long streamEnd = System.nanoTime();
        long streamTime = streamEnd - streamStart;
        // -------------------------------
        // ✅ Results
        // -------------------------------
        System.out.println("Loop Result Size: " + loopResult.size());
        System.out.println("Stream Result Size: " + streamResult.size());
        System.out.println("\nLoop Execution Time (ns): " + loopTime);
        System.out.println("Stream Execution Time (ns): " + streamTime);
        // ✅ Consistency check
        System.out.println("\nResults Match: " +
                (loopResult.size() == streamResult.size()));
    }
}
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
}