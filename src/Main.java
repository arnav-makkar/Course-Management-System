import java.util.*;

public class Main implements Data, Human {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Add courses info
        Course IP = new Course("Introduction to Programming", "CSE101", "Dr. BN Jain", "9:00am-10:30am on Monday and Wednesday", 1, 4);
        Course DC = new Course("Digital Circuits", "ECE111", "Dr. Tammam Tillo", "9:00am-10:30am on Tuesday and Thursday", 1, 4);
        Course LA = new Course("Linear Algebra", "MTH101", "Dr. Samaresh Chatterji", "10:30am-12:00pm on Monday and Wednesday", 1, 4);
        Course HCI = new Course("Human Computer Interaction", "ECE113", "Dr. Rajeev Ratn Shah", "10:30am-12:00pm on Tuesday and Thursday", 1, 4);
        Course COM = new Course("Communication Skills", "COM101", "Dr. Payel Mukherjee", "3:00pm-6:00pm on Wednesday", 1, 4);
        Data.sem1.addAll(Arrays.asList(IP, DC, LA, HCI, COM));

        Course DSA = new Course("Data Structures and Algorithms", "CSE102", "Dr. Arun Balaji", "9:00am-10:30am on Tuesday and Thursday", 2, 4);
        DSA.pre_req = "IP";
        Course CO = new Course("Computer Organisation", "CSE112", "Dr. Sujay Deb", "9:00am-10:30am on Monday and Wednesday", 2, 4);
        Course PnS = new Course("Probability and Statistics", "MTH201", "Dr. Subhajit Ghosechowdhury", "10:30am-12:00pm on Monday and Wednesday", 2, 4);
        Course BE = new Course("Basic Electronics", "ECE113", "Dr. Tammam Tillo", "10:30am-12:00pm on Tuesday and Thursday", 2, 4);
        BE.pre_req = "DC";
        Course MnB = new Course("Money and Banking", "ECO223", "Dr. Kirti Kanjilal", "3:00pm-6:00pm on Wednesday", 2, 4);
        Course CTRSS = new Course("Critical Thinking and Readings in Social Science", "SSH101", "Dr. Aasim Khan", "3:00pm-6:00pm on Wednesday", 2, 4);
        Data.sem2.addAll(Arrays.asList(DSA, CO, PnS, BE, MnB, CTRSS));

        Course AP = new Course("Advanced Programming", "CSE201", "Dr. Arun Balaji", "9:00am-10:30am on Monday and Wednesday", 3, 4);
        AP.pre_req = "IP, DSA";
        Course OS = new Course("Operating Systems", "CSE231", "Dr. Vivek Kumar", "9:00am-10:30am on Tuesday and Thursday", 3, 4);
        OS.pre_req = "CO";
        Course M3 = new Course("Multivatiate Calculus", "MTH203", "Dr. Satish Kumar Pandey", "10:30am-12:00pm on Monday and Wednesday", 3, 4);
        Course DM = new Course("Discrete Mathematics", "CSE121", "Dr. Bapi Chatterjee", "10:30am-12:00pm on Tuesday and Thursday", 3, 4);
        Course NT = new Course("Number Theory", "MTH211", "Dr. Debika Banerjee", "3:00pm-6:00pm on Wednesday", 3, 4);
        Course SPP = new Course("Social and Political Philosophy", "SSH221", "Dr. Manohar Kumar", "3:00pm-6:00pm on Wednesday", 3, 4);
        Course PDE = new Course("Politics in Digital Era", "SSH240", "Dr. Aasim Khan", "3:00pm-6:00pm on Wednesday", 3, 4);
        Course PASSP = new Course("Political Anthropology: State, Subject and Power", "SOC216", "Dr. Deepak Prince", "3:00pm-6:00pm on Wednesday", 3, 4);
        Data.sem3.addAll(Arrays.asList(AP, OS, M3, DM, NT, SPP, PDE, PASSP));

        Student Arnav_Makkar = new Student("Arnav Makkar", "Arnav1234");
        Student Aditya_Singh = new Student("Aditya Singh", "Aditya1234");
        Student Rushil_Singha = new Student("Rushil Singha", "Rushil1234");
        Human.student_list.addAll(List.of(Arnav_Makkar, Aditya_Singh, Rushil_Singha));


        TA Aayush_Mishra = new TA("Aayush Mishra", "Aayush123", AP);
        Human.ta_list.add(Aayush_Mishra);

        while(true){

            System.out.println("\nWelcome to the University Course Registration System");

            try {

                System.out.println("1: Student");
                System.out.println("2: Professor");
                System.out.println("3: Teaching Assistant");
                System.out.println("4: Administrator");
                System.out.println("5: Exit the Application");

                System.out.print("Enter the login option: ");
                int number = scanner.nextInt();  // Read integer input

                if (number == 1) {
                    Student_Functionalities.main(null);
                    //break;
                } else if (number == 2) {
                    Prof_Functionalities.main(null);
                    //break;
                } else if (number == 3) {
                    TA_Functionalities.main(null);
                    //break;
                } else if (number == 4) {
                    Admin_Functionalities.main(null);
                    //break;
                } else if (number == 5) {
                    System.out.println("Exiting the system...");
                    System.exit(0);
                } else {
                    System.out.println("Invalid login option, please try again");
                }
            }

            catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }

            catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }
    }
}