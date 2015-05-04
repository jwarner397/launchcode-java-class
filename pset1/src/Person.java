/**
 * Created by Joseph Warner on 5/1/2015.
 * Parent class for people in this program
 */
public class Person {
    protected String firstName;
    protected String lastName;
    protected String gender;
    protected int age;
    protected String homeTown;


    public Person(String firstName, String lastName, String gender, int age, String homeTown) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.homeTown = homeTown;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getGender() {
        return this.gender;
    }

    public int getAge() {
        return this.age;
    }

    public String getHomeTown() {
        return this.homeTown;
    }



}
