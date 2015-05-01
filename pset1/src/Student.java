/**
 * Created by Joseph Warner on 4/28/2015.
 */
public class Student {

    private String firstName;
    private String lastName;
    private int studentID;
    private int credits;
    private double GPA;

    public Student(String firstName, String lastName, int studentID, int credits, double GPA) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentID = studentID;
        this.credits = credits;
        this.GPA = GPA;
    }

    // second constructor for creating legacy students
    public Student(Student mother, Student father) {
        this.firstName = mother.firstName.concat(mother.lastName);
        this.lastName = father.firstName.concat(father.lastName);
        this.studentID = (int)(Math.random() * 500000);
        this.credits = legacyCredits(mother, father);
        this.GPA =(mother.GPA + father.GPA)/2;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getStudentID() {
        return this.studentID;
    }

    public int getCredits() {
        return this.credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public double getGPA() {
        return this.GPA;
    }

    public void setGPA(double gpa) {
        this.GPA = gpa;
    }

    // calls legacy constructor and builds legacy student info
    public Student createLegacy(Student father) {
        return new Student(this, father);
    }

    // returns the number of credits a legacy student has based on mother's and father's credits attained
    public int legacyCredits(Student mother, Student father) {
        if (mother.credits > father.credits) {
            return mother.credits;
        } else {
            return father.credits;
        }
    }

    // returns concatenation of a student's first and last names into one string
    public String getName() {
        this.firstName = getFirstName();
        this.lastName = getLastName();
        return (this.firstName + " " + this.lastName);
    }

    // returns concatenation of a student's name and student ID number
    public String toString() {
        this.studentID = getStudentID();
        String fullName = getName();
        String idNumber = Integer.toString(this.studentID);
        return (fullName + " ".concat(idNumber));
    }

    // returns a student's class standing based on number of credits
    public String getClassStanding() {
        this.credits = getCredits();
        String classStanding;
        if (this.credits <= 30) {
            classStanding = "Freshman";
        } else if (this.credits > 30 && this.credits <= 60) {
            classStanding = "Sophomore";
        } else if (this.credits > 60 && this.credits <= 90) {
            classStanding = "Junior";
        } else {
            classStanding = "Senior";
        }
        return classStanding;
    }

    // returns the amount of tuition a student has incurred
    public double computeTuition() {
        this.credits = getCredits();
        double hourlyTuition = 1333.3333;
        return (this.credits * hourlyTuition);
    }

    // sets a student's GPA based on current GPA modified with a new course's credits and grade
    public void submitGrade(double grade, int courseCredits) {
        double newQualityPoints = courseCredits * grade;
        double qualityPoints = ((getGPA() * getCredits()) + newQualityPoints);
        setCredits(getCredits() + courseCredits);
        double gpa = (qualityPoints / getCredits());
        setGPA(gpa);
    }

    public static void main(String args[]) {
        // Create too many students for the course
        Student a = new Student("Joe", "Warner", 123456, 100, 4.0);
        Student b = new Student("Shelly", "Warner", 789012, 30, 4.0);
        Student c = new Student("Jeff", "Jones", 345678, 30, 2.1);
        Student d = new Student("Brett", "Smith", 901234, 87, 3.2);
        Student e = new Student("Brian", "Davis", 567890, 90, 1.9);
        Student f = new Student("Karen", "Warner", 212345, 67, 4.0);
        Student g = new Student("Melissa", "Fletcher", 223456, 60, 3.0);
        Student h = new Student("Chris", "Bay", 334567, 50, 3.0);
        Student i = new Student("Jessie", "Levine", 445678, 15, 3.0);
        Student j = new Student("LeAnn", "Jacobs", 556789, 25, 3.0);
        Student k = new Student("Tonya", "Harding", 667890, 35, 3.0);
        Student l = new Student("Abby", "Warner", 112345, 65, 4.0);
        Student m = new Student("Madeline", "Warner", 112367, 88, 4.0);
        Student n = new Student("Sheryl", "Boerding", 998765, 15, 3.0);
        Student o = new Student("Keith", "Boerding", 897654, 30, 3.0);
        Student p = new Student("Sammi", "Beording", 867530, 30, 2.0);
        Student q = new Student("Critter", "Beording", 913985, 45, 2.0);
        Student r = new Student("Terri", "Warner", 823746, 100, 2.0);
        Student s = new Student("Bill", "Gates", 192837, 90, 2.5);
        Student t = new Student("Stuart", "Little", 909090, 25, 3.7);
        Student u = new Student("Dustin", "Hoffman", 808080, 15, 4.0);

        // create a new course
        Course CS50 = new Course("CS50", 3, 20, new Student[20]);

        // add the students to the course
        CS50.addStudent(a);
        CS50.addStudent(b);
        CS50.addStudent(c);
        CS50.addStudent(d);
        CS50.addStudent(e);
        CS50.addStudent(f);
        CS50.addStudent(g);
        CS50.addStudent(h);
        CS50.addStudent(i);
        CS50.addStudent(j);
        CS50.addStudent(k);
        CS50.addStudent(l);
        CS50.addStudent(m);
        CS50.addStudent(n);
        CS50.addStudent(o);
        CS50.addStudent(p);
        CS50.addStudent(q);
        CS50.addStudent(r);
        CS50.addStudent(s);
        CS50.addStudent(t);
        CS50.addStudent(u);

        // print out the course's average GPA
        System.out.println(CS50.courseGPA());

        // print the class roster
        CS50.printRoster();

        // create a legacy student
        Student legacy = k.createLegacy(s);

        // access the new legacy student and print out some info
        System.out.println(legacy.toString() + " " + legacy.getGPA());

    }

}
