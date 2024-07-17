package quiz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Quiz extends JFrame implements ActionListener {

    String questions[][] = new String[10][5];
    String answers[][] = new String[10][2];
    String useranswers[][] = new String[10][1];
    JLabel qno, question;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup groupoptions;
    JButton next, submit, lifeline;

    public static int timer = 15;
    public static int ans_given = 0;
    public static int count = 0;
    public static int score = 0;

    String name, Password;

    Quiz(String name, String pass) {
        this.name = name;
        this.Password = Password;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/quiz2.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1300, 305);
        add(image);

        ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("icons/backgroundquiz.jpg"));
        Image i3 = i2.getImage().getScaledInstance(1300, 580, Image.SCALE_DEFAULT);
        ImageIcon i4 = new ImageIcon(i3);
        JLabel image1 = new JLabel(i4);
        image1.setBounds(0, 0, 1300, 580);
        add(image1);

        qno = new JLabel("1");
        qno.setForeground(Color.WHITE);
        qno.setBounds(100, 325, 50, 30);
        qno.setFont(new Font("Tahoma", Font.PLAIN, 22));
        image1.add(qno);

        question = new JLabel();
        question.setBounds(150, 325, 800, 30);
        question.setFont(new Font("Tahoma", Font.PLAIN, 22));
        question.setForeground(Color.WHITE);
        image1.add(question);

        questions[0][0] = "Which of the following is not a valid Java identifier ?";
        questions[0][1] = "_myVar";
        questions[0][2] = "$myVar";
        questions[0][3] = "1myVar";
        questions[0][4] = "myVar1";

        questions[1][0] =  "Which of the following is true about the anonymous inner class?";
        questions[1][1] = "It has only methods";
        questions[1][2] = "Objects can't be created";
        questions[1][3] = "It has a fixed class name";
        questions[1][4] = "It has no class name";

        questions[2][0] = "Which package contains the Random class?";
        questions[2][1] = "java.util package";
        questions[2][2] = "java.lang package";
        questions[2][3] = "java.awt package";
        questions[2][4] = "java.io package";

        questions[3][0] = "An interface with no fields or methods is known as?";
        questions[3][1] = "Runnable Interface";
        questions[3][2] = "Abstract Interface";
        questions[3][3] = "Marker Interface";
        questions[3][4] = "CharSequence Interface";

        questions[4][0] = "Which of the following is an immediate subclass of the Panel class?";
        questions[4][1] = "Applet class";
        questions[4][2] = "Window class";
        questions[4][3] = "Frame class";
        questions[4][4] = "Dialog class ";

        questions[5][0] = "Which of the following is a marker interface?";
        questions[5][1] = "Runnable interface";
        questions[5][2] = "Remote interface";
        questions[5][3] = "Readable interface";
        questions[5][4] = "Result interface";

        questions[6][0] = "Which keyword is used for accessing the features of a package?";
        questions[6][1] = "import";
        questions[6][2] = "package";
        questions[6][3] = "extends";
        questions[6][4] = "export";

        questions[7][0] = "In java, jar stands for?";
        questions[7][1] = "Java Archive Runner";
        questions[7][2] = "Java Archive";
        questions[7][3] = "Java Application Resource";
        questions[7][4] = "Java Application Runner";

        questions[8][0] = "Which of the following is a mutable class in java?";
        questions[8][1] = "java.lang.StringBuilder";
        questions[8][2] = "java.lang.Short";
        questions[8][3] = "java.lang.Byte";
        questions[8][4] = "java.lang.String";

        questions[9][0] = "Which of the following option leads to the portability and security of Java?";
        questions[9][1] = "Bytecode is executed by JVM";
        questions[9][2] = "The applet makes the Java code secure and portable";
        questions[9][3] = "Use of exception handling";
        questions[9][4] = "Dynamic binding between objects";

        answers[0][1] = "1myVar";
        answers[1][1] = "It has no class name";
        answers[2][1] = "java.util package";
        answers[3][1] = "Marker Interface";
        answers[4][1] = "Applet class";
        answers[5][1] = "Remote interface";
        answers[6][1] = "import";
        answers[7][1] = "Java Archive";
        answers[8][1] = "java.lang.StringBuilder";
        answers[9][1] = "Bytecode is executed by JVM";

        opt1 = new JRadioButton("the");
        opt1.setBounds(100, 430, 500, 40);
        opt1.setForeground(Color.WHITE);
        opt1.setBackground(new Color(30, 144, 255));
        opt1.setFont(new Font("Dialog", Font.PLAIN, 20));
        image1.add(opt1);
//        
        opt2 = new JRadioButton("The");
        opt2.setBounds(700, 430, 500, 40);
        opt2.setForeground(Color.WHITE);
        opt2.setBackground(new Color(30, 144, 255));
        opt2.setFont(new Font("Dialog", Font.PLAIN, 20));
        image1.add(opt2);
//        
        opt3 = new JRadioButton("The");
        opt3.setBounds(100, 505, 500, 40);
        opt3.setForeground(Color.WHITE);
        opt3.setBackground(new Color(30, 144, 255));
        opt3.setFont(new Font("Dialog", Font.PLAIN, 20));
        image1.add(opt3);
//        
        opt4 = new JRadioButton(("The"));
        opt4.setBounds(700, 505, 500, 40);
        opt4.setForeground(Color.WHITE);
        opt4.setBackground(new Color(30, 144, 255));
        opt4.setFont(new Font("Dialog", Font.PLAIN, 20));
        image1.add(opt4);

        groupoptions = new ButtonGroup();
        groupoptions.add(opt1);
        groupoptions.add(opt2);
        groupoptions.add(opt3);
        groupoptions.add(opt4);

        next = new JButton("Next");
        next.setBounds(700, 590, 150, 40);
        next.setFont(new Font("Tahoma", Font.PLAIN, 22));
        next.setBackground(new Color(30, 144, 255));
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);

        submit = new JButton("Submit");
        submit.setBounds(900, 590, 150, 40);
        submit.setFont(new Font("Tahoma", Font.PLAIN, 22));
        submit.setBackground(new Color(30, 144, 255));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setEnabled(false);
        add(submit);

        start(count);

        setBounds(0, 0, 1440, 700);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            repaint();
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);

            ans_given = 1;
            if (groupoptions.getSelection() == null) {
                useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }

            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }

            count++;
            start(count);
        } else if (ae.getSource() == lifeline) {
            if (count == 2 || count == 4 || count == 6 || count == 8 || count == 9) {
                opt2.setEnabled(false);
                opt3.setEnabled(false);
            } else {
                opt1.setEnabled(false);
                opt4.setEnabled(false);
            }
            lifeline.setEnabled(false);
        } else if (ae.getSource() == submit) {
            ans_given = 1;
            if (groupoptions.getSelection() == null) {
                useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }

            for (int i = 0; i < useranswers.length; i++) {
                if (useranswers[i][0].equals(answers[i][1])) {
                    score += 10;
                } else {
                    score += 0;
                }
            }
            setVisible(false);
            new Score(name, Password, score);
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        String time = "Time left - " + timer + " seconds"; // 15
        g.setColor(Color.RED);
        g.setFont(new Font("Tahoma", Font.BOLD, 15));

        if (timer > 0) {
            g.drawString(time, 1100, 300);
        } else {
            g.drawString("Times up!!", 1100, 300);
        }

        timer--; // 14

        try {
            Thread.sleep(1000);
            repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (ans_given == 1) {
            ans_given = 0;
            timer = 15;
        } else if (timer < 0) {
            timer = 15;
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);

            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if (count == 9) { // submit button
                if (groupoptions.getSelection() == null) {
                    useranswers[count][0] = "";
                } else {
                    useranswers[count][0] = groupoptions.getSelection().getActionCommand();
                }

                for (int i = 0; i < useranswers.length; i++) {
                    if (useranswers[i][0].equals(answers[i][1])) {
                        score += 10;
                    } else {
                        score += 0;
                    }
                }
                setVisible(false);
                new Score(name, Password, score);
            } else { // next button
                if (groupoptions.getSelection() == null) {
                    useranswers[count][0] = "";
                } else {
                    useranswers[count][0] = groupoptions.getSelection().getActionCommand();
                }
                count++; // 0 // 1
                start(count);
            }
        }

    }

    public void start(int count) {
        qno.setText("" + (count + 1) + ". ");
        question.setText(questions[count][0]);
        //question.setForeground(Color.WHITE);
        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);

        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);

        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);

        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);

        groupoptions.clearSelection();
    }

    public static void main(String[] args) {
        new Quiz("", "");

    }

}
