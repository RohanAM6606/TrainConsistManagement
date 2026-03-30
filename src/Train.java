import java.util.*;

public class Train {
    public static void main(String[] args){

        // ---------------- UC1 ----------------
        System.out.println("=== Train Consist Management App ===");
        System.out.println("Version: 1.0");
        System.out.println("System initialized successfully.");

        List<String> trainConsist = new ArrayList<>();
        System.out.println("Train consist initialized.");
        System.out.println("Initial bogie count: " + trainConsist.size());

        // ---------------- UC2 ----------------

        trainConsist.add("Sleeper");
        trainConsist.add("AC Chair");
        trainConsist.add("First Class");

        System.out.println("\nBogies after addition:");
        System.out.println(trainConsist);

        trainConsist.remove("AC Chair");

        System.out.println("\nAfter removing 'AC Chair':");
        System.out.println(trainConsist);

        System.out.println("\nDoes 'Sleeper' exist? " + trainConsist.contains("Sleeper"));

        System.out.println("\nFinal Train Consist:");
        System.out.println(trainConsist);

        // ---------------- UC3 ----------------

        System.out.println("\n--- UC3: Unique Bogie IDs using HashSet ---");

        Set<String> bogieIds = new HashSet<>();

        bogieIds.add("BG101");
        bogieIds.add("BG102");
        bogieIds.add("BG103");
        bogieIds.add("BG101"); // duplicate
        bogieIds.add("BG102"); // duplicate

        System.out.println("Unique Bogie IDs:");
        System.out.println(bogieIds);

        // ---------------- UC4 (Map for Details) ----------------

        System.out.println("\n--- UC4: Bogie Details using Map ---");

        Map<String, String> bogieDetails = new HashMap<>();

        bogieDetails.put("BG101", "Sleeper");
        bogieDetails.put("BG102", "First Class");
        bogieDetails.put("BG103", "Sleeper");

        System.out.println("\nBogie Details:");
        for(String id : bogieIds){
            System.out.println("Bogie ID: " + id + " | Type: " + bogieDetails.get(id));
        }

        String checkId = "BG101";
        if(bogieDetails.containsKey(checkId)){
            System.out.println("\nDetails of " + checkId + ": " + bogieDetails.get(checkId));
        }

        // ---------------- UC4 (LinkedList Order) ----------------

        System.out.println("\n--- UC4: Maintain Ordered Bogies using LinkedList ---");

        LinkedList<String> trainOrder = new LinkedList<>();

        trainOrder.add("Engine");
        trainOrder.add("Sleeper");
        trainOrder.add("AC");
        trainOrder.add("Cargo");
        trainOrder.add("Guard");

        System.out.println("\nInitial Train Consist:");
        System.out.println(trainOrder);

        trainOrder.add(2, "Pantry");

        System.out.println("\nAfter inserting Pantry at position 2:");
        System.out.println(trainOrder);

        trainOrder.removeFirst();
        trainOrder.removeLast();

        System.out.println("\nAfter removing first and last bogie:");
        System.out.println(trainOrder);

        // ---------------- UC5 ----------------

        System.out.println("\n--- UC5: Ordered + Unique using LinkedHashSet ---");

        Set<String> trainFormation = new LinkedHashSet<>();

        trainFormation.add("Engine");
        trainFormation.add("Sleeper");
        trainFormation.add("Cargo");
        trainFormation.add("Guard");
        trainFormation.add("Sleeper"); // duplicate

        System.out.println("\nFinal Train Formation:");
        System.out.println(trainFormation);

        // ---------------- UC6 ----------------

        System.out.println("\n--- UC6: Map Bogie to Capacity using HashMap ---");

        Map<String, Integer> bogieCapacity = new HashMap<>();

        bogieCapacity.put("Sleeper", 72);
        bogieCapacity.put("AC Chair", 60);
        bogieCapacity.put("First Class", 24);
        bogieCapacity.put("Cargo", 100);

        System.out.println("\nBogie Capacity Details:");
        for (Map.Entry<String, Integer> entry : bogieCapacity.entrySet()) {
            System.out.println("Bogie: " + entry.getKey() +
                    " | Capacity: " + entry.getValue());
        }

        String search = "Sleeper";
        if (bogieCapacity.containsKey(search)) {
            System.out.println("\nCapacity of " + search + ": " +
                    bogieCapacity.get(search));
        }

        // End
        System.out.println("\nProgram continues...");
    }
}