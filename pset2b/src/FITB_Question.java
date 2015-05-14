import javax.swing.*;

/**
 * Created by Joseph on 5/5/2015.
 */
public class FITB_Question extends Quiz_Question {
    private Quiz_Question question;

    public FITB_Question(String question, String[] answer) {
        super(question, answer);
    }

    public double checkAnswer(String[] inputAnswer) {
        int answerLength = this.getAnswer().length;
        for (int i = 0; i < answerLength; i++){
            String lower = inputAnswer[0].toLowerCase();
            if (lower.equals(this.getAnswer()[i])) {
                    return 1.0;
            }
        }
        return (0);
    }

    public String[] createDialog() {
        String input = (String) JOptionPane.showInputDialog(
                null,
                this.getQuestion() + "\n",
                "ReBootU Quiz",
                JOptionPane.PLAIN_MESSAGE,
                null,
                null,
                null);


        //If a string was returned, say so.
        try {
            String answer = input.toLowerCase();
            return new String[]{answer};
        } catch(NullPointerException e) {
            //If you're here, the return value was null/empty.
            JOptionPane.showMessageDialog(null, "Wrong answer!", "Error", JOptionPane.INFORMATION_MESSAGE);
            String answer = "";
            return new String[]{answer};
        }
    }
}
