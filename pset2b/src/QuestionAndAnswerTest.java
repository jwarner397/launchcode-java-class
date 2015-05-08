import org.junit.Test;

import junit.framework.TestCase;

/**
 * Created by Joseph on 5/5/2015.
 */
public class QuestionAndAnswerTest extends TestCase {
    @Test
    public void testQuestions() {
        String[] aAnswerOptions = {"red", "white", "blue", "green"};
        Multiple_Choice_Question a = new Multiple_Choice_Question("What color is the wall?", "white", aAnswerOptions);
        assertEquals(true, a.checkAnswer("White"));
        // assertEquals("white", a.createDialog());
        Quiz_Question b = new Quiz_Question("What is the name of this building?", "trex");
        FITB_Question d = new FITB_Question("What is the name of this building?", "trex");
        // assertEquals("trex", d.createFitbDialog());
        assertEquals(true, d.checkAnswer("TreX"));
        String[] eAnswerOptions = {"trash can", "bottle", "chair", "fan"};
        MCMAQuestion e = new MCMAQuestion("What is on the table?", "bottle fan", eAnswerOptions);
        assertEquals(true, e.checkMCMAAnswer("bottle fan"));
        // System.out.println("answerBuffer = " + e.getAnswerBuffer());
        assertEquals("bottle fan", e.createMCMADialog());
        // System.out.println("userAnswer = " + e.getUserAnswer());





    }
}
