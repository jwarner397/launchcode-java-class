import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Created by Joseph on 5/6/2015.
 *
 * Code adapted from website https://docs.oracle.com/javase/tutorial/displayCode.html?code=https://docs.oracle.com/javase/tutorial/uiswing/examples/components/CheckBoxDemoProject/src/components/CheckBoxDemo.java
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
*/
public class MultiC_MultiA_Question extends Quiz_Question implements ItemListener {
    private String[] answerOptions;
    private JCheckBox choiceAButton;
    private JCheckBox choiceBButton;
    private JCheckBox choiceCButton;
    private JCheckBox choiceDButton;
    private JButton submitButton;
    private String userAnswer;
    private String[] choice = new String[4];
    private String answerBuffer;

    public MultiC_MultiA_Question(String question, String answer, String[] answerOptions) {
        super(question, answer);
        this.answerOptions = answerOptions;
        this.answer = answer;

    }

    public String[] getAnswerOptions() {
        return this.answerOptions;
    }

    public String getAnswer() {
        return this.answer;
    }

    public String getUserAnswer() {
        return this.userAnswer;
    }

    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }

    public String getAnswerBuffer() {
        return this.answerBuffer;
    }

    public boolean checkMCMAAnswer(String inputAnswer) {
        return (this.answer.equals(inputAnswer.toLowerCase()));
    }

    public void CreateMcMaDialog() {

        //In initialization code:
        choiceAButton = new JCheckBox(this.answerOptions[0]);
        choiceAButton.setSelected(false);

        choiceBButton = new JCheckBox(this.answerOptions[1]);
        choiceBButton.setSelected(false);

        choiceCButton = new JCheckBox(this.answerOptions[2]);
        choiceCButton.setSelected(false);

        choiceDButton = new JCheckBox(this.answerOptions[3]);
        choiceDButton.setSelected(false);

        JButton submitButton = new JButton("Submit");


        //Register a listener for the check boxes.
        choiceAButton.addItemListener(this);
        choiceBButton.addItemListener(this);
        choiceCButton.addItemListener(this);
        choiceDButton.addItemListener(this);
        submitButton.addItemListener(this);


        JPanel p = new JPanel(new GridLayout(0, 1));
        // JPanel p = new JPanel(new BorderLayout());
        JFrame frame = new JFrame("ReBootU Quiz");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setVisible(true);

        JLabel questionLabel = new JLabel(this.question);
        questionLabel.setFont(questionLabel.getFont().deriveFont(Font.ITALIC));

        frame.add(p, BorderLayout.LINE_START);
        p.add(questionLabel, BorderLayout.CENTER);
        // p.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));


        frame.add(p);
        p.add(choiceAButton);
        p.add(choiceBButton);
        p.add(choiceCButton);
        p.add(choiceDButton);
        p.add(submitButton, "South");

        /*if (submitButton.isSelected()) {
            this.userAnswer = this.answerBuffer;
            System.out.println(this.answerBuffer);
        }
        this.userAnswer = "hi"; //this.answerBuffer;*/
    }


    public void itemStateChanged(ItemEvent e) {
        Object source = e.getItemSelectable();

        this.answerBuffer = "";

        if (source == choiceAButton) {
            this.choice[0] = this.answerOptions[0];
        } else if (source == choiceBButton) {
            this.choice[1] = this.answerOptions[1];
        } else if (source == choiceCButton) {
            this.choice[2] = this.answerOptions[2];
        } else if (source == choiceDButton) {
            this.choice[3] = this.answerOptions[3];
        }

        /*if (e.getStateChange() == ItemEvent.DESELECTED) {
            //...make a note of it...
        }*/


        if (this.choice != null) {
            for (int j = 0; j < 4; j++) {
                if (this.choice[j] != null) {
                    this.answerBuffer = this.answerBuffer.concat(this.choice[j] + " ");
                }
            }

        }

        setUserAnswer(this.answerBuffer);

        System.out.println("answerBuffer = hey " + this.answerBuffer);

        if (source == submitButton) {
            setUserAnswer(this.answerBuffer);
            System.out.println("userAnswer =" + this.userAnswer);
        }

        this.userAnswer = this.answerBuffer;



    }







    public static void main(String args[]) {
        String[] eAnswerOptions = {"trash can", "bottle", "chair", "fan"};
        MultiC_MultiA_Question e = new MultiC_MultiA_Question("What is on the table?", "bottle, fan", eAnswerOptions);
        e.checkMCMAAnswer("bottle, fan,");
        e.CreateMcMaDialog();
        System.out.println(e.getAnswerBuffer());



    }

}

