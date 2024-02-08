/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentrecords;
import java.util.*;
/**
 *
 * @author Mae
 */

public class Student {

    /**
     * enum student type
     */
    enum StudentType { 

        /**
         *students with no major
         */
        NoMajor, 

        /**
         * full time students 
         */
        FullTime, 

        /**
         * part time students
         */
        PartTime}
    
    /**
     *banner id to track unique student id
     */
    private static int nextAvailableBannerID = 0;
    
    /**
     *arraylist that stores all the students 
     */
    public static ArrayList<Student> students = new ArrayList<>();
    
    /**
     * student first name
     */
    String firstName;

    /**
     * student last name
     */
    String lastName;

    /**
     * student password
     */
    String password;

    /**
     * student email
     */
    String email;

    /**
     * student banner ID - ID number
     */
    int bannerId;

    /**
     * holds student type for selected enum
     */
    StudentType studentType;

    /**
     * student major
     */
    String major; 

    /**
     * student balance
     */
    float balance;
    
    /**
     * constructor with all options selected
     * @param f - first name
     * @param l - last name
     * @param p - password 
     * @param e - email
     * @param bId - banner ID
     * @param sT - student type
     * @param m - major
     * @param b - balance
     * @throws Exception - throws exception if "No Major" students have a major entered with their info
     */
    public Student (String f, String l, String p, String e, int bId, String sT, String m, float b) throws Exception
    {
        firstName = f;
        lastName = l;
        password = p;
        email = e;
        bannerId = bId;
        //converts input string into studentType object
        studentType = StudentType.valueOf(sT);
        major = m;
        balance = b;
        
        //checking if no major student has major declared
        if(studentType == StudentType.NoMajor)
        {
            if(major != null)
                throw new BadDataException("No Major students cannot have a declared major.");
        }
        
        //update the banner ID if they created a larger one than ours
        if(bannerId > nextAvailableBannerID){
            nextAvailableBannerID = bannerId;
        }
        //increases bannerID
        nextAvailableBannerID++;
    }
    
    /**
     * constructor for no major students. references the first constructor and calls "null" where major would be
     * @param f - first name
     * @param l - last name
     * @param p - password
     * @param e - email
     * @param bId - banner ID
     * @param sT - student type
     * @param b - balance
     * @throws Exception - catch-all for any exceptions
     */
    public Student(String f, String l, String p, String e, int bId, String sT, float b) throws Exception

    {
        this(f, l, p, e, bId, sT, null, b);
    }
    
    /**
     * creates email and banner ID
     * @param f - first name
     * @param l - last name
     * @param p - password
     * @param sT - student type
     * @param m - major
     * @param b - balance
     * @throws Exception
     */
    public Student(String f, String l, String p, String sT, String m, float b) throws Exception
    {
        //f.substring(0,1)+l+"@mcc.edu"; uses substring to make email first initial then adds last name + "@mcc.edu"
        //nextAvailableBannerID creates unique bannerID
        this(f, l, p, f.substring(0,1) + l + "@mcc.edu", nextAvailableBannerID, sT, m, b);
    }
    
    //getters
    /**
     * 
     * @return last name
     */
    public String getLastName(){ return lastName;}

    /**
     *
     * @return first name
     */
    public String getFirstName(){return firstName;}

    /**
     *
     * @return password
     */
    public String getPassword(){return password;}

    /**
     *
     * @return bannerID
     */
    public int getBannerId() {return bannerId;}

    /**
     *
     * @return email
     */
    public String getEmail() {return email;}

    /**
     *
     * @return student type
     */
    public StudentType getStudentType(){return studentType;}

    /**
     *
     * @return student type object as a string
     */
    public String getStudentTypeString(){return studentType.toString();}

    /**
     *
     * @return major
     */
    public String getMajor() {return major;}

    /**
     *
     * @return next available banner ID
     */
    public static int getNextAvailableBannerId() {return nextAvailableBannerID;}

    /**
     *
     * @return array list of students in the system
     */
    public static  ArrayList<Student> getStudents(){ return students;}
    
    //setters
    /**
     * sets email
     * @param e - email
     */
    public void setEmail(String e) {email = e;}
    
    /**
     * checks if students are the same by comparing banner ID
     * @param otherID - user entered banner ID
     * @return true or false
     */
    public boolean equals(int otherID)
    {
        //return if the banner IDs are equal
        return this.bannerId == otherID;
    }
    
    /**
     *add student to the array list
     * @param s - student
     */
    public static void addStudent(Student s)
    {
        students.add(s);
    }

    /**
     * sorts the array list by last name using lambda expressions
     */
    public static void sortStudents()
    {
       students.sort((a,b) -> a.lastName.compareTo(b.lastName));
    }
    
    /**
     * checks if password is valid. Valid passwords are 8-10 characters, 1 uppercase letter, 1 lowercase letter, and 1 digit
     * @param pass - password
     * @return true or false (good or bad password)
     */
    public static boolean validPassword (String pass)
    {
        //makes sure password is the correct length
        if(pass.length() >= 8 && pass.length() <= 10)
        {
            //counters for upper, lower, and digit cases
            int lower = 0;
            int upper = 0;
            int digit = 0;
            
            //goes through the string to see if lower, upper, or digit
            for (int i = 0; i < pass.length(); i++)
            {
                //checks if lowercase - compares to hex value of a and z characters
                if(pass.charAt(i) >= 'a' && pass.charAt(i) <= 'z')
                    lower++;
                //checks if uppercase - compares to hex value of A and Z characters
                if(pass.charAt(i) >= 'A' && pass.charAt(i) <= 'Z')
                    upper++;
                //checks if lower case - compares to hex value of 0 and 9 characters (NOT digit)
                if(pass.charAt(i) >= '0' && pass.charAt(i) <= '9')
                    digit++;
            }
            if(lower > 0 && upper > 0 && digit > 0)
            {
                //if all counters are at least 1 password is valid
                return true;
            }
        }
        //returns false if didn't pass the above checks    
        return false;
    }
    
    //toString method - does not include passwords

    /**
     *to string method for printing
     * @return string with or without major depending on the student
     */
    public String toString()
    {
        //format balance to $xx.xx
        String mybalance = String.format("$%.2f", balance);
        //if no major, return without major
        if(studentType == StudentType.NoMajor){
            return lastName + ", " + firstName + ", " + email + ", " + bannerId + ", " + studentType + ", " + mybalance;
        }
        //else return with major
        return lastName + ", " + firstName + ", " + email + ", " + bannerId + ", " + studentType + ",  " + major + ", " + mybalance;
    }
}
