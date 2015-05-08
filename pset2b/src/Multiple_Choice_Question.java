import javax.swing.*;
import java.awt.event.ItemListener;

/**
 * Created by Joseph on 5/5/2015.
 */
public class Multiple_Choice_Question extends Quiz_Question {
    private String[] answerOptions;

    public Multiple_Choice_Question(String question, String answer, String[] answerOptions) {
        super(question, answer);
        this.answerOptions = answerOptions;
    }

    public String[] getAnswerOptions() {
        return this.answerOptions;
    }

    /* public void displayQuestion() {
        System.out.println(this.getQuestion());
        int arrLength = this.answerOptions.length;
        for (String answerOption : this.answerOptions) {
            System.out.println(answerOption);
        }
    } */

    public boolean checkAnswer(String inputAnswer) {
        return (this.getAnswer().equals(inputAnswer.toLowerCase()));
    }

    public String createDialog() {
        Object[] possibilities = this.answerOptions;
        String input = (String) JOptionPane.showInputDialog(
                null,
                this.getQuestion() + "\n",
                "ReBootU Quiz",
                JOptionPane.PLAIN_MESSAGE,
                null,
                possibilities,
                null);


        //If a string was returned, say so.
        if ((input != null) && (input.length() > 0)) {
            return input.toLowerCase();
        } else {
            //If you're here, the return value was null/empty.
            return (null);
        }
    }

    public static void main(String args[]) {
        String[] aAnswerOptions = new String[]{"red", "white", "blue", "green"};
        Multiple_Choice_Question a = new Multiple_Choice_Question(("What color is the wall?"), "blue", aAnswerOptions);
        // a.displayQuestion();
        a.checkAnswer("Blue");

    }





}
