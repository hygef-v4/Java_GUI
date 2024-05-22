import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of students to enroll: ");
        int n = scanner.nextInt();

        Student[] students = new Student[n];
        for (int i = 0; i < n; i ++) {
            students[i] = new Student();
            students[i].enroll();
            students[i].viewBalance();
            students[i].payTuition();
        }

        for (Student student : students){
            System.out.println(student);
        }
    }
}