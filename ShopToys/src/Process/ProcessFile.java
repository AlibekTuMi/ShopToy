package Process;

import java.util.Scanner;

import SystemFile.ShopToy;
import SystemFile.Toy;

public class ProcessFile {

    public void checkList() {
        if (ShopToy.getToys().isEmpty()) {
            System.out.println("В магазине нет игрушек!");
        } else {
            ShopToy.listToys();
        }
    }

    public void addToy() {
        String name = input("Введите название игрушки");
        int frequency = -1;
        ShopToy.addToys(new Toy(name, frequency(frequency)));
        System.out.println("Игрушка добавлена!");
    }

    public void raffleToys() {
        if (ShopToy.getToys().isEmpty()) {
            System.out.println("В магазине нет игрушек!");
        } else {
            ShopToy.listToys();
            String name = input("\nВведите название игрушки:");
            boolean findToy = false;
            for (Toy toy : ShopToy.getToys()) {
                if (toy.getName().equals(name)) {
                    findToy = true;
                    break;
                }
            }
            if (!findToy) {
                System.out.println("Игрушки с таким названием нет в магазине!");
            } else {
                ShopToy.raffleToys(name);
            }
        }
    }

    private static String input(String msg) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(msg);
        return scanner.nextLine();

    }

    private static int convert(String ver) {
        try {
            return Integer.parseInt(ver);
        } catch (Exception e) {
            return -1;
        }
    }

    private static int frequency(int frequency) {
        while (frequency <= 0 || frequency > 100) {
            try {
                frequency = convert(input("Введите вероятность выпадения игрушки от 1 до 100"));

            } catch (Exception e) {
                System.out.println("Некорректный ввод вероятности, повторите еще раз!");
                frequency(frequency);
            }
            if (frequency <= 0 || frequency > 100) {
                System.out.println("Некорректная вероятность, попробуйте ещё раз");
            }
        }
        return frequency;
    }
}
