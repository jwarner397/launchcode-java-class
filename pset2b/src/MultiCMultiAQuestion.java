import java.util.Scanner;
/**
 * Created by Joseph on 5/11/2015.
 */
public class MultiCMultiAQuestion extends Quiz_Question {
    private String[] answerOptions;

    public MultiCMultiAQuestion(String question, String[] answer, String[] answerOptions) {
        super(question, answer);
        this.answerOptions = answerOptions;
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
        Scanner scan = new Scanner(System.in);
        System.out.println(this.getQuestion());
        for (String answerOption : this.answerOptions) {
            System.out.println(answerOption);
        }
        System.out.println("Enter your answer(s)");
        String input = scan.nextLine();
        return input.split(",");

    }

    public static void main(String args[]) {
        String[] aAnswerOptions = new String[]{"trash can", "bottle", "chair", "fan"};
        String[] aAnswer = new String[] {"bottle","fan"};
        MultiCMultiAQuestion a = new MultiCMultiAQuestion("What is on the table?", aAnswer, aAnswerOptions);
        // a.createDialog();
        // Scanner scan = new Scanner(System.in);
        String[] input = a.createDialog();
        double correct = a.checkAnswer(input);
        // double correct = a.checkAnswer(aAnswer);
        System.out.println(correct);
    }

}
