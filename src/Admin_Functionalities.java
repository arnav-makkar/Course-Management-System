import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import custom_exceptions.*;

public class Admin_Functionalities implements Data, Human{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nWelcome to the Administrator Portal!");

        Admin admin = new Admin("1234");

        while(true) {

            try {
                System.out.print("Enter admin password: ");
                String password_entered = scanner.nextLine();

                if(!Objects.equals(password_entered, admin.getPassword())) {
                    throw new InvalidLoginException("Incorrect password, please try again.\nPassword = 1234");
                }

                else{
                    System.out.println("\nYou have successfully logged in!\n");

                    while (true) {

                        System.out.println("Please choose any of the following options: ");
                        System.out.println("1. Manage Course Catalog");
                        System.out.println("2. Manage Student Records");
                        System.out.println("3. Assign Professors to Courses");
                        System.out.println("4. Handle Complaints");
                        System.out.println("5. Change Add/Drop Deadline");
                        System.out.println("6. Exit");
                        System.out.println("Enter your choice: ");

                        int choice = scanner.nextInt();
                        scanner.nextLine();

                        if (choice == 1) {
                            System.out.println("Enter semester: ");
                            int chosen_sem = scanner.nextInt();
                            scanner.nextLine();

                            int indx = chosen_sem - 1;

                            while (true) {
                                System.out.println("Please choose one of the following options: ");
                                System.out.println("1. View Courses");
                                System.out.println("2. Add Courses");
                                System.out.println("3. Delete Courses");
                                System.out.println("4. Back");
                                System.out.println("Enter your choice: ");

                                int optn = scanner.nextInt();
                                scanner.nextLine();

                                if(optn == 1){
                                    for (int i = 0; i < Data.sem_dir.get(indx).size(); i++) {
                                        System.out.print(i + 1 + ". ");
                                        System.out.println(Data.sem_dir.get(indx).get(i).name);
                                    }
                                }

                                else if (optn == 2) {
                                    System.out.println("Enter Course Title: ");
                                    String course_title = scanner.nextLine();

                                    System.out.println("Enter Course Code: ");
                                    String course_code = scanner.nextLine();

                                    System.out.println("Enter Professor Name: ");
                                    String professor_name = scanner.nextLine();

                                    System.out.println("Enter Timings: ");
                                    String timings = scanner.nextLine();

                                    System.out.println("Enter Semester: ");
                                    int semester = scanner.nextInt();
                                    scanner.nextLine();

                                    System.out.println("Enter Course Credits: ");
                                    int course_credits = scanner.nextInt();
                                    scanner.nextLine();

                                    //  System.out.println("Enter course name variable: ");
                                    //  String course_name_variable = scanner.nextLine();
                                    //  scanner.nextLine();

                                    Course course_identifier = new Course(course_title, course_code, professor_name, timings, semester, course_credits);
                                    //Course IP = new Course("Introduction to Programming", "CSE101", "Dr. BN Jain", "9:00am-10:30am on Monday and Wednesday", 1, 4);

                                    Data.sem_dir.get(indx).add(course_identifier);

                                    System.out.println("Course has been added!");
                                }
                                else if (optn == 3) {
                                    for (int i = 0; i < Data.sem_dir.get(indx).size(); i++) {
                                        System.out.print(i + 1 + ". ");
                                        System.out.println(Data.sem_dir.get(indx).get(i).name);
                                    }

                                    System.out.print("Enter the course you want to delete: ");
                                    int del_ind = scanner.nextInt();
                                    scanner.nextLine();

                                    Data.sem_dir.get(indx).remove(del_ind - 1);

                                    System.out.println("Course has been deleted from catalogue!");
                                }

                                else if (optn == 4) {
                                    break;
                                }

                                else {
                                    System.out.println("Invalid choice, please try again");
                                }
                            }
                        }

                        else if (choice == 2) {
                            while (true) {
                                System.out.println("Please choose one of the following options: ");
                                System.out.println("1. View Students");
                                System.out.println("2. Update Student Grades");
                                System.out.println("3. Change Student Name");
                                System.out.println("4. Back");
                                System.out.println("Enter your choice: ");

                                int optn = scanner.nextInt();
                                scanner.nextLine();

                                if (optn == 1) {
                                    if (Human.student_list.isEmpty()) {
                                        System.out.println("There are no students to display");
                                    } else {
                                        System.out.println("There are " + Human.student_list.size() + " students to display");
                                        for (int i = 0; i < Human.student_list.size(); i++) {
                                            System.out.print(i + 1 + ". ");
                                            System.out.println(Human.student_list.get(i).name);
                                        }
                                    }
                                } else if (optn == 2) {

                                    if (Human.student_list.isEmpty()) {
                                        System.out.println("There are no students to display");
                                    } else {
                                        System.out.println("There are " + Human.student_list.size() + " students to display");
                                        for (int i = 0; i < Human.student_list.size(); i++) {
                                            System.out.print(i + 1 + ". ");
                                            System.out.println(Human.student_list.get(i).name);
                                        }

                                        System.out.print("Select the student for whom you want to assign the grades: ");
                                        int snum = scanner.nextInt();
                                        scanner.nextLine();

                                        if (Human.student_list.get(snum - 1).courses_taken.isEmpty()) {
                                            System.out.println("The student has not selected any courses");
                                        } else {
                                            for (int i = 0; i < Human.student_list.get(snum - 1).courses_taken.size(); i++) {

                                                String course_name = Human.student_list.get(snum - 1).courses_taken.get(i).name;

                                                System.out.print("Enter grade for " + course_name + ": ");
                                                Float grade = scanner.nextFloat();
                                                scanner.nextLine();

                                                Human.student_list.get(snum - 1).grades_map.put(Human.student_list.get(snum - 1).courses_taken.get(i), grade);
                                            }
                                            System.out.println("The grades have been assigned!");
                                            Human.student_list.get(snum - 1).grades_assigned = 1;
                                        }
                                    }
                                } else if (optn == 3) {
                                    if (Human.student_list.isEmpty()) {
                                        System.out.println("There are no students to display");
                                    } else {
                                        System.out.println("Please choose one of the following options: ");
                                        for (int i = 0; i < Human.student_list.size(); i++) {
                                            System.out.print(i + 1 + ". ");
                                            System.out.println(Human.student_list.get(i).name);
                                        }

                                        System.out.print("Enter option: ");
                                        int optn2 = scanner.nextInt();
                                        scanner.nextLine();

                                        System.out.println("Enter new name for " + Human.student_list.get(optn2 - 1).name + " : ");
                                        String new_name = scanner.nextLine();

                                        Human.student_list.get(optn2 - 1).name = new_name;

                                        System.out.println("Name has been updated!");
                                    }
                                } else if (optn == 4) {
                                    break;
                                } else {
                                    System.out.println("Invalid choice, please try again");
                                }
                            }
                        } else if (choice == 3) {
                            System.out.println("Enter semester: ");
                            int chosen_sem = scanner.nextInt();
                            scanner.nextLine();

                            int indx = chosen_sem - 1;

                            System.out.println("The courses offered in this semester are as follows: ");
                            int i;

                            for (i = 0; i < Data.sem_dir.get(indx).size(); i++) {
                                System.out.print(i + 1 + ". ");
                                System.out.println(Data.sem_dir.get(indx).get(i).name);
                            }

                            System.out.println((i + 1) + ". " + "Back");

                            System.out.println("Enter Option: ");
                            int option = scanner.nextInt();
                            scanner.nextLine();

                            if (option == i + 1) {
                                continue;
                            } else if (option <= i) {
                                System.out.println("Enter professor name: ");

                                String newname = scanner.nextLine();
                                Data.sem_dir.get(indx).get(i-1).changeProfName(newname);

                                System.out.println("Professor has been assigned!");
                            } else {
                                System.out.println("Invalid option, please try again");
                            }
                        } else if (choice == 4) {
                            while (true) {
                                System.out.println("Please choose one of the following options: ");
                                System.out.println("1. View All Complaints");
                                System.out.println("2. View Pending Complaints");
                                System.out.println("3. Resolve Pending Complaints");
                                System.out.println("4. Back");
                                System.out.println("Enter your choice: ");

                                int optn = scanner.nextInt();
                                scanner.nextLine();

                                if (optn == 1) {
                                    if (ComplaintSystem.complaints.isEmpty()) {
                                        System.out.println("There are no complaints to display");
                                    } else {
                                        System.out.println("There are " + ComplaintSystem.complaints.size() + " complaints to display");

                                        for (int i = 0; i < ComplaintSystem.complaints.size(); i++) {
                                            System.out.println("Complaint ID: " + ComplaintSystem.complaints.get(i).getComplaintID());
                                            System.out.println("Student ID: " + ComplaintSystem.complaints.get(i).getStudentID());
                                            System.out.println("Complaint Description: " + ComplaintSystem.complaints.get(i).getDescription());
                                            System.out.println("Complaint Status: " + ComplaintSystem.complaints.get(i).getStatus());
                                        }
                                    }
                                } else if (optn == 2) {
                                    int c = 0;
                                    for (int i = 0; i < ComplaintSystem.complaints.size(); i++) {
                                        if (ComplaintSystem.complaints.get(i).getStatus() == "Pending") {
                                            System.out.println("Complaint ID: " + ComplaintSystem.complaints.get(i).getComplaintID());
                                            System.out.println("Student ID: " + ComplaintSystem.complaints.get(i).getStudentID());
                                            System.out.println("Complaint Description: " + ComplaintSystem.complaints.get(i).getDescription());

                                            c++;
                                        }
                                    }

                                    if (c == 0) {
                                        System.out.println("There are no pending complaints");
                                    }
                                } else if (optn == 3) {

                                    int c = 0;
                                    for (int i = 0; i < ComplaintSystem.complaints.size(); i++) {
                                        if (ComplaintSystem.complaints.get(i).getStatus() == "Pending") {
                                            System.out.println("Serial Number: " + (int) (i + 1));
                                            System.out.println("Complaint ID: " + ComplaintSystem.complaints.get(i).getComplaintID());
                                            System.out.println("Student ID: " + ComplaintSystem.complaints.get(i).getStudentID());
                                            System.out.println("Complaint Description: " + ComplaintSystem.complaints.get(i).getDescription());

                                            c++;
                                        }
                                    }

                                    if (c == 0) {
                                        System.out.println("There are no pending complaints");
                                    } else {
                                        System.out.println("Enter the serial number: ");
                                        int num = scanner.nextInt();
                                        scanner.nextLine();

                                        ComplaintSystem.complaints.get(num - 1).setStatus("Resolved");

                                        System.out.println("Complaint with ID: " + ComplaintSystem.complaints.get(num - 1).getComplaintID() + " has been successfully resolved");
                                    }
                                } else if (optn == 4) {
                                    break;
                                } else {
                                    System.out.println("Invalid choice, please try again");
                                }
                            }
                        } else if (choice == 5) {

                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

                            if (Course.deadline == null) {
                                System.out.println("Course Add/Drop Deadline has not been added yet");
                            }
                            else {
                                System.out.println("Current Add/Drop Deadline is " + Course.deadline.format(formatter));
                            }

                            while (true) {
                                try {
                                    System.out.print("Enter a date (dd-MM-yyyy): ");
                                    String dateInput = scanner.nextLine();

                                    LocalDate date = LocalDate.parse(dateInput, formatter);

                                    Course.deadline = date;
                                    System.out.println("Course Add/Drop Deadline has been updated to: " + date.format(formatter));

                                    break;
                                } catch (DateTimeParseException e) {
                                    System.out.println("Invalid date, please try again");
                                }
                            }
                        } else if (choice == 6) {
                            break;
                        } else {
                            System.out.println("Invalid choice, please try again");
                        }
                    }

                    break;
                }
            }

            catch(InvalidLoginException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}