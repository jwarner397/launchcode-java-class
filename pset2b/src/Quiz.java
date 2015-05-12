/**
 * Created by Joseph on 5/11/2015.
 */
public class Quiz {
    private Quiz_Question[] quiz;

    public Quiz (Quiz_Question[] quiz) {
        this.quiz = quiz;

    }

    public Quiz_Question[] getQuiz() {
        return this.quiz;
    }

    public void administer() {
        int length = this.quiz.length;
        double correct = 0;
        for (int i = 0; i < length; i++) {
            String[] answer = this.quiz[i].createDialog();
            correct = correct + this.quiz[i].checkAnswer(answer[0]);
        }
        System.out.println("Your score is " + (correct/length * 100) + "%");

    }

    public static void main(String args[]) {
        String[] aAnswerOptions = new String[]{"trash can", "bottle", "chair", "fan"};
        String[] aAnswer = new String[] {"bottle", "fan"};
        MultiCMultiAQuestion a = new MultiCMultiAQuestion("What is on the table?", aAnswer, aAnswerOptions);
        String[] bAnswerOptions = {"red", "white", "blue", "green"};
        String[] bAnswer = {"white"};
        String[] cAnswer = {"46"};
        FITB_Question c = new FITB_Question("How old are you?", cAnswer);
        String[] dAnswer = {"trex"};
        Multiple_Choice_Question b = new Multiple_Choice_Question("What color is the wall?", bAnswer, bAnswerOptions);
        FITB_Question d = new FITB_Question("What is the name of this building?", dAnswer);
        Quiz_Question[] q = new Quiz_Question[]{a,b,c,d};
        Quiz quiz = new Quiz(q);
        quiz.administer();

    }



}
