package emailapp;
import java.util.*;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private String alternateEmail;
    private int mailboxCapacity=500;
    private int defaultPasswordLength=10; 
    private String companySuffix = "company.com";

    // Constructor to receive the first name and last name
    public Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("Email Created: "+ this.firstName+" "+ this.lastName);
        // Call a method asking for the department  - return the department
        this.department = setDepartment();
        System.out.println("Department: "+ this.department);

        // Call a method that returns a random password
        this.password = randomPassword(defaultPasswordLength); 
        System.out.println("Your password is: "+ this.password);

        // Combine elements to generate email
        email = firstName.toLowerCase() + lastName.toLowerCase() +"@" + department +"."+ companySuffix;
        //System.out.println("your email is: "+ email);
    }

    // Ask for the department
    private String setDepartment(){
        System.out.println("NEW WORKER: "+firstName+"\nSELECT DEPARTMENT CODES: \n1 for Sales \n2 for Development \n3 for Accounting \n0 for none \nEnter the Department code: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if(depChoice == 1){return "sales";}
        else if(depChoice == 2){return "dev";}
        else if(depChoice == 3){return "acct";}
        else{ return "service";}
    }

    // Generate a random password
    private String randomPassword(int length){
        String passwordSet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
        char[] password = new char[length];
        for(int i=0;i<length;i++){
            int rand = (int) (Math.random()*passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    // Set the mailbox capacity
    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }

    // Set the alternate email
    public void setAlternateEmail(String altEmail){
        this.alternateEmail = altEmail;
    }

    // Change the password
    public void changePassword(String password){
        this.password = password;
    }

    public int getMailboxCapacity(){
        return mailboxCapacity;
    }
    public String getAlternateEmail(){
        return alternateEmail;
    }

    public String getPassword(){
        return password;
    }
    public String showInfo(){
        return "DISPLAY NAME: " + firstName+" "+lastName+
                "\nCOMPANY EMAIL: "+ email +
                "\nMAILBOX CAPACITY: "+  mailboxCapacity+"mb";
    }
}
