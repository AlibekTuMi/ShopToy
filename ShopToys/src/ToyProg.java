import Control.ControlFile;
import Process.ProcessFile;

public class ToyProg {
    public static void main(String[] args) {
        System.out.println("Здравствуйте! Это приложение магазин игрушек.");
        ControlFile control = new ControlFile(new ProcessFile());
        control.run();
    }
}
