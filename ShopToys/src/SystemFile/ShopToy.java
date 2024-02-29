package SystemFile;

import java.util.PriorityQueue;
import java.util.Random;

public class ShopToy {
    private static PriorityQueue<Toy> toys;
    static {
        toys = new PriorityQueue<>();
    }

    public static void addToys(Toy toy) {
        toys.add(toy);
    }

    public static void listToys() {
        System.out.println("\nСписок игрушек:\n");
        int i = 1;
        for (Toy toy : toys) {
            System.out.printf("Игрушка №%s - %s\n", i, toy);
            i++;
        }
    }

    public static void raffleToys(String name) {
        Random random = new Random();
        int randomNum = random.nextInt(100) + 1;
        int frequencyYourToy = 0;
        for (Toy toy : toys) {
            if (toy.getName().equals(name)) {
                frequencyYourToy = toy.getFrequency();
            }
        }
        if (randomNum <= frequencyYourToy) {
            System.out.println("\nВы Выиграли эту игрушку !!!!!! ПОЗДРАВЛЯЮ!!!!!!!!");
        } else {
            System.out.println("\nИгрушка не выиграна(((... Может повезёт в следующий раз)");
        }
    }

    public static PriorityQueue<Toy> getToys() {
        return toys;
    }
}
