import java.util.*;

public interface Data {

    ArrayList<Feedback> feed_list = new ArrayList<>();

    ArrayList<Course> sem1 = new ArrayList<>();
    ArrayList<Course> sem2 = new ArrayList<>();
    ArrayList<Course> sem3 = new ArrayList<>();

    ArrayList<ArrayList<Course>> sem_dir = new ArrayList<>(
            Arrays.asList(sem1, sem2, sem3)
    );
}