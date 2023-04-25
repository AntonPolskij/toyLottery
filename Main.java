import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Queue<Toy> ToysToWinQueue = new PriorityQueue<Toy>(dropFrequencyComparator);

        addNewToyToQueue(ToysToWinQueue, 1, "Конструктор", 1);
        addNewToyToQueue(ToysToWinQueue, 2, "Машинка", 2);
        addNewToyToQueue(ToysToWinQueue, 3, "Кукла", 1);
        giveOutAToy(ToysToWinQueue);
        System.out.println(ToysToWinQueue);
    }

    public static Comparator<Toy> dropFrequencyComparator = new Comparator<Toy>() {
        @Override
        public int compare(Toy o1, Toy o2) {
            return (int) (o2.getDropFrequency() - o1.getDropFrequency());
        }
    };

    private static void addNewToyToQueue(Queue<Toy> ToysToWinQueue, int id, String toyName, int quantity) {
        Random random = new Random();
        int dropFrequency = random.nextInt(100);
        ToysToWinQueue.add(new Toy(id, toyName, quantity, dropFrequency));
    }

    private static void giveOutAToy(Queue<Toy> ToysToWinQueue) {
        try {
            FileWriter fw = new FileWriter("C:\\Users\\polsk\\Desktop\\Git\\toyLottery\\resources\\Toys.txt");
            String text = ToysToWinQueue.poll().toString();
            fw.append(text);
            fw.append('\n');

            fw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}