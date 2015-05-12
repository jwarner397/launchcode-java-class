/**
 * Created by Joseph on 5/5/2015.
 */
public class Quiz_Question {
    private String question;
    private String[] answer;

    public Quiz_Question(String question, String[] answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return this.question;
    }

    public String[] getAnswer() {
        return this.answer;
    }

    public void setAnswer(String[] answer) {
        this.answer = answer;
    }

    public String[] createDialog () {
        System.out.println(this.question);

        return this.answer;
    }

    public double checkAnswer(String inputAnswer) {
        int answerLength = this.getAnswer().length;
        int count = 0;
        for (int i = 0; i < answerLength; i++){
            String lower = inputAnswer.toLowerCase();
            if (lower.equals(this.getAnswer()[i])) {
                return 1.0;
            }
        }
        return (0);
    }


}
