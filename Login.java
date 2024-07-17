package quiz;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;

public class Login extends JFrame implements ActionListener {

    JButton signin, signUp, clear, admin, exit;
    JTextField userTextField;
    JPasswordField passTextField;
    JLabel user, pass;
    

    Login() {

        setTitle("Quiz Application For Assessment");

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(35, 25, 100, 100);
        add(label);

        JLabel text = new JLabel("WELCOME TO QUIZ APPLICATION");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(200, 40, 700, 40);
        add(text);

        user = new JLabel("USER : ");
        user.setFont(new Font("Raleway", Font.BOLD, 28));
        user.setBounds(150, 200, 200, 40);
        add(user);

        userTextField = new JTextField();
        userTextField.setBounds(350, 205, 350, 30);
        userTextField.setFont(new Font("Arial", Font.BOLD, 20));
        add(userTextField);

        pass = new JLabel("PASSWORD: ");
        pass.setFont(new Font("Raleway", Font.BOLD, 28));
        pass.setBounds(155, 260, 200, 40);
        add(pass);

        passTextField = new JPasswordField();
        passTextField.setBounds(350, 265, 350, 30);
        passTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(passTextField);

        signin = new JButton("SIGN IN");
        signin.setBounds(280, 320, 100, 30);
        signin.setBackground(Color.BLACK);
        signin.setForeground(Color.WHITE);
        signin.addActionListener(this);
        add(signin);

        clear = new JButton("CLEAR");
        clear.setBounds(390, 320, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        admin = new JButton("ADMIN");
        admin.setBounds(500, 320, 100, 30);
        admin.setBackground(Color.BLACK);
        admin.setForeground(Color.WHITE);
        admin.addActionListener(this);
        add(admin);

        signUp = new JButton("NEW USER REGISTATION"); // due to global declaration
        signUp.setBounds(280, 370, 325, 30);
        signUp.setBackground(Color.BLACK);
        signUp.setForeground(Color.WHITE);
        signUp.addActionListener(this);
        add(signUp);

        exit = new JButton("EXIT");
        exit.setBounds(370, 420, 150, 30);
        exit.setBackground(Color.BLACK);
        exit.setForeground(Color.WHITE);
        exit.addActionListener(this);
        add(exit);

        setSize(900, 600);
        setLocation(300, 30);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == signin) {
            Database conn = new Database();
            String user = userTextField.getText();
            String pass = passTextField.getText();
           
            String query = "select * from Login where UserId ='" + user + "' and  Password = '" + pass + "'";
            try {
                ResultSet rs = conn.s.executeQuery(query);
                if (rs.next()) {
                    setVisible(false);
                    new Rules(pass).setVisible(true);

                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect UserId or Password");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
            
        } else if (ae.getSource() == signUp) {
            setVisible(false);
            new SignUpOne().setVisible(true);

        } else if (ae.getSource() == clear) {
            userTextField.setText("");
            passTextField.setText("");

        

        } else if (ae.getSource() == admin) {
            setVisible(false);
            new Admin().setVisible(true);

        } else if (ae.getSource() == exit) {
            setVisible(false);
            System.exit(0);

        }
    }

    public static void main(String[] args) {
        new Login();
    }

}
