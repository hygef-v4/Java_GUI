import org.w3c.dom.ls.LSOutput;

import java.util.HashSet;
import java.util.Scanner;

public class Student {
    private String firstName;
    private String lastName;
    private int gradeYear;
    private String studentID;
    private String courses = "";

    private int balance;
    private int tuitionBalance;
    private static int costOfCourse = 600;
    private static int id = 1000;
    private static int studentCount = 0;
    private final String [] Subjects = {"History 101", "Math 101", "English 101","Chemistry 101","CS 101"};

    // ensure do not enter duplicate courses
    private HashSet<String> enrolledCourses = new HashSet<>();

    // constructor to enter name and year
    public Student(){
        studentCount ++;
        System.out.println("Student #" + studentCount + ": ");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter student first name: ");
        this.firstName = scanner.nextLine();

        System.out.println("Enter student last name: ");
        this.lastName = scanner.nextLine();

        do{
            System.out.println("1 - Freshmen\n2 - Sophomore\n3 - Junior\n4 - Senior\n" +
                    "Enter student class level: ");
            this.gradeYear = scanner.nextInt();
            if (this.gradeYear < 1 || this.gradeYear > 4){
                System.out.println("Invalid choice !");
            }
        } while (this.gradeYear < 1 || this.gradeYear > 4);

        setStudentId();

        System.out.println(firstName + " " + lastName + " " + gradeYear + " " + studentID);

        setBalance();

    }

    // set balance
    private void setBalance() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your balance: ");
        this.balance = scanner.nextInt();
    }


    // 5 digits ID (start with grade)
    private void setStudentId(){
        id++;
        // grade level + id
        this.studentID =  gradeYear + "" + id;
        // convert to string
    }
    //enroll  courses
    public void enroll() {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter course to enroll (Q to quit): ");
            String course = scanner.nextLine().trim();

            if (course.equalsIgnoreCase("Q")) {
                break;
            }

            if (checkValidSubject(course)) {
                if(!enrolledCourses.contains(course)){
                    enrolledCourses.add(course);
                    courses += "\n" + course;
                    tuitionBalance += costOfCourse;
                    //System.out.println("Enrolled in: " + course);
                } else {
                    System.out.println("You are already enrolled in " + course);
                }

            } else {
                System.out.println("Invalid course. Please try again.");
            }
        }

        System.out.println("Enrolled in: " + courses);
        System.out.println("Tuition balance: $" + tuitionBalance);
    }
    // check valid subjects
    private  boolean checkValidSubject(String input){

        for (String subject : Subjects){
            if (input.equalsIgnoreCase(subject)){
                return true;
            }
        }

        return false;
    }
    //view balance
    public void viewBalance(){
        System.out.println("Your balance is: $" + tuitionBalance);
    }
    // pay tuition
    public  void payTuition(){
        Scanner scanner  = new Scanner(System.in);
        while (true){
            System.out.println("Do you want to pay tuition ? (Y or N)");
            char choice = scanner.next().charAt(0);
            if (choice == 'Y' || choice == 'y' ){
                // pay
                if (balance >= tuitionBalance){
                    balance -= tuitionBalance;
                    tuitionBalance = 0;
                    System.out.println("Tuition has been paid ! ");
                    System.out.println("Your current balance: " + balance);
                }
                else{
                    System.out.println("Your account does not have enough balance !");
                }
                break;
            }
            else if (choice == 'N' || choice == 'n'){
                System.out.println("Payment canceled ! ");
                break;
            }
            else {
                System.out.println("Invalid choice ! ");
            }
        }


    }
    public void chargeBalance(){
        Scanner scanner  = new Scanner(System.in);
        System.out.println("Enter the amount of money u want to recharge: ");
        int charge = scanner.nextInt();
        this.balance += charge;
    }

    // show function
    public String toString(){
        String courseList = tuitionBalance == 0 ? courses : "Tuition not paid, no courses to show.";
        return "Name: " + firstName + " " + lastName +
                "\nGrade level: " + gradeYear +
                "\nStudent ID: " + studentID +
                "\nCourses enrolled: " + courseList +
                "\nBalance: $" + balance;
    }

}
