//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Email em1 = new Email("Hung", "Khuat");

        em1.showInfo();
        em1.showPassword();
        //em1.changePassword();
        //em1.showPassword();

        Email em2 = new Email("Akira", "Nguyen");
        em2.showInfo();
        em2.showPassword();
    }
}

