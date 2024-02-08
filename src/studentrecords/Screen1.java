/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentrecords;

import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
/**
 *
 * @author Mae
 */
public class Screen1 extends JFrame {
    
    //create the items for the GUI
    /**
     * upload button
     */
    JButton uploadButton;

    /**
     * message label
     */
    JLabel message;

    /**
     * box where user can enter text
     */
    JTextField inputBox;
    
    /**
     * creates the panel/GUI screen
     */
    public Screen1()
    {
        setTitle("Upload Student Records");
        setSize(400, 150);
        //closes just this window, not the whole program
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        buildPanel();
        setVisible(true);
    }
    
    /**
     * creates items inside the GUI window
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
        uploadButton = new JButton("Enter");
        uploadButton.addActionListener(b1);
        //button aesthetics
        uploadButton.setBackground(Color.GRAY);
        uploadButton.setForeground(Color.WHITE);
        
        //distance label
        message = new JLabel("Please type the name/path of the student records.");
        message.setForeground(Color.WHITE);
        
        //add things to panel
        panel1.add(message);
        panel1.add(inputBox);
        panel1.add(uploadButton);
        
        //add panel to window
        this.add(panel1);
       
    }
    
    /**
     * all the code behind the button events. what happens when they click "enter".
     */
    private class ButtonHandler implements ActionListener 
    {

        /**
         *
         * @param e - button click event
         */
        public void actionPerformed(ActionEvent e)
        {
            String cmd = e.getActionCommand();
            //debugging
            System.out.println(cmd);

            //if user clicks enter button
            if(cmd.equals("Enter"))
            {
                //gets file name from text box
                String fileName = inputBox.getText();
                   
                //creates file with file name user entered
                File f = new File(fileName);
                
                //try to open the file
                try
                {
                    //show which line number we are reading in the file
                    int lineNumber = 0;
                    
                    //open the file for reading and read one line at a time
                    Scanner input = new Scanner(f);
                    while (input.hasNext())
                    {
                        //read a line
                        String line = input.nextLine();
                        
                        //work on one word at a time by splitting at ',' character, makes array of words
                        String[] words = line.split(",");
                        //goes through array of words to get rid of spaces and commas
                        for (int i = 0; i < words.length; i++)
                            {
                                //use string method to remove white spaces 
                                words[i] = words[i].trim();

                                //check if word ends in a comma
                                if (words[i].endsWith(","))
                                {
                                    //remove the comma (makes new substring without last character (comma))
                                    words[i] = words[i].substring(0, words[i].length() - 1);
                                }
                            }
                        
                        //try to add student info into Student
                        try
                        {
                            //if declared as no major
                            if(words[5].equals("NoMajor"))
                            {
                                //if declared as NoMajor but still has a major(assumed with length of line being too long)
                                if(words.length > 7)
                                    throw new BadDataException("No Major students cannot have a declared major.");
                                
                                //using the constructor that doesn't have a major
                                //lastname, firstname, password, email, bannerID, studentType, balance
                                Student s = new Student(words[1], words[0], words[3], words[2], Integer.parseInt(words[4]), words[5], Float.parseFloat(words[6]));
                                
                                //add student to the array list
                                Student.addStudent(s);
                            }
                            //if declared as Full Time or Part Time
                            else if(words[5].equals("Full Time") || words[5].equals("Part Time"))
                            {
                                //gets rid of empty space between words so it matches the Enum
                                //gets the first words and attaches the second word without the space
                                words[5] = words[5].substring(0,4) + words[5].substring(5,words[5].length());
                                //using the constructor that DOES have a major
                                //lastname, firstname, password, email, bannerID, studentType, major, balance
                                Student s = new Student(words[1], words[0], words[3], words[2], Integer.parseInt(words[4]), words[5], words[6], Float.parseFloat(words[7]));
                                //add student to the array list
                                Student.addStudent(s);
                            }
                            //if declared as nothing that we care about
                            else
                            {
                                throw new BadDataException("Student Type must be Full Time, Part Time, or NoMajor.");
                            }
                        }
                        //general throw message for bad data, usually Nomajor with a major declared
                        catch (BadDataException exception)
                        {
                            JOptionPane.showMessageDialog(null, "Bad data at line " + lineNumber+ ": " + exception.getMessage());
                        }
                        //declared part time or full time and didn't give a major(assumed by length not long enough)
                        catch (ArrayIndexOutOfBoundsException exception){
                            JOptionPane.showMessageDialog(null, "Error at line " + lineNumber +  ": Part Time and Full Time students must have a major.");
                        }
                        //Balance is not a number (assumed since the length is correct and couldn't turn their number into a float
                        catch (NumberFormatException exception){
                            JOptionPane.showMessageDialog(null, "Error at line " + lineNumber +  ": Balance must be a number.");
                        }
                        //Anthing else, not sure what happened :(
                        catch (Exception exception)
                        {
                            JOptionPane.showMessageDialog(null, "Error at line " + lineNumber + ": " + exception.getMessage());
                        }
                    //increase the line number we are at
                        lineNumber++;
                    }
                    //close file
                    input.close();
                }
                //if there's an exception with opening the file
                catch (FileNotFoundException exception)
                {
                    JOptionPane.showMessageDialog(null, "File not Found.");
                }
                 // don't need this but if other exception occurs   
                catch (Exception exception)
                {
                    JOptionPane.showMessageDialog(null, exception.getMessage());
                }
                
                JOptionPane.showMessageDialog(null, "Finished adding " + fileName + " to student database.");
            }
        }
    }
}
