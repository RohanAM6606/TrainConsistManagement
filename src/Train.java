import java.util.*;
import java.util.stream.*;
import java.util.regex.*;

class InvalidCapacityException extends Exception {
    InvalidCapacityException(String message) {
        super(message);
    }
}

class CargoSafetyException extends RuntimeException {
    CargoSafetyException(String message) {
        super(message);
    }
}

class Bogie {
    String name;
    int capacity;
    String type;

    Bogie(String name, int capacity, String type) throws InvalidCapacityException {
        if (type.equals("Passenger") && capacity <= 0) {
            throw new InvalidCapacityException("Invalid capacity for passenger bogie");
        }
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

    void assignCargo(String cargo) {
        if (type.equals("Rectangular") && cargo.equals("Petroleum")) {
            throw new CargoSafetyException("Unsafe cargo assignment");
        }
        this.cargo = cargo;
    }
}

public class Train {
    public static void main(String[] args){

        System.out.println("=== Train Consist Management App ===");

        List<String> trainConsist = new ArrayList<>();
        trainConsist.add("Sleeper");
        trainConsist.add("AC Chair");
        trainConsist.add("First Class");

        trainConsist.remove("AC Chair");
        System.out.println("\nFinal Train Consist: " + trainConsist);

        // ---------------- SET ----------------
        Set<String> bogieIds = new HashSet<>();
        bogieIds.add("BG101");
        bogieIds.add("BG102");
        bogieIds.add("BG103");
        bogieIds.add("BG101");

        System.out.println("\nUnique Bogie IDs: " + bogieIds);

        // ---------------- MAP ----------------
        Map<String, String> bogieDetails = new HashMap<>();
        bogieDetails.put("BG101", "Sleeper");
        bogieDetails.put("BG102", "First Class");
        bogieDetails.put("BG103", "Sleeper");

        System.out.println("\nBogie Details:");
        for(String id : bogieIds){
            System.out.println(id + " → " + bogieDetails.get(id));
        }

        // ---------------- LINKED LIST ----------------
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

        // ---------------- LINKED HASH SET ----------------
        Set<String> trainFormation = new LinkedHashSet<>();
        trainFormation.add("Engine");
        trainFormation.add("Sleeper");
        trainFormation.add("Cargo");
        trainFormation.add("Guard");
        trainFormation.add("Sleeper");

        System.out.println("\nOrdered + Unique Formation: " + trainFormation);

        // ---------------- MAP (CAPACITY) ----------------
        Map<String, Integer> bogieCapacity = new HashMap<>();
        bogieCapacity.put("Sleeper", 72);
        bogieCapacity.put("AC Chair", 60);
        bogieCapacity.put("First Class", 24);

        System.out.println("\nBogie Capacities:");
        for(Map.Entry<String, Integer> e : bogieCapacity.entrySet()){
            System.out.println(e.getKey() + " → " + e.getValue());
        }

        // ---------------- UC17 SORT ----------------
        System.out.println("\n--- UC17: Arrays.sort() ---");
        String[] bogieTypes = {"Sleeper", "AC Chair", "First Class", "Cargo", "Pantry"};
        Arrays.sort(bogieTypes);
        System.out.println("Sorted Bogie Types: " + Arrays.toString(bogieTypes));

        // ================= UC18 =================
        System.out.println("\n--- UC18: Linear Search for Bogie ID ---");

        Scanner sc = new Scanner(System.in);

        // Convert Set to List
        List<String> bogieList = new ArrayList<>(bogieIds);

        // Input
        System.out.print("Enter Bogie ID to search: ");
        String searchKey = sc.nextLine();

        boolean found = false;

        // Linear Search
        for (String id : bogieList) {
            if (id.equals(searchKey)) {
                found = true;
                break;
            }
        }

        // Output
        if (found) {
            System.out.println("Bogie ID " + searchKey + " exists in the train.");
        } else {
            System.out.println("Bogie ID " + searchKey + " NOT found.");
        }

        System.out.println("\nProgram continues...");
    }
}
