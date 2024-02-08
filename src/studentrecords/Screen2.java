/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentrecords;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
/**
 *
 * @author Mae
 */
public class Screen2 extends JFrame {
    
    //create the things
    /**
     * add button
     */
    JButton add;

    /**
     * panel for welcome message
     */
    JPanel panel1,

    /**
     * panel for first name information
     */
    panel2,

    /**
     * panel for last name information
     */
    panel3,

    /**
     * panel for password info
     */
    panel4,

    /**
     * panel for confirm password info
     */
    panel5,

    /**
     * panel for student type info
     */
    panel6,

    /**
     * panel for major info
     */
    panel7,

    /**
     * panel for account balance info
     */
    panel8,

    /**
     * panel for submit button
     */
    panel9;

    /**
     * message label
     */
    JLabel message;

    /**
     * first name label
     */
    JLabel firstName,

    /**
     * last name label
     */
    lastName,

    /**
     * password label
     */
    password,

    /**
     * confirm password label
     */
    confirmPass,

    /**
     * student type label
     */
    studentType,

    /**
     * major label
     */
    major,

    /**
     * account balance label
     */
    accountBalance;

    /**
     * textbox for user to enter in first name
     */
    JTextField firstBox,

    /**
     * textbox for user to enter in last name
     */
    lastBox,

    /**
     * textbox for user to enter in password
     */
    passBox,

    /**
     * textbox for user to enter in password again to confirm
     */
    confirmBox,

    /**
     * textbox for user to enter in major
     */
    majorBox,

    /**
     * textbox for user to enter in account balance
     */
    accountBox;

    /**
     * radio button to select student without a major
     */
    private JRadioButton noMajorButton;

    /**
     * radio button to select full time student
     */
    private JRadioButton fullTimeButton;

    /**
     * radio button to select part time student
     */
    private JRadioButton partTimeButton;

    /**
     * creates a group for the radio buttons. so that only one can be selected at a time.
     */
    private ButtonGroup bg; 
    
    /**
     * creates the GUI window to add new student
     */
    public Screen2()
    {
        setTitle("Add New Student");
        setSize(400, 500);
      
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        buildPanel();
        setVisible(true);
    }
    
    /**
     * styles all the items inside the GUI window
     */
    public void buildPanel()
    {
        //create panels
        panel1 = new JPanel(); 
        panel2 = new JPanel(); 
        panel3 = new JPanel();
        panel4 = new JPanel();
        panel5 = new JPanel();
        panel6 = new JPanel();
        panel7 = new JPanel();
        panel8 = new JPanel();
        panel9 = new JPanel();
       
        
        //create layout
        setLayout(new GridLayout(9, 1));
        panel1.setBackground(Color.BLACK);
        panel2.setBackground(Color.BLACK);
        panel3.setBackground(Color.BLACK);
        panel4.setBackground(Color.BLACK);
        panel5.setBackground(Color.BLACK);
        panel6.setBackground(Color.BLACK);
        panel7.setBackground(Color.BLACK);
        panel8.setBackground(Color.BLACK);
        panel9.setBackground(Color.BLACK);
        
        //creates button handler
        ButtonHandler b1 = new ButtonHandler();
        
        //create buttons
        add = new JButton("Add Student");
        add.addActionListener(b1);
        //button aesthetics
        add.setBackground(Color.GRAY);
        add.setForeground(Color.WHITE);
        
        //create labels
        message = new JLabel("Please enter student information.");
        message.setForeground(Color.WHITE);
        
        firstName = new JLabel("First Name: ");
        firstName.setForeground(Color.WHITE);
        
        lastName = new JLabel("Last Name: ");
        lastName.setForeground(Color.WHITE);
        
        password = new JLabel("Password: ");
        password.setForeground(Color.WHITE);
        
        confirmPass = new JLabel("Confirm Password: ");
        confirmPass.setForeground(Color.WHITE);
        
        studentType = new JLabel("Student Type: ");
        studentType.setForeground(Color.WHITE);
        
        major = new JLabel("Major: ");
        major.setForeground(Color.WHITE);
        
        accountBalance = new JLabel("Account Balance: ");
        accountBalance.setForeground(Color.WHITE);
        
        //textfield for the user to enter the number of minutes of the call.
        firstBox = new JTextField(15);
        firstBox.setBackground(Color.BLACK);
        firstBox.setForeground(Color.WHITE);
        
        lastBox = new JTextField(15);
        lastBox.setBackground(Color.BLACK);
        lastBox.setForeground(Color.WHITE);
        
        passBox = new JTextField(15);
        passBox.setBackground(Color.BLACK);
        passBox.setForeground(Color.WHITE);
        
        confirmBox = new JTextField(15);
        confirmBox.setBackground(Color.BLACK);
        confirmBox.setForeground(Color.WHITE);
        
        //radio button for student type
        // Create the radio buttons.
        noMajorButton = new JRadioButton("No Major", true);
        noMajorButton.setBackground(Color.BLACK);
        noMajorButton.setForeground(Color.WHITE);
        
        fullTimeButton = new JRadioButton("Full Time");
        fullTimeButton.setBackground(Color.BLACK);
        fullTimeButton.setForeground(Color.WHITE);
        
        partTimeButton = new JRadioButton("Part Time");
        partTimeButton.setBackground(Color.BLACK);
        partTimeButton.setForeground(Color.WHITE);

        // Group the radio buttons.
        bg = new ButtonGroup();
        bg.add(noMajorButton);
        bg.add(fullTimeButton);
        bg.add(partTimeButton);
        
        majorBox = new JTextField(15);
        majorBox.setBackground(Color.BLACK);
        majorBox.setForeground(Color.WHITE);
        
        accountBox = new JTextField(15);
        accountBox.setBackground(Color.BLACK);
        accountBox.setForeground(Color.WHITE);
        
        //add to panels in grid
        panel1.add(message);
        
        panel2.add(firstName);
        panel2.add(firstBox);
        
        panel3.add(lastName);
        panel3.add(lastBox);
        
        panel4.add(password);
        panel4.add(passBox);
        
        panel5.add(confirmPass);
        panel5.add(confirmBox);
        
        panel6.add(studentType);
        panel6.add(noMajorButton);
        panel6.add(fullTimeButton);
        panel6.add(partTimeButton);
        
        panel7.add(major);
        panel7.add(majorBox);
        
        panel8.add(accountBalance);
        panel8.add(accountBox);
        
        panel9.add(add);
        
        //add the panel to the JFrame 
        this.add(panel1);
        this.add(panel2);
        this.add(panel3);
        this.add(panel4);
        this.add(panel5);
        this.add(panel6);
        this.add(panel7);
        this.add(panel8);
        this.add(panel9);
    }
    
    /**
     * all of the code behind button events on the add student page. what happens when the user clicks "submit"
     */
    private class ButtonHandler implements ActionListener
    {

        /**
         *
         * @param e - submit button was clicked.
         */
        public void actionPerformed(ActionEvent e)
        {
            String cmd = e.getActionCommand();
            //debugging
            System.out.println(cmd);
            //clicks on Add Student
           if(cmd.equals("Add Student"))
           {
               //get info from the boxes
               String f = firstBox.getText();
               String l = lastBox.getText();
               String p = passBox.getText();
               String confp = confirmBox.getText();
               String m = majorBox.getText();
               String bal = accountBox.getText();
               
               try
               {
                   //if passwords do not match
                   if(!p.equals(confp))
                   {
                       //change backgrouund color
                       panel4.setBackground(Color.RED);
                       panel5.setBackground(Color.RED);
                       //throw exception
                       throw new BadDataException("Passwords must match!");
                   }
                   //if not a valid password
                   else if(!Student.validPassword(p))
                   {
                       //change background color
                       panel4.setBackground(Color.RED);
                       throw new BadDataException("Passwords must contain 8-10 characters, 1 uppercase letter, 1 lowercase letter, and 1 number.");
                   }
                   //if first name field is left blank
                   else if(f.isEmpty())
                   {
                       //change background color
                       panel2.setBackground(Color.RED);
                       throw new BadDataException("First name field may not be empty.");
                   }
                   //if last name field is left blank
                   else if(l.isEmpty())
                   {
                       //change background color
                       panel3.setBackground(Color.RED);
                       throw new BadDataException("Last name field may not be empty.");
                   }
                   //if they fixed the errors
                   else
                   {
                       panel2.setBackground(Color.BLACK);
                       panel3.setBackground(Color.BLACK);
                       panel4.setBackground(Color.BLACK);
                       panel5.setBackground(Color.BLACK);
                   }
                   //parse balance into a float
                   float b = Float.parseFloat(bal);
                   //if they fixed balance error
                   panel8.setBackground(Color.BLACK);
                   
                     //if declared as no major
                    if(noMajorButton.isSelected())
                    {
                        //create student with null major
                        Student s = new Student(f,l,p,"NoMajor",null,b);
                        //add student to Student arraylist
                        Student.addStudent(s);
                        //success message
                        JOptionPane.showMessageDialog(null, "Student added. Email: " + s.getEmail() + " BannerID: " + s.getBannerId());
                    }
                    //if selected full time
                    else if (fullTimeButton.isSelected())
                    {
                        //check if they have a major
                        if(m.isEmpty())
                        {
                            panel7.setBackground(Color.RED);
                            throw new BadDataException("Must have a major.");
                        }
                        //reset panel to black
                        panel7.setBackground(Color.BLACK);
                        //create full time student
                        Student s = new Student(f,l,p,"FullTime",m,b);
                        //add student to arraylist
                        Student.addStudent(s);
                        //success message
                        JOptionPane.showMessageDialog(null, "Student added. Email: " + s.getEmail() + " BannerID: " + s.getBannerId());
                    }
                    //if selected part time
                    else if (partTimeButton.isSelected())
                    {
                        //check if they have a major
                        if(m.isEmpty())
                        {
                            panel7.setBackground(Color.RED);
                            throw new BadDataException("Must have a major.");
                        }
                        //reset panel to black
                        panel7.setBackground(Color.BLACK);
                        //create part time student
                        Student s = new Student(f,l,p,"PartTime",m,b);
                        //add student to arraylist
                        Student.addStudent(s);
                        //success message
                        JOptionPane.showMessageDialog(null, "Student added. Email: " + s.getEmail() + " BannerID: " + s.getBannerId());
                    }
                    
                    //clear out the boxes once finished adding
                    firstBox.setText("");
                    lastBox.setText("");
                    passBox.setText("");
                    confirmBox.setText("");
                    majorBox.setText("");
                    accountBox.setText("");
               }
               //my exceptions created for incorrect data
               catch (BadDataException exception)
               {
                   JOptionPane.showMessageDialog(null, "Error: " + exception.getMessage());
               }
               //exception if they balance isn't a number
               catch (NumberFormatException exception){
                            panel8.setBackground(Color.RED);
                            JOptionPane.showMessageDialog(null, "Error: Balance must be a number.");
                        }
               //other exceptions
               catch(Exception exception)
               {
                   JOptionPane.showMessageDialog(null, "Error: " + exception.getMessage());
               }

           }
        }
    }
}
