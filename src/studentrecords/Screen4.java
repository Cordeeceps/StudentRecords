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
public class Screen4 extends JFrame {
    
    //create the things
    /**
     * search button
     */
    JButton searchButton;

    /**
     * message label
     */
    JLabel message;

    /**
     * textbox for user input (student ID to search for)
     */
    JTextField inputBox;
    
    /**
     * creates GUI screen for "find student" option
     */
    public Screen4()
    {
        setTitle("Find Student");
        setSize(400, 150);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        buildPanel();
        setVisible(true);
    }
    
    /**
     * styles the items in the GUI window
     */
    public void buildPanel()
    {
        //create panels
        JPanel panel1 = new JPanel(); 
       
        //create layout
        panel1.setBackground(Color.BLACK);
        
        //textfield for the user to enter the number of minutes of the call.
        inputBox = new JTextField(25);
        inputBox.setBackground(Color.BLACK);
        inputBox.setForeground(Color.WHITE);

        //creates button handler
        ButtonHandler b1 = new ButtonHandler();
        
        //create buttons
        searchButton = new JButton("Find");
        searchButton.addActionListener(b1);
        //button aesthetics
        searchButton.setBackground(Color.GRAY);
        searchButton.setForeground(Color.WHITE);
        
        //distance label
        message = new JLabel("Enter student Banner ID.");
        message.setForeground(Color.WHITE);
        
        //add things to panel
        panel1.add(message);
        panel1.add(inputBox);
        panel1.add(searchButton);
        
        //add panel to window
        this.add(panel1);
    }
    
    /**
     * all the code that happens when the user clicks the "search" button.
     */
    private class ButtonHandler implements ActionListener
    {

        /**
         *
         * @param e - action event when the "search" button is clicked.
         */
        public void actionPerformed(ActionEvent e)
        {
            String cmd = e.getActionCommand();
            //debugging
            System.out.println(cmd);
            //if they click the find button
           if(cmd.equals("Find"))
           {
               //get the banner ID from the text box
               String bannerID = inputBox.getText();
               try
               {
                   //notes if we found the student
                   boolean foundStudent = false;
                   
                   //change Banner into int
                   int banner = Integer.parseInt(bannerID);
                   
                   for(int i = 0; i < Student.getStudents().size(); i++)
                   {
                       //checks if the banner equals the selected Student's banner
                       if(Student.getStudents().get(i).equals(banner))
                       {
                           //change state of found student
                           foundStudent = true;
                           //print the student information, uses the toString
                           JOptionPane.showMessageDialog(null, Student.getStudents().get(i));
                       }
                   }
                   if(foundStudent == false)
                       JOptionPane.showMessageDialog(null, "Student not Found!");
                   
               }
               //if they don't put a number in BannerID
               catch (NumberFormatException exception)
               {
                    JOptionPane.showMessageDialog(null, "Error: Banner ID must be a number.");
               }
           }
        }
    }
}
