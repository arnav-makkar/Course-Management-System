abstract class User {
    public String name;
    public String password;

    public String getPassword() {
        return password;
    }
    public String getUsername() {
        return name;
    }

    // Polymorphism
    static int check_user_exists(Student student){
        int return_val = 0;

        for(int i = 0; i < Human.student_list.size(); i++){
            if(Human.student_list.get(i).getUsername().equals(student.getUsername()) && Human.student_list.get(i).getPassword().equals(student.getPassword())){
                return_val = 1;
                return return_val;
            }
        }
        return return_val;
    }

    static int check_user_exists(Prof prof){
        int return_val = 0;

        for(int i = 0; i < Human.prof_list.size(); i++){
            if(Human.prof_list.get(i).getUsername().equals(prof.getUsername()) && Human.prof_list.get(i).getPassword().equals(prof.getPassword())){
                return_val = 1;
                return return_val;
            }
        }
        return return_val;
    }

    static int check_user_exists(TA ta){
        int return_val = 0;

        for(int i = 0; i < Human.ta_list.size(); i++){
            if(Human.ta_list.get(i).getUsername().equals(ta.getUsername()) && Human.ta_list.get(i).getPassword().equals(ta.getPassword())){
                return_val = 1;
                return return_val;
            }
        }
        return return_val;
    }
}