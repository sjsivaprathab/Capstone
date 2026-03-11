import java.util.*;

public class SuperManager {
    // GOD CLASS STATE: Too many unrelated variables
    public List<String> users = new ArrayList<>();
    public double[] transactions = new double[5];
    public String serverStatus = "OFFLINE";
    public static final int MAX_RETRIES = 3;
    private String secretKey; // Never initialized

    public void handleEverything(String task, String data, int id) {
        System.out.println("Starting task: " + task);

        // BUG 1: NullPointerException - secretKey is null
        if (secretKey.equals("ADMIN")) {
            System.out.println("Elevated Access");
        }

        // BUG 2: Logic error - Uses == to compare Strings instead of .equals()
        if (task == "SAVE_USER") {
            users.add(data);
        }

        // BUG 3: ArrayIndexOutOfBoundsException - no check if id < 5
        transactions[id] = 100.0;

        // BUG 4: ArithmeticException - Division by zero if id is 0
        double ratio = 500 / id; 
        System.out.println("Calculation result: " + ratio);
    }

    public void processDataFlow() {
        // BUG 5: Off-by-one error in loop condition
        for (int i = 0; i <= users.size(); i++) {
            // BUG 6: NullPointerException if list element is null
            System.out.println("User: " + users.get(i).toLowerCase());
        }
    }

    public void connectToNetwork(String ip) {
        int attempts = 0;
        // BUG 7: Infinite loop - attempts is never incremented
        while (serverStatus.equals("OFFLINE")) {
            System.out.println("Connecting to " + ip);
            if (attempts > MAX_RETRIES) break; 
        }
    }

    public void financialReport() {
        double total = 0;
        // BUG 8: Potential ConcurrentModificationException if 
        // another thread adds to 'users' while we iterate
        for (String u : users) {
            if (u == null) continue;
            total += 10.5;
        }
        System.out.println("Projected Revenue: " + total);
    }

    public static void main(String[] args) {
        SuperManager god = new SuperManager();
        
        // This sequence will crash at multiple points
        god.users.add("Alice");
        god.handleEverything("SAVE_USER", "Bob", 10); // Crashes at id 10
        god.processDataFlow(); // Crashes on loop end
        god.connectToNetwork("192.168.1.1"); // Hangs forever
    }
}
