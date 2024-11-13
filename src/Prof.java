import java.util.*;

public class Prof extends User{
    //public String name;
    //private String password;
    public ArrayList<Course> courses_assigned = new ArrayList<>();
    
    Prof(String name,String password){
        this.name=name;
        this.password=password;

        for(int i = 0; i<Data.sem_dir.size(); i++){
            for(int j = 0; j<Data.sem_dir.get(i).size(); j++){
                if(Data.sem_dir.get(i).get(j).prof.equals(name)){
                    courses_assigned.add(Data.sem_dir.get(i).get(j));
                }
            }
        }
    }
}