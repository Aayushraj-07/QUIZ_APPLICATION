
package quiz;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Admin extends JFrame implements ActionListener{
    JButton create, delete, update, back;
    String EmailId;
    Admin() {
        
         getContentPane().setBackground(Color.WHITE);
         setLayout(null);
         setTitle("Adminstration");
         
         JLabel l = new JLabel("HERE YOU CAN CREATE, UPDATE & DELETE QUESTIONS.");
         l.setFont(new Font("Raleway", Font.BOLD, 14));
         l.setBounds(100,70,400,30);
         add(l);


        create = new JButton("CREATE");
        create.setBackground(Color.BLACK);
        create.setForeground(Color.WHITE);
        create.setFont(new Font("Raleway", Font.BOLD, 14));
        create.setBounds(150,150,100,30);
        create.addActionListener(this);
        add(create);
         
        
        update = new JButton("UPDATE");
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setFont(new Font("Raleway", Font.BOLD, 14));
        update.setBounds(350,150,100,30);
        update.addActionListener(this);
        add(update);
        
        delete = new JButton("DELETE");
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.setFont(new Font("Raleway", Font.BOLD, 14));
        delete.setBounds(150,200,100,30);
        delete.addActionListener(this);
        add(delete);

        
        back = new JButton("BACK");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Raleway", Font.BOLD, 14));
        back.setBounds(350,200,100,30);
        back.addActionListener(this);
        add(back);
        
        


         
         
         setSize(750,520);
         setVisible(true);
         setLocation(320,95);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == create) {
            
        } else if (e.getSource() == update) {
            
        } else if (e.getSource() == delete) {
            
            
        } else if (e.getSource() == back) {
            setVisible(false);
            new Login().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Admin();
    }

    
   
}
