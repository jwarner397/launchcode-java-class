import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import static com.sun.javafx.fxml.expression.Expression.add;


/**
 * Created by Joseph on 5/8/2015.
 */
public class MCMAQuestion extends Multiple_Choice_Question implements ItemListener {
    private String[] answerOptions;
    // private JCheckBox choiceAButton;
    // private JCheckBox choiceBButton;
    // private JCheckBox choiceCButton;
    // private JCheckBox choiceDButton;
    // private JLabel questionLabel;
    // private String[] choices;
    // private String answerBuffer;

    public MCMAQuestion(String question, String answer, String[] answerOptions) {

        super(question, answer, answerOptions);
        this.answerOptions = answerOptions;
        /*this.choiceAButton = choiceAButton;
        this.choiceBButton = choiceBButton;
        this.choiceCButton = choiceCButton;
        this.choiceDButton = choiceDButton;

        this.choices = new String[4];
        this.questionLabel = new JLabel();
        this.answerBuffer = answerBuffer;*/
    }

    String[] choices = new String[4];
    JLabel questionLabel = new JLabel();
    String answerBuffer = "";
    JCheckBox choiceAButton;
    JCheckBox choiceBButton;
    JCheckBox choiceCButton;
    JCheckBox choiceDButton;


    /*public class CheckBoxDemo extends JPanel
            implements ItemListener {*/

    public boolean checkMCMAAnswer(String inputAnswer) {
        return (this.answer.equals(inputAnswer.toLowerCase()));
    }


        protected String createMCMADialog() {
            // super(new BorderLayout());

            //Create the check boxes.
            JCheckBox choiceAButton = new JCheckBox(this.answerOptions[0]);
            // choiceAButton.setMnemonic(KeyEvent.VK_C);
            choiceAButton.setSelected(false);

            JCheckBox choiceBButton = new JCheckBox(this.answerOptions[1]);
            // choiceBButton.setMnemonic(KeyEvent.VK_G);
            choiceBButton.setSelected(false);

            JCheckBox choiceCButton = new JCheckBox(this.answerOptions[2]);
            // choiceCButton.setMnemonic(KeyEvent.VK_H);
            choiceCButton.setSelected(false);

            JCheckBox choiceDButton = new JCheckBox(this.answerOptions[3]);
            // choiceDButton.setMnemonic(KeyEvent.VK_T);
            choiceDButton.setSelected(false);

            //Register a listener for the check boxes.
            choiceAButton.addItemListener(this);
            choiceBButton.addItemListener(this);
            choiceCButton.addItemListener(this);
            choiceDButton.addItemListener(this);

            //Indicates what's on the geek.
            //this.choices = new StringBuffer("cght");

            //Set up the picture label
            questionLabel = new JLabel(this.question);
            questionLabel.setFont(questionLabel.getFont().deriveFont(Font.ITALIC));
            // updatePicture();

            //Put the check boxes in a column in a panel
            JPanel checkPanel = new JPanel(new GridLayout(1, 1));
            checkPanel.add(choiceAButton);
            checkPanel.add(choiceBButton);
            checkPanel.add(choiceCButton);
            checkPanel.add(choiceDButton);

            add(checkPanel, BorderLayout.LINE_START);
            add(questionLabel, BorderLayout.CENTER);
            // setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
            checkPanel.setBorder(BorderFactory.createLineBorder(Color.black));

            JFrame frame = new JFrame("ReBootU Quiz");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            //Create and set up the content pane.
            JPanel newContentPane = new JPanel(new BorderLayout());
            newContentPane.setOpaque(true); //content panes must be opaque
            frame.setContentPane(newContentPane);

            //Display the window.
            frame.pack();
            frame.setVisible(true);
            newContentPane.add(checkPanel);

            // createAndShowGUI(checkPanel);


            return this.answerBuffer;
        }

        /** Listens to the check boxes. */
        public void itemStateChanged(ItemEvent e) {
            //int index = 0;
            // char c = '-';
            Object source = e.getItemSelectable();

            if (source == choiceAButton) {
                this.choices[0] = answerOptions[0];
            } else if (source == choiceBButton) {
                this.choices[1] = answerOptions[1];
            } else if (source == choiceCButton) {
                this.choices[2] = answerOptions[2];
            } else if (source == choiceDButton) {
                this.choices[3] = answerOptions[3];
            }

            //Now that we know which button was pushed, find out
            //whether it was selected or deselected.
            if (e.getStateChange() == ItemEvent.DESELECTED) {
                if (source == choiceAButton) {
                    this.choices[0] = "";
                } else if (source == choiceBButton) {
                    this.choices[1] = "";
                } else if (source == choiceCButton) {
                    this.choices[2] = "";
                } else if (source == choiceDButton) {
                    this.choices[3] = "";
                }

            }

            //Apply the change to the string.
            for (int i = 0; i < this.choices.length; i++) {
                if (this.choices[i] != null) {
                    answerBuffer = answerBuffer.concat(this.choices[i] + " ");
                }
            }

            // updatePicture();
        }

        /**
         * Create the GUI and show it.  For thread safety,
         * this method should be invoked from the
         * event-dispatching thread.
         */
        private static void createAndShowGUI(JPanel checkPanel) {
            //Create and set up the window.
            JFrame frame = new JFrame("ReBootU Quiz");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            //Create and set up the content pane.
            JPanel newContentPane = new JPanel(new BorderLayout());
            newContentPane.setOpaque(true); //content panes must be opaque
            frame.setContentPane(newContentPane);

            //Display the window.
            frame.pack();
            frame.setVisible(true);
            add(checkPanel, newContentPane);
        }

        public static void main(String[] args) {
            //Schedule a job for the event-dispatching thread:
            //creating and showing this application's GUI.
            // String[] eAnswerOptions = {"trash can", "bottle", "chair", "fan"};
            // MCMAQuestion e = new MCMAQuestion("What is on the table?", "bottle, fan", eAnswerOptions);
            // e.createMCMADialog();
            // createAndShowGUI();
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    String[] eAnswerOptions = {"trash can", "bottle", "chair", "fan"};
                    MCMAQuestion e = new MCMAQuestion("What is on the table?", "bottle, fan", eAnswerOptions);
                    e.createMCMADialog();
                    // createAndShowGUI();
                }
            });
        }


}
