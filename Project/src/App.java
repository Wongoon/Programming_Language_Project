import java.util.*;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        InternetCafe cafe = new InternetCafe();
        Print.ClearConsole();

        boolean running = true;
        while(running) {
            int choice = ChoiceMode(sc);
            Print.ClearConsole();
            switch (choice) {
                case 1:
                    cafe.LogIn(sc);
                    break;
                case 2:
                    cafe.Register(sc);
                    break;
                case 3:
                    running = false;
                    System.out.println("프로그램 종료");
                    break;
                default:
                    Print.ClearConsole();
                    System.out.println("다시 시도해주세요.");
                    break;
            }
        }

        sc.close();
    }

    public static int ChoiceMode(Scanner sc) { // 로그인, 회원가입 선택 메서드
        Print.print();
        System.out.println("모드를 선택하세요");
        System.out.println("1 : 로그인");
        System.out.println("2 : 회원가입");
        System.out.println("3 : 종료");
        Print.print();

        return sc.nextInt();
    }
}
