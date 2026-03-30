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

        // Create HashSet
        Set<String> bogieIds = new HashSet<>();

        // Add bogie IDs (including duplicates)
        bogieIds.add("BG101");
        bogieIds.add("BG102");
        bogieIds.add("BG103");
        bogieIds.add("BG101"); // duplicate
        bogieIds.add("BG102"); // duplicate

        // Display unique bogie IDs
        System.out.println("Unique Bogie IDs:");
        System.out.println(bogieIds);

        // Program continues
        System.out.println("\nProgram continues...");
    }
}