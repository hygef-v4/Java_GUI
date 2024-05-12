import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private  String email;
    private String emailSuffix = ".gmail.com";
    private int mailboxCapacity = 15;
    private String alternativeEmail;
    //static to share for all objects created
    private static int memberCount = 0;


    private int passwordLength = 8;

    // Constructor to receive the first name and last name
    public Email (String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        memberCount ++;
        // call method asking for department
        this.department = setDepartment();

        //Call method return random password
        this.password = randomPassword(passwordLength);

        // generate email
        this.email = (firstName + "." + lastName + "@" + department + emailSuffix).toLowerCase();
        System.out.println("Your email: " + this.email);

    }
    // Ask for the department
    private String setDepartment(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the department\n1 for Sales\n2 for Development\n3 for Accounting\nelse for nothing\n");
        int choice = scanner.nextInt();

        //choose department
        switch (choice){
            case 1:
                return "sales";
            case 2:
                return "dev";
            case 3:
                return "acct";
            default: // return nothing
                return "";
        }
    }

    // Generate a random password
    private String randomPassword(int length){
        String passwordSet = "abcdefghijklmnopqrstuvwsyz0123456789!@#$%";
        char[] password = new char[length];

        for (int i = 0; i < length; i++){
            int rand_i = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand_i);
        }
        // change password array to string
        return (String.valueOf(password)).toUpperCase();
    }

    // Set the mail capacity
    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }

    // Set the alternative email
    public void setAlternativeEmail(String altEmail){
        this.alternativeEmail = altEmail;
    }


    // Change the password
    public void changePassword(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter new password: ");
        this.password = scanner.nextLine();
    }

    public int getMailboxCapacity() {return this.mailboxCapacity;}

    public String getAlternativeEmail() {return this.alternativeEmail;}

    public String getPassword() {return this.password;};

    public void showInfo() {
        System.out.println("#" + memberCount + " DISPLAY NAME: " + firstName + " | " + lastName
                + " | EMAIL: "  + email + " | MAILBOX CAPACITY: " +
                mailboxCapacity + "Gb");
    }

    public void showPassword() {
        System.out.println("Password: " + this.password);
    }
}
