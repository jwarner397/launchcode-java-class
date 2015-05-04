/**
 * Created by Joseph on 5/4/2015.
 * Sub Class of class Student
 */
public class Part_Time_Student extends Student {
    private double tuition;

    public Part_Time_Student(String gender, int age, String homeTown, String firstName, String lastName, int studentID, int credits, double GPA){
        super(gender, age, homeTown, firstName, lastName, studentID, credits, GPA);
        this.tuition = 300 * this.credits;
    }

    public double getTuition(){
        return this.tuition;
    }

}
