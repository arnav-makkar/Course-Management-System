import custom_exceptions.InvalidLoginException;
import java.util.*;

public class TA_Functionalities {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nWelcome to the Teaching Assistant Portal!");

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

                TA temp_check = new TA(name, password);
                int user_check;
                TA current_user;
                user_check = User.check_user_exists(temp_check);

                try {
                    if (user_check == 0) {
                        throw new InvalidLoginException("User cannot be found, please try again\nTry 'Aayush Mishra, Aayush123'");
                    }

                    else {
                        current_user = Human.ta_list.getFirst();
                        for (int i = 0; i < Human.ta_list.size(); i++) {
                            if (Objects.equals(Human.ta_list.get(i).name, name)) {
                                current_user = Human.ta_list.get(i);
                            }
                        }
                        System.out.println("\nHi " + current_user.getUsername());

                        while (true) {
                            System.out.println("Please choose any of the following options: ");
                            System.out.println("1. View Enrolled Students");
                            System.out.println("2. Update Grades");
                            System.out.println("3. View Profile");
                            System.out.println("4. Back");

                            System.out.print("Enter Option: ");
                            int option = scanner.nextInt();
                            scanner.nextLine();

                            if(option == 1){

                                if(Human.student_list.isEmpty()) {
                                    System.out.println("There are no students yet");
                                }

                                else {
                                    int c = 0;
                                    for (int i = 0; i < Human.student_list.size(); i++) {
                                        if(Human.student_list.get(i).courses_taken.contains(current_user.course_assigned)) {
                                            c++;
                                            System.out.println(Human.student_list.get(i).getUsername());
                                        }
                                    }

                                    if (c == 0) {
                                        System.out.println("There are no students enrolled yet");
                                    }
                                }
                            }

                            else if(option == 2){

                                int c = 1;
                                int i;

                                if(Human.student_list.isEmpty()) {
                                    System.out.println("There are no students yet");
                                }

                                else {
                                    for (i = 0; i < Human.student_list.size(); i++) {
                                        if(Human.student_list.get(i).courses_taken.contains(current_user.course_assigned) && Human.student_list.get(i).grades_assigned != 0) {
                                            System.out.println(i+1 + ". " + Human.student_list.get(i).getUsername() + " -> " + Human.student_list.get(i).grades_map.get(current_user.course_assigned));
                                            c++;
                                        }
                                    }

                                    if (c == 1) {
                                        System.out.println("Grades have not been asssigned yet");
                                    }

                                    else{
                                        System.out.println("Enter the student number: ");
                                        int opt = scanner.nextInt();
                                        scanner.nextLine();

                                        System.out.println("Enter new grade: ");
                                        float n_grade = scanner.nextInt();
                                        scanner.nextLine();

                                        Human.student_list.get(opt-1).grades_map.put(current_user.course_assigned, n_grade);

                                        System.out.println("Grade has been successfully updated!");
                                    }
                                }
                            }

                            else if(option == 3){
                                System.out.println(current_user.toString());
                            }

                            else if(option == 4){
                                break;
                            }
                        }
                    }

                    break;
                }
                catch (InvalidLoginException e){
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