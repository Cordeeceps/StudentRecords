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
public class MainScreen extends JFrame {
    
    //create the things
    JButton uploadRecords, addNew, downloadStats, findStudent, exit;
    JLabel welcome;
    final String option1 = "1. Upload Student Records from File";
    final String option2 = "2. Add New Student";
    final String option3 = "3. Download Statistics";
    final String option4 = "4. Find Student";
    final String option5 = "5. Exit Program";
    
    /**
     * formats the main screen GUI
     */
    public MainScreen()
    {
        setTitle("MCC Student Record System");
        setSize(600, 600);
      
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buildPanel();
        setVisible(true);
    }
    
    /**
     * formats items inside the GUI window
     */
    public void buildPanel()
    {
        //create panels
        JPanel panel1 = new JPanel(); 
        JPanel panel2 = new JPanel(); 
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel();
        JPanel panel6 = new JPanel();
       
        
        //create layout
        setLayout(new GridLayout(6, 1));
        panel1.setBackground(Color.BLACK);
        panel2.setBackground(Color.BLACK);
        panel3.setBackground(Color.BLACK);
        panel4.setBackground(Color.BLACK);
        panel5.setBackground(Color.BLACK);
        panel6.setBackground(Color.BLACK);
        
        //creates button handler
        ButtonHandler b1 = new ButtonHandler();
        
        //create buttons
        uploadRecords = new JButton(option1);
        uploadRecords.addActionListener(b1);
        //button aesthetics
        uploadRecords.setBackground(Color.GRAY);
        uploadRecords.setForeground(Color.WHITE);
        
        addNew = new JButton(option2);
        addNew.addActionListener(b1);
        addNew.setBackground(Color.GRAY);
        addNew.setForeground(Color.WHITE);
        
        downloadStats = new JButton(option3);
        downloadStats.addActionListener(b1);
        downloadStats.setBackground(Color.GRAY);
        downloadStats.setForeground(Color.WHITE);
        
        findStudent = new JButton(option4);
        findStudent.addActionListener(b1);
        findStudent.setBackground(Color.GRAY);
        findStudent.setForeground(Color.WHITE);
        
        exit = new JButton(option5);
        exit.addActionListener(b1);
        exit.setBackground(Color.GRAY);
        exit.setForeground(Color.WHITE);
        
        //distance label
        welcome = new JLabel("Welcome to MCC’s Student Record System. Please choose from the following options:");
        welcome.setForeground(Color.WHITE);
        
        //add to panels in grid
        panel1.add(welcome);
        panel2.add(uploadRecords);
        panel3.add(addNew);
        panel4.add(downloadStats);
        panel5.add(findStudent);
        panel6.add(exit);
        
        //add the panel to the JFrame 
        this.add(panel1);
        this.add(panel2);
        this.add(panel3);
        this.add(panel4);
        this.add(panel5);
        this.add(panel6);
        
    }
    /**
     * runs code based on button input from the user. pops up new windows for each button that's clicked.
     */
    private class ButtonHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String cmd = e.getActionCommand();
            //debugging
            System.out.println(cmd);
            
            //makes the GUI work. pops up each screen in a new window if the button is clicked
            switch(cmd)
            {
                case option1: 
                    //opens upload student record screen
                    Screen1 screen1 = new Screen1();
                    break;
                case option2: 
                    //opens add new student screen
                    Screen2 screen2 = new Screen2();
                    break;
                case option3: 
                    //opens download statistics screen
                    Screen3 screen3 = new Screen3();
                    break;
                case option4: 
                    //opens find student screen
                    Screen4 screen4 = new Screen4();
                    break;
                case option5: 
                    //exits program
                    System.exit(0);
                    break;
                //this shouldn't happen. Would have to click on something that doesn't exist. :(
                default: 
                    break;
            }

        }
    }
}
