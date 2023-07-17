package OOP3;
import java.util.*;


public class Container implements Iterable<Box>, Comparable<Container>{

    private int id;
    static int nextId=1;
    protected ArrayList<Box> boxesIn;

    protected Container(List<Box> boxes, int id) {
        this.boxesIn = new ArrayList<>(boxes);
        this.id = id;
    }
    protected Container(List<Box> boxes) {
        this(boxes, nextId++);
    }
    public Container() {
        this.boxesIn = new ArrayList<>();
    }
    public int getWeight() {
        return boxesIn.stream().mapToInt(Box::getWeight).sum();
    }
    public int getSize() {
        return boxesIn.size();
    }
    @Override
    public Iterator<Box> iterator() {
        return boxesIn.iterator();
    }
    @Override
    public int compareTo(Container o) {
        return Integer.compare(this.getWeight(), o.getWeight());
    }
    @Override
    public String toString() {
        return "Контейнер " + this.id +
                " {Общий вес: " + this.getWeight() +
                ", Общее количество: " + this.getSize() +
                ", Коробки "+ boxesIn + '}';
    }
}
