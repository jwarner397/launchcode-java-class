/**
 * Created by Joseph on 5/4/2015.
 * Sub Class of class Student
 */
public class Full_Time_Student extends Student {
    private double tuition;

    public Full_Time_Student(String gender, int age, String homeTown, String firstName, String lastName, int studentID, int credits, double GPA){
        super(gender, age, homeTown, firstName, lastName, studentID, credits, GPA);
        this.tuition = 20000;
    }

    public double getTuition(){
        return this.tuition;
    }
}
