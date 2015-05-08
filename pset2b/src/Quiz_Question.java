/**
 * Created by Joseph on 5/5/2015.
 */
public class Quiz_Question {
    protected String question;
    protected String answer;
    protected boolean evaluate;

    public Quiz_Question(String question, String answer) {
        this.question = question;
        this.answer = answer;
        this.evaluate = evaluate;
    }

    public String getQuestion() {
        return this.question;
    }

    /*public void setQuestion(String question) {
        this.question = question;
    }*/

    public String getAnswer() {
        return this.answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean getEvaluate() {
        return this.evaluate;
    }

    public void setEvaluate(boolean evaluate) {
        this.evaluate = evaluate;
    }

    public void displayQuestion (Quiz_Question question) {
        System.out.println(this.question);
    }


}
