import javax.swing.*;
import java.awt.event.*;

public class StudentGradeGeneratorGUI extends JFrame implements ActionListener {

    JLabel titleLabel;
    JLabel sub1Label, sub2Label, sub3Label, sub4Label, sub5Label;

    JTextField sub1Field, sub2Field, sub3Field, sub4Field, sub5Field;

    JButton calculateButton, clearButton, exitButton;

    JTextArea resultArea;

    StudentGradeGeneratorGUI() {

        setTitle("Student Grade Generator");
        setSize(550, 550);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        titleLabel = new JLabel("STUDENT GRADE GENERATOR");
        titleLabel.setBounds(160, 20, 250, 30);
        add(titleLabel);

        sub1Label = new JLabel("Maths Marks:");
        sub1Label.setBounds(60, 80, 150, 30);
        add(sub1Label);

        sub2Label = new JLabel("Science Marks:");
        sub2Label.setBounds(60, 120, 150, 30);
        add(sub2Label);

        sub3Label = new JLabel("English Marks:");
        sub3Label.setBounds(60, 160, 150, 30);
        add(sub3Label);

        sub4Label = new JLabel("History Marks:");
        sub4Label.setBounds(60, 200, 150, 30);
        add(sub4Label);

        sub5Label = new JLabel("Geography Marks:");
        sub5Label.setBounds(60, 240, 150, 30);
        add(sub5Label);

        sub1Field = new JTextField();
        sub1Field.setBounds(220, 80, 180, 30);
        add(sub1Field);

        sub2Field = new JTextField();
        sub2Field.setBounds(220, 120, 180, 30);
        add(sub2Field);

        sub3Field = new JTextField();
        sub3Field.setBounds(220, 160, 180, 30);
        add(sub3Field);

        sub4Field = new JTextField();
        sub4Field.setBounds(220, 200, 180, 30);
        add(sub4Field);

        sub5Field = new JTextField();
        sub5Field.setBounds(220, 240, 180, 30);
        add(sub5Field);

        calculateButton = new JButton("Calculate");
        calculateButton.setBounds(60, 310, 120, 40);
        add(calculateButton);

        clearButton = new JButton("Clear");
        clearButton.setBounds(210, 310, 120, 40);
        add(clearButton);

        exitButton = new JButton("Exit");
        exitButton.setBounds(360, 310, 120, 40);
        add(exitButton);

        resultArea = new JTextArea();
        resultArea.setBounds(60, 380, 420, 100);
        resultArea.setEditable(false);
        add(resultArea);

        calculateButton.addActionListener(this);
        clearButton.addActionListener(this);
        exitButton.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == calculateButton) {

            int marks[] = new int[5];

            marks[0] = Integer.parseInt(sub1Field.getText());
            marks[1] = Integer.parseInt(sub2Field.getText());
            marks[2] = Integer.parseInt(sub3Field.getText());
            marks[3] = Integer.parseInt(sub4Field.getText());
            marks[4] = Integer.parseInt(sub5Field.getText());

            int total = 0;
            int highest = marks[0];
            int lowest = marks[0];

            for (int i = 0; i < marks.length; i++) {

                total = total + marks[i];

                if (marks[i] > highest) {
                    highest = marks[i];
                }
                if (marks[i] < lowest) {
                    lowest = marks[i];
                }
            }

            double average = total / 5.0;
            String grade;

            if (average >= 90) {
                grade = "A+";
            } else if (average >= 80) {
                grade = "A";
            } else if (average >= 70) {
                grade = "B";
            } else if (average >= 60) {
                grade = "C";
            } else if (average >= 50) {
                grade = "D";
            } else {
                grade = "Fail";
            }

            String result = "";

            result += "===== STUDENT RESULT =====\n\n";
            result += "Total Marks: " + total + "\n";
            result += "Average Marks: " + average + "\n";
            result += "Highest Marks: " + highest + "\n";
            result += "Lowest Marks: " + lowest + "\n";
            result += "Grade: " + grade;

            resultArea.setText(result);
        }

        else if (e.getSource() == clearButton) {

            sub1Field.setText("");
            sub2Field.setText("");
            sub3Field.setText("");
            sub4Field.setText("");
            sub5Field.setText("");

            resultArea.setText("");
        }

        else if (e.getSource() == exitButton) {

            JOptionPane.showMessageDialog(
                    this,
                    "Thank You!"
            );

            System.exit(0);
        }
    }

    // Main Method
    public static void main(String[] args) {

        new StudentGradeGeneratorGUI();
    }
}