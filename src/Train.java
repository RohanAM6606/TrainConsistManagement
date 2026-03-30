import java.util.*;

public class Train {
    public static void main(String[] args){

        // UC1: Initialization
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

        // ---------------- UC4 ----------------

        System.out.println("\n--- UC4: Bogie Details using Map ---");

        // Map: Bogie ID → Bogie Type
        Map<String, String> bogieDetails = new HashMap<>();

        bogieDetails.put("BG101", "Sleeper");
        bogieDetails.put("BG102", "First Class");
        bogieDetails.put("BG103", "Sleeper");

        // Display bogie details
        System.out.println("\nBogie Details:");
        for(String id : bogieIds){
            String type = bogieDetails.get(id);
            System.out.println("Bogie ID: " + id + " | Type: " + type);
        }

        // Check specific bogie
        String checkId = "BG101";
        if(bogieDetails.containsKey(checkId)){
            System.out.println("\nDetails of " + checkId + ": " + bogieDetails.get(checkId));
        }

        // ---------------- UC4(2)----------------

        System.out.println("\n--- UC4: Maintain Ordered Bogie IDs using LinkedList ---");

// Create LinkedList for ordered consist
        LinkedList<String> trainOrder = new LinkedList<>();

// Add bogies
        trainOrder.add("Engine");
        trainOrder.add("Sleeper");
        trainOrder.add("AC");
        trainOrder.add("Cargo");
        trainOrder.add("Guard");

        System.out.println("\nInitial Train Consist:");
        System.out.println(trainOrder);

// Insert Pantry at position 2
        trainOrder.add(2, "Pantry");

        System.out.println("\nAfter inserting Pantry at position 2:");
        System.out.println(trainOrder);

// Remove first and last bogie
        trainOrder.removeFirst();
        trainOrder.removeLast();

        System.out.println("\nAfter removing first and last bogie:");
        System.out.println(trainOrder);
    }
}