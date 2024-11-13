import java.time.LocalDate;

public class Course {
    public String name;
    public String code;
    public String prof;
    public String timings;
    public int credits;
    public int semester;
    public String pre_req;
    public String misc_info;

    public int students_enrolled = 0;
    public int e_limit = 600;
    static LocalDate deadline = null;

    public Course(String name, String code, String prof, String timings, int semester, int Credits) {
        this.name = name;
        this.code = code;
        this.prof = prof;
        this.timings = timings;
        this.credits = Credits;
        this.semester = semester;
        this.pre_req = null;
        this.misc_info = null;
    }

    public void changeProfName(String newProf) {
        this.prof = newProf;
    }

    public int getE_limit() {
        return e_limit;
    }

    @Override
    public String toString() {
        return name;
    }
}