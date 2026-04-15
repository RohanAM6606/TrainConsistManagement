import java.util.*;
import java.util.stream.*;
import java.util.regex.*;

class Bogie {
    String name;
    int capacity;
    String type;

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

class GoodsBogie {
    String type;
    String cargo;

    GoodsBogie(String type, String cargo) {
        this.type = type;
        this.cargo = cargo;
    }
}

public class Train {
    public static void main(String[] args){

        System.out.println("=== Train Consist Management App ===");

        List<String> trainConsist = new ArrayList<>();
        System.out.println("Initial bogie count: " + trainConsist.size());

        trainConsist.add("Sleeper");
        trainConsist.add("AC Chair");
        trainConsist.add("First Class");

        trainConsist.remove("AC Chair");
        System.out.println("\nFinal Train Consist: " + trainConsist);

        Set<String> bogieIds = new HashSet<>();
        bogieIds.add("BG101");
        bogieIds.add("BG102");
        bogieIds.add("BG103");
        bogieIds.add("BG101");

        System.out.println("\nUnique Bogie IDs: " + bogieIds);

        Map<String, String> bogieDetails = new HashMap<>();
        bogieDetails.put("BG101", "Sleeper");
        bogieDetails.put("BG102", "First Class");
        bogieDetails.put("BG103", "Sleeper");

        System.out.println("\nBogie Details:");
        for(String id : bogieIds){
            System.out.println(id + " → " + bogieDetails.get(id));
        }

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

        Set<String> trainFormation = new LinkedHashSet<>();
        trainFormation.add("Engine");
        trainFormation.add("Sleeper");
        trainFormation.add("Cargo");
        trainFormation.add("Guard");
        trainFormation.add("Sleeper");

        System.out.println("\nOrdered + Unique Formation: " + trainFormation);

        Map<String, Integer> bogieCapacity = new HashMap<>();
        bogieCapacity.put("Sleeper", 72);
        bogieCapacity.put("AC Chair", 60);
        bogieCapacity.put("First Class", 24);

        System.out.println("\nBogie Capacities:");
        for(Map.Entry<String, Integer> e : bogieCapacity.entrySet()){
            System.out.println(e.getKey() + " → " + e.getValue());
        }

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

        System.out.println("\n--- UC8: Filter Bogies using Streams ---");

        List<Bogie> filtered = bogies.stream()
                .filter(b -> b.capacity >= 50)
                .toList();

        System.out.println("\nFiltered Bogies (Capacity >= 50):");
        filtered.forEach(System.out::println);

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

        System.out.println("\n--- UC11: Train ID & Cargo Code Validation ---");

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Train ID (Format: TRN-1234): ");
        String trainId = sc.nextLine();

        System.out.print("Enter Cargo Code (Format: PET-AB): ");
        String cargoCode = sc.nextLine();

        String trainRegex = "TRN-\\d{4}";
        String cargoRegex = "PET-[A-Z]{2}";

        Pattern trainPattern = Pattern.compile(trainRegex);
        Pattern cargoPattern = Pattern.compile(cargoRegex);

        Matcher trainMatcher = trainPattern.matcher(trainId);
        Matcher cargoMatcher = cargoPattern.matcher(cargoCode);

        if (trainMatcher.matches()) {
            System.out.println("Valid Train ID");
        } else {
            System.out.println("Invalid Train ID");
        }

        if (cargoMatcher.matches()) {
            System.out.println("Valid Cargo Code");
        } else {
            System.out.println("Invalid Cargo Code");
        }

        System.out.println("\n--- UC12: Safety Validation using Streams ---");

        List<GoodsBogie> goodsBogies = new ArrayList<>();

        goodsBogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goodsBogies.add(new GoodsBogie("Box", "Coal"));
        goodsBogies.add(new GoodsBogie("Cylindrical", "Petroleum"));

        boolean isSafe = goodsBogies.stream()
                .allMatch(b ->
                        (b.type.equals("Cylindrical") && b.cargo.equals("Petroleum")) ||
                        (!b.type.equals("Cylindrical"))
                );

        if (isSafe) {
            System.out.println("Train is safety compliant");
        } else {
            System.out.println("Train is NOT safe");
        }

        System.out.println("\nProgram continues...");
    }
}
