package quiz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Rules extends JFrame implements ActionListener {
   
    JButton start, back;
    String Password, EmailId, name;
    
    Rules(String pass, String name) {
        this.Password= Password;
        this.EmailId = EmailId;
        this.name = name;
        
        setTitle("Rule for the Quiz");
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Welcome " + name + " to Quiz Application");
        heading.setBounds(300, 20, 700, 30);
        heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 28));
        heading.setForeground(new Color(30, 144, 254));
        add(heading);
        
        JLabel rules = new JLabel();
        rules.setBounds(20, 90, 700, 350);
        rules.setFont(new Font("Tahoma", Font.PLAIN, 16));
        rules.setText(
            "<html>"+ 
                "1. Give answer point to point" + "<br><br>" +
                "2. There are 10 questions with four options are avalable for each question" + "<br><br>" +
                "3. All questions are compulsory to Attempt" + "<br><br>" +
                "4. You will get 10 marks for each correct answer" + "<br><br>" +
                "5. you will get 15 seconds to answer a question" + "<br><br>" +
                "6. You can see your Score on your dashboard after submitting the quiz" + "<br><br>" +
                "7. Follow Instruction given above and feel free to ask query and give your FEEDBACK" + "<br><br>" +
                "8. Give answer wisely, Good Luck" + "<br><br>" +
            "<html>"
        );
        add(rules);
        
        back = new JButton("Back");
        back.setBounds(250, 500, 100, 30);
        back.setBackground(new Color(30, 144, 254));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        start = new JButton("Start");
        start.setBounds(400, 500, 100, 30);
        start.setBackground(new Color(30, 144, 254));
        start.setForeground(Color.WHITE);
        start.addActionListener(this);
        add(start);

        setSize(1250,650);
        setLocation(0,0);
        setVisible(true);
        
       }

    Rules(String pass) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == start) {
            setVisible(false);
             new Quiz(Password,"").setVisible(true);
        } else if(ae.getSource() == back){
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    

    
    public static void main(String[] args) {
        new Rules("","");
    }
    
    
}
