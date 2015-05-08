import javax.swing.*;

/**
 * Created by Joseph on 5/5/2015.
 */
public class FITB_Question extends Quiz_Question {
    private Quiz_Question question;

    public FITB_Question(String question, String answer) {
        super(question, answer);
    }

    public String getAnswer() {
        return this.answer;
    }

    public boolean checkAnswer(String inputAnswer) {
        return (this.getAnswer().equals(inputAnswer.toLowerCase()));
    }

    public String createFitbDialog() {
        String input = (String) JOptionPane.showInputDialog(
                null,
                this.getQuestion() + "\n",
                "ReBootU Quiz",
                JOptionPane.PLAIN_MESSAGE,
                null,
                null,
                null);


        //If a string was returned, say so.
        if ((input != null) && (input.length() > 0)) {
            return input.toLowerCase();
        } else {

            //If you're here, the return value was null/empty.
            return (null);
        }
    }
}
