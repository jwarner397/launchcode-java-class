import org.junit.Test;

import junit.framework.TestCase;

/**
 * Created by Joseph on 5/5/2015.
 */
public class QuestionAndAnswerTest extends TestCase {
    @Test
    public void testQuestions() {
        String[] aAnswerOptions = {"red", "white", "blue", "green"};
        String[] aAnswer = {"white"};
        Multiple_Choice_Question a = new Multiple_Choice_Question("What color is the wall?", aAnswer, aAnswerOptions);
        String[] aInputAnswer = {"White"};
        assertEquals(1.0, a.checkAnswer(aInputAnswer));
        // assertEquals("white", a.createDialog());
        String[] bAnswer = {"trex"};
        Quiz_Question b = new Quiz_Question("What is the name of this building?", bAnswer);
        FITB_Question d = new FITB_Question("What is the name of this building?", bAnswer);
        String[] fAnswer = {"46"};
        FITB_Question f = new FITB_Question("How old are you?", fAnswer);
        assertEquals(1.0, f.checkAnswer("46"));
        // assertEquals("trex", d.createFitbDialog());
        assertEquals(1.0, d.checkAnswer("TreX"));
        // assertEquals("46", f.createFitbDialog());
        String[] eAnswerOptions = {"trash can", "bottle", "chair", "fan"};
        String[] eAnswer = {"bottle", "fan"};
        MultiCMultiAQuestion h = new MultiCMultiAQuestion("What is on the table?", eAnswer, eAnswerOptions);
        h.createDialog();
        assertEquals(true, h.checkAnswer("bottle,fan"));






    }
}
