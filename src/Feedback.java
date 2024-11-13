import java.util.*;

class Feedback<T> {

    public List<T> feedbacks;

    public Course course;
    public String student_name;

    public Feedback(Course course, String name) {
        this.student_name = name;
        this.course = course;
        feedbacks = new ArrayList<>();
    }

    public void addFeedback(T feedback) {
        feedbacks.add(feedback);
    }

    public void viewFeedback() {
        System.out.println("Name: " + student_name + "\nCourse: " + course.name);
        for (T feedback : feedbacks) {
            System.out.println(feedback);
        }

        System.out.println();
    }
}