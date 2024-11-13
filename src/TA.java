public class TA extends Student{
    public Course course_assigned;

    TA(String name, String password, Course course) {
        super(name, password);

        Student student = new Student(name, password);
        Human.student_list.add(student);

        this.course_assigned = course;
    }

    TA(String name, String password) {
        super(name, password);

        Student student = new Student(name, password);
        Human.student_list.add(student);
    }

    @Override
    public String toString() {
        return "Name: " + getUsername() + "\nCourse Assigned: " + course_assigned;
    }
}