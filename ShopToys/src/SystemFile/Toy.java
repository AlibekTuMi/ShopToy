package SystemFile;

public class Toy implements Comparable<Toy> {
    private String name;
    private int id;
    private int frequency;
    private static int count;
    static {
        count = 0;
    }

    /**
     * @param name      - название игрушки
     * @param id        - id игрушки
     * @param frequency - частота выпадения
     */
    public Toy(String name, int frequency) {
        this.name = name;
        count++;
        this.id = count;
        this.frequency = frequency;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    @Override
    public int compareTo(Toy o) {
        if (this.id < o.id) {
            return -1;
        } else if (this.id > o.id) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return name;
    }

}
