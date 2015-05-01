
/**
 * Created by Joseph on 4/28/2015.
 */
public class Course {
    private String courseName;
    private int courseCredits;
    private int numberOfSeats;
    private Student[] studentRoster;

    public Course(String courseName, int courseCredits, int numberOfSeats, Student[] studentRoster) {
        this.courseName = courseName;
        this.courseCredits = courseCredits;
        this.numberOfSeats = numberOfSeats;
        this.studentRoster = studentRoster;
    }

    public String getCourseName() {
        return this.courseName;
    }

    public int getCourseCredits() {
        return this.courseCredits;
    }

    public int getNumberOfSeats() {
        return this.numberOfSeats;
    }

    // returns a string of the course name and number of credits
    public String toString() {
        this.courseName = getCourseName();
        String credits = Integer.toString(getCourseCredits());
        return (getCourseName() + " ".concat(credits));
    }

    // returns a true value if a student is successfully added to a course
    public boolean addStudent(Student student) {
            int length = (this.studentRoster.length);
            boolean result = false;
            for (int i = 0; i < length; i++) {
                if (student == this.studentRoster[i]) {
                    System.out.println(student.getName() + " is already registered for this course.");
                    return false;
                } else if (studentRoster[i] == null) {
                    this.studentRoster[i] = student;
                    return true;
                }
            }
            if (!result) {
                System.out.println("Sorry, this class is full!");
            }
        return (result);
    }

    // prints roster of student names for a given class
    public void printRoster() {
        System.out.println(this.courseName + "Student Roster");
        for (int k = 0; k < this.studentRoster.length; k++){
            if (this.studentRoster[k] != null) {
                System.out.println(this.studentRoster[k].getName());
            }

        }
    }

    // returns average GPA for all students in a given class
    public double courseGPA() {

        double groupScore = 0;
        int numberOfStudents = 0;
        for (int m = 0; m < this.studentRoster.length; m++) {
            if (this.studentRoster[m] != null) {
                numberOfStudents++;
                groupScore = groupScore + studentRoster[m].getGPA();
            }
        }
        return (groupScore / numberOfStudents);
    }

}
