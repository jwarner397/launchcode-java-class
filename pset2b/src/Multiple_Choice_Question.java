import javax.swing.*;
import java.awt.event.ItemListener;
import java.util.List;
import java.io.*;
/**
 * Created by Joseph on 5/5/2015.
 */
public class Multiple_Choice_Question extends Quiz_Question {
    private String[] answerOptions;

    public Multiple_Choice_Question(String question, String[] answer, String[] answerOptions) {
        super(question, answer);
        this.answerOptions = answerOptions;
    }

    public String[] getAnswerOptions() {
        return this.answerOptions;
    }

    public double checkAnswer(String[] inputAnswer) {
        int inputLength = inputAnswer.length;
        int answerLength = this.getAnswer().length;
        int count = 0;
        for (int i = 0; i < answerLength; i++){
            for (int j = 0; j < inputLength; j++) {
                String lower = inputAnswer[j].toLowerCase();
                if (lower.equals(this.getAnswer()[i])) {
                    count++;
                }
            }
        }
        return (count/answerLength);
    }

    @Override
    public String[] createDialog() {
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
            String answer = input.toLowerCase();
            return new String[]{answer};
        } else {
            //If you're here, the return value was null/empty.
            return (null);
        }
    }

    public static void main(String args[]) {
        String[] aAnswerOptions = new String[]{"red", "white", "blue", "green"};
        String[] aAnswers = {"blue"};
        Multiple_Choice_Question a = new Multiple_Choice_Question(("What color is the wall?"), aAnswers, aAnswerOptions);
        // a.displayQuestion();
        String[] aInputAnswer = {"Blue"};
        a.checkAnswer(aInputAnswer);

    }





}
