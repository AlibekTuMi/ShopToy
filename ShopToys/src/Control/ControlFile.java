package Control;

import java.util.Scanner;

import Process.ProcessFile;

public class ControlFile {
    private ProcessFile control;

    public ControlFile(ProcessFile control) {
        this.control = control;
    }

    public void run() {
        Command command = Command.ADD;
        boolean ver = true;
        System.out.println("\n" + 
                "Введите команду для дальнейших действий:\n" +
                "LIST - Посмотреть список игрушек\n" +
                "ADD - Добавить игрушку в магазин\n" +
                "RAFFLE - Разыграть игрушку\n" +
                "EXIT - Выход из программы");
        while (ver) {
            try (Scanner scanner = new Scanner(System.in)) {
                String choice = scanner.nextLine();
                try {
                    command = Command.valueOf(choice.toUpperCase());
                } catch (IllegalArgumentException e) {
                    System.out.println("Неверная команда, повторите ввод!");
                    run();

                }
                switch (command) {
                    case ADD:
                        control.addToy();
                        run();
                        break;

                    case LIST:
                        control.checkList();
                        run();
                        break;

                    case RAFFLE:
                        control.raffleToys();
                        run();
                        break;

                    case EXIT:
                        System.out.println("Программа закрывается!\nДо свидания!");
                        ver = false;
                        break;

                    default:
                        break;

                }
            } catch (Exception e) {
                System.out.println("Ошибка ввода!");
            }

        }
    }
}
