import java.util.*;
import java.util.stream.*;

// ---------------- Bogie Class ----------------
class Bogie {
    String name;
    int capacity;
    String type; // Passenger / Goods

    Bogie(String name, int capacity, String type) {
        this.name = name;
        this.capacity = capacity;
        this.type = type;
    }

    @Override
    public String toString() {
        return name + " (" + capacity + ")";
    }
}

public class Train {
    public static void main(String[] args){

        // ---------------- UC1 ----------------
        System.out.println("=== Train Consist Management App ===");

        List<String> trainConsist = new ArrayList<>();
        System.out.println("Initial bogie count: " + trainConsist.size());

        // ---------------- UC2 ----------------
        trainConsist.add("Sleeper");
        trainConsist.add("AC Chair");
        trainConsist.add("First Class");

        trainConsist.remove("AC Chair");
        System.out.println("\nFinal Train Consist: " + trainConsist);

        // ---------------- UC3 ----------------
        Set<String> bogieIds = new HashSet<>();
        bogieIds.add("BG101");
        bogieIds.add("BG102");
        bogieIds.add("BG103");
        bogieIds.add("BG101");

        System.out.println("\nUnique Bogie IDs: " + bogieIds);

        // ---------------- UC4 (Map) ----------------
        Map<String, String> bogieDetails = new HashMap<>();
        bogieDetails.put("BG101", "Sleeper");
        bogieDetails.put("BG102", "First Class");
        bogieDetails.put("BG103", "Sleeper");

        System.out.println("\nBogie Details:");
        for(String id : bogieIds){
            System.out.println(id + " → " + bogieDetails.get(id));
        }

        // ---------------- UC4 (LinkedList Order) ----------------
        LinkedList<String> trainOrder = new LinkedList<>();
        trainOrder.add("Engine");
        trainOrder.add("Sleeper");
        trainOrder.add("AC");
        trainOrder.add("Cargo");
        trainOrder.add("Guard");

        trainOrder.add(2, "Pantry");
        trainOrder.removeFirst();
        trainOrder.removeLast();

        System.out.println("\nOrdered Train: " + trainOrder);

        // ---------------- UC5 ----------------
        Set<String> trainFormation = new LinkedHashSet<>();
        trainFormation.add("Engine");
        trainFormation.add("Sleeper");
        trainFormation.add("Cargo");
        trainFormation.add("Guard");
        trainFormation.add("Sleeper");

        System.out.println("\nOrdered + Unique Formation: " + trainFormation);

        // ---------------- UC6 ----------------
        Map<String, Integer> bogieCapacity = new HashMap<>();
        bogieCapacity.put("Sleeper", 72);
        bogieCapacity.put("AC Chair", 60);
        bogieCapacity.put("First Class", 24);

        System.out.println("\nBogie Capacities:");
        for(Map.Entry<String, Integer> e : bogieCapacity.entrySet()){
            System.out.println(e.getKey() + " → " + e.getValue());
        }

        // ---------------- UC7 ----------------
        System.out.println("\n--- UC7: Sort Bogies by Capacity ---");

        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72, "Passenger"));
        bogies.add(new Bogie("AC Chair", 60, "Passenger"));
        bogies.add(new Bogie("First Class", 24, "Passenger"));

        bogies.sort(Comparator.comparingInt(b -> b.capacity));

        System.out.println("\nSorted Bogies:");
        for(Bogie b : bogies){
            System.out.println(b);
        }

        // ---------------- UC8 ----------------
        System.out.println("\n--- UC8: Filter Bogies using Streams ---");

        List<Bogie> filtered = bogies.stream()
                .filter(b -> b.capacity >= 50)
                .toList();

        System.out.println("\nFiltered Bogies (Capacity >= 50):");
        filtered.forEach(System.out::println);

        // ---------------- UC9 ----------------
        System.out.println("\n--- UC9: Group Bogies by Type ---");

        List<Bogie> allBogies = new ArrayList<>();

        allBogies.add(new Bogie("Sleeper", 72, "Passenger"));
        allBogies.add(new Bogie("AC Chair", 60, "Passenger"));
        allBogies.add(new Bogie("First Class", 24, "Passenger"));
        allBogies.add(new Bogie("Cargo", 100, "Goods"));
        allBogies.add(new Bogie("Oil Tanker", 120, "Goods"));

        Map<String, List<Bogie>> grouped =
                allBogies.stream()
                        .collect(Collectors.groupingBy(b -> b.type));

        System.out.println("\nGrouped Bogies:");

        for (Map.Entry<String, List<Bogie>> entry : grouped.entrySet()) {
            System.out.println("\nType: " + entry.getKey());
            for (Bogie b : entry.getValue()) {
                System.out.println("  " + b);
            }
        }

        System.out.println("\nProgram continues...");
    }
}