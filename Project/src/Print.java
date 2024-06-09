import java.io.IOException;

public class Print {
    public static void ClearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (IOException | InterruptedException ex) {
            System.out.println("콘솔을 클리어할 수 없습니다.");
        }
    }
    
    public static void print()
    {
        System.out.println();
        System.out.println("*------------------------------*------------------------------*");
        System.out.println();
    }
}
