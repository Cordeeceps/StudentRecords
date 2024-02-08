/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentrecords;

import java.awt.event.*;
import java.awt.*;
import java.io.PrintWriter;
import javax.swing.*;
/**
 *
 * @author Mae
 */
public class Screen3 extends JFrame {
    
    //create the things
    /**
     * download button
     */
    JButton downloadButton;

    /**
     * message label
     */
    JLabel message;

    /**
     * textbox for user input/file name
     */
    JTextField inputBox;
    
    /**
     * creates the GUI screen for download student records option
     */
    public Screen3()
    {
        setTitle("Download Student Records");
        setSize(400, 150);
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
        downloadButton = new JButton("Download Records");
        downloadButton.addActionListener(b1);
        //button aesthetics
        downloadButton.setBackground(Color.GRAY);
        downloadButton.setForeground(Color.WHITE);
        
        //distance label
        message = new JLabel("Enter download file name/path.");
        message.setForeground(Color.WHITE);
        
        //add things to panel
        panel1.add(message);
        panel1.add(inputBox);
        panel1.add(downloadButton);
        
        //add panel to window
        this.add(panel1);
       
    }
    
    /**
     * all the code that happens when the user clicks the "download" button.
     */
    private class ButtonHandler implements ActionListener
    {

        /**
         *
         * @param e - action event when user clicks "download" button.
         */
        public void actionPerformed(ActionEvent e)
        {
            String cmd = e.getActionCommand();
            //debugging
            System.out.println(cmd);
            //gets file name from text box
            if(cmd.equals("Download Records"))
            {
                String fileName = inputBox.getText();
                try
                {
                    //open the file for writing
                    PrintWriter pw = new PrintWriter(fileName);
                    //sorting the Arraylist of Students
                    Student.sortStudents();
                    //go through all students in the list
                    for(Student s : Student.getStudents())
                    {
                        //print to file
                        pw.println(s);
                    }
                    
                    //close the file
                    pw.close();
                    JOptionPane.showMessageDialog(null, "File Created! :)");
                }
                //exceptions should not happen in this but needed for pw
                catch (Exception exception)
                {
                     JOptionPane.showMessageDialog(null, "How did you get here?");
                }
            }
        }
    }
}
