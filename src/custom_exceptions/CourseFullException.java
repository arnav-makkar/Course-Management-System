package custom_exceptions;

public class CourseFullException extends Exception{
    public CourseFullException(String message){
        super(message);
    }
}