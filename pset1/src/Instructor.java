/**
 * Created by Joseph Warner on 5/1/2015.
 * Sub Class of class Person
 */
public class Instructor extends Person {

    private String degreeType;
    private boolean tenure;
    private Course[] courseLoad;

    public Instructor(String firstName, String lastName, String gender, int age, String homeTown, String degreeType, boolean tenure, Course[] courseLoad) {
        super(firstName, lastName, gender, age, homeTown);
        this.degreeType = degreeType;
        this.tenure = tenure;
        this.courseLoad = courseLoad;
    }

    public String getDegreeType() {
        return this.degreeType;
    }

    public void setDegreeType(String degreeType) {
        this.degreeType = degreeType;
    }

    public boolean getTenure() {
        return this.tenure;
    }

    public void setTenure(boolean tenure) {
        this.tenure = tenure;
    }

    public Course[] getCourseLoad() {
        return this.courseLoad;
    }

    // returns a true value if a course is successfully added to an instructor's course load
    public boolean addCourse(Course course) {
        int length = (this.courseLoad.length);
        boolean result = false;
        for (int i = 0; i < length; i++) {
            if (course == this.courseLoad[i]) {
                System.out.println(course.getCourseName() + " is already slated for this course.");
                return false;
            } else if (courseLoad[i] == null) {
                this.courseLoad[i] = course;
                return true;
            }
        }
        if (!result) {
            System.out.println("Sorry, this instructor has too many courses!");
        }
        return (result);

    }
}
