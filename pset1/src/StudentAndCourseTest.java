import org.junit.Test;

import junit.framework.TestCase;

/**
 * JUnit tests for Student and Course
 * @author dshook
 *
 */
public class StudentAndCourseTest extends TestCase {
	@Test
	public void testStudentInit() {
		Student s = new Student("male", 32, "Washington", "Doug", "Shook", 111111, 0, 0);
		assertEquals("Doug Shook", s.getName());
		assertEquals(111111, s.getStudentID());
		//No credits, no GPA
		assertEquals(0.0, s.getGPA());
		assertEquals(0, s.getCredits());

        //Generate some random students, and test
		for (int i = 0; i < 20; ++i) {
			double a =  (Math.random() * 5000);
			double b =  (Math.random() * 5000);
			int c = (int)(Math.random() * 5000);
			Student s3 = new Student("", 22, "", "" + a, "" + b, c, 0, 0);
			assertEquals(a + " " + b, s3.getName());
			assertEquals(0.0, s3.getGPA());
			assertEquals(0, s3.getCredits());
		}
	}

	@Test
	 public void testStudentClass() {
		Student t = new Student("male", 46, "St Louis", "Joe", "Warner", 123456, 75, 4.0);
		assertEquals("Junior", t.getClassStanding());
		assertEquals(123456, t.getStudentID());
		//No credits, no GPA
		assertEquals(4.0, t.getGPA());
		assertEquals(75, t.getCredits());
		assertEquals(4.0, t.getGPA());
		assertEquals(75, t.getCredits());
		assertEquals("Joe Warner", t.getName());
		assertEquals("Joe Warner 123456", t.toString());
	}

	@Test
	public void testStudentLegacy() {
		Student f = new Student("male", 46, "St Louis", "Joe", "Warner", 123456, 120, 4.0);
		Student m = new Student("female", 45, "Affton", "Shelly", "Warner", 654321, 130, 3.0);
		Student c = m.createLegacy(f);
		assertEquals("ShellyWarner", c.getFirstName());
		assertEquals("JoeWarner", c.getLastName());
		assertEquals(3.5, c.getGPA());
		assertEquals(130, c.getCredits());
		}

	@Test
	public void testStudentGrade() {
		Student f = new Student("male", 46, "St Louis", "Joe", "Warner", 123456, 50, 4.0);
		assertEquals(66666.665, f.computeTuition());
		f.submitGrade(3, 3);
		assertEquals(3.943396226415094, f.getGPA());
	}

	@Test
	public void testCourseClass() {
		Student f = new Student("male", 46, "St Louis", "Joe", "Warner", 123456, 120, 4.0);
		Student m = new Student("female", 45, "Affton", "Shelly", "Warner", 654321, 130, 3.0);
		Course a = new Course("CS50", 3, 20, new Student[20]);
		assertEquals("CS50 3", a.toString());
		assertEquals(true, a.addStudent(f));
		assertEquals(true, a.addStudent(m));
		assertEquals(false, a.addStudent(f));
		a.printRoster();
		assertEquals(3.5, a.courseGPA());
		assertEquals(20, a.getNumberOfSeats());

	}

	@Test
	public void testSubClasses() {
		Student a = new Student("male", 46, "St Louis", "Joe", "Warner", 123456, 120, 4.0);
		Part_Time_Student c = new Part_Time_Student("male", 46, "St Louis", "Joe", "Warner", 123456, 120, 4.0);
		Full_Time_Student d = new Full_Time_Student("female", 42, "Affton", "Abby", "Warner", 654321, 70, 3.0);
		Course CS50 = new Course("CS50", 3, 20, new Student[20]);
		Course CS100 = new Course("CS100", 3, 20, new Student[20]);
		Instructor b = new Instructor("Shelly", "Warner", "female", 45, "Affton", "PhD", false, new Course[3]);
		assertEquals(true, CS50.addStudent(a));
		assertEquals(false, CS50.addStudent(a));
		assertEquals(true, b.addCourse(CS50));
		assertEquals(true, b.addCourse(CS100));
		assertEquals(20000.00, d.getTuition());
		assertEquals(36000.00, c.getTuition());
		assertEquals(true, CS100.addStudent(c));
		assertEquals("male", c.getGender());
		assertEquals(42, d.getAge());
		assertEquals("Affton", d.getHomeTown());

	}

	//More tests should go here

}


