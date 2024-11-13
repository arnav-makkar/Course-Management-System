import java.util.*;
import custom_exceptions.*;

public class Prof_Functionalities implements Data, Human{
    public static void print_courses_assigned(Prof current_user){
        if(current_user.courses_assigned.isEmpty()){
            System.out.println("There are no courses assigned yet");
        }

        else{
            System.out.println("There are " + current_user.courses_assigned.size() + " courses assigned");

            for(int i = 0; i<current_user.courses_assigned.size(); i++){
                System.out.print(i+1 + ". ");
                System.out.println(current_user.courses_assigned.get(i).name);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nWelcome to the Professor Portal!");

        Prof arun = new Prof("Dr. Arun Balaji", "Arun123");
        Prof tammam = new Prof("Dr. Tammam Tillo", "Tammam123");

        Human.prof_list.add(arun);
        Human.prof_list.add(tammam);

        while(true){

            System.out.println("1. Login");
            System.out.println("2. Back");
            System.out.print("Enter Your Choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if(choice == 1) {
                System.out.print("Enter Name: ");
                String name = scanner.nextLine();
                System.out.print("Enter Password: ");
                String password = scanner.nextLine();

                Prof temp_check = new Prof(name, password);
                int user_check;
                Prof current_user;
                user_check = User.check_user_exists(temp_check);

                try {
                    if (user_check == 0) {
                        throw new InvalidLoginException("User cannot be found, please try again\nTry 'Dr. Arun Balaji, Arun123' or 'Dr. Tammam Tillo, Tammam123'");
                    }

                    else {
                        current_user = Human.prof_list.getFirst();
                        for (int i = 0; i < Human.prof_list.size(); i++) {
                            if (Objects.equals(Human.prof_list.get(i).name, name)) {
                                current_user = Human.prof_list.get(i);
                            }
                        }
                        System.out.println("\nHi " + current_user.getUsername());

                        while (true) {
                            System.out.println("Please choose any of the following options: ");
                            System.out.println("1. View Assigned Courses");
                            System.out.println("2. Update Assigned Course Details");
                            System.out.println("3. View Enrolled Students");
                            System.out.println("4. Update Course Enrollment Limit");
                            System.out.println("5. View Feedback");
                            System.out.println("6. Back");

                            System.out.print("Enter Option: ");
                            int option = scanner.nextInt();
                            scanner.nextLine();

                            if (option == 1) {
                                print_courses_assigned(current_user);
                            }
                            else if (option == 2) {

                                while (true) {
                                    System.out.println("Please choose any of the following options: ");
                                    System.out.println("1. Change Course Credits");
                                    System.out.println("2. Change Course Timings");
                                    System.out.println("3. Add/Change Pre-Requisite Courses");
                                    System.out.println("4. Add other miscellaneous details(syllabus, office hours, enrollment limits, etc)");
                                    System.out.println("5. Back");
                                    System.out.print("Enter Option: ");

                                    int option2 = scanner.nextInt();
                                    scanner.nextLine();

                                    if (option2 == 1) {
                                        print_courses_assigned(current_user);

                                        System.out.println("Enter option: ");
                                        int option3 = scanner.nextInt();
                                        scanner.nextLine();

                                        System.out.println("The number of credits for your selection is " + current_user.courses_assigned.get(option3 - 1).credits);
                                        System.out.println("Enter the number of credits: ");

                                        int cred_new = scanner.nextInt();
                                        scanner.nextLine();

                                        current_user.courses_assigned.get(option3 - 1).credits = cred_new;

                                        System.out.println("The number of credits have been updated");
                                    } else if (option2 == 2) {
                                        print_courses_assigned(current_user);

                                        System.out.println("Enter option: ");
                                        int option3 = scanner.nextInt();
                                        scanner.nextLine();

                                        System.out.println("Enter new timings: ");

                                        String timings_new = scanner.nextLine();

                                        current_user.courses_assigned.get(option3 - 1).timings = timings_new;

                                        System.out.println("The timings have been updated");
                                    } else if (option2 == 3) {
                                        print_courses_assigned(current_user);

                                        System.out.println("Enter option: ");
                                        int option3 = scanner.nextInt();
                                        scanner.nextLine();

                                        System.out.println("Enter pre-requisites: ");

                                        String pr_new = scanner.nextLine();

                                        current_user.courses_assigned.get(option3 - 1).pre_req = pr_new;

                                        System.out.println("The pre-requisites have been updated");
                                    } else if (option2 == 4) {
                                        print_courses_assigned(current_user);

                                        System.out.println("Enter option: ");
                                        int option3 = scanner.nextInt();
                                        scanner.nextLine();

                                        System.out.println("Enter miscellaneous details: ");

                                        String misc_new = scanner.nextLine();

                                        current_user.courses_assigned.get(option3 - 1).misc_info = misc_new;

                                        System.out.println("The miscellaneous details have been updated");
                                    } else if (option2 == 5) {
                                        break;
                                    } else {
                                        System.out.println("Invalid option, please try again");
                                    }
                                }
                            }
                            else if (option == 3) {

                                if (Human.student_list.isEmpty()) {
                                    System.out.println("There are no students yet");
                                }
                                else {
                                    int c = 0;
                                    for (int i = 0; i < Human.student_list.size(); i++) {
                                        for (int j = 0; j < Human.student_list.get(i).courses_taken.size(); j++) {
                                            if (current_user.courses_assigned.contains(Human.student_list.get(i).courses_taken.get(j))) {
                                                System.out.println(Human.student_list.get(i).name);
                                                c++;
                                                break;
                                            }
                                        }
                                    }

                                    if (c == 0) {
                                        System.out.println("There are no students enrolled yet");
                                    }
                                }
                            } else if (option == 4) {

                                print_courses_assigned(current_user);

                                System.out.println("Enter option: ");
                                int opt = scanner.nextInt();
                                scanner.nextLine();

                                System.out.println("Current enrollment limit for your selection is " + current_user.courses_assigned.get(opt - 1).getE_limit());

                                System.out.println("Enter new Enrollment Limit: ");
                                int elim = scanner.nextInt();
                                scanner.nextLine();

                                current_user.courses_assigned.get(opt - 1).e_limit = elim;

                                System.out.println("Enrollment Limit has been updated \n ");
                            }
                            else if (option == 5) {
                                int c = 0;
                                if(Data.feed_list.isEmpty()){
                                    System.out.println("There are no feedbacks yet");
                                }

                                else{
                                    for(int i = 0; i<feed_list.size(); i++){
                                        if(current_user.courses_assigned.contains(feed_list.get(i).course)){
                                            c++;
                                            feed_list.get(i).viewFeedback();
                                        }
                                    }

                                    if(c == 0){
                                        System.out.println("There are no feedbacks yet");
                                    }
                                }
                            }
                            else if (option == 6) {
                                break;
                            } else {
                                System.out.println("Invalid Option, please try again");
                            }
                        }
                        break;
                    }
                }

                catch (InvalidLoginException e) {
                    System.out.println(e.getMessage());
                }

            }

            else if(choice == 2){
                break;
            }

            else{
                System.out.println("Invalid Choice, please try again");
            }
        }
    }
}