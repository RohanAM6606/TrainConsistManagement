import java.util.ArrayList;
import java.util.List;

public class Train {
    public static void main(String[] args){

        // UC1: Initialization
        System.out.println("=== Train Consist Management App ===");
        System.out.println("Version: 1.0");
        System.out.println("System initialized successfully.");

        List<String> trainConsist = new ArrayList<>();

        System.out.println("Train consist initialized.");
        System.out.println("Initial bogie count: " + trainConsist.size());

        // ---------------- UC2 START ----------------

        // Add bogies (CREATE)
        trainConsist.add("Sleeper");
        trainConsist.add("AC Chair");
        trainConsist.add("First Class");

        // Display bogies (READ)
        System.out.println("\nBogies after addition:");
        System.out.println(trainConsist);

        // Remove a bogie (DELETE)
        trainConsist.remove("AC Chair");
        System.out.println("\nAfter removing 'AC Chair':");
        System.out.println(trainConsist);

        // Check existence (SEARCH)
        boolean exists = trainConsist.contains("Sleeper");
        System.out.println("\nDoes 'Sleeper' exist? " + exists);


        System.out.println("\nFinal Train Consist:");
        System.out.println(trainConsist);




    }
}