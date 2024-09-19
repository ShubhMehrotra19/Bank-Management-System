package bank.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

// swing, java ki ek extended library hai to use ham Javax se call karte hai.
public class login extends JFrame implements ActionListener {

    JButton login, clear, signup;  // yaha se ham buttons ko globally define kar dete hai
    JTextField cardTextField;
    JPasswordField pinTextField;

    login(){
        setTitle("Automated Teller Machine"); // isse ham frame ka title change kar sakte hai

        setLayout(null);  //java mein automatically apne khudke layouts hote hai. hame custom layout use karne ke liye setBounds use karna hota hai.
                          // setBounds ko use karne ke liye hame base layouts ko off karna padta hai isliye ham setLayout use karte hai.


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg")); /* kabhi bhi kisi bhi frame pe koi icon use karna ho,
        to uske liye  ImageIcon karke ke class hoti hai. Uska ek object create karna hota hai, aur is object mein ham system ka path use karke
        icon locate karte hai.
        */

        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        // Image java.awt ka part hai aur ise ham kisi bhi image ka scale change karne ke liye use karte hai.
        // kyuki ham i2 ko JLabel mein use nahi kar sakte, isliye hame isko ImageIcon mein convert karna padega.

        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);

        // frame ke upar kisi object ki location change karne ke liye ham setBounds use karenge.
        label.setBounds(70, 10, 100, 100);

        add(label); // jab bhi kisi component ko frame mein place karna hota hai use add() function mein daalna hota hai.

        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(200, 40, 400, 40);
        add(text);

        JLabel cardno = new JLabel("Card Number : ");
        cardno.setFont(new Font("Raleway", Font.BOLD, 28));
        cardno.setBounds(120, 150, 250, 40);
        add(cardno);

        // java mein input ki space ke liye TextField ka use karte hai
        cardTextField = new JTextField();
        cardTextField.setBounds(350, 150, 250, 40);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 16));
        add(cardTextField);

        JLabel pin = new JLabel("Enter Pin : ");
        pin.setFont(new Font("Raleway", Font.BOLD, 28));
        pin.setBounds(120, 220, 250, 40);
        add(pin);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(350, 220, 250, 40);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 16));
        add(pinTextField);

        login = new JButton("Sign in");
        login.setBounds(250, 300, 100, 40);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);  // buttons pe function lagane ke liye unpe actionListener daalte hai. aur this se ham us button ko target kre.
        add(login);

        clear = new JButton("Clear");
        clear.setBounds(400, 300, 100, 40);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("Sign Up");
        signup.setBounds(250, 360, 250, 40);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);

        getContentPane().setBackground(Color.WHITE);

        // JLabel ki help se ham frame pe kuch bhi content likh sakte hai.

        setSize(800, 480);  // setsize function frame ki length aur breadth define karta hai
        setVisible(true); // by default jo frame hota hai vo user se hidden hota hai. use dikhane ke liye hame ye function call karna padta hai.
        setLocation(350, 200); // function jisse ham apne frame ko origin se set coordinates pe load hone ka command dete hai
    }
    /* jab bhi ham class ka object banate hai to sabse pehle constructor call hota hai isliye hame constructor mein values
        daalni padegi */

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == clear){
            // yaha pe textfield pe kaam karna hai to textField bhi locally define honi chahiye
            cardTextField.setText("");
            pinTextField.setText("");
        } else if (ae.getSource() == login){

        } else if (ae.getSource() == signup) {
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    } // ye interface ko implement karne ke liye abstract class ko override karne ko hai

    public static void main(String[] args) {
        new login();
    }
}
