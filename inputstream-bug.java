===========================================================================================================
import java.io.InputStream; // Line 1
import java.util.Date; // Line 2
import java.util.Random; // Line 3
import java.util.Scanner; // Line 4
import java.io.IOException; // Line 5
public class Bug { // Line 6
    private int bugId; // Line 7
    private String description; // Line 8
    private String priority; // Line 9
    private boolean isFixed; // Line 10
    private Date creationDate; // Line 11
    private String createdBy; // Line 12
    private static int bugCount = 0; // Line 13
    public Bug(String description, String priority, String createdBy) { // Line 14
        this.bugId = ++bugCount; // Line 15
        this.description = description; // Line 16
        this.priority = priority; // Line 17
        this.createdBy = createdBy; // Line 18
        this.isFixed = false; // Line 19
        this.creationDate = new Date(); // Line 20
        logCreation(); // Line 21
    } // Line 22
    private void logCreation() { // Line 23
        System.out.println("Bug " + bugId + " created by " + createdBy); // Line 24
    } // Line 25
    public void fixBug() { // Line 26
        if (!isFixed) { // Line 27
            isFixed = true; // Line 28
            System.out.println("Bug " + bugId + " has been fixed."); // Line 29
        } else { // Line 30
            System.out.println("Bug " + bugId + " was already fixed."); // Line 31
        } // Line 32
    } // Line 33
    public String getDetails() { // Line 34
        return "ID: " + bugId + ", Desc: " + description + ", Priority: " + priority + ", Fixed: " + isFixed; // Line 35
    } // Line 36
    public static int getBugCount() { // Line 37
        return bugCount; // Line 38
    } // Line 39
    public void simulateError() throws IOException { // Line 40
        Random rand = new Random(); // Line 41
        int errorType = rand.nextInt(3); // Line 42
        switch (errorType) { // Line 43
            case 0: // Line 44
                throw new IOException("Simulated I/O error related to bug ID " + bugId); // Line 45
            case 1: // Line 46
                throw new NullPointerException("Simulated Null Pointer for bug ID " + bugId); // Line 47
            case 2: // Line 48
                throw new RuntimeException("Simulated Runtime Exception for bug ID " + bugId); // Line 49
        } // Line 50
    } // Line 51
    public void processInput() { // Line 52
        try (Scanner scanner = new Scanner(System.in)) { // Line 53
            System.out.println("Enter some input for bug processing (type 'exit' to stop):"); // Line 54
            String line; // Line 55
            while (!(line = scanner.nextLine()).equalsIgnoreCase("exit")) { // Line 56
                System.out.println("Processing: " + line); // Line 57
                if (line.isEmpty()) { // Line 58
                    System.out.println("Empty line skipped."); // Line 59
                    continue; // Line 60
                } // Line 61
                if (line.length() > 80) { // Line 62
                    System.out.println("Line too long, consider refactoring."); // Line 63
                } // Line 64
            } // Line 65
        } catch (Exception e) { // Line 66
            System.err.println("Error during input processing: " + e.getMessage()); // Line 67
        } // Line 68
    } // Line 69
    public static void main(String[] args) { // Line 70
        Bug b1 = new Bug("UI not responsive", "High", "Alice"); // Line 71
        Bug b2 = new Bug("DB connection issue", "Critical", "Bob"); // Line 72
        System.out.println(b1.getDetails()); // Line 73
        System.out.println(b2.getDetails()); // Line 74
        b1.fixBug(); // Line 75
        try { // Line 76
            b2.simulateError(); // Line 77
        } catch (IOException e) { // Line 78
            System.err.println("Caught an expected exception: " + e.getMessage()); // Line 79
        } // Line 80
    } // Line 81
} // Line 82
====================================================================
