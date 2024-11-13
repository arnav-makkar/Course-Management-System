import java.util.*;

class Complaint {
    private int complaintID;
    private String studentID;
    private String description;
    private String status;

    public Complaint(int complaintID, String studentID, String description) {
        this.complaintID = complaintID;
        this.studentID = studentID;
        this.description = description;
        this.status = "Pending";
    }

    public int getComplaintID() {
        return complaintID;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void displayComplaint() {
        System.out.println("Complaint ID: " + complaintID);
        System.out.println("Description: " + description);
        System.out.println("Status: " + status);
        System.out.println();
    }
}

public class ComplaintSystem {
    public static ArrayList<Complaint> complaints = new ArrayList<>();
    private static int complaintCounter = 1000;  // To generate unique complaint IDs

    public static int generateComplaintID() {
        return ++complaintCounter;
    }

    public static void submitComplaint(String studentID, Scanner sc) {

        System.out.print("Enter Complaint Description: ");
        String description = sc.nextLine();

        Complaint newComplaint = new Complaint(generateComplaintID(), studentID, description);
        complaints.add(newComplaint);

        System.out.println("Complaint submitted successfully with ID: " + newComplaint.getComplaintID());
    }

    public static void viewComplaints(String studentID) {
        boolean found = false;

        for(int i = 0; i < complaints.size(); i++) {
            if(complaints.get(i).getStudentID().equals(studentID)) {
                complaints.get(i).displayComplaint();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No complaints found");
        }
    }

    public static void main(String studentID) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        while(true) {
            System.out.println("Complaint System Menu:");
            System.out.println("1. Submit Complaint");
            System.out.println("2. View Complaints");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            if(choice == 1) {
                submitComplaint(studentID, scanner);
            }

            else if(choice == 2) {
                viewComplaints(studentID);
            }

            else if(choice == 3) {
                break;
            }

            else{
                System.out.println("Invalid Choice, please try again.");
            }
        }
    }
}