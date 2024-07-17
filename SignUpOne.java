package quiz;

import com.toedter.calendar.JDateChooser;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;
//import com.toedter.calendar.JDateChooser;

public class SignUpOne extends JFrame implements ActionListener {

    long random;
    JTextField nameTextField, emailTextField, phnoTextField;
    JRadioButton male, female, other;
    JDateChooser dateChooser;
    JButton submit;


    SignUpOne() {
        getContentPane().setBackground(Color.CYAN);
        setLayout(null);

        setTitle("New Registation");

        JLabel PersonalDetails = new JLabel(" Personal Details");
        PersonalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        PersonalDetails.setBounds(280, 10, 200, 30);
        add(PersonalDetails);

        JLabel name = new JLabel("Name: ");
        name.setFont(new Font("Raleway", Font.BOLD, 20)); // to change the font of label
        name.setBounds(100, 120, 100, 30);
        add(name);

        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        nameTextField.setBounds(240, 120, 320, 30);
        add(nameTextField);

        JLabel email = new JLabel("Email: ");
        email.setFont(new Font("Raleway", Font.BOLD, 20)); // to change the font of label
        email.setBounds(100, 170, 150, 30);
        add(email);

        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        emailTextField.setBounds(240, 170, 320, 30);
        add(emailTextField);

        JLabel phno = new JLabel("Mobile No: ");
        phno.setFont(new Font("Raleway", Font.BOLD, 20)); // to change the font of label
        phno.setBounds(100, 220, 200, 30);
        add(phno);

        phnoTextField = new JTextField();
        phnoTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        phnoTextField.setBounds(240, 220, 320, 30);
        add(phnoTextField);

        JLabel dob = new JLabel("Date Of Birth: ");
        dob.setFont(new Font("Raleway", Font.BOLD, 20)); // to change the font of label
        dob.setBounds(100, 270, 200, 30);
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(240, 270, 320, 30);
        add(dateChooser);

        JLabel gender = new JLabel("Gender: ");
        gender.setFont(new Font("Raleway", Font.BOLD, 20)); // to change the font of label
        gender.setBounds(100, 320, 200, 30);
        add(gender);

        male = new JRadioButton("Male");
        male.setFont(new Font("Raleway", Font.PLAIN, 14));
        male.setBackground(Color.WHITE);
        male.setBounds(240, 320, 80, 30);
        add(male);

        female = new JRadioButton("Female");
        female.setFont(new Font("Raleway", Font.PLAIN, 14));
        female.setBackground(Color.WHITE);
        female.setBounds(350, 320, 80, 30);
        add(female);

        other = new JRadioButton("Other");
        other.setFont(new Font("Raleway", Font.PLAIN, 14));
        other.setBackground(Color.WHITE);
        other.setBounds(480, 320, 80, 30);
        add(other);

        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        gendergroup.add(other);

        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBounds(460, 370, 100, 30);
        submit.addActionListener(this);
        add(submit);

        setSize(700, 600);
        setLocation(200, 30);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String UserName = nameTextField.getText(); //setText
        String EmailId = emailTextField.getText();
        String DOB = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String PhNo = phnoTextField.getText();
        String Sex = null;

        if (male.isSelected()) {
            Sex = "Male";
        } else if (female.isSelected()) {
            Sex = "Female";
        } else if (other.isSelected()) {
            Sex = "Other";
        }

        Random random = new Random();
        String UserId = "" + Math.abs(random.nextLong() % 900000L + 202300000L);
        String Password = "" + Math.abs(random.nextLong() % 9000L + 1000L);

        if (e.getSource() == submit) {
            //JOptionPane.showMessageDialog(null, "Submitted Successfully.");
            //setVisible(false);

            try {
                if (UserName.equals("")) {
                    JOptionPane.showMessageDialog(null, "Name is Required"); //to give message to fill the data
                } else {
                    Database c = new Database();
                    String query1 = "INSERT INTO SignUpOne values('" + UserId + "', '" + Password + "', '" + UserName + "', '" + EmailId + "','" + PhNo + "','" + DOB + "','" + Sex + "')";
                    String query2 = "INSERT INTO Login values('" + EmailId + "', '" + UserId + "','" + Password + "')";

                    c.s.executeUpdate(query1);
                    c.s.executeUpdate(query2);

                    JOptionPane.showMessageDialog(null, "Submitted successfully!");
                    JOptionPane.showMessageDialog(null, "User Id : " + UserId + "\n Password : " + Password);
                    setVisible(false);
                     new Login().setVisible(true);
                }

            } catch (Exception ae) {
                System.out.println(ae);
            }
        }

    }

    public static void main(String[] args) {
        new SignUpOne();

    }

}
